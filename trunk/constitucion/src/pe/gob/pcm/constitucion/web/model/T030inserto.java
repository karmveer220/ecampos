/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t030inserto")
public class T030inserto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T030insertoPK t030insertoPK;
    @Column(name = "IND_TIPINSERTO")
    private Character indTipinserto;
    @Lob
    @Column(name = "DES_INSERTO")
    private String desInserto;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private T020tramite t020tramite;

    public T030inserto() {
    }

    public T030inserto(T030insertoPK t030insertoPK) {
        this.t030insertoPK = t030insertoPK;
    }

    public T030inserto(short annTramite, int numTramite, short numInserto) {
        this.t030insertoPK = new T030insertoPK(annTramite, numTramite, numInserto);
    }

    public T030insertoPK getT030insertoPK() {
        return t030insertoPK;
    }

    public void setT030insertoPK(T030insertoPK t030insertoPK) {
        this.t030insertoPK = t030insertoPK;
    }

    public Character getIndTipinserto() {
        return indTipinserto;
    }

    public void setIndTipinserto(Character indTipinserto) {
        this.indTipinserto = indTipinserto;
    }

    public String getDesInserto() {
        return desInserto;
    }

    public void setDesInserto(String desInserto) {
        this.desInserto = desInserto;
    }

    public T020tramite getT020tramite() {
        return t020tramite;
    }

    public void setT020tramite(T020tramite t020tramite) {
        this.t020tramite = t020tramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t030insertoPK != null ? t030insertoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T030inserto)) {
            return false;
        }
        T030inserto other = (T030inserto) object;
        if ((this.t030insertoPK == null && other.t030insertoPK != null) || (this.t030insertoPK != null && !this.t030insertoPK.equals(other.t030insertoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T030inserto[t030insertoPK=" + t030insertoPK + "]";
    }

}
