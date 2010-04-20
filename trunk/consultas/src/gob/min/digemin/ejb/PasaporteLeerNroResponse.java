
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PasaporteLeerNroResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PasaporteLeerNroResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pasaporte" type="{http://ejb.digemin.min.gob/}simpasaporte1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PasaporteLeerNroResponse", propOrder = {
    "pasaporte"
})
public class PasaporteLeerNroResponse {

    protected Simpasaporte1 pasaporte;

    /**
     * Gets the value of the pasaporte property.
     * 
     * @return
     *     possible object is
     *     {@link Simpasaporte1 }
     *     
     */
    public Simpasaporte1 getPasaporte() {
        return pasaporte;
    }

    /**
     * Sets the value of the pasaporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simpasaporte1 }
     *     
     */
    public void setPasaporte(Simpasaporte1 value) {
        this.pasaporte = value;
    }

}
