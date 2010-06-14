package org.cnl.digemin.service.impl;

import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.WsDigeminService;

import java.util.List;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.DAO.UsuarioDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.service.AdminService;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */

public class AdminServiceImpl implements AdminService {

    public static int PERFIL_ADMIN = 1;
    
    private UsuarioDAO usuarioDAO;    
    private AuditoriaDAO auditoriaDAO;
   
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
		this.auditoriaDAO = auditoriaDAO;
	}

	WsDigeminService service;
        
    public AdminServiceImpl(){
        
    }
    
	public BeanPersona validarPersona(String usuario ,String clave,BeanAuditoria auditoria)throws Exception{
    	
        auditoria.setMetodo("validarPersona");
        auditoria.setCampos("TABLA CNL_PERSONA_PER codigo, clave");
        auditoria.setConsulta(usuario);
        auditoria.setSistema("WEB");
        
        BeanPersona persona =  usuarioDAO.validarPersona(usuario,clave);
        auditoriaDAO.grabaAuditoria(auditoria);
        
        service = new WsDigeminService();
    	EjbDigeminWS port = service.getEjbDigeminWsPort(); 
        persona.setIdSession(port.autenticaSession(persona.getSusuario()));
       return persona;
       
    }
    
    public Integer nuevaPersona(BeanPersona p,BeanAuditoria auditoria)throws Exception{
        auditoria.setMetodo("nuevaPersona");
        auditoria.setCampos("TABLA CNL_PERSONA_PER COMPLETA");
        StringBuilder consulta = new StringBuilder();
        consulta.append( p.getSpaterno());
        consulta.append( " " + p.getSmaterno());
        if(p.getNperfil()!=null)consulta.append( " [perfil = " ).append( p.getNperfil().getSdescripcion()).append("]");
        if(p.getNnotaria()!=null)consulta.append( " [notaria = " ).append( p.getNnotaria().getNcodigo()).append("]");
        consulta.append( " " + p.getSnombre());
        auditoria.setConsulta(consulta.toString());
        auditoria.setSistema("WEB");
        auditoriaDAO.grabaAuditoria(auditoria);
        System.out.println("registrado por jpa");
        return usuarioDAO.nuevaPersona(p);
    }
  
    public List<BeanPersona> listarUsuarios(Long codigo) throws Exception{
        return usuarioDAO.listarUsuarios(codigo);
    }
   
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
