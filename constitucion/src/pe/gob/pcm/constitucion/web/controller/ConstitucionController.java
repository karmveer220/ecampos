package pe.gob.pcm.constitucion.web.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
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
import pe.gob.pcm.constitucion.web.model.T029archivo;
import pe.gob.pcm.constitucion.web.model.T032mandatario;
import pe.gob.pcm.constitucion.web.model.Users;
import pe.gob.pcm.constitucion.web.service.MandatarioService;
import pe.gob.pcm.constitucion.web.service.NotariaService;
import pe.gob.pcm.constitucion.web.service.ParticipanteService;
import pe.gob.pcm.constitucion.web.service.TramiteService;
import pe.gob.pcm.constitucion.web.service.ValidacionService;
import pe.gob.pcm.constitucion.web.util.ParametrosUtil;


@Controller
@Scope("session")
public class ConstitucionController {

	private static final Logger logger = Logger.getLogger(ConstitucionController.class);
	public static String TRAMITE_SESSION = "tramitesistema";
	public static String TIPO_ARCHIVO_PARTE = "1";
	public static String TIPO_ARCHIVO_XML = "2";
	public static String TIPO_ARCHIVO_PDF = "3";
	
	@Autowired
	private ParametroDAO parametroDAO;

	@Autowired
	private ValidacionService validacionService;

	@Autowired
	private TramiteService tramiteService;
	
	@Autowired
	private NotariaService notariaService;
	
	@Autowired
	private ParticipanteService participanteService;

	@Autowired
	private MandatarioService mandatarioService;
	
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
		T020tramite tr = new T020tramite();
		tr.setIndEstado( "1" );
		model.put("lIncompletos",  tramiteService.listarTramites( tr ));
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
	
	@RequestMapping(value ="/constitucion/editarTramite.htm",method = RequestMethod.GET)
    public String editartramite(@RequestParam("codigo")  String id,  ModelMap model,HttpServletRequest request) {
		logger.debug("nuevoTramite");
		cargaCombos(request);
		T020tramite tr = tramiteService.obtenerTramite(id);
		model.put("tramite", tr );
		request.getSession().setAttribute("tramitesistema", tr );
        return "TramiteEditable";
    }
	
	@RequestMapping(value ="/constitucion/grabarTramite.htm",method = RequestMethod.POST)
    public String grabarTramite(@Valid T020tramite tramite, BindingResult result, ModelMap model,HttpServletRequest request) {
		logger.debug("grabo el tramite y muetro mensaje de exito, no avanzo a la siguiente pantalla");
		BeanValida val = validacionService.validaTramiteInicial(tramite);
		if(val.getResultado() == 0 ){
			tramite.setT021notaria( notariaService.obtenerNotaria( Users.getUsuarioBean().getCodNotaria() ) );
			tramite.setIndEstado("1");
			tramiteService.registrarTramite(tramite);
			request.getSession().setAttribute("tramitesistema", tramite);
		}else{
			request.setAttribute("msgError",val.getMensaje());
			return "TramiteEditable";
		}
		return "Participantes";
    }
	
	@RequestMapping(value ="/constitucion/regresaPasoUno.htm",method = RequestMethod.POST)
    public String regresaPasoUno(ModelMap model,HttpServletRequest request) {
		logger.debug("vuelvo al paso uno");
		T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
		cargaCombos(request);
		model.put("tramite", trm );
		return "TramiteEditable";
    }
	
	@RequestMapping(value ="/constitucion/tramitePasoDos.htm",method = RequestMethod.POST)
    public String tramitePasoDos(ModelMap model,HttpServletRequest request) {
		logger.debug("entro a paso do");
		T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
		model.put( "lparticipantes" , participanteService.listarAccionistas( trm.getNumTramite() ));
		return "Participantes";
    }
	
	@RequestMapping(value ="/constitucion/regresaPasoDos.htm",method = RequestMethod.POST)
    public String regresaPasoDos(ModelMap model,HttpServletRequest request) {
		logger.debug("vuelvo al paso dos");
		T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
		model.put( "lparticipantes" , participanteService.listarAccionistas( trm.getNumTramite() ));
		return "Participantes";
    }
	
	@RequestMapping(value ="/constitucion/tramitePasoTres.htm",method = RequestMethod.POST)
    public String tramitePasoTres(ModelMap model,HttpServletRequest request) {
		logger.debug("entro a paso tres, mandatarios y cargos");
		T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
		model.put("lmandatarios", mandatarioService.listarMandatarios( trm.getNumTramite()));
		return "Mandatarios";
    }
	
	@RequestMapping(value ="/constitucion/nmandatario.htm",method = RequestMethod.POST)
    public String nmandatario(ModelMap model,HttpServletRequest request) {
		logger.debug("mandatario nuevo");
		model.put("mandatario", new T032mandatario());
		return "ManEditable";
    }
	
	@RequestMapping(value ="/constitucion/registraMandatario.htm",method = RequestMethod.POST)
    public String registraMandatario(@Valid T032mandatario mandatario, BindingResult result,ModelMap model,HttpServletRequest request) {
		try {
			logger.debug("grabo al nuevo mandatario " + mandatario);
			T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
			mandatario.setT020tramite(trm);
			mandatarioService.registrarMandatario(mandatario);			
			model.put("lmandatarios", mandatarioService.listarMandatarios( trm.getNumTramite()));
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.put("msgError", e.getMessage());
			model.put("mandatario", mandatario);
			return "ManEditable";
		}		
		return "Mandatarios";
    }
	
	@RequestMapping(value ="/constitucion/regresaPasoTres.htm",method = RequestMethod.POST)
    public String regresaPasoTres(ModelMap model,HttpServletRequest request) {
		logger.debug("vuelvo al paso tres, madnatarios y cargos");
		return "Mandatarios";
    }
	
	@RequestMapping(value ="/constitucion/tramitePart.htm",method = RequestMethod.POST)
    public String tramitePart(ModelMap model,HttpServletRequest request) {
		logger.debug("entro a parte");
		T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
		model.put("archivoTramite", tramiteService.obtenerArchivo( trm.getNumTramite().toString(), TIPO_ARCHIVO_PARTE ));
		return "Parte";
    }
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value ="/constitucion/subirParte.htm",method = RequestMethod.POST)
    public String subirParte(ModelMap model,HttpServletRequest request) {
		logger.debug("grabo archivo en BD");
		
		T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
		T029archivo archivo = new T029archivo();
		archivo.setT020tramite(trm);
		
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(4 * 1024 * 1024);
        factory.setRepository(new File("D:\\"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax( 50 * 1024 * 1024);
        try{
               List fileItems = upload.parseRequest(request);                    
               Iterator i = fileItems.iterator();               
               while ( i.hasNext () ){
            	  FileItem fi = (FileItem)i.next();
                  if ( !fi.isFormField () ){
                	 String fileName = fi.getName();                                           
                     if( fileName.lastIndexOf("\\") >= 0 ){
                         archivo.setNomArchivo(fileName.substring( fileName.lastIndexOf("\\")+1 ) ); 
                     }else{
                         archivo.setNomArchivo(fileName.substring(fileName.lastIndexOf("\\")+1));
                     }
                     archivo.setArcContenido( fi.get() );
                     archivo.setIndTiparch(TIPO_ARCHIVO_PARTE);
                     tramiteService.registrarArchivo(archivo);
                     model.put("archivoTramite", archivo );
                  }
               }
       	}catch(Exception ex) {
           logger.debug(ex.getMessage());
        }       
		return "Parte";
    }
	
	@RequestMapping(value ="/constitucion/verParte.htm",method = RequestMethod.POST)
    public String verParte(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		 logger.debug("muestro jsp para cargar o ver imagenes");
         try {                   
             response.reset(); 
             response.setContentType("application/rtf");             
             ServletOutputStream out = response.getOutputStream();
             T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
             T029archivo archivo =  tramiteService.obtenerArchivo( trm.getNumTramite().toString() , TIPO_ARCHIVO_PARTE);
             response.addHeader("Content-Disposition", "attachment;filename=\""+ archivo.getNomArchivo() +"\"");
             out.write( archivo.getArcContenido() , 0,  archivo.getArcContenido().length);
             out.flush();
             out.close();                  
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
	}
	
	@RequestMapping(value ="/constitucion/borrarParte.htm",method = RequestMethod.POST)
    public String borrarParte(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		 logger.debug("muestro jsp para borrarParte");
         T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
         tramiteService.borrarParte( trm.getNumTramite() , TIPO_ARCHIVO_PARTE);
         return "Parte";
	}
	
	@RequestMapping(value ="/constitucion/grabarDerechos.htm",method = RequestMethod.POST)
    public String grabarDerechos(ModelMap model,HttpServletRequest request) {
		logger.debug("entro a grabar derechos ");
		String monto = request.getParameter("derechoRegistral");
		T020tramite trm = (T020tramite)request.getSession().getAttribute("tramitesistema");
		trm.setMtoDereregis( new BigDecimal( monto ));
		trm.setIndFormapago( request.getParameter("formaPago"));
		tramiteService.modificarTramite(trm);
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
