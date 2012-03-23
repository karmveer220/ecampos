package pe.gob.mininter.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.mininter.service.UsuarioService;

@Controller
@Scope("session") 
public class LoginController  {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UsuarioService  usuarioService;
	
	@RequestMapping("/login.htm")
    public String login() {
		return "/login";
    }
	
	@RequestMapping("/home.htm")
	public String inicio( ModelMap model , HttpServletRequest request ){
		logger.debug("primer metodo al que ingresa");
		//model.put("limagenes", "" );
		
		LdapUserDetailsImpl u = (LdapUserDetailsImpl)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		request.setAttribute("lstSistemas", usuarioService.listarSistemas(u.getUsername()) );
		request.setAttribute("lcumpleanios", usuarioService.listarCumpleaniosMes( ) );
		return "home";
	}
	
}
