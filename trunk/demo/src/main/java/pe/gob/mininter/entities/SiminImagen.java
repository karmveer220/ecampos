package pe.gob.mininter.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the SIMIN_IMAGEN database table.
 * 
 */
@Entity
@Table(name="SIMIN_IMAGEN")
public class SiminImagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence") 
    @SequenceGenerator(name="sequence", sequenceName="SEQ_CO_IMG_CODIGO", allocationSize=1) 
	@Column(name="CO_IMG_CODIGO")
	private Integer coImgCodigo;

    @Lob()
	@Column(name="NA_IMG_IMAGEN")
	private byte[] naImgImagen;

	@Column(name="NA_IMG_NOMBRE")
	private String naImgNombre;

	@Column(name="NA_IMG_OBSERVACIONES")
	private String naImgObservaciones;

	@Column(name="NA_IMG_SIZE")
	private BigInteger naImgSize;
	
	//bi-directional many-to-one association to SiminTipoPublicacion
    @ManyToOne
	@JoinColumn(name="CO_TIP_PUBLICACION")
	private SiminTipoPublicacion siminTipoPublicacion;
	
	@Column(name="FA_IMG_ESTADO")
	private BigInteger faImgEstado;


    public SiminImagen() {
    }

	public Integer getCoImgCodigo() {
		return this.coImgCodigo;
	}

	public void setCoImgCodigo(Integer coImgCodigo) {
		this.coImgCodigo = coImgCodigo;
	}

	public byte[] getNaImgImagen() {
		return this.naImgImagen;
	}

	public void setNaImgImagen(byte[] naImgImagen) {
		this.naImgImagen = naImgImagen;
	}

	public String getNaImgNombre() {
		return this.naImgNombre;
	}

	public void setNaImgNombre(String naImgNombre) {
		this.naImgNombre = naImgNombre;
	}

	public String getNaImgObservaciones() {
		return this.naImgObservaciones;
	}

	public void setNaImgObservaciones(String naImgObservaciones) {
		this.naImgObservaciones = naImgObservaciones;
	}

	public BigInteger getNaImgSize() {
		return this.naImgSize;
	}

	public void setNaImgSize(BigInteger naImgSize) {
		this.naImgSize = naImgSize;
	}
	
	public BigInteger getFaImgEstado() {
		return this.faImgEstado;
	}

	public void setFaImgEstado(BigInteger faImgEstado) {
		this.faImgEstado = faImgEstado;
	}
	
	public SiminTipoPublicacion getSiminTipoPublicacion() {
		return this.siminTipoPublicacion;
	}

	public void setSiminTipoPublicacion(SiminTipoPublicacion siminTipoPublicacion) {
		this.siminTipoPublicacion = siminTipoPublicacion;
	}

}