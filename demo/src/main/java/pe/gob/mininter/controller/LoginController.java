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
		
		//String username = request.getParameter("id").trim();
		//no poner trim ya que si no llega el parametro id, devuelve null, y null.trim da nullpointerexception
		
		String username = request.getParameter("id");
		
		if(username != null){
			username = username.trim();//aqui si puedo hacer trim de forma segura
			System.out.println("intento de logueo = " +username);
			SiminMaestro usuario = (SiminMaestro) usuarioService.loadUserByUsername(username);	
				
			//InetAddress thisIp = InetAddress.getLocalHost();//no sirve de nada
			//thisIp.getHostAddress().toString(); --> trae la ip del servidor
			String  thisIpAddress =  request.getRemoteAddr(); //--> request.getRemoteAddr(); trae la ip de quien ha llamado a esta pagina 
			usuario.setIpPrivada(thisIpAddress);
			
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("lstSistemas", usuarioService.listarSistemas(username) );
			request.getSession().setAttribute("lcumpleanios", usuarioService.listarCumpleaniosMes("") );
			return "/home";	
		}else{
			//si es que no he podido obtener el username muestro pantalla de login
			model.put("msgError", "no se ha encontrado el parametro username");
			return "/login";
		}
    }
	
	@RequestMapping("/home.htm")
	public String inicio( ModelMap model , HttpServletRequest request ) throws UnknownHostException, MalformedURLException{
		logger.debug("primer metodo al que ingresa");
		request.getSession().getAttribute("usuario");
		return "/home";
	}	
	
}
