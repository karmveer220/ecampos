package org.cnl.digemin.service;

import gob.min.digemin.ejb.EjbDigeminLocal;
import gob.min.digemin.ejb.entitiesWeb.BeanImagen;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.DAO.impl.HibAudotoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.utiles.Utiles;
import org.springframework.stereotype.Service;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
@Service
public class ImagenService {
	
    private AuditoriaDAO auditoriaDAO;
   
    private EjbDigeminLocal ejbDigeminLocal;
    public void setEjbDigeminLocal(EjbDigeminLocal ejbDigeminLocal) {
    	System.out.println("------creado el EJB------");
		this.ejbDigeminLocal = ejbDigeminLocal;
	}

	public ImagenService()throws Exception{
        auditoriaDAO = new HibAudotoriaDAO();
    }
    
    public List<String> MCMImagenBuscarUltimasPorIdPersona(String uidPErsona,String paisNacionalidad,String pers_llave,String[] ltipoImagen,String path,BeanAuditoria auditoria ,String idSession)throws Exception{
             
    	
    	BeanRequest request = new BeanRequest();
    	request.setUIdPersona(uidPErsona);
    	request.setSIdPaisNacionalidad(paisNacionalidad);
    	request.setSPersLlave(pers_llave);
    	request.setSIdSession(idSession);
    	request.getSTipoImagen();//Solo para inicializar la lista
    	System.out.println("tipos de imagenes : " + ltipoImagen.length);
    	if(ltipoImagen.length > 0){
    		request.setSTipoImagen( ltipoImagen);
    	}
    	List<BeanImagen> lista = null ;
    	
    	if(paisNacionalidad.equals("PER")){
    		lista = ejbDigeminLocal.MCMImagenBuscarUltimasPorIdPersonaPeruano(request);	
    	}else{
    		lista = ejbDigeminLocal.MCMImagenBuscarUltimasPorIdPersonaExtranjero(request);
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
