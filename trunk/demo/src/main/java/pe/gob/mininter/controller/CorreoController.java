package pe.gob.mininter.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.gob.mininter.entities.SiminCorreo;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.service.UtilesService;
import pe.gob.mininter.utiles.Mail;
import pe.gob.mininter.utiles.Utiles;

@Controller
@Scope("session") 
public class CorreoController {
	
	private static final Logger logger = Logger.getLogger(CorreoController.class);
	
	@Autowired
	private UtilesService  utilesService;
	
	@Autowired
	Mail mail;
	
	@RequestMapping(value ="/correo.htm", method = RequestMethod.GET)
	public String preEnviarCorreo(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		SiminMaestro usuario =  (SiminMaestro)request.getSession().getAttribute("usuario");
		model.put("correo",new SiminCorreo());
		model.put("lstCorreos", utilesService.listarCorreos((int) usuario.getCperlCodigo()));
		return "/enviarCorreo";
	}

	@RequestMapping(value ="/listarCorreo.htm", method = RequestMethod.GET)
	public String listarCorreos(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=ISO-8859-1");
		request.setCharacterEncoding("UTF8");
		model.put("lstTotalCorreos", utilesService.listarCorreos(0));
		return "/lstCorreo";
	}
	
	@RequestMapping(value ="/editarCorreo.htm", method = RequestMethod.GET)
	public String editarCorreo(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=ISO-8859-1");
		request.setCharacterEncoding("UTF8");
		//model.put("lstTotalCorreos", utilesService.listarCorreos(0));
		return "/lstCorreo";
	}

	
	
	@RequestMapping(value ="/enviarCorreo.htm", method = RequestMethod.POST)
	public String enviarCorreo(@Valid SiminCorreo correo, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		//Variables para insertar en el Correo Electronico
		SiminMaestro usuario =  (SiminMaestro) request.getSession().getAttribute("usuario");
		String nroPiso = request.getParameter("naMailPiso");
		String nroCelular = request.getParameter("nroCelular");
		String observacion = request.getParameter("naMailRequerimiento");
		
		//00100-2012
		
		model.put("correo",new SiminCorreo());
		correo.setFaMailEstado("1");
		correo.setDaMailFecha(new Date());
		usuario.setNmstEmail(request.getParameter("email"));
		utilesService.registrarCorreo(correo, usuario);
		
		model.put("lstCorreos", utilesService.listarCorreos((int) usuario.getCperlCodigo()));
		
		//Preparando la Cabecera para el envio del Correo Electronico
		StringBuffer mensajeCabecera = new StringBuffer();
		mensajeCabecera.append(estilo);
		
		mensajeCabecera.append("<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"700px\" align=\"left\"> ");
		mensajeCabecera.append("<tr><td>");
		mensajeCabecera.append("Buenos d&iacute;as, se le informa que las siguiente solicitud por atender:<br/>");
		mensajeCabecera.append("</td></tr>");
		mensajeCabecera.append("<tr><td>&nbsp;</td></tr>");
		mensajeCabecera.append("<tr><td>");
		
		mensajeCabecera.append("<table border='0' border='1' cellspacing='1' cellpadding='3' align='center'>");
		mensajeCabecera.append("<tr>");
		mensajeCabecera.append("<th>Dependencia</th>");
		mensajeCabecera.append("<th>Usuario</th>");
		mensajeCabecera.append("<th>Requerimiento</th>");
		mensajeCabecera.append("<th>Celular-Anexo</th>");
		mensajeCabecera.append("<th>Ubicaci&oacute;n</th>");
		mensajeCabecera.append("<th>Fecha del Requerimiento</th>");
		mensajeCabecera.append("</tr>");
		
		//Preparando el Body para el envio del Mensaje
		StringBuffer mensaje = new StringBuffer();
		mensaje.append( mensajeCabecera.toString() );
		mensaje.append("<tr>");
		mensaje.append("<td>").append(usuario.getSiminUnidadorganica1().getNunoDescripcion() ).append("</td>");
		mensaje.append("<td>").append(usuario.getNombreCompleto() ).append("</td>");
		mensaje.append("<td>").append(observacion).append("</td>");
		mensaje.append("<td>").append(nroCelular).append("</td>");
		mensaje.append("<td>").append(nroPiso).append("</td>");
		mensaje.append("<td>").append(Utiles.obtenerDia()).append("</td>");
		mensaje.append("</tr>");         
		mensaje.append("</table>");
		
		mensaje.append("</td></tr>");
		mensaje.append("<tr><td>&nbsp;</td></tr>");
		mensaje.append(pie);
		mensaje.append("</table>");
		
		mail.sendMail("soporte@mininter.gob.pe", "menriquezo@mininter.gob.pe", "merlyn.enriquez@gmail.com", "Soporte Tecnico", mensaje.toString());
		
		return "/enviarCorreo";
	}
	
	private String estilo = "<style type='text/css'> " +
            "body{background-color: #F9F9F9;} " +
            "table{font-size: 11px; font-family: arial;} " +
            "table th{font-size: 14px; background-color: #142733; color: #FFFFFF;} " +
            "table td{ background-color: #F9F9F9;} " +
            " " +
            "td.rojo{ background-color: #E60000;    }       " +
            "td.verde { background-color: #367D37;  }       " +
            "td.amarillo{ background-color: #FFF334;        color: #000;}" +
            " " +
            "table .tform{font-size: 11px; font-family: arial; background-color:#F9F9F9;}  " +
            ".tform th{font-size: 12px;  color: #993333; text-align:right; background-color: #F9F9F9;} " +
            ".tform td{ }  " +
            " " +
            "</style>";
	
	private String pie = "<tr><td  align=\"left\" style=\"text-align: justify;\"> <br/>" +
			"El sistema de correo electrónico del Ministerio del Interior está destinado únicamente " +
			"para fines del negocio, cualquier otro uso contraviene las políticas del Correo Eléctronico." +
			"Toda la información del negocio contenida en este mensaje es confidencial y de uso exclusivo" +
			" del Ministerio del Interior. Su divulgación, copia y/o adulteración están" +
			"prohibidas y sólo debe ser conocida por la persona a quien se dirige este mensaje." +
			" Si Ud. ha recibido este mensaje por error por favor proceda a eliminarlo y notificar al remitente.</td></tr>";
	
}

