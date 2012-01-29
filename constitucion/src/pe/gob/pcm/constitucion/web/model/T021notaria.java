/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @Column(name = "DIR_NOTARIA")
    private String dirNotaria;
    @Column(name = "DES_CORREO")
    private String desCorreo;
    @Column(name = "DES_WEB")
    private String desWeb;
    @Column(name = "NUM_TELEF1")
    private String numTelef1;
    @Column(name = "NUM_TELEF2")
    private String numTelef2;
    @Column(name = "COD_SUNARP")
    private String codSunarp;
    @Column(name = "COD_COLEGIO")
    private String codColegio;
    @Column(name = "COD_UBIGEO")
    private String codUbigeo;
    @Column(name = "NUM_LATITUD")
    private BigDecimal numLatitud;
    @Column(name = "NUM_LONGITUD")
    private BigDecimal numLongitud;
    @Column(name = "OBS_NOTARIA")
    private String obsNotaria;
    @Column(name = "NUM_DNIPRESEN")
    private String numDnipresen;
    @Column(name = "APE_PATPRESEN")
    private String apePatpresen;
    @Column(name = "APE_MATPRESEN")
    private String apeMatpresen;
    @Column(name = "NOM_PRESEN")
    private String nomPresen;
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Column(name = "IND_ELIMINADO")
    private Character indEliminado;
    @Column(name = "FEC_ELIMINADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t021notaria")
    private List<T020tramite> t020tramiteList;

    public T021notaria() {
    }

    public T021notaria(String codNotaria) {
        this.codNotaria = codNotaria;
    }

    public T021notaria(String codNotaria, String numRucnot, String nomRazsoc) {
        this.codNotaria = codNotaria;
        this.numRucnot = numRucnot;
        this.nomRazsoc = nomRazsoc;
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

    public Character getIndEliminado() {
        return indEliminado;
    }

    public void setIndEliminado(Character indEliminado) {
        this.indEliminado = indEliminado;
    }

    public Date getFecEliminado() {
        return fecEliminado;
    }

    public void setFecEliminado(Date fecEliminado) {
        this.fecEliminado = fecEliminado;
    }

    public List<T020tramite> getT020tramiteList() {
        return t020tramiteList;
    }

    public void setT020tramiteList(List<T020tramite> t020tramiteList) {
        this.t020tramiteList = t020tramiteList;
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
        return "pe.gob.pcm.constitucion.web.model.T021notaria[codNotaria=" + codNotaria + "]";
    }

}
