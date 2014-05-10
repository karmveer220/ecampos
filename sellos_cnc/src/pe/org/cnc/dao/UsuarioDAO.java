package pe.org.cnc.dao;

import java.util.List;

import pe.org.cnc.model.Authority;
import pe.org.cnc.model.Permisos;
import pe.org.cnc.model.Usuario;

public interface UsuarioDAO {

	void registrarUsuario(Usuario usuario);
	void eliminarUsuario(Integer idUsuario);
	public Usuario obtenerUsuarioPorUsername(String username);
	Usuario obtenerUsuario(Integer idUsuario);
	List<Usuario> listarUsuarios();
	void registrarPermiso(Authority a);
	@Deprecated
	Authority obtenerPerfilUsuario(String username);
	List<Usuario> listarUsuarios(Usuario usuario);
	List<Permisos> listarPermisos();
	List<String> obtenerPermisos(String username);
	void registrarPermisos(Usuario usuario);
	
}
