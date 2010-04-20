package org.cnl.digemin.service;

import gob.min.digemin.ejb.EjbDigeminLocal;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;
import gob.min.digemin.ejb.entitiesWeb.Simcarnetextranjeria1;

import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.DAO.impl.HibAudotoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.springframework.stereotype.Service;

/**
 * DIGEMIN
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Julio 2009
 * @version 1.0
 */
@Service
public class CeService {
	
	
	private EjbDigeminLocal ejbDigeminLocal;	
    public void setEjbDigeminLocal(EjbDigeminLocal ejbDigeminLocal) {
    	System.out.println("------creado el EJB------");
		this.ejbDigeminLocal = ejbDigeminLocal;
	}

	private AuditoriaDAO auditoriaDAO;
    
        public CeService()throws Exception{
           auditoriaDAO = new HibAudotoriaDAO();
        }        
      
     
        public List<Simcarnetextranjeria1> obtenerListaCeporUidPersona(String uIdPErsona,BeanAuditoria auditoria,String idSession)throws Exception{
            
        	BeanRequest request = new BeanRequest();
        	request.setUIdPersona(uIdPErsona);
        	request.setSIdSession(idSession);
        	List<Simcarnetextranjeria1> lista = ejbDigeminLocal.CarnetExtranjeriaLeerPersona(request);
        	
            auditoria.setMetodo("obtenerListaCeporUidPersona");
            auditoria.setCampos("TABLA SimCarnetExtranjeria uIdPErsona");
            auditoria.setConsulta(uIdPErsona);
            auditoria.setSistema("WS");
            auditoriaDAO.grabaAuditoria(auditoria);  
            
            return lista;
        }        
        
        public Simcarnetextranjeria1 CarnetExtranjeriaLeerNro(String numero,BeanAuditoria auditoria ,String idSession)throws Exception{
                        
            auditoria.setMetodo("CarnetExtranjeriaLeerNro");
            auditoria.setCampos("TABLA SimCarnetExtranjeria NroCarnet");
            auditoria.setConsulta(numero);
            auditoria.setSistema("WS");
            auditoriaDAO.grabaAuditoria(auditoria);
            
           
        	BeanRequest request = new BeanRequest();
        	request.setSNumCE(numero);
        	request.setSIdSession(idSession);
        	System.out.println("llamando al EJB!!!!");
        	Simcarnetextranjeria1 carnet = ejbDigeminLocal.CarnetExtranjeriaLeerNro(request);
                     
            return carnet;
        }

}
