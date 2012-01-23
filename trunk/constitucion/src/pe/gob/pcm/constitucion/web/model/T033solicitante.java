/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t033solicitante")
public class T033solicitante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T033solicitantePK t033solicitantePK;
    @Basic(optional = false)
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Basic(optional = false)
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

    public T033solicitante() {
    }

    public T033solicitante(T033solicitantePK t033solicitantePK) {
        this.t033solicitantePK = t033solicitantePK;
    }

    public T033solicitante(T033solicitantePK t033solicitantePK, String apePaterno, String apeMaterno) {
        this.t033solicitantePK = t033solicitantePK;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
    }

    public T033solicitante(short annTramite, int numTramite, String codTdocsol, String numDocsol) {
        this.t033solicitantePK = new T033solicitantePK(annTramite, numTramite, codTdocsol, numDocsol);
    }

    public T033solicitantePK getT033solicitantePK() {
        return t033solicitantePK;
    }

    public void setT033solicitantePK(T033solicitantePK t033solicitantePK) {
        this.t033solicitantePK = t033solicitantePK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t033solicitantePK != null ? t033solicitantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T033solicitante)) {
            return false;
        }
        T033solicitante other = (T033solicitante) object;
        if ((this.t033solicitantePK == null && other.t033solicitantePK != null) || (this.t033solicitantePK != null && !this.t033solicitantePK.equals(other.t033solicitantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T033solicitante[t033solicitantePK=" + t033solicitantePK + "]";
    }

}
