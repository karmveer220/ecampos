/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author elvis
 */
@Embeddable
public class T027perjurrepPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private short annTramite;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "COD_TIPDOC")
    private String codTipdoc;
    @Basic(optional = false)
    @Column(name = "NUM_DOCUM")
    private String numDocum;
    @Basic(optional = false)
    @Column(name = "COD_TDOCREP")
    private String codTdocrep;
    @Basic(optional = false)
    @Column(name = "NUM_DOCREP")
    private String numDocrep;

    public T027perjurrepPK() {
    }

    public T027perjurrepPK(short annTramite, int numTramite, String codTipdoc, String numDocum, String codTdocrep, String numDocrep) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
        this.codTipdoc = codTipdoc;
        this.numDocum = numDocum;
        this.codTdocrep = codTdocrep;
        this.numDocrep = numDocrep;
    }

    public short getAnnTramite() {
        return annTramite;
    }

    public void setAnnTramite(short annTramite) {
        this.annTramite = annTramite;
    }

    public int getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(int numTramite) {
        this.numTramite = numTramite;
    }

    public String getCodTipdoc() {
        return codTipdoc;
    }

    public void setCodTipdoc(String codTipdoc) {
        this.codTipdoc = codTipdoc;
    }

    public String getNumDocum() {
        return numDocum;
    }

    public void setNumDocum(String numDocum) {
        this.numDocum = numDocum;
    }

    public String getCodTdocrep() {
        return codTdocrep;
    }

    public void setCodTdocrep(String codTdocrep) {
        this.codTdocrep = codTdocrep;
    }

    public String getNumDocrep() {
        return numDocrep;
    }

    public void setNumDocrep(String numDocrep) {
        this.numDocrep = numDocrep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annTramite;
        hash += (int) numTramite;
        hash += (codTipdoc != null ? codTipdoc.hashCode() : 0);
        hash += (numDocum != null ? numDocum.hashCode() : 0);
        hash += (codTdocrep != null ? codTdocrep.hashCode() : 0);
        hash += (numDocrep != null ? numDocrep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T027perjurrepPK)) {
            return false;
        }
        T027perjurrepPK other = (T027perjurrepPK) object;
        if (this.annTramite != other.annTramite) {
            return false;
        }
        if (this.numTramite != other.numTramite) {
            return false;
        }
        if ((this.codTipdoc == null && other.codTipdoc != null) || (this.codTipdoc != null && !this.codTipdoc.equals(other.codTipdoc))) {
            return false;
        }
        if ((this.numDocum == null && other.numDocum != null) || (this.numDocum != null && !this.numDocum.equals(other.numDocum))) {
            return false;
        }
        if ((this.codTdocrep == null && other.codTdocrep != null) || (this.codTdocrep != null && !this.codTdocrep.equals(other.codTdocrep))) {
            return false;
        }
        if ((this.numDocrep == null && other.numDocrep != null) || (this.numDocrep != null && !this.numDocrep.equals(other.numDocrep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T027perjurrepPK[annTramite=" + annTramite + ", numTramite=" + numTramite + ", codTipdoc=" + codTipdoc + ", numDocum=" + numDocum + ", codTdocrep=" + codTdocrep + ", numDocrep=" + numDocrep + "]";
    }

}
