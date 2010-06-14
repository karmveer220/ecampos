package org.cnl.digemin.service.impl;


import gob.min.digemin.ejb.BeanRequest;
import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.Simpasaporte1;
import gob.min.digemin.ejb.WsDigeminService;

import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.service.PasaporteService;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */

public class PasaporteServiceImpl implements PasaporteService {

	private WsDigeminService service;
	private AuditoriaDAO auditoriaDAO;
    public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
		this.auditoriaDAO = auditoriaDAO;
	}

	public PasaporteServiceImpl(){
		    	
    }
    
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.PasaporteService#obtenerListaPasaportePorUidPersona(java.lang.String, org.cnl.digemin.bean.BeanAuditoria, java.lang.String)
	 */
    public List<Simpasaporte1> obtenerListaPasaportePorUidPersona(String uIdPErsona,BeanAuditoria auditoria,String idSession)throws Exception{
    	
	service = new WsDigeminService();
	EjbDigeminWS port = service.getEjbDigeminWsPort();
 	BeanRequest request = new BeanRequest();
 	request.setUIdPersona(uIdPErsona);
 	request.setSIdSession(idSession);
    List<Simpasaporte1> lista = port.pasaporteLeerPersona(request);
 
	 auditoria.setMetodo("obtenerListaPasaportePorUidPersona");
	 auditoria.setCampos("TABLA SimPasaporte / SimPasPeru uIdPErsona");
	 auditoria.setConsulta(uIdPErsona);
	 auditoria.setSistema("WS");
	 auditoriaDAO.grabaAuditoria(auditoria);
 
    System.out.println("Entregando lista de pasaportes.");
    return lista;
    }        
    
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.PasaporteService#PasaporteLeerNro(java.lang.String, org.cnl.digemin.bean.BeanAuditoria, java.lang.String)
	 */
    public Simpasaporte1 PasaporteLeerNro(String numero,BeanAuditoria auditoria,String idSession)throws Exception{
        auditoria.setMetodo("PasaporteLeerNro");
        auditoria.setCampos("TABLA SimPasaporte / SimPasPeru numero");
        auditoria.setConsulta(numero);
        auditoria.setSistema("WS");
        auditoriaDAO.grabaAuditoria(auditoria);
        
        service = new WsDigeminService();
    	EjbDigeminWS port = service.getEjbDigeminWsPort();
     	BeanRequest request = new BeanRequest();
     	request.setSNumPasaporte(numero);
     	request.setSIdSession(idSession);
        Simpasaporte1 pasaporte = port.pasaporteLeerNro(request);
   
        return pasaporte;
    }
  
}
