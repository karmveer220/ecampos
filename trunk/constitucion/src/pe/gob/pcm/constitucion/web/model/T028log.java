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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t028log")
public class T028log implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T028logPK t028logPK;
    @Column(name = "COD_OPERACION")
    private String codOperacion;
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE"),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE")})
    @ManyToOne
    private T020tramite t020tramite;

    public T028log() {
    }

    public T028log(T028logPK t028logPK) {
        this.t028logPK = t028logPK;
    }

    public T028log(short annLog, int numLog) {
        this.t028logPK = new T028logPK(annLog, numLog);
    }

    public T028logPK getT028logPK() {
        return t028logPK;
    }

    public void setT028logPK(T028logPK t028logPK) {
        this.t028logPK = t028logPK;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
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

    public T020tramite getT020tramite() {
        return t020tramite;
    }

    public void setT020tramite(T020tramite t020tramite) {
        this.t020tramite = t020tramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t028logPK != null ? t028logPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T028log)) {
            return false;
        }
        T028log other = (T028log) object;
        if ((this.t028logPK == null && other.t028logPK != null) || (this.t028logPK != null && !this.t028logPK.equals(other.t028logPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T028log[t028logPK=" + t028logPK + "]";
    }

}
