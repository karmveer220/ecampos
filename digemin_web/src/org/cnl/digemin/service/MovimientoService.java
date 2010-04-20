package org.cnl.digemin.service;

import gob.min.digemin.ejb.EjbDigeminLocal;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;
import gob.min.digemin.ejb.entitiesWeb.Simmovmigra1;

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
public class MovimientoService {
	
	private EjbDigeminLocal ejbDigeminLocal;
	public void setEjbDigeminLocal(EjbDigeminLocal ejbDigeminLocal) {
		System.out.println("------creado el EJB------");
		this.ejbDigeminLocal = ejbDigeminLocal;
	}

	private AuditoriaDAO auditoriaDAO;
    
    public MovimientoService()throws Exception{
        auditoriaDAO = new HibAudotoriaDAO();
    }        
  
    public List<Simmovmigra1> listaDeMovimientosNumeroDocumento(String nroCarnetE,BeanAuditoria auditoria,String idSession)throws Exception{
        auditoria.setMetodo("listaDeMovimientosXCarnet");
        auditoria.setCampos("TABLA SimMovMigra nroCarnetE");
        auditoria.setConsulta(nroCarnetE);
        auditoria.setSistema("WS");
        auditoriaDAO.grabaAuditoria(auditoria);
        
        
    	BeanRequest request = new BeanRequest();
    	request.setSNumDocMovimiento(nroCarnetE);
    	request.setSIdSession(idSession);
        List<Simmovmigra1> lista = ejbDigeminLocal.listaMovimientosXCarnet(request);
     
        return lista;
    }
}
