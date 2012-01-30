package pe.gob.pcm.constitucion.web.dao;

import pe.gob.pcm.constitucion.web.model.T029archivo;
import pe.gob.pcm.constitucion.web.model.T030inserto;

public interface InsertoDAO {

	public void registraInserto( T030inserto inserto);

	public void registrarArchivo(T029archivo archivo);

	public T029archivo obtenerArchivo(String idTramite, String tipo);

	public void borrarParte(Integer numTramite, String tipo);
	
}
