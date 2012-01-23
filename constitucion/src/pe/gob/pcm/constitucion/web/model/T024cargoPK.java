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
public class T024cargoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private short annTramite;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "COD_TDOCMAN")
    private String codTdocman;
    @Basic(optional = false)
    @Column(name = "NUM_DOCMAN")
    private String numDocman;
    @Basic(optional = false)
    @Column(name = "COD_CARGO")
    private String codCargo;

    public T024cargoPK() {
    }

    public T024cargoPK(short annTramite, int numTramite, String codTdocman, String numDocman, String codCargo) {
        this.annTramite = annTramite;
        this.numTramite = numTramite;
        this.codTdocman = codTdocman;
        this.numDocman = numDocman;
        this.codCargo = codCargo;
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

    public String getCodTdocman() {
        return codTdocman;
    }

    public void setCodTdocman(String codTdocman) {
        this.codTdocman = codTdocman;
    }

    public String getNumDocman() {
        return numDocman;
    }

    public void setNumDocman(String numDocman) {
        this.numDocman = numDocman;
    }

    public String getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(String codCargo) {
        this.codCargo = codCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annTramite;
        hash += (int) numTramite;
        hash += (codTdocman != null ? codTdocman.hashCode() : 0);
        hash += (numDocman != null ? numDocman.hashCode() : 0);
        hash += (codCargo != null ? codCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T024cargoPK)) {
            return false;
        }
        T024cargoPK other = (T024cargoPK) object;
        if (this.annTramite != other.annTramite) {
            return false;
        }
        if (this.numTramite != other.numTramite) {
            return false;
        }
        if ((this.codTdocman == null && other.codTdocman != null) || (this.codTdocman != null && !this.codTdocman.equals(other.codTdocman))) {
            return false;
        }
        if ((this.numDocman == null && other.numDocman != null) || (this.numDocman != null && !this.numDocman.equals(other.numDocman))) {
            return false;
        }
        if ((this.codCargo == null && other.codCargo != null) || (this.codCargo != null && !this.codCargo.equals(other.codCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T024cargoPK[annTramite=" + annTramite + ", numTramite=" + numTramite + ", codTdocman=" + codTdocman + ", numDocman=" + numDocman + ", codCargo=" + codCargo + "]";
    }

}
