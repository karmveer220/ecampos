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
@NamedQuery(name = "Simcalidadmigratoria.findAll", 
    query = "select o from Simcalidadmigratoria o")
@Table(name = "\"SimCalidadMigratoria\"")
public class Simcalidadmigratoria implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private Integer nIdCalidad;
    private String bActivo;
    private String bActivoVI;
    private String bFamiliar;
    private String bProhTrab;
    private Calendar dFechaHoraAud;
    private Integer nDiasPermDefault;
    private Integer nDiasPermMaximo;
    private Integer nIdSesion;
    private String sCodAnterior;
    private String sDescripcion;
    private String sIdGrupoCal;
    private String sSigla;
    private String sTipo;
    /*@OneToMany(mappedBy = "simcalidadmigratoria")
    private List<Simmovmigra> simmovmigraList;
    @OneToMany(mappedBy = "simcalidadmigratoria")
    private List<Simpersona> simpersonaList;*/

    public Simcalidadmigratoria() {
    }

    public String getBActivo() {
        return bActivo;
    }

    public void setBActivo(String bActivo) {
        this.bActivo = bActivo;
    }

    public String getBActivoVI() {
        return bActivoVI;
    }

    public void setBActivoVI(String bActivoVI) {
        this.bActivoVI = bActivoVI;
    }

    public String getBFamiliar() {
        return bFamiliar;
    }

    public void setBFamiliar(String bFamiliar) {
        this.bFamiliar = bFamiliar;
    }

    public String getBProhTrab() {
        return bProhTrab;
    }

    public void setBProhTrab(String bProhTrab) {
        this.bProhTrab = bProhTrab;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Integer getNDiasPermDefault() {
        return nDiasPermDefault;
    }

    public void setNDiasPermDefault(Integer nDiasPermDefault) {
        this.nDiasPermDefault = nDiasPermDefault;
    }

    public Integer getNDiasPermMaximo() {
        return nDiasPermMaximo;
    }

    public void setNDiasPermMaximo(Integer nDiasPermMaximo) {
        this.nDiasPermMaximo = nDiasPermMaximo;
    }

    public Integer getNIdCalidad() {
        return nIdCalidad;
    }

    public void setNIdCalidad(Integer nIdCalidad) {
        this.nIdCalidad = nIdCalidad;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public String getSCodAnterior() {
        return sCodAnterior;
    }

    public void setSCodAnterior(String sCodAnterior) {
        this.sCodAnterior = sCodAnterior;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getSIdGrupoCal() {
        return sIdGrupoCal;
    }

    public void setSIdGrupoCal(String sIdGrupoCal) {
        this.sIdGrupoCal = sIdGrupoCal;
    }

    public String getSSigla() {
        return sSigla;
    }

    public void setSSigla(String sSigla) {
        this.sSigla = sSigla;
    }

    public String getSTipo() {
        return sTipo;
    }

    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    /*public List<Simmovmigra> getSimmovmigraList() {
        return simmovmigraList;
    }

    public void setSimmovmigraList(List<Simmovmigra> simmovmigraList) {
        this.simmovmigraList = simmovmigraList;
    }

    public Simmovmigra addSimmovmigra(Simmovmigra simmovmigra) {
        getSimmovmigraList().add(simmovmigra);
        simmovmigra.setSimcalidadmigratoria(this);
        return simmovmigra;
    }

    public Simmovmigra removeSimmovmigra(Simmovmigra simmovmigra) {
        getSimmovmigraList().remove(simmovmigra);
        simmovmigra.setSimcalidadmigratoria(null);
        return simmovmigra;
    }

    public List<Simpersona> getSimpersonaList() {
        return simpersonaList;
    }

    public void setSimpersonaList(List<Simpersona> simpersonaList) {
        this.simpersonaList = simpersonaList;
    }

    public Simpersona addSimpersona(Simpersona simpersona) {
        getSimpersonaList().add(simpersona);
        simpersona.setSimcalidadmigratoria(this);
        return simpersona;
    }

    public Simpersona removeSimpersona(Simpersona simpersona) {
        getSimpersonaList().remove(simpersona);
        simpersona.setSimcalidadmigratoria(null);
        return simpersona;
    }*/
}
