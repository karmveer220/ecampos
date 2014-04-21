package pe.org.cnc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.org.cnc.dao.NotarioDAO;
import pe.org.cnc.model.Notario;
import pe.org.cnc.util.Utiles;
@Repository
public class NotarioDAOImpl extends HibernateDaoSupport  implements NotarioDAO{

	@Autowired
	public NotarioDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public void registrarNotario(Notario notario) {
		this.getHibernateTemplate().saveOrUpdate( notario );
	}

	@Override
	public Notario obtenerNotario(Integer idNotario) {
		try {
			return (Notario) this.getHibernateTemplate().find("from Notario u where idnotario = ? ", idNotario).get(0);
		} catch (Exception e) {
			logger.error( e.getMessage() );
			return null;
		}
	}

	@Override
	public void eliminarNotario(Integer idNotario) {
		this.getHibernateTemplate().bulkUpdate(" update Notario u set estado = 0 where idnotario = ? ", idNotario );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notario> buscarNotario(Notario notario) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Notario.class);
		logger.debug(" buscar buscarNotario() ");
		criteria.add( Restrictions.eq("estado", 1) );
		if(notario !=null){
			if( !Utiles.nullToBlank( notario.getIdnotario() ).equals("0")){
				criteria.add( Restrictions.eq("idnotario", notario.getIdnotario() ) );
			}
			if( !Utiles.nullToBlank( notario.getNombre() ).equals("")){
				criteria.add( Restrictions.ilike("nombre", notario.getNombre() , MatchMode.ANYWHERE ) );
			}
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public Notario validaTexto(String texto) {
		try {
			return (Notario) this.getHibernateTemplate().find("from Notario u where textosello like ? ", texto).get(0);
		} catch (Exception e) {
			logger.error( e.getMessage() );
			return null;
		}
	}

}
