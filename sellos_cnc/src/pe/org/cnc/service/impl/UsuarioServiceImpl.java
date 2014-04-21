package pe.org.cnc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.cnc.dao.UsuarioDAO;
import pe.org.cnc.model.Usuario;
import pe.org.cnc.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario obtenerUsuario(String username) {
		return usuarioDAO.obtenerUsuario(username);
	}

	@Override
	public Usuario autenticarUsuario(String username, String clave) throws Exception {
		Usuario usr = usuarioDAO.obtenerUsuario(username);
		if( usr== null ){
			throw new Exception("Usuario no registrado en la base de datos");
		}
		if( !usr.getClave().equals( clave )){
			throw new Exception("La clave no corresponde.");
		}
		return usr;
	}
}
