/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t031plantilla")
public class T031plantilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T031plantillaPK t031plantillaPK;
    @Lob
    @Column(name = "ARC_PLANTILLA")
    private byte[] arcPlantilla;
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;
    @JoinColumn(name = "COD_NOTARIA", referencedColumnName = "COD_NOTARIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private T021notaria t021notaria;

    public T031plantilla() {
    }

    public T031plantilla(T031plantillaPK t031plantillaPK) {
        this.t031plantillaPK = t031plantillaPK;
    }

    public T031plantilla(String codNotaria, String codTipsoc) {
        this.t031plantillaPK = new T031plantillaPK(codNotaria, codTipsoc);
    }

    public T031plantillaPK getT031plantillaPK() {
        return t031plantillaPK;
    }

    public void setT031plantillaPK(T031plantillaPK t031plantillaPK) {
        this.t031plantillaPK = t031plantillaPK;
    }

    public byte[] getArcPlantilla() {
        return arcPlantilla;
    }

    public void setArcPlantilla(byte[] arcPlantilla) {
        this.arcPlantilla = arcPlantilla;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getCodUsumodif() {
        return codUsumodif;
    }

    public void setCodUsumodif(String codUsumodif) {
        this.codUsumodif = codUsumodif;
    }

    public Date getFecModif() {
        return fecModif;
    }

    public void setFecModif(Date fecModif) {
        this.fecModif = fecModif;
    }

    public T021notaria getT021notaria() {
        return t021notaria;
    }

    public void setT021notaria(T021notaria t021notaria) {
        this.t021notaria = t021notaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t031plantillaPK != null ? t031plantillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T031plantilla)) {
            return false;
        }
        T031plantilla other = (T031plantilla) object;
        if ((this.t031plantillaPK == null && other.t031plantillaPK != null) || (this.t031plantillaPK != null && !this.t031plantillaPK.equals(other.t031plantillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T031plantilla[t031plantillaPK=" + t031plantillaPK + "]";
    }

}
