/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t024cargo")
public class T024cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T024cargoPK t024cargoPK;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "COD_TDOCMAN", referencedColumnName = "COD_TDOCMAN", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_DOCMAN", referencedColumnName = "NUM_DOCMAN", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private T032mandatario t032mandatario;

    public T024cargo() {
    }

    public T024cargo(T024cargoPK t024cargoPK) {
        this.t024cargoPK = t024cargoPK;
    }

    public T024cargo(short annTramite, int numTramite, String codTdocman, String numDocman, String codCargo) {
        this.t024cargoPK = new T024cargoPK(annTramite, numTramite, codTdocman, numDocman, codCargo);
    }

    public T024cargoPK getT024cargoPK() {
        return t024cargoPK;
    }

    public void setT024cargoPK(T024cargoPK t024cargoPK) {
        this.t024cargoPK = t024cargoPK;
    }

    public T032mandatario getT032mandatario() {
        return t032mandatario;
    }

    public void setT032mandatario(T032mandatario t032mandatario) {
        this.t032mandatario = t032mandatario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t024cargoPK != null ? t024cargoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T024cargo)) {
            return false;
        }
        T024cargo other = (T024cargo) object;
        if ((this.t024cargoPK == null && other.t024cargoPK != null) || (this.t024cargoPK != null && !this.t024cargoPK.equals(other.t024cargoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T024cargo[t024cargoPK=" + t024cargoPK + "]";
    }

}
