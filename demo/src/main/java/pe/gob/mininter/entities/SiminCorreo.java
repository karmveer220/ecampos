package pe.gob.mininter.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="SIMIN_CORREOS")
public class SiminCorreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence") 
    //@SequenceGenerator(name="sequence", sequenceName="SEQ_CO_MAIL_CODIGO", allocationSize=1) 
	@Column(name="CO_MAIL_CODIGO")
	private long coMailCodigo;

	@Column(name="CO_MAIL_GENERADO")
	private String coMailGenerado;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="DA_MAIL_FECHA", columnDefinition="Date default SYSDATE")
	private Date daMailFecha;

	@Column(name="FA_MAIL_ESTADO")
	private String faMailEstado;

	@Column(name="NA_MAIL_CORREO")
	private String naMailCorreo;

	@Column(name="NA_MAIL_PISO")
	private String naMailPiso;

	@NotEmpty(message = "El requerimiento es obligatorio para ser enviado a Soporte Técnico")
	@Size(max = 500)
	@Column(name="NA_MAIL_REQUERIMIENTO")
	private String naMailRequerimiento;
	
	@Column(name="NA_MAIL_CONTACTO")
	private BigDecimal naMailContacto;

	//bi-directional many-to-one association to SiminMaestro
    @ManyToOne
	@JoinColumn(name="C_PERL_CODIGO")
	private SiminMaestro siminMaestro;

    public SiminCorreo() {
    }

	public long getCoMailCodigo() {
		return this.coMailCodigo;
	}

	public void setCoMailCodigo(long coMailCodigo) {
		this.coMailCodigo = coMailCodigo;
	}

	public String getCoMailGenerado() {
		return this.coMailGenerado;
	}

	public void setCoMailGenerado(String coMailGenerado) {
		this.coMailGenerado = coMailGenerado;
	}

	public Date getDaMailFecha() {
		return this.daMailFecha;
	}

	public void setDaMailFecha(Date daMailFecha) {
		this.daMailFecha = daMailFecha;
	}

	public String getFaMailEstado() {
		return this.faMailEstado;
	}

	public void setFaMailEstado(String faMailEstado) {
		this.faMailEstado = faMailEstado;
	}

	public String getNaMailCorreo() {
		return this.naMailCorreo;
	}

	public void setNaMailCorreo(String naMailCorreo) {
		this.naMailCorreo = naMailCorreo;
	}

	public String getNaMailPiso() {
		return this.naMailPiso;
	}

	public void setNaMailPiso(String naMailPiso) {
		this.naMailPiso = naMailPiso;
	}

	public String getNaMailRequerimiento() {
		return this.naMailRequerimiento;
	}

	public void setNaMailRequerimiento(String naMailRequerimiento) {
		this.naMailRequerimiento = naMailRequerimiento;
	}

	public SiminMaestro getSiminMaestro() {
		return this.siminMaestro;
	}

	public void setSiminMaestro(SiminMaestro siminMaestro) {
		this.siminMaestro = siminMaestro;
	}
	
	public BigDecimal getNaMailContacto() {
		return this.naMailContacto;
	}

	public void setNaMailContacto(BigDecimal naMailContacto) {
		this.naMailContacto = naMailContacto;
	}

}