package pe.gob.mininter.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import pe.gob.mininter.utiles.Utiles;


/**
 * The persistent class for the SIMIN_MAESTRO database table.
 * 
 */
@Entity
@Table(name="SIMIN_MAESTRO")
public class SiminMaestro extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private List<Authorities> authoritiesList;
	
	@Transient
	private String funcionEmp;
	
	@Id
	@Column(name="C_PERL_CODIGO")
	private long cperlCodigo;

	@Column(name="C_AGEN_CODIGO")
	private BigDecimal cAgenCodigo;

	@Column(name="C_BANC_CODIGO")
	private BigDecimal cBancCodigo;

	@Column(name="C_CAR_CODIGO")
	private String cCarCodigo;

	@Column(name="C_DEXT_CODIGO")
	private BigDecimal cDextCodigo;

	@Column(name="C_ENC_CODIGO")
	private String cEncCodigo;

	@Column(name="C_ESTC_CODIGO")
	private String cEstcCodigo;

	@Column(name="C_FUN_CODIGO")
	private BigDecimal cFunCodigo;

	@Column(name="C_GOCU_CODIGO")
	private BigDecimal cGocuCodigo;

	@Column(name="C_GRA_CODIGO")
	private String cGraCodigo;

	@Column(name="C_GRIM_CODIGO")
	private String cGrimCodigo;

	@Column(name="C_MST_COD_DOMI")
	private String cMstCodDomi;

	@Column(name="C_MST_CODIGO")
	private String cMstCodigo;

	@Column(name="C_MST_DOMICILIO_DEP")
	private String cMstDomicilioDep;

	@Column(name="C_MST_DOMICILIO_DIS")
	private String cMstDomicilioDis;

	@Column(name="C_MST_DOMICILIO_PROV")
	private String cMstDomicilioProv;

	@Column(name="C_MST_LUGNACIM_DEP")
	private String cMstLugnacimDep;

	@Column(name="C_MST_LUGNACIM_DIS")
	private String cMstLugnacimDis;

	@Column(name="C_MST_LUGNACIM_PROV")
	private String cMstLugnacimProv;

	@Column(name="C_MST_NUM_PLAZA")
	private String cMstNumPlaza;

	@Column(name="C_MST_USUARIOMODIFICACION")
	private String cMstUsuariomodificacion;

	@Column(name="C_MST_USUARIOREGISTRO")
	private String cMstUsuarioregistro;

	@Column(name="C_PROF_CODIGO")
	private String cProfCodigo;

	@Column(name="C_SIT_CODIGO")
	private String cSitCodigo;

	@Column(name="C_SITE_CODIGO")
	private String cSiteCodigo;

	@Column(name="C_SPEN_CODIGO")
	private String cSpenCodigo;

	@Column(name="C_TING_CODIGO")
	private String ctingCodigo;

	@Column(name="C_TINGC_CODIGO")
	private String cTingcCodigo;

	@Column(name="C_TPLAN_CODIGO")
	private BigDecimal cTplanCodigo;

	@Column(name="C_TUR_CODIGO")
	private String cTurCodigo;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_CESE")
	private Date dMstCese;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_FEC_AFILIACION")
	private Date dMstFecAfiliacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_FECH_ADM")
	private Date dMstFechAdm;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_FECH_MIN")
	private Date dMstFechMin;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_FECH_RES")
	private Date dMstFechRes;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_FECHAMODIFICACION")
	private Date dMstFechamodificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_FECHANACIMIENTO")
	private Date dmstFechanacimiento;

    @Temporal( TemporalType.DATE)
	@Column(name="D_MST_FECHAREGISTRO")
	private Date dMstFecharegistro;

	@Column(name="F_MST_PRIMERAVEZ")
	private BigDecimal fMstPrimeravez;

	@Column(name="M_MST_CELULAR")
	private String mMstCelular;

	@Column(name="M_MST_RUC")
	private String mMstRuc;

	@Column(name="M_MST_TELEFONO")
	private String mMstTelefono;

	@Column(name="N_MST_ACCEMAIL")
	private String nMstAccemail;

	@Column(name="N_MST_ACCINTERNET")
	private String nMstAccinternet;

	@Column(name="N_MST_APEMATERNO")
	private String nMstApematerno;

	@Column(name="N_MST_APEPATERNO")
	private String nMstApepaterno;

	@Column(name="N_MST_CLAVE")
	private String nMstClave;

	@Column(name="N_MST_DNI")
	private String nMstDni;

	@Column(name="N_MST_DOMICILIO")
	private String nMstDomicilio;

	@Email 
	@Column(name="N_MST_EMAIL")
	private String nmstEmail;

	@Column(name="N_MST_EMAIL_PERSONAL")
	private String nMstEmailPersonal;

	@Column(name="N_MST_IPSS")
	private String nMstIpss;

	@Column(name="N_MST_LM")
	private String nMstLm;

	@Column(name="N_MST_LOGIN")
	private String nmstLogin;

	@Column(name="N_MST_LT")
	private String nMstLt;

	@Column(name="N_MST_LUGARNACIMIENTO")
	private String nMstLugarnacimiento;

	@Column(name="N_MST_MOT_CESE")
	private String nMstMotCese;

	@Column(name="N_MST_NAFP")
	private String nMstNafp;

	@Column(name="N_MST_NOMBRE")
	private String nMstNombre;

	@Column(name="N_MST_NRO_RES")
	private String nMstNroRes;

	@Column(name="N_MST_NRO_RES_CESE")
	private String nMstNroResCese;

	@Column(name="N_MST_NUM_HIJOS")
	private String nMstNumHijos;

	@Column(name="N_MST_QUINQUENIO")
	private String nMstQuinquenio;

	@Column(name="N_MST_SANGRE")
	private String nMstSangre;

	@Column(name="N_MST_SEXO")
	private String nMstSexo;

	@Column(name="N_MST_SUELDO")
	private String nMstSueldo;

	@Column(name="N_MST_TELEBAN")
	private String nMstTeleban;

	@Column(name="N_MST_TSERV")
	private String nMstTserv;

	//bi-directional many-to-one association to SiminUnidadorganica
    @ManyToOne
	@JoinColumn(name="C_UNO_CODIGO_OF_DESTAQUE")
	private SiminUnidadorganica siminUnidadorganica1;

	//bi-directional many-to-one association to SiminUnidadorganica
    @ManyToOne
	@JoinColumn(name="C_UNO_CODIGO_OFICINA")
	private SiminUnidadorganica siminUnidadorganica2;

	//bi-directional many-to-one association to SiminUsuariosistema
	@OneToMany(mappedBy="siminMaestro")
	private List<SiminUsuariosistema> siminUsuariosistemas;
	
	//bi-directional many-to-one association to SiminGrado
    @ManyToOne
	@JoinColumn(name="C_ENC_CODIGO", insertable = false, updatable = false)
	private SiminGrado siminGrado1;

	//bi-directional many-to-one association to SiminGrado
    @ManyToOne
	@JoinColumn(name="C_GRA_CODIGO", insertable = false, updatable = false)
	private SiminGrado siminGrado2;
    
    @OneToMany(mappedBy="siminMaestro")
	private List<SiminCorreo> siminCorreos;

	//Valores Propios
	@Transient
	private String ipPublica;
	
	@Transient
	private String ipPrivada;

	public SiminMaestro(String username, String password, boolean enabled,Collection<GrantedAuthority> authorities) {
		super(username, password, enabled, true, true, true, authorities);
		this.cSitCodigo = enabled==true ? "1" : "0";
		this.nmstLogin = username;
		this.nMstClave = password;
	}
	
	public SiminMaestro(Long cperlCodigo, String username, String password, boolean enabled,List<GrantedAuthority> authorities,
			String usrnombrevh,String usrapepaternovh, String usrapematernovh,
			Date usrfechanacimientodt,String estado, String nunoDescripcion, String ctingCodigo, String nunoGeneralAbrev, String nmstEmail) {
		super(username, password, enabled, true, true, true, authorities);
		this.cperlCodigo = cperlCodigo;
		this.nmstLogin = username;
		//this.nMstClave = password;
		this.nMstNombre=usrnombrevh;
		this.nMstApepaterno= usrapepaternovh;
		this.nMstApematerno = usrapematernovh;
	    this.dmstFechanacimiento = usrfechanacimientodt;
	    this.cSitCodigo = estado;
	    this.siminUnidadorganica1 = new SiminUnidadorganica();
	    this.siminUnidadorganica1.setNunoDescripcion(nunoDescripcion);
	    this.siminUnidadorganica1.setNunoGeneralAbrev(nunoGeneralAbrev);
	    this.ctingCodigo = ctingCodigo;
	    this.nmstEmail = nmstEmail;
	}
	
	
	public SiminMaestro(Long cperlCodigo ,String usrnombrevh,String usrapepaternovh, String usrapematernovh, 
			String nunoDescripcion, Date usrfechanacimientodt, String ngraNombre, String funcionEmp, String ctingCodigo, String nunoAbreviatura) {
		super("m", "e", true, true, true, true, uno());
		
		this.nMstNombre=usrnombrevh;
		this.nMstApepaterno= usrapepaternovh;
		this.nMstApematerno = usrapematernovh;
	    this.cperlCodigo = cperlCodigo;
	    this.siminUnidadorganica1 = new SiminUnidadorganica();
        this.siminUnidadorganica1.setNunoDescripcion(nunoDescripcion);
        this.siminUnidadorganica1.setNunoAbreviatura(nunoAbreviatura);
        this.siminGrado2 = new SiminGrado();
        this.siminGrado2.setNgraNombre(ngraNombre);
        this.dmstFechanacimiento = usrfechanacimientodt;
        this.funcionEmp = funcionEmp;
	    this.ctingCodigo = ctingCodigo;
	    
	}
	

	public static SiminMaestro getUsuarioBean() {
		SiminMaestro nu = (SiminMaestro)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		//LdapUserDetailsImpl uu = null;
		if(nu != null) {
			return nu;
		}
		else return null;
	}
	 public SiminMaestro() {		
			super("default", "default", true, true, true, true , uno() );		
		}


	public static List<GrantedAuthority> uno(){
			List<GrantedAuthority> oo = new ArrayList<GrantedAuthority>(); 
			oo.add(new GrantedAuthorityImpl("IS_AUTHENTICATED_ANONYMOUSLY") );
			return oo;
	}

	public long getCperlCodigo() {
		return cperlCodigo;
	}

	public void setCperlCodigo(long cperlCodigo) {
		this.cperlCodigo = cperlCodigo;
	}

	public BigDecimal getCAgenCodigo() {
		return this.cAgenCodigo;
	}

	public void setCAgenCodigo(BigDecimal cAgenCodigo) {
		this.cAgenCodigo = cAgenCodigo;
	}

	public BigDecimal getCBancCodigo() {
		return this.cBancCodigo;
	}

	public void setCBancCodigo(BigDecimal cBancCodigo) {
		this.cBancCodigo = cBancCodigo;
	}

	public String getCCarCodigo() {
		return this.cCarCodigo;
	}

	public void setCCarCodigo(String cCarCodigo) {
		this.cCarCodigo = cCarCodigo;
	}

	public BigDecimal getCDextCodigo() {
		return this.cDextCodigo;
	}

	public void setCDextCodigo(BigDecimal cDextCodigo) {
		this.cDextCodigo = cDextCodigo;
	}

	public String getCEncCodigo() {
		return this.cEncCodigo;
	}

	public void setCEncCodigo(String cEncCodigo) {
		this.cEncCodigo = cEncCodigo;
	}

	public String getCEstcCodigo() {
		return this.cEstcCodigo;
	}

	public void setCEstcCodigo(String cEstcCodigo) {
		this.cEstcCodigo = cEstcCodigo;
	}

	public BigDecimal getCFunCodigo() {
		return this.cFunCodigo;
	}

	public void setCFunCodigo(BigDecimal cFunCodigo) {
		this.cFunCodigo = cFunCodigo;
	}

	public BigDecimal getCGocuCodigo() {
		return this.cGocuCodigo;
	}

	public void setCGocuCodigo(BigDecimal cGocuCodigo) {
		this.cGocuCodigo = cGocuCodigo;
	}

	public String getCGraCodigo() {
		return this.cGraCodigo;
	}

	public void setCGraCodigo(String cGraCodigo) {
		this.cGraCodigo = cGraCodigo;
	}

	public String getCGrimCodigo() {
		return this.cGrimCodigo;
	}

	public void setCGrimCodigo(String cGrimCodigo) {
		this.cGrimCodigo = cGrimCodigo;
	}

	public String getCMstCodDomi() {
		return this.cMstCodDomi;
	}

	public void setCMstCodDomi(String cMstCodDomi) {
		this.cMstCodDomi = cMstCodDomi;
	}

	public String getCMstCodigo() {
		return this.cMstCodigo;
	}

	public void setCMstCodigo(String cMstCodigo) {
		this.cMstCodigo = cMstCodigo;
	}

	public String getCMstDomicilioDep() {
		return this.cMstDomicilioDep;
	}

	public void setCMstDomicilioDep(String cMstDomicilioDep) {
		this.cMstDomicilioDep = cMstDomicilioDep;
	}

	public String getCMstDomicilioDis() {
		return this.cMstDomicilioDis;
	}

	public void setCMstDomicilioDis(String cMstDomicilioDis) {
		this.cMstDomicilioDis = cMstDomicilioDis;
	}

	public String getCMstDomicilioProv() {
		return this.cMstDomicilioProv;
	}

	public void setCMstDomicilioProv(String cMstDomicilioProv) {
		this.cMstDomicilioProv = cMstDomicilioProv;
	}

	public String getCMstLugnacimDep() {
		return this.cMstLugnacimDep;
	}

	public void setCMstLugnacimDep(String cMstLugnacimDep) {
		this.cMstLugnacimDep = cMstLugnacimDep;
	}

	public String getCMstLugnacimDis() {
		return this.cMstLugnacimDis;
	}

	public void setCMstLugnacimDis(String cMstLugnacimDis) {
		this.cMstLugnacimDis = cMstLugnacimDis;
	}

	public String getCMstLugnacimProv() {
		return this.cMstLugnacimProv;
	}

	public void setCMstLugnacimProv(String cMstLugnacimProv) {
		this.cMstLugnacimProv = cMstLugnacimProv;
	}

	public String getCMstNumPlaza() {
		return this.cMstNumPlaza;
	}

	public void setCMstNumPlaza(String cMstNumPlaza) {
		this.cMstNumPlaza = cMstNumPlaza;
	}

	public String getCMstUsuariomodificacion() {
		return this.cMstUsuariomodificacion;
	}

	public void setCMstUsuariomodificacion(String cMstUsuariomodificacion) {
		this.cMstUsuariomodificacion = cMstUsuariomodificacion;
	}

	public String getCMstUsuarioregistro() {
		return this.cMstUsuarioregistro;
	}

	public void setCMstUsuarioregistro(String cMstUsuarioregistro) {
		this.cMstUsuarioregistro = cMstUsuarioregistro;
	}

	public String getCProfCodigo() {
		return this.cProfCodigo;
	}

	public void setCProfCodigo(String cProfCodigo) {
		this.cProfCodigo = cProfCodigo;
	}

	public String getCSitCodigo() {
		return this.cSitCodigo;
	}

	public void setCSitCodigo(String cSitCodigo) {
		this.cSitCodigo = cSitCodigo;
	}

	public String getCSiteCodigo() {
		return this.cSiteCodigo;
	}

	public void setCSiteCodigo(String cSiteCodigo) {
		this.cSiteCodigo = cSiteCodigo;
	}

	public String getCSpenCodigo() {
		return this.cSpenCodigo;
	}

	public void setCSpenCodigo(String cSpenCodigo) {
		this.cSpenCodigo = cSpenCodigo;
	}

	public String getCTingcCodigo() {
		return this.cTingcCodigo;
	}

	public void setCTingcCodigo(String cTingcCodigo) {
		this.cTingcCodigo = cTingcCodigo;
	}

	public BigDecimal getCTplanCodigo() {
		return this.cTplanCodigo;
	}

	public void setCTplanCodigo(BigDecimal cTplanCodigo) {
		this.cTplanCodigo = cTplanCodigo;
	}

	public String getCTurCodigo() {
		return this.cTurCodigo;
	}

	public void setCTurCodigo(String cTurCodigo) {
		this.cTurCodigo = cTurCodigo;
	}

	public Date getDMstCese() {
		return this.dMstCese;
	}

	public void setDMstCese(Date dMstCese) {
		this.dMstCese = dMstCese;
	}

	public Date getDMstFecAfiliacion() {
		return this.dMstFecAfiliacion;
	}

	public void setDMstFecAfiliacion(Date dMstFecAfiliacion) {
		this.dMstFecAfiliacion = dMstFecAfiliacion;
	}

	public Date getDMstFechAdm() {
		return this.dMstFechAdm;
	}

	public void setDMstFechAdm(Date dMstFechAdm) {
		this.dMstFechAdm = dMstFechAdm;
	}

	public Date getDMstFechMin() {
		return this.dMstFechMin;
	}

	public void setDMstFechMin(Date dMstFechMin) {
		this.dMstFechMin = dMstFechMin;
	}

	public Date getDMstFechRes() {
		return this.dMstFechRes;
	}

	public void setDMstFechRes(Date dMstFechRes) {
		this.dMstFechRes = dMstFechRes;
	}

	public Date getDMstFechamodificacion() {
		return this.dMstFechamodificacion;
	}

	public void setDMstFechamodificacion(Date dMstFechamodificacion) {
		this.dMstFechamodificacion = dMstFechamodificacion;
	}

	public Date getDmstFechanacimiento() {
		return dmstFechanacimiento;
	}

	public void setDmstFechanacimiento(Date dmstFechanacimiento) {
		this.dmstFechanacimiento = dmstFechanacimiento;
	}

	public Date getDMstFecharegistro() {
		return this.dMstFecharegistro;
	}	

	public void setDMstFecharegistro(Date dMstFecharegistro) {
		this.dMstFecharegistro = dMstFecharegistro;
	}

	public BigDecimal getFMstPrimeravez() {
		return this.fMstPrimeravez;
	}

	public void setFMstPrimeravez(BigDecimal fMstPrimeravez) {
		this.fMstPrimeravez = fMstPrimeravez;
	}

	public String getMMstCelular() {
		return this.mMstCelular;
	}

	public void setMMstCelular(String mMstCelular) {
		this.mMstCelular = mMstCelular;
	}

	public String getMMstRuc() {
		return this.mMstRuc;
	}

	public void setMMstRuc(String mMstRuc) {
		this.mMstRuc = mMstRuc;
	}

	public String getMMstTelefono() {
		return this.mMstTelefono;
	}

	public void setMMstTelefono(String mMstTelefono) {
		this.mMstTelefono = mMstTelefono;
	}

	public String getNMstAccinternet() {
		return this.nMstAccinternet;
	}

	public void setNMstAccinternet(String nMstAccinternet) {
		this.nMstAccinternet = nMstAccinternet;
	}

	public String getNMstApematerno() {
		return this.nMstApematerno;
	}

	public void setNMstApematerno(String nMstApematerno) {
		this.nMstApematerno = nMstApematerno;
	}

	public String getNMstApepaterno() {
		return this.nMstApepaterno;
	}

	public void setNMstApepaterno(String nMstApepaterno) {
		this.nMstApepaterno = nMstApepaterno;
	}

	public String getNMstClave() {
		return this.nMstClave;
	}

	public void setNMstClave(String nMstClave) {
		this.nMstClave = nMstClave;
	}

	public String getNMstDni() {
		return this.nMstDni;
	}

	public void setNMstDni(String nMstDni) {
		this.nMstDni = nMstDni;
	}

	public String getNMstDomicilio() {
		return this.nMstDomicilio;
	}

	public void setNMstDomicilio(String nMstDomicilio) {
		this.nMstDomicilio = nMstDomicilio;
	}	

	public String getNMstEmailPersonal() {
		return this.nMstEmailPersonal;
	}

	public void setNMstEmailPersonal(String nMstEmailPersonal) {
		this.nMstEmailPersonal = nMstEmailPersonal;
	}

	public String getNMstIpss() {
		return this.nMstIpss;
	}

	public void setNMstIpss(String nMstIpss) {
		this.nMstIpss = nMstIpss;
	}

	public String getNMstLm() {
		return this.nMstLm;
	}

	public void setNMstLm(String nMstLm) {
		this.nMstLm = nMstLm;
	}
	
	public String getNmstLogin() {
		return nmstLogin;
	}

	public void setNmstLogin(String nmstLogin) {
		this.nmstLogin = nmstLogin;
	}	

	public String getNMstLt() {
		return this.nMstLt;
	}

	public void setNMstLt(String nMstLt) {
		this.nMstLt = nMstLt;
	}

	public String getNMstLugarnacimiento() {
		return this.nMstLugarnacimiento;
	}

	public void setNMstLugarnacimiento(String nMstLugarnacimiento) {
		this.nMstLugarnacimiento = nMstLugarnacimiento;
	}

	public String getNMstMotCese() {
		return this.nMstMotCese;
	}

	public void setNMstMotCese(String nMstMotCese) {
		this.nMstMotCese = nMstMotCese;
	}

	public String getNMstNafp() {
		return this.nMstNafp;
	}

	public void setNMstNafp(String nMstNafp) {
		this.nMstNafp = nMstNafp;
	}

	public String getNMstNombre() {
		return this.nMstNombre;
	}

	public void setNMstNombre(String nMstNombre) {
		this.nMstNombre = nMstNombre;
	}

	public String getNMstNroRes() {
		return this.nMstNroRes;
	}

	public void setNMstNroRes(String nMstNroRes) {
		this.nMstNroRes = nMstNroRes;
	}

	public String getNMstNroResCese() {
		return this.nMstNroResCese;
	}

	public void setNMstNroResCese(String nMstNroResCese) {
		this.nMstNroResCese = nMstNroResCese;
	}

	public String getNMstNumHijos() {
		return this.nMstNumHijos;
	}

	public void setNMstNumHijos(String nMstNumHijos) {
		this.nMstNumHijos = nMstNumHijos;
	}

	public String getNMstQuinquenio() {
		return this.nMstQuinquenio;
	}

	public void setNMstQuinquenio(String nMstQuinquenio) {
		this.nMstQuinquenio = nMstQuinquenio;
	}

	public String getNMstSangre() {
		return this.nMstSangre;
	}

	public void setNMstSangre(String nMstSangre) {
		this.nMstSangre = nMstSangre;
	}

	public String getNMstSexo() {
		return this.nMstSexo;
	}

	public void setNMstSexo(String nMstSexo) {
		this.nMstSexo = nMstSexo;
	}

	public String getNMstSueldo() {
		return this.nMstSueldo;
	}

	public void setNMstSueldo(String nMstSueldo) {
		this.nMstSueldo = nMstSueldo;
	}

	public String getNMstTeleban() {
		return this.nMstTeleban;
	}

	public void setNMstTeleban(String nMstTeleban) {
		this.nMstTeleban = nMstTeleban;
	}

	public String getNMstTserv() {
		return this.nMstTserv;
	}

	public void setNMstTserv(String nMstTserv) {
		this.nMstTserv = nMstTserv;
	}

	public SiminUnidadorganica getSiminUnidadorganica1() {
		return this.siminUnidadorganica1;
	}

	public void setSiminUnidadorganica1(SiminUnidadorganica siminUnidadorganica1) {
		this.siminUnidadorganica1 = siminUnidadorganica1;
	}
	
	public SiminUnidadorganica getSiminUnidadorganica2() {
		return this.siminUnidadorganica2;
	}

	public void setSiminUnidadorganica2(SiminUnidadorganica siminUnidadorganica2) {
		this.siminUnidadorganica2 = siminUnidadorganica2;
	}
	
	public List<SiminUsuariosistema> getSiminUsuariosistemas() {
		return this.siminUsuariosistemas;
	}

	public void setSiminUsuariosistemas(List<SiminUsuariosistema> siminUsuariosistemas) {
		this.siminUsuariosistemas = siminUsuariosistemas;
	}

	public List<Authorities> getAuthoritiesList() {
		return authoritiesList;
	}

	public void setAuthoritiesList(List<Authorities> authoritiesList) {
		this.authoritiesList = authoritiesList;
	}
	
	public String getIpPublica() {
		return ipPublica;
	}

	public void setIpPublica(String ipPublica) {
		this.ipPublica = ipPublica;
	}

	public String getIpPrivada() {
		return ipPrivada;
	}

	public void setIpPrivada(String ipPrivada) {
		this.ipPrivada = ipPrivada;
	}
	
	public SiminGrado getSiminGrado1() {
		return this.siminGrado1;
	}

	public void setSiminGrado1(SiminGrado siminGrado1) {
		this.siminGrado1 = siminGrado1;
	}
	
	public SiminGrado getSiminGrado2() {
		return this.siminGrado2;
	}

	public void setSiminGrado2(SiminGrado siminGrado2) {
		this.siminGrado2 = siminGrado2;
	}

	public String getFuncionEmp() {
		return funcionEmp;
	}

	public void setFuncionEmp(String funcionEmp) {
		this.funcionEmp = funcionEmp;
	}

	public String getCtingCodigo() {
		return ctingCodigo;
	}

	public void setCtingCodigo(String ctingCodigo) {
		this.ctingCodigo = ctingCodigo;
	}
	
	public List<SiminCorreo> getSiminCorreos() {
		return this.siminCorreos;
	}

	public void setSiminCorreos(List<SiminCorreo> siminCorreos) {
		this.siminCorreos = siminCorreos;
	}

	public String getNmstEmail() {
		return nmstEmail;
	}

	public void setNmstEmail(String nmstEmail) {
		this.nmstEmail = nmstEmail;
	}

	@Transient
	public String getNombreCompleto(){
		String nombreCompleto = nMstNombre + " " + nMstApepaterno + " " + nMstApematerno;
		return Utiles.primeraMayuscula(nombreCompleto.toLowerCase());
	}
	
}