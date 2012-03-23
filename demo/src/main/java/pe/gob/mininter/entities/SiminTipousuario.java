package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SIMIN_TIPOUSUARIO database table.
 * 
 */
@Entity
@Table(name="SIMIN_TIPOUSUARIO")
public class SiminTipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_TUSU_CODIGO")
	private long cTusuCodigo;

	@Column(name="C_TUSU_DETALLE")
	private String cTusuDetalle;

	@Column(name="C_TUSU_USUARIOMODIFICACION")
	private BigDecimal cTusuUsuariomodificacion;

	@Column(name="C_TUSU_USUARIOREGISTRO")
	private BigDecimal cTusuUsuarioregistro;

    @Temporal( TemporalType.DATE)
	@Column(name="D_TUSU_FECHAMODIFICACION")
	private Date dTusuFechamodificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_TUSU_FECHAREGISTRO")
	private Date dTusuFecharegistro;

	@Column(name="F_TUSU_ESTADO")
	private BigDecimal fTusuEstado;

	@Column(name="N_TUSU_DESCRIPCION")
	private String nTusuDescripcion;

	//bi-directional many-to-one association to SiminUsuariosistema
	@OneToMany(mappedBy="siminTipousuario")
	private List<SiminUsuariosistema> siminUsuariosistemas;

    public SiminTipousuario() {
    }

	public long getCTusuCodigo() {
		return this.cTusuCodigo;
	}

	public void setCTusuCodigo(long cTusuCodigo) {
		this.cTusuCodigo = cTusuCodigo;
	}

	public String getCTusuDetalle() {
		return this.cTusuDetalle;
	}

	public void setCTusuDetalle(String cTusuDetalle) {
		this.cTusuDetalle = cTusuDetalle;
	}

	public BigDecimal getCTusuUsuariomodificacion() {
		return this.cTusuUsuariomodificacion;
	}

	public void setCTusuUsuariomodificacion(BigDecimal cTusuUsuariomodificacion) {
		this.cTusuUsuariomodificacion = cTusuUsuariomodificacion;
	}

	public BigDecimal getCTusuUsuarioregistro() {
		return this.cTusuUsuarioregistro;
	}

	public void setCTusuUsuarioregistro(BigDecimal cTusuUsuarioregistro) {
		this.cTusuUsuarioregistro = cTusuUsuarioregistro;
	}

	public Date getDTusuFechamodificacion() {
		return this.dTusuFechamodificacion;
	}

	public void setDTusuFechamodificacion(Date dTusuFechamodificacion) {
		this.dTusuFechamodificacion = dTusuFechamodificacion;
	}

	public Date getDTusuFecharegistro() {
		return this.dTusuFecharegistro;
	}

	public void setDTusuFecharegistro(Date dTusuFecharegistro) {
		this.dTusuFecharegistro = dTusuFecharegistro;
	}

	public BigDecimal getFTusuEstado() {
		return this.fTusuEstado;
	}

	public void setFTusuEstado(BigDecimal fTusuEstado) {
		this.fTusuEstado = fTusuEstado;
	}

	public String getNTusuDescripcion() {
		return this.nTusuDescripcion;
	}

	public void setNTusuDescripcion(String nTusuDescripcion) {
		this.nTusuDescripcion = nTusuDescripcion;
	}

	public List<SiminUsuariosistema> getSiminUsuariosistemas() {
		return this.siminUsuariosistemas;
	}

	public void setSiminUsuariosistemas(List<SiminUsuariosistema> siminUsuariosistemas) {
		this.siminUsuariosistemas = siminUsuariosistemas;
	}
	
}