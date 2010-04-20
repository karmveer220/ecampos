package org.cnl.digemin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanPerfil;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.form.LoginForm;
import org.cnl.digemin.service.AdminService;
import org.cnl.digemin.service.ColegioService;
import org.cnl.digemin.service.NotariaService;
import org.cnl.digemin.service.PerfilService;
import org.cnl.digemin.utiles.Encriptador;
import org.cnl.digemin.utiles.Utiles;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class LoginAction extends DispatchAction {
    
    private static final Logger logger = Logger.getLogger(LoginAction.class);
    private BeanPersona usrLogin;
  
    
    public ActionForward login(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            LoginForm miform=(LoginForm)form;       
            AdminService service = new AdminService();
            logger.debug(" llamando al service login");
            Encriptador en = Encriptador.getInstance();
            BeanPersona usuario = service.validarPersona(miform.getUsuario(), en.hashData(miform.getClave().getBytes()),new BeanAuditoria());
            request.getSession().setAttribute("usrLogin",usuario);

            NotariaService nservice = new NotariaService();
            request.getSession().setAttribute("lstNotarias",nservice.listaComboNotarias(usuario.getNcolegio().getNcodigo()));
            ColegioService col = new ColegioService();
            request.getSession().setAttribute("comboColegios",col.listaDeColegios());
            
            PerfilService perfilService = new PerfilService();
            List<BeanPerfil> lperfiles=perfilService.listaPErfiles();
            request.getSession().setAttribute("comboPerfiles",lperfiles);
            
            if(usuario.getFclave()==0){
                request.setAttribute("mensaje","Debe cambiar la clave para mantener la seguridad de su cuenta");
                return mapping.findForward("clave");
            }            
            
            return mapping.findForward("inicio");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("exit");
        }
    }
    
    public ActionForward logout(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
        
            HttpSession s = request.getSession();
            s.removeAttribute("usrLogin");
            s.invalidate();
            
        }catch(Exception e){
        	e.printStackTrace();
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
            Encriptador en = Encriptador.getInstance();
            if(!Utiles.nullToBlank(usr.getSclave()).equals( en.hashData(Utiles.nullToBlank(miform.getClave()).getBytes())) ){
                throw new Exception("Su clave actual no es correcta.");
            }
            if(!Utiles.nullToBlank(miform.getNuevaClave()).equals(Utiles.nullToBlank(miform.getConfirmarClave()))){
                throw new Exception("No coincide su nueva clave");
            }
            usr.setSclave(en.hashData( Utiles.nullToBlank(miform.getNuevaClave()).getBytes() ));
            usr.setFclave(1);
            AdminService as = new  AdminService();
            as.modificarPersona(usr,new BeanAuditoria(usrLogin.getNcodigo()));
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
        AdminService adminService = new AdminService();
        BeanPersona usr = adminService.obtenerUsuarioById(new Long(usuario));
        request.getSession().setAttribute("urclave", usr);
        return mapping.findForward("restablecer");
     }
    
    public ActionForward restablecerClave(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
    	try {
    		logger.debug("restablecver clave guardando");
    		BeanPersona usuario = (BeanPersona)request.getSession().getAttribute("urclave");
        	LoginForm miforn = (LoginForm)form;
        	usrLogin = (BeanPersona)request.getSession().getAttribute("usrLogin");
        	String nueva = Utiles.nullToBlank(miforn.getNuevaClave());
        	String confirmar = Utiles.nullToBlank(miforn.getConfirmarClave());
        	if(!nueva.equals(confirmar)){
        		throw new Exception("No coinciden las claves");    		
        	}
        	 Encriptador en = Encriptador.getInstance();
        	usuario.setSclave(en.hashData(nueva.getBytes()));
        	usuario.setFclave(0);
        	AdminService adminService = new AdminService();
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
