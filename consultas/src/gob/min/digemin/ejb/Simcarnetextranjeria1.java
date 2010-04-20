
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for simcarnetextranjeria1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simcarnetextranjeria1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DFechaCaducidad" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DFechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DFechaVencRes" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="NIdCarnet" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SNumeroCarnet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UIdPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simcarnetextranjeria1", propOrder = {
    "cantidad",
    "dFechaCaducidad",
    "dFechaEmision",
    "dFechaVencRes",
    "nIdCarnet",
    "sNumeroCarnet",
    "sTipo",
    "uIdPersona"
})
public class Simcarnetextranjeria1 {

    protected Integer cantidad;
    @XmlElement(name = "DFechaCaducidad")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dFechaCaducidad;
    @XmlElement(name = "DFechaEmision")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dFechaEmision;
    @XmlElement(name = "DFechaVencRes")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dFechaVencRes;
    @XmlElement(name = "NIdCarnet")
    protected Integer nIdCarnet;
    @XmlElement(name = "SNumeroCarnet")
    protected String sNumeroCarnet;
    @XmlElement(name = "STipo")
    protected String sTipo;
    @XmlElement(name = "UIdPersona")
    protected String uIdPersona;

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
     * Gets the value of the dFechaCaducidad property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFechaCaducidad() {
        return dFechaCaducidad;
    }

    /**
     * Sets the value of the dFechaCaducidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFechaCaducidad(XMLGregorianCalendar value) {
        this.dFechaCaducidad = value;
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
     * Gets the value of the dFechaVencRes property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFechaVencRes() {
        return dFechaVencRes;
    }

    /**
     * Sets the value of the dFechaVencRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFechaVencRes(XMLGregorianCalendar value) {
        this.dFechaVencRes = value;
    }

    /**
     * Gets the value of the nIdCarnet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNIdCarnet() {
        return nIdCarnet;
    }

    /**
     * Sets the value of the nIdCarnet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNIdCarnet(Integer value) {
        this.nIdCarnet = value;
    }

    /**
     * Gets the value of the sNumeroCarnet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumeroCarnet() {
        return sNumeroCarnet;
    }

    /**
     * Sets the value of the sNumeroCarnet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumeroCarnet(String value) {
        this.sNumeroCarnet = value;
    }

    /**
     * Gets the value of the sTipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTipo() {
        return sTipo;
    }

    /**
     * Sets the value of the sTipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTipo(String value) {
        this.sTipo = value;
    }

    /**
     * Gets the value of the uIdPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUIdPersona() {
        return uIdPersona;
    }

    /**
     * Sets the value of the uIdPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUIdPersona(String value) {
        this.uIdPersona = value;
    }

}
