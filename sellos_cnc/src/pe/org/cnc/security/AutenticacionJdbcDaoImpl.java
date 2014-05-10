package pe.org.cnc.security;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;

import pe.org.cnc.dao.UsuarioDAO;
import pe.org.cnc.model.Usuario;

@Repository("userLoginService")
public class AutenticacionJdbcDaoImpl extends JdbcDaoImpl{

	private Logger logger = Logger.getLogger(AutenticacionJdbcDaoImpl.class);
		
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Autowired
	public AutenticacionJdbcDaoImpl(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			
			this.setUsersByUsernameQuery("SELECT u.username as username,u.clave as password, u.estado as enabled  FROM usuarios u WHERE u.username = ?");
			this.setAuthoritiesByUsernameQuery("SELECT usuario as username ,authority FROM authorities WHERE usuario = ?");
			
			logger.debug("usuario login "+ username );
			UserDetails user = super.loadUserByUsername(username);
			Usuario usuario = usuarioDao.obtenerUsuarioPorUsername(username);
			
			Usuario ubean = new Usuario(user.getUsername(), user.getPassword(), user.isEnabled(), user.getAuthorities());
			ubean.setUsername(user.getUsername());
			ubean.setClave(user.getPassword());
			ubean.setNombres(usuario.getNombres());
			ubean.setApellidos(usuario.getApellidos());
			ubean.setEstado( user.isEnabled()==true?1:0);
			logger.debug("*********"+ubean.toString());
			return ubean;	
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("No hay notaria relacionada a este usuario");
		}
	}

	
}
