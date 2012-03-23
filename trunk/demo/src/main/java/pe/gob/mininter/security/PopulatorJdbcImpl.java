package pe.gob.mininter.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

public class PopulatorJdbcImpl implements LdapAuthoritiesPopulator{

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userdata, String username) {
		
		List<GrantedAuthority> oo = new ArrayList<GrantedAuthority>(); 
		oo.add(new GrantedAuthorityImpl("IS_AUTHENTICATED_ANONYMOUSLY") );
		return oo;
		//logger.debug(ud.getAuthorities());
		//return ud.getAuthorities();
	//	return null;
	}
	
}
