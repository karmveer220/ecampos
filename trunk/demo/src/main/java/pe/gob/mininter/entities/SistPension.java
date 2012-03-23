package pe.gob.mininter.entities;

import java.io.Serializable;

public class SistPension implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id_sisPension;
	private String nom_sisPension;
	private String desc_sisPension;
	private Double porcentaje;
	private Integer contador;
	
	public SistPension() {	}

	public SistPension(String id_sisPension,String nom_sisPension,Double porcentaje) {
		this.id_sisPension=id_sisPension;
		this.nom_sisPension=nom_sisPension;
		this.porcentaje=porcentaje;
	}
	
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public void setId_sisPension(String id_sisPension) {
		this.id_sisPension = id_sisPension;
	}
	public String getId_sisPension() {
		return id_sisPension;
	}
	public void setNom_sisPension(String nom_sisPension) {
		this.nom_sisPension = nom_sisPension;
	}
	public String getNom_sisPension() {
		return nom_sisPension;
	}
	public String getDesc_sisPension() {
		return desc_sisPension;
	}
	public void setDesc_sisPension(String desc_sisPension) {
		this.desc_sisPension = desc_sisPension;
	}
}