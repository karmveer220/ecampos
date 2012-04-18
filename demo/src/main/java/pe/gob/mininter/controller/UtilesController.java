package pe.gob.mininter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.gob.mininter.service.UsuarioService;
import pe.gob.mininter.utiles.Utiles;

@Controller
@Scope("session") 
public class UtilesController {
	
	private static final Logger logger = Logger.getLogger(UtilesController.class);
	
	@Autowired
	private UsuarioService  usuarioService;
	
	@RequestMapping("/menuSemanal.htm")
	 public String menuSemanal() {
		logger.debug("test");
		return "/menuSemanal";
	}
	
	@RequestMapping("/vision.htm")
	public String vision() {
		return "/vision";
	}
		
	@RequestMapping("/cap.htm")
	public String cap() {
		return "/cap";
	}
	
	@RequestMapping("/mof.htm")
	public String mof() {
		return "/mof";
	}	
	
	@RequestMapping("/rof.htm")
	public String rof() {
		return "/rof";
	}	
	
	@RequestMapping("/tupa.htm")
	public String tupa() {
		return "/tupa";
	}	
	
	@RequestMapping("/directivas.htm")
	public String directivas() {
		return "/directivas";
	}	
	
	@RequestMapping("/organigrama.htm")
	public String organigrama() {
		return "/organigrama";
	}	
	
	@RequestMapping("/procedimientos.htm")
	public String procedimientos() {
		return "/procedimientos";
	}
	
	@RequestMapping("/boletines.htm")
	public String boletines() {
		return "/boletines";
	}
	@RequestMapping("/marcoLegal.htm")
	public String marcoLegal() {
		return "/marcoLegal";
	}
	
	@RequestMapping("/campanas.htm")
	public String campanas() {
		return "/campanas";
	}
	
	@RequestMapping("/galeria.htm")
	public String galeria() {
		return "/galeria";
	}
	
	@RequestMapping("/fotos.htm")
	public String fotos() {
		return "/fotos";
	}
	
	@RequestMapping("/cumplemensual.htm")
	public String lstCumpleMensual(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		request.setAttribute("lcumpleaniosMensual", usuarioService.listarCumpleaniosMes("1") );
		return "/lstCumple";
	}
	
	@RequestMapping("/directorioTelf.htm")
	public String lstDirectorioTelf(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		String descripcion = "";
		String telefono = "";
		String anexo = "";
		
		descripcion = Utiles.nullToBlank(request.getParameter("ndirDescripcion"));		
		telefono = Utiles.nullToBlank(request.getParameter("ndirTelefono"));
		anexo = Utiles.nullToBlank(request.getParameter("ndirAnexo"));
		logger.debug("param "+descripcion+" "+telefono);
		
		
		request.setAttribute("ldirectorioTelf", usuarioService.listarDirectorioTelf(descripcion,telefono,anexo) );
		return "/lstDirectorioTelf";
	}
}
