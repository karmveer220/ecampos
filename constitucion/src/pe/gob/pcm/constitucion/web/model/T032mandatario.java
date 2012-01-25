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
@Table(name = "t032mandatario")
public class T032mandatario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MANDATARIO")
    private Integer idMandatario;
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "COD_TDOCMAN")
    private String codTdocman;
    @Basic(optional = false)
    @Column(name = "NUM_DOCMAN")
    private String numDocman;
    @Basic(optional = false)
    @Column(name = "IND_ACCSOC")
    private char indAccsoc;
    @Basic(optional = false)
    @Column(name = "NOM_MANDAT")
    private String nomMandat;
    @Basic(optional = false)
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Basic(optional = false)
    @Column(name = "APE_MATERNO")
    private String apeMaterno;
    @Basic(optional = false)
    @Column(name = "FEC_NACIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacim;
    @Basic(optional = false)
    @Column(name = "COD_ESTCIVIL")
    private String codEstcivil;
    @Basic(optional = false)
    @Column(name = "COD_PAIS")
    private String codPais;
    @Basic(optional = false)
    @Column(name = "DIR_MANDAT")
    private String dirMandat;
    @Basic(optional = false)
    @Column(name = "DES_PROFESION")
    private String desProfesion;
    @Basic(optional = false)
    @Column(name = "CLV_INSREG")
    private String clvInsreg;
    @Column(name = "COD_CARGO")
    private String codCargo;

    public T032mandatario() {
    }

    public T032mandatario(Integer idMandatario) {
        this.idMandatario = idMandatario;
    }

    public T032mandatario(Integer idMandatario, int numTramite, String codTdocman, String numDocman, char indAccsoc, String nomMandat, String apePaterno, String apeMaterno, Date fecNacim, String codEstcivil, String codPais, String dirMandat, String desProfesion, String clvInsreg) {
        this.idMandatario = idMandatario;
        this.numTramite = numTramite;
        this.codTdocman = codTdocman;
        this.numDocman = numDocman;
        this.indAccsoc = indAccsoc;
        this.nomMandat = nomMandat;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fecNacim = fecNacim;
        this.codEstcivil = codEstcivil;
        this.codPais = codPais;
        this.dirMandat = dirMandat;
        this.desProfesion = desProfesion;
        this.clvInsreg = clvInsreg;
    }

    public Integer getIdMandatario() {
        return idMandatario;
    }

    public void setIdMandatario(Integer idMandatario) {
        this.idMandatario = idMandatario;
    }

    public int getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(int numTramite) {
        this.numTramite = numTramite;
    }

    public String getCodTdocman() {
        return codTdocman;
    }

    public void setCodTdocman(String codTdocman) {
        this.codTdocman = codTdocman;
    }

    public String getNumDocman() {
        return numDocman;
    }

    public void setNumDocman(String numDocman) {
        this.numDocman = numDocman;
    }

    public char getIndAccsoc() {
        return indAccsoc;
    }

    public void setIndAccsoc(char indAccsoc) {
        this.indAccsoc = indAccsoc;
    }

    public String getNomMandat() {
        return nomMandat;
    }

    public void setNomMandat(String nomMandat) {
        this.nomMandat = nomMandat;
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

    public Date getFecNacim() {
        return fecNacim;
    }

    public void setFecNacim(Date fecNacim) {
        this.fecNacim = fecNacim;
    }

    public String getCodEstcivil() {
        return codEstcivil;
    }

    public void setCodEstcivil(String codEstcivil) {
        this.codEstcivil = codEstcivil;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getDirMandat() {
        return dirMandat;
    }

    public void setDirMandat(String dirMandat) {
        this.dirMandat = dirMandat;
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

    public String getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(String codCargo) {
        this.codCargo = codCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMandatario != null ? idMandatario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T032mandatario)) {
            return false;
        }
        T032mandatario other = (T032mandatario) object;
        if ((this.idMandatario == null && other.idMandatario != null) || (this.idMandatario != null && !this.idMandatario.equals(other.idMandatario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.model.T032mandatario[idMandatario=" + idMandatario + "]";
    }

}
