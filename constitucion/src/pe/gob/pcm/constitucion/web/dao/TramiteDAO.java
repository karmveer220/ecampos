package pe.gob.pcm.constitucion.web.dao;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T020tramite;

public interface TramiteDAO {

	public void registrarTramite(T020tramite tramite);

	public void modificarTramite(T020tramite tramite);

	public List<T020tramite> listarTramites(T020tramite tramite);

	public T020tramite obtenerTramite(Integer tramite);

	public void eliminarTramite(Integer tramite);

	public void restaurarTramite(Integer tramite);

	public void cerrarTramite(Integer tramite);

	public void firmarTramite(Integer tramite);

	public void recibirTramite(Integer tramite);

	public void enviarTramite(Integer tramite);

	public void abrirTramite(int tramite);
	
}
