
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CarnetExtranjeriaLeerNroResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CarnetExtranjeriaLeerNroResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carnet" type="{http://ejb.digemin.min.gob/}simcarnetextranjeria1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CarnetExtranjeriaLeerNroResponse", propOrder = {
    "carnet"
})
public class CarnetExtranjeriaLeerNroResponse {

    protected Simcarnetextranjeria1 carnet;

    /**
     * Gets the value of the carnet property.
     * 
     * @return
     *     possible object is
     *     {@link Simcarnetextranjeria1 }
     *     
     */
    public Simcarnetextranjeria1 getCarnet() {
        return carnet;
    }

    /**
     * Sets the value of the carnet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simcarnetextranjeria1 }
     *     
     */
    public void setCarnet(Simcarnetextranjeria1 value) {
        this.carnet = value;
    }

}
