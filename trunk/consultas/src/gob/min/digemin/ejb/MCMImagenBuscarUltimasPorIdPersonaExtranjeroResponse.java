
package gob.min.digemin.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MCMImagenBuscarUltimasPorIdPersonaExtranjeroResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MCMImagenBuscarUltimasPorIdPersonaExtranjeroResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaImagenes" type="{http://ejb.digemin.min.gob/}beanImagen" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MCMImagenBuscarUltimasPorIdPersonaExtranjeroResponse", propOrder = {
    "listaImagenes"
})
public class MCMImagenBuscarUltimasPorIdPersonaExtranjeroResponse {

    protected List<BeanImagen> listaImagenes;

    /**
     * Gets the value of the listaImagenes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaImagenes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaImagenes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeanImagen }
     * 
     * 
     */
    public List<BeanImagen> getListaImagenes() {
        if (listaImagenes == null) {
            listaImagenes = new ArrayList<BeanImagen>();
        }
        return this.listaImagenes;
    }

}
