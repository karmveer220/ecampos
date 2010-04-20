
package gob.min.digemin.ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for simmovmigra1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simmovmigra1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DFechaControl" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="NIdCalidad" type="{http://ejb.digemin.min.gob/}simcalidadmigratoria1" minOccurs="0"/>
 *         &lt;element name="SDireccionDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIdDocumento" type="{http://ejb.digemin.min.gob/}simdocumento1" minOccurs="0"/>
 *         &lt;element name="SIdMovMigratorio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIdPaisMov" type="{http://ejb.digemin.min.gob/}simpais1" minOccurs="0"/>
 *         &lt;element name="SNumDocControl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNumeroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SObservaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simmovmigra1", propOrder = {
    "dFechaControl",
    "nIdCalidad",
    "sDireccionDestino",
    "sIdDocumento",
    "sIdMovMigratorio",
    "sIdPaisMov",
    "sNumDocControl",
    "sNumeroDoc",
    "sObservaciones",
    "sTipo"
})
public class Simmovmigra1 {

    @XmlElement(name = "DFechaControl")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dFechaControl;
    @XmlElement(name = "NIdCalidad")
    protected Simcalidadmigratoria1 nIdCalidad;
    @XmlElement(name = "SDireccionDestino")
    protected String sDireccionDestino;
    @XmlElement(name = "SIdDocumento")
    protected Simdocumento1 sIdDocumento;
    @XmlElement(name = "SIdMovMigratorio")
    protected String sIdMovMigratorio;
    @XmlElement(name = "SIdPaisMov")
    protected Simpais1 sIdPaisMov;
    @XmlElement(name = "SNumDocControl")
    protected String sNumDocControl;
    @XmlElement(name = "SNumeroDoc")
    protected String sNumeroDoc;
    @XmlElement(name = "SObservaciones")
    protected String sObservaciones;
    @XmlElement(name = "STipo")
    protected String sTipo;

    /**
     * Gets the value of the dFechaControl property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFechaControl() {
        return dFechaControl;
    }

    /**
     * Sets the value of the dFechaControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFechaControl(XMLGregorianCalendar value) {
        this.dFechaControl = value;
    }

    /**
     * Gets the value of the nIdCalidad property.
     * 
     * @return
     *     possible object is
     *     {@link Simcalidadmigratoria1 }
     *     
     */
    public Simcalidadmigratoria1 getNIdCalidad() {
        return nIdCalidad;
    }

    /**
     * Sets the value of the nIdCalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simcalidadmigratoria1 }
     *     
     */
    public void setNIdCalidad(Simcalidadmigratoria1 value) {
        this.nIdCalidad = value;
    }

    /**
     * Gets the value of the sDireccionDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDireccionDestino() {
        return sDireccionDestino;
    }

    /**
     * Sets the value of the sDireccionDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDireccionDestino(String value) {
        this.sDireccionDestino = value;
    }

    /**
     * Gets the value of the sIdDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link Simdocumento1 }
     *     
     */
    public Simdocumento1 getSIdDocumento() {
        return sIdDocumento;
    }

    /**
     * Sets the value of the sIdDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simdocumento1 }
     *     
     */
    public void setSIdDocumento(Simdocumento1 value) {
        this.sIdDocumento = value;
    }

    /**
     * Gets the value of the sIdMovMigratorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIdMovMigratorio() {
        return sIdMovMigratorio;
    }

    /**
     * Sets the value of the sIdMovMigratorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIdMovMigratorio(String value) {
        this.sIdMovMigratorio = value;
    }

    /**
     * Gets the value of the sIdPaisMov property.
     * 
     * @return
     *     possible object is
     *     {@link Simpais1 }
     *     
     */
    public Simpais1 getSIdPaisMov() {
        return sIdPaisMov;
    }

    /**
     * Sets the value of the sIdPaisMov property.
     * 
     * @param value
     *     allowed object is
     *     {@link Simpais1 }
     *     
     */
    public void setSIdPaisMov(Simpais1 value) {
        this.sIdPaisMov = value;
    }

    /**
     * Gets the value of the sNumDocControl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumDocControl() {
        return sNumDocControl;
    }

    /**
     * Sets the value of the sNumDocControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumDocControl(String value) {
        this.sNumDocControl = value;
    }

    /**
     * Gets the value of the sNumeroDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNumeroDoc() {
        return sNumeroDoc;
    }

    /**
     * Sets the value of the sNumeroDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNumeroDoc(String value) {
        this.sNumeroDoc = value;
    }

    /**
     * Gets the value of the sObservaciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSObservaciones() {
        return sObservaciones;
    }

    /**
     * Sets the value of the sObservaciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSObservaciones(String value) {
        this.sObservaciones = value;
    }

    /**
     * Gets the value of the sTipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTipo() {
        return sTipo;
    }

    /**
     * Sets the value of the sTipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTipo(String value) {
        this.sTipo = value;
    }

}
