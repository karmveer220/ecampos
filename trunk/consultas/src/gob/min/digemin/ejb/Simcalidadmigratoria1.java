
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simcalidadmigratoria1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simcalidadmigratoria1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NIdCalidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SCodAnterior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIdGrupoCal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSigla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simcalidadmigratoria1", propOrder = {
    "nIdCalidad",
    "sCodAnterior",
    "sDescripcion",
    "sIdGrupoCal",
    "sSigla",
    "sTipo"
})
public class Simcalidadmigratoria1 {

    @XmlElement(name = "NIdCalidad")
    protected Integer nIdCalidad;
    @XmlElement(name = "SCodAnterior")
    protected String sCodAnterior;
    @XmlElement(name = "SDescripcion")
    protected String sDescripcion;
    @XmlElement(name = "SIdGrupoCal")
    protected String sIdGrupoCal;
    @XmlElement(name = "SSigla")
    protected String sSigla;
    @XmlElement(name = "STipo")
    protected String sTipo;

    /**
     * Gets the value of the nIdCalidad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNIdCalidad() {
        return nIdCalidad;
    }

    /**
     * Sets the value of the nIdCalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNIdCalidad(Integer value) {
        this.nIdCalidad = value;
    }

    /**
     * Gets the value of the sCodAnterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCodAnterior() {
        return sCodAnterior;
    }

    /**
     * Sets the value of the sCodAnterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCodAnterior(String value) {
        this.sCodAnterior = value;
    }

    /**
     * Gets the value of the sDescripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDescripcion() {
        return sDescripcion;
    }

    /**
     * Sets the value of the sDescripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDescripcion(String value) {
        this.sDescripcion = value;
    }

    /**
     * Gets the value of the sIdGrupoCal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdGrupoCal() {
        return sIdGrupoCal;
    }

    /**
     * Sets the value of the sIdGrupoCal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdGrupoCal(String value) {
        this.sIdGrupoCal = value;
    }

    /**
     * Gets the value of the sSigla property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSigla() {
        return sSigla;
    }

    /**
     * Sets the value of the sSigla property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSigla(String value) {
        this.sSigla = value;
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

}
