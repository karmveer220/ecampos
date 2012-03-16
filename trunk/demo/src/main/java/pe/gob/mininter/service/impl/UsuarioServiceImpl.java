package pe.gob.mininter.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;

import pe.gob.mininter.entities.Users;
import pe.gob.mininter.service.UsuarioService;

public class UsuarioServiceImpl extends SimpleJdbcDaoSupport implements UsuarioService{

	
	private Logger logger = Logger.getLogger(UsuarioServiceImpl.class);

	@Autowired
	public UsuarioServiceImpl(DataSource dataSource){
		setDataSource(dataSource);
	}
	public UsuarioServiceImpl( ) { }
	
	@Override
	public List<Users> listaUsuarios() {
		return null;
	}
	@Override
	public UserDetails loadUserByUsername(String username) {
		return null;
	}

}
