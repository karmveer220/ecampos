package org.cnl.digemin.service;

import gob.min.digemin.ejb.EjbDigeminLocal;

import java.util.List;

import org.apache.log4j.Logger;
import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.DAO.UsuarioDAO;
import org.cnl.digemin.DAO.impl.HibAudotoriaDAO;
import org.cnl.digemin.DAO.impl.HibUsuarioDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanNotaria;
import org.cnl.digemin.bean.BeanPersona;
import org.springframework.stereotype.Service;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
@Service
public class AdminService {

	Logger logger = Logger.getLogger(AdminService.class);
    
    private UsuarioDAO usuarioDAO;
    private AuditoriaDAO auditoriaDAO;
    private EjbDigeminLocal ejbDigeminLocal;	
    public void setEjbDigeminLocal(EjbDigeminLocal ejbDigeminLocal) {
    	logger.debug("------creado el EJB------");
		this.ejbDigeminLocal = ejbDigeminLocal;
	}
    
    public AdminService() throws Exception{
        usuarioDAO = new HibUsuarioDAO();
        auditoriaDAO = new HibAudotoriaDAO();
    }
    
	public BeanPersona validarPersona(String usuario ,String clave,BeanAuditoria auditoria)throws Exception{
    	String id_session="";
        auditoria.setMetodo("validarPersona");
        auditoria.setCampos("TABLA CNL_PERSONA_PER codigo, clave");
        auditoria.setConsulta(usuario + " / " + clave);
        auditoria.setSistema("WEB");
        auditoriaDAO.grabaAuditoria(auditoria);
        //BeanPersona persona =  usuarioDAO.validarPersona(usuario,clave);
        //id_session=ejbDigeminLocal.autenticaSession(usuario, clave);  
        //logger.debug("---PERSONA AUTENTICADA---" + id_session);
        //persona.setIdSession(id_session);
        BeanPersona persona = new BeanPersona();
        persona.setIdSession("13285");
        persona.setSnombre("juan");
        persona.setSpaterno("albornoz");
        persona.setSmaterno("sanchez");
        persona.setNotaria(new Long(455));
        persona.setNnotaria(new BeanNotaria(new Long(125),"notaria nnnn"));
       return persona;
       
    }
    
    public Integer nuevaPersona(BeanPersona p,BeanAuditoria auditoria)throws Exception{
        auditoria.setMetodo("nuevaPersona");
        auditoria.setCampos("TABLA CNL_PERSONA_PER COMPLETA");
        StringBuffer consulta = new StringBuffer();
        consulta.append( p.getSpaterno());
        consulta.append( " " + p.getSmaterno());
        if(p.getNperfil()!=null)consulta.append( " [perfil = " + p.getNperfil().getSdescripcion()+"]");
        if(p.getNnotaria()!=null)consulta.append( " [notaria = " + p.getNnotaria().getNcodigo()+"]");
        consulta.append( " " + p.getSnombre());
        auditoria.setConsulta(consulta.toString());
        auditoria.setSistema("WEB");
        auditoriaDAO.grabaAuditoria(auditoria);
        return usuarioDAO.nuevaPersona(p);
    }
    /**
     * Recibe el codigo de la notaria, si es 0 significa que el usuario es del CNL<br />
     * y le corresponde la lista de todos los usuarios, de ser otro numero <br />
     * le corresponde solo la lista de usuarios de su notariam.
     * @param codigo Id de notaria.
     * @return lista de usuarios segun la notaria ingresada
     * @throws Exception
     */
    public List<BeanPersona> listarUsuarios(Long codigo) throws Exception{
        return usuarioDAO.listarUsuarios(codigo);
    }
    /**
     * Evalua el codigo de la notaria. sies del CNL entrega todos los usuarios, sino, solo 
     * los usuarios de su ntoaria.
     * @param b beanPersona con informacion cargada
     * @return
     * @throws Exception
     */
    public List<BeanPersona> buscarUsuarios(BeanPersona b) throws Exception{
        return usuarioDAO.buscarUsuarios(b);
    }
    
    public BeanPersona obtenerUsuarioById(Long codigo)throws Exception{
        return usuarioDAO.obtenerUsuarioById(codigo);
    }

    public Integer modificarPersona(BeanPersona p,BeanAuditoria auditoria)throws Exception{
        auditoria.setMetodo("modificarPersona");
        auditoria.setCampos("TABLA CNL_PERSONA_PER COMPLETA");
        auditoria.setConsulta(p.getSnombre() + " " + p.getSpaterno() + " " + p.getSmaterno() + p.getNperfil().getSdescripcion() + p.getNnotaria().getSnombre());
        auditoria.setSistema("WEB");
        auditoriaDAO.grabaAuditoria(auditoria);
        return usuarioDAO.modificarPersona(p);
    }
}
