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
public class T033solicitantePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private short annTramite;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "COD_TDOCSOL")
    private String codTdocsol;
    @Basic(optional = false)
    @Column(name = "NUM_DOCSOL")
    private String numDocsol;

    public T033solicitantePK() {
    }

    public T033solicitantePK(short annTramite, int numTramite, String codTdocsol, String numDocsol) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
        this.codTdocsol = codTdocsol;
        this.numDocsol = numDocsol;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annTramite;
        hash += (int) numTramite;
        hash += (codTdocsol != null ? codTdocsol.hashCode() : 0);
        hash += (numDocsol != null ? numDocsol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T033solicitantePK)) {
            return false;
        }
        T033solicitantePK other = (T033solicitantePK) object;
        if (this.annTramite != other.annTramite) {
            return false;
        }
        if (this.numTramite != other.numTramite) {
            return false;
        }
        if ((this.codTdocsol == null && other.codTdocsol != null) || (this.codTdocsol != null && !this.codTdocsol.equals(other.codTdocsol))) {
            return false;
        }
        if ((this.numDocsol == null && other.numDocsol != null) || (this.numDocsol != null && !this.numDocsol.equals(other.numDocsol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T033solicitantePK[annTramite=" + annTramite + ", numTramite=" + numTramite + ", codTdocsol=" + codTdocsol + ", numDocsol=" + numDocsol + "]";
    }

}
