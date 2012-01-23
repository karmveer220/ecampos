/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t020tramite")
public class T020tramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T020tramitePK t020tramitePK;
    @Column(name = "COD_TIPSOC")
    private String codTipsoc;
    @Column(name = "COD_ZONREG")
    private String codZonreg;
    @Column(name = "COD_OFICREG")
    private String codOficreg;
    @Column(name = "COD_PRESENTA")
    private String codPresenta;
    @Column(name = "CLV_KARDEX")
    private String clvKardex;
    @Column(name = "IND_LIBROSOC")
    private Character indLibrosoc;
    @Column(name = "IND_LIBROCON")
    private Character indLibrocon;
    @Column(name = "NUM_CUO")
    private String numCuo;
    @Column(name = "IND_CUO")
    private Character indCuo;
    @Column(name = "FEC_CUO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCuo;
    @Column(name = "COD_TDOCSOL")
    private String codTdocsol;
    @Column(name = "NUM_DOCSOL")
    private String numDocsol;
    @Column(name = "NUM_TITULO")
    private String numTitulo;
    @Basic(optional = false)
    @Column(name = "NOM_RAZSOC")
    private String nomRazsoc;
    @Column(name = "NOM_DENABREV")
    private String nomDenabrev;
    @Column(name = "COD_UBIGEO")
    private String codUbigeo;
    @Column(name = "IND_APORTE")
    private Character indAporte;
    @Column(name = "MTO_APORTE")
    private BigDecimal mtoAporte;
    @Column(name = "MTO_VALORACCION")
    private BigDecimal mtoValoraccion;
    @Column(name = "MTO_ACCIONPART")
    private BigDecimal mtoAccionpart;
    @Column(name = "IND_CANCECAPI")
    private Character indCancecapi;
    @Column(name = "NUM_PORCENCANC")
    private Integer numPorcencanc;
    @Column(name = "MTO_DEREREGIS")
    private BigDecimal mtoDereregis;
    @Column(name = "IND_FORMAPAGO")
    private Character indFormapago;
    @Column(name = "IND_PSC")
    private Character indPsc;
    @Column(name = "IND_ESTADO")
    private Character indEstado;
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Column(name = "FEC_CERRADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCerrado;
    @Column(name = "FEC_FIRMADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFirmado;
    @Column(name = "IND_ELIMINADO")
    private Character indEliminado;
    @Column(name = "FEC_ELIMINADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminado;
    @Column(name = "IND_ENVIO")
    private Character indEnvio;
    @Column(name = "FEC_ENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEnvio;
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t020tramite")
    private List<T022accionista> t022accionistaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t020tramite")
    private List<T030inserto> t030insertoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t020tramite")
    private List<T032mandatario> t032mandatarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t020tramite")
    private List<T029archivo> t029archivoList;
    @OneToMany(mappedBy = "t020tramite")
    private List<T028log> t028logList;
    @JoinColumn(name = "COD_NOTARIA", referencedColumnName = "COD_NOTARIA")
    @ManyToOne
    private T021notaria t021notaria;

    public T020tramite() {
    }

    public T020tramite(T020tramitePK t020tramitePK) {
        this.t020tramitePK = t020tramitePK;
    }

    public T020tramite(T020tramitePK t020tramitePK, String nomRazsoc) {
        this.t020tramitePK = t020tramitePK;
        this.nomRazsoc = nomRazsoc;
    }

    public T020tramite(short annTramite, int numTramite) {
        this.t020tramitePK = new T020tramitePK(annTramite, numTramite);
    }

    public T020tramitePK getT020tramitePK() {
        return t020tramitePK;
    }

    public void setT020tramitePK(T020tramitePK t020tramitePK) {
        this.t020tramitePK = t020tramitePK;
    }

    public String getCodTipsoc() {
        return codTipsoc;
    }

    public void setCodTipsoc(String codTipsoc) {
        this.codTipsoc = codTipsoc;
    }

    public String getCodZonreg() {
        return codZonreg;
    }

    public void setCodZonreg(String codZonreg) {
        this.codZonreg = codZonreg;
    }

    public String getCodOficreg() {
        return codOficreg;
    }

    public void setCodOficreg(String codOficreg) {
        this.codOficreg = codOficreg;
    }

    public String getCodPresenta() {
        return codPresenta;
    }

    public void setCodPresenta(String codPresenta) {
        this.codPresenta = codPresenta;
    }

    public String getClvKardex() {
        return clvKardex;
    }

    public void setClvKardex(String clvKardex) {
        this.clvKardex = clvKardex;
    }

    public Character getIndLibrosoc() {
        return indLibrosoc;
    }

    public void setIndLibrosoc(Character indLibrosoc) {
        this.indLibrosoc = indLibrosoc;
    }

    public Character getIndLibrocon() {
        return indLibrocon;
    }

    public void setIndLibrocon(Character indLibrocon) {
        this.indLibrocon = indLibrocon;
    }

    public String getNumCuo() {
        return numCuo;
    }

    public void setNumCuo(String numCuo) {
        this.numCuo = numCuo;
    }

    public Character getIndCuo() {
        return indCuo;
    }

    public void setIndCuo(Character indCuo) {
        this.indCuo = indCuo;
    }

    public Date getFecCuo() {
        return fecCuo;
    }

    public void setFecCuo(Date fecCuo) {
        this.fecCuo = fecCuo;
    }

    public String getCodTdocsol() {
        return codTdocsol;
    }

    public void setCodTdocsol(String codTdocsol) {
        this.codTdocsol = codTdocsol;
    }

    public String getNumDocsol() {
        return numDocsol;
    }

    public void setNumDocsol(String numDocsol) {
        this.numDocsol = numDocsol;
    }

    public String getNumTitulo() {
        return numTitulo;
    }

    public void setNumTitulo(String numTitulo) {
        this.numTitulo = numTitulo;
    }

    public String getNomRazsoc() {
        return nomRazsoc;
    }

    public void setNomRazsoc(String nomRazsoc) {
        this.nomRazsoc = nomRazsoc;
    }

    public String getNomDenabrev() {
        return nomDenabrev;
    }

    public void setNomDenabrev(String nomDenabrev) {
        this.nomDenabrev = nomDenabrev;
    }

    public String getCodUbigeo() {
        return codUbigeo;
    }

    public void setCodUbigeo(String codUbigeo) {
        this.codUbigeo = codUbigeo;
    }

    public Character getIndAporte() {
        return indAporte;
    }

    public void setIndAporte(Character indAporte) {
        this.indAporte = indAporte;
    }

    public BigDecimal getMtoAporte() {
        return mtoAporte;
    }

    public void setMtoAporte(BigDecimal mtoAporte) {
        this.mtoAporte = mtoAporte;
    }

    public BigDecimal getMtoValoraccion() {
        return mtoValoraccion;
    }

    public void setMtoValoraccion(BigDecimal mtoValoraccion) {
        this.mtoValoraccion = mtoValoraccion;
    }

    public BigDecimal getMtoAccionpart() {
        return mtoAccionpart;
    }

    public void setMtoAccionpart(BigDecimal mtoAccionpart) {
        this.mtoAccionpart = mtoAccionpart;
    }

    public Character getIndCancecapi() {
        return indCancecapi;
    }

    public void setIndCancecapi(Character indCancecapi) {
        this.indCancecapi = indCancecapi;
    }

    public Integer getNumPorcencanc() {
        return numPorcencanc;
    }

    public void setNumPorcencanc(Integer numPorcencanc) {
        this.numPorcencanc = numPorcencanc;
    }

    public BigDecimal getMtoDereregis() {
        return mtoDereregis;
    }

    public void setMtoDereregis(BigDecimal mtoDereregis) {
        this.mtoDereregis = mtoDereregis;
    }

    public Character getIndFormapago() {
        return indFormapago;
    }

    public void setIndFormapago(Character indFormapago) {
        this.indFormapago = indFormapago;
    }

    public Character getIndPsc() {
        return indPsc;
    }

    public void setIndPsc(Character indPsc) {
        this.indPsc = indPsc;
    }

    public Character getIndEstado() {
        return indEstado;
    }

    public void setIndEstado(Character indEstado) {
        this.indEstado = indEstado;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public Date getFecCerrado() {
        return fecCerrado;
    }

    public void setFecCerrado(Date fecCerrado) {
        this.fecCerrado = fecCerrado;
    }

    public Date getFecFirmado() {
        return fecFirmado;
    }

    public void setFecFirmado(Date fecFirmado) {
        this.fecFirmado = fecFirmado;
    }

    public Character getIndEliminado() {
        return indEliminado;
    }

    public void setIndEliminado(Character indEliminado) {
        this.indEliminado = indEliminado;
    }

    public Date getFecEliminado() {
        return fecEliminado;
    }

    public void setFecEliminado(Date fecEliminado) {
        this.fecEliminado = fecEliminado;
    }

    public Character getIndEnvio() {
        return indEnvio;
    }

    public void setIndEnvio(Character indEnvio) {
        this.indEnvio = indEnvio;
    }

    public Date getFecEnvio() {
        return fecEnvio;
    }

    public void setFecEnvio(Date fecEnvio) {
        this.fecEnvio = fecEnvio;
    }

    public String getCodUsumodif() {
        return codUsumodif;
    }

    public void setCodUsumodif(String codUsumodif) {
        this.codUsumodif = codUsumodif;
    }

    public Date getFecModif() {
        return fecModif;
    }

    public void setFecModif(Date fecModif) {
        this.fecModif = fecModif;
    }

    public List<T022accionista> getT022accionistaList() {
        return t022accionistaList;
    }

    public void setT022accionistaList(List<T022accionista> t022accionistaList) {
        this.t022accionistaList = t022accionistaList;
    }

    public List<T030inserto> getT030insertoList() {
        return t030insertoList;
    }

    public void setT030insertoList(List<T030inserto> t030insertoList) {
        this.t030insertoList = t030insertoList;
    }

    public List<T032mandatario> getT032mandatarioList() {
        return t032mandatarioList;
    }

    public void setT032mandatarioList(List<T032mandatario> t032mandatarioList) {
        this.t032mandatarioList = t032mandatarioList;
    }

    public List<T029archivo> getT029archivoList() {
        return t029archivoList;
    }

    public void setT029archivoList(List<T029archivo> t029archivoList) {
        this.t029archivoList = t029archivoList;
    }

    public List<T028log> getT028logList() {
        return t028logList;
    }

    public void setT028logList(List<T028log> t028logList) {
        this.t028logList = t028logList;
    }

    public T021notaria getT021notaria() {
        return t021notaria;
    }

    public void setT021notaria(T021notaria t021notaria) {
        this.t021notaria = t021notaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t020tramitePK != null ? t020tramitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T020tramite)) {
            return false;
        }
        T020tramite other = (T020tramite) object;
        if ((this.t020tramitePK == null && other.t020tramitePK != null) || (this.t020tramitePK != null && !this.t020tramitePK.equals(other.t020tramitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T020tramite[t020tramitePK=" + t020tramitePK + "]";
    }

}
