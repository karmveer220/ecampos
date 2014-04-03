package pe.org.cnc.controller;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.org.cnc.model.NotarioTO;
import com.barcode_coder.java_barcode.Barcode;
import com.barcode_coder.java_barcode.BarcodeDatamatrix;

@Controller
public class SelloController {


	private static final Logger logger = Logger.getLogger(SelloController.class );
	
	@RequestMapping(value="/lSellos.htm", method=RequestMethod.GET)  
	 public String lista(HttpServletRequest request , ModelMap model ) {
	   logger.debug("lista de sellos");
	   
	   List<NotarioTO> notarios = new ArrayList<NotarioTO>();
	   notarios.add( new NotarioTO( "HUBERT CAMACHO GALVEZ" , new Date()));
	   notarios.add( new NotarioTO( "ENRIQUE LANEGRA ARZOLA" , new Date()));
	   notarios.add( new NotarioTO( "EDWIN JACINTO RAMOS ZEA" , new Date()));
	   notarios.add( new NotarioTO( "DIEGO GONZALO GEREDA TORRES DE VIDAURRE" , new Date()));
	   
	   request.setAttribute("lSellos", notarios);
	   return "lsellos";  
	 }
	
	@RequestMapping(value="/lSellos.htm", method=RequestMethod.POST)  
	 public String busqueda(HttpServletRequest request , ModelMap model ) {
	   logger.debug("lista de sellos");
	   request.setAttribute("lSellos", null);
	   return "lsellos";  
	 }
	
	@RequestMapping(value="/nSello.htm", method=RequestMethod.GET)  
	 public String nuevo( HttpServletRequest request , ModelMap model ) {  
	   logger.debug("nuevo sello");
	   
	   List<NotarioTO> notarios = new ArrayList<NotarioTO>();
	   notarios.add( new NotarioTO( "HUBERT CAMACHO GALVEZ" , new Date()));
	   notarios.add( new NotarioTO( "ENRIQUE LANEGRA ARZOLA" , new Date()));
	   notarios.add( new NotarioTO( "EDWIN JACINTO RAMOS ZEA" , new Date()));
	   notarios.add( new NotarioTO( "DIEGO GONZALO GEREDA TORRES DE VIDAURRE" , new Date()));
	   
	   request.setAttribute("lSellos", notarios);
	   return "nsello";  
	 } 
	
	@RequestMapping(value="/nSello.htm", method=RequestMethod.POST)  
	 public String grabarSello( HttpServletRequest request ,ModelMap model ) {  
	   logger.debug("grabando sello sello");
	   request.setAttribute("lSellos", null);
	   return "lsellos";  
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
	
	@RequestMapping(value="/verSello", method=RequestMethod.GET)  
	 public String versello(HttpServletRequest request, HttpServletResponse  response,  ModelMap model ) {  
	   logger.debug("traer el ultimo sello del notario" +  request.getParameter("codigo") );
	   PrintWriter out = null;
	   try {
		   response.setContentType("text/html;charset=ISO-8859-1");
	       request.setCharacterEncoding("UTF8");	   
		   out = response.getWriter();
		   out.println("<img src='img/test.png' />");
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return null;  
	 }
	@RequestMapping(value="/sello", method=RequestMethod.GET)  
	public String sello(HttpServletRequest request, HttpServletResponse  response,  ModelMap model){

	       // System.out.println("obtengo mensaje y genero datamatrix");
	        String dm = request.getParameter("msg");
	        
	        //Barcode b = BarcodeFactory.createBarcode(BarcodeType.Datamatrix, dm );
	        Barcode b2 = new BarcodeDatamatrix(dm , false );
	        b2.export("png",5,20,false,"D:\\image.png");
	        
	        try {
	        	
	        	FileInputStream fs = new FileInputStream("D:\\image.png");
	        	byte[] bs = IOUtils.toByteArray(fs);
	        	
				response.reset();
				response.setContentType("image/png");
				//response.setHeader("content-disposition"," attachment;filename=imagen.png");
				response.setContentLength( bs.length );
				response.getOutputStream().write(bs);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			

			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	        return null;
	}
}
