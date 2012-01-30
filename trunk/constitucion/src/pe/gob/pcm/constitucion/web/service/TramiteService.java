package pe.gob.pcm.constitucion.web.service;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T029archivo;

public interface TramiteService {

	public void registrarTramite(T020tramite tramite);

	public void modificarTramite(T020tramite tramite);

	public List<T020tramite> listarTramites(T020tramite tramite);

	public T020tramite obtenerTramite(String id);

	public void registrarArchivo(T029archivo archivo);

	public T029archivo obtenerArchivo(String idTramite, String tipo);

	public void borrarParte(Integer numTramite, String tipo);
	
}
