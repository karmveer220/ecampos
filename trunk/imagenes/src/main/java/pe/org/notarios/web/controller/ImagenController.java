package pe.org.notarios.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.org.notarios.web.dao.ImagenDAO;
import pe.org.notarios.web.model.Imagenes;

@Controller
@Scope("session")
public class ImagenController {

	private static final Logger logger = Logger.getLogger(ImagenController.class);
	
	@Autowired
	ImagenDAO imagenDAO;
	
	@RequestMapping("/inicio.htm")
	public String jspImagenes( ModelMap model , HttpServletRequest request ){
		logger.debug("muestro jsp para cargar o ver imagenes");
		
		model.put("limagenes", imagenDAO.listarImagenes() );
		
		return "imagenes";
	}
	
	@RequestMapping(value="/carga.htm")
	public String cargaImagenes( ModelMap model  , HttpServletRequest request ){
		logger.debug("muestro jsp para inseertar imagenes");
		String filePath = "";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4 * 1024 * 1024);
		factory.setRepository(new File("D:\\"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax( 50 * 1024 * 1024);
	      File file = null;
	      try{
		      List fileItems = upload.parseRequest(request);			
		      Iterator i = fileItems.iterator();
		      
		      while ( i.hasNext () ){
		    	  FileItem fi = (FileItem)i.next();
		         if ( !fi.isFormField () ){
		           String fieldName = fi.getFieldName();
		            String fileName = fi.getName();
		            filePath = "D://demoupload//" ; 
		            String contentType = fi.getContentType();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            Imagenes im = new Imagenes();
		            
		            if( fileName.lastIndexOf("\\") >= 0 ){
		               file = new File( filePath +  fileName.substring( fileName.lastIndexOf("\\"))) ;
		               im.setNombre( fileName.substring( fileName.lastIndexOf("\\")+1 ) );
		            }else{
		              file = new File( filePath +  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		              im.setNombre(fileName.substring(fileName.lastIndexOf("\\")+1));
		            }
		            
		            
		            im.setImagen( fi.get() );
		           imagenDAO.insertaImagen(im);
		            fi.write( file ) ;
		         }
		      }
	      }catch(Exception ex) {
	          logger.debug(ex.getMessage());
	       }
	      
	
		
	  	model.put("limagenes", imagenDAO.listarImagenes() );
		
		return "imagenes";
	}
	
	
	@RequestMapping("/img.htm")
	public String img( ModelMap model , HttpServletRequest request , HttpServletResponse response ){
		logger.debug("muestro jsp para cargar o ver imagenes");
		String id = request.getParameter("id");
		try {
			
			response.reset(); 
			response.setContentType("image/jpeg");
		    ServletOutputStream out = response.getOutputStream();
		   Imagenes im =  imagenDAO.obtenerImagen(id);
		   
		   out.write( im.getImagen(), 0,  im.getImagen().length);
           out.flush();
           out.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		return null;
	}
	
}
