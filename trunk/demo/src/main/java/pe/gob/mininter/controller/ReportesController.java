package pe.gob.mininter.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import pe.gob.mininter.entities.BReporteCas;
import pe.gob.mininter.entities.Marcacion;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.service.ReporteService;
import pe.gob.mininter.utiles.Mail;
import pe.gob.mininter.utiles.Utiles;

@Controller
@Scope("session")
public class ReportesController {
	
	private static final Logger logger = Logger.getLogger(ReportesController.class);
	
	@Autowired
	private ReporteService reporteService;
	
	@Autowired
	Mail mail;
	
	@RequestMapping("/asistencia.htm")
	public String inicio( ModelMap model , HttpServletRequest request ){
		return "lstAsistencia";
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
	
	private String pie = "<tr><td  align=\"center\"> <br/>******Este mensaje ha sido enviado desde una cuenta desatendida, por favor no responder a este correo****** </td></tr>";

	@RequestMapping("/boleta.htm")	
	public String sistema(ModelMap model , HttpServletRequest request ){
		SiminMaestro usuario =  (SiminMaestro) request.getSession().getAttribute("usuario");
	 
		StringBuffer mensaje = new StringBuffer();
		StringBuffer mensajeCabecera = new StringBuffer();

		mensajeCabecera.append(estilo);
		mensajeCabecera.append("<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"700px\" align=\"center\"> ");
		mensajeCabecera.append("<tr><td>");
		mensajeCabecera.append("Buenos d&iacute;as, se le informa que las siguientes discrepancias estan por vencer:<br>");
		mensajeCabecera.append("</td></tr>");
		mensajeCabecera.append("<tr><td>");
		mensajeCabecera.append("<table border='0' border='1' cellspacing='1' cellpadding='3' align='center'>");
		mensajeCabecera.append("<tr>");
		mensajeCabecera.append("<th>Oficina</th>");
		mensajeCabecera.append("<th>Detalle</th>");
		mensajeCabecera.append("<th>Observacion</th>");
		mensajeCabecera.append("<th>Vencimiento</th>");
		mensajeCabecera.append("</tr>");
		
		mensaje = new StringBuffer();
		mensaje.append( mensajeCabecera.toString() );
         
		logger.debug("funcion dia"+Utiles.obtenerDia());
		
		mensaje.append("<tr>");
		mensaje.append("<td>").append(""+ usuario.getSiminUnidadorganica1().getNunoDescripcion() ).append("</td>");
		mensaje.append("<td>").append(""+ usuario.getNombreCompleto() ).append("</td>");
		mensaje.append("<td>").append("Utiles.nullToBlank( dis.getObserv() )").append("</td>");
		mensaje.append("<td>").append(""+Utiles.obtenerDia()).append("</td>");
		mensaje.append("</tr>");
		
         
		mensaje.append("</table>");
		mensaje.append("</td></tr>");
		mensaje.append(pie);
		mensaje.append("</table>");
	    
		mail.sendMail("soporte@mininter.gob.pe", "menriquezo@mininter.gob.pe", "", "Soporte Tecnico", mensaje.toString());

		
		
		
		return "/lstBoleta";
	}
	
	@RequestMapping("/rptcasboleta.htm")
	public String rptCASBoleta( HttpServletRequest request, HttpServletResponse response){
		
		char sep = File.separatorChar;
		ServletOutputStream ouputStream = null;
		
		Calendar hoy = new GregorianCalendar();
		String mes, año = "";
		String reportName = "";
		
		año = Utiles.nullToBlank(request.getParameter("anio"));		
		mes = Utiles.nullToBlank(request.getParameter("mes"));
		
		if (año.equals("") || mes.equals("")) {			
			mes = Utiles.completarCero(hoy.get(Calendar.MONTH));
			año = hoy.get(Calendar.YEAR)+"";
		}else {
			año = Utiles.nullToBlank(request.getParameter("anio"));		
			mes = Utiles.completarCero(Integer.parseInt(request.getParameter("mes")));
		}
		
		try {
			SiminMaestro maestro = (SiminMaestro) request.getSession().getAttribute("usuario");
			
			ouputStream = response.getOutputStream();
			
			Collection<BReporteCas> col  = new ArrayList<BReporteCas>();
			
			if (maestro.getCtingCodigo().equals("5") || maestro.getCtingCodigo().equals("7")) {
				List<BReporteCas> listaGeneral = reporteService.listarCasBoletas(año, mes, "", maestro.getNmstLogin());
	        	for(int i=0;i<listaGeneral.size();i++){
	            	BReporteCas bdo = listaGeneral.get(i);
	            	col.add(bdo);
	            }
	        	reportName = request.getRealPath("Reportes"+sep+"rptCASBoletaEmp.jasper");
			}else {
				BReporteCas bdo = reporteService.listarBoletaNom(año, Integer.parseInt(mes)+"", maestro.getNmstLogin());
            	col.add(bdo);            	
            	reportName = request.getRealPath("Reportes"+sep+"rptNOMBoletaEmp.jasper");
			}
			String ruta = request.getRealPath("images"+sep+"documento.jpg");			
			logger.debug("ruta "+reportName);
			
			JRBeanCollectionDataSource dataSource;
	        Map<String, Object> pars = new HashMap<String, Object>();
	        
            pars.put("ruta", ruta);
   			
            dataSource = new JRBeanCollectionDataSource(col);			
			File f = new File(reportName);
			byte[] bytes2 = JasperRunManager.runReportToPdf(f.getPath(),pars,dataSource);			
			response.setContentType("application/pdf"); 
			response.setContentLength(bytes2.length);
			ouputStream.write(bytes2, 0, bytes2.length);
			ouputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgError", e.getMessage());
		} finally{
			if (ouputStream != null)  ouputStream = null;
		}
		return null;
	}
	
	@RequestMapping("/rptasistencia.htm")
	public String rptReporteAsistenciaxEmpleado( HttpServletRequest request, HttpServletResponse response) {
		char sep = File.separatorChar;
		ServletOutputStream ouputStream = null;
		try {
			SiminMaestro maestro = (SiminMaestro) request.getSession().getAttribute("usuario");

			ouputStream = response.getOutputStream();
			Calendar hoy = new GregorianCalendar();
			Calendar fecha = new GregorianCalendar();

			String inicio ="";
			String fin = "";
			String dia, mes, año = "";

			inicio =  Utiles.nullToBlank(request.getParameter("fechaInicio"));
			fin = Utiles.nullToBlank(request.getParameter("fechaFin"));

			if (inicio.equals("")) {
				mes = Utiles.completarCero(hoy.get(Calendar.MONTH));   				
				año = hoy.get(Calendar.YEAR)+"";
				String formatoFecha = Utiles.completarCero(hoy.get(Calendar.DAY_OF_MONTH))+"/"+Utiles.completarCero(Integer.parseInt(mes))+"/"+año;
				fecha = Utiles.stringToCalendar(formatoFecha, Utiles.FORMATO_FECHA_CORTA);
				dia = fecha.getActualMaximum(Calendar.DAY_OF_MONTH)+"";

				inicio = "01/"+mes+"/"+año;
				fin = dia+"/"+mes+"/"+año;

			}else {
				inicio= request.getParameter("fechaInicio");
				fin =   request.getParameter("fechaFin");
			}

			List<Marcacion> rptAsistencia = reporteService.obtenerAsistenciaxEmpleado(inicio, fin, maestro.getNmstLogin() );
			Collection<Marcacion> col  = new ArrayList<Marcacion>();

			for(int i=0;i<rptAsistencia.size();i++){
				Marcacion bdo = rptAsistencia.get(i);
				col.add(bdo);            
			}			
			
			String reportName = request.getRealPath("Reportes"+sep+"rptAsistenciaPorEmpleado.jasper");
			String ruta = request.getRealPath("images"+sep+"mi.gif");
			String ruta1 = request.getRealPath("images"+sep+"ofitel.gif");
			logger.debug("ruta "+reportName);
			
			JRBeanCollectionDataSource dataSource;
			Map<String, Object> pars = new HashMap<String, Object>();

			pars.put("ruta", ruta);
			pars.put("ruta1", ruta1);	
			pars.put("fecIni", inicio);
			pars.put("fecFin", fin);
			
			dataSource = new JRBeanCollectionDataSource(col);
			
			File f = new File(reportName);
			byte[] bytes2 = JasperRunManager.runReportToPdf(f.getPath(),pars,dataSource);			
			response.setContentType("application/pdf"); 
			response.setContentLength(bytes2.length);
			ouputStream.write(bytes2, 0, bytes2.length);
			ouputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgError", e.getMessage());

		} finally{
			if (ouputStream != null) {
				logger.debug("ouputStream.Close()");
				ouputStream = null;								
			}
		}
		return null;
   	}

	
}
