package org.cnl.digemin.bean;

import java.io.Serializable;

public class BeanColegio implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6860273203279501610L;
	private Long ncodigo;
	private String snombre;
	private String sdireccion;
	
	public BeanColegio(){}
	
	public BeanColegio(Long ncodigo){
		this.ncodigo=ncodigo;
	}
	
	public Long getNcodigo() {
		return ncodigo;
	}
	public void setNcodigo(Long ncodigo) {
		this.ncodigo = ncodigo;
	}
	public String getSnombre() {
		return snombre;
	}
	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}
	public String getSdireccion() {
		return sdireccion;
	}
	public void setSdireccion(String sdireccion) {
		this.sdireccion = sdireccion;
	}
	
}
