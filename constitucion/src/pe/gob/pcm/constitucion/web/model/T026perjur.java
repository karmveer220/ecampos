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
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t026perjur")
public class T026perjur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERJUR")
    private Integer idPerjur;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "COD_TIPDOC")
    private String codTipdoc;
    @Basic(optional = false)
    @Column(name = "NUM_DOCUM")
    private String numDocum;
    @Basic(optional = false)
    @Column(name = "NOM_RAZSOC")
    private String nomRazsoc;
    @Basic(optional = false)
    @Column(name = "DIR_PERJUR")
    private String dirPerjur;
    @Basic(optional = false)
    @Column(name = "DES_SIGLAS")
    private String desSiglas;
    @Basic(optional = false)
    @Column(name = "CLV_INSREG")
    private String clvInsreg;
    @Basic(optional = false)
    @Column(name = "COD_ZONREG")
    private String codZonreg;
    @Basic(optional = false)
    @Column(name = "COD_OFICREG")
    private String codOficreg;

    public T026perjur() {
    }

    public T026perjur(Integer idPerjur) {
        this.idPerjur = idPerjur;
    }

    public T026perjur(Integer idPerjur, int numTramite, String codTipdoc, String numDocum, String nomRazsoc, String dirPerjur, String desSiglas, String clvInsreg, String codZonreg, String codOficreg) {
        this.idPerjur = idPerjur;
        this.numTramite = numTramite;
        this.codTipdoc = codTipdoc;
        this.numDocum = numDocum;
        this.nomRazsoc = nomRazsoc;
        this.dirPerjur = dirPerjur;
        this.desSiglas = desSiglas;
        this.clvInsreg = clvInsreg;
        this.codZonreg = codZonreg;
        this.codOficreg = codOficreg;
    }

    public Integer getIdPerjur() {
        return idPerjur;
    }

    public void setIdPerjur(Integer idPerjur) {
        this.idPerjur = idPerjur;
    }

    public int getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(int numTramite) {
        this.numTramite = numTramite;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerjur != null ? idPerjur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T026perjur)) {
            return false;
        }
        T026perjur other = (T026perjur) object;
        if ((this.idPerjur == null && other.idPerjur != null) || (this.idPerjur != null && !this.idPerjur.equals(other.idPerjur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.model.T026perjur[idPerjur=" + idPerjur + "]";
    }

}
