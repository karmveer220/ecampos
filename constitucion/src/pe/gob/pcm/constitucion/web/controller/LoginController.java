package pe.gob.pcm.constitucion.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value ="/login.htm",method = RequestMethod.GET)
    public String login(ModelMap model,HttpServletRequest request) {
		logger.debug("pantalla login");
		return "login";
    }
	
	
	@RequestMapping(value ="/home.htm",method = RequestMethod.GET)
    public String home(ModelMap model,HttpServletRequest request) {
		logger.debug("pantalla HOME");
		return "home";
    }
	
	
}
