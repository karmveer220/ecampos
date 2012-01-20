package pe.org.notarios.web.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name = "imagenes")
public class Imagenes {


    private int idImagen;
    private byte[] imagen;
    private String nombre;
    private String observaciones;
    private BigInteger size;;
    
   public Imagenes() {
   }

	
   public Imagenes(int idImagen) {
       this.idImagen = idImagen;
   }
   public Imagenes(int idImagen, byte[] imagen, String nombre, String observaciones,BigInteger size) {
      this.idImagen = idImagen;
      this.imagen = imagen;
      this.nombre = nombre;
      this.observaciones = observaciones;
      this.size=size;
   }
  
    @Id 
    @GeneratedValue
   @Column(name="id_imagen", unique=true, nullable=false)
   public int getIdImagen() {
       return this.idImagen;
   }
   
   public void setIdImagen(int idImagen) {
       this.idImagen = idImagen;
   }
   
   @Lob 
   @Column(name="imagen")
   public byte[] getImagen() {
       return this.imagen;
   }
   
   public void setImagen(byte[] imagen) {
       this.imagen = imagen;
   }
   
   @Column(name="nombre", length=100)
   public String getNombre() {
       return this.nombre;
   }
   
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }
   
   @Column(name="observaciones", length=1000)
   public String getObservaciones() {
       return this.observaciones;
   }
   
   public void setObservaciones(String observaciones) {
       this.observaciones = observaciones;
   }

   @Column(name="size")
	public BigInteger getSize() {
		return size;
	}
	
	
	public void setSize(BigInteger size) {
		this.size = size;
	}

    
}
