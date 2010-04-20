
package gob.min.digemin.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listaMovimientosXCarnetResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listaMovimientosXCarnetResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaMovimientos" type="{http://ejb.digemin.min.gob/}simmovmigra1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaMovimientosXCarnetResponse", propOrder = {
    "listaMovimientos"
})
public class ListaMovimientosXCarnetResponse {

    protected List<Simmovmigra1> listaMovimientos;

    /**
     * Gets the value of the listaMovimientos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaMovimientos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaMovimientos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Simmovmigra1 }
     * 
     * 
     */
    public List<Simmovmigra1> getListaMovimientos() {
        if (listaMovimientos == null) {
            listaMovimientos = new ArrayList<Simmovmigra1>();
        }
        return this.listaMovimientos;
    }

}
