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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
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
    @EmbeddedId
    protected T025pernatPK t025pernatPK;
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Column(name = "APE_MATERNO")
    private String apeMaterno;
    @Column(name = "NOM_PERNAT")
    private String nomPernat;
    @Column(name = "FEC_NACIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacim;
    @Column(name = "DES_PROFESION")
    private String desProfesion;
    @Column(name = "COD_PAIS")
    private String codPais;
    @Column(name = "DIR_PERNAT")
    private String dirPernat;
    @Column(name = "COD_UBIGEO")
    private String codUbigeo;
    @Column(name = "COD_ESTCIVIL")
    private String codEstcivil;
    @Column(name = "COD_TDCON")
    private String codTdcon;
    @Column(name = "NUM_DOCCON")
    private String numDoccon;
    @Column(name = "APE_PATCON")
    private String apePatcon;
    @Column(name = "APE_MATCON")
    private String apeMatcon;
    @Column(name = "NOM_CONYUGE")
    private String nomConyuge;
    @Column(name = "DES_PROFCON")
    private String desProfcon;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPDOC", referencedColumnName = "COD_TIPDOC", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_DOCUM", referencedColumnName = "NUM_DOCUM", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private T022accionista t022accionista;

    public T025pernat() {
    }

    public T025pernat(T025pernatPK t025pernatPK) {
        this.t025pernatPK = t025pernatPK;
    }

    public T025pernat(short annTramite, int numTramite, String codTipdoc, String numDocum) {
        this.t025pernatPK = new T025pernatPK(annTramite, numTramite, codTipdoc, numDocum);
    }

    public T025pernatPK getT025pernatPK() {
        return t025pernatPK;
    }

    public void setT025pernatPK(T025pernatPK t025pernatPK) {
        this.t025pernatPK = t025pernatPK;
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

    public T022accionista getT022accionista() {
        return t022accionista;
    }

    public void setT022accionista(T022accionista t022accionista) {
        this.t022accionista = t022accionista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t025pernatPK != null ? t025pernatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T025pernat)) {
            return false;
        }
        T025pernat other = (T025pernat) object;
        if ((this.t025pernatPK == null && other.t025pernatPK != null) || (this.t025pernatPK != null && !this.t025pernatPK.equals(other.t025pernatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T025pernat[t025pernatPK=" + t025pernatPK + "]";
    }

}
