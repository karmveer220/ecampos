package pe.org.cnc.service;

import pe.org.cnc.model.Usuario;

public interface UsuarioService {

	Usuario obtenerUsuario(String username);

	Usuario autenticarUsuario(String username, String clave) throws Exception;

}
