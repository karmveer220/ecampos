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
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.pcm.constitucion.web.bean.BeanValida;
import pe.gob.pcm.constitucion.web.dao.ParametroDAO;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T021notaria;
import pe.gob.pcm.constitucion.web.model.Users;
import pe.gob.pcm.constitucion.web.service.NotariaService;
import pe.gob.pcm.constitucion.web.service.TramiteService;
import pe.gob.pcm.constitucion.web.service.ValidacionService;
import pe.gob.pcm.constitucion.web.util.ParametrosUtil;


@Controller
@Scope("session")
public class ConstitucionController {

	private static final Logger logger = Logger.getLogger(ConstitucionController.class);
	
	@Autowired
	private ParametroDAO parametroDAO;

	@Autowired
	private ValidacionService validacionService;

	@Autowired
	private TramiteService tramiteService;
	
	@Autowired
	private NotariaService notariaService;
	
	@RequestMapping(value ="/constitucion/bandeja.htm",method = RequestMethod.GET)
    public String bandeja(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de bandejas");
		model.put("ltramites", "aqui lista de constituciones");
		model.put("tramite", new T020tramite() );
        return "BandejaEntrada";
    }
		
	@RequestMapping(value ="/constitucion/incompletos.htm",method = RequestMethod.GET)
    public String incompletos(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de incompletos");
		model.put("ltramites", "aqui lista de constituciones");
		model.put("tramite", new T020tramite() );
        return "Incompletos";
    }
	
	@RequestMapping(value ="/constitucion/pendientes.htm",method = RequestMethod.GET)
    public String pendiente(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de bandejas");
		model.put("ltramites", "aqui lista de constituciones");
		model.put("tramite", new T020tramite() );
        return "PendienteFirma";
    }
	
	@RequestMapping(value ="/constitucion/firmados.htm",method = RequestMethod.GET)
    public String firmados(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de Firmados");
		model.put("ltramites", "aqui lista de constituciones");
		model.put("tramite", new T020tramite() );
        return "Firmados";
    }
	
	@RequestMapping(value ="/constitucion/enviados.htm",method = RequestMethod.GET)
    public String enviados(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de enviados");
		model.put("ltramites", "aqui lista de constituciones");
		model.put("tramite", new T020tramite() );
        return "Enviados";
    }
	
	@RequestMapping(value ="/constitucion/eliminados.htm",method = RequestMethod.GET)
    public String eliminados(ModelMap model,HttpServletRequest request) {
		logger.debug("lista de eliminados");
		model.put("ltramites", "aqui lista de constituciones");
		model.put("tramite", new T020tramite() );
        return "Eliminados";
    }
		
	@RequestMapping(value ="/constitucion/nuevoTramite.htm",method = RequestMethod.POST)
    public String nuevotramite(ModelMap model,HttpServletRequest request) {
		logger.debug("nuevoTramite");
		cargaCombos(request);
		model.put("tramite", new T020tramite() );
        return "TramiteEditable";
    }
	
	
	@RequestMapping(value ="/constitucion/grabarTramite.htm",method = RequestMethod.POST)
    public String grabarTramite(@Valid T020tramite tramite, BindingResult result, ModelMap model,HttpServletRequest request) {
		logger.debug("grabo el tramite y muetro mensaje de exito, no avanzo a la siguiente pantalla");
		BeanValida val = validacionService.validaTramiteInicial(tramite);
		if(val.getResultado() == 0 ){
			tramite.setT021notaria( notariaService.obtenerNotaria( Users.getUsuarioBean().getCodNotaria() ) );
			tramiteService.registrarTramite(tramite);
			request.getSession().setAttribute("tramitesistema", tramite);
		}else{
			request.setAttribute("msgError",val.getMensaje());
		}
		return "Participantes";
    }
	
	
	@RequestMapping(value ="/constitucion/tramitePasoDos.htm",method = RequestMethod.POST)
    public String tramitePasoDos(ModelMap model,HttpServletRequest request) {
		logger.debug("entro a paso dos");
		return "Participantes";
    }
	
	@RequestMapping(value ="/constitucion/tramitePasoTres.htm",method = RequestMethod.POST)
    public String tramitePasoTres(ModelMap model,HttpServletRequest request) {
		logger.debug("entro a paso dos");
		return "Mandatarios";
    }
	
	@RequestMapping(value ="/constitucion/tramitePart.htm",method = RequestMethod.POST)
    public String tramitePart(ModelMap model,HttpServletRequest request) {
		logger.debug("entro a parte");
		return "Parte";
    }
	

	public void cargaCombos(HttpServletRequest request){
		request.setAttribute("lsTipoSociedad", parametroDAO.litarParametros(ParametrosUtil.TIPO_SOCIEDAD));
		request.setAttribute("lsZonaRegistral", parametroDAO.litarParametros(ParametrosUtil.ZONA_REGISTRAL));
		request.setAttribute("lsTipoAporte", parametroDAO.litarParametros(ParametrosUtil.TIPO_APORTE));
		request.setAttribute("lsDepartamentos", parametroDAO.litarParametrosDepartamentos());
	}
	
	
	@RequestMapping(value = "/*/comboficinaregistral.htm", method = RequestMethod.POST)
    public String comboficinaregistral(@RequestParam("cod") String cod,ModelMap model,HttpServletRequest request){
		logger.debug("cargar combo de comboficinaregistral");
		request.getSession().setAttribute("lcombooficinas", parametroDAO.litarParametros(ParametrosUtil.OFICINA_REGISTRAL,cod));
		return "ajax/cmbOficinas";
    }
	
	@RequestMapping(value = "/*/comboProvincias.htm", method = RequestMethod.POST)
    public String comboProvincias(@RequestParam("cod") String cod,ModelMap model,HttpServletRequest request){
		logger.debug("cargar combo de provincias");
		cod = cod.substring(0,2);
		logger.debug("cod = " + cod);
		request.getSession().setAttribute("lcomboprovincias", parametroDAO.litarParametrosProvincias(cod));
		return "ajax/cmbProv";
    }
}
