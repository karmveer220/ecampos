/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_LOG")
    private Integer numLog;
    @Column(name = "ANN_LOG")
    private Short annLog;
    @Column(name = "ANN_TRAMITE")
    private Short annTramite;
    @Column(name = "NUM_TRAMITE")
    private Integer numTramite;
    @Column(name = "COD_OPERACION")
    private String codOperacion;
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;

    public T028log() {
    }

    public T028log(Integer numLog) {
        this.numLog = numLog;
    }

    public Integer getNumLog() {
        return numLog;
    }

    public void setNumLog(Integer numLog) {
        this.numLog = numLog;
    }

    public Short getAnnLog() {
        return annLog;
    }

    public void setAnnLog(Short annLog) {
        this.annLog = annLog;
    }

    public Short getAnnTramite() {
        return annTramite;
    }

    public void setAnnTramite(Short annTramite) {
        this.annTramite = annTramite;
    }

    public Integer getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(Integer numTramite) {
        this.numTramite = numTramite;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numLog != null ? numLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T028log)) {
            return false;
        }
        T028log other = (T028log) object;
        if ((this.numLog == null && other.numLog != null) || (this.numLog != null && !this.numLog.equals(other.numLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T028log[numLog=" + numLog + "]";
    }

}
