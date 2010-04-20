package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Simdocumento.findAll", 
    query = "select o from Simdocumento o")
@Table(name = "\"SimDocumento\"")
public class Simdocumento implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bActivo;
    private String bUsoBusqueda;
    private String bUsoControlMov;
    private String bUsoDocOficial;
    private String bUsoIdentidad;
    private String bUsoMpa;
    private String bUsoPasaporte;
    private String bUsoRegistro;
    private String bUsoViaje;
    private String bUsoViajeCmp;
    private Calendar dFechaHoraAud;
    private Integer nIdSesion;
    private Integer nLongitud;
    private String sCodControlRq;
    private String sDescripcion;
    @Id
    private String sIdDocumento;
    private String sIdDocumentoOcr;
    private String sTabAnterior;
    @OneToMany(mappedBy = "simdocumento")
    private List<Simmovmigra> simmovmigraList;
    @OneToMany(mappedBy = "simdocumento1")
    private List<Simmovmigra> simmovmigraList1;

    public Simdocumento() {
    }

    public String getBActivo() {
        return bActivo;
    }
    public List<Simmovmigra> getSimmovmigraList() {
       return simmovmigraList;
   }

   public void setSimmovmigraList(List<Simmovmigra> simmovmigraList) {
       this.simmovmigraList = simmovmigraList;
   }
       
    public List<Simmovmigra> getSimmovmigraList1() {
        return simmovmigraList1;
    }

    public void setSimmovmigraList1(List<Simmovmigra> simmovmigraList1) {
        this.simmovmigraList1 = simmovmigraList1;
    }

    public void setBActivo(String bActivo) {
        this.bActivo = bActivo;
    }

    public String getBUsoBusqueda() {
        return bUsoBusqueda;
    }

    public void setBUsoBusqueda(String bUsoBusqueda) {
        this.bUsoBusqueda = bUsoBusqueda;
    }

    public String getBUsoControlMov() {
        return bUsoControlMov;
    }

    public void setBUsoControlMov(String bUsoControlMov) {
        this.bUsoControlMov = bUsoControlMov;
    }

    public String getBUsoDocOficial() {
        return bUsoDocOficial;
    }

    public void setBUsoDocOficial(String bUsoDocOficial) {
        this.bUsoDocOficial = bUsoDocOficial;
    }

    public String getBUsoIdentidad() {
        return bUsoIdentidad;
    }

    public void setBUsoIdentidad(String bUsoIdentidad) {
        this.bUsoIdentidad = bUsoIdentidad;
    }

    public String getBUsoMpa() {
        return bUsoMpa;
    }

    public void setBUsoMpa(String bUsoMpa) {
        this.bUsoMpa = bUsoMpa;
    }

    public String getBUsoPasaporte() {
        return bUsoPasaporte;
    }

    public void setBUsoPasaporte(String bUsoPasaporte) {
        this.bUsoPasaporte = bUsoPasaporte;
    }

    public String getBUsoRegistro() {
        return bUsoRegistro;
    }

    public void setBUsoRegistro(String bUsoRegistro) {
        this.bUsoRegistro = bUsoRegistro;
    }

    public String getBUsoViaje() {
        return bUsoViaje;
    }

    public void setBUsoViaje(String bUsoViaje) {
        this.bUsoViaje = bUsoViaje;
    }

    public String getBUsoViajeCmp() {
        return bUsoViajeCmp;
    }

    public void setBUsoViajeCmp(String bUsoViajeCmp) {
        this.bUsoViajeCmp = bUsoViajeCmp;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }


    public Integer getNLongitud() {
        return nLongitud;
    }

    public void setNLongitud(Integer nLongitud) {
        this.nLongitud = nLongitud;
    }

    public String getSCodControlRq() {
        return sCodControlRq;
    }

    public void setSCodControlRq(String sCodControlRq) {
        this.sCodControlRq = sCodControlRq;
    }

    public String getSDescripcion() {
        return sDescripcion;
    }

    public void setSDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getSIdDocumento() {
        return sIdDocumento;
    }

    public void setSIdDocumento(String sIdDocumento) {
        this.sIdDocumento = sIdDocumento;
    }

    public String getSIdDocumentoOcr() {
        return sIdDocumentoOcr;
    }

    public void setSIdDocumentoOcr(String sIdDocumentoOcr) {
        this.sIdDocumentoOcr = sIdDocumentoOcr;
    }

    public String getSTabAnterior() {
        return sTabAnterior;
    }

    public void setSTabAnterior(String sTabAnterior) {
        this.sTabAnterior = sTabAnterior;
    }

 
}
