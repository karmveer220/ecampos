package pe.gob.pcm.constitucion.web.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.pcm.constitucion.web.dao.InsertoDAO;
import pe.gob.pcm.constitucion.web.model.T029archivo;
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

	@Override
	public String obtenerInserto(Integer id) {
		return (String)getSession().createQuery("select desInserto from T030inserto p where p.t020tramite.numTramite = :id ")
        .setInteger("id", id)
        .uniqueResult();
	}
	
	@Override
	public void eliminarInserto(Integer numTramite) {
		getSession().createQuery("delete from T030inserto p where p.t020tramite.numTramite = :id ")
        .setInteger("id", numTramite)
        .executeUpdate();
	}
	
	@Override
	public void registrarArchivo(T029archivo archivo) {
		this.getHibernateTemplate().save(archivo);
	}

	@Override
	public T029archivo obtenerArchivo(String idTramite,String tipo) {
		Query query = getSession().createQuery(" from T029archivo p where p.t020tramite.numTramite = :id and indTiparch = :tipo")
        .setString("id", idTramite)
        .setString("tipo", tipo);
        return (T029archivo) query.uniqueResult();
	}

	@Override
	public void borrarParte(Integer numTramite, String tipo) {
		getSession().createQuery(" delete from T029archivo p where p.t020tramite.numTramite = :id and indTiparch = :tipo")
        .setInteger("id", numTramite)
        .setString("tipo", tipo)
        .executeUpdate();
		
	}


}
