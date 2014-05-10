package pe.org.cnc.service;

import java.util.List;

import pe.org.cnc.model.Authority;
import pe.org.cnc.model.Permisos;
import pe.org.cnc.model.Usuario;

public interface UsuarioService {

	Usuario obtenerUsuario(String username);

	Usuario autenticarUsuario(String username, String clave) throws Exception;

	void registrarUsuario(Usuario usuario);
	void modificarClave(Usuario usuario);
	void eliminarUsuario(Integer idUsuario);
	Usuario obtenerUsuario(Integer idUsuario);
	public Usuario obtenerUsuarioPorUsername(String username);
	List<Usuario> listarUsuarios();
	void registrarPermiso(Authority a);
	@Deprecated
	Authority obtenerPerfilUsuario(String username);
	List<Usuario>  listarUsuarios(Usuario usuario);
	List<Permisos> listarPermisos();
	List<String> obtenerPermisos(String username);
	void registrarPermisos(Usuario usuario);
	
}
