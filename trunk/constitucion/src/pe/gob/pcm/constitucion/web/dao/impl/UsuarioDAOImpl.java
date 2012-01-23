package pe.gob.pcm.constitucion.web.dao.impl;

import java.util.List;

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
	
	@Override
	public List<Users> listaUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> listaUsuarios(Users usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users obtenerUsuarioPorUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users obtenerUsuario(String username) {
		// TODO Auto-generated method stub
		return null;
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
