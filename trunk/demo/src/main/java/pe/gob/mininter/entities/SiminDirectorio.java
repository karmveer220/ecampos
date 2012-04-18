package pe.gob.mininter.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="SIMIN_DIRECTORIO")
public class SiminDirectorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C_DIR_CODIGO")
	private long cDirCodigo;

	@Column(name="N_DIR_ABREVIATURA")
	private String nDirAbreviatura;

	@Column(name="N_DIR_ANEXO")
	private String ndirAnexo;

	@Column(name="N_DIR_DESCRIPCION")
	private String ndirDescripcion;

	@Column(name="N_DIR_TELEFONO")
	private String ndirTelefono;

	//bi-directional many-to-one association to SiminUnidadorganica
    @ManyToOne
	@JoinColumn(name="C_UNO_CODIGO")
	private SiminUnidadorganica siminUnidadorganica;

    public SiminDirectorio() {
    	
    }

	public long getCDirCodigo() {
		return this.cDirCodigo;
	}

	public void setCDirCodigo(long cDirCodigo) {
		this.cDirCodigo = cDirCodigo;
	}

	public String getNDirAbreviatura() {
		return this.nDirAbreviatura;
	}

	public void setNDirAbreviatura(String nDirAbreviatura) {
		this.nDirAbreviatura = nDirAbreviatura;
	}	

	public SiminUnidadorganica getSiminUnidadorganica() {
		return this.siminUnidadorganica;
	}

	public void setSiminUnidadorganica(SiminUnidadorganica siminUnidadorganica) {
		this.siminUnidadorganica = siminUnidadorganica;
	}

	public String getNdirAnexo() {
		return ndirAnexo;
	}

	public void setNdirAnexo(String ndirAnexo) {
		this.ndirAnexo = ndirAnexo;
	}

	public String getNdirDescripcion() {
		return ndirDescripcion;
	}

	public void setNdirDescripcion(String ndirDescripcion) {
		this.ndirDescripcion = ndirDescripcion;
	}

	public String getNdirTelefono() {
		return ndirTelefono;
	}

	public void setNdirTelefono(String ndirTelefono) {
		this.ndirTelefono = ndirTelefono;
	}
	
	
}