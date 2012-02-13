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

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t020tramite")
public class T020tramite implements Serializable {
    private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private Integer numTramite;
    
	@Basic(optional = false)
    @Column(name = "ANN_TRAMITE")
    private short annTramite;
    
	@Column(name = "COD_TIPSOC")
    private String codTipsoc;
    @Column(name = "COD_ZONREG")
    private String codZonreg;
    @Column(name = "COD_OFICREG")
    private String codOficreg;
    @Column(name = "COD_PRESENTA")
    private String codPresenta;
    @Column(name = "CLV_KARDEX")
    private String clvKardex;
    @Column(name = "IND_LIBROSOC")
    private Integer indLibrosoc;
    @Column(name = "IND_LIBROCON")
    private Integer indLibrocon;
    @Column(name = "NUM_CUO")
    private String numCuo;
    @Column(name = "IND_CUO")
    private Integer indCuo;
    @Column(name = "FEC_CUO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCuo;
    @Column(name = "COD_TDOCSOL")
    private String codTdocsol;
    @Column(name = "NUM_DOCSOL")
    private String numDocsol;
    @Column(name = "NUM_TITULO")
    private String numTitulo;
    @Basic(optional = false)
    @Column(name = "NOM_RAZSOC")
    private String nomRazsoc;
    @Column(name = "NOM_DENABREV")
    private String nomDenabrev;
    @Column(name = "COD_UBIGEO")
    private String codUbigeo;
    @Column(name = "IND_APORTE")
    private Integer indAporte;
    @Column(name = "MTO_APORTE")
    private BigDecimal mtoAporte;
    @Column(name = "MTO_VALORACCION")
    private BigDecimal mtoValoraccion;
    @Column(name = "MTO_ACCIONPART")
    private BigDecimal mtoAccionpart;
    @Column(name = "IND_CANCECAPI")
    private Integer indCancecapi;
    @Column(name = "NUM_PORCENCANC")
    private Integer numPorcencanc;
    @Column(name = "MTO_DEREREGIS")
    private BigDecimal mtoDereregis;
    @Column(name = "IND_FORMAPAGO")
    private Integer indFormapago;
    @Column(name = "IND_PSC")
    private Integer indPsc;
    @Column(name = "IND_ESTADO")
    private Integer indEstado;
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Column(name = "FEC_CERRADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCerrado;
    @Column(name = "FEC_FIRMADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFirmado;
    @Column(name = "IND_ELIMINADO")
    private Integer indEliminado;
    @Column(name = "FEC_ELIMINADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminado;
    @Column(name = "IND_ENVIO")
    private Integer indEnvio;
    @Column(name = "FEC_ENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEnvio;
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;
    
    @Transient
    private String objetoSocial;
    @Transient
    private String codDepa;
    
	@JoinColumn(name = "COD_NOTARIA", referencedColumnName = "COD_NOTARIA")
    @ManyToOne(optional = false)
    private T021notaria t021notaria;

    public T020tramite() {
    }

    public T020tramite(Integer numTramite) {
        this.numTramite = numTramite;
    }

    public T020tramite(Integer numTramite, short annTramite, String nomRazsoc) {
        this.numTramite = numTramite;
        this.annTramite = annTramite;
        this.nomRazsoc = nomRazsoc;
    }

    public Integer getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(Integer numTramite) {
        this.numTramite = numTramite;
    }

    public short getAnnTramite() {
        return annTramite;
    }

    public void setAnnTramite(short annTramite) {
        this.annTramite = annTramite;
    }

    public String getCodTipsoc() {
        return codTipsoc;
    }

    public void setCodTipsoc(String codTipsoc) {
        this.codTipsoc = codTipsoc;
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

    public String getCodPresenta() {
        return codPresenta;
    }

    public void setCodPresenta(String codPresenta) {
        this.codPresenta = codPresenta;
    }

    public String getClvKardex() {
        return clvKardex;
    }

    public void setClvKardex(String clvKardex) {
        this.clvKardex = clvKardex;
    }

    public Integer getIndLibrosoc() {
        return indLibrosoc;
    }

    public void setIndLibrosoc(Integer indLibrosoc) {
        this.indLibrosoc = indLibrosoc;
    }

    public Integer getIndLibrocon() {
        return indLibrocon;
    }

    public void setIndLibrocon(Integer indLibrocon) {
        this.indLibrocon = indLibrocon;
    }

    public String getNumCuo() {
        return numCuo;
    }

    public void setNumCuo(String numCuo) {
        this.numCuo = numCuo;
    }

    public Integer getIndCuo() {
        return indCuo;
    }

    public void setIndCuo(Integer indCuo) {
        this.indCuo = indCuo;
    }

    public Date getFecCuo() {
        return fecCuo;
    }

    public void setFecCuo(Date fecCuo) {
        this.fecCuo = fecCuo;
    }

    public String getCodTdocsol() {
        return codTdocsol;
    }

    public void setCodTdocsol(String codTdocsol) {
        this.codTdocsol = codTdocsol;
    }

    public String getNumDocsol() {
        return numDocsol;
    }

    public void setNumDocsol(String numDocsol) {
        this.numDocsol = numDocsol;
    }

    public String getNumTitulo() {
        return numTitulo;
    }

    public void setNumTitulo(String numTitulo) {
        this.numTitulo = numTitulo;
    }

    public String getNomRazsoc() {
        return nomRazsoc;
    }

    public void setNomRazsoc(String nomRazsoc) {
        this.nomRazsoc = nomRazsoc;
    }

    public String getNomDenabrev() {
        return nomDenabrev;
    }

    public void setNomDenabrev(String nomDenabrev) {
        this.nomDenabrev = nomDenabrev;
    }

    public String getCodUbigeo() {
        return codUbigeo;
    }

    public void setCodUbigeo(String codUbigeo) {
        this.codUbigeo = codUbigeo;
    }

    public Integer getIndAporte() {
        return indAporte;
    }

    public void setIndAporte(Integer indAporte) {
        this.indAporte = indAporte;
    }

    public BigDecimal getMtoAporte() {
        return mtoAporte;
    }

    public void setMtoAporte(BigDecimal mtoAporte) {
        this.mtoAporte = mtoAporte;
    }

    public BigDecimal getMtoValoraccion() {
        return mtoValoraccion;
    }

    public void setMtoValoraccion(BigDecimal mtoValoraccion) {
        this.mtoValoraccion = mtoValoraccion;
    }

    public BigDecimal getMtoAccionpart() {
        return mtoAccionpart;
    }

    public void setMtoAccionpart(BigDecimal mtoAccionpart) {
        this.mtoAccionpart = mtoAccionpart;
    }

    public Integer getIndCancecapi() {
        return indCancecapi;
    }

    public void setIndCancecapi(Integer indCancecapi) {
        this.indCancecapi = indCancecapi;
    }

    public Integer getNumPorcencanc() {
        return numPorcencanc;
    }

    public void setNumPorcencanc(Integer numPorcencanc) {
        this.numPorcencanc = numPorcencanc;
    }

    public BigDecimal getMtoDereregis() {
        return mtoDereregis;
    }

    public void setMtoDereregis(BigDecimal mtoDereregis) {
        this.mtoDereregis = mtoDereregis;
    }

    public Integer getIndFormapago() {
        return indFormapago;
    }

    public void setIndFormapago(Integer indFormapago) {
        this.indFormapago = indFormapago;
    }

    public Integer getIndPsc() {
        return indPsc;
    }

    public void setIndPsc(Integer indPsc) {
        this.indPsc = indPsc;
    }

   /**
    * 1 = Bandeja<br>
    * 2 = Incompletos<br>
    * 3 = Pendiente de Firma(Cerrado)<br>
    * 4 = Firmado<br>
    * 5 = Enviado<br>
    *  
    * @return estado
    */
    public Integer getIndEstado() {
        return indEstado;
    }
    
    public String getEstado() {
        switch(indEstado){
        	case 1 : return "En Bandeja";
        	case 2 : return "Incompleto";
        	case 3 : return "Pendiente de Firma";
        	case 4 : return "Firmado";
        	case 5 : return "Enviado";
        	default : return "--";
        }
        
    }
    
    /**
     * 1 = Bandeja<br>
     * 2 = Incompletos<br>
     * 3 = Pendiente de Firma(Cerrado)<br>
     * 4 = Firmado<br>
     * 5 = Enviado<br>
     * 
     * @param indEstado
     */
    public void setIndEstado(Integer indEstado) {
        this.indEstado = indEstado;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public Date getFecCerrado() {
        return fecCerrado;
    }

    public void setFecCerrado(Date fecCerrado) {
        this.fecCerrado = fecCerrado;
    }

    public Date getFecFirmado() {
        return fecFirmado;
    }

    public void setFecFirmado(Date fecFirmado) {
        this.fecFirmado = fecFirmado;
    }

    public Integer getIndEliminado() {
        return indEliminado;
    }

    public void setIndEliminado(Integer indEliminado) {
        this.indEliminado = indEliminado;
    }

    public Date getFecEliminado() {
        return fecEliminado;
    }

    public void setFecEliminado(Date fecEliminado) {
        this.fecEliminado = fecEliminado;
    }

    public Integer getIndEnvio() {
        return indEnvio;
    }

    public void setIndEnvio(Integer indEnvio) {
        this.indEnvio = indEnvio;
    }

    public Date getFecEnvio() {
        return fecEnvio;
    }

    public void setFecEnvio(Date fecEnvio) {
        this.fecEnvio = fecEnvio;
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

   public T021notaria getT021notaria() {
        return t021notaria;
    }

    public void setT021notaria(T021notaria t021notaria) {
        this.t021notaria = t021notaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTramite != null ? numTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T020tramite)) {
            return false;
        }
        T020tramite other = (T020tramite) object;
        if ((this.numTramite == null && other.numTramite != null) || (this.numTramite != null && !this.numTramite.equals(other.numTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T020tramite[numTramite=" + numTramite + "]";
    }

	public String getObjetoSocial() {
		return objetoSocial;
	}

	public void setObjetoSocial(String objetoSocial) {
		this.objetoSocial = objetoSocial;
	}

	public String getCodDepa() {
		if(codUbigeo!=null)
			if(codUbigeo.length()>2)
				return codUbigeo.substring(0,2)+"0000";
		return "";
	}

	public void setCodDepa(String codDepa) {
		this.codDepa = codDepa;
	}
  
    
}
