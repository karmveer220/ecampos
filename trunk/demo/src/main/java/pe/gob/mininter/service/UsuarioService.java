package pe.gob.mininter.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.entities.SiminUsuariosistema;
import pe.gob.mininter.entities.Users;

public interface UsuarioService {

	public List<Users> listaUsuarios();

	public UserDetails loadUserByUsername(String username);

	public List<SiminUsuariosistema> listarSistemas(String username);

	public List<SiminMaestro> listarCumpleaniosMes(String rptMensual);
	
	
}
