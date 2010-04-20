package org.cnl.digemin.service;


import gob.min.digemin.ejb.EjbDigeminLocal;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;
import gob.min.digemin.ejb.entitiesWeb.Simpasaporte1;

import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.DAO.impl.HibAudotoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.springframework.stereotype.Service;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
@Service
public class PasaporteService {
	
	private EjbDigeminLocal ejbDigeminLocal;	
    public void setEjbDigeminLocal(EjbDigeminLocal ejbDigeminLocal) {
    	System.out.println("------creado el EJB------");
		this.ejbDigeminLocal = ejbDigeminLocal;
	}

	private AuditoriaDAO auditoriaDAO;
    
    public PasaporteService()throws Exception{
    	auditoriaDAO = new HibAudotoriaDAO();
    }
    
    public List<Simpasaporte1> obtenerListaPasaportePorUidPersona(String uIdPErsona,BeanAuditoria auditoria,String idSession)throws Exception{
    	System.out.println("------obtenerListaPasaportePorUidPersona------");
 	BeanRequest request = new BeanRequest();
 	request.setUIdPersona(uIdPErsona);
 	request.setSIdSession(idSession);
    List<Simpasaporte1> lista = ejbDigeminLocal.PasaporteLeerPersona(request);
 
	 auditoria.setMetodo("obtenerListaPasaportePorUidPersona");
	 auditoria.setCampos("TABLA SimPasaporte / SimPasPeru uIdPErsona");
	 auditoria.setConsulta(uIdPErsona);
	 auditoria.setSistema("WS");
	 auditoriaDAO.grabaAuditoria(auditoria);
 
    System.out.println("Entregando lista de pasaportes.");
    return lista;
    }        
    
    public Simpasaporte1 PasaporteLeerNro(String numero,BeanAuditoria auditoria,String idSession)throws Exception{
        auditoria.setMetodo("PasaporteLeerNro");
        auditoria.setCampos("TABLA SimPasaporte / SimPasPeru numero");
        auditoria.setConsulta(numero);
        auditoria.setSistema("WS");
        auditoriaDAO.grabaAuditoria(auditoria);
        
    	System.out.println("------PasaporteLeerNro------");
     	BeanRequest request = new BeanRequest();
     	request.setSNumPasaporte(numero);
     	request.setSIdSession(idSession);
        Simpasaporte1 pasaporte = ejbDigeminLocal.PasaporteLeerNro(request);
   
        return pasaporte;
    }
  
}
