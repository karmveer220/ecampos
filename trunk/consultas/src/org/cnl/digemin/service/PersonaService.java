package org.cnl.digemin.service;

import gob.min.digemin.ejb.BeanRequest;
import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.Simpersona1;
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
public class PersonaService {

	WsDigeminService service;
    private AuditoriaDAO auditoriaDAO;
    
    public PersonaService()throws Exception{
    	auditoriaDAO = new HibAudotoriaDAO();
    }
    
    public List<Simpersona1> listaPersonas(String snombre, String spaterno,
    		String smaterno,boolean bPeruano, boolean coincidirAlFinal,
    		BeanAuditoria auditoria,String idSession) throws Exception {
            
    	service = new WsDigeminService();
    	EjbDigeminWS port = service.getEjbDigeminWsPort();
    	BeanRequest request = new BeanRequest();
    	request.setSNombre(snombre);
    	request.setSApePaterno(spaterno);
    	request.setSApeMaterno(smaterno);
    	request.setBAproximado(coincidirAlFinal);
    	request.setBPeruano(bPeruano);
    	request.setSIdSession(idSession);
    	List<Simpersona1> lista = port.listaPersonaPorNombres(request);
    	
        auditoria.setMetodo("listaPersonas");
        auditoria.setCampos("TABLA Simpersona snombre spaterno smaterno bPeruano");
        auditoria.setConsulta(snombre +"-"+ spaterno + "-" +smaterno+"|"+ (bPeruano==true?"Peruano":"Extranjero") );
        auditoria.setSistema("WS");
        auditoriaDAO.grabaAuditoria(auditoria);
       
        return lista;                
    }
    
    public Simpersona1 obtenerDatosPersona(String uIdPErsona,BeanAuditoria auditoria,String idSession)throws Exception{
        
    	service = new WsDigeminService();
    	EjbDigeminWS port = service.getEjbDigeminWsPort();
    	BeanRequest request = new BeanRequest();
    	request.setUIdPersona(uIdPErsona);
    	request.setSIdSession(idSession);
    	Simpersona1 persona = port.personaLeer(request);

         auditoria.setMetodo("obtenerDatosPersona");
         auditoria.setCampos("TABLA Simpersona uIdPErsona");
         auditoria.setConsulta(uIdPErsona);
         auditoria.setSistema("WS");
         auditoriaDAO.grabaAuditoria(auditoria);
        return persona;
    }
    
    public Simpersona1 obtenerDatosPersonaPorPasaporte(String sNumPasaporte,BeanAuditoria auditoria,String idSession)throws Exception{
    	
    	service = new WsDigeminService();
    	EjbDigeminWS port = service.getEjbDigeminWsPort();
    	BeanRequest request = new BeanRequest();
    	request.setSNumPasaporte(sNumPasaporte);
    	request.setSIdSession(idSession);
    	Simpersona1 persona = port.personaLeerPorPasaporte(request);
    	
         auditoria.setMetodo("obtenerDatosPersonaPorPasaporte");
         auditoria.setCampos("TABLA Simpersona sNumPasaporte");
         auditoria.setConsulta(sNumPasaporte);
         auditoria.setSistema("WS");
         auditoriaDAO.grabaAuditoria(auditoria);
         
        return persona;
    }
}
