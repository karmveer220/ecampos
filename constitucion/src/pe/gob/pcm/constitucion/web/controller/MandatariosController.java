package pe.gob.pcm.constitucion.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.gob.pcm.constitucion.web.model.T032mandatario;

@Controller
@Scope("session")
public class MandatariosController {

private static final Logger logger = Logger.getLogger(MandatariosController.class);
	
	@RequestMapping(value ="/mandatarios/nuevomandatario.htm",method = RequestMethod.GET)
    public String nuevomandatario(ModelMap model,HttpServletRequest request) {
		logger.debug("nuevo mandatario");
		model.put("mandatario", new T032mandatario());
        return "ManEditable";
    }
	
	@RequestMapping(value ="/mandatarios/registramandatario.htm",method = RequestMethod.POST)
    public String registramandatario(ModelMap model,HttpServletRequest request) {
		logger.debug("registra mandatario");
		model.put("lUsuarios", "aqui lista de usuarios");
        return "Participantes";
    }
	
}
