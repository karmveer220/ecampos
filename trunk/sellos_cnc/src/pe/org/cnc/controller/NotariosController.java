package pe.org.cnc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.org.cnc.model.Notario;
import pe.org.cnc.service.NotarioService;
import pe.org.cnc.service.ParametroService;
import pe.org.cnc.util.Parametros;

@Controller
public class NotariosController {

	private static final Logger logger = Logger.getLogger(NotariosController.class );
	
	@Autowired
	private NotarioService notarioService;
	
	@Autowired
	private ParametroService parametroService;
	
	@RequestMapping(value="/lnotarios.htm", method=RequestMethod.GET)  
	 public String lista(HttpServletRequest request , ModelMap model ) {
	   logger.debug("lista de Notarios");
	   request.setAttribute("lNotarios", notarioService.buscarNotario( null ));
	   return "lnotarios";  
	 }
	
	@RequestMapping(value="/nnotario.htm", method=RequestMethod.GET)  
	 public String preNnotario(HttpServletRequest request , ModelMap model ) {
	   logger.debug("pre nuevo notario");
	   Notario not = new Notario();
	   not.setEstado( 1 );
	   model.put("notario", not );
	   return "nnotarios";  
	 }


	@RequestMapping(value="/nnotario.htm", method=RequestMethod.POST)  
	public String nNotario(@Valid Notario notario, BindingResult result, HttpServletRequest request , ModelMap model ) {
	   logger.debug("nuevo notario");
	  
	   try {		   
		   
		   //Generar texto para codigo de barras
		   StringBuilder texto = new StringBuilder();
		   texto.append( parametroService.obtenerParametro( Parametros.PARAM_URL ).getValor() );
		   texto.append( notario.getIdnotario() );
		   
		   notario.setTextosello( texto.toString() );
		   notario.setFechasello( new Date() );
		   
		   notarioService.registrarNotario(notario);		   
		   model.put("notario", new Notario());
		   request.setAttribute("lNotarios", notarioService.buscarNotario( null ));		   
		   model.put("mensaje", "Se ha grabado al notario con exito");		   
		   return "lnotarios";
	   } catch (Exception e) {
		   model.put("notario", notario);
		   model.put("msgError", "Error: no se pudo grabar la Notario. " +  e. getMessage());		   
		   return "nnotarios";
	   } 
	}
	
	@RequestMapping(value="/enotario.htm", method=RequestMethod.GET)  
	public String preeditar(HttpServletRequest request , ModelMap model ) {
	   logger.debug("pre editar notario");
	   model.put("notario", notarioService.obtenerNotario( Integer.parseInt( request.getParameter("codigo"))) );
	   return "nnotarios";  
	 }

	@RequestMapping(value="/dnotario.htm", method=RequestMethod.GET)  
	public String eliminar(HttpServletRequest request , ModelMap model ) {
	   logger.debug("eliminar notario");
	   notarioService.eliminarNotario( Integer.parseInt( request.getParameter("codigo")));
	   request.setAttribute("lNotarios", notarioService.buscarNotario( null ));
	   return "nnotarios";  
	 }
	
	/**
	 * link que se colocara en los sellos 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/ver.htm", method=RequestMethod.GET)  
	public String ver(HttpServletRequest request , ModelMap model ) {
	   logger.debug("ver info desde un codigo impreso");
	   
	   request.setAttribute("notario", notarioService.obtenerNotario( Integer.parseInt( request.getParameter("cod"))) );
	   
	   return "detalleNotario";  
	 }
	
}
