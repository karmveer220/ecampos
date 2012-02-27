package pe.gob.pcm.constitucion.web.dao;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T022accionista;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;

public interface ParticipanteDAO {

	public List<T022accionista> listarAccionistas( int tramite );
	public List<T025pernat> listarPersonasNaturales( int idtramite );
	public List<T026perjur> listarPersonasJuridicas( int idtramite );
	
	public void registrarAccionistas(T022accionista accionista);
	public void registrarPersonaNatural(T025pernat accionista);
	public void registrarPersonaJuridica(T026perjur accionista);
	
	public void modificarAccionistas(T022accionista accionista);
	public void modificarPersonaNatural(T025pernat accionista);
	public void modificarPersonaJuridica(T026perjur accionista);
	
	public void eliminarAccionistas(T022accionista accionista);
	public void eliminarPersonaNatural(T025pernat accionista);
	public void eliminarPersonaJuridica(T026perjur accionista);
	public T025pernat obtenerParticipantePn(String cod);
	public T022accionista obtenerAccionista(String numDoccon, String codTipdoc,T020tramite t020tramite);
	
}
