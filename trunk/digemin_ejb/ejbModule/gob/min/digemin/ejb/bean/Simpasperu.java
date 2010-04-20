package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@NamedQuery(name = "Simpasperu.findAll", query = "select o from Simpasperu o")
@Table(name = "\"SimPasPeru\"")
@IdClass(SimpasperuPK.class)
public class Simpasperu implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar dFechaHoraAud;
    private Integer nIdSesion;
    @Id
    @Column(insertable = false, updatable = false)
    private String sPasNumero;
    @Id
    @Column(insertable = false, updatable = false)
    private String uIdPersona;
    /*@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "sPasNumero", referencedColumnName = "sPasNumero")
    private Simpasaporte simpasaporte;*/
    @ManyToOne
    @JoinColumn(name = "uIdPersona", referencedColumnName = "uIdPersona")
    private Simperuano simperuano;

    public Simpasperu() {
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public String getSPasNumero() {
        return sPasNumero;
    }

    public void setSPasNumero(String sPasNumero) {
        this.sPasNumero = sPasNumero;
    }

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }

   /* public Simpasaporte getSimpasaporte() {
        return simpasaporte;
    }

    public void setSimpasaporte(Simpasaporte simpasaporte) {
        this.simpasaporte = simpasaporte;
    }*/

    public Simperuano getSimperuano() {
        return simperuano;
    }

    public void setSimperuano(Simperuano simperuano) {
        this.simperuano = simperuano;
    }
}
