package pe.gob.pcm.constitucion.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.pcm.constitucion.web.dao.ParticipanteDAO;
import pe.gob.pcm.constitucion.web.model.T022accionista;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;
import pe.gob.pcm.constitucion.web.service.ParticipanteService;
import pe.gob.pcm.constitucion.web.util.Utiles;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	@Autowired
	private ParticipanteDAO participanteDAO;
	
	@Override
	public List<T022accionista> listarAccionistas( int idtramite ) {
		return participanteDAO.listarAccionistas(idtramite);
	}

	@Override
	public List<T025pernat> listarPersonasNaturales( int idtramite ) {
		return participanteDAO.listarPersonasNaturales(idtramite);
	}

	@Override
	public List<T026perjur> listarPersonasJuridicas( int idtramite ) {
		return participanteDAO.listarPersonasJuridicas(idtramite);
	}

	@Override
	public void registrarAccionistas(T022accionista accionista) {
		participanteDAO.registrarAccionistas(accionista);
	}

	@Override
	@Transactional
	public void registrarPersonaNatural(T025pernat accionista) {
		participanteDAO.registrarPersonaNatural(accionista);
		
		if( !Utiles.nullToBlank(accionista.getMontoAporte()).equals("") ){
			
			T022accionista acc = new T022accionista();
			acc.setFecRegistro( new Date());
			
			acc.setMtoAporte( accionista.getMontoAporte() );
			acc.setIndAporte( accionista.getIndAporte() );
			acc.setCodParticipa( accionista.getCodParticipa() );
			
			acc.setNumDocum( accionista.getNumDocum() );
			acc.setCodTipdoc( accionista.getCodTipdoc());
			acc.setT020tramite( accionista.getT020tramite() );
			participanteDAO.registrarAccionistas( acc );
			
		}
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
