package pe.gob.mininter.controller;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.service.UsuarioService;

@Controller
@Scope("session") 
public class LoginController  {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UsuarioService  usuarioService;
	
	@RequestMapping("/login.htm")
    public String login(ModelMap model , HttpServletRequest request) throws NumberFormatException, Exception {
		return "/login";
    }
	
	@RequestMapping("/home.htm")
	public String inicio( ModelMap model , HttpServletRequest request ) throws UnknownHostException, MalformedURLException{
		logger.debug("====================================================================");
		request.getSession().getAttribute("usuario");

		try {
			java.security.Principal principal = request.getUserPrincipal();
			String remoteUser = principal.getName();
			logger.debug("pintar "+remoteUser);
		    remoteUser = request.getRemoteUser();
		    logger.debug("pintar "+remoteUser);
			   
			LdapUserDetails u= (LdapUserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username=u.getUsername();
			SiminMaestro usuario = (SiminMaestro) usuarioService.loadUserByUsername(username);
			usuario.setIpPrivada(request.getRemoteHost());
							
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("lstSistemas", usuarioService.listarSistemas(username) );
			request.getSession().setAttribute("lcumpleanios", usuarioService.listarCumpleaniosMes("","", null) );
			return "/home";	
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/home";
	}	
	
}
