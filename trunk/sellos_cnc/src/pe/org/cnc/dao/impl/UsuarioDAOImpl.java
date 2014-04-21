package pe.org.cnc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.org.cnc.dao.UsuarioDAO;
import pe.org.cnc.model.Usuario;

@Repository
public class UsuarioDAOImpl  extends HibernateDaoSupport implements UsuarioDAO {


	@Autowired
	public UsuarioDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public Usuario obtenerUsuario(String username) {
		try {
			return (Usuario) this.getHibernateTemplate().find("from Usuario u where username = ? ", username).get(0);
		} catch (Exception e) {
			logger.debug( e.getMessage() );
			return null;
		}
	}
	
}
