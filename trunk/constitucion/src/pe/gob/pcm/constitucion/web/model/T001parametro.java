/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t001parametro")
public class T001parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T001parametroPK t001parametroPK;
    
    @Column(name = "DES_PARAM")
    private String desParam;
    @Column(name = "DES_CORTA")
    private String desCorta;
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;

    public T001parametro() {
    }

    public T001parametro(T001parametroPK t001parametroPK) {
        this.t001parametroPK = t001parametroPK;
    }

    public T001parametro(String codGrupo, String codParam) {
        this.t001parametroPK = new T001parametroPK(codGrupo, codParam);
    }

    public T001parametroPK getT001parametroPK() {
        return t001parametroPK;
    }

    public void setT001parametroPK(T001parametroPK t001parametroPK) {
        this.t001parametroPK = t001parametroPK;
    }

    public String getDesParam() {
        return desParam;
    }

    public void setDesParam(String desParam) {
        this.desParam = desParam;
    }

    public String getDesCorta() {
        return desCorta;
    }

    public void setDesCorta(String desCorta) {
        this.desCorta = desCorta;
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
        hash += (t001parametroPK != null ? t001parametroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T001parametro)) {
            return false;
        }
        T001parametro other = (T001parametro) object;
        if ((this.t001parametroPK == null && other.t001parametroPK != null) || (this.t001parametroPK != null && !this.t001parametroPK.equals(other.t001parametroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T001parametro[t001parametroPK=" + t001parametroPK + "]";
    }

}
