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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t027perjurrep")
public class T027perjurrep implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T027perjurrepPK t027perjurrepPK;
    @Column(name = "NOM_REPRE")
    private String nomRepre;
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Column(name = "APE_MATERNO")
    private String apeMaterno;
    @Column(name = "DIR_PERJUR")
    private String dirPerjur;
    @Column(name = "DES_PROFESION")
    private String desProfesion;
    @Column(name = "CLV_INSREG")
    private String clvInsreg;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPDOC", referencedColumnName = "COD_TIPDOC", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_DOCUM", referencedColumnName = "NUM_DOCUM", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private T026perjur t026perjur;

    public T027perjurrep() {
    }

    public T027perjurrep(T027perjurrepPK t027perjurrepPK) {
        this.t027perjurrepPK = t027perjurrepPK;
    }

    public T027perjurrep(short annTramite, int numTramite, String codTipdoc, String numDocum, String codTdocrep, String numDocrep) {
        this.t027perjurrepPK = new T027perjurrepPK(annTramite, numTramite, codTipdoc, numDocum, codTdocrep, numDocrep);
    }

    public T027perjurrepPK getT027perjurrepPK() {
        return t027perjurrepPK;
    }

    public void setT027perjurrepPK(T027perjurrepPK t027perjurrepPK) {
        this.t027perjurrepPK = t027perjurrepPK;
    }

    public String getNomRepre() {
        return nomRepre;
    }

    public void setNomRepre(String nomRepre) {
        this.nomRepre = nomRepre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getDirPerjur() {
        return dirPerjur;
    }

    public void setDirPerjur(String dirPerjur) {
        this.dirPerjur = dirPerjur;
    }

    public String getDesProfesion() {
        return desProfesion;
    }

    public void setDesProfesion(String desProfesion) {
        this.desProfesion = desProfesion;
    }

    public String getClvInsreg() {
        return clvInsreg;
    }

    public void setClvInsreg(String clvInsreg) {
        this.clvInsreg = clvInsreg;
    }

    public T026perjur getT026perjur() {
        return t026perjur;
    }

    public void setT026perjur(T026perjur t026perjur) {
        this.t026perjur = t026perjur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t027perjurrepPK != null ? t027perjurrepPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T027perjurrep)) {
            return false;
        }
        T027perjurrep other = (T027perjurrep) object;
        if ((this.t027perjurrepPK == null && other.t027perjurrepPK != null) || (this.t027perjurrepPK != null && !this.t027perjurrepPK.equals(other.t027perjurrepPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T027perjurrep[t027perjurrepPK=" + t027perjurrepPK + "]";
    }

}
