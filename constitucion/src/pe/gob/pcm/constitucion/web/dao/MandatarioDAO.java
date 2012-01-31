package pe.gob.pcm.constitucion.web.dao;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T032mandatario;

public interface MandatarioDAO {

	public List<T032mandatario> listarMandatarios(Integer idTramite);
	public T032mandatario obtenerMandatario(Integer idMandatario);
	public void registrarMandatario(T032mandatario mandatario);
	public void eliminarMandatario(Integer mandatario);
	public void editarMandatario(T032mandatario mandatario);
	
}
