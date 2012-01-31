package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t026perjur")
public class T026perjur implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERJUR")
    private Integer idPerjur;
    @Column(name = "COD_TIPDOC")
    private String codTipdoc;
    @Column(name = "NUM_DOCUM")
    private String numDocum;
    @Column(name = "NOM_RAZSOC")
    private String nomRazsoc;
    @Column(name = "DIR_PERJUR")
    private String dirPerjur;
    @Column(name = "DES_SIGLAS")
    private String desSiglas;
    @Column(name = "CLV_INSREG")
    private String clvInsreg;
    @Column(name = "COD_ZONREG")
    private String codZonreg;
    @Column(name = "COD_OFICREG")
    private String codOficreg;
    
    @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE")
    @ManyToOne(optional = false)
    private T020tramite t020tramite;
    
    @Transient
    private BigDecimal montoAporte;
    @Transient
    private String indAporte;
    @Transient
    private String codParticipa;
    
    public T026perjur() {
    }

    public T026perjur(Integer idPerjur) {
        this.idPerjur = idPerjur;
    }

    public Integer getIdPerjur() {
        return idPerjur;
    }

    public void setIdPerjur(Integer idPerjur) {
        this.idPerjur = idPerjur;
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

    public String getNomRazsoc() {
        return nomRazsoc;
    }

    public void setNomRazsoc(String nomRazsoc) {
        this.nomRazsoc = nomRazsoc;
    }

    public String getDirPerjur() {
        return dirPerjur;
    }

    public void setDirPerjur(String dirPerjur) {
        this.dirPerjur = dirPerjur;
    }

    public String getDesSiglas() {
        return desSiglas;
    }

    public void setDesSiglas(String desSiglas) {
        this.desSiglas = desSiglas;
    }

    public String getClvInsreg() {
        return clvInsreg;
    }

    public void setClvInsreg(String clvInsreg) {
        this.clvInsreg = clvInsreg;
    }

    public String getCodZonreg() {
        return codZonreg;
    }

    public void setCodZonreg(String codZonreg) {
        this.codZonreg = codZonreg;
    }

    public String getCodOficreg() {
        return codOficreg;
    }

    public void setCodOficreg(String codOficreg) {
        this.codOficreg = codOficreg;
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
        hash += (idPerjur != null ? idPerjur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof T026perjur)) {
            return false;
        }
        T026perjur other = (T026perjur) object;
        if ((this.idPerjur == null && other.idPerjur != null) || (this.idPerjur != null && !this.idPerjur.equals(other.idPerjur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T026perjur[idPerjur=" + idPerjur + "]";
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
    
    
    

}
