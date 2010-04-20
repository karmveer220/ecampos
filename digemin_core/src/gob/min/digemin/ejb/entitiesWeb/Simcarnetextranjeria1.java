package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;

import java.util.Calendar;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Simcarnetextranjeria1 implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nIdCarnet;
    private String sNumeroCarnet;
    private String uIdPersona;
    private Calendar dFechaEmision;
    private Calendar dFechaCaducidad;
    private Calendar dFechaVencRes;
    private String sTipo;
    private Integer cantidad;
    
    public Simcarnetextranjeria1() {
    }
    
    /**
     * 
     * @param nIdCarnet
     * @param sNumeroCarnet
     * @param uIdPersona
     * @param dFechaEmision
     * @param dFechaCaducidad
     * @param dFechaVencRes
     * @param sTipo
     */
    public Simcarnetextranjeria1(Integer nIdCarnet,String sNumeroCarnet,String uIdPersona,Calendar dFechaEmision,Calendar dFechaCaducidad,Calendar dFechaVencRes,String sTipo) {
        this.nIdCarnet=nIdCarnet;
        this.sNumeroCarnet=sNumeroCarnet;
        this.uIdPersona=uIdPersona;
        this.dFechaEmision=dFechaEmision;
        this.dFechaCaducidad=dFechaCaducidad;
        this.dFechaVencRes=dFechaVencRes;
        this.sTipo=sTipo;
    }
    
    public Integer getNIdCarnet() {
        return nIdCarnet;
    }

    public void setNIdCarnet(Integer nIdCarnet) {
        this.nIdCarnet = nIdCarnet;
    }

    public String getSNumeroCarnet() {
        return sNumeroCarnet;
    }

    public void setSNumeroCarnet(String sNumeroCarnet) {
        this.sNumeroCarnet = sNumeroCarnet;
    }

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }

    public Calendar getDFechaEmision() {
        return dFechaEmision;
    }

    public void setDFechaEmision(Calendar dFechaEmision) {
        this.dFechaEmision = dFechaEmision;
    }

    public Calendar getDFechaCaducidad() {
        return dFechaCaducidad;
    }

    public void setDFechaCaducidad(Calendar dFechaCaducidad) {
        this.dFechaCaducidad = dFechaCaducidad;
    }

    public Calendar getDFechaVencRes() {
        return dFechaVencRes;
    }

    public void setDFechaVencRes(Calendar dFechaVencRes) {
        this.dFechaVencRes = dFechaVencRes;
    }

    public String getSTipo() {
        return sTipo;
    }

    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    /**
     * Cantidad de documentos que tiene en total la persona
     * @return
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Cantidad de documentos que tiene la persona en total
     * @param cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
