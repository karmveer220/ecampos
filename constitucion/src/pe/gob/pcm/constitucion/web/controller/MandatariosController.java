package pe.gob.pcm.constitucion.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.gob.pcm.constitucion.web.dao.ParametroDAO;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T032mandatario;
import pe.gob.pcm.constitucion.web.service.MandatarioService;
import pe.gob.pcm.constitucion.web.service.ParticipanteService;
import pe.gob.pcm.constitucion.web.util.ParametrosUtil;

@Controller
@Scope("session")
public class MandatariosController {

private static final Logger logger = Logger.getLogger(MandatariosController.class);
	
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private ParticipanteService participanteService;

	@Autowired
	private MandatarioService mandatarioService;
	
	@RequestMapping(value ="/mandatarios/nuevomandatario.htm",method = RequestMethod.GET)
    public String nuevomandatario(ModelMap model,HttpServletRequest request) {
		logger.debug("nuevo mandatario");
		model.put("mandatario", new T032mandatario());
        return "ManEditable";
    }
	
	@RequestMapping(value ="/mandatarios/editarMandatario.htm",method = RequestMethod.GET)
    public String editarMandatario(ModelMap model,HttpServletRequest request) {
		logger.debug("editar mandatario");
		Integer id = Integer.parseInt(request.getParameter("cod"));
		model.put("mandatario", mandatarioService.obtenerMandatario(id));
        return "ManEditable";
    }
	
	@RequestMapping(value ="/mandatarios/verMandatario.htm",method = RequestMethod.GET)
    public String verMandatario(ModelMap model,HttpServletRequest request) {
		logger.debug("ver mandatario");
		Integer id = Integer.parseInt(request.getParameter("cod"));
		model.put("mandatario", mandatarioService.obtenerMandatario(id));
        return "ManNoEditable";
    }
	
	@RequestMapping(value ="/mandatarios/registramandatario.htm",method = RequestMethod.POST)
    public String registramandatario(ModelMap model,HttpServletRequest request) {
		logger.debug("registra mandatario");
		model.put("lUsuarios", "aqui lista de usuarios");
        return "Participantes";
    }

	@RequestMapping(value ="/mandatarios/asignacargo.htm",method = RequestMethod.GET)
    public String asignacargo(ModelMap model,HttpServletRequest request) {
		logger.debug("asignacargo");
		T020tramite trm = (T020tramite)request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION);
		request.setAttribute("lCargos", parametroDAO.litarParametros(ParametrosUtil.TIPO_CARGOS, trm.getCodTipsoc() ));
		T032mandatario man = mandatarioService.obtenerMandatario( Integer.parseInt( request.getParameter("cod") ) );
		logger.debug("mandatario = "+man);
		request.setAttribute("manda", man );
        return "Cargos";
    }
	
	@RequestMapping(value ="/mandatarios/registraCargo.htm",method = RequestMethod.POST)
    public String registraCargo(ModelMap model,HttpServletRequest request) {
		logger.debug("registraCargo");
		Integer codman = Integer.parseInt( request.getParameter("codManda") );
		String codCargo = request.getParameter("cargo");
		logger.debug( codman + " = " + codCargo);
		mandatarioService.asignaCargoMandatario(codman,codCargo);
		T020tramite trm = (T020tramite)request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION);
		model.put("lmandatarios", mandatarioService.listarMandatarios( trm.getNumTramite()));
		return "Mandatarios";
    }
	
	@RequestMapping(value ="/mandatarios/seleccionasocio.htm",method = RequestMethod.GET)
    public String seleccionasocio(ModelMap model,HttpServletRequest request) {
		logger.debug("seleccionasocio");
		T020tramite trm = (T020tramite)request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION);
		model.put( "lparticipantes" , participanteService.listarPersonasNaturales( trm.getNumTramite() ) );
        return "SelectAccionistas";
    }
}
