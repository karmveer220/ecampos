
package gob.min.digemin.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CarnetExtranjeriaLeerPersonaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CarnetExtranjeriaLeerPersonaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaCarnet" type="{http://ejb.digemin.min.gob/}simcarnetextranjeria1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CarnetExtranjeriaLeerPersonaResponse", propOrder = {
    "listaCarnet"
})
public class CarnetExtranjeriaLeerPersonaResponse {

    protected List<Simcarnetextranjeria1> listaCarnet;

    /**
     * Gets the value of the listaCarnet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCarnet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCarnet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Simcarnetextranjeria1 }
     * 
     * 
     */
    public List<Simcarnetextranjeria1> getListaCarnet() {
        if (listaCarnet == null) {
            listaCarnet = new ArrayList<Simcarnetextranjeria1>();
        }
        return this.listaCarnet;
    }

}
