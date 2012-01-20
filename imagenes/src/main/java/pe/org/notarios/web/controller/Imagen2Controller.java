package pe.org.notarios.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
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
public class Imagen2Controller {

	private static final Logger logger = Logger.getLogger(Imagen2Controller.class);
	
	@Autowired
	ImagenDAO imagenDAO;
	
	@RequestMapping("/inicio2.htm")
	public String jspImagenes2( ModelMap model , HttpServletRequest request ){
		logger.debug("muestro jsp para cargar o ver imagenes");
		model.put("limagenes", imagenDAO.listarImagenes() );
		return "imagenes2";
	}
	
	
	
	@RequestMapping(value="/carga2.htm")
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
		            
		            im.setSize( new BigInteger( fi.getSize()+"" ) );
		            im.setImagen( fi.get() );
		            imagenDAO.insertaImagen(im);
		            fi.write( file ) ;
		         }
		      }
	      }catch(Exception ex) {
	          logger.debug(ex.getMessage());
	       }
	      
	
		
	  	model.put("limagenes", imagenDAO.listarImagenes() );
		
		return "res";
	}
	
}
