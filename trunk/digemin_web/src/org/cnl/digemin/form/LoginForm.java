package org.cnl.digemin.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class LoginForm extends ActionForm{

    private String usuario;
    private String clave;
    private String nuevaClave;
    private String confirmarClave;
    
    public void reset(ActionMapping arg0, HttpServletRequest arg1) {
        usuario="";
        clave="";
        nuevaClave="";
        confirmarClave="";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setConfirmarClave(String confirmarClave) {
        this.confirmarClave = confirmarClave;
    }

    public String getConfirmarClave() {
        return confirmarClave;
    }
    
    public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {

       ActionErrors errors = new ActionErrors();
       if ((usuario == null) || (usuario.length() < 1))
         errors.add("usuario", new ActionMessage("error.username.required"));
       if ((clave == null) || (clave.length() < 1))
         errors.add("clave", new ActionMessage("error.password.required"));

       return errors;
    
    }
}
