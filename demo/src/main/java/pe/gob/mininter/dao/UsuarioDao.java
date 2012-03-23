package pe.gob.mininter.dao;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.entities.SiminUsuariosistema;

public interface UsuarioDao {
	
	public User obtenerUsuarioPorUsername(String username);

	public List<SiminUsuariosistema> listarSistemas(String username);

	public List<SiminMaestro> listarCumpleaniosMes();
	
}
