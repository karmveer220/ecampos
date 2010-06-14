package org.cnl.digemin.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Bean para enviar informacion de auditoria del sistema</br> COLEGIO DE
 * NOTARIOS DE LIMA - CEDETEC</br> Convenio DIGEMIN - CNL</br>
 * 
 * @author Elvis Ruben Campos Mori
 * @since MAYO 2009
 * @version 2.0
 */
public class BeanAuditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Long usuarioRegistro;
	private Date fechaRegistro;
	private String metodo;
	private String sistema;
	private String consulta;
	private String campos;
	private String username;

	public BeanAuditoria() {

	}

	public BeanAuditoria(int usuarioRegistro) {
		this.usuarioRegistro = new Long(usuarioRegistro);
	}

	public BeanAuditoria(int usuarioRegistro, String username) {
		this.usuarioRegistro = new Long(usuarioRegistro);
		this.username = username;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SIMPLE_STYLE);
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setUsuarioRegistro(Long usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Long getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getSistema() {
		return sistema;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setCampos(String campos) {
		this.campos = campos;
	}

	public String getCampos() {
		return campos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}