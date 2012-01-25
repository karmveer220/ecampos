/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t021notaria")
public class T021notaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_NOTARIA")
    private String codNotaria;
    @Basic(optional = false)
    @Column(name = "NUM_RUCNOT")
    private String numRucnot;
    @Basic(optional = false)
    @Column(name = "NOM_RAZSOC")
    private String nomRazsoc;
    @Basic(optional = false)
    @Column(name = "DIR_NOTARIA")
    private String dirNotaria;
    @Basic(optional = false)
    @Column(name = "DES_CORREO")
    private String desCorreo;
    @Basic(optional = false)
    @Column(name = "DES_WEB")
    private String desWeb;
    @Basic(optional = false)
    @Column(name = "NUM_TELEF1")
    private String numTelef1;
    @Basic(optional = false)
    @Column(name = "NUM_TELEF2")
    private String numTelef2;
    @Basic(optional = false)
    @Column(name = "COD_SUNARP")
    private String codSunarp;
    @Basic(optional = false)
    @Column(name = "COD_COLEGIO")
    private String codColegio;
    @Basic(optional = false)
    @Column(name = "COD_UBIGEO")
    private String codUbigeo;
    @Basic(optional = false)
    @Column(name = "NUM_LATITUD")
    private BigDecimal numLatitud;
    @Basic(optional = false)
    @Column(name = "NUM_LONGITUD")
    private BigDecimal numLongitud;
    @Basic(optional = false)
    @Column(name = "OBS_NOTARIA")
    private String obsNotaria;
    @Basic(optional = false)
    @Column(name = "NUM_DNIPRESEN")
    private String numDnipresen;
    @Basic(optional = false)
    @Column(name = "APE_PATPRESEN")
    private String apePatpresen;
    @Basic(optional = false)
    @Column(name = "APE_MATPRESEN")
    private String apeMatpresen;
    @Basic(optional = false)
    @Column(name = "NOM_PRESEN")
    private String nomPresen;
    @Basic(optional = false)
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Basic(optional = false)
    @Column(name = "IND_ELIMINADO")
    private char indEliminado;
    @Basic(optional = false)
    @Column(name = "FEC_ELIMINADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminado;

    public T021notaria() {
    }

    public T021notaria(String codNotaria) {
        this.codNotaria = codNotaria;
    }

    public T021notaria(String codNotaria, String numRucnot, String nomRazsoc, String dirNotaria, String desCorreo, String desWeb, String numTelef1, String numTelef2, String codSunarp, String codColegio, String codUbigeo, BigDecimal numLatitud, BigDecimal numLongitud, String obsNotaria, String numDnipresen, String apePatpresen, String apeMatpresen, String nomPresen, Date fecRegistro, char indEliminado, Date fecEliminado) {
        this.codNotaria = codNotaria;
        this.numRucnot = numRucnot;
        this.nomRazsoc = nomRazsoc;
        this.dirNotaria = dirNotaria;
        this.desCorreo = desCorreo;
        this.desWeb = desWeb;
        this.numTelef1 = numTelef1;
        this.numTelef2 = numTelef2;
        this.codSunarp = codSunarp;
        this.codColegio = codColegio;
        this.codUbigeo = codUbigeo;
        this.numLatitud = numLatitud;
        this.numLongitud = numLongitud;
        this.obsNotaria = obsNotaria;
        this.numDnipresen = numDnipresen;
        this.apePatpresen = apePatpresen;
        this.apeMatpresen = apeMatpresen;
        this.nomPresen = nomPresen;
        this.fecRegistro = fecRegistro;
        this.indEliminado = indEliminado;
        this.fecEliminado = fecEliminado;
    }

    public String getCodNotaria() {
        return codNotaria;
    }

    public void setCodNotaria(String codNotaria) {
        this.codNotaria = codNotaria;
    }

    public String getNumRucnot() {
        return numRucnot;
    }

    public void setNumRucnot(String numRucnot) {
        this.numRucnot = numRucnot;
    }

    public String getNomRazsoc() {
        return nomRazsoc;
    }

    public void setNomRazsoc(String nomRazsoc) {
        this.nomRazsoc = nomRazsoc;
    }

    public String getDirNotaria() {
        return dirNotaria;
    }

    public void setDirNotaria(String dirNotaria) {
        this.dirNotaria = dirNotaria;
    }

    public String getDesCorreo() {
        return desCorreo;
    }

    public void setDesCorreo(String desCorreo) {
        this.desCorreo = desCorreo;
    }

    public String getDesWeb() {
        return desWeb;
    }

    public void setDesWeb(String desWeb) {
        this.desWeb = desWeb;
    }

    public String getNumTelef1() {
        return numTelef1;
    }

    public void setNumTelef1(String numTelef1) {
        this.numTelef1 = numTelef1;
    }

    public String getNumTelef2() {
        return numTelef2;
    }

    public void setNumTelef2(String numTelef2) {
        this.numTelef2 = numTelef2;
    }

    public String getCodSunarp() {
        return codSunarp;
    }

    public void setCodSunarp(String codSunarp) {
        this.codSunarp = codSunarp;
    }

    public String getCodColegio() {
        return codColegio;
    }

    public void setCodColegio(String codColegio) {
        this.codColegio = codColegio;
    }

    public String getCodUbigeo() {
        return codUbigeo;
    }

    public void setCodUbigeo(String codUbigeo) {
        this.codUbigeo = codUbigeo;
    }

    public BigDecimal getNumLatitud() {
        return numLatitud;
    }

    public void setNumLatitud(BigDecimal numLatitud) {
        this.numLatitud = numLatitud;
    }

    public BigDecimal getNumLongitud() {
        return numLongitud;
    }

    public void setNumLongitud(BigDecimal numLongitud) {
        this.numLongitud = numLongitud;
    }

    public String getObsNotaria() {
        return obsNotaria;
    }

    public void setObsNotaria(String obsNotaria) {
        this.obsNotaria = obsNotaria;
    }

    public String getNumDnipresen() {
        return numDnipresen;
    }

    public void setNumDnipresen(String numDnipresen) {
        this.numDnipresen = numDnipresen;
    }

    public String getApePatpresen() {
        return apePatpresen;
    }

    public void setApePatpresen(String apePatpresen) {
        this.apePatpresen = apePatpresen;
    }

    public String getApeMatpresen() {
        return apeMatpresen;
    }

    public void setApeMatpresen(String apeMatpresen) {
        this.apeMatpresen = apeMatpresen;
    }

    public String getNomPresen() {
        return nomPresen;
    }

    public void setNomPresen(String nomPresen) {
        this.nomPresen = nomPresen;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public char getIndEliminado() {
        return indEliminado;
    }

    public void setIndEliminado(char indEliminado) {
        this.indEliminado = indEliminado;
    }

    public Date getFecEliminado() {
        return fecEliminado;
    }

    public void setFecEliminado(Date fecEliminado) {
        this.fecEliminado = fecEliminado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNotaria != null ? codNotaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T021notaria)) {
            return false;
        }
        T021notaria other = (T021notaria) object;
        if ((this.codNotaria == null && other.codNotaria != null) || (this.codNotaria != null && !this.codNotaria.equals(other.codNotaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.model.T021notaria[codNotaria=" + codNotaria + "]";
    }

}
