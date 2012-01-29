/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Basic(optional = false)
    @Column(name = "COD_GRUPO")
    private String codGrupo;
    @Basic(optional = false)
    @Column(name = "COD_PARAM")
    private String codParam;
    @Basic(optional = false)
    @Column(name = "DES_PARAM")
    private String desParam;
    @Column(name = "DES_CORTA")
    private String desCorta;
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PARAMETRO")
    private Integer idParametro;

    public T001parametro() {
    }

    public T001parametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public T001parametro(Integer idParametro, String codGrupo, String codParam, String desParam) {
        this.idParametro = idParametro;
        this.codGrupo = codGrupo;
        this.codParam = codParam;
        this.desParam = desParam;
    }

    public String getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(String codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getCodParam() {
        return codParam;
    }

    public void setCodParam(String codParam) {
        this.codParam = codParam;
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

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T001parametro)) {
            return false;
        }
        T001parametro other = (T001parametro) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T001parametro[idParametro=" + idParametro + "]";
    }

}
