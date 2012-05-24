package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the SIMIN_TIPO_PUBLICACION database table.
 * 
 */
@Entity
@Table(name="SIMIN_TIPO_PUBLICACION")
public class SiminTipoPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CO_TIP_PUBLICACION")
	private long coTipPublicacion;

	@Column(name="NA_TIP_DESCRIPCION")
	private String naTipDescripcion;

	//bi-directional many-to-one association to SiminImagen
	@OneToMany(mappedBy="siminTipoPublicacion")
	private Set<SiminImagen> siminImagens;

    public SiminTipoPublicacion() {
    }

	public long getCoTipPublicacion() {
		return this.coTipPublicacion;
	}

	public void setCoTipPublicacion(long coTipPublicacion) {
		this.coTipPublicacion = coTipPublicacion;
	}

	public String getNaTipDescripcion() {
		return this.naTipDescripcion;
	}

	public void setNaTipDescripcion(String naTipDescripcion) {
		this.naTipDescripcion = naTipDescripcion;
	}

	public Set<SiminImagen> getSiminImagens() {
		return this.siminImagens;
	}

	public void setSiminImagens(Set<SiminImagen> siminImagens) {
		this.siminImagens = siminImagens;
	}
	
}