package pe.gob.pcm.constitucion.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
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
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;
import pe.gob.pcm.constitucion.web.service.ParticipanteService;
import pe.gob.pcm.constitucion.web.service.ValidacionService;
import pe.gob.pcm.constitucion.web.util.ParametrosUtil;

@Controller
@Scope("session")
public class ParticipantesController {

	private static final Logger logger = Logger.getLogger(ParticipantesController.class);
	
	@Autowired
	private ValidacionService validacionService;
	
	@Autowired
	private ParticipanteService participanteService;

	@Autowired
	private ParametroDAO parametroDAO;
	
	@RequestMapping(value ="/participantes/nuevopn.htm",method = RequestMethod.GET)
    public String nuevopn(ModelMap model,HttpServletRequest request) {
		logger.debug("nuevo participante natural");
		cargarListas(request, null, null );
		T020tramite trm = (T020tramite)request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION);
		request.setAttribute("lsParticipante", parametroDAO.litarParametros(ParametrosUtil.TIPO_PARTICIPANTE , trm.getCodTipsoc()  ));
		T025pernat per = new T025pernat();
		per.setIndAporte( trm.getIndAporte() + "" );
		model.put("persona", per );
        return "Naturales";
    }
	
	@RequestMapping(value ="/participantes/registrapn.htm",method = RequestMethod.POST)
    public String registrapn(@Valid T025pernat persona, BindingResult result, ModelMap model,HttpServletRequest request) {
		try {
			logger.debug("registra participante natural");
			logger.debug( persona.toString() );
			BeanValida b = validacionService.validaParticipantePn( persona );
			T020tramite trm = (T020tramite)request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION);
			persona.setT020tramite(trm);
			if(b.getResultado() == 0){
				participanteService.registrarPersonaNatural(persona);
				model.put( "lparticipantes" , participanteService.listarAccionistas( trm.getNumTramite() ));				
			}else{
				throw new Exception(b.getMensaje());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.put("persona", persona );
			cargarListas(request, null, null );
			return "Naturales";
		}
        return "Participantes";
    }
	
	@RequestMapping(value ="/participantes/editarParticipante.htm",method = RequestMethod.GET)
    public String editarParticipante(@RequestParam("codigo") String cod, ModelMap model,HttpServletRequest request) {
		logger.debug("nuevo participante editarParticipante");
		T020tramite trm = (T020tramite)request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION);
		request.setAttribute("lsParticipante", parametroDAO.litarParametros(ParametrosUtil.TIPO_PARTICIPANTE , trm.getCodTipsoc()  ));
		T025pernat per = participanteService.obtenerParticipantePn(cod);
		per = participanteService.completarParticipante(trm,per);
		model.put("persona", per );		
		cargarListas(request , per , null );
        return "Naturales";
    }
	
	@RequestMapping(value ="/participantes/verParticipante.htm",method = RequestMethod.GET)
    public String verParticipante(@RequestParam("codigo") String cod, ModelMap model,HttpServletRequest request) {
		logger.debug("ver participante editarParticipante");
		T020tramite trm = (T020tramite)request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION);
		T025pernat per = participanteService.obtenerParticipantePn(cod);
		per = participanteService.completarParticipante(trm,per);
		per = participanteService.completarParticipanteVista(trm,per);
		model.put("persona", per );
        return "NaturalesEdit";
    }
	
	@RequestMapping(value ="/participantes/nuevopj.htm",method = RequestMethod.GET)
    public String nuevopj(ModelMap model,HttpServletRequest request) {
		logger.debug("nuevo participante juridico");
		cargarListas(request, null, null );		
		model.put("persona", new T026perjur() );
        return "Juridicas";
    }

	@RequestMapping(value ="/participantes/registrapj.htm",method = RequestMethod.POST)
    public String registrapj(@Valid T026perjur accionista, BindingResult result, ModelMap model,HttpServletRequest request) {
		try {
			logger.debug("registra participante juridico");
			BeanValida b = validacionService.validaParticipantePj( accionista );
			if(b.getResultado() == 0){
				T020tramite tramite = (T020tramite)(request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION));
				accionista.setT020tramite(tramite);
				participanteService.registrarPersonaJuridica(accionista);
				model.put( "lparticipantes" , participanteService.listarAccionistas( tramite.getNumTramite() ));
			}else{
				throw new Exception( b.getMensaje());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			cargarListas(request ,null, null);
			model.put("persona", accionista );
			return "Juridicas";
		}
        return "Participantes";
    }


	@SuppressWarnings("unused")
	private void cargarListas(HttpServletRequest request, T026perjur tramite) {
		cargarListas(request, null,null);
		if(tramite.getCodOficreg()!=null){
			request.getSession().setAttribute("lcombooficinas", parametroDAO.litarParametros(ParametrosUtil.OFICINA_REGISTRAL,tramite.getCodOficreg()));	
		}
	}

	private void cargarListas(HttpServletRequest request, T025pernat pn , T026perjur pj ) {
		request.setAttribute("lsDepartamentos", parametroDAO.litarParametrosDepartamentos());
		request.getSession().removeAttribute("lcomboprovincias");
		request.getSession().removeAttribute("lcomboDistritos");
		request.setAttribute("lsTipoSociedad", parametroDAO.litarParametros(ParametrosUtil.TIPO_SOCIEDAD));
		request.setAttribute("lsTipoAporte", parametroDAO.litarParametros(ParametrosUtil.TIPO_APORTE));
		request.setAttribute("lsZonaRegistral", parametroDAO.litarParametros(ParametrosUtil.ZONA_REGISTRAL));
		request.setAttribute("lsEstadoCivil", parametroDAO.litarParametros(ParametrosUtil.ESTADO_CIVIL));
		request.setAttribute("lsPersonaNatural", parametroDAO.litarParametros(ParametrosUtil.PERSONAS_NATURALES));
		T020tramite tramite = (T020tramite)(request.getSession().getAttribute(ConstitucionController.TRAMITE_SESSION));
		if(tramite != null) {
			request.setAttribute("lsParticipante", parametroDAO.litarParametros( ParametrosUtil.TIPO_PARTICIPANTE , tramite.getCodTipsoc()  ));
		}
		String ubig ="";
		if(pn != null ){
			if( StringUtils.isNotEmpty( pn.getCodUbigeo() )){
				ubig =pn.getCodUbigeo();
				String cod = ubig.substring(0,2);
				String cod2 = ubig.substring(2,4);
				request.getSession().setAttribute("lcomboprovincias", parametroDAO.litarParametrosProvincias(cod));
				request.getSession().setAttribute("lcomboDistritos", parametroDAO.litarParametrosdistritos(cod, cod2));	
			}	
		}
		
	}

}
