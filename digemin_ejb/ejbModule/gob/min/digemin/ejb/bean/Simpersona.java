package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
@Entity
@NamedQuery(name = "Simpersona.findAll", query = "select o from Simpersona o")
@Table(name = "\"SimPersona\"")
public class Simpersona implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String uIdPersona;
    //private String notas;
    private String bActivo;
    private String bEnElPais;
    private Calendar dFechaHoraAud;
    private Calendar dFechaNacimiento;
    private Calendar dUltimoIngreso;
    private Integer nIdSesion;
    private Integer nPermanencia;
    private String sBusqueda;
    private String sCodAnterior;
    private String sIdDocIdentidad;
    private String sIdDocViaje;
    private String sIdEstadoCivil;
    private String sIdProfesion;
    private String sMaterno;
    private String sNombre;
    private String sNumDocIdentidad;
    private String sNumDocViaje;
    private String sObservaciones;
    private String sPaterno;
    private String sSexo;
    private String sUltimoPasaporte;
      
    @ManyToOne
    @JoinColumn(name = "nIdCalidad", referencedColumnName = "nIdCalidad")
    private Simcalidadmigratoria simcalidadmigratoria;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "sIdPaisNacionalidad", referencedColumnName = "sIdPais")
    private Simpais simpais;
    @ManyToOne
    @JoinColumn(name = "sIdPaisResidencia", referencedColumnName = "sIdPais")
    private Simpais simpais1;
    @ManyToOne
    @JoinColumn(name = "sIdPaisNacimiento", referencedColumnName = "sIdPais")
    private Simpais simpais2;

    public Simpersona() {
    }
    
    public String getBActivo() {
        return bActivo;
    }

    public void setBActivo(String bActivo) {
        this.bActivo = bActivo;
    }

    public String getBEnElPais() {
        return bEnElPais;
    }

    public void setBEnElPais(String bEnElPais) {
        this.bEnElPais = bEnElPais;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Calendar getDFechaNacimiento() {
        return dFechaNacimiento;
    }

    public void setDFechaNacimiento(Calendar dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }

    public Calendar getDUltimoIngreso() {
        return dUltimoIngreso;
    }

    public void setDUltimoIngreso(Calendar dUltimoIngreso) {
        this.dUltimoIngreso = dUltimoIngreso;
    }


    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public Integer getNPermanencia() {
        return nPermanencia;
    }

    public void setNPermanencia(Integer nPermanencia) {
        this.nPermanencia = nPermanencia;
    }

    public String getSBusqueda() {
        return sBusqueda;
    }

    public void setSBusqueda(String sBusqueda) {
        this.sBusqueda = sBusqueda;
    }

    public String getSCodAnterior() {
        return sCodAnterior;
    }

    public void setSCodAnterior(String sCodAnterior) {
        this.sCodAnterior = sCodAnterior;
    }

    public String getSIdDocIdentidad() {
        return sIdDocIdentidad;
    }

    public void setSIdDocIdentidad(String sIdDocIdentidad) {
        this.sIdDocIdentidad = sIdDocIdentidad;
    }

    public String getSIdDocViaje() {
        return sIdDocViaje;
    }

    public void setSIdDocViaje(String sIdDocViaje) {
        this.sIdDocViaje = sIdDocViaje;
    }

    public String getSIdEstadoCivil() {
        return sIdEstadoCivil;
    }

    public void setSIdEstadoCivil(String sIdEstadoCivil) {
        this.sIdEstadoCivil = sIdEstadoCivil;
    }


    public String getSIdProfesion() {
        return sIdProfesion;
    }

    public void setSIdProfesion(String sIdProfesion) {
        this.sIdProfesion = sIdProfesion;
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

    public String getSNumDocIdentidad() {
        return sNumDocIdentidad;
    }

    public void setSNumDocIdentidad(String sNumDocIdentidad) {
        this.sNumDocIdentidad = sNumDocIdentidad;
    }

    public String getSNumDocViaje() {
        return sNumDocViaje;
    }

    public void setSNumDocViaje(String sNumDocViaje) {
        this.sNumDocViaje = sNumDocViaje;
    }

    public String getSObservaciones() {
        return sObservaciones;
    }

    public void setSObservaciones(String sObservaciones) {
        this.sObservaciones = sObservaciones;
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

    public String getSUltimoPasaporte() {
        return sUltimoPasaporte;
    }

    public void setSUltimoPasaporte(String sUltimoPasaporte) {
        this.sUltimoPasaporte = sUltimoPasaporte;
    }

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }

   

    public Simpais getSimpais() {
        return simpais;
    }

    public void setSimpais(Simpais simpais) {
        this.simpais = simpais;
    }

    public Simpais getSimpais1() {
        return simpais1;
    }

    public void setSimpais1(Simpais simpais1) {
        this.simpais1 = simpais1;
    }
    public Simcalidadmigratoria getSimcalidadmigratoria() {
       return simcalidadmigratoria;
    }

    public void setSimcalidadmigratoria(Simcalidadmigratoria simcalidadmigratoria) {
       this.simcalidadmigratoria = simcalidadmigratoria;
    }
   
    public Simpais getSimpais2() {
        return simpais2;
    }

    public void setSimpais2(Simpais simpais2) {
        this.simpais2 = simpais2;
    }
    
    public String toString(){
        return "nombre : " + getSNombre() + "; Ap. Paterno : " + getSPaterno() + "; Ap. Materno : " + getSMaterno() + "; sexo : " + getSSexo();
    }
}
