package gob.min.digemin.ejb.bean;

import gob.min.digemin.ejb.utiles.Utiles;

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
@NamedQuery(name = "Simcarnetextranjeria.findAll", 
    query = "select o from Simcarnetextranjeria o")
@Table(name = "\"SimCarnetExtranjeria\"")
public class Simcarnetextranjeria implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private Integer nIdCarnet;
    private String bAnulado;
    private String bDuplicado;
    private String bEntregado;
    private String bImpreso;
    private Calendar dFechaAnulacion;
    private Calendar dFechaCaducidad;
    private Calendar dFechaEmision;
    private Calendar dFechaHoraAud;
    private Calendar dFechaInscripcion;
    private Calendar dFechaVencRes;
    private Integer nIdFicha;
    private Integer nIdInscripcion;
    private Integer nIdSesion;
    private String sNumeroCarnet;
    private String sNumeroTramite;
    private String sTipo;
    private String uIdPersona;

    public Simcarnetextranjeria() {
    }

    public String getBAnulado() {
        return bAnulado;
    }

    public void setBAnulado(String bAnulado) {
        this.bAnulado = bAnulado;
    }

    public String getBDuplicado() {
        return bDuplicado;
    }

    public void setBDuplicado(String bDuplicado) {
        this.bDuplicado = bDuplicado;
    }

    public String getBEntregado() {
        return bEntregado;
    }

    public void setBEntregado(String bEntregado) {
        this.bEntregado = bEntregado;
    }

    public String getBImpreso() {
        return bImpreso;
    }

    public void setBImpreso(String bImpreso) {
        this.bImpreso = bImpreso;
    }

    public Calendar getDFechaAnulacion() {
        return dFechaAnulacion;
    }

    public void setDFechaAnulacion(Calendar dFechaAnulacion) {
        this.dFechaAnulacion = dFechaAnulacion;
    }

    public Calendar getDFechaCaducidad() {
        return dFechaCaducidad;
    }

    public void setDFechaCaducidad(Calendar dFechaCaducidad) {
        this.dFechaCaducidad = dFechaCaducidad;
    }

    public Calendar getDFechaEmision() {
        return dFechaEmision;
    }

    public void setDFechaEmision(Calendar dFechaEmision) {
        this.dFechaEmision = dFechaEmision;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Calendar getDFechaInscripcion() {
        return dFechaInscripcion;
    }

    public void setDFechaInscripcion(Calendar dFechaInscripcion) {
        this.dFechaInscripcion = dFechaInscripcion;
    }

    public Calendar getDFechaVencRes() {
        return dFechaVencRes;
    }

    public void setDFechaVencRes(Calendar dFechaVencRes) {
        this.dFechaVencRes = dFechaVencRes;
    }

    public Integer getNIdCarnet() {
        return nIdCarnet;
    }

    public void setNIdCarnet(Integer nIdCarnet) {
        this.nIdCarnet = nIdCarnet;
    }

    public Integer getNIdFicha() {
        return nIdFicha;
    }

    public void setNIdFicha(Integer nIdFicha) {
        this.nIdFicha = nIdFicha;
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

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }
    public String toString(){
        return "Numero : " + getSNumeroCarnet() + "; Emision : " + Utiles.CalendarToStringTry(getDFechaEmision(),Utiles.FORMATO_FECHA_LARGE );
    }
}
