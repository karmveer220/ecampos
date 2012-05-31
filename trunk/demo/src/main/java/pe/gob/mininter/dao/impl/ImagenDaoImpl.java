package pe.gob.mininter.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dao.ImagenDao;
import pe.gob.mininter.entities.SiminImagen;

@Repository
public class ImagenDaoImpl extends HibernateDaoSupport implements ImagenDao {

	@Autowired
	public ImagenDaoImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SiminImagen> listarImagenes(Integer codPublicacion) {
		return this.getHibernateTemplate().find("from SiminImagen i where rownum < 17 and i.siminTipoPublicacion.coTipPublicacion = "+codPublicacion+" order by naImgNombre desc");
	}

	@Override
	public Integer insertaImagen(SiminImagen imagen) {
		return (Integer) this.getHibernateTemplate().save(imagen);
	}

	@Override
	public SiminImagen obtenerImagen(String id) {
		return (SiminImagen)this.getHibernateTemplate().find("from SiminImagen where coImgCodigo ='" +id+ "'").get(0);
	}

	@Override
	public SiminImagen listarImagenCodigo(String id) {
		return (SiminImagen)this.getHibernateTemplate().find("from SiminImagen i where faImgEstado = 1 and i.siminTipoPublicacion.coTipPublicacion = "+id).get(0);
	}	

}
