
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for simpersona1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpersona1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DFechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="documentoviaje" type="{http://ejb.digemin.min.gob/}simdocumento1" minOccurs="0"/>
 *         &lt;element name="paisNacimiento" type="{http://ejb.digemin.min.gob/}simpais1" minOccurs="0"/>
 *         &lt;element name="paisNacionalidad" type="{http://ejb.digemin.min.gob/}simpais1" minOccurs="0"/>
 *         &lt;element name="SIdDocIdentidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SMaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNumDocIdentidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "simpersona1", propOrder = {
    "dFechaNacimiento",
    "documentoviaje",
    "paisNacimiento",
    "paisNacionalidad",
    "sIdDocIdentidad",
    "sMaterno",
    "sNombre",
    "sNumDocIdentidad",
    "sPaterno",
    "sSexo",
    "uIdPersona"
})
public class Simpersona1 {

    @XmlElement(name = "DFechaNacimiento")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dFechaNacimiento;
    protected Simdocumento1 documentoviaje;
    protected Simpais1 paisNacimiento;
    protected Simpais1 paisNacionalidad;
    @XmlElement(name = "SIdDocIdentidad")
    protected String sIdDocIdentidad;
    @XmlElement(name = "SMaterno")
    protected String sMaterno;
    @XmlElement(name = "SNombre")
    protected String sNombre;
    @XmlElement(name = "SNumDocIdentidad")
    protected String sNumDocIdentidad;
    @XmlElement(name = "SPaterno")
    protected String sPaterno;
    @XmlElement(name = "SSexo")
    protected String sSexo;
    @XmlElement(name = "UIdPersona")
    protected String uIdPersona;

    /**
     * Gets the value of the dFechaNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFechaNacimiento() {
        return dFechaNacimiento;
    }

    /**
     * Sets the value of the dFechaNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFechaNacimiento(XMLGregorianCalendar value) {
        this.dFechaNacimiento = value;
    }

    /**
     * Gets the value of the documentoviaje property.
     * 
     * @return
     *     possible object is
     *     {@link Simdocumento1 }
     *     
     */
    public Simdocumento1 getDocumentoviaje() {
        return documentoviaje;
    }

    /**
     * Sets the value of the documentoviaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simdocumento1 }
     *     
     */
    public void setDocumentoviaje(Simdocumento1 value) {
        this.documentoviaje = value;
    }

    /**
     * Gets the value of the paisNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link Simpais1 }
     *     
     */
    public Simpais1 getPaisNacimiento() {
        return paisNacimiento;
    }

    /**
     * Sets the value of the paisNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simpais1 }
     *     
     */
    public void setPaisNacimiento(Simpais1 value) {
        this.paisNacimiento = value;
    }

    /**
     * Gets the value of the paisNacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link Simpais1 }
     *     
     */
    public Simpais1 getPaisNacionalidad() {
        return paisNacionalidad;
    }

    /**
     * Sets the value of the paisNacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simpais1 }
     *     
     */
    public void setPaisNacionalidad(Simpais1 value) {
        this.paisNacionalidad = value;
    }

    /**
     * Gets the value of the sIdDocIdentidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdDocIdentidad() {
        return sIdDocIdentidad;
    }

    /**
     * Sets the value of the sIdDocIdentidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdDocIdentidad(String value) {
        this.sIdDocIdentidad = value;
    }

    /**
     * Gets the value of the sMaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMaterno() {
        return sMaterno;
    }

    /**
     * Sets the value of the sMaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMaterno(String value) {
        this.sMaterno = value;
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
     * Gets the value of the sNumDocIdentidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumDocIdentidad() {
        return sNumDocIdentidad;
    }

    /**
     * Sets the value of the sNumDocIdentidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumDocIdentidad(String value) {
        this.sNumDocIdentidad = value;
    }

    /**
     * Gets the value of the sPaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPaterno() {
        return sPaterno;
    }

    /**
     * Sets the value of the sPaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPaterno(String value) {
        this.sPaterno = value;
    }

    /**
     * Gets the value of the sSexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSexo() {
        return sSexo;
    }

    /**
     * Sets the value of the sSexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSexo(String value) {
        this.sSexo = value;
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
