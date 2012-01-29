package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.pcm.constitucion.web.dao.UsuarioDAO;
import pe.gob.pcm.constitucion.web.model.Users;

@Repository
public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	@Autowired
	public UsuarioDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listaUsuarios() {
		Query query = getSession().createQuery(" from Users u  ");
        return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listaUsuarios(Users usuario) {
		Query query = getSession().createQuery(" from Users u  ");
        return query.list();
	}

	@Override
	public Users obtenerUsuarioPorUsername(String username) {
		Query query = getSession().createQuery(" from Users u where u.username = :id ")
        .setString("id", username);
        return (Users) query.uniqueResult();
	}

	@Override
	public void registrarusuario(Users usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarusuario(Users usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPermisos(Users usuario) {
		// TODO Auto-generated method stub

	}

}
