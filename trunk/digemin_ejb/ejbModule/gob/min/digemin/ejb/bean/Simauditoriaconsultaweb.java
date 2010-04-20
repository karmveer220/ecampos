package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Simauditoriaconsultaweb.findAll", 
    query = "select o from Simauditoriaconsultaweb o")
@Table(name = "\"SimAuditoriaConsultaWEB\"")
public class Simauditoriaconsultaweb implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dFechaConsulta;
    private String sDocDetalle;
    private String sIdProcedimientoForm;
    private Integer sIdSesion;
    private String sObservacion;
    private String sTipoConsulta;
    private String uIdPersona;

    public Simauditoriaconsultaweb() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDFechaConsulta() {
        return dFechaConsulta;
    }

    public void setDFechaConsulta(Date dFechaConsulta) {
        this.dFechaConsulta = dFechaConsulta;
    }

    public String getSDocDetalle() {
        return sDocDetalle;
    }

    public void setSDocDetalle(String sDocDetalle) {
        this.sDocDetalle = sDocDetalle;
    }

    public String getSIdProcedimientoForm() {
        return sIdProcedimientoForm;
    }

    public void setSIdProcedimientoForm(String sIdProcedimientoForm) {
        this.sIdProcedimientoForm = sIdProcedimientoForm;
    }

    public Integer getSIdSesion() {
        return sIdSesion;
    }

    public void setSIdSesion(Integer sIdSesion) {
        this.sIdSesion = sIdSesion;
    }

    public String getSObservacion() {
        return sObservacion;
    }

    public void setSObservacion(String sObservacion) {
        this.sObservacion = sObservacion;
    }

    public String getSTipoConsulta() {
        return sTipoConsulta;
    }

    public void setSTipoConsulta(String sTipoConsulta) {
        this.sTipoConsulta = sTipoConsulta;
    }

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }
}
