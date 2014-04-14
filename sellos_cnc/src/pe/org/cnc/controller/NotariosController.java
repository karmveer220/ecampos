package pe.org.cnc.controller;

import java.util.ArrayList;
import java.util.List;

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
import pe.org.cnc.model.NotarioTO;
import pe.org.cnc.service.NotarioService;

@Controller
public class NotariosController {

	private static final Logger logger = Logger.getLogger(NotariosController.class );
	
	@Autowired
	private NotarioService notarioService;
	
	@RequestMapping(value="/lnotarios.htm", method=RequestMethod.GET)  
	 public String lista(HttpServletRequest request , ModelMap model ) {
	   logger.debug("lista de Notarios");
	   
	   List<NotarioTO> lista = new ArrayList<NotarioTO>();
	   lista.add( new NotarioTO(1,"RAFAEL ENRIQUE RIVERO CASTILLO", "100" , null) );
	   lista.add( new NotarioTO(2,"PEDRO ALONSO NORIEGA ALTAMIRANO", "101" , null) );
	   lista.add( new NotarioTO(3,"MAXIMO LUIS VARGAS HORNES", "102" , null) );
	   lista.add( new NotarioTO(4,"LUIS FELIX CANALES NICHO", "103" , null) );
	   lista.add( new NotarioTO(5,"KATIUSKA YSABEL OTAYZA WUCHI", "104" , null) );
	   
	   request.setAttribute("lNotarios", lista);
	   return "lnotarios";  
	 }
	
	@RequestMapping(value="/nnotario.htm", method=RequestMethod.GET)  
	 public String preNnotario(HttpServletRequest request , ModelMap model ) {
	   logger.debug("pre nuevo notario");
	   model.put("notario", new Notario());
	   return "nnotarios";  
	 }


	@RequestMapping(value="/nnotario.htm", method=RequestMethod.POST)  
	public String nNotario(@Valid Notario notario, BindingResult result, HttpServletRequest request , ModelMap model ) {
	   logger.debug("nuevo notario");
	   notarioService.registrarNotario(notario);
	   
	   model.put("notario", new Notario());
	   try {
		
		   List<NotarioTO> lista = new ArrayList<NotarioTO>();
		   lista.add( new NotarioTO(1,"RAFAEL ENRIQUE RIVERO CASTILLO", "100" , null) );
		   lista.add( new NotarioTO(2,"PEDRO ALONSO NORIEGA ALTAMIRANO", "101" , null) );
		   lista.add( new NotarioTO(3,"MAXIMO LUIS VARGAS HORNES", "102" , null) );
		   lista.add( new NotarioTO(4,"LUIS FELIX CANALES NICHO", "103" , null) );
		   lista.add( new NotarioTO(5,"KATIUSKA YSABEL OTAYZA WUCHI", "104" , null) );
		   
		   request.setAttribute("lNotarios", lista);
		   
		   model.put("mensaje", "Se ha grabado al notario con exito");
		   
		   return "lnotarios";
	   } catch (Exception e) {
		   model.put("notario", notario);
		   return "nnotarios";
	   } 
	}
	
	@RequestMapping(value="/enotario.htm", method=RequestMethod.GET)  
	public String preeditar(HttpServletRequest request , ModelMap model ) {
	   logger.debug("pre editar notario");
	   model.put("notario", notarioService.obtenerNotario( Integer.parseInt( request.getParameter("codigo"))) );
	   return "nnotarios";  
	 }

	
}
