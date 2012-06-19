package pe.gob.mininter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sourceforge.ajaxtags.servlets.AjaxActionHelper;
import net.sourceforge.ajaxtags.servlets.BaseAjaxXmlAction;
import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder;

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
public class CorreoController implements BaseAjaxXmlAction {
	
	private static final Logger logger = Logger.getLogger(CorreoController.class);
	
	@Autowired
	private UtilesService  utilesService;
		
	@Autowired
	Mail mail;
	
	/**
	 * <property name="username" value="soporte" />	
	 * <property name="password" value="0f1t3L5t" />
	**/	
	
	@RequestMapping(value ="/correo.htm", method = RequestMethod.GET)
	public String preEnviarCorreo(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=ISO-8859-1");
			request.setCharacterEncoding("UTF8");
			SiminMaestro usuario =  (SiminMaestro)request.getSession().getAttribute("usuario");
			model.put("correo",new SiminCorreo());
			model.put("lstCorreos", utilesService.listarCorreos((int) usuario.getCperlCodigo()));
		} catch (Exception e) {
			logger.debug(e.getMessage());
            e.printStackTrace();
		}
		return "/enviarCorreo";
	}

	@RequestMapping(value ="/listarCorreo.htm", method = RequestMethod.GET)
	public String listarCorreos(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=ISO-8859-1");
		request.setCharacterEncoding("UTF8");
		logger.debug("listarCorreo");
		model.put("lstTotalCorreos", utilesService.listarCorreos(0));
		return "/lstCorreo";
	}
	
	@RequestMapping("/editarCorreo.htm")
	public String editarCorreo(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		logger.debug("llegaste a ajax"+request.getParameter("cod"));
		try {
            String xml = null;
            xml = AjaxActionHelper.invoke(this, (HttpServletRequest)request, (HttpServletResponse)response);
            PrintWriter pw = response.getWriter();
            pw.write(xml);
            pw.flush();
        } catch (Exception e) {
        	logger.debug(e.getMessage());
            e.printStackTrace();
        }
        return null;
	}
	
	@RequestMapping(value ="/enviarCorreo.htm", method = RequestMethod.POST)
	public String enviarCorreo(@Valid SiminCorreo correo, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			//Variables para insertar en el Correo Electronico
			SiminMaestro usuario =  (SiminMaestro) request.getSession().getAttribute("usuario");
			String nroPiso = request.getParameter("naMailPiso");
			String nroCelular = request.getParameter("naMailContacto");
			String observacion = request.getParameter("naMailRequerimiento");
			String email = request.getParameter("email");
			
			
			//00100-2012
			
			model.put("correo",new SiminCorreo());
			correo.setFaMailEstado("1");
			correo.setDaMailFecha(new Date());
			usuario.setNmstEmail(request.getParameter("email"));
			utilesService.registrarCorreo(correo, usuario);
			
			
			//Preparando la Cabecera para el envio del Correo Electronico
			StringBuffer mensajeCabecera = new StringBuffer();
			mensajeCabecera.append(estilo);
			
			mensajeCabecera.append("<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"700px\" align=\"left\"> ");
			mensajeCabecera.append("<tr><td>");
			mensajeCabecera.append("Estimado(a)<br/><br/>");
			mensajeCabecera.append("Se le informa que tiene la siguiente solicitud por atender:<br/>");
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
			//mensaje.append(atencion);
			mensaje.append(pie);
			mensaje.append("</table>");
			
			if (result.hasErrors()){
				return "/enviarCorreo";
			}
			
			
			mail.sendMail("info@mininter.gob.pe", "soporte@mininter.gob.pe", email, "Soporte Tecnico", mensaje.toString());
			//mail.sendMail("info@mininter.gob.pe", "menriquezo@mininter.gob.pe", email, "Requerimiento a Soporte Técnico y/o Desarrollo", mensaje.toString());
			model.put("lstCorreos", utilesService.listarCorreos((int) usuario.getCperlCodigo()));
			
			request.setAttribute("mensaje","El formulario ha sido enviado a Soporte Técnico.");
		} catch (Exception e) {
			model.put("msgError", e.getMessage());
		} finally {
			
		}
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
	
	private String atencion = "<tr><td  align=\"left\"> <br/>Este mensaje ha sido enviado desde una cuenta desatendida, por favor no responder a este correo</td></tr>";
	
	private String pie = "<tr><td  align=\"left\" style=\"text-align: justify;\"> <br/>" +
			"El sistema de correo electrónico del Ministerio del Interior está destinado únicamente " +
			"para fines del negocio, cualquier otro uso contraviene las políticas del Correo Eléctronico." +
			"Toda la información del negocio contenida en este mensaje es confidencial y de uso exclusivo " +
			"del Ministerio del Interior. Su divulgación, copia y/o adulteración están " +
			"prohibidas y sólo debe ser conocida por la persona a quien se dirige este mensaje. " +
			"Si Ud. ha recibido este mensaje por error por favor proceda a eliminarlo y notificar al remitente. " +
			"Este mensaje ha sido enviado desde una cuenta desatendida, por favor no responder a este correo</td></tr>";
	
	@Override
	public String getXmlContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer codCorreo = Integer.parseInt(request.getParameter("cod"));
		String param = request.getParameter("q");
    	if (param == null){
        	param = request.getParameter("value");
        	utilesService.actualizarCorreo(codCorreo, param);
            return request.getParameter("value");
        }
    	
        return new AjaxXmlBuilder().addItemAsCData("Callout Header", "<p>This is a test of the 'callout.view'</p><p>You asked about:<br/><b>" + param + "</b>.</p>").toString();
	}

	@Override
	public String getXMLEncoding() {
		return "UTF-8";
	}
	
}

