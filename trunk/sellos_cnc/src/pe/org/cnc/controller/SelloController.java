package pe.org.cnc.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SelloController {


	private static final Logger logger = Logger.getLogger(SelloController.class );
	
	@RequestMapping(value="/lSellos.htm", method=RequestMethod.GET)  
	 public String lista( ModelMap model ) {  
	   logger.debug("lista de sellos");
	   return "lsellos";  
	 } 
	
	@RequestMapping(value="/nSello.htm", method=RequestMethod.GET)  
	 public String nuevo( ModelMap model ) {  
	   logger.debug("nuevo sello");
	   return "nsello";  
	 } 
	
	//consultaSello1
	@RequestMapping(value="/consultaSello1", method=RequestMethod.POST)  
	 public String consultaSello1(HttpServletRequest request, HttpServletResponse  response,  ModelMap model ) {  
	   logger.debug("busco la info de??" +  request.getParameter("texto") );
	   PrintWriter out = null;
	   try {
		   out = response.getWriter();
		   out.println("el contenido corresponde a la notaria XXXXXXX " + request.getParameter("texto") );
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return null;  
	 } 
}
