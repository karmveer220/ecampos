package pe.gob.mininter.dao;

import org.springframework.security.core.userdetails.User;

public interface UsuarioDao {
	
	public User obtenerUsuarioPorUsername(String username);
	
}
