package org.cnl.digemin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.form.LoginForm;
import org.cnl.digemin.service.AdminService;
import org.cnl.digemin.utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class LoginAction extends DispatchAction {
    
    private Logger logger = Logger.getLogger(LoginAction.class);
    private BeanPersona usrLogin;
    
    @Autowired
    private AdminService adminService;
    
    public ActionForward login(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            request.getSession().setAttribute("usrLogin",adminService.validarPersona("", "", new BeanAuditoria()));
            return mapping.findForward("inicio");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("exit");
        }
    }
    
    public ActionForward logout(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            HttpSession s = request.getSession(false);
            s.invalidate();
        }catch(Exception e){
            request.setAttribute("msgError",e.getMessage());
        }
        return mapping.findForward("exit");
    }
    
    public ActionForward preCambioClave(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
       logger.debug("solo es encesario ir al jsp");
       return mapping.findForward("clave");
    }
    
    public ActionForward cambioClave(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            HttpSession session = request.getSession();
            usrLogin = (BeanPersona)session.getAttribute("usrLogin");
            
            LoginForm miform=(LoginForm)form;
            BeanPersona usr = (BeanPersona)request.getSession().getAttribute("usrLogin");
            if(!Utiles.nullToBlank(usr.getSclave()).equals(Utiles.nullToBlank(miform.getClave()))){
                throw new Exception("Su clave actual no es correcta.");
            }
            if(!Utiles.nullToBlank(miform.getNuevaClave()).equals(Utiles.nullToBlank(miform.getConfirmarClave()))){
                throw new Exception("No coincide su nueva clave");
            }
            usr.setSclave(Utiles.nullToBlank(miform.getNuevaClave()));
            usr.setFclave(1);
           
            adminService.modificarPersona(usr,new BeanAuditoria(usrLogin.getNcodigo()));
            request.setAttribute("mensaje","Su clave ha sido modificada");
        }catch(Exception e){
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("clave");
        }
        return mapping.findForward("home");
    }
    
    public ActionForward preRestClave(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        logger.debug("solo es encesario ir al jsp");
        String usuario = request.getParameter("usr");
        BeanPersona usr = adminService.obtenerUsuarioById(new Long(usuario));
        request.getSession().setAttribute("urclave", usr);
        return mapping.findForward("restablecer");
     }
    
    public ActionForward restablecerClave(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
    	try {
    		BeanPersona usuario = (BeanPersona)request.getSession().getAttribute("urclave");
        	LoginForm miforn = (LoginForm)form;
        	usrLogin = (BeanPersona)request.getSession().getAttribute("usrLogin");
        	String nueva = Utiles.nullToBlank(miforn.getNuevaClave());
        	String confirmar = Utiles.nullToBlank(miforn.getConfirmarClave());
        	if(!nueva.equals(confirmar)){
        		throw new Exception("No coinciden las claves");    		
        	}
        	usuario.setSclave(nueva);
        	usuario.setFclave(0);
        	adminService.modificarPersona(usuario, new BeanAuditoria(usrLogin.getNcodigo()));
        	request.setAttribute("mensaje", "Clave reestablecida.");
        	request.removeAttribute("urclave");
        	return mapping.findForward("home");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgError", e.getMessage());
			return mapping.findForward("restablecer");
		}
     }
    
}
