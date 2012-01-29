/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERJURREP")
    private Integer idPerjurrep;
    @Column(name = "COD_TIPDOC")
    private String codTipdoc;
    @Column(name = "NUM_DOCUM")
    private String numDocum;
    @Column(name = "COD_TDOCREP")
    private String codTdocrep;
    @Column(name = "NUM_DOCREP")
    private String numDocrep;
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
    @JoinColumn(name = "ID_PERJUR", referencedColumnName = "ID_PERJUR")
    @ManyToOne(optional = false)
    private T026perjur t026perjur;

    public T027perjurrep() {
    }

    public T027perjurrep(Integer idPerjurrep) {
        this.idPerjurrep = idPerjurrep;
    }

    public Integer getIdPerjurrep() {
        return idPerjurrep;
    }

    public void setIdPerjurrep(Integer idPerjurrep) {
        this.idPerjurrep = idPerjurrep;
    }

    public String getCodTipdoc() {
        return codTipdoc;
    }

    public void setCodTipdoc(String codTipdoc) {
        this.codTipdoc = codTipdoc;
    }

    public String getNumDocum() {
        return numDocum;
    }

    public void setNumDocum(String numDocum) {
        this.numDocum = numDocum;
    }

    public String getCodTdocrep() {
        return codTdocrep;
    }

    public void setCodTdocrep(String codTdocrep) {
        this.codTdocrep = codTdocrep;
    }

    public String getNumDocrep() {
        return numDocrep;
    }

    public void setNumDocrep(String numDocrep) {
        this.numDocrep = numDocrep;
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
        hash += (idPerjurrep != null ? idPerjurrep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T027perjurrep)) {
            return false;
        }
        T027perjurrep other = (T027perjurrep) object;
        if ((this.idPerjurrep == null && other.idPerjurrep != null) || (this.idPerjurrep != null && !this.idPerjurrep.equals(other.idPerjurrep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T027perjurrep[idPerjurrep=" + idPerjurrep + "]";
    }

}
