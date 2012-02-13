package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.pcm.constitucion.web.dao.MandatarioDAO;
import pe.gob.pcm.constitucion.web.model.T032mandatario;

@Repository
public class MandatarioDAOImpl extends HibernateDaoSupport implements MandatarioDAO{

	@Autowired
	public MandatarioDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T032mandatario> listarMandatarios(Integer idTramite) {
		Query query = getSession().createQuery(" from T032mandatario p where p.t020tramite.numTramite = :id ")
        .setInteger("id", idTramite);
        return (List<T032mandatario>) query.list();
	}

	@Override
	public T032mandatario obtenerMandatario(Integer idMandatario) {
		Query query = getSession().createQuery(" from T032mandatario p where p.idMandatario = :id ")
        .setInteger("id", idMandatario);
        return (T032mandatario) query.uniqueResult();
	}

	@Override
	public void registrarMandatario(T032mandatario mandatario) {
		this.getHibernateTemplate().saveOrUpdate(mandatario);
	}

	@Override
	public void eliminarMandatario(Integer mandatario) {
		getSession().createQuery(" delete from T032mandatario p where p.idMandatario = :id ")
        .setInteger("id", mandatario).executeUpdate();
	}

	@Override
	public void editarMandatario(T032mandatario mandatario) {
		this.getHibernateTemplate().merge(mandatario);
	}

	@Override
	public void asignaCargoMandatario(Integer codman, String codCargo) {
		getSession().createQuery(" update T032mandatario m set m.codCargo = :cargo where m.idMandatario = :id ")
        .setInteger("id", codman).setString("cargo", codCargo).executeUpdate();		
	}

}
