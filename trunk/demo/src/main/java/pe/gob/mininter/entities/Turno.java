package pe.gob.mininter.entities;

import java.io.Serializable;

public class Turno implements Serializable {
	
	  Integer codigoTurno ;
	  String descripcionTurno ;
	  Integer estado ;
	  String horaInicio;
	  String horaFin;
	  String comentario;
	  String descripcionEstado;
	  String nombreTurno;
	  
	  
	  
	  private String horaTolerancia;
	  private String detalleTurno;

	  private Integer contador;
	  
	  
	  
	  
	  
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public String getDetalleTurno() {
		return detalleTurno;
	}
	public void setDetalleTurno(String detalleTurno) {
		this.detalleTurno = detalleTurno;
	}
	public String getNombreTurno() {
		return nombreTurno;
	}
	public void setNombreTurno(String nombreTurno) {
		this.nombreTurno = nombreTurno;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	
	  
	public Integer getCodigoTurno() {
		return codigoTurno;
	}
	public void setCodigoTurno(Integer codigoTurno) {
		this.codigoTurno = codigoTurno;
	}
	public String getDescripcionTurno() {
		return descripcionTurno;
	}
	public void setDescripcionTurno(String descripcionTurno) {
		this.descripcionTurno = descripcionTurno;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public void setHoraTolerancia(String string) {
		this.horaTolerancia=string;
		
	}
	public String getHoraTolerancia() {
		return horaTolerancia;
	}
	public void setDescripcionEstado(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	  
	  
	
	

}
