package pe.org.cnc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.org.cnc.dao.ParametroDAO;
import pe.org.cnc.model.Parametros;

@Repository
public class ParametroDAOImpl extends HibernateDaoSupport implements ParametroDAO {

	@Autowired
	public ParametroDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public Parametros obtenerParametro(Integer id) {
		try {
			return (Parametros) this.getHibernateTemplate().find("from Parametros u where idParametro = ? ", id ).get(0);
		} catch (Exception e) {
			logger.error( e.getMessage() );
			return null;
		}
	}

}
