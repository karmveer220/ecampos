package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SIMIN_SISTEMA database table.
 * 
 */
@Entity
@Table(name="SIMIN_SISTEMA")
public class SiminSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_SIS_CODIGO")
	private long cSisCodigo;

	@Column(name="C_SIS_USUARIOMODIFICACION")
	private BigDecimal cSisUsuariomodificacion;

	@Column(name="C_SIS_USUARIOREGISTRO")
	private BigDecimal cSisUsuarioregistro;

    @Temporal( TemporalType.DATE)
	@Column(name="D_SIS_FECHAMODIFICACION")
	private Date dSisFechamodificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_SIS_FECHAREGISTRO")
	private Date dSisFecharegistro;

	@Column(name="F_SIS_ESTADO")
	private BigDecimal fSisEstado;

	@Column(name="N_SIS_ABREVIATURA")
	private String nSisAbreviatura;

	@Column(name="N_SIS_DESCRIPCION")
	private String nsisDescripcion;

	//bi-directional many-to-one association to SiminUsuariosistema
	@OneToMany(mappedBy="siminSistema")
	private List<SiminUsuariosistema> siminUsuariosistemas;

    public SiminSistema() {
    }

	public long getCSisCodigo() {
		return this.cSisCodigo;
	}

	public void setCSisCodigo(long cSisCodigo) {
		this.cSisCodigo = cSisCodigo;
	}

	public BigDecimal getCSisUsuariomodificacion() {
		return this.cSisUsuariomodificacion;
	}

	public void setCSisUsuariomodificacion(BigDecimal cSisUsuariomodificacion) {
		this.cSisUsuariomodificacion = cSisUsuariomodificacion;
	}

	public BigDecimal getCSisUsuarioregistro() {
		return this.cSisUsuarioregistro;
	}

	public void setCSisUsuarioregistro(BigDecimal cSisUsuarioregistro) {
		this.cSisUsuarioregistro = cSisUsuarioregistro;
	}

	public Date getDSisFechamodificacion() {
		return this.dSisFechamodificacion;
	}

	public void setDSisFechamodificacion(Date dSisFechamodificacion) {
		this.dSisFechamodificacion = dSisFechamodificacion;
	}

	public Date getDSisFecharegistro() {
		return this.dSisFecharegistro;
	}

	public void setDSisFecharegistro(Date dSisFecharegistro) {
		this.dSisFecharegistro = dSisFecharegistro;
	}

	public BigDecimal getFSisEstado() {
		return this.fSisEstado;
	}

	public void setFSisEstado(BigDecimal fSisEstado) {
		this.fSisEstado = fSisEstado;
	}

	public String getNSisAbreviatura() {
		return this.nSisAbreviatura;
	}

	public void setNSisAbreviatura(String nSisAbreviatura) {
		this.nSisAbreviatura = nSisAbreviatura;
	}

	public String getNsisDescripcion() {
		return this.nsisDescripcion;
	}

	public void setNsisDescripcion(String nSisDescripcion) {
		this.nsisDescripcion = nSisDescripcion;
	}

	public List<SiminUsuariosistema> getSiminUsuariosistemas() {
		return this.siminUsuariosistemas;
	}

	public void setSiminUsuariosistemas(List<SiminUsuariosistema> siminUsuariosistemas) {
		this.siminUsuariosistemas = siminUsuariosistemas;
	}
	
}