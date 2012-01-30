package pe.gob.pcm.constitucion.web.bean;

public class BeanValida {

	private int resultado;
	private String mensaje;
	
	public BeanValida(){}
	
	public BeanValida(int resultado, String mensaje){
		this.resultado=resultado;
		this.mensaje=mensaje;
	}
	
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public void aumenta(int cantidad, String mensaje){
		this.resultado += cantidad;
		this.mensaje += mensaje;
	}
	@Override
	public String toString(){
		return "Resultado = " + resultado + "; Mensaje = " + mensaje ; 
	}
	
}
