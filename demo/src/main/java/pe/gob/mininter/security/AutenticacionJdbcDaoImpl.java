package pe.gob.mininter.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pe.gob.mininter.dao.UsuarioDao;


public class AutenticacionJdbcDaoImpl implements UserDetailsService {
	 
	private Logger logger = Logger.getLogger(AutenticacionJdbcDaoImpl.class);
		
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			logger.debug("debo entregar unusuariocolalista depermisos cargada");
			return usuarioDao.obtenerUsuarioPorUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("No hay notaria relacionada a este usuario");
		}
	}

	
}
