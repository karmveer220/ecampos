package pe.gob.mininter.entities;

import java.io.Serializable;

public class Justificacion implements Serializable {
	  Integer codigoJustificacion ;
	  String descripcionJustificacion;
	  Integer estado;
	  Integer codigoProgramacion ;
	  String comentario;
	  String descripcionEstado;
	  String descuento;
	  
	  
	  
	  
	  
	  
	  
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	public Integer getCodigoJustificacion() {
		return codigoJustificacion;
	}
	public void setCodigoJustificacion(Integer codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}
	public String getDescripcionJustificacion() {
		return descripcionJustificacion;
	}
	public void setDescripcionJustificacion(String descripcionJustificacion) {
		this.descripcionJustificacion = descripcionJustificacion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getCodigoProgramacion() {
		return codigoProgramacion;
	}
	public void setCodigoProgramacion(Integer codigoProgramacion) {
		this.codigoProgramacion = codigoProgramacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	  
	
	
	  

}
