package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SIMIN_FUNCIONES database table.
 * 
 */
@Entity
@Table(name="SIMIN_FUNCIONES")
public class SiminFunciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_FUN_CODIGO")
	private long cFunCodigo;

	@Column(name="F_FUN_ESTADO")
	private String fFunEstado;

	@Column(name="N_FUN_ABREVIATURA")
	private String nFunAbreviatura;

	@Column(name="N_FUN_CONFIANZA")
	private BigDecimal nFunConfianza;

	@Column(name="N_FUN_DESCRIP")
	private String nFunDescrip;

	@Column(name="N_FUN_DESCRIP_F")
	private String nFunDescripF;

    public SiminFunciones() {
    }

	public long getCFunCodigo() {
		return this.cFunCodigo;
	}

	public void setCFunCodigo(long cFunCodigo) {
		this.cFunCodigo = cFunCodigo;
	}

	public String getFFunEstado() {
		return this.fFunEstado;
	}

	public void setFFunEstado(String fFunEstado) {
		this.fFunEstado = fFunEstado;
	}

	public String getNFunAbreviatura() {
		return this.nFunAbreviatura;
	}

	public void setNFunAbreviatura(String nFunAbreviatura) {
		this.nFunAbreviatura = nFunAbreviatura;
	}

	public BigDecimal getNFunConfianza() {
		return this.nFunConfianza;
	}

	public void setNFunConfianza(BigDecimal nFunConfianza) {
		this.nFunConfianza = nFunConfianza;
	}

	public String getNFunDescrip() {
		return this.nFunDescrip;
	}

	public void setNFunDescrip(String nFunDescrip) {
		this.nFunDescrip = nFunDescrip;
	}

	public String getNFunDescripF() {
		return this.nFunDescripF;
	}

	public void setNFunDescripF(String nFunDescripF) {
		this.nFunDescripF = nFunDescripF;
	}

}