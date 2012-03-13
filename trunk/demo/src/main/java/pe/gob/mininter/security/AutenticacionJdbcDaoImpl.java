package pe.gob.mininter.security;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("userLoginService")
public class AutenticacionJdbcDaoImpl extends JdbcDaoImpl {
	 
	private Logger logger = Logger.getLogger(AutenticacionJdbcDaoImpl.class);
	
	@Autowired
	public AutenticacionJdbcDaoImpl(DataSource dataSource){
		setDataSource(dataSource);
		logger.debug("jaja");
	}
	
	public UserDetails loadUserDetails(String username){
		logger.debug("llego el mensaje");
		
		try {
			this.setAuthoritiesByUsernameQuery("select m.n_mst_login as username, z.n_auto_rol as authority from simin_maestro m inner join srhl_autorizaciones z on m.c_perl_codigo = z.c_perl_codigo where m.n_mst_login = ? ");
			UserDetails user = super.loadUserByUsername(username);
			logger.debug("usuario login "+user.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("No existe el usuario en el directorio activo. Comuniquese con Soporte Técnico");
		}
		return null;
	}
	

}
