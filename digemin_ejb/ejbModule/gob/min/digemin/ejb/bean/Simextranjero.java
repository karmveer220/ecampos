package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
@Entity
@NamedQuery(name = "Simextranjero.findAll", 
    query = "select o from Simextranjero o")
@Table(name = "\"SimExtranjero\"")
public class Simextranjero implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(insertable = false, updatable = false)
    private String uIdPersona;
    private Calendar dFechaEstadia;
    private Calendar dFechaHoraAud;
    private Calendar dFechaInicial;
    private String nEstatura;
    private Integer nIdColorCabello;
    private Integer nIdColorOjos;
    private Integer nIdOrganizacion;
    private Integer nIdSesion;
    private Integer nUltimaInscripcion;
    private String sCarnetActual;
    private String sCiudadNatal;
    private String sDomicilio;
    private String sEmail;
    private String sIdReligion;
    private String sIdUbigeoDomicilio;
    private String sTelefono;    
    @OneToOne
    @JoinColumn(name = "uIdPersona", referencedColumnName = "uIdPersona")
    private Simpersona simpersona;

    public Simextranjero() {
    }

    public Calendar getDFechaEstadia() {
        return dFechaEstadia;
    }

    public void setDFechaEstadia(Calendar dFechaEstadia) {
        this.dFechaEstadia = dFechaEstadia;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Calendar getDFechaInicial() {
        return dFechaInicial;
    }

    public void setDFechaInicial(Calendar dFechaInicial) {
        this.dFechaInicial = dFechaInicial;
    }

    public String getNEstatura() {
        return nEstatura;
    }

    public void setNEstatura(String nEstatura) {
        this.nEstatura = nEstatura;
    }

    public Integer getNIdColorCabello() {
        return nIdColorCabello;
    }

    public void setNIdColorCabello(Integer nIdColorCabello) {
        this.nIdColorCabello = nIdColorCabello;
    }

    public Integer getNIdColorOjos() {
        return nIdColorOjos;
    }

    public void setNIdColorOjos(Integer nIdColorOjos) {
        this.nIdColorOjos = nIdColorOjos;
    }

    public Integer getNIdOrganizacion() {
        return nIdOrganizacion;
    }

    public void setNIdOrganizacion(Integer nIdOrganizacion) {
        this.nIdOrganizacion = nIdOrganizacion;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public Integer getNUltimaInscripcion() {
        return nUltimaInscripcion;
    }

    public void setNUltimaInscripcion(Integer nUltimaInscripcion) {
        this.nUltimaInscripcion = nUltimaInscripcion;
    }

    public String getSCarnetActual() {
        return sCarnetActual;
    }

    public void setSCarnetActual(String sCarnetActual) {
        this.sCarnetActual = sCarnetActual;
    }

    public String getSCiudadNatal() {
        return sCiudadNatal;
    }

    public void setSCiudadNatal(String sCiudadNatal) {
        this.sCiudadNatal = sCiudadNatal;
    }

    public String getSDomicilio() {
        return sDomicilio;
    }

    public void setSDomicilio(String sDomicilio) {
        this.sDomicilio = sDomicilio;
    }

    public String getSEmail() {
        return sEmail;
    }

    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getSIdReligion() {
        return sIdReligion;
    }

    public void setSIdReligion(String sIdReligion) {
        this.sIdReligion = sIdReligion;
    }

    public String getSIdUbigeoDomicilio() {
        return sIdUbigeoDomicilio;
    }

    public void setSIdUbigeoDomicilio(String sIdUbigeoDomicilio) {
        this.sIdUbigeoDomicilio = sIdUbigeoDomicilio;
    }

    public String getSTelefono() {
        return sTelefono;
    }

    public void setSTelefono(String sTelefono) {
        this.sTelefono = sTelefono;
    }

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }

    public Simpersona getSimpersona() {
        return simpersona;
    }

    public void setSimpersona(Simpersona simpersona) {
        this.simpersona = simpersona;
    }
}
