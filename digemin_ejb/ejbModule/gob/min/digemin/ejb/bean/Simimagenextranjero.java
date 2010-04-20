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
@NamedQuery(name = "Simimagenextranjero.findAll", 
    query = "select o from Simimagenextranjero o")
@Table(name = "\"SimImagenExtranjero\"")
public class Simimagenextranjero implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private Integer nIdImagen;
    private String bUltimo;
    private Calendar dFechaHoraAud;    
    private Integer nIdInscripcion;
    private Integer nIdSesion;
    private String sIdDedo;
    private String sNumeroCarnet;
    private String sNumeroTramite;
    private String sTipo;
    private byte[] xImagen;
    private String uIdPersona;
    /*@ManyToOne
    @JoinColumn(name = "uIdPersona", referencedColumnName = "uIdPersona")
    private Simpersona simpersona;
    */
    public Simimagenextranjero() {
    }

    public String getBUltimo() {
        return bUltimo;
    }

    public void setBUltimo(String bUltimo) {
        this.bUltimo = bUltimo;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Integer getNIdImagen() {
        return nIdImagen;
    }

    public void setNIdImagen(Integer nIdImagen) {
        this.nIdImagen = nIdImagen;
    }

    public Integer getNIdInscripcion() {
        return nIdInscripcion;
    }

    public void setNIdInscripcion(Integer nIdInscripcion) {
        this.nIdInscripcion = nIdInscripcion;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public String getSIdDedo() {
        return sIdDedo;
    }

    public void setSIdDedo(String sIdDedo) {
        this.sIdDedo = sIdDedo;
    }

    public String getSNumeroCarnet() {
        return sNumeroCarnet;
    }

    public void setSNumeroCarnet(String sNumeroCarnet) {
        this.sNumeroCarnet = sNumeroCarnet;
    }

    public String getSNumeroTramite() {
        return sNumeroTramite;
    }

    public void setSNumeroTramite(String sNumeroTramite) {
        this.sNumeroTramite = sNumeroTramite;
    }

    public String getSTipo() {
        return sTipo;
    }

    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }


    public byte[] getXImagen() {
        return xImagen;
    }

    public void setXImagen(byte[] xImagen) {
        this.xImagen = xImagen;
    }

   /* public Simpersona getSimpersona() {
        return simpersona;
    }

    public void setSimpersona(Simpersona simpersona) {
        this.simpersona = simpersona;
    }*/

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }
}
