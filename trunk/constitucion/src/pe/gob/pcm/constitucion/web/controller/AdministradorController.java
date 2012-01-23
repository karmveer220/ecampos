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
public class AdministradorController {

	private static final Logger logger = Logger.getLogger(AdministradorController.class);
	
	@RequestMapping(value ="/administracion/usuarios.htm",method = RequestMethod.GET)
    public String usuarios(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de usuarios");
		model.put("lUsuarios", "aqui lista de usuarios");
        return "admin/usuarios";
    }
	
	@RequestMapping(value ="/administracion/notarias.htm",method = RequestMethod.GET)
    public String notarias(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de notarias");
		model.put("lNotarias", "aqui lista de notarias");
        return "admin/notarias";
    }
	
}
