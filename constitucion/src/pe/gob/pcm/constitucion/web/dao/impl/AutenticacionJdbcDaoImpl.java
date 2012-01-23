package pe.gob.pcm.constitucion.web.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;

import pe.gob.pcm.constitucion.web.dao.UsuarioDAO;
import pe.gob.pcm.constitucion.web.model.Users;

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
			
			this.setUsersByUsernameQuery("SELECT username,  password, enabled  FROM users u WHERE username = ?");
			this.setAuthoritiesByUsernameQuery("SELECT username ,authority FROM authorities WHERE username = ?");
			
			UserDetails user = super.loadUserByUsername(username);
			logger.debug("usuario login "+user.toString());
			Users usuario = usuarioDao.obtenerUsuarioPorUsername(username);
			Users ubean = new Users(user.getUsername(), user.getPassword(), user.isEnabled(), user.getAuthorities());
			ubean.setUsername(user.getUsername());
			ubean.setPassword(user.getPassword());
			ubean.setEnabled( user.isEnabled());
			logger.debug("*********"+ubean.toString());
			return ubean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("No hay notaria relacionada a este usuario");
		}
	}

	
}
