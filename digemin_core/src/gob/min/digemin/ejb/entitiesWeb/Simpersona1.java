package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;

import java.util.Calendar;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Simpersona1 implements Serializable{

    private String uIdPersona;
    private Calendar dFechaNacimiento;
    private String sMaterno;
    private String sNombre;
    private String sPaterno;
    private String sSexo;
    private Simpais1 paisNacimiento;//simpais2
    private Simpais1 paisNacionalidad;//simpais
    private String sIdDocIdentidad;
    private String sNumDocIdentidad;
    private Simdocumento1 documentoviaje;
    
    public Simpersona1() {
    }

    public Simpersona1(String uIdPersona,Calendar dFechaNacimiento,String sMaterno,String sNombre,String sPaterno) {
        this.uIdPersona=uIdPersona;
        this.dFechaNacimiento=dFechaNacimiento;
        this.sMaterno=sMaterno;
        this.sNombre=sNombre;
        this.sPaterno=sPaterno;
    }
    
    public Simpersona1(String uIdPersona,Calendar dFechaNacimiento,String sMaterno,String sNombre,String sPaterno,String sSexo,Simpais1 paisNacimiento,Simpais1 paisNacionalidad,String sIdDocIdentidad,String sNumDocIdentidad) {
        this.uIdPersona=uIdPersona;
        this.dFechaNacimiento=dFechaNacimiento;
        this.sMaterno=sMaterno;
        this.sNombre=sNombre;
        this.sPaterno=sPaterno;
        this.sSexo=sSexo;
        this.paisNacimiento=paisNacimiento;
        this.paisNacionalidad=paisNacionalidad;
        this.sIdDocIdentidad=sIdDocIdentidad;
        this.sNumDocIdentidad=sNumDocIdentidad;
    }
    
    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }

    public Calendar getDFechaNacimiento() {
        return dFechaNacimiento;
    }

    public void setDFechaNacimiento(Calendar dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }

    public String getSMaterno() {
        return sMaterno;
    }

    public void setSMaterno(String sMaterno) {
        this.sMaterno = sMaterno;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getSPaterno() {
        return sPaterno;
    }

    public void setSPaterno(String sPaterno) {
        this.sPaterno = sPaterno;
    }

    public String getSSexo() {
        return sSexo;
    }

    public void setSSexo(String sSexo) {
        this.sSexo = sSexo;
    }

    public Simpais1 getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(Simpais1 paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getSIdDocIdentidad() {
        return sIdDocIdentidad;
    }

    public void setSIdDocIdentidad(String sIdDocIdentidad) {
        this.sIdDocIdentidad = sIdDocIdentidad;
    }

    public String getSNumDocIdentidad() {
        return sNumDocIdentidad;
    }

    public void setSNumDocIdentidad(String sNumDocIdentidad) {
        this.sNumDocIdentidad = sNumDocIdentidad;
    }
    
    public Simpais1 getPaisNacionalidad() {
        return paisNacionalidad;
    }

    public void setPaisNacionalidad(Simpais1 paisNacionalidad) {
        this.paisNacionalidad = paisNacionalidad;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }

    public void setDocumentoviaje(Simdocumento1 documentoviaje) {
        this.documentoviaje = documentoviaje;
    }

    public Simdocumento1 getDocumentoviaje() {
        return documentoviaje;
    }
}
