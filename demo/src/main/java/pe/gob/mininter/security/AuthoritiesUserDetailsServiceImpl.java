package pe.gob.mininter.security;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthoritiesUserDetailsServiceImpl implements AuthenticationProvider  {
	
	private Logger logger = Logger.getLogger(AutenticacionJdbcDaoImpl.class);
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();	  
		String password = authentication.getCredentials().toString();
		logger.debug(username);
		logger.debug(password);
		return null;
	}

	@Override
	public boolean supports(Class<?> class1) {
		return true;
	}
}