package pe.org.cnc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parametros {

	@Id
	private int idParametro;
	private String nombre;
	private String valor;
	public int getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
