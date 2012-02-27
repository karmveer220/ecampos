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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
    
    @Column(name = "COD_TIPDOC")
    private String codTipdoc;
    
    @Column(name = "NUM_DOCUM")
    private String numDocum;
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
    
    @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE")
    @ManyToOne(optional = false)
    private T020tramite t020tramite;

    @Transient
    private BigDecimal montoAporte;
    @Transient
    private String indAporte;
    @Transient
    private String codParticipa;
    @Transient
    private String codDepa;
    @Transient
    private String codProv;
    @Transient
    private String nombreCompleto;
    
    public T025pernat() {
    }

    public T025pernat(Integer idPernat) {
        this.idPernat = idPernat;
    }

    public Integer getIdPernat() {
        return idPernat;
    }

    public void setIdPernat(Integer idPernat) {
        this.idPernat = idPernat;
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

    public T020tramite getT020tramite() {
        return t020tramite;
    }

    public void setT020tramite(T020tramite t020tramite) {
        this.t020tramite = t020tramite;
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
    	return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
    }

	public BigDecimal getMontoAporte() {
		return montoAporte;
	}

	public void setMontoAporte(BigDecimal montoAporte) {
		this.montoAporte = montoAporte;
	}

	public String getIndAporte() {
		return indAporte;
	}

	public void setIndAporte(String indAporte) {
		this.indAporte = indAporte;
	}

	public String getCodParticipa() {
		return codParticipa;
	}

	public void setCodParticipa(String codParticipa) {
		this.codParticipa = codParticipa;
	}

	public String getNombreCompleto(){
		return this.apePaterno + " "  + this.apeMaterno + " " + this.nomPernat;
	}

	public String getCodDepa() {
		return codDepa;
	}

	public void setCodDepa(String codDepa) {
		this.codDepa = codDepa;
	}

	public String getCodProv() {
		return codProv;
	}

	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}
    
}
