package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Simpasaporte1 implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sPasNumero;
    private Date dFechaEmision;
    private Date dFechaExpiracion;
    private String sIdDocumento;
    private String sNumeroDoc;
    private String sEstadoActual;
    private Integer cantidad;
    
    public Simpasaporte1() {
    }

    public Simpasaporte1(String sPasNumero,Date dFechaEmision,Date dFechaExpiracion,String sIdDocumento,String sNumeroDoc,String sEstadoActual) {
        this.sPasNumero=sPasNumero;
        this.dFechaEmision=dFechaEmision;
        this.dFechaExpiracion=dFechaExpiracion;
        this.sIdDocumento=sIdDocumento;
        this.sNumeroDoc=sNumeroDoc;
        this.sEstadoActual=sEstadoActual;
    }
    
    public String getSPasNumero() {
        return sPasNumero;
    }

    public void setSPasNumero(String sPasNumero) {
        this.sPasNumero = sPasNumero;
    }

    public Date getDFechaEmision() {
        return dFechaEmision;
    }

    public void setDFechaEmision(Date dFechaEmision) {
        this.dFechaEmision = dFechaEmision;
    }

    public Date getDFechaExpiracion() {
        return dFechaExpiracion;
    }

    public void setDFechaExpiracion(Date dFechaExpiracion) {
        this.dFechaExpiracion = dFechaExpiracion;
    }

    public String getSIdDocumento() {
        return sIdDocumento;
    }

    public void setSIdDocumento(String sIdDocumento) {
        this.sIdDocumento = sIdDocumento;
    }

    public String getSNumeroDoc() {
        return sNumeroDoc;
    }

    public void setSNumeroDoc(String sNumeroDoc) {
        this.sNumeroDoc = sNumeroDoc;
    }

    public String getSEstadoActual() {
        return sEstadoActual;
    }

    public void setSEstadoActual(String sEstadoActual) {
        this.sEstadoActual = sEstadoActual;
    }
    /**
     * cantidad de documentos que tiene la persona
     * @return cantidad de documentos
     */
    public Integer getCantidad() {
        return cantidad;
    }
    /**
     * Cantida de documentos que tiene la persona
     * @param cantidad cantidad de pasaportes que tiene la persoan
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
