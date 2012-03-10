package pe.gob.mininter.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session") 
public class LoginController  {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("/login.htm")
    public String login() {
		return "/login";
    }
	
	@RequestMapping("/inicio.htm")
	public String inicio( ModelMap model , HttpServletRequest request ){
		logger.debug("primer metodo al que ingresa");
		//model.put("limagenes", "" );
		return "home";
	}
	
}
