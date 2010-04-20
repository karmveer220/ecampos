package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Simpasaporte.findAll", 
    query = "select o from Simpasaporte o")
@Table(name = "\"SimPasaporte\"")
public class Simpasaporte implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String sPasNumero;
    private String bColectivo;
    private String bConsular;
    private String bFallaControl;
    private String bManual;
    private String bVencido;
    private Date dFechaAnulacion;
    private Date dFechaEmision;
    private Date dFechaExpiracion;
    private Date dFechaHoraAud;
    private Date dFechaHoraReg;
    private Date dFechaNacimiento;
    private Date dFechaRevalidacion;
    private Date dFechaTramite;
    private Integer nIdMotAnulacion;
    private Integer nIdSesion;
    private Integer nIntentosOCRB;
    private String sEstadoActual;
    private String sIdDepAnu;
    private String sIdDepEmi;
    private String sIdDepRev;
    private String sIdDependencia;
    private String sIdDocumento;
    private String sIdUbigeoNacimiento;
    private String sMaterno;
    private String sNombre;
    private String sNumeroDoc;
    private String sNumeroTramite;
    private String sObservaciones;
    private String sPaterno;
    private String sSexo;
    private String sTipoControl;
    private String sTramiteAnu;
    private String sTramiteEmi;
    private String sTramiteRev;
    /*@OneToMany(mappedBy = "simpasaporte")
    private List<Simpasperu> simpasperuList;
    @OneToMany(mappedBy = "simpasaporte")
    private List<Simimagen> simimagenList;*/
    @ManyToOne
    @JoinColumn(name = "sIdPaisNacimiento", referencedColumnName = "sIdPais")
    private Simpais simpais;

    public Simpasaporte() {
    }

    public String getBColectivo() {
        return bColectivo;
    }

    public void setBColectivo(String bColectivo) {
        this.bColectivo = bColectivo;
    }

    public String getBConsular() {
        return bConsular;
    }

    public void setBConsular(String bConsular) {
        this.bConsular = bConsular;
    }

    public String getBFallaControl() {
        return bFallaControl;
    }

    public void setBFallaControl(String bFallaControl) {
        this.bFallaControl = bFallaControl;
    }

    public String getBManual() {
        return bManual;
    }

    public void setBManual(String bManual) {
        this.bManual = bManual;
    }

    public String getBVencido() {
        return bVencido;
    }

    public void setBVencido(String bVencido) {
        this.bVencido = bVencido;
    }

    public Date getDFechaAnulacion() {
        return dFechaAnulacion;
    }

    public void setDFechaAnulacion(Date dFechaAnulacion) {
        this.dFechaAnulacion = dFechaAnulacion;
    }

    public Date getDFechaEmision() {
        return dFechaEmision;
    }

    public void setDFechaEmision(Date dFechaEmision) {
        this.dFechaEmision = dFechaEmision;
    }

    public Date getDFechaExpiracion() {
        return dFechaExpiracion;
    }

    public void setDFechaExpiracion(Date dFechaExpiracion) {
        this.dFechaExpiracion = dFechaExpiracion;
    }

    public Date getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Date dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Date getDFechaHoraReg() {
        return dFechaHoraReg;
    }

    public void setDFechaHoraReg(Date dFechaHoraReg) {
        this.dFechaHoraReg = dFechaHoraReg;
    }

    public Date getDFechaNacimiento() {
        return dFechaNacimiento;
    }

    public void setDFechaNacimiento(Date dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }

    public Date getDFechaRevalidacion() {
        return dFechaRevalidacion;
    }

    public void setDFechaRevalidacion(Date dFechaRevalidacion) {
        this.dFechaRevalidacion = dFechaRevalidacion;
    }

    public Date getDFechaTramite() {
        return dFechaTramite;
    }

    public void setDFechaTramite(Date dFechaTramite) {
        this.dFechaTramite = dFechaTramite;
    }

    public Integer getNIdMotAnulacion() {
        return nIdMotAnulacion;
    }

    public void setNIdMotAnulacion(Integer nIdMotAnulacion) {
        this.nIdMotAnulacion = nIdMotAnulacion;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public Integer getNIntentosOCRB() {
        return nIntentosOCRB;
    }

    public void setNIntentosOCRB(Integer nIntentosOCRB) {
        this.nIntentosOCRB = nIntentosOCRB;
    }

    public String getSEstadoActual() {
        return sEstadoActual;
    }

    public void setSEstadoActual(String sEstadoActual) {
        this.sEstadoActual = sEstadoActual;
    }

    public String getSIdDepAnu() {
        return sIdDepAnu;
    }

    public void setSIdDepAnu(String sIdDepAnu) {
        this.sIdDepAnu = sIdDepAnu;
    }

    public String getSIdDepEmi() {
        return sIdDepEmi;
    }

    public void setSIdDepEmi(String sIdDepEmi) {
        this.sIdDepEmi = sIdDepEmi;
    }

    public String getSIdDepRev() {
        return sIdDepRev;
    }

    public void setSIdDepRev(String sIdDepRev) {
        this.sIdDepRev = sIdDepRev;
    }

    public String getSIdDependencia() {
        return sIdDependencia;
    }

    public void setSIdDependencia(String sIdDependencia) {
        this.sIdDependencia = sIdDependencia;
    }

    public String getSIdDocumento() {
        return sIdDocumento;
    }

    public void setSIdDocumento(String sIdDocumento) {
        this.sIdDocumento = sIdDocumento;
    }


    public String getSIdUbigeoNacimiento() {
        return sIdUbigeoNacimiento;
    }

    public void setSIdUbigeoNacimiento(String sIdUbigeoNacimiento) {
        this.sIdUbigeoNacimiento = sIdUbigeoNacimiento;
    }

    public String getSMaterno() {
        return sMaterno;
    }

    public void setSMaterno(String sMaterno) {
        this.sMaterno = sMaterno;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getSNumeroDoc() {
        return sNumeroDoc;
    }

    public void setSNumeroDoc(String sNumeroDoc) {
        this.sNumeroDoc = sNumeroDoc;
    }

    public String getSNumeroTramite() {
        return sNumeroTramite;
    }

    public void setSNumeroTramite(String sNumeroTramite) {
        this.sNumeroTramite = sNumeroTramite;
    }

    public String getSObservaciones() {
        return sObservaciones;
    }

    public void setSObservaciones(String sObservaciones) {
        this.sObservaciones = sObservaciones;
    }

    public String getSPasNumero() {
        return sPasNumero;
    }

    public void setSPasNumero(String sPasNumero) {
        this.sPasNumero = sPasNumero;
    }

    public String getSPaterno() {
        return sPaterno;
    }

    public void setSPaterno(String sPaterno) {
        this.sPaterno = sPaterno;
    }

    public String getSSexo() {
        return sSexo;
    }

    public void setSSexo(String sSexo) {
        this.sSexo = sSexo;
    }

    public String getSTipoControl() {
        return sTipoControl;
    }

    public void setSTipoControl(String sTipoControl) {
        this.sTipoControl = sTipoControl;
    }

    public String getSTramiteAnu() {
        return sTramiteAnu;
    }

    public void setSTramiteAnu(String sTramiteAnu) {
        this.sTramiteAnu = sTramiteAnu;
    }

    public String getSTramiteEmi() {
        return sTramiteEmi;
    }

    public void setSTramiteEmi(String sTramiteEmi) {
        this.sTramiteEmi = sTramiteEmi;
    }

    public String getSTramiteRev() {
        return sTramiteRev;
    }

    public void setSTramiteRev(String sTramiteRev) {
        this.sTramiteRev = sTramiteRev;
    }

  /*  public List<Simpasperu> getSimpasperuList() {
        return simpasperuList;
    }

    public void setSimpasperuList(List<Simpasperu> simpasperuList) {
        this.simpasperuList = simpasperuList;
    }

    public Simpasperu addSimpasperu(Simpasperu simpasperu) {
        getSimpasperuList().add(simpasperu);
        simpasperu.setSimpasaporte(this);
        return simpasperu;
    }

    public Simpasperu removeSimpasperu(Simpasperu simpasperu) {
        getSimpasperuList().remove(simpasperu);
        simpasperu.setSimpasaporte(null);
        return simpasperu;
    }

    public List<Simimagen> getSimimagenList() {
        return simimagenList;
    }

    public void setSimimagenList(List<Simimagen> simimagenList) {
        this.simimagenList = simimagenList;
    }

    public Simimagen addSimimagen(Simimagen simimagen) {
        getSimimagenList().add(simimagen);
        simimagen.setSimpasaporte(this);
        return simimagen;
    }

    public Simimagen removeSimimagen(Simimagen simimagen) {
        getSimimagenList().remove(simimagen);
        simimagen.setSimpasaporte(null);
        return simimagen;
    }*/

    public Simpais getSimpais() {
        return simpais;
    }

    public void setSimpais(Simpais simpais) {
        this.simpais = simpais;
    }
}
