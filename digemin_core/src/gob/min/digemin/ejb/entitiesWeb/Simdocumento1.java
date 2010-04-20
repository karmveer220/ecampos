package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Mayo 2009
 * @version 1.0
 */
public class Simdocumento1 implements Serializable{
    
    private String sIdDocumento;
    private String sDescripcion;
    
    public Simdocumento1() {
    }
    
    public Simdocumento1(String sIdDocumento,String sDescripcion) {
        this.sIdDocumento=sIdDocumento;
        this.sDescripcion=sDescripcion;
    }
    
    public void setSIdDocumento(String sIdDocumento) {
        this.sIdDocumento = sIdDocumento;
    }

    public String getSIdDocumento() {
        return sIdDocumento;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
