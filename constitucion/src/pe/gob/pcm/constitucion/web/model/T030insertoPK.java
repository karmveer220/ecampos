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
public class T030insertoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private short annTramite;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "NUM_INSERTO")
    private short numInserto;

    public T030insertoPK() {
    }

    public T030insertoPK(short annTramite, int numTramite, short numInserto) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
        this.numInserto = numInserto;
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

    public short getNumInserto() {
        return numInserto;
    }

    public void setNumInserto(short numInserto) {
        this.numInserto = numInserto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annTramite;
        hash += (int) numTramite;
        hash += (int) numInserto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T030insertoPK)) {
            return false;
        }
        T030insertoPK other = (T030insertoPK) object;
        if (this.annTramite != other.annTramite) {
            return false;
        }
        if (this.numTramite != other.numTramite) {
            return false;
        }
        if (this.numInserto != other.numInserto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T030insertoPK[annTramite=" + annTramite + ", numTramite=" + numTramite + ", numInserto=" + numInserto + "]";
    }

}
