package pe.gob.mininter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String login() {
		return "/login";
    }
	
	@RequestMapping("/home.htm")
	public String inicio( ModelMap model , HttpServletRequest request ) throws UnknownHostException, MalformedURLException{
		logger.debug("primer metodo al que ingresa");
		LdapUserDetailsImpl u = (LdapUserDetailsImpl)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		
		//UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
		logger.debug("inicio");
		SiminMaestro usuario = (SiminMaestro) usuarioService.loadUserByUsername(u.getUsername());
		logger.debug("fin"+usuario.getSiminUnidadorganica1().getNunoDescripcion());
		logger.debug(usuario.getSiminUnidadorganica1().getNunoDescripcion());
		try {
			URL autoIP = new URL("http://testip.edpsciences.org/");
			BufferedReader in = new BufferedReader( new InputStreamReader(autoIP.openStream()));
			String ip_address = (in.readLine()).trim();
			InetAddress thisIp = InetAddress.getLocalHost(); 
			String  thisIpAddress = thisIp.getHostAddress().toString();
			usuario.setIpPublica(ip_address);
			usuario.setIpPrivada(thisIpAddress);
			logger.debug("IP Publico"+ip_address+"IP Privada"+thisIpAddress);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		request.getSession().setAttribute("usuario", usuario);
		request.setAttribute("lstSistemas", usuarioService.listarSistemas(u.getUsername()) );
		request.setAttribute("lcumpleanios", usuarioService.listarCumpleaniosMes( ) );
		return "home";
	}

	@RequestMapping("/infinst.htm")
    public String vision() {
		return "/infinst";
    }
	
	//eco
	@RequestMapping("/eco.htm")
    public String eco() {
		return "/eco";
    }	

	//cumple
	@RequestMapping("/cumple.htm")
	public String cumple( ModelMap model , HttpServletRequest request ){
	LdapUserDetailsImpl u = (LdapUserDetailsImpl)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());			
	request.setAttribute("lcumpleanios", usuarioService.listarCumpleaniosMes( ) );
	return "cumple";
	}
	
	//sistemas
	@RequestMapping("/sistemas.htm")
	public String sistemas( ModelMap model , HttpServletRequest request ){
	LdapUserDetailsImpl u = (LdapUserDetailsImpl)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());			
	request.setAttribute("lstSistemas", usuarioService.listarSistemas(u.getUsername()) );
	return "sistemas";
	}
	
	//soporte
	@RequestMapping("/soporte.htm")
    public String soporte() {
		return "/soporte";
    }
	
	//campañas
	@RequestMapping("/campanas.htm")
    public String campanas() {
		return "/campanas";
    }
	

	
		
	
	
}
