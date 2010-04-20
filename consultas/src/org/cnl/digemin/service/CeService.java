package org.cnl.digemin.service;

import gob.min.digemin.ejb.BeanRequest;
import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.Simcarnetextranjeria1;
import gob.min.digemin.ejb.WsDigeminService;

import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.DAO.impl.HibAudotoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class CeService {      
    
	WsDigeminService service;
    private AuditoriaDAO auditoriaDAO;
    
        public CeService()throws Exception{
           auditoriaDAO = new HibAudotoriaDAO();
        }        
      
     
        public List<Simcarnetextranjeria1> obtenerListaCeporUidPersona(String uIdPErsona,BeanAuditoria auditoria,String idSession)throws Exception{
                  
        	service = new WsDigeminService();
        	EjbDigeminWS port = service.getEjbDigeminWsPort();
        	BeanRequest request = new BeanRequest();
        	request.setUIdPersona(uIdPErsona);
        	request.setSIdSession(idSession);
        	List<Simcarnetextranjeria1> lista = port.carnetExtranjeriaLeerPersona(request);
        	
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
            
            service = new WsDigeminService();
        	EjbDigeminWS port = service.getEjbDigeminWsPort();
        	BeanRequest request = new BeanRequest();
        	request.setSNumCE(numero);
        	request.setSIdSession(idSession);
        	Simcarnetextranjeria1 carnet = port.carnetExtranjeriaLeerNro(request);
                     
            return carnet;
        }

}
