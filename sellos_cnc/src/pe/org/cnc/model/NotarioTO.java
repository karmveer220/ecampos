package pe.org.cnc.model;

import java.util.Date;
import java.util.List;

public class NotarioTO {

	private Integer codigo;
	private String nombre;
	private String colegiatura;
	private List<SelloTO> sellos;
	
	//del ultimo sello
	private Date fCreacion;	
	
	public Date getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(Date fCreacion) {
		this.fCreacion = fCreacion;
	}

	public NotarioTO(){
		
	}
	
	public NotarioTO(Integer codigo, String nombre, String colegiatura,
			List<SelloTO> sellos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.colegiatura = colegiatura;
		this.sellos = sellos;
	}
	
	public NotarioTO( String nombre, Date fecha){
		this.nombre = nombre;
		this.fCreacion = fecha;
	}
	

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColegiatura() {
		return colegiatura;
	}
	public void setColegiatura(String colegiatura) {
		this.colegiatura = colegiatura;
	}
	public List<SelloTO> getSellos() {
		return sellos;
	}
	public void setSellos(List<SelloTO> sellos) {
		this.sellos = sellos;
	}
	
	
	
}
