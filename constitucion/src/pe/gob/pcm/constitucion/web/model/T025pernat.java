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
@Table(name = "t025pernat")
public class T025pernat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERNAT")
    private Integer idPernat;
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
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Basic(optional = false)
    @Column(name = "APE_MATERNO")
    private String apeMaterno;
    @Basic(optional = false)
    @Column(name = "NOM_PERNAT")
    private String nomPernat;
    @Basic(optional = false)
    @Column(name = "FEC_NACIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacim;
    @Basic(optional = false)
    @Column(name = "DES_PROFESION")
    private String desProfesion;
    @Basic(optional = false)
    @Column(name = "COD_PAIS")
    private String codPais;
    @Basic(optional = false)
    @Column(name = "DIR_PERNAT")
    private String dirPernat;
    @Basic(optional = false)
    @Column(name = "COD_UBIGEO")
    private String codUbigeo;
    @Basic(optional = false)
    @Column(name = "COD_ESTCIVIL")
    private String codEstcivil;
    @Basic(optional = false)
    @Column(name = "COD_TDCON")
    private String codTdcon;
    @Basic(optional = false)
    @Column(name = "NUM_DOCCON")
    private String numDoccon;
    @Basic(optional = false)
    @Column(name = "APE_PATCON")
    private String apePatcon;
    @Basic(optional = false)
    @Column(name = "APE_MATCON")
    private String apeMatcon;
    @Basic(optional = false)
    @Column(name = "NOM_CONYUGE")
    private String nomConyuge;
    @Basic(optional = false)
    @Column(name = "DES_PROFCON")
    private String desProfcon;

    public T025pernat() {
    }

    public T025pernat(Integer idPernat) {
        this.idPernat = idPernat;
    }

    public T025pernat(Integer idPernat, int numTramite, String codTipdoc, String numDocum, String apePaterno, String apeMaterno, String nomPernat, Date fecNacim, String desProfesion, String codPais, String dirPernat, String codUbigeo, String codEstcivil, String codTdcon, String numDoccon, String apePatcon, String apeMatcon, String nomConyuge, String desProfcon) {
        this.idPernat = idPernat;
        this.numTramite = numTramite;
        this.codTipdoc = codTipdoc;
        this.numDocum = numDocum;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nomPernat = nomPernat;
        this.fecNacim = fecNacim;
        this.desProfesion = desProfesion;
        this.codPais = codPais;
        this.dirPernat = dirPernat;
        this.codUbigeo = codUbigeo;
        this.codEstcivil = codEstcivil;
        this.codTdcon = codTdcon;
        this.numDoccon = numDoccon;
        this.apePatcon = apePatcon;
        this.apeMatcon = apeMatcon;
        this.nomConyuge = nomConyuge;
        this.desProfcon = desProfcon;
    }

    public Integer getIdPernat() {
        return idPernat;
    }

    public void setIdPernat(Integer idPernat) {
        this.idPernat = idPernat;
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

    public String getNomPernat() {
        return nomPernat;
    }

    public void setNomPernat(String nomPernat) {
        this.nomPernat = nomPernat;
    }

    public Date getFecNacim() {
        return fecNacim;
    }

    public void setFecNacim(Date fecNacim) {
        this.fecNacim = fecNacim;
    }

    public String getDesProfesion() {
        return desProfesion;
    }

    public void setDesProfesion(String desProfesion) {
        this.desProfesion = desProfesion;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getDirPernat() {
        return dirPernat;
    }

    public void setDirPernat(String dirPernat) {
        this.dirPernat = dirPernat;
    }

    public String getCodUbigeo() {
        return codUbigeo;
    }

    public void setCodUbigeo(String codUbigeo) {
        this.codUbigeo = codUbigeo;
    }

    public String getCodEstcivil() {
        return codEstcivil;
    }

    public void setCodEstcivil(String codEstcivil) {
        this.codEstcivil = codEstcivil;
    }

    public String getCodTdcon() {
        return codTdcon;
    }

    public void setCodTdcon(String codTdcon) {
        this.codTdcon = codTdcon;
    }

    public String getNumDoccon() {
        return numDoccon;
    }

    public void setNumDoccon(String numDoccon) {
        this.numDoccon = numDoccon;
    }

    public String getApePatcon() {
        return apePatcon;
    }

    public void setApePatcon(String apePatcon) {
        this.apePatcon = apePatcon;
    }

    public String getApeMatcon() {
        return apeMatcon;
    }

    public void setApeMatcon(String apeMatcon) {
        this.apeMatcon = apeMatcon;
    }

    public String getNomConyuge() {
        return nomConyuge;
    }

    public void setNomConyuge(String nomConyuge) {
        this.nomConyuge = nomConyuge;
    }

    public String getDesProfcon() {
        return desProfcon;
    }

    public void setDesProfcon(String desProfcon) {
        this.desProfcon = desProfcon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPernat != null ? idPernat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T025pernat)) {
            return false;
        }
        T025pernat other = (T025pernat) object;
        if ((this.idPernat == null && other.idPernat != null) || (this.idPernat != null && !this.idPernat.equals(other.idPernat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.model.T025pernat[idPernat=" + idPernat + "]";
    }

}
