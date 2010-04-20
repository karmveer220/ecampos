
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simpais1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpais1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SIdPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNacionalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpais1", propOrder = {
    "sIdPais",
    "sNacionalidad",
    "sNombre"
})
public class Simpais1 {

    @XmlElement(name = "SIdPais")
    protected String sIdPais;
    @XmlElement(name = "SNacionalidad")
    protected String sNacionalidad;
    @XmlElement(name = "SNombre")
    protected String sNombre;

    /**
     * Gets the value of the sIdPais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdPais() {
        return sIdPais;
    }

    /**
     * Sets the value of the sIdPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdPais(String value) {
        this.sIdPais = value;
    }

    /**
     * Gets the value of the sNacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNacionalidad() {
        return sNacionalidad;
    }

    /**
     * Sets the value of the sNacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNacionalidad(String value) {
        this.sNacionalidad = value;
    }

    /**
     * Gets the value of the sNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNombre() {
        return sNombre;
    }

    /**
     * Sets the value of the sNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNombre(String value) {
        this.sNombre = value;
    }

}
