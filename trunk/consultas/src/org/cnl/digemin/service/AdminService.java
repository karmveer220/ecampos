package org.cnl.digemin.service;

import gob.min.digemin.ejb.EjbDigeminWS;
import gob.min.digemin.ejb.WsDigeminService;

import java.util.List;

import javax.xml.ws.BindingProvider;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.DAO.UsuarioDAO;
import org.cnl.digemin.DAO.impl.HibAudotoriaDAO;
import org.cnl.digemin.DAO.impl.HibUsuarioDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanPersona;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */

public class AdminService {

    public static int PERFIL_ADMIN = 1;
    private UsuarioDAO usuarioDAO;
    private AuditoriaDAO auditoriaDAO;
    WsDigeminService service;
    
    public AdminService() throws Exception{
        usuarioDAO = new HibUsuarioDAO();
        auditoriaDAO = new HibAudotoriaDAO();
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
    	//BindingProvider bp = (BindingProvider)port;
       // Map<String, Object> rc = bp.getRequestContext();   
       // rc.put(BindingProvider.USERNAME_PROPERTY, "cedetec");
       /// rc.put(BindingProvider.PASSWORD_PROPERTY, "c3d3t3c");
    	System.out.println("\n valores de user y clave seteados \n");
    	((BindingProvider)port).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "cedetec");
    	((BindingProvider)port).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "c3d3t3c"); 
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
