package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@NamedQuery(name = "Simpais.findAll", query = "select o from Simpais o")
@Table(name = "\"SimPais\"")
public class Simpais implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String sIdPais;
    private String sNacionalidad;
    private String sNombre;
    private String bActivo;
    private String bGrupoAndino;
    private Integer nIdContinente;
    private Integer nIdSesion;
    private Calendar dFechaHoraAud;
    private String bVisaEstudiante;
    private String bVisaIngreso;
    private String bVisaNegocio;
    private String bVisaSalida;
    private String bVisaTurista;
    private String sCodigoIso;
   
    /*@OneToMany(mappedBy = "simpais")
    private List<Simmovmigra> simmovmigraList;
    @OneToMany(mappedBy = "simpais1")
    private List<Simmovmigra> simmovmigraList1;
    @OneToMany(mappedBy = "simpais")
    private List<Simpersona> simpersonaList;
    @OneToMany(mappedBy = "simpais1")
    private List<Simpersona> simpersonaList1;
    @OneToMany(mappedBy = "simpais")
    private List<Simpasaporte> simpasaporteList;
    @OneToMany(mappedBy = "simpais2")
    private List<Simpersona> simpersonaList2;*/

    public Simpais() {
    }

    public String getBActivo() {
        return bActivo;
    }

    public void setBActivo(String bActivo) {
        this.bActivo = bActivo;
    }

    public String getBGrupoAndino() {
        return bGrupoAndino;
    }

    public void setBGrupoAndino(String bGrupoAndino) {
        this.bGrupoAndino = bGrupoAndino;
    }

    public String getBVisaEstudiante() {
        return bVisaEstudiante;
    }

    public void setBVisaEstudiante(String bVisaEstudiante) {
        this.bVisaEstudiante = bVisaEstudiante;
    }

    public String getBVisaIngreso() {
        return bVisaIngreso;
    }

    public void setBVisaIngreso(String bVisaIngreso) {
        this.bVisaIngreso = bVisaIngreso;
    }

    public String getBVisaNegocio() {
        return bVisaNegocio;
    }

    public void setBVisaNegocio(String bVisaNegocio) {
        this.bVisaNegocio = bVisaNegocio;
    }

    public String getBVisaSalida() {
        return bVisaSalida;
    }

    public void setBVisaSalida(String bVisaSalida) {
        this.bVisaSalida = bVisaSalida;
    }

    public String getBVisaTurista() {
        return bVisaTurista;
    }

    public void setBVisaTurista(String bVisaTurista) {
        this.bVisaTurista = bVisaTurista;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Integer getNIdContinente() {
        return nIdContinente;
    }

    public void setNIdContinente(Integer nIdContinente) {
        this.nIdContinente = nIdContinente;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public String getSCodigoIso() {
        return sCodigoIso;
    }

    public void setSCodigoIso(String sCodigoIso) {
        this.sCodigoIso = sCodigoIso;
    }

  
    public String getSIdPais() {
        return sIdPais;
    }

    public void setSIdPais(String sIdPais) {
        this.sIdPais = sIdPais;
    }

    public String getSNacionalidad() {
        return sNacionalidad;
    }

    public void setSNacionalidad(String sNacionalidad) {
        this.sNacionalidad = sNacionalidad;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

}
