package org.cnl.digemin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanColegio;
import org.cnl.digemin.bean.BeanNotaria;
import org.cnl.digemin.bean.BeanPerfil;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.service.AdminService;
import org.cnl.digemin.service.impl.AdminServiceImpl;
import org.cnl.digemin.utiles.Encriptador;
import org.cnl.digemin.utiles.Utiles;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class UsuarioAction extends DispatchAction {

	private static final Logger logger = Logger.getLogger(UsuarioAction.class);
    private BeanPersona usrLogin;
    
    private AdminService adminService;    
    public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public ActionForward lista(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{   
            usrLogin = (BeanPersona)request.getSession().getAttribute("usrLogin");
            logger.debug("Lista de usuarios");
            if(request.getSession().getAttribute("listaUsuariosuu")==null){
                List<BeanPersona> lista = adminService.listarUsuarios(new Long(usrLogin.getNnotaria().getNcodigo()) );
                request.getSession().setAttribute("listaUsuariosuu",lista);
            }
            DynaActionForm mfo = (DynaActionForm)form;
            mfo.reset(mapping, request);
            logger.debug("fin del metodo");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
        }
        return mapping.findForward("lista");
    }
   
    public ActionForward buscar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            usrLogin = (BeanPersona)request.getSession().getAttribute("usrLogin");
            logger.debug("busqueda de usuarios");
            DynaActionForm myform = (DynaActionForm)form;
                BeanPersona b = new BeanPersona();
                b.setSnombre(Utiles.nullToBlank(myform.get("snombre")));
                b.setSpaterno(Utiles.nullToBlank(myform.get("spaterno")));
                b.setSusuario(Utiles.nullToBlank(myform.get("susuario")));
                b.setNotaria(Integer.parseInt((String)myform.get("notaria")));
                b.setColegio(Integer.parseInt((String)myform.get("colegio")));
                List<BeanPersona> lista = adminService.buscarUsuarios(b);
                request.getSession().setAttribute("listaUsuariosuu",lista);
           
            logger.debug("fin del metodo");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError", " "+e.getMessage());
        }
        return mapping.findForward("lista");
    }
    
    public ActionForward preNuevo(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            BeanPersona bp = new BeanPersona();
            bp.setSnombre("");
            bp.setSclave("1");
            bp.setColegio(0);
            bp.setNotaria(0);
            bp.setPerfil(0);
            request.getSession().setAttribute("nuser",bp);
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("lista");
        }
        return mapping.findForward("nuevo");
    }
    
    public ActionForward nuevo(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        String clave="";
        BeanPersona p =null;
    	try{
            usrLogin = (BeanPersona)request.getSession().getAttribute("usrLogin");
            DynaActionForm myform = (DynaActionForm)form;
            p = (BeanPersona)request.getSession().getAttribute("nuser");
            llenaUsuario(p, myform, request);
            p.setFclave(0);
            Encriptador en = Encriptador.getInstance();
            clave=myform.getString("sclave");
            p.setSclave( en.hashData( Utiles.nullToBlank(myform.get("sclave")).getBytes() ));
            adminService.nuevaPersona(p,new BeanAuditoria(usrLogin.getNcodigo().intValue()));
            request.setAttribute("mensaje","Usuario registrado exitosamente");
            request.removeAttribute("nuser");
            request.getSession().removeAttribute("listaUsuariosuu");
           return lista(mapping,form,request,response);
            
        }catch(Exception e){
        	p.setSclave(clave);
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("nuevo");
        }
    }
    
    public ActionForward preModificar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            Long cod  = new Long(request.getParameter("usr"));
            request.getSession().setAttribute("muser",adminService.obtenerUsuarioById(cod));
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("lista");
        }
        return mapping.findForward("modificar");
    }
    
    
    public ActionForward modificar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            DynaActionForm myform = (DynaActionForm)form;
            BeanPersona p = (BeanPersona)request.getSession().getAttribute("muser");
            usrLogin = (BeanPersona)request.getSession().getAttribute("usrLogin");
            llenaUsuario(p, myform, request);            
            logger.debug("antes del modificar ");            
            adminService.modificarPersona(p,new BeanAuditoria(usrLogin.getNcodigo().intValue()));
            request.setAttribute("mensaje","Usuario modificado exitosamente");
            request.getSession().removeAttribute("listaUsuariosuu");
            request.getSession().removeAttribute("muser");
            return lista(mapping,form,request,response);
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("modificar");
        }
        //return mapping.findForward("lista");
    }
    
    public void llenaUsuario(BeanPersona p,DynaActionForm myform,HttpServletRequest request) throws Exception{
    	
    	 if(usrLogin.getNperfil().getNcodigo() == AdminServiceImpl.PERFIL_ADMIN){
             p.setNperfil(new BeanPerfil(Integer.parseInt(Utiles.nullToBlank(myform.get("perfil"))),""));
             p.setPerfil(Integer.parseInt(Utiles.nullToBlank(myform.get("perfil"))));    
             p.setNotaria(Integer.parseInt(Utiles.nullToBlank(myform.get("notaria"))));
             p.setNnotaria(new BeanNotaria(p.getNotaria(),""));
         }else{
        	 //Consulta por defecto y la misma notaria del administrador local
             p.setNperfil(new BeanPerfil(2,""));
             p.setPerfil(2);
             p.setNotaria(usrLogin.getNotaria());
             p.setNnotaria(new BeanNotaria(usrLogin.getNnotaria().getNcodigo(),usrLogin.getNnotaria().getSnombre()));
         }
         p.setSnombre(Utiles.nullToBlank(myform.get("snombre")));
         p.setSpaterno(Utiles.nullToBlank(myform.get("spaterno")));
         p.setSmaterno(Utiles.nullToBlank(myform.get("smaterno")));
         p.setDnacimiento(Utiles.nullToBlank(myform.get("dnacimiento")));
         p.setNacimiento(Utiles.stringToCalendar(Utiles.nullToBlank(myform.get("dnacimiento")), Utiles.FORMATO_FECHA_CORTA_MYSQL));
         p.setSusuario(Utiles.nullToBlank(myform.get("susuario")));
         p.setSnum_doc(Utiles.nullToBlank(myform.get("snum_doc")));
         p.setSemail(Utiles.nullToBlank(myform.get("semail")));
         p.setColegio(Integer.parseInt(Utiles.nullToBlank(request.getParameter("colegio"))));         
    }
    
    public ActionForward cancelaModificar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            request.getSession().removeAttribute("muser");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
        }
        return mapping.findForward("lista");
    }
    
}
