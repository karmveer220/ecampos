package pe.gob.pcm.constitucion.web.service;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T029archivo;

public interface TramiteService {

	public void registrarTramite(T020tramite tramite);

	public void modificarTramite(T020tramite tramite);

	public List<T020tramite> listarTramites(T020tramite tramite);

	public T020tramite obtenerTramite(Integer id);

	public void registrarArchivo(T029archivo archivo);

	public T029archivo obtenerArchivo(String idTramite, String tipo);

	public void borrarParte(Integer numTramite, String tipo);

	public void eliminarTramite(Integer tramite);

	public void restaurarTramite(Integer tramite);

	public void cerrarTramite(Integer tramite);

	public void firmarTramite(T020tramite tr);

	public void recibirTramite(Integer tramite);

	/**
	 * aqui llamo al servicio para el envio, generacio xml y zip
	 * @param tr
	 */
	public void enviarTramite(T020tramite tr);

	public void abrirTramite(int parseInt);
	
}
