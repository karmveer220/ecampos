
package gob.min.digemin.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beanRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BAproximado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="BPeruano" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SApeMaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SApePaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SClave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIdPaisNacionalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIdSession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNumCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNumDocMovimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNumPasaporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPersLlave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STipoImagen" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UIdPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanRequest", propOrder = {
    "bAproximado",
    "bPeruano",
    "sApeMaterno",
    "sApePaterno",
    "sClave",
    "sIdPaisNacionalidad",
    "sIdSession",
    "sNombre",
    "sNumCE",
    "sNumDocMovimiento",
    "sNumPasaporte",
    "sPersLlave",
    "sTipoImagen",
    "sUsuario",
    "uIdPersona"
})
public class BeanRequest {

    @XmlElement(name = "BAproximado")
    protected boolean bAproximado;
    @XmlElement(name = "BPeruano")
    protected boolean bPeruano;
    @XmlElement(name = "SApeMaterno")
    protected String sApeMaterno;
    @XmlElement(name = "SApePaterno")
    protected String sApePaterno;
    @XmlElement(name = "SClave")
    protected String sClave;
    @XmlElement(name = "SIdPaisNacionalidad")
    protected String sIdPaisNacionalidad;
    @XmlElement(name = "SIdSession")
    protected String sIdSession;
    @XmlElement(name = "SNombre")
    protected String sNombre;
    @XmlElement(name = "SNumCE")
    protected String sNumCE;
    @XmlElement(name = "SNumDocMovimiento")
    protected String sNumDocMovimiento;
    @XmlElement(name = "SNumPasaporte")
    protected String sNumPasaporte;
    @XmlElement(name = "SPersLlave")
    protected String sPersLlave;
    @XmlElement(name = "STipoImagen", nillable = true)
    protected List<String> sTipoImagen;
    @XmlElement(name = "SUsuario")
    protected String sUsuario;
    @XmlElement(name = "UIdPersona")
    protected String uIdPersona;

    /**
     * Gets the value of the bAproximado property.
     * 
     */
    public boolean isBAproximado() {
        return bAproximado;
    }

    /**
     * Sets the value of the bAproximado property.
     * 
     */
    public void setBAproximado(boolean value) {
        this.bAproximado = value;
    }

    /**
     * Gets the value of the bPeruano property.
     * 
     */
    public boolean isBPeruano() {
        return bPeruano;
    }

    /**
     * Sets the value of the bPeruano property.
     * 
     */
    public void setBPeruano(boolean value) {
        this.bPeruano = value;
    }

    /**
     * Gets the value of the sApeMaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSApeMaterno() {
        return sApeMaterno;
    }

    /**
     * Sets the value of the sApeMaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSApeMaterno(String value) {
        this.sApeMaterno = value;
    }

    /**
     * Gets the value of the sApePaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSApePaterno() {
        return sApePaterno;
    }

    /**
     * Sets the value of the sApePaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSApePaterno(String value) {
        this.sApePaterno = value;
    }

    /**
     * Gets the value of the sClave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSClave() {
        return sClave;
    }

    /**
     * Sets the value of the sClave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSClave(String value) {
        this.sClave = value;
    }

    /**
     * Gets the value of the sIdPaisNacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdPaisNacionalidad() {
        return sIdPaisNacionalidad;
    }

    /**
     * Sets the value of the sIdPaisNacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdPaisNacionalidad(String value) {
        this.sIdPaisNacionalidad = value;
    }

    /**
     * Gets the value of the sIdSession property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdSession() {
        return sIdSession;
    }

    /**
     * Sets the value of the sIdSession property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdSession(String value) {
        this.sIdSession = value;
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

    /**
     * Gets the value of the sNumCE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumCE() {
        return sNumCE;
    }

    /**
     * Sets the value of the sNumCE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumCE(String value) {
        this.sNumCE = value;
    }

    /**
     * Gets the value of the sNumDocMovimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumDocMovimiento() {
        return sNumDocMovimiento;
    }

    /**
     * Sets the value of the sNumDocMovimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumDocMovimiento(String value) {
        this.sNumDocMovimiento = value;
    }

    /**
     * Gets the value of the sNumPasaporte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumPasaporte() {
        return sNumPasaporte;
    }

    /**
     * Sets the value of the sNumPasaporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumPasaporte(String value) {
        this.sNumPasaporte = value;
    }

    /**
     * Gets the value of the sPersLlave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPersLlave() {
        return sPersLlave;
    }

    /**
     * Sets the value of the sPersLlave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPersLlave(String value) {
        this.sPersLlave = value;
    }

    /**
     * Gets the value of the sTipoImagen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sTipoImagen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTipoImagen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSTipoImagen() {
        if (sTipoImagen == null) {
            sTipoImagen = new ArrayList<String>();
        }
        return this.sTipoImagen;
    }

    /**
     * Gets the value of the sUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUsuario() {
        return sUsuario;
    }

    /**
     * Sets the value of the sUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUsuario(String value) {
        this.sUsuario = value;
    }

    /**
     * Gets the value of the uIdPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUIdPersona() {
        return uIdPersona;
    }

    /**
     * Sets the value of the uIdPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUIdPersona(String value) {
        this.uIdPersona = value;
    }

}
