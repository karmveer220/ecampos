package pe.gob.pcm.constitucion.web.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.pcm.constitucion.web.dao.InsertoDAO;
import pe.gob.pcm.constitucion.web.model.T030inserto;

@Repository
public class InsertoDAOImpl  extends HibernateDaoSupport implements InsertoDAO {


	@Autowired
	public InsertoDAOImpl (SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void registraInserto(T030inserto inserto) {
		this.getHibernateTemplate().save(inserto);
	}

}
