package pe.org.cnc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.org.cnc.model.Usuario;
import pe.org.cnc.service.UsuarioService;
import pe.org.cnc.util.Utiles;

@Controller
public class LoginController {


	private static final Logger logger = Logger.getLogger(LoginController.class );
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/login.htm")  
	 public String login() {  
	   logger.debug("pantalla de login");
	   return "login";  
	 }  

	@RequestMapping("/ingresar.htm")  
	 public String ingresar( HttpServletRequest request , ModelMap model) {  
	   logger.debug("ingreso al index");
	   
	   try {
		   Usuario usr = usuarioService.autenticarUsuario( request.getParameter("username") ,request.getParameter("password")    );
		   request.getSession().setAttribute("usrLogin", usr );
		   return "index";  
	   } catch (Exception e) {
			logger.error( e.getMessage() );
			model.put("msgError", e.getMessage() );
			return "login";  
	   }
	   
	 }  
	
	@RequestMapping("/index.htm")  
	 public String index() {  
	   logger.debug("ingreso al index");
	   return "index";  
	 }  
	

	
	@RequestMapping(value="recuperaClave.htm", method=RequestMethod.GET)
	public String preRecuperaClave(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		logger.debug("pantalla recuperar clave");
		try {
			response.setContentType("text/html;charset=ISO-8859-1");
	        request.setCharacterEncoding("UTF8");
		} catch (Exception e) {
			e.printStackTrace();
			model.put("msgError", e.getMessage());
		}
		logger.debug("return al inicio");
		return "includes/recupera_clave";
		
	}
	
	@RequestMapping(value="recuperaClave.htm", method=RequestMethod.POST)
	public String recuperaClave(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		logger.debug("procesa el recuperar clave");
		try {
			response.setContentType("text/html;charset=ISO-8859-1");
	        request.setCharacterEncoding("UTF8");
	        String usuario = Utiles.nullToBlank( request.getParameter("username") ).trim();
	        Usuario u = usuarioService.obtenerUsuarioPorUsername( usuario );
	        if(u== null ){
	        	throw new Exception("No se ha encontrado al usuario.");
	        }
	        if(  Utiles.nullToBlank( u.getEmail() ).equals("") ){
	        	throw new Exception("No tiene registrado su email, pongase en contacto con el Area de Tecnologia del CNL.");
	        }
	        String mail = u.getEmail();
	        u.setClave("" + new Date().getTime());	        
	        String msg = "Su nueva clave es: " + u.getClave();
	        logger.debug( msg );
	        usuarioService.registrarUsuario( u );
	       // mailService.sendMail("informatica@notarios.org.pe", mail, null, "Restablecimiento de clave", msg);
	        model.put("mail",  mail );
		} catch (Exception e) {
			e.printStackTrace();
			model.put("msgError", e.getMessage());
			return "includes/recupera_clave";
		}
		return "includes/recupera_clave_fin";
	}
	
	@RequestMapping(value="admin/prenuevoUsr.htm")
	public String preNuevoUsr(HttpServletRequest request, ModelMap model){
		try {
			logger.debug("admin/pre nuevo usuario");
			model.put("usuario", new Usuario() );
		} catch (Exception e) {
			e.printStackTrace();
			model.put("msgError", e.getMessage());
			return "mantenimiento/usuario_lista";
		}
		return "mantenimiento/usuario_registro";
	}

	@RequestMapping(value="admin/nuevoUsr.htm", method=RequestMethod.POST)
	public String nuevoUsr(@Valid Usuario usuario, BindingResult result,HttpServletRequest request, ModelMap model){
		try {
			logger.debug("log_admin/nuevaUsr");
			logger.debug( "estado = " + usuario.getEstado());
			usuarioService.registrarUsuario(usuario);			
			model.put("listPermisos",  usuarioService.listarPermisos());
			usuario.setlPermisos( usuarioService.obtenerPermisos( usuario.getUsername() ) );
			logger.debug( "lpermisos = " + usuario.getlPermisos().size() );
			model.put("usuario", usuario);
			String msg = "Usuario registrado."; 
			if( !Utiles.nullToBlank(usuario.getClaveNueva()).equals("") ){
				msg +=  " Se ha asignado la clave: " + usuario.getClaveNueva();
				StringBuilder mensaje = new StringBuilder();
			//	mensaje.append(" Buenos dias " + usuario.getNombreCompleto());
				mensaje.append("<p>");
				mensaje.append(" Se le ha asignado el usuario: " + usuario.getUsername() + ", <br>");
				mensaje.append(" se le ha asignado la clave: " + usuario.getClaveNueva()+ ". <br>");
				mensaje.append(" Para ingresar al sistema pulse sobre el siguiente enlace: http://190.216.169.23/sicnl/login.htm");
				mensaje.append("</p>");
				String[] para = {usuario.getEmail()};
				String[] cc = {};
				String[] bcc = {};
				//mail.sendMail( "informatica@notarios.org.pe", para , cc , bcc, "CNL - Datos de Acceso" , mensaje.toString() );
			}	 
			model.put("mensaje", msg);
		} catch (Exception e) {
			model.put("msgError", e.getMessage());
			model.put("usuario", usuario);
			return "mantenimiento/usuario_registro";
		}
		// REDIRECT A PAGINA DE PERMIOSOS
		return "mantenimiento/usuario_permisos";
	}
		

	@RequestMapping(value="admin/nuevoUsrPermisos.htm")
	public String nuevoUsrPermisos(@Valid Usuario usuario,BindingResult result,HttpServletRequest request,HttpServletResponse response, ModelMap model){
		try {
			usuarioService.registrarPermisos( usuario );
			
			response.setContentType("text/html;charset=ISO-8859-1");
	        request.setCharacterEncoding("UTF8");
			model.put("mensaje","Permiso registrado");
			model.put("usuario", new Usuario());
			model.put("lusuarios", usuarioService.listarUsuarios() );
		} catch (Exception e) {
			e.printStackTrace();
			model.put("msgError", e.getMessage());
			return "mantenimiento/usuario_permisos";
		}
		return "mantenimiento/usuario_lista";
	}

	@RequestMapping(value="admin/editarUsr.htm")
	public String editarUsr(HttpServletRequest request, ModelMap model){
		try {
			logger.debug("admin/editarUsr");
			
			model.put("usuario",  usuarioService.obtenerUsuario( Integer.parseInt(request.getParameter( "cod" ) )));
		} catch (Exception e) {
			model.put("msgError", e.getMessage());
			return "mantenimiento/usuario_lista";
		}
		return "mantenimiento/usuario_registro";
	}
	@RequestMapping(value="admin/eliminarUsr.htm")
	public String eliminarUsr(HttpServletRequest request, ModelMap model){
		try {
			logger.debug("log_admin/eliminarUsr");			
			usuarioService.eliminarUsuario( Integer.parseInt( request.getParameter("cod") ));
			model.put("lusuarios", usuarioService.listarUsuarios() );
			//model.put("lentidad", entidadService.listarEntidades( new Entidad() ));
			model.put("usuario", new Usuario());
		} catch (Exception e) {
			model.put("msgError", e.getMessage());
		}
		return "mantenimiento/usuario_lista";
	}
	
	//cambi ode copntrasenia

	@RequestMapping(value="admin/precpass.htm")
	public String precpass(HttpServletRequest request, ModelMap model){
		return "mantenimiento/usuario_clave";
	}
	
	@RequestMapping(value="admin/cpass.htm")
	public String cpass(HttpServletRequest request, ModelMap model){
		try {
			logger.debug(" cambiar clave ");
			String clave = request.getParameter("clave");
			String nueva = request.getParameter("nueva");
			String confirmar = request.getParameter("confirmar");
			Usuario u = usuarioService.obtenerUsuarioPorUsername( Usuario.getUsuarioBean().getUsername() );
			logger.debug( Utiles.hashMd5( clave ) );
			if(!u.getClave().equals( Utiles.hashMd5( clave ))){
				throw new Exception("Clave incorrecta");
			}
			if(!nueva.equals(confirmar)){
				throw new Exception("Nueva clave no coincide");
			}
			u.setClave(  nueva  );
			usuarioService.modificarClave(u);
			model.put("mensaje", "clave modificada");
		} catch (Exception e) {
			e.printStackTrace();
			model.put("msgError", e.getMessage());
			return "mantenimiento/usuario_clave";
		}
		return "inicio";
	}

	
	@RequestMapping(value="admin/precpassadm.htm")
	public String precpassadm(HttpServletRequest request, ModelMap model){
		try {
			logger.debug("admin/precpass");
			Integer id = Integer.parseInt( request.getParameter("cod"));
			model.put("usuario", usuarioService.obtenerUsuario( id ));
			
		} catch (Exception e) {
			model.put("msgError", e.getMessage());
			return "inicio";
		}
		return "mantenimiento/usuarioAdmin_clave";
	}
	
	@RequestMapping(value="admin/cpassadm.htm",method=RequestMethod.POST )
	public String cpassadm(@Valid Usuario usuario,BindingResult result,HttpServletRequest request, ModelMap model){
		try {
			String usr = "";//usuario.getIdusuario()+"";
			logger.debug("admin/cpassadm idUsr="  + usr);
			String nueva = request.getParameter("nueva");
			logger.debug( nueva );
			String confirmar = request.getParameter("confirmar");
			logger.debug( confirmar );
			Usuario u = usuarioService.obtenerUsuario( Integer.parseInt( usr ));			
			if(!nueva.equals(confirmar)){
				throw new Exception("Nueva clave no coincide");
			}
			u.setClave( ( nueva ) );
			usuarioService.modificarClave(u);
			model.put("mensaje", "Clave modificada");
		} catch (Exception e) {
			e.printStackTrace();
			model.put("usuario",  usuario );
			model.put("msgError", e.getMessage());		
		}
		return "mantenimiento/usuarioAdmin_clave";
	}
	
	
}
