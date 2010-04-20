
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonaLeerPorPasaporteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonaLeerPorPasaporteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="persona" type="{http://ejb.digemin.min.gob/}simpersona1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaLeerPorPasaporteResponse", propOrder = {
    "persona"
})
public class PersonaLeerPorPasaporteResponse {

    protected Simpersona1 persona;

    /**
     * Gets the value of the persona property.
     * 
     * @return
     *     possible object is
     *     {@link Simpersona1 }
     *     
     */
    public Simpersona1 getPersona() {
        return persona;
    }

    /**
     * Sets the value of the persona property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simpersona1 }
     *     
     */
    public void setPersona(Simpersona1 value) {
        this.persona = value;
    }

}
