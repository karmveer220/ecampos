package pe.org.cnc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.org.cnc.model.NotarioTO;

@Controller
public class NotariosController {

	private static final Logger logger = Logger.getLogger(NotariosController.class );
	
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

}
