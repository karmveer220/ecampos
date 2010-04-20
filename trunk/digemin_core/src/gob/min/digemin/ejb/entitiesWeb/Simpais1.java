package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Simpais1 implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sIdPais;
    private String sNombre;
    private String sNacionalidad;
    
    public Simpais1(String sIdPais,String sNombre,String sNacionalidad) {
        this.sIdPais =sIdPais ;
        this.sNombre =sNombre ;
        this.sNacionalidad =sNacionalidad ;
    }
    
    public Simpais1() {
    }
    
    public String getSIdPais() {
        return sIdPais;
    }

    public void setSIdPais(String sIdPais) {
        this.sIdPais = sIdPais;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getSNacionalidad() {
        return sNacionalidad;
    }

    public void setSNacionalidad(String sNacionalidad) {
        this.sNacionalidad = sNacionalidad;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
