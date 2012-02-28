package org.pe.cnl.bean;

// Generated 02/12/2009 04:29:26 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConPerfilPef generated by hbm2java
 */
@Entity
@Table(name = "con_perfil_pef", catalog = "CNL_DIGEMIN")
public class ConPerfilPef implements java.io.Serializable {

	private Integer pefNCodigo;
	private String pefSDescripcion;

	public ConPerfilPef() {
	}

	public ConPerfilPef(String pefSDescripcion) {
		this.pefSDescripcion = pefSDescripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PEF_nCODIGO", unique = true, nullable = false)
	public Integer getPefNCodigo() {
		return this.pefNCodigo;
	}

	public void setPefNCodigo(Integer pefNCodigo) {
		this.pefNCodigo = pefNCodigo;
	}

	@Column(name = "PEF_sDESCRIPCION", length = 25)
	public String getPefSDescripcion() {
		return this.pefSDescripcion;
	}

	public void setPefSDescripcion(String pefSDescripcion) {
		this.pefSDescripcion = pefSDescripcion;
	}

}