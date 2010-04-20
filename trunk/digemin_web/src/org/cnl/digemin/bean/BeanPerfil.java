package org.cnl.digemin.bean;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class BeanPerfil implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ncodigo;
    private String sdescripcion;
    private Set<BeanPersona> personas;
    
    public BeanPerfil(Long ncodigo,String sdescripcion) {
        this.ncodigo=ncodigo;
        this.sdescripcion=sdescripcion;
    }
    
    public BeanPerfil() {
    }
    public void setNcodigo(Long ncodigo) {
        this.ncodigo = ncodigo;
    }

    public Long getNcodigo() {
        return ncodigo;
    }

    public void setSdescripcion(String sdescripcion) {
        this.sdescripcion = sdescripcion;
    }
    public String getSdescripcion() {
        return sdescripcion;
    }
    public void setPersonas(Set<BeanPersona> personas) {
        this.personas = personas;
    }
    public Set<BeanPersona> getPersonas() {
        return personas;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }

}
