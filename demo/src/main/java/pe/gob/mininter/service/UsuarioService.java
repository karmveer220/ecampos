package pe.gob.mininter.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import pe.gob.mininter.entities.Users;

public interface UsuarioService {

	public List<Users> listaUsuarios();

	public UserDetails loadUserByUsername(String username);
}
