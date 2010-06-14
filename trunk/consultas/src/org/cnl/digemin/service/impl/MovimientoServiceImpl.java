package org.cnl.digemin.service.impl;

import gob.min.digemin.ejb.BeanRequest;
import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.Simmovmigra1;
import gob.min.digemin.ejb.WsDigeminService;

import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.service.MovimientoService;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */

public class MovimientoServiceImpl implements MovimientoService {

    private WsDigeminService service;    
    private AuditoriaDAO auditoriaDAO;    
    public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
		this.auditoriaDAO = auditoriaDAO;
	}

	public MovimientoServiceImpl(){
		
    }        
  
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.MovimientoService#listaDeMovimientosNumeroDocumento(java.lang.String, org.cnl.digemin.bean.BeanAuditoria, java.lang.String)
	 */
    public List<Simmovmigra1> listaDeMovimientosNumeroDocumento(String nroCarnetE,BeanAuditoria auditoria,String idSession)throws Exception{
        auditoria.setMetodo("listaDeMovimientosXCarnet");
        auditoria.setCampos("TABLA SimMovMigra nroCarnetE");
        auditoria.setConsulta(nroCarnetE);
        auditoria.setSistema("WS");
        auditoriaDAO.grabaAuditoria(auditoria);
        
        service = new WsDigeminService();
    	EjbDigeminWS port = service.getEjbDigeminWsPort();
    	BeanRequest request = new BeanRequest();
    	request.setSNumDocMovimiento(nroCarnetE);
    	request.setSIdSession(idSession);
        List<Simmovmigra1> lista = port.listaMovimientosXCarnet(request);
     
        return lista;
    }
}
