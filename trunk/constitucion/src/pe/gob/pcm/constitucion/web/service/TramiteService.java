package pe.gob.pcm.constitucion.web.service;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T020tramite;

public interface TramiteService {

	public void registrarTramite(T020tramite tramite);

	public void modificarTramite(T020tramite tramite);

	public List<T020tramite> listarTramites(T020tramite tramite);
	
}
