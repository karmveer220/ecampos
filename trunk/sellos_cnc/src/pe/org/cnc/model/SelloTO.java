package pe.org.cnc.model;

import java.util.Date;

public class SelloTO {

	private Integer codigo;
	private String texto;
	private Date fechaCreacion;
	
	public SelloTO(){
		
	}
	
	public SelloTO(Integer codigo, String texto, Date fechaCreacion) {
		super();
		this.codigo = codigo;
		this.texto = texto;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
