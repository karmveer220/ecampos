
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for simpasaporte1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpasaporte1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DFechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DFechaExpiracion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SEstadoActual" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIdDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNumeroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPasNumero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpasaporte1", propOrder = {
    "cantidad",
    "dFechaEmision",
    "dFechaExpiracion",
    "sEstadoActual",
    "sIdDocumento",
    "sNumeroDoc",
    "sPasNumero"
})
public class Simpasaporte1 {

    protected Integer cantidad;
    @XmlElement(name = "DFechaEmision")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dFechaEmision;
    @XmlElement(name = "DFechaExpiracion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dFechaExpiracion;
    @XmlElement(name = "SEstadoActual")
    protected String sEstadoActual;
    @XmlElement(name = "SIdDocumento")
    protected String sIdDocumento;
    @XmlElement(name = "SNumeroDoc")
    protected String sNumeroDoc;
    @XmlElement(name = "SPasNumero")
    protected String sPasNumero;

    /**
     * Gets the value of the cantidad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidad(Integer value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the dFechaEmision property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFechaEmision() {
        return dFechaEmision;
    }

    /**
     * Sets the value of the dFechaEmision property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFechaEmision(XMLGregorianCalendar value) {
        this.dFechaEmision = value;
    }

    /**
     * Gets the value of the dFechaExpiracion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFechaExpiracion() {
        return dFechaExpiracion;
    }

    /**
     * Sets the value of the dFechaExpiracion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFechaExpiracion(XMLGregorianCalendar value) {
        this.dFechaExpiracion = value;
    }

    /**
     * Gets the value of the sEstadoActual property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEstadoActual() {
        return sEstadoActual;
    }

    /**
     * Sets the value of the sEstadoActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEstadoActual(String value) {
        this.sEstadoActual = value;
    }

    /**
     * Gets the value of the sIdDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdDocumento() {
        return sIdDocumento;
    }

    /**
     * Sets the value of the sIdDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdDocumento(String value) {
        this.sIdDocumento = value;
    }

    /**
     * Gets the value of the sNumeroDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumeroDoc() {
        return sNumeroDoc;
    }

    /**
     * Sets the value of the sNumeroDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumeroDoc(String value) {
        this.sNumeroDoc = value;
    }

    /**
     * Gets the value of the sPasNumero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPasNumero() {
        return sPasNumero;
    }

    /**
     * Sets the value of the sPasNumero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPasNumero(String value) {
        this.sPasNumero = value;
    }

}
