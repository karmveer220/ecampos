package pe.gob.pcm.constitucion.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.gob.pcm.constitucion.web.bean.BeanValida;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;
import pe.gob.pcm.constitucion.web.service.ValidacionService;

@Controller
@Scope("session")
public class ParticipantesController {

	private static final Logger logger = Logger.getLogger(ParticipantesController.class);
	
	@Autowired
	ValidacionService validacionService;
	
	@RequestMapping(value ="/participantes/nuevopn.htm",method = RequestMethod.GET)
    public String nuevopn(ModelMap model,HttpServletRequest request) {
		logger.debug("nuevo participante natural");
		model.put("persona", new T025pernat());
        return "Naturales";
    }
	
	@RequestMapping(value ="/participantes/registrapn.htm",method = RequestMethod.POST)
    public String registrapn(@Valid T025pernat persona, BindingResult result, ModelMap model,HttpServletRequest request) {
		try {
			logger.debug("registra participante natural");
			BeanValida b = validacionService.validaParticipantePn( persona );
			if(b.getResultado() == 0){
				//procedo a registrar participante
			}else{
				model.put("msgError", b.getMensaje() );
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
        return "Participantes";
    }
	
	@RequestMapping(value ="/participantes/nuevopj.htm",method = RequestMethod.GET)
    public String nuevopj(ModelMap model,HttpServletRequest request) {
		logger.debug("nuevo participante juridico");
		model.put("lUsuarios", "aqui lista de usuarios");
        return "Juridicas";
    }
	
	@RequestMapping(value ="/participantes/registrapj.htm",method = RequestMethod.POST)
    public String registrapj(ModelMap model,HttpServletRequest request) {
		try {
			logger.debug("registra participante juridico");
			BeanValida b = validacionService.validaParticipantePj( new T026perjur() );
			if(b.getResultado() == 0){
				//procedo a registrar participante
			}else{
				model.put("msgError", b.getMensaje() );
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
        return "Participantes";
    }
	
}
