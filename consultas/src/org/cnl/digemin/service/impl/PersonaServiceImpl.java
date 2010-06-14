package org.cnl.digemin.service.impl;

import gob.min.digemin.ejb.BeanRequest;
import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.Simpersona1;
import gob.min.digemin.ejb.WsDigeminService;

import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.service.PersonaService;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */

public class PersonaServiceImpl implements PersonaService {

	private WsDigeminService service;	
    private AuditoriaDAO auditoriaDAO;    
    public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
		this.auditoriaDAO = auditoriaDAO;
	}

	public PersonaServiceImpl(){
    	
    }
    
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.PersonaService#listaPersonas(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, org.cnl.digemin.bean.BeanAuditoria, java.lang.String)
	 */
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
    
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.PersonaService#obtenerDatosPersona(java.lang.String, org.cnl.digemin.bean.BeanAuditoria, java.lang.String)
	 */
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
    
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.PersonaService#obtenerDatosPersonaPorPasaporte(java.lang.String, org.cnl.digemin.bean.BeanAuditoria, java.lang.String)
	 */
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
