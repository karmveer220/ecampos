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
public class T029archivoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private short annTramite;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "NUM_ARCHIVO")
    private short numArchivo;

    public T029archivoPK() {
    }

    public T029archivoPK(short annTramite, int numTramite, short numArchivo) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
        this.numArchivo = numArchivo;
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

    public short getNumArchivo() {
        return numArchivo;
    }

    public void setNumArchivo(short numArchivo) {
        this.numArchivo = numArchivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annTramite;
        hash += (int) numTramite;
        hash += (int) numArchivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T029archivoPK)) {
            return false;
        }
        T029archivoPK other = (T029archivoPK) object;
        if (this.annTramite != other.annTramite) {
            return false;
        }
        if (this.numTramite != other.numTramite) {
            return false;
        }
        if (this.numArchivo != other.numArchivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T029archivoPK[annTramite=" + annTramite + ", numTramite=" + numTramite + ", numArchivo=" + numArchivo + "]";
    }

}
