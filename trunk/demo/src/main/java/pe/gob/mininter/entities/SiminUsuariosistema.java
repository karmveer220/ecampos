package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SIMIN_USUARIOSISTEMA database table.
 * 
 */
@Entity
@Table(name="SIMIN_USUARIOSISTEMA")
public class SiminUsuariosistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_US_CODIGO")
	private long cUsCodigo;

	@Column(name="C_US_USUARIOMODIFICACION")
	private BigDecimal cUsUsuariomodificacion;

	@Column(name="C_US_USUARIOREGISTRO")
	private BigDecimal cUsUsuarioregistro;

    @Temporal( TemporalType.DATE)
	@Column(name="D_US_FECHAMODIFICACION")
	private Date dUsFechamodificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_US_FECHAREGISTRO")
	private Date dUsFecharegistro;

	//bi-directional many-to-one association to SiminMaestro
    @ManyToOne
	@JoinColumn(name="C_PERL_CODIGO")
	private SiminMaestro siminMaestro;

	//bi-directional many-to-one association to SiminSistema
    @ManyToOne
	@JoinColumn(name="C_SIS_CODIGO")
	private SiminSistema siminSistema;

	//bi-directional many-to-one association to SiminTipousuario
    @ManyToOne
	@JoinColumn(name="C_TUSU_CODIGO")
	private SiminTipousuario siminTipousuario;

    public SiminUsuariosistema() {
    }

	public long getCUsCodigo() {
		return this.cUsCodigo;
	}

	public void setCUsCodigo(long cUsCodigo) {
		this.cUsCodigo = cUsCodigo;
	}

	public BigDecimal getCUsUsuariomodificacion() {
		return this.cUsUsuariomodificacion;
	}

	public void setCUsUsuariomodificacion(BigDecimal cUsUsuariomodificacion) {
		this.cUsUsuariomodificacion = cUsUsuariomodificacion;
	}

	public BigDecimal getCUsUsuarioregistro() {
		return this.cUsUsuarioregistro;
	}

	public void setCUsUsuarioregistro(BigDecimal cUsUsuarioregistro) {
		this.cUsUsuarioregistro = cUsUsuarioregistro;
	}

	public Date getDUsFechamodificacion() {
		return this.dUsFechamodificacion;
	}

	public void setDUsFechamodificacion(Date dUsFechamodificacion) {
		this.dUsFechamodificacion = dUsFechamodificacion;
	}

	public Date getDUsFecharegistro() {
		return this.dUsFecharegistro;
	}

	public void setDUsFecharegistro(Date dUsFecharegistro) {
		this.dUsFecharegistro = dUsFecharegistro;
	}

	public SiminMaestro getSiminMaestro() {
		return this.siminMaestro;
	}

	public void setSiminMaestro(SiminMaestro siminMaestro) {
		this.siminMaestro = siminMaestro;
	}
	
	public SiminSistema getSiminSistema() {
		return this.siminSistema;
	}

	public void setSiminSistema(SiminSistema siminSistema) {
		this.siminSistema = siminSistema;
	}
	
	public SiminTipousuario getSiminTipousuario() {
		return this.siminTipousuario;
	}

	public void setSiminTipousuario(SiminTipousuario siminTipousuario) {
		this.siminTipousuario = siminTipousuario;
	}
	
}