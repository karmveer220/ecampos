package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T022accionista> listarAccionistas( int idtramite ) {
		Query query = getSession().createQuery(" from T022accionista p where p.t020tramite.numTramite  = :id ")
        .setInteger("id", idtramite);
		List<T022accionista> lis =  query.list();
		logger.debug("encotnrados " + lis.size() );
		return lis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T025pernat> listarPersonasNaturales(int idtramite) {
		Query query = getSession().createQuery(" from T025pernat p where p.t020tramite.numTramite  = :id ")
        .setInteger("id", idtramite);
		List<T025pernat> lis = query.list();
		logger.debug("encotnrados " + lis.size() );
		return lis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T026perjur> listarPersonasJuridicas(int idtramite) {
		Query query = getSession().createQuery(" from T026perjur p where p.t020tramite.numTramite  = :id ")
        .setInteger("id", idtramite);
		List<T026perjur> lis = query.list();
		logger.debug("encotnrados " + lis.size() );
		return lis;
	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void registrarAccionistas(T022accionista accionista) {
		this.getHibernateTemplate().save(accionista);
	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void registrarPersonaNatural(T025pernat accionista) {
		this.getHibernateTemplate().save(accionista);
	}

	@Override
	public void registrarPersonaJuridica(T026perjur accionista) {
		this.getHibernateTemplate().save(accionista);
	}

	@Override
	public void modificarAccionistas(T022accionista accionista) {
		this.getHibernateTemplate().merge(accionista);
	}

	@Override
	public void modificarPersonaNatural(T025pernat accionista) {
		this.getHibernateTemplate().merge(accionista);
	}

	@Override
	public void modificarPersonaJuridica(T026perjur accionista) {
		this.getHibernateTemplate().merge(accionista);
	}

	@Override
	public void eliminarAccionistas(T022accionista accionista) {
		this.getHibernateTemplate().merge(accionista);
	}

	@Override
	public void eliminarPersonaNatural(T025pernat accionista) {
		this.getHibernateTemplate().merge(accionista);
	}

	@Override
	public void eliminarPersonaJuridica(T026perjur accionista) {
		this.getHibernateTemplate().merge(accionista);
	}

}
