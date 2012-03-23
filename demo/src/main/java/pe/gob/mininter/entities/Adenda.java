package pe.gob.mininter.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Adenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String c_aden_codigo;
	private String d_aden_fecini;
	private String d_aden_fecfin;
	private String c_cont_codigo;
	private String f_cont_adenda;
	
	public Adenda(){
		  c_aden_codigo="";
		  d_aden_fecini="";
		  d_aden_fecfin="";
		  c_cont_codigo="";
		  f_cont_adenda="";
	}
	
	public String getC_aden_codigo() {
		return c_aden_codigo;
	}
	public void setC_aden_codigo(String c_aden_codigo) {
		this.c_aden_codigo = c_aden_codigo;
	}
	public String getD_aden_fecini() {
		return d_aden_fecini;
	}
	public void setD_aden_fecini(String d_aden_fecini) {
		this.d_aden_fecini = d_aden_fecini;
	}
	public String getD_aden_fecfin() {
		return d_aden_fecfin;
	}
	public void setD_aden_fecfin(String d_aden_fecfin) {
		this.d_aden_fecfin = d_aden_fecfin;
	}
	public String getC_cont_codigo() {
		return c_cont_codigo;
	}
	public void setC_cont_codigo(String c_cont_codigo) {
		this.c_cont_codigo = c_cont_codigo;
	}	
	public String getF_cont_adenda() {
		return f_cont_adenda;
	}
	public void setF_cont_adenda(String f_cont_adenda) {
		this.f_cont_adenda = f_cont_adenda;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}
