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
public class T020tramitePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private int annTramite;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;

    public T020tramitePK() {
    }

    public T020tramitePK(int annTramite, int numTramite) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
    }

    public int getAnnTramite() {
        return annTramite;
    }

    public void setAnnTramite(int annTramite) {
        this.annTramite = annTramite;
    }

    public int getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(int numTramite) {
        this.numTramite = numTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annTramite;
        hash += (int) numTramite;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T020tramitePK)) {
            return false;
        }
        T020tramitePK other = (T020tramitePK) object;
        if (this.annTramite != other.annTramite) {
            return false;
        }
        if (this.numTramite != other.numTramite) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T020tramitePK[annTramite=" + annTramite + ", numTramite=" + numTramite + "]";
    }

}
