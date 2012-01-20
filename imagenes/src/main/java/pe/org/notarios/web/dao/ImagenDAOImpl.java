package pe.org.notarios.web.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.org.notarios.web.model.Imagenes;

@Repository
public class ImagenDAOImpl extends HibernateDaoSupport implements ImagenDAO {

	@Autowired
	public ImagenDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Imagenes> listarImagenes() {
		return this.getHibernateTemplate().find("from Imagenes ");
	}

	@Override
	public void insertaImagen(Imagenes imagen) {
		this.getHibernateTemplate().save(imagen);
	}

	@Override
	public Imagenes obtenerImagen(String id) {
		return (Imagenes)this.getHibernateTemplate().find("from Imagenes where idImagen ='" +id+ "'").get(0);
	}

}
