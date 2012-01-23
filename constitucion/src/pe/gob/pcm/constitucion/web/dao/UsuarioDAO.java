package pe.gob.pcm.constitucion.web.dao;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.Users;

public interface UsuarioDAO {

	public List<Users> listaUsuarios();
	public List<Users> listaUsuarios(Users usuario);
	public Users obtenerUsuarioPorUsername(String username);
	public Users obtenerUsuario(String username);
	public void registrarusuario(Users usuario);
	public void modificarusuario(Users usuario);
	public void modificarPermisos(Users usuario);

}
