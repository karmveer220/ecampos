package pe.org.cnc.dao;

import java.util.List;

import pe.org.cnc.model.Notario;

public interface NotarioDAO {

	public void registrarNotario(Notario notario);
	public Notario obtenerNotario(Integer idNotario);
	public void eliminarNotario(Integer idNotario);
	public List<Notario> buscarNotario(Notario notario);
	
}
