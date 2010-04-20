package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
@Entity
@NamedQuery(name = "Simperuano.findAll", query = "select o from Simperuano o")
@Table(name = "\"SimPeruano\"")
public class Simperuano implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar dFechaHoraAud;
    private String nEstatura;
    private Integer nIdColorCabello;
    private Integer nIdColorOjos;
    private Integer nIdSesion;
    private String sDomicilio;
    private String sFisionomiaAnt;
    private String sIdDocumento;
    private String sIdUbigeoDomicilio;
    private String sIdUbigeoNacimiento;
    private String sNombreMadre;
    private String sNombrePadre;
    private String sNumeroDoc;
    private String sTelefono;
    @Id
    @Column(insertable = false, updatable = false)
    private String uIdPersona;
    /*@OneToOne
    @JoinColumn(name = "uIdPersona", referencedColumnName = "uIdPersona")
    private Simpersona simpersona;*/
    @OneToMany(mappedBy = "simperuano")
    private List<Simpasperu> simpasperuList;

    public Simperuano() {
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
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

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public String getSDomicilio() {
        return sDomicilio;
    }

    public void setSDomicilio(String sDomicilio) {
        this.sDomicilio = sDomicilio;
    }

    public String getSFisionomiaAnt() {
        return sFisionomiaAnt;
    }

    public void setSFisionomiaAnt(String sFisionomiaAnt) {
        this.sFisionomiaAnt = sFisionomiaAnt;
    }

    public String getSIdDocumento() {
        return sIdDocumento;
    }

    public void setSIdDocumento(String sIdDocumento) {
        this.sIdDocumento = sIdDocumento;
    }

    public String getSIdUbigeoDomicilio() {
        return sIdUbigeoDomicilio;
    }

    public void setSIdUbigeoDomicilio(String sIdUbigeoDomicilio) {
        this.sIdUbigeoDomicilio = sIdUbigeoDomicilio;
    }

    public String getSIdUbigeoNacimiento() {
        return sIdUbigeoNacimiento;
    }

    public void setSIdUbigeoNacimiento(String sIdUbigeoNacimiento) {
        this.sIdUbigeoNacimiento = sIdUbigeoNacimiento;
    }

    public String getSNombreMadre() {
        return sNombreMadre;
    }

    public void setSNombreMadre(String sNombreMadre) {
        this.sNombreMadre = sNombreMadre;
    }

    public String getSNombrePadre() {
        return sNombrePadre;
    }

    public void setSNombrePadre(String sNombrePadre) {
        this.sNombrePadre = sNombrePadre;
    }

    public String getSNumeroDoc() {
        return sNumeroDoc;
    }

    public void setSNumeroDoc(String sNumeroDoc) {
        this.sNumeroDoc = sNumeroDoc;
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

   /* public Simpersona getSimpersona() {
        return simpersona;
    }

    public void setSimpersona(Simpersona simpersona) {
        this.simpersona = simpersona;
    }*/

    public List<Simpasperu> getSimpasperuList() {
        return simpasperuList;
    }

    public void setSimpasperuList(List<Simpasperu> simpasperuList) {
        this.simpasperuList = simpasperuList;
    }

    public Simpasperu addSimpasperu(Simpasperu simpasperu) {
        getSimpasperuList().add(simpasperu);
        simpasperu.setSimperuano(this);
        return simpasperu;
    }

    public Simpasperu removeSimpasperu(Simpasperu simpasperu) {
        getSimpasperuList().remove(simpasperu);
        simpasperu.setSimperuano(null);
        return simpasperu;
    }
}
