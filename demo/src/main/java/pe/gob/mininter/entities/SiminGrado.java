package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the SIMIN_GRADO database table.
 * 
 */
@Entity
@Table(name="SIMIN_GRADO")
public class SiminGrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_GRA_CODIGO")
	private String cGraCodigo;

	@Column(name="C_GRA_USUARIOMODIFICACION")
	private String cGraUsuariomodificacion;

	@Column(name="C_GRA_USUARIOREGISTRO")
	private String cGraUsuarioregistro;

	@Column(name="C_TGR_CODIGO")
	private String cTgrCodigo;

    @Temporal( TemporalType.DATE)
	@Column(name="D_GRA_FECHAMODIFICACION")
	private Date dGraFechamodificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_GRA_FECHAREGISTRO")
	private Date dGraFecharegistro;

	@Column(name="F_GRA_ESTADO")
	private BigDecimal fGraEstado;

	@Column(name="N_GRA_CATEGORIA")
	private String nGraCategoria;

	@Column(name="N_GRA_NOMBRE")
	private String ngraNombre;

	//bi-directional many-to-one association to SiminMaestro
	@OneToMany(mappedBy="siminGrado1")
	private List<SiminMaestro> siminMaestros1;

	//bi-directional many-to-one association to SiminMaestro
	@OneToMany(mappedBy="siminGrado2")
	private List<SiminMaestro> siminMaestros2;

    public SiminGrado() {
    }

	public String getCGraCodigo() {
		return this.cGraCodigo;
	}

	public void setCGraCodigo(String cGraCodigo) {
		this.cGraCodigo = cGraCodigo;
	}

	public String getCGraUsuariomodificacion() {
		return this.cGraUsuariomodificacion;
	}

	public void setCGraUsuariomodificacion(String cGraUsuariomodificacion) {
		this.cGraUsuariomodificacion = cGraUsuariomodificacion;
	}

	public String getCGraUsuarioregistro() {
		return this.cGraUsuarioregistro;
	}

	public void setCGraUsuarioregistro(String cGraUsuarioregistro) {
		this.cGraUsuarioregistro = cGraUsuarioregistro;
	}

	public String getCTgrCodigo() {
		return this.cTgrCodigo;
	}

	public void setCTgrCodigo(String cTgrCodigo) {
		this.cTgrCodigo = cTgrCodigo;
	}

	public Date getDGraFechamodificacion() {
		return this.dGraFechamodificacion;
	}

	public void setDGraFechamodificacion(Date dGraFechamodificacion) {
		this.dGraFechamodificacion = dGraFechamodificacion;
	}

	public Date getDGraFecharegistro() {
		return this.dGraFecharegistro;
	}

	public void setDGraFecharegistro(Date dGraFecharegistro) {
		this.dGraFecharegistro = dGraFecharegistro;
	}

	public BigDecimal getFGraEstado() {
		return this.fGraEstado;
	}

	public void setFGraEstado(BigDecimal fGraEstado) {
		this.fGraEstado = fGraEstado;
	}

	public String getNGraCategoria() {
		return this.nGraCategoria;
	}

	public void setNGraCategoria(String nGraCategoria) {
		this.nGraCategoria = nGraCategoria;
	}	

	public List<SiminMaestro> getSiminMaestros1() {
		return this.siminMaestros1;
	}

	public void setSiminMaestros1(List<SiminMaestro> siminMaestros1) {
		this.siminMaestros1 = siminMaestros1;
	}
	
	public List<SiminMaestro> getSiminMaestros2() {
		return this.siminMaestros2;
	}

	public void setSiminMaestros2(List<SiminMaestro> siminMaestros2) {
		this.siminMaestros2 = siminMaestros2;
	}

	public String getNgraNombre() {
		return ngraNombre;
	}

	public void setNgraNombre(String ngraNombre) {
		this.ngraNombre = ngraNombre;
	}
	
}