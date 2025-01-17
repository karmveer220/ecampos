package pe.org.cnc.service;

import java.util.List;

import pe.org.cnc.model.Notario;

public interface NotarioService {

	public void registrarNotario(Notario notario);
	public Notario obtenerNotario(Integer idNotario);
	public void eliminarNotario(Integer idNotario);
	public List<Notario> buscarNotario(Notario notario);
	public Notario validaTexto(String texto);
	
}
