package org.cnl.digemin.service;

import gob.min.digemin.ejb.EjbDigeminLocal;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;
import gob.min.digemin.ejb.entitiesWeb.Simpersona1;

import java.util.List;

import org.apache.log4j.Logger;
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
public class PersonaService {
	
	Logger logger = Logger.getLogger(PersonaService.class);
	
	private EjbDigeminLocal ejbDigeminLocal;	
    public void setEjbDigeminLocal(EjbDigeminLocal ejbDigeminLocal) {
    	logger.debug("------creado el EJB------");
		this.ejbDigeminLocal = ejbDigeminLocal;
	}

	private AuditoriaDAO auditoriaDAO;
    
    public PersonaService()throws Exception{
    	auditoriaDAO = new HibAudotoriaDAO();
    }
    
    public List<Simpersona1> listaPersonas(String snombre, String spaterno,
    		String smaterno,boolean bPeruano, boolean coincidirAlFinal,
    		BeanAuditoria auditoria,String idSession) throws Exception {
            
    	logger.debug("------listaPersonas------");
    	gob.min.digemin.ejb.entitiesWeb.BeanRequest request = new gob.min.digemin.ejb.entitiesWeb.BeanRequest();
    	request.setSNombre(snombre);
    	request.setSApePaterno(spaterno);
    	request.setSApeMaterno(smaterno);
    	request.setBAproximado(coincidirAlFinal);
    	request.setBPeruano(bPeruano);
    	request.setSIdSession(idSession);
    	logger.debug("--- llamo al metodo autenticacion ---");
    	ejbDigeminLocal.autenticaSession("ecampos", "123456");
    	logger.debug("--- llamo a la lista sin recibirla en ningun bean ---");
    	ejbDigeminLocal.listaPersonaPorNombres((gob.min.digemin.ejb.entitiesWeb.BeanRequest)request);
    	logger.debug("--- Fin de llamada a lista sin recibirla ---");
    	logger.debug("--- llamo a la lista y la recibo en una lista ---");
    	List<Simpersona1> lista = ejbDigeminLocal.listaPersonaPorNombres(request);
    	
        auditoria.setMetodo("listaPersonas");
        auditoria.setCampos("TABLA Simpersona snombre spaterno smaterno bPeruano");
        auditoria.setConsulta(snombre +" / "+ spaterno + " / " +smaterno+" / "+bPeruano);
        auditoria.setSistema("WS");
        auditoriaDAO.grabaAuditoria(auditoria);
       
        return lista;                
    }
    
    public Simpersona1 obtenerDatosPersona(String uIdPErsona,BeanAuditoria auditoria,String idSession)throws Exception{
        
    	BeanRequest request = new BeanRequest();
    	request.setUIdPersona(uIdPErsona);
    	request.setSIdSession(idSession);
    	Simpersona1 persona = ejbDigeminLocal.PersonaLeer(request);

         auditoria.setMetodo("obtenerDatosPersona");
         auditoria.setCampos("TABLA Simpersona uIdPErsona");
         auditoria.setConsulta(uIdPErsona);
         auditoria.setSistema("WS");
         auditoriaDAO.grabaAuditoria(auditoria);
        return persona;
    }
    
    public Simpersona1 obtenerDatosPersonaPorPasaporte(String sNumPasaporte,BeanAuditoria auditoria,String idSession)throws Exception{
    	
    	BeanRequest request = new BeanRequest();
    	request.setSNumPasaporte(sNumPasaporte);
    	request.setSIdSession(idSession);
    	Simpersona1 persona = ejbDigeminLocal.PersonaLeerPorPasaporte(request);
    	
         auditoria.setMetodo("obtenerDatosPersonaPorPasaporte");
         auditoria.setCampos("TABLA Simpersona sNumPasaporte");
         auditoria.setConsulta(sNumPasaporte);
         auditoria.setSistema("WS");
         auditoriaDAO.grabaAuditoria(auditoria);
         
        return persona;
    }
}
