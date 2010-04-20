
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simdocumento1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simdocumento1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIdDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simdocumento1", propOrder = {
    "sDescripcion",
    "sIdDocumento"
})
public class Simdocumento1 {

    @XmlElement(name = "SDescripcion")
    protected String sDescripcion;
    @XmlElement(name = "SIdDocumento")
    protected String sIdDocumento;

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

}
