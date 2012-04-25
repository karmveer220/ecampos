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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.gob.mininter.entities.BReporteCas;
import pe.gob.mininter.entities.Marcacion;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.service.ReporteService;
import pe.gob.mininter.utiles.Utiles;

@Controller
@Scope("session")
public class ReportesController {
	
	private static final Logger logger = Logger.getLogger(ReportesController.class);
	
	@Autowired
	private ReporteService reporteService;
	
	@RequestMapping("/asistencia.htm")
	public String inicio( ModelMap model , HttpServletRequest request ){
		return "lstAsistencia";
	}	
	
	@RequestMapping("/boleta.htm")	
	public String sistema(ModelMap model , HttpServletRequest request ){
		request.getSession().getAttribute("usuario");
		return "/lstBoleta";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/rptcasboleta.htm")
	public String rptCASBoleta( HttpServletRequest request, HttpServletResponse response){
		
		SiminMaestro maestro = (SiminMaestro) request.getSession().getAttribute("usuario");
		
		Calendar hoy = new GregorianCalendar();
		String mes, año = "";
		
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
			
			ServletOutputStream ouputStream = response.getOutputStream();
			String reportName = "";
			Collection<BReporteCas> col  = new ArrayList<BReporteCas>();
			
			if (maestro.getCtingCodigo().equals("5") || maestro.getCtingCodigo().equals("7")) {
				List<BReporteCas> listaGeneral = reporteService.listarCasBoletas(año, mes, "", maestro.getNmstLogin() );
	        	for(int i=0;i<listaGeneral.size();i++){
	            	BReporteCas bdo = listaGeneral.get(i);
	            	col.add(bdo);
	            }
	        	reportName = request.getRealPath("/Reportes/rptCASBoletaEmp.jasper");
			}else {
				BReporteCas bdo = reporteService.listarBoletaNom(año, Integer.parseInt(mes)+"", maestro.getNmstLogin());
            	col.add(bdo);            	
            	reportName = request.getRealPath("/Reportes/rptNOMBoletaEmp.jasper");
			}
			
			JRBeanCollectionDataSource dataSource;
	        Map<String, Object> pars = new HashMap<String, Object>();
	        String ruta = request.getRealPath("/images/documento.jpg");
            pars.put("ruta", ruta);
   			
   			dataSource = new JRBeanCollectionDataSource(col);
	        logger.debug("datasource lleno con lista documento " + col.size());
	        File f = new File(reportName);
            byte[] bytes2 = JasperRunManager.runReportToPdf(f.getPath(),pars,dataSource);			
	        response.setContentType("application/pdf");
	        logger.debug("a"+ bytes2.length);
	        response.setContentLength(bytes2.length); 
	        ouputStream.write(bytes2, 0, bytes2.length);  
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgError", e.getMessage());
			logger.debug(e.getMessage());
		}
		return "/lstBoleta";
	}
	
	@RequestMapping("/rptasistencia.htm")
	public String rptReporteAsistenciaxEmpleado( HttpServletRequest request, HttpServletResponse response) {
	   	
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

			logger.debug(inicio+" "+fin);

			List<Marcacion> rptAsistencia = reporteService.obtenerAsistenciaxEmpleado(inicio, fin, maestro.getNmstLogin() );

			logger.debug(rptAsistencia.size());

			Collection<Marcacion> col  = new ArrayList<Marcacion>();

			for(int i=0;i<rptAsistencia.size();i++){
				Marcacion bdo = rptAsistencia.get(i);
				col.add(bdo);            
			}

			String reportName = "";
			if (rptAsistencia.size() == 0 ) {
				logger.debug("hola");
				reportName = request.getRealPath("/Reportes/rptAsistenciaPorEmpleadoNull.jasper");
			}else {
				logger.debug("haa");
				reportName = request.getRealPath("/Reportes/rptAsistenciaPorEmpleado.jasper");
			}

			String ruta = request.getRealPath("/images/mi.gif");
			String ruta1 = request.getRealPath("/images/ofitel.gif");

			JRBeanCollectionDataSource dataSource;
			Map<String, Object> pars = new HashMap<String, Object>();


			pars.put("ruta", ruta);
			pars.put("ruta1", ruta1);	
			pars.put("fecIni", inicio);
			pars.put("fecFin", fin);

			dataSource = new JRBeanCollectionDataSource(col);
			logger.debug("datasource lleno con lista documento " + col.size());
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
