/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t023aportebien")
public class T023aportebien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_APORTE")
    private Integer idAporte;
    @Basic(optional = false)
    @Column(name = "ID_ACCIONISTA")
    private int idAccionista;
    @Basic(optional = false)
    @Column(name = "NUM_APORTE")
    private int numAporte;
    @Basic(optional = false)
    @Column(name = "CNT_BIEN")
    private int cntBien;
    @Basic(optional = false)
    @Column(name = "DES_BIEN")
    private String desBien;
    @Basic(optional = false)
    @Column(name = "MTO_BIEN")
    private BigDecimal mtoBien;

    public T023aportebien() {
    }

    public T023aportebien(Integer idAporte) {
        this.idAporte = idAporte;
    }

    public T023aportebien(Integer idAporte, int idAccionista, int numAporte, int cntBien, String desBien, BigDecimal mtoBien) {
        this.idAporte = idAporte;
        this.idAccionista = idAccionista;
        this.numAporte = numAporte;
        this.cntBien = cntBien;
        this.desBien = desBien;
        this.mtoBien = mtoBien;
    }

    public Integer getIdAporte() {
        return idAporte;
    }

    public void setIdAporte(Integer idAporte) {
        this.idAporte = idAporte;
    }

    public int getIdAccionista() {
        return idAccionista;
    }

    public void setIdAccionista(int idAccionista) {
        this.idAccionista = idAccionista;
    }

    public int getNumAporte() {
        return numAporte;
    }

    public void setNumAporte(int numAporte) {
        this.numAporte = numAporte;
    }

    public int getCntBien() {
        return cntBien;
    }

    public void setCntBien(int cntBien) {
        this.cntBien = cntBien;
    }

    public String getDesBien() {
        return desBien;
    }

    public void setDesBien(String desBien) {
        this.desBien = desBien;
    }

    public BigDecimal getMtoBien() {
        return mtoBien;
    }

    public void setMtoBien(BigDecimal mtoBien) {
        this.mtoBien = mtoBien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAporte != null ? idAporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T023aportebien)) {
            return false;
        }
        T023aportebien other = (T023aportebien) object;
        if ((this.idAporte == null && other.idAporte != null) || (this.idAporte != null && !this.idAporte.equals(other.idAporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.model.T023aportebien[idAporte=" + idAporte + "]";
    }

}
