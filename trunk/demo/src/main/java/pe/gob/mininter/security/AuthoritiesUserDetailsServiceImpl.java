package pe.gob.mininter.security;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;


public class AuthoritiesUserDetailsServiceImpl extends JdbcDaoImpl implements UserDetailsService  {
	
	private Logger logger = Logger.getLogger(AutenticacionJdbcDaoImpl.class);
		
	public AuthoritiesUserDetailsServiceImpl(DataSource dataSource){
		setDataSource(dataSource);
	}
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = (User) loadUserByUsername(username);
		return user;
	}
	
	/*List<GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
	      List<GrantedAuthority> = ("select role from roles where username = ?",
	                                                   new String[] {username},
	                                                   new RowMapper<GrantedAuthority>() {
	        *//**
	         *  We're assuming here that you're using the standard convention of using the role
	         *  prefix "ROLE_" to mark attributes which are supported by Spring Security's RoleVoter.
	         *//*
	        public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
	          return new GrantedAuthorityImpl("ROLE_" + rs.getString(1);
	        }
	      }
	    }*/
	

}