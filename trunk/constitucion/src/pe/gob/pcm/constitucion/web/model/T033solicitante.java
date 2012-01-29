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
@Table(name = "t033solicitante")
public class T033solicitante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOLICITANTE")
    private Integer idSolicitante;
    @Column(name = "COD_TDOCSOL")
    private String codTdocsol;
    @Column(name = "NUM_DOCSOL")
    private String numDocsol;
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Column(name = "APE_MATERNO")
    private String apeMaterno;
    @Column(name = "NOM_SOLICITANTE")
    private String nomSolicitante;
    @Column(name = "DES_CORREO")
    private String desCorreo;
    @Column(name = "NUM_TELEF")
    private String numTelef;
    @Column(name = "NUM_CELULAR")
    private String numCelular;
    @Column(name = "DIR_SOLICITANTE")
    private String dirSolicitante;
    
    @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE")
    @ManyToOne(optional = false)
    private T020tramite t020tramite;

    public T033solicitante() {
    }

    public T033solicitante(Integer idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public Integer getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Integer idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getCodTdocsol() {
        return codTdocsol;
    }

    public void setCodTdocsol(String codTdocsol) {
        this.codTdocsol = codTdocsol;
    }

    public String getNumDocsol() {
        return numDocsol;
    }

    public void setNumDocsol(String numDocsol) {
        this.numDocsol = numDocsol;
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

    public String getNomSolicitante() {
        return nomSolicitante;
    }

    public void setNomSolicitante(String nomSolicitante) {
        this.nomSolicitante = nomSolicitante;
    }

    public String getDesCorreo() {
        return desCorreo;
    }

    public void setDesCorreo(String desCorreo) {
        this.desCorreo = desCorreo;
    }

    public String getNumTelef() {
        return numTelef;
    }

    public void setNumTelef(String numTelef) {
        this.numTelef = numTelef;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getDirSolicitante() {
        return dirSolicitante;
    }

    public void setDirSolicitante(String dirSolicitante) {
        this.dirSolicitante = dirSolicitante;
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
        hash += (idSolicitante != null ? idSolicitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T033solicitante)) {
            return false;
        }
        T033solicitante other = (T033solicitante) object;
        if ((this.idSolicitante == null && other.idSolicitante != null) || (this.idSolicitante != null && !this.idSolicitante.equals(other.idSolicitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T033solicitante[idSolicitante=" + idSolicitante + "]";
    }

}
