package pe.org.cnc.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the notarios database table.
 * 
 */
@Entity
@Table(name="notarios")
@NamedQuery(name="Notario.findAll", query="SELECT n FROM Notario n")
public class Notario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idnotario;

	private String apellidos;

	private String direccion;

	private int estado;

	@Temporal(TemporalType.DATE)
	private Date fechasello;

	private String nombrenotaria;

	private String nombre;

	private String telefonos;

	private String textosello;

	public Notario() {
	}

	public int getIdnotario() {
		return this.idnotario;
	}

	public void setIdnotario(int idnotario) {
		this.idnotario = idnotario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechasello() {
		return this.fechasello;
	}

	public void setFechasello(Date fechasello) {
		this.fechasello = fechasello;
	}

	public String getNombrenotaria() {
		return this.nombrenotaria;
	}

	public void setNombrenotaria(String nombrenotaria) {
		this.nombrenotaria = nombrenotaria;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getTextosello() {
		return this.textosello;
	}

	public void setTextosello(String textosello) {
		this.textosello = textosello;
	}

}