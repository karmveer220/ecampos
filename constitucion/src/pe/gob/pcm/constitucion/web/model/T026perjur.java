/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t026perjur")
public class T026perjur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T026perjurPK t026perjurPK;
    @Column(name = "NOM_RAZSOC")
    private String nomRazsoc;
    @Column(name = "DIR_PERJUR")
    private String dirPerjur;
    @Column(name = "DES_SIGLAS")
    private String desSiglas;
    @Column(name = "CLV_INSREG")
    private String clvInsreg;
    @Column(name = "COD_ZONREG")
    private String codZonreg;
    @Column(name = "COD_OFICREG")
    private String codOficreg;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPDOC", referencedColumnName = "COD_TIPDOC", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_DOCUM", referencedColumnName = "NUM_DOCUM", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private T022accionista t022accionista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t026perjur")
    private List<T027perjurrep> t027perjurrepList;

    public T026perjur() {
    }

    public T026perjur(T026perjurPK t026perjurPK) {
        this.t026perjurPK = t026perjurPK;
    }

    public T026perjur(short annTramite, int numTramite, String codTipdoc, String numDocum) {
        this.t026perjurPK = new T026perjurPK(annTramite, numTramite, codTipdoc, numDocum);
    }

    public T026perjurPK getT026perjurPK() {
        return t026perjurPK;
    }

    public void setT026perjurPK(T026perjurPK t026perjurPK) {
        this.t026perjurPK = t026perjurPK;
    }

    public String getNomRazsoc() {
        return nomRazsoc;
    }

    public void setNomRazsoc(String nomRazsoc) {
        this.nomRazsoc = nomRazsoc;
    }

    public String getDirPerjur() {
        return dirPerjur;
    }

    public void setDirPerjur(String dirPerjur) {
        this.dirPerjur = dirPerjur;
    }

    public String getDesSiglas() {
        return desSiglas;
    }

    public void setDesSiglas(String desSiglas) {
        this.desSiglas = desSiglas;
    }

    public String getClvInsreg() {
        return clvInsreg;
    }

    public void setClvInsreg(String clvInsreg) {
        this.clvInsreg = clvInsreg;
    }

    public String getCodZonreg() {
        return codZonreg;
    }

    public void setCodZonreg(String codZonreg) {
        this.codZonreg = codZonreg;
    }

    public String getCodOficreg() {
        return codOficreg;
    }

    public void setCodOficreg(String codOficreg) {
        this.codOficreg = codOficreg;
    }

    public T022accionista getT022accionista() {
        return t022accionista;
    }

    public void setT022accionista(T022accionista t022accionista) {
        this.t022accionista = t022accionista;
    }

    public List<T027perjurrep> getT027perjurrepList() {
        return t027perjurrepList;
    }

    public void setT027perjurrepList(List<T027perjurrep> t027perjurrepList) {
        this.t027perjurrepList = t027perjurrepList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t026perjurPK != null ? t026perjurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T026perjur)) {
            return false;
        }
        T026perjur other = (T026perjur) object;
        if ((this.t026perjurPK == null && other.t026perjurPK != null) || (this.t026perjurPK != null && !this.t026perjurPK.equals(other.t026perjurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T026perjur[t026perjurPK=" + t026perjurPK + "]";
    }

}
