/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t022accionista")
public class T022accionista implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T022accionistaPK t022accionistaPK;
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Column(name = "IND_APORTE")
    private Character indAporte;
    @Column(name = "MTO_APORTE")
    private BigDecimal mtoAporte;
    @Column(name = "COD_PARTICIPA")
    private String codParticipa;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private T020tramite t020tramite;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "t022accionista")
    private T026perjur t026perjur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t022accionista")
    private List<T023aportebien> t023aportebienList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "t022accionista")
    private T025pernat t025pernat;

    public T022accionista() {
    }

    public T022accionista(T022accionistaPK t022accionistaPK) {
        this.t022accionistaPK = t022accionistaPK;
    }

    public T022accionista(String annTramite, String numTramite, String codTipdoc, String numDocum) {
        this.t022accionistaPK = new T022accionistaPK(annTramite, numTramite, codTipdoc, numDocum);
    }

    public T022accionistaPK getT022accionistaPK() {
        return t022accionistaPK;
    }

    public void setT022accionistaPK(T022accionistaPK t022accionistaPK) {
        this.t022accionistaPK = t022accionistaPK;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public Character getIndAporte() {
        return indAporte;
    }

    public void setIndAporte(Character indAporte) {
        this.indAporte = indAporte;
    }

    public BigDecimal getMtoAporte() {
        return mtoAporte;
    }

    public void setMtoAporte(BigDecimal mtoAporte) {
        this.mtoAporte = mtoAporte;
    }

    public String getCodParticipa() {
        return codParticipa;
    }

    public void setCodParticipa(String codParticipa) {
        this.codParticipa = codParticipa;
    }

    public T020tramite getT020tramite() {
        return t020tramite;
    }

    public void setT020tramite(T020tramite t020tramite) {
        this.t020tramite = t020tramite;
    }

    public T026perjur getT026perjur() {
        return t026perjur;
    }

    public void setT026perjur(T026perjur t026perjur) {
        this.t026perjur = t026perjur;
    }

    public List<T023aportebien> getT023aportebienList() {
        return t023aportebienList;
    }

    public void setT023aportebienList(List<T023aportebien> t023aportebienList) {
        this.t023aportebienList = t023aportebienList;
    }

    public T025pernat getT025pernat() {
        return t025pernat;
    }

    public void setT025pernat(T025pernat t025pernat) {
        this.t025pernat = t025pernat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t022accionistaPK != null ? t022accionistaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T022accionista)) {
            return false;
        }
        T022accionista other = (T022accionista) object;
        if ((this.t022accionistaPK == null && other.t022accionistaPK != null) || (this.t022accionistaPK != null && !this.t022accionistaPK.equals(other.t022accionistaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T022accionista[t022accionistaPK=" + t022accionistaPK + "]";
    }

}
