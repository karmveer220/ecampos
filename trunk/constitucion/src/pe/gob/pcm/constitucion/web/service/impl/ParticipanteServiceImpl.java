package pe.gob.pcm.constitucion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.pcm.constitucion.web.dao.ParticipanteDAO;
import pe.gob.pcm.constitucion.web.model.T022accionista;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;
import pe.gob.pcm.constitucion.web.service.ParticipanteService;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	@Autowired
	private ParticipanteDAO participanteDAO;
	
	@Override
	public List<T022accionista> listarAccionistas(String anioTramite, String numTramite) {
		return participanteDAO.listarAccionistas(anioTramite, numTramite);
	}

	@Override
	public List<T025pernat> listarPersonasNaturales(String anioTramite, String numTramite) {
		return participanteDAO.listarPersonasNaturales(anioTramite, numTramite);
	}

	@Override
	public List<T026perjur> listarPersonasJuridicas(String anioTramite, String numTramite) {
		return participanteDAO.listarPersonasJuridicas(anioTramite, numTramite);
	}

	@Override
	public void registrarAccionistas(T022accionista accionista) {
		participanteDAO.registrarAccionistas(accionista);
	}

	@Override
	public void registrarPersonaNatural(T025pernat accionista) {
		participanteDAO.registrarPersonaNatural(accionista);
	}

	@Override
	public void registrarPersonaJuridica(T026perjur accionista) {
		participanteDAO.registrarPersonaJuridica(accionista);
	}

	@Override
	public void modificarAccionistas(T022accionista accionista) {
		participanteDAO.modificarAccionistas(accionista);
	}

	@Override
	public void modificarPersonaNatural(T025pernat accionista) {
		participanteDAO.modificarPersonaNatural(accionista);
	}

	@Override
	public void modificarPersonaJuridica(T026perjur accionista) {
		participanteDAO.modificarPersonaJuridica(accionista);
	}

	@Override
	public void eliminarAccionistas(T022accionista accionista) {
		participanteDAO.eliminarAccionistas(accionista);
	}

	@Override
	public void eliminarPersonaNatural(T025pernat accionista) {
		participanteDAO.eliminarPersonaNatural(accionista);
	}

	@Override
	public void eliminarPersonaJuridica(T026perjur accionista) {
		participanteDAO.eliminarPersonaJuridica(accionista);
	}

}
