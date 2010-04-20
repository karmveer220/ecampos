package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Mayo 2009
 * @version 1.0
 */
public class Simcalidadmigratoria1 implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nIdCalidad;
    private String sCodAnterior;
    private String sDescripcion;
    private String sIdGrupoCal;
    private String sSigla;
    private String sTipo;
    
    public Simcalidadmigratoria1() {
    }

    public Simcalidadmigratoria1(Integer nIdCalidad,String sDescripcion) {
        this.nIdCalidad=nIdCalidad;
        this.sDescripcion=sDescripcion;
    }
    
    public void setNIdCalidad(Integer nIdCalidad) {
        this.nIdCalidad = nIdCalidad;
    }

    public Integer getNIdCalidad() {
        return nIdCalidad;
    }

    public void setSCodAnterior(String sCodAnterior) {
        this.sCodAnterior = sCodAnterior;
    }

    public String getSCodAnterior() {
        return sCodAnterior;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }

    public void setSIdGrupoCal(String sIdGrupoCal) {
        this.sIdGrupoCal = sIdGrupoCal;
    }

    public String getSIdGrupoCal() {
        return sIdGrupoCal;
    }

    public void setSSigla(String sSigla) {
        this.sSigla = sSigla;
    }

    public String getSSigla() {
        return sSigla;
    }

    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public String getSTipo() {
        return sTipo;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
