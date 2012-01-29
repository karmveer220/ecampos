package pe.gob.pcm.constitucion.web.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.pcm.constitucion.web.dao.NotariaDAO;
import pe.gob.pcm.constitucion.web.model.T021notaria;

@Repository
public class NotariaDAOImpl extends HibernateDaoSupport implements NotariaDAO {

	@Autowired
	public NotariaDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}

	@Override
	public T021notaria obtenerNotaria(String codNotaria) {
		Query query = getSession().createQuery(" from T021notaria p where p.codNotaria = :id ")
        .setString("id", codNotaria);
        return (T021notaria) query.uniqueResult();
	}
	
}
