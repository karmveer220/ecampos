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
public class T022accionistaPK implements Serializable {
	
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private String annTramite;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private String numTramite;
    @Basic(optional = false)
    @Column(name = "COD_TIPDOC")
    private String codTipdoc;
    @Basic(optional = false)
    @Column(name = "NUM_DOCUM")
    private String numDocum;

    public T022accionistaPK() {
    }

    public T022accionistaPK(String annTramite, String numTramite, String codTipdoc, String numDocum) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
        this.codTipdoc = codTipdoc;
        this.numDocum = numDocum;
    }

    public String getAnnTramite() {
        return annTramite;
    }

    public void setAnnTramite(String annTramite) {
        this.annTramite = annTramite;
    }

    public String getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(String numTramite) {
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
        hash += (annTramite != null ? annTramite.hashCode() : 0);
        hash += (numTramite != null ? numTramite.hashCode() : 0);
        hash += (codTipdoc != null ? codTipdoc.hashCode() : 0);
        hash += (numDocum != null ? numDocum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T022accionistaPK)) {
            return false;
        }
        T022accionistaPK other = (T022accionistaPK) object;
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
        return "pe.gob.pcm.constitucion.web.model.T022accionistaPK[annTramite=" + annTramite + ", numTramite=" + numTramite + ", codTipdoc=" + codTipdoc + ", numDocum=" + numDocum + "]";
    }

}
