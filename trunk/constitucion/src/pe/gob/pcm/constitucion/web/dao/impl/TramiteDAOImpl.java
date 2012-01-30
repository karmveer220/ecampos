package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.pcm.constitucion.web.dao.TramiteDAO;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.util.Utiles;

@Repository
public class TramiteDAOImpl extends HibernateDaoSupport implements TramiteDAO {

	@Autowired
	public TramiteDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}

	@Override
	public void registrarTramite(T020tramite tramite) {
		this.getHibernateTemplate().save(tramite);
	}

	@Override
	public void modificarTramite(T020tramite tramite) {
		this.getHibernateTemplate().saveOrUpdate(tramite);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T020tramite> listarTramites(T020tramite tramite) {
		DetachedCriteria criteria = DetachedCriteria.forClass(T020tramite.class);
		if(!Utiles.nullToBlank( tramite.getClvKardex() ).equals("")){
			criteria.add( Restrictions.ilike("clvKardex", tramite.getClvKardex() ,MatchMode.ANYWHERE) );			
		}
		if(!Utiles.nullToBlank( tramite.getIndEstado() ).equals("")){
			criteria.add( Restrictions.like("indEstado", tramite.getIndEstado() ) );			
		}		
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public T020tramite obtenerTramite(String id) {
		Query query = getSession().createQuery(" from T020tramite p where p.numTramite = :id ")
        .setString("id", id);
        return (T020tramite) query.uniqueResult();
	}
	
}
