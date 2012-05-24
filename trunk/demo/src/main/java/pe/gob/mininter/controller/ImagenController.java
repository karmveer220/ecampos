package pe.gob.mininter.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.mininter.dao.ImagenDao;
import pe.gob.mininter.entities.SiminImagen;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller
@Scope("session")
public class ImagenController {

	private static final Logger logger = Logger.getLogger(ImagenController.class);
	
	@Autowired
	ImagenDao imagenDAO;
	
	@RequestMapping("/inicio.htm")
	public String jspImagenes( ModelMap model, HttpServletRequest request ){
		model.put("limagenes", imagenDAO.listarImagenes(0) );
		return "administrarImg";
	}
	
	@RequestMapping("/fotos.htm")
	public String insertarImg( ModelMap model, HttpServletRequest request ){
		return "administrarImg";
	}
	
	@RequestMapping("/menu.htm")
	public String verMenuSemanal( ModelMap model, HttpServletRequest request ){
		model.put("lmenu", imagenDAO.listarImagenCodigo("4") );
		return "menuSemanal";
	}
	
	@RequestMapping("/inicio2.htm")
	public String jspImagenes2( ModelMap model , HttpServletRequest request ){
		logger.debug("muestro jsp para cargar o ver imagenes");
		model.put("limagenes", imagenDAO.listarImagenes(0) );
		return "imagenes2";
	}
	
	@RequestMapping(value="/carga.htm")
	public String cargaImagenes( ModelMap model, HttpServletRequest request ){
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
		            long sizeInBytes = new Long(fi.getSize()) ;
		            SiminImagen im = new SiminImagen();
		            
		            if( fileName.lastIndexOf("\\") >= 0 ){
		               file = new File( filePath +  fileName.substring( fileName.lastIndexOf("\\"))) ;
		               im.setNaImgNombre( fileName.substring( fileName.lastIndexOf("\\")+1 ) );
		            }else{
		              file = new File( filePath +  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		              im.setNaImgNombre(fileName.substring(fileName.lastIndexOf("\\")+1));
		            }
		            im.setNaImgSize( new BigInteger( fi.getSize()+"" ) );
		            logger.debug(fi.getSize()+"");
		            
		            logger.debug(im.getNaImgSize()+"");
		            
		            im.setNaImgImagen( fi.get() );
		            imagenDAO.insertaImagen(im);
		            fi.write( file ) ;
		         }
		      }
	      }catch(Exception ex) {
	    	  ex.printStackTrace();
	          logger.debug(ex.getMessage());
	      }
		
	  	model.put("limagenes", imagenDAO.listarImagenes(4) );
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
		    SiminImagen im =  imagenDAO.obtenerImagen(id);		   
		   out.write( im.getNaImgImagen(), 0,  im.getNaImgImagen().length);
           out.flush();
           out.close();			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/pdf.htm")
	public String pdf( ModelMap model , HttpServletRequest request , HttpServletResponse response ){
		logger.debug("muestro jsp para cargar pdf");
		String id = request.getParameter("id");
		try {			
			response.reset(); 
			response.setContentType("application/pdf");
		    ServletOutputStream out = response.getOutputStream();
		    SiminImagen im =  imagenDAO.obtenerImagen(id);		   
		   out.write( im.getNaImgImagen(), 0,  im.getNaImgImagen().length);
           out.flush();
           out.close();			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/imgth.htm")
	public String imgth( ModelMap model , HttpServletRequest request , HttpServletResponse response ){
		logger.debug("muestro jsp para cargar o ver imagenes");
		String id = request.getParameter("id");
		int IMG_WIDTH = 100;
		int IMG_HEIGHT = 80;
		try {			
			response.reset(); 
			response.setContentType("image/jpeg");
		    ServletOutputStream out = response.getOutputStream();
		   SiminImagen im =  imagenDAO.obtenerImagen(id);
		   
		   ImageIcon imageIcon = new ImageIcon( im.getNaImgImagen() ); 
			
		   BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		   Graphics2D g = resizedImage.createGraphics();
		   g.drawImage(imageIcon.getImage(), 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		   g.dispose();
		   ByteArrayOutputStream encoderOutputStream = new ByteArrayOutputStream();
		   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(encoderOutputStream);
		   encoder.encode(resizedImage);
		   im.setNaImgImagen( encoderOutputStream.toByteArray() );
		   
		   out.write( im.getNaImgImagen(), 0,  im.getNaImgImagen().length);
           out.flush();
           out.close();			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/imgdw.htm")
	public String imgdw( ModelMap model , HttpServletRequest request , HttpServletResponse response ){
		logger.debug("muestro jsp para cargar o ver imagenes");
		String id = request.getParameter("id");
		try {			
			SiminImagen im =  imagenDAO.obtenerImagen(id);			
			response.reset(); 
			response.setContentType("image/jpeg");
			response.addHeader("Content-Disposition", "attachment;filename=\""+ im.getNaImgNombre() +"\"");
		    ServletOutputStream out = response.getOutputStream();		   
		   out.write( im.getNaImgImagen(), 0,  im.getNaImgImagen().length);
           out.flush();
           out.close();			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
