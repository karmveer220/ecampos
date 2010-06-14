package org.cnl.digemin.bean;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC Convenio DIGEMIN - CNL
 * 
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class BeanPerfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ncodigo;
	private String sdescripcion;

	public BeanPerfil(int ncodigo, String sdescripcion) {
		this.ncodigo = ncodigo;
		this.sdescripcion = sdescripcion;
	}

	public BeanPerfil() {
	}

	public void setNcodigo(int ncodigo) {
		this.ncodigo = ncodigo;
	}

	public int getNcodigo() {
		return ncodigo;
	}

	public void setSdescripcion(String sdescripcion) {
		this.sdescripcion = sdescripcion;
	}

	public String getSdescripcion() {
		return sdescripcion;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SIMPLE_STYLE);
	}

}
