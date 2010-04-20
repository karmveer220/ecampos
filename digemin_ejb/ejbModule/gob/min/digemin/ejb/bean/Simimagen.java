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
@NamedQuery(name = "Simimagen.findAll", query = "select o from Simimagen o")
@Table(name = "\"SimImagen\"")
public class Simimagen implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private Integer nIdImagen;
    private String bUltimo;
    private Calendar dFechaHoraAud;
    private Integer nIdSesion;
    private String sNumeroTramite;
    private String sTipoImagen;
    private String uIdPersona;
    private byte[] xImagen;
    private String sPasNumero;
   /* @ManyToOne
    @JoinColumn(name = "sPasNumero", referencedColumnName = "sPasNumero")
    private Simpasaporte simpasaporte;*/

    public Simimagen() {
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

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public String getSNumeroTramite() {
        return sNumeroTramite;
    }

    public void setSNumeroTramite(String sNumeroTramite) {
        this.sNumeroTramite = sNumeroTramite;
    }


    public String getSTipoImagen() {
        return sTipoImagen;
    }

    public void setSTipoImagen(String sTipoImagen) {
        this.sTipoImagen = sTipoImagen;
    }

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }

    public byte[] getXImagen() {
        return xImagen;
    }

    public void setXImagen(byte[] xImagen) {
        this.xImagen = xImagen;
    }

   /* public Simpasaporte getSimpasaporte() {
        return simpasaporte;
    }

    public void setSimpasaporte(Simpasaporte simpasaporte) {
        this.simpasaporte = simpasaporte;
    }*/

    public String getSPasNumero() {
        return sPasNumero;
    }

    public void setSPasNumero(String sPasNumero) {
        this.sPasNumero = sPasNumero;
    }
}
