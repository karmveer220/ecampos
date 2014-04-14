package pe.org.cnc.controller;

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

@Controller
public class NotariosController {

	private static final Logger logger = Logger.getLogger(NotariosController.class );
	
	@Autowired
	private NotarioService notarioService;
	
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
		   texto.append("");
		   texto.append("/sellos/consulta?col=");
		   texto.append( notario.getIdnotario() );
		   
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
	
}
