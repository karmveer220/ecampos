package org.cnl.digemin.service.impl;

import gob.min.digemin.ejb.BeanImagen;
import gob.min.digemin.ejb.BeanRequest;
import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.WsDigeminService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.service.ImagenService;
import org.cnl.digemin.utiles.Utiles;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */

public class ImagenServiceImpl implements ImagenService {

	WsDigeminService service;
	
    private AuditoriaDAO auditoriaDAO;
    
    public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
		this.auditoriaDAO = auditoriaDAO;
	}

	public ImagenServiceImpl()throws Exception{
        
    }
    
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.ImagenService#MCMImagenBuscarUltimasPorIdPersona(java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.String, org.cnl.digemin.bean.BeanAuditoria, java.lang.String)
	 */
    public List<String> MCMImagenBuscarUltimasPorIdPersona(String uidPErsona,String paisNacionalidad,String pers_llave,String[] ltipoImagen,String path,BeanAuditoria auditoria ,String idSession)throws Exception{
             
    	service = new WsDigeminService();
    	EjbDigeminWS port = service.getEjbDigeminWsPort();
    	BeanRequest request = new BeanRequest();
    	request.setUIdPersona(uidPErsona);
    	request.setSIdPaisNacionalidad(paisNacionalidad);
    	request.setSPersLlave(pers_llave);
    	request.setSIdSession(idSession);
    	request.getSTipoImagen();//Solo para inicializar la lista
    	System.out.println("tipos de imagenes : " + ltipoImagen.length);
    	if(ltipoImagen.length > 0){
    		for(String img : ltipoImagen){
    			request.getSTipoImagen().add(img);	
    		}
    	}
    	List<BeanImagen> lista = null ;
    	
    	if(paisNacionalidad.equals("PER")){
    		lista = port.mcmImagenBuscarUltimasPorIdPersonaPeruano(request);	
    	}else{
    		lista = port.mcmImagenBuscarUltimasPorIdPersonaExtranjero(request);
    	}
        
        List<String> resultado = null;

            for(BeanImagen im : lista){
            	if(resultado==null){resultado=new ArrayList<String>();}
            	InputStream inp = new ByteArrayInputStream(im.getImagen());
                resultado.add(Utiles.guardaImagenEnDisco(inp,im.getId(),path));
            }
        
        auditoria.setMetodo("MCMImagenBuscarUltimasPorIdPersona");
        auditoria.setCampos("TABLA SimImagen/SimImagenExtranjero");
        auditoria.setConsulta(uidPErsona + " / " + paisNacionalidad);
        auditoria.setSistema("WS");
        auditoriaDAO.grabaAuditoria(auditoria);
        return resultado;
        
    }
    
}
