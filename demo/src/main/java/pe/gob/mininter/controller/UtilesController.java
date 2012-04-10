package pe.gob.mininter.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session") 
public class UtilesController {

	private static final Logger logger = Logger.getLogger(UtilesController.class);
	
	@RequestMapping("/boleta.htm")	
	public String sistema(ModelMap model , HttpServletRequest request ){
		String username = System.getProperty("user.name");
		request.getSession().setAttribute("username", username);
		
		logger.debug(username);
		
		
		return "/lstBoleta";
		
		
	}
}
