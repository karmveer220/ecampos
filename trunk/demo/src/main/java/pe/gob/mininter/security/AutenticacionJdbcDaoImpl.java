package pe.gob.mininter.security;

import java.util.Collection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Repository;

@Repository("usuarioService")
public class AutenticacionJdbcDaoImpl  extends JdbcDaoImpl  {
	 //implements LdapAuthoritiesPopulator
	private Logger logger = Logger.getLogger(AutenticacionJdbcDaoImpl.class);
	
	@Autowired
	public AutenticacionJdbcDaoImpl(DataSource dataSource){
		setDataSource(dataSource);
	}
		
	public UserDetails loadUserDetails(String username){
		logger.debug("llego el mensaje");
		
		try {

			this.setAuthoritiesByUsernameQuery("select m.n_mst_login as username, z.n_auto_rol as authority from simin_maestro m inner join srhl_autorizaciones z on m.c_perl_codigo = z.c_perl_codigo where m.n_mst_login = ? ");
			UserDetails user = super.loadUserByUsername(username);
			logger.debug("usuario login "+user.toString());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("No existe el usuario en el directorio activo. Comuniquese con Soporte Técnico");
		}
		
	}
	

	/*@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations dircontextoperations, String s) {
		
		return null;
	}	*/
}
