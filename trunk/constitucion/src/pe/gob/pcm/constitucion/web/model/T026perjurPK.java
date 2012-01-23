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
public class T026perjurPK implements Serializable {
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

    public T026perjurPK() {
    }

    public T026perjurPK(short annTramite, int numTramite, String codTipdoc, String numDocum) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
        this.codTipdoc = codTipdoc;
        this.numDocum = numDocum;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annTramite;
        hash += (int) numTramite;
        hash += (codTipdoc != null ? codTipdoc.hashCode() : 0);
        hash += (numDocum != null ? numDocum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T026perjurPK)) {
            return false;
        }
        T026perjurPK other = (T026perjurPK) object;
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
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T026perjurPK[annTramite=" + annTramite + ", numTramite=" + numTramite + ", codTipdoc=" + codTipdoc + ", numDocum=" + numDocum + "]";
    }

}
