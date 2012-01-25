/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private Integer numTramite;
    @Basic(optional = false)
    @Column(name = "COD_NOTARIA")
    private String codNotaria;
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private short annTramite;
    @Basic(optional = false)
    @Column(name = "COD_TIPSOC")
    private String codTipsoc;
    @Basic(optional = false)
    @Column(name = "COD_ZONREG")
    private String codZonreg;
    @Basic(optional = false)
    @Column(name = "COD_OFICREG")
    private String codOficreg;
    @Basic(optional = false)
    @Column(name = "COD_PRESENTA")
    private String codPresenta;
    @Basic(optional = false)
    @Column(name = "CLV_KARDEX")
    private String clvKardex;
    @Basic(optional = false)
    @Column(name = "IND_LIBROSOC")
    private char indLibrosoc;
    @Basic(optional = false)
    @Column(name = "IND_LIBROCON")
    private char indLibrocon;
    @Basic(optional = false)
    @Column(name = "NUM_CUO")
    private String numCuo;
    @Basic(optional = false)
    @Column(name = "IND_CUO")
    private char indCuo;
    @Basic(optional = false)
    @Column(name = "FEC_CUO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCuo;
    @Basic(optional = false)
    @Column(name = "COD_TDOCSOL")
    private String codTdocsol;
    @Basic(optional = false)
    @Column(name = "NUM_DOCSOL")
    private String numDocsol;
    @Basic(optional = false)
    @Column(name = "NUM_TITULO")
    private String numTitulo;
    @Basic(optional = false)
    @Column(name = "NOM_RAZSOC")
    private String nomRazsoc;
    @Basic(optional = false)
    @Column(name = "NOM_DENABREV")
    private String nomDenabrev;
    @Basic(optional = false)
    @Column(name = "COD_UBIGEO")
    private String codUbigeo;
    @Basic(optional = false)
    @Column(name = "IND_APORTE")
    private char indAporte;
    @Basic(optional = false)
    @Column(name = "MTO_APORTE")
    private BigDecimal mtoAporte;
    @Basic(optional = false)
    @Column(name = "MTO_VALORACCION")
    private BigDecimal mtoValoraccion;
    @Basic(optional = false)
    @Column(name = "MTO_ACCIONPART")
    private BigDecimal mtoAccionpart;
    @Basic(optional = false)
    @Column(name = "IND_CANCECAPI")
    private char indCancecapi;
    @Basic(optional = false)
    @Column(name = "NUM_PORCENCANC")
    private int numPorcencanc;
    @Basic(optional = false)
    @Column(name = "MTO_DEREREGIS")
    private BigDecimal mtoDereregis;
    @Basic(optional = false)
    @Column(name = "IND_FORMAPAGO")
    private char indFormapago;
    @Basic(optional = false)
    @Column(name = "IND_PSC")
    private char indPsc;
    @Basic(optional = false)
    @Column(name = "IND_ESTADO")
    private char indEstado;
    @Basic(optional = false)
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Basic(optional = false)
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Basic(optional = false)
    @Column(name = "FEC_CERRADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCerrado;
    @Basic(optional = false)
    @Column(name = "FEC_FIRMADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFirmado;
    @Basic(optional = false)
    @Column(name = "IND_ELIMINADO")
    private char indEliminado;
    @Basic(optional = false)
    @Column(name = "FEC_ELIMINADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminado;
    @Basic(optional = false)
    @Column(name = "IND_ENVIO")
    private char indEnvio;
    @Basic(optional = false)
    @Column(name = "FEC_ENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEnvio;
    @Basic(optional = false)
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Basic(optional = false)
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;

    public T020tramite() {
    }

    public T020tramite(Integer numTramite) {
        this.numTramite = numTramite;
    }

    public T020tramite(Integer numTramite, String codNotaria, short annTramite, String codTipsoc, String codZonreg, String codOficreg, String codPresenta, String clvKardex, char indLibrosoc, char indLibrocon, String numCuo, char indCuo, Date fecCuo, String codTdocsol, String numDocsol, String numTitulo, String nomRazsoc, String nomDenabrev, String codUbigeo, char indAporte, BigDecimal mtoAporte, BigDecimal mtoValoraccion, BigDecimal mtoAccionpart, char indCancecapi, int numPorcencanc, BigDecimal mtoDereregis, char indFormapago, char indPsc, char indEstado, Date fecIngreso, Date fecRegistro, Date fecCerrado, Date fecFirmado, char indEliminado, Date fecEliminado, char indEnvio, Date fecEnvio, String codUsumodif, Date fecModif) {
        this.numTramite = numTramite;
        this.codNotaria = codNotaria;
        this.annTramite = annTramite;
        this.codTipsoc = codTipsoc;
        this.codZonreg = codZonreg;
        this.codOficreg = codOficreg;
        this.codPresenta = codPresenta;
        this.clvKardex = clvKardex;
        this.indLibrosoc = indLibrosoc;
        this.indLibrocon = indLibrocon;
        this.numCuo = numCuo;
        this.indCuo = indCuo;
        this.fecCuo = fecCuo;
        this.codTdocsol = codTdocsol;
        this.numDocsol = numDocsol;
        this.numTitulo = numTitulo;
        this.nomRazsoc = nomRazsoc;
        this.nomDenabrev = nomDenabrev;
        this.codUbigeo = codUbigeo;
        this.indAporte = indAporte;
        this.mtoAporte = mtoAporte;
        this.mtoValoraccion = mtoValoraccion;
        this.mtoAccionpart = mtoAccionpart;
        this.indCancecapi = indCancecapi;
        this.numPorcencanc = numPorcencanc;
        this.mtoDereregis = mtoDereregis;
        this.indFormapago = indFormapago;
        this.indPsc = indPsc;
        this.indEstado = indEstado;
        this.fecIngreso = fecIngreso;
        this.fecRegistro = fecRegistro;
        this.fecCerrado = fecCerrado;
        this.fecFirmado = fecFirmado;
        this.indEliminado = indEliminado;
        this.fecEliminado = fecEliminado;
        this.indEnvio = indEnvio;
        this.fecEnvio = fecEnvio;
        this.codUsumodif = codUsumodif;
        this.fecModif = fecModif;
    }

    public Integer getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(Integer numTramite) {
        this.numTramite = numTramite;
    }

    public String getCodNotaria() {
        return codNotaria;
    }

    public void setCodNotaria(String codNotaria) {
        this.codNotaria = codNotaria;
    }

    public short getAnnTramite() {
        return annTramite;
    }

    public void setAnnTramite(short annTramite) {
        this.annTramite = annTramite;
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

    public char getIndLibrosoc() {
        return indLibrosoc;
    }

    public void setIndLibrosoc(char indLibrosoc) {
        this.indLibrosoc = indLibrosoc;
    }

    public char getIndLibrocon() {
        return indLibrocon;
    }

    public void setIndLibrocon(char indLibrocon) {
        this.indLibrocon = indLibrocon;
    }

    public String getNumCuo() {
        return numCuo;
    }

    public void setNumCuo(String numCuo) {
        this.numCuo = numCuo;
    }

    public char getIndCuo() {
        return indCuo;
    }

    public void setIndCuo(char indCuo) {
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

    public char getIndAporte() {
        return indAporte;
    }

    public void setIndAporte(char indAporte) {
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

    public char getIndCancecapi() {
        return indCancecapi;
    }

    public void setIndCancecapi(char indCancecapi) {
        this.indCancecapi = indCancecapi;
    }

    public int getNumPorcencanc() {
        return numPorcencanc;
    }

    public void setNumPorcencanc(int numPorcencanc) {
        this.numPorcencanc = numPorcencanc;
    }

    public BigDecimal getMtoDereregis() {
        return mtoDereregis;
    }

    public void setMtoDereregis(BigDecimal mtoDereregis) {
        this.mtoDereregis = mtoDereregis;
    }

    public char getIndFormapago() {
        return indFormapago;
    }

    public void setIndFormapago(char indFormapago) {
        this.indFormapago = indFormapago;
    }

    public char getIndPsc() {
        return indPsc;
    }

    public void setIndPsc(char indPsc) {
        this.indPsc = indPsc;
    }

    public char getIndEstado() {
        return indEstado;
    }

    public void setIndEstado(char indEstado) {
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

    public char getIndEliminado() {
        return indEliminado;
    }

    public void setIndEliminado(char indEliminado) {
        this.indEliminado = indEliminado;
    }

    public Date getFecEliminado() {
        return fecEliminado;
    }

    public void setFecEliminado(Date fecEliminado) {
        this.fecEliminado = fecEliminado;
    }

    public char getIndEnvio() {
        return indEnvio;
    }

    public void setIndEnvio(char indEnvio) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTramite != null ? numTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T020tramite)) {
            return false;
        }
        T020tramite other = (T020tramite) object;
        if ((this.numTramite == null && other.numTramite != null) || (this.numTramite != null && !this.numTramite.equals(other.numTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.model.T020tramite[numTramite=" + numTramite + "]";
    }

}
