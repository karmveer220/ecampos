
package gob.min.digemin.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listaPersonaPorNombresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listaPersonaPorNombresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaPersonas" type="{http://ejb.digemin.min.gob/}simpersona1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaPersonaPorNombresResponse", propOrder = {
    "listaPersonas"
})
public class ListaPersonaPorNombresResponse {

    protected List<Simpersona1> listaPersonas;

    /**
     * Gets the value of the listaPersonas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaPersonas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaPersonas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Simpersona1 }
     * 
     * 
     */
    public List<Simpersona1> getListaPersonas() {
        if (listaPersonas == null) {
            listaPersonas = new ArrayList<Simpersona1>();
        }
        return this.listaPersonas;
    }

}
