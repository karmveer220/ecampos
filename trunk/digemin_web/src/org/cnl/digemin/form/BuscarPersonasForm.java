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
public class BuscarPersonasForm extends ActionForm{
    /**
     * 
     */
    private static final long serialVersionUID = 4162050557476371585L;
    private String snombre;
    private String spaterno;
    private String smaterno;
    private String snroce;
    private String snropas;
    /**1 coincidir en cualquier lugar (like '%text%')<br>
     * 0 coincidir al final de la palabra (like 'texto%')*/
    private String coincidir;
    /**
     * 1 = Peruano<br/>
     * 0 = Extranjero
     */
    private String nacionalidad;
    
    public void reset(ActionMapping arg0, HttpServletRequest arg1) {
          snombre="";
          spaterno="";
          smaterno="";
          snroce="";
          coincidir="";
          snropas="";
          nacionalidad="";
    }

    public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
    
        ActionErrors errores = new ActionErrors();
      /*  if  ( (spaterno == null || spaterno.trim().length() == 0) &&  (smaterno == null || smaterno.trim().length() == 0) )
       * {
       * if(snombre == null || snombre.trim().length() == 0){
       *    errores.add("errorCondicion", new ActionMessage("errors.required","Condicion"));
            }
        }*/
        return errores;
    }
            
    public String getSnombre() {
            return snombre;
    }

    public void setSnombre(String snombre) {
            this.snombre = snombre;
    }

    public String getSpaterno() {
            return spaterno;
    }

    public void setSpaterno(String spaterno) {
            this.spaterno = spaterno;
    }

    public String getSmaterno() {
            return smaterno;
    }

    public void setSmaterno(String smaterno) {
            this.smaterno = smaterno;
    }

    public String getSnroce() {
        return snroce;
    }

    public void setSnroce(String snroce) {
        this.snroce = snroce;
    }

    public String getCoincidir() {
        return coincidir;
    }

    public void setCoincidir(String coincidir) {
        this.coincidir = coincidir;
    }

    public void setSnropas(String snropas) {
        this.snropas = snropas;
    }

    public String getSnropas() {
        return snropas;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
}
