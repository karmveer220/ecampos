/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t023aportebien")
public class T023aportebien implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T023aportebienPK t023aportebienPK;
    @Column(name = "CNT_BIEN")
    private Integer cntBien;
    @Column(name = "DES_BIEN")
    private String desBien;
    @Column(name = "MTO_BIEN")
    private BigDecimal mtoBien;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPDOC", referencedColumnName = "COD_TIPDOC", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_DOCUM", referencedColumnName = "NUM_DOCUM", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private T022accionista t022accionista;

    public T023aportebien() {
    }

    public T023aportebien(T023aportebienPK t023aportebienPK) {
        this.t023aportebienPK = t023aportebienPK;
    }

    public T023aportebien(short annTramite, int numTramite, String codTipdoc, String numDocum, int numAporte) {
        this.t023aportebienPK = new T023aportebienPK(annTramite, numTramite, codTipdoc, numDocum, numAporte);
    }

    public T023aportebienPK getT023aportebienPK() {
        return t023aportebienPK;
    }

    public void setT023aportebienPK(T023aportebienPK t023aportebienPK) {
        this.t023aportebienPK = t023aportebienPK;
    }

    public Integer getCntBien() {
        return cntBien;
    }

    public void setCntBien(Integer cntBien) {
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

    public T022accionista getT022accionista() {
        return t022accionista;
    }

    public void setT022accionista(T022accionista t022accionista) {
        this.t022accionista = t022accionista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t023aportebienPK != null ? t023aportebienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T023aportebien)) {
            return false;
        }
        T023aportebien other = (T023aportebien) object;
        if ((this.t023aportebienPK == null && other.t023aportebienPK != null) || (this.t023aportebienPK != null && !this.t023aportebienPK.equals(other.t023aportebienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T023aportebien[t023aportebienPK=" + t023aportebienPK + "]";
    }

}
