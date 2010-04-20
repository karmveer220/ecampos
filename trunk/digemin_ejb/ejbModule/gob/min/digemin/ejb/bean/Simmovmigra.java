package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
@Entity
@NamedQuery(name = "Simmovmigra.findAll", 
    query = "select o from Simmovmigra o")
@Table(name = "\"SimMovMigra\"")
public class Simmovmigra implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bAnulado;
    private String bExpulsion;
    private String bMigrado;
    private String bTemporal;
    private String bTiempoReal;
    private Calendar dConsRq;
    private Calendar dFechaControl;
    private Calendar dFechaDigita;
    private Calendar dFechaHoraAud;
    private Calendar dRptaRq;
    private String nGastos;
    private Integer nIdEstacionDigita;
    private Integer nIdMotivoViaje;
    private Integer nIdOperadorDigita;
    private Integer nIdSesion;
    private Integer nIdTipoAlojamiento;
    private Integer nIdTransportista;
    private Integer nIdTurnoOperador;
    private Integer nPermanencia;
    private String sContadorRq;
    private String sDireccionDestino;
    private String sEstadoRq;
    private String sIdDepDigita;
    private String sIdDependencia;
    //private String sIdDocControl;
    //private String sIdDocumento;
    private String sIdEstadoCivil;
    private String sIdItinerario;
    private String sIdModuloDigita;
    @Id
    private String sIdMovMigratorio;
    private String sIdPaisNacimiento;
    private String sIdPaisResidencia;
    private String sIdParteDiario;
    private String sIdProfesion;
    private String sIdViaTransporte;
    private String sNombres;
    private String sNumDocControl;
    private String sNumeroDoc;
    private String sObservaciones;
    private String sPagoPermOk;
    private String sTipo;
    private String sTipoUnidad;
    @ManyToOne
    @JoinColumn(name = "uIdPersona", referencedColumnName = "uIdPersona")
    private Simpersona simpersona;
    @ManyToOne
    @JoinColumn(name = "sIdPaisNacionalidad", referencedColumnName = "sIdPais")
    private Simpais simpais;
    @ManyToOne
    @JoinColumn(name = "sIdPaisMov", referencedColumnName = "sIdPais")
    private Simpais simpais1;
    @ManyToOne
    @JoinColumn(name = "nIdCalidad", referencedColumnName = "nIdCalidad")
    private Simcalidadmigratoria simcalidadmigratoria;
    @ManyToOne
    @JoinColumn(name = "sIdDocControl", referencedColumnName = "sIdDocumento")
    private Simdocumento simdocumento;
    @ManyToOne
    @JoinColumn(name = "sIdDocumento", referencedColumnName = "sIdDocumento")
    private Simdocumento simdocumento1;
   
    public Simmovmigra() {
    }
    /**
     * Documento de control
     * @return
     */
    public Simdocumento getSimdocumento() {
       return simdocumento;
   }
    
    /**
     * documento de control
     * @param simdocumento
     */
   public void setSimdocumento(Simdocumento simdocumento) {
       this.simdocumento = simdocumento;
   }
   /**
     * Id de documento
     * @return
     */
    public Simdocumento getSimdocumento1() {
        return simdocumento1;
    }
    /**
     * id de documento
     * @param simdocumento1
     */
    public void setSimdocumento1(Simdocumento simdocumento1) {
        this.simdocumento1 = simdocumento1;
    }
    public String getBAnulado() {
        return bAnulado;
    }

    public void setBAnulado(String bAnulado) {
        this.bAnulado = bAnulado;
    }

    public String getBExpulsion() {
        return bExpulsion;
    }

    public void setBExpulsion(String bExpulsion) {
        this.bExpulsion = bExpulsion;
    }

    public String getBMigrado() {
        return bMigrado;
    }

    public void setBMigrado(String bMigrado) {
        this.bMigrado = bMigrado;
    }

    public String getBTemporal() {
        return bTemporal;
    }

    public void setBTemporal(String bTemporal) {
        this.bTemporal = bTemporal;
    }

    public String getBTiempoReal() {
        return bTiempoReal;
    }

    public void setBTiempoReal(String bTiempoReal) {
        this.bTiempoReal = bTiempoReal;
    }

    public Calendar getDConsRq() {
        return dConsRq;
    }

    public void setDConsRq(Calendar dConsRq) {
        this.dConsRq = dConsRq;
    }

    public Calendar getDFechaControl() {
        return dFechaControl;
    }

    public void setDFechaControl(Calendar dFechaControl) {
        this.dFechaControl = dFechaControl;
    }

    public Calendar getDFechaDigita() {
        return dFechaDigita;
    }

    public void setDFechaDigita(Calendar dFechaDigita) {
        this.dFechaDigita = dFechaDigita;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Calendar getDRptaRq() {
        return dRptaRq;
    }

    public void setDRptaRq(Calendar dRptaRq) {
        this.dRptaRq = dRptaRq;
    }

    public String getNGastos() {
        return nGastos;
    }

    public void setNGastos(String nGastos) {
        this.nGastos = nGastos;
    }


    public Integer getNIdEstacionDigita() {
        return nIdEstacionDigita;
    }

    public void setNIdEstacionDigita(Integer nIdEstacionDigita) {
        this.nIdEstacionDigita = nIdEstacionDigita;
    }

    public Integer getNIdMotivoViaje() {
        return nIdMotivoViaje;
    }

    public void setNIdMotivoViaje(Integer nIdMotivoViaje) {
        this.nIdMotivoViaje = nIdMotivoViaje;
    }

    public Integer getNIdOperadorDigita() {
        return nIdOperadorDigita;
    }

    public void setNIdOperadorDigita(Integer nIdOperadorDigita) {
        this.nIdOperadorDigita = nIdOperadorDigita;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public Integer getNIdTipoAlojamiento() {
        return nIdTipoAlojamiento;
    }

    public void setNIdTipoAlojamiento(Integer nIdTipoAlojamiento) {
        this.nIdTipoAlojamiento = nIdTipoAlojamiento;
    }

    public Integer getNIdTransportista() {
        return nIdTransportista;
    }

    public void setNIdTransportista(Integer nIdTransportista) {
        this.nIdTransportista = nIdTransportista;
    }

    public Integer getNIdTurnoOperador() {
        return nIdTurnoOperador;
    }

    public void setNIdTurnoOperador(Integer nIdTurnoOperador) {
        this.nIdTurnoOperador = nIdTurnoOperador;
    }

    public Integer getNPermanencia() {
        return nPermanencia;
    }

    public void setNPermanencia(Integer nPermanencia) {
        this.nPermanencia = nPermanencia;
    }

    public String getSContadorRq() {
        return sContadorRq;
    }

    public void setSContadorRq(String sContadorRq) {
        this.sContadorRq = sContadorRq;
    }

    public String getSDireccionDestino() {
        return sDireccionDestino;
    }

    public void setSDireccionDestino(String sDireccionDestino) {
        this.sDireccionDestino = sDireccionDestino;
    }

    public String getSEstadoRq() {
        return sEstadoRq;
    }

    public void setSEstadoRq(String sEstadoRq) {
        this.sEstadoRq = sEstadoRq;
    }

    public String getSIdDepDigita() {
        return sIdDepDigita;
    }

    public void setSIdDepDigita(String sIdDepDigita) {
        this.sIdDepDigita = sIdDepDigita;
    }

    public String getSIdDependencia() {
        return sIdDependencia;
    }

    public void setSIdDependencia(String sIdDependencia) {
        this.sIdDependencia = sIdDependencia;
    }

  /*  public String getSIdDocControl() {
        return sIdDocControl;
    }

    public void setSIdDocControl(String sIdDocControl) {
        this.sIdDocControl = sIdDocControl;
    }

    public String getSIdDocumento() {
        return sIdDocumento;
    }

    public void setSIdDocumento(String sIdDocumento) {
        this.sIdDocumento = sIdDocumento;
    }
*/
    public String getSIdEstadoCivil() {
        return sIdEstadoCivil;
    }

    public void setSIdEstadoCivil(String sIdEstadoCivil) {
        this.sIdEstadoCivil = sIdEstadoCivil;
    }

    public String getSIdItinerario() {
        return sIdItinerario;
    }

    public void setSIdItinerario(String sIdItinerario) {
        this.sIdItinerario = sIdItinerario;
    }

    public String getSIdModuloDigita() {
        return sIdModuloDigita;
    }

    public void setSIdModuloDigita(String sIdModuloDigita) {
        this.sIdModuloDigita = sIdModuloDigita;
    }

    public String getSIdMovMigratorio() {
        return sIdMovMigratorio;
    }

    public void setSIdMovMigratorio(String sIdMovMigratorio) {
        this.sIdMovMigratorio = sIdMovMigratorio;
    }


    public String getSIdPaisNacimiento() {
        return sIdPaisNacimiento;
    }

    public void setSIdPaisNacimiento(String sIdPaisNacimiento) {
        this.sIdPaisNacimiento = sIdPaisNacimiento;
    }


    public String getSIdPaisResidencia() {
        return sIdPaisResidencia;
    }

    public void setSIdPaisResidencia(String sIdPaisResidencia) {
        this.sIdPaisResidencia = sIdPaisResidencia;
    }

    public String getSIdParteDiario() {
        return sIdParteDiario;
    }

    public void setSIdParteDiario(String sIdParteDiario) {
        this.sIdParteDiario = sIdParteDiario;
    }

    public String getSIdProfesion() {
        return sIdProfesion;
    }

    public void setSIdProfesion(String sIdProfesion) {
        this.sIdProfesion = sIdProfesion;
    }

    public String getSIdViaTransporte() {
        return sIdViaTransporte;
    }

    public void setSIdViaTransporte(String sIdViaTransporte) {
        this.sIdViaTransporte = sIdViaTransporte;
    }

    public String getSNombres() {
        return sNombres;
    }

    public void setSNombres(String sNombres) {
        this.sNombres = sNombres;
    }

    public String getSNumDocControl() {
        return sNumDocControl;
    }

    public void setSNumDocControl(String sNumDocControl) {
        this.sNumDocControl = sNumDocControl;
    }

    public String getSNumeroDoc() {
        return sNumeroDoc;
    }

    public void setSNumeroDoc(String sNumeroDoc) {
        this.sNumeroDoc = sNumeroDoc;
    }

    public String getSObservaciones() {
        return sObservaciones;
    }

    public void setSObservaciones(String sObservaciones) {
        this.sObservaciones = sObservaciones;
    }

    public String getSPagoPermOk() {
        return sPagoPermOk;
    }

    public void setSPagoPermOk(String sPagoPermOk) {
        this.sPagoPermOk = sPagoPermOk;
    }

    public String getSTipo() {
        return sTipo;
    }

    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public String getSTipoUnidad() {
        return sTipoUnidad;
    }

    public void setSTipoUnidad(String sTipoUnidad) {
        this.sTipoUnidad = sTipoUnidad;
    }


    public Simpersona getSimpersona() {
        return simpersona;
    }

    public void setSimpersona(Simpersona simpersona) {
        this.simpersona = simpersona;
    }
    /**
     * pais de nacionalidad
     * @return
     */
    public Simpais getSimpais() {
        return simpais;
    }
    /**
     * pais de nacioalidad
     * @param simpais
     */
    public void setSimpais(Simpais simpais) {
        this.simpais = simpais;
    }
    /**
     * Pais de movimiento
     * @return
     */
    public Simpais getSimpais1() {
        return simpais1;
    }
    /**
     * pais de movimiento
     * @param simpais1
     */
    public void setSimpais1(Simpais simpais1) {
        this.simpais1 = simpais1;
    }

    public Simcalidadmigratoria getSimcalidadmigratoria() {
        return simcalidadmigratoria;
    }

    public void setSimcalidadmigratoria(Simcalidadmigratoria simcalidadmigratoria) {
        this.simcalidadmigratoria = simcalidadmigratoria;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
    }
}
