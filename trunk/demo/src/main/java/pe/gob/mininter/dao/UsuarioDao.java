package pe.gob.mininter.dao;

import pe.gob.mininter.entities.Users;

public interface UsuarioDao {
	
	public Users obtenerUsuarioPorUsername(String username);
	
}
