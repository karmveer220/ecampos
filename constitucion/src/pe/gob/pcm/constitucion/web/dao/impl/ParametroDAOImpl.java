package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.pcm.constitucion.web.dao.ParametroDAO;
import pe.gob.pcm.constitucion.web.model.T001parametro;

@Repository
public class ParametroDAOImpl extends HibernateDaoSupport implements ParametroDAO {

	@Autowired
	public ParametroDAOImpl (SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T001parametro> litarParametros(String padre) {
		Query query = getSession().createQuery(" from T001parametro p where p.codGrupo = :id ")
        .setString("id", padre);
        return (List<T001parametro>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T001parametro> litarParametros(String padre, String padre2) {
		Query query = getSession().createQuery(" from T001parametro p where p.codGrupo = :id and p.codParam like '"+padre2+"%'  ")
        .setString("id", padre);
        return (List<T001parametro>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T001parametro> litarParametrosDepartamentos() {
		Query query = getSession().createQuery(" from T001parametro p where p.codGrupo = '006' and p.codParam like '%0000' ");
        return (List<T001parametro>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T001parametro> litarParametrosProvincias(String depa) {
		Query query = getSession().createQuery(" from T001parametro p where p.codGrupo = '006' and p.codParam like '"+depa+"%00'  ");
        return (List<T001parametro>) query.list();
	}

	@Override
	public List<T001parametro> litarParametrosdistritos(String depa, String prov) {
		Query query = getSession().createQuery(" from T001parametro p where p.codGrupo = '006' and p.codParam like '"+depa + prov +"%'  ");
        return (List<T001parametro>) query.list();
	}

}
