package pe.gob.mininter.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthoritiesUserDetailsServiceImpl implements UserDetailsService {
	
	private Logger logger = Logger.getLogger(AuthoritiesUserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return null;
	}
	
	
    
 

}
