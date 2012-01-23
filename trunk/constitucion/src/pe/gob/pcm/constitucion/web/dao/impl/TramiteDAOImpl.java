package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;
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
		//criteria.add( Restrictions.eq("cliestadonu", 1) );			
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
}
