package pe.gob.mininter.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.mininter.entities.BReporteCas;
import pe.gob.mininter.entities.Marcacion;
import pe.gob.mininter.service.ReporteService;

@Controller
@Scope("session")
public class ReportesController {
	
	private static final Logger logger = Logger.getLogger(ReportesController.class);
	
	@Autowired
	private ReporteService reporteService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/rptcasboleta.htm")
	public String rptCASBoleta( HttpServletRequest request, HttpServletResponse response){
		
		//LdapUserDetailsImpl u = (LdapUserDetailsImpl)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		
		logger.debug("pinta algo"+request.getAttribute("año"));
		logger.debug("pinta algo"+request.getAttribute("mes"));
		
		
		
		String username = System.getProperty("user.name");
		String periodo = "2012";//request.getParameter("anio");
		String mes =   "03";//request.getParameter("meses");
		String dependencia = "OFITEL";//request.getParameter("dependenciaEmp");
		String nombres = username  ;//request.getParameter("nombresEmp");
		//String ue = request.getParameter("ue_id");
		
		try {
			
			ServletOutputStream ouputStream = response.getOutputStream();
			logger.debug(ouputStream.toString());
					
			List<BReporteCas> listaGeneral = reporteService.listarCasBoletas(periodo, mes, dependencia, nombres );
			request.getSession().setAttribute("listGeneral", 0);			
			Collection<BReporteCas> col  = new ArrayList<BReporteCas>();
			
        	for(int i=0;i<listaGeneral.size();i++){
            	BReporteCas bdo = listaGeneral.get(i);
            	col.add(bdo);
            }
            String reportName = request.getRealPath("/Reportes/rptCASBoletaEmp.jasper");
	        	        
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
		return null;
	}
	
	@RequestMapping("/rptasistencia.htm")
	public String rptReporteAsistenciaxEmpleado( HttpServletRequest request, HttpServletResponse response) {
	   	
   		ServletOutputStream ouputStream = null;
   		
   		try {

   			ouputStream = response.getOutputStream();
   			//LdapUserDetailsImpl u = (LdapUserDetailsImpl)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
   			
   			String username = System.getProperty("user.name");
   			String  FechaIni = "01/03/2012";//request.getParameter("fec_ini_asistencia");
			String  FechaFin = "31/03/2012";//request.getParameter("fec_fin_asistencia");
			
			logger.debug("FechaIni = "+FechaIni);
   			logger.debug("FechaFin = "+FechaFin);
   			
   			
   			
   			List<Marcacion> rptAsistencia = reporteService.obtenerAsistenciaxEmpleado(FechaIni, FechaFin, username );
   			
   			logger.debug(rptAsistencia.size());
   				
   			Collection<Marcacion> col  = new ArrayList<Marcacion>();
               for(int i=0;i<rptAsistencia.size();i++){
            	   Marcacion bdo = rptAsistencia.get(i);
               	col.add(bdo);            
               }

            String reportName = request.getRealPath("/Reportes/rptAsistenciaPorEmpleado.jasper");
            String ruta = request.getRealPath("/images/mi.gif");
   	        String ruta1 = request.getRealPath("/images/ofitel.gif");
   	        	        
   	        JRBeanCollectionDataSource dataSource;
   	        Map<String, Object> pars = new HashMap<String, Object>();
   	        

      			pars.put("ruta", ruta);
      			pars.put("ruta1", ruta1);	
      			pars.put("fecIni", FechaIni);
      		    pars.put("fecFin", FechaFin);
      			
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
