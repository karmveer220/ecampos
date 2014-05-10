package pe.org.cnc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.org.cnc.dao.UsuarioDAO;
import pe.org.cnc.model.Authority;
import pe.org.cnc.model.Permisos;
import pe.org.cnc.model.Usuario;
@Repository
public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	@Autowired
	public UsuarioDAOImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public void registrarUsuario(Usuario usuario) {
		this.getHibernateTemplate().saveOrUpdate(usuario);
	}

	@Override
	public void eliminarUsuario(Integer idUsuario) {
		Query query = getSession().createQuery(" delete from Usuario u where idUsuario = :id  ")
        .setInteger("id", idUsuario);
		query.executeUpdate();
	}

	@Override
	public Usuario obtenerUsuario(Integer idUsuario) {
		Query query = getSession().createQuery("from Usuario u where idUsuario = :id  ")
        .setInteger("id", idUsuario);
		Usuario h = (Usuario)query.uniqueResult();
		return h;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<Usuario> listarUsuarios() {
		logger.debug("listarUsuarios()");
		//return this.getHibernateTemplate().find(" from Usuario u where estado=1");
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
		criteria.add( Restrictions.eq("estado", 1 ) );
		return getHibernateTemplate().findByCriteria(criteria);
	}
	

	@Override
	public Usuario obtenerUsuarioPorUsername(String username) {
		Query query = getSession().createQuery("from Usuario u where username = :id  ")
        .setString("id", username);
		Usuario h = (Usuario)query.uniqueResult();
		return h;
	}

	@Override
	public void registrarPermiso( Authority a ) {
		Query query = getSession().createQuery(" delete from Authority u where u.id.usuario = :id  ")
        .setInteger("id", a.getId() );
		query.executeUpdate();
		this.getHibernateTemplate().save( a );
	}

	/**
	 * ya no aplica, en esta tabla cada usuario tiene muchos roles asignados
	 */
	@Override
	@Deprecated
	public Authority obtenerPerfilUsuario(String username) {
		Query query = getSession().createQuery("from Authority u where u.id.usuario = :id  ")
        .setString("id", username);
		Authority h = (Authority)query.uniqueResult();
		return h;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarUsuarios(Usuario usuario) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
		logger.debug(" listarUsuarios() ");
		/*if(usuario !=null){
			if( usuario.getEntidad()!=null && !Utiles.nullToBlank( usuario.getEntidad().getIdEntidad() ).equals("")){
				criteria.add( Restrictions.eq("entidad.idEntidad", usuario.getEntidad().getIdEntidad() ) );
				logger.debug(" entidad = "+  usuario.getEntidad().getIdEntidad() );
			}
		}*/
		criteria.add( Restrictions.eq("estado", 1 ) );
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permisos> listarPermisos() {
		return this.getHibernateTemplate().find("from Permisos");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> obtenerPermisos(String username) {
		Query query = getSession().createQuery("select a.id.authority from Authority a where a.id.usuario = :id  ")
        .setString("id", username);
		List<String> l = query.list();
		for(String  i : l ){
			logger.debug( i);
		}
		return l;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void registrarPermisos(Usuario usuario) {
		Query query = getSession().createQuery(" delete from Authority u where u.id.usuario = :id  ")
        .setString("id", usuario.getUsername());
		query.executeUpdate();
		Authority a = null;
		
		for(String p : usuario.getlPermisos()){
			a = new Authority();
			a.setAuthority( p ) ;			
			a.setUsername( usuario.getUsername() );
			logger.debug( a );
			this.getHibernateTemplate().save( a );	
		}
		logger.debug("Permisos insertados");
	}

	

}
