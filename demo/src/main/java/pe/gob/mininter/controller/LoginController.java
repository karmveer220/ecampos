package pe.gob.mininter.controller;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
		String username = request.getParameter("id").trim();
		SiminMaestro usuario = (SiminMaestro) usuarioService.loadUserByUsername(username);	
			
		InetAddress thisIp = InetAddress.getLocalHost();
		String  thisIpAddress = thisIp.getHostAddress().toString();
		usuario.setIpPrivada(thisIpAddress);
		
		request.getSession().setAttribute("usuario", usuario);
		request.getSession().setAttribute("lstSistemas", usuarioService.listarSistemas(username) );
		request.getSession().setAttribute("lcumpleanios", usuarioService.listarCumpleaniosMes("") );
		return "/home";
    }
	
	@RequestMapping("/home.htm")
	public String inicio( ModelMap model , HttpServletRequest request ) throws UnknownHostException, MalformedURLException{
		logger.debug("primer metodo al que ingresa");
		request.getSession().getAttribute("usuario");
		return "/home";
	}	
	
}
