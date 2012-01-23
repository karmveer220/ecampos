package pe.gob.pcm.constitucion.web.dao;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T020tramite;

public interface TramiteDAO {

	public void registrarTramite(T020tramite tramite);

	public void modificarTramite(T020tramite tramite);

	public List<T020tramite> listarTramites(T020tramite tramite);
	
}
