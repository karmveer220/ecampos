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
		String username = System.getProperty("user.name");
		SiminMaestro usuario = (SiminMaestro) usuarioService.loadUserByUsername(username);
		logger.debug("ingreso "+ usuario.getCTingCodigo()+" "+usuario.getSiminUnidadorganica1().getNUnoGeneralAbrev());
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
		request.getSession().setAttribute("lstSistemas", usuarioService.listarSistemas(username) );
		request.setAttribute("lcumpleanios", usuarioService.listarCumpleaniosMes("") );
		return "/home";
    }
	
	@RequestMapping("/home.htm")
	public String inicio( ModelMap model , HttpServletRequest request ) throws UnknownHostException, MalformedURLException{
		logger.debug("primer metodo al que ingresa");
		return "home";
	}	
	
}
