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
import pe.gob.pcm.constitucion.web.model.T020tramite;
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
		logger.debug("num tramite = " + idtramite + " encotnrados " + lis.size() );
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
		this.getHibernateTemplate().saveOrUpdate(accionista);
	}

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void registrarPersonaNatural(T025pernat accionista) {
		this.getHibernateTemplate().saveOrUpdate(accionista);
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

	/**
	 * eliminar un accionista de en un determinado tramite
	 */
	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void eliminarAccionistas(Integer tramite, String codTipoDoc, String numDoc) {
		logger.debug("eliminar un accionista del tramite tram=" + tramite +"; tdoc=" + codTipoDoc +"; num="+ numDoc);
		getSession().createQuery(" delete from T022accionista a where a.t020tramite.numTramite = :id and a.codTipdoc= :tipoDoc and a.numDocum = :numDoc")
        .setInteger("id", tramite)
        .setString("tipoDoc", codTipoDoc)
        .setString("numDoc", numDoc)
        .executeUpdate();
	}

	/**
	 * eliminar una persona natural
	 */
	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void eliminarPersonaNatural(Integer tramite, String codTipoDoc, String numDoc) {
		logger.debug("eliminar  persona natural tram=" + tramite +"; tdoc=" + codTipoDoc +"; num="+ numDoc);
		getSession().createQuery(" delete from T025pernat p where p.t020tramite.numTramite = :tramite and p.codTipdoc = :tipoDoc and p.numDocum = :numDoc ")
		.setInteger("tramite", tramite)
		.setString("tipoDoc", codTipoDoc)
		.setString("numDoc", numDoc)
		.executeUpdate();
	}

	/**
	 * Eliminar una persona juridica
	 */
	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void eliminarPersonaJuridica(Integer tramite, String codTipoDoc, String numDoc) {
		logger.debug("eliminar  persona juridica tram=" + tramite +"; tdoc=" + codTipoDoc +"; num="+ numDoc);
		getSession().createQuery(" delete from T026perjur p where p.t020tramite.numTramite = :tramite and p.codTipdoc = :tipoDoc and p.numDocum = :numDoc ")
        .setInteger("tramite", tramite)
        .setString("tipoDoc", codTipoDoc)
        .setString("numDoc", numDoc)
        .executeUpdate();
	}

	
	@Override
	public T022accionista obtenerAccionista(String numDoccon, String codTipdoc, T020tramite t020tramite) {
		Query query = getSession().createQuery(" from T022accionista p where p.codTipdoc = :tdoc and p.numDocum = :num and p.t020tramite.numTramite =:tr")
        .setString("num", numDoccon)
		.setString("tdoc", codTipdoc)
		.setInteger("tr", t020tramite.getNumTramite());
		return (T022accionista)query.uniqueResult();
	}

	@Override
	public T022accionista obtenerAccionista(Integer cod) {
		Query query = getSession().createQuery(" from T022accionista a where a.idAccionista = :id")
        .setInteger("id", cod );
		return (T022accionista)query.uniqueResult();
	}

	@Override
	public T025pernat obtenerParticipantePn(Integer tramite, String codTipoDoc, String numDoc) {
		Query query = getSession().createQuery(" from T025pernat p where p.codTipdoc = :tipoDoc and p.numDocum = :numDoc and p.t020tramite.numTramite = :tramite ")
        .setInteger("tramite", tramite )
        .setString("tipoDoc", codTipoDoc)
        .setString("numDoc", numDoc );
		return (T025pernat)query.uniqueResult();
	}

	@Override
	public T026perjur obtenerParticipantePj(Integer tramite, String codTipoDoc, String numDoc) {
		Query query = getSession().createQuery(" from T026perjur p where p.codTipdoc = :tipoDoc and p.numDocum = :numDoc and p.t020tramite.numTramite = :tramite ")
        .setInteger("tramite", tramite )
        .setString("tipoDoc", codTipoDoc)
        .setString("numDoc", numDoc );
		return (T026perjur)query.uniqueResult();
	}

	@Override
	public T025pernat obtenerParticipantePn(Integer idPn) {
		Query query = getSession().createQuery(" from T025pernat p where p.idPernat = :id ")
        .setInteger("id", idPn );
		return (T025pernat)query.uniqueResult();
	}


}
