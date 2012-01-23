package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.pcm.constitucion.web.dao.ParticipanteDAO;
import pe.gob.pcm.constitucion.web.model.T022accionista;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;

@Repository
public class ParticipanteDAOImpl extends HibernateDaoSupport implements ParticipanteDAO {

	@Autowired
	public ParticipanteDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public List<T022accionista> listarAccionistas(String anioTramite,
			String numTramite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T025pernat> listarPersonasNaturales(String anioTramite,
			String numTramite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T026perjur> listarPersonasJuridicas(String anioTramite,
			String numTramite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarAccionistas(T022accionista accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registrarPersonaNatural(T025pernat accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registrarPersonaJuridica(T026perjur accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarAccionistas(T022accionista accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPersonaNatural(T025pernat accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPersonaJuridica(T026perjur accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAccionistas(T022accionista accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPersonaNatural(T025pernat accionista) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPersonaJuridica(T026perjur accionista) {
		// TODO Auto-generated method stub

	}

}
