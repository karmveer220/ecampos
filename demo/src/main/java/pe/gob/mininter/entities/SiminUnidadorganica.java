package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SIMIN_UNIDADORGANICA database table.
 * 
 */
@Entity
@Table(name="SIMIN_UNIDADORGANICA")
public class SiminUnidadorganica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_UNO_CODIGO")
	private long cUnoCodigo;

	@Column(name="C_PROG_CODIGO")
	private BigDecimal cProgCodigo;

	@Column(name="C_ROF_CODIGO")
	private BigDecimal cRofCodigo;

	@Column(name="C_UBI_CODDEPARTAMENTO")
	private String cUbiCoddepartamento;

	@Column(name="C_UBI_CODDISTRITO")
	private String cUbiCoddistrito;

	@Column(name="C_UBI_CODPROVINCIA")
	private String cUbiCodprovincia;

	@Column(name="C_UE_CODIGO")
	private BigDecimal cUeCodigo;

	@Column(name="C_UNO_CODIGOINTERNO")
	private String cUnoCodigointerno;

	@Column(name="C_UNO_CODIGOPADRE")
	private String cUnoCodigopadre;

	@Column(name="C_UNO_JERARQUIA")
	private BigDecimal cUnoJerarquia;

	@Column(name="C_UNO_USUARIOCREACION")
	private BigDecimal cUnoUsuariocreacion;

	@Column(name="C_UNO_USUARIOMODIFICACION")
	private BigDecimal cUnoUsuariomodificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_UNO_FECHACREACION")
	private Date dUnoFechacreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_UNO_FECHAMODIFICACION")
	private Date dUnoFechamodificacion;

	@Column(name="F_UNO_ESTADO")
	private BigDecimal fUnoEstado;

	@Column(name="F_UNO_POLICIAL")
	private BigDecimal fUnoPolicial;

	private BigDecimal marcacion;

	@Column(name="N_UNO_ABREVIATURA")
	private String nunoAbreviatura;

	@Column(name="N_UNO_DESCRIPCION")
	private String nunoDescripcion;

	@Column(name="N_UNO_GENERAL")
	private String nUnoGeneral;

	@Column(name="N_UNO_GENERAL_ABREV")
	private String nUnoGeneralAbrev;

	@Column(name="N_UNO_JERARQUIA_POI")
	private BigDecimal nUnoJerarquiaPoi;

	@Column(name="N_UNO_SIGLA")
	private String nUnoSigla;

	//bi-directional many-to-one association to SiminMaestro
	@OneToMany(mappedBy="siminUnidadorganica1")
	private List<SiminMaestro> siminMaestros1;

	//bi-directional many-to-one association to SiminMaestro
	@OneToMany(mappedBy="siminUnidadorganica2")
	private List<SiminMaestro> siminMaestros2;
	
	//bi-directional many-to-one association to SiminDirectorio
	@OneToMany(mappedBy="siminUnidadorganica")
	private List<SiminDirectorio> siminDirectorios;

    public SiminUnidadorganica() {
    }

	public long getCUnoCodigo() {
		return this.cUnoCodigo;
	}

	public void setCUnoCodigo(long cUnoCodigo) {
		this.cUnoCodigo = cUnoCodigo;
	}

	public BigDecimal getCProgCodigo() {
		return this.cProgCodigo;
	}

	public void setCProgCodigo(BigDecimal cProgCodigo) {
		this.cProgCodigo = cProgCodigo;
	}

	public BigDecimal getCRofCodigo() {
		return this.cRofCodigo;
	}

	public void setCRofCodigo(BigDecimal cRofCodigo) {
		this.cRofCodigo = cRofCodigo;
	}

	public String getCUbiCoddepartamento() {
		return this.cUbiCoddepartamento;
	}

	public void setCUbiCoddepartamento(String cUbiCoddepartamento) {
		this.cUbiCoddepartamento = cUbiCoddepartamento;
	}

	public String getCUbiCoddistrito() {
		return this.cUbiCoddistrito;
	}

	public void setCUbiCoddistrito(String cUbiCoddistrito) {
		this.cUbiCoddistrito = cUbiCoddistrito;
	}

	public String getCUbiCodprovincia() {
		return this.cUbiCodprovincia;
	}

	public void setCUbiCodprovincia(String cUbiCodprovincia) {
		this.cUbiCodprovincia = cUbiCodprovincia;
	}

	public BigDecimal getCUeCodigo() {
		return this.cUeCodigo;
	}

	public void setCUeCodigo(BigDecimal cUeCodigo) {
		this.cUeCodigo = cUeCodigo;
	}

	public String getCUnoCodigointerno() {
		return this.cUnoCodigointerno;
	}

	public void setCUnoCodigointerno(String cUnoCodigointerno) {
		this.cUnoCodigointerno = cUnoCodigointerno;
	}

	public String getCUnoCodigopadre() {
		return this.cUnoCodigopadre;
	}

	public void setCUnoCodigopadre(String cUnoCodigopadre) {
		this.cUnoCodigopadre = cUnoCodigopadre;
	}

	public BigDecimal getCUnoJerarquia() {
		return this.cUnoJerarquia;
	}

	public void setCUnoJerarquia(BigDecimal cUnoJerarquia) {
		this.cUnoJerarquia = cUnoJerarquia;
	}

	public BigDecimal getCUnoUsuariocreacion() {
		return this.cUnoUsuariocreacion;
	}

	public void setCUnoUsuariocreacion(BigDecimal cUnoUsuariocreacion) {
		this.cUnoUsuariocreacion = cUnoUsuariocreacion;
	}

	public BigDecimal getCUnoUsuariomodificacion() {
		return this.cUnoUsuariomodificacion;
	}

	public void setCUnoUsuariomodificacion(BigDecimal cUnoUsuariomodificacion) {
		this.cUnoUsuariomodificacion = cUnoUsuariomodificacion;
	}

	public Date getDUnoFechacreacion() {
		return this.dUnoFechacreacion;
	}

	public void setDUnoFechacreacion(Date dUnoFechacreacion) {
		this.dUnoFechacreacion = dUnoFechacreacion;
	}

	public Date getDUnoFechamodificacion() {
		return this.dUnoFechamodificacion;
	}

	public void setDUnoFechamodificacion(Date dUnoFechamodificacion) {
		this.dUnoFechamodificacion = dUnoFechamodificacion;
	}

	public BigDecimal getFUnoEstado() {
		return this.fUnoEstado;
	}

	public void setFUnoEstado(BigDecimal fUnoEstado) {
		this.fUnoEstado = fUnoEstado;
	}

	public BigDecimal getFUnoPolicial() {
		return this.fUnoPolicial;
	}

	public void setFUnoPolicial(BigDecimal fUnoPolicial) {
		this.fUnoPolicial = fUnoPolicial;
	}

	public BigDecimal getMarcacion() {
		return this.marcacion;
	}

	public void setMarcacion(BigDecimal marcacion) {
		this.marcacion = marcacion;
	}

	public String getNunoDescripcion() {
		return this.nunoDescripcion;
	}

	public void setNunoDescripcion(String nunoDescripcion) {
		this.nunoDescripcion = nunoDescripcion;
	}
	
	public String getNUnoGeneral() {
		return this.nUnoGeneral;
	}

	public void setNUnoGeneral(String nUnoGeneral) {
		this.nUnoGeneral = nUnoGeneral;
	}

	public String getNUnoGeneralAbrev() {
		return this.nUnoGeneralAbrev;
	}

	public void setNUnoGeneralAbrev(String nUnoGeneralAbrev) {
		this.nUnoGeneralAbrev = nUnoGeneralAbrev;
	}

	public BigDecimal getNUnoJerarquiaPoi() {
		return this.nUnoJerarquiaPoi;
	}

	public void setNUnoJerarquiaPoi(BigDecimal nUnoJerarquiaPoi) {
		this.nUnoJerarquiaPoi = nUnoJerarquiaPoi;
	}

	public String getNUnoSigla() {
		return this.nUnoSigla;
	}

	public void setNUnoSigla(String nUnoSigla) {
		this.nUnoSigla = nUnoSigla;
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

	public List<SiminDirectorio> getSiminDirectorios() {
		return siminDirectorios;
	}

	public void setSiminDirectorios(List<SiminDirectorio> siminDirectorios) {
		this.siminDirectorios = siminDirectorios;
	}

	public String getNunoAbreviatura() {
		return nunoAbreviatura;
	}

	public void setNunoAbreviatura(String nunoAbreviatura) {
		this.nunoAbreviatura = nunoAbreviatura;
	}
}