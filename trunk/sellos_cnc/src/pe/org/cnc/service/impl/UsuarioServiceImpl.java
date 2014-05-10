package pe.org.cnc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.cnc.dao.UsuarioDAO;
import pe.org.cnc.model.Authority;
import pe.org.cnc.model.Permisos;
import pe.org.cnc.model.Usuario;
import pe.org.cnc.service.UsuarioService;
import pe.org.cnc.util.Utiles;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario obtenerUsuario(String username) {
		return usuarioDAO.obtenerUsuarioPorUsername(username);
	}

	@Override
	public Usuario autenticarUsuario(String username, String clave) throws Exception {
		Usuario usr = usuarioDAO.obtenerUsuarioPorUsername(username);
		if( usr== null ){
			throw new Exception("Usuario no registrado en la base de datos");
		}
		if( !usr.getClave().equals( clave )){
			throw new Exception("La clave no corresponde.");
		}
		return usr;
	}
	
	
	@Override
	public void registrarUsuario(Usuario usuario) {
	/*	if( !Utiles.nullToBlank( usuario.getClave() ).equals("")){
			usuario.setClave( Utiles.hashMd5( usuario.getClave() ) );	
		}else{*/
		//	logger.debug("ID USUARIO = " + usuario.getIdUsuario());
			if( usuario.getIdUsuario() > 0 ){ /* modificar al usuario*/
				Usuario us = obtenerUsuario( usuario.getIdUsuario() );
				usuario.setClave( us.getClave() );
				us=null;
			}else{
				usuario.setClaveNueva(  Utiles.generarClave( 6 ) );
				usuario.setClave( Utiles.hashMd5(usuario.getClaveNueva() ) );	
			}
		//}
		usuarioDAO.registrarUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(Integer idUsuario) {
		usuarioDAO.eliminarUsuario(idUsuario);
	}

	@Override
	public Usuario obtenerUsuario(Integer idUsuario) {
		return usuarioDAO.obtenerUsuario(idUsuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDAO.listarUsuarios();
	}

	@Override
	public Usuario obtenerUsuarioPorUsername(String username) {
		return usuarioDAO.obtenerUsuarioPorUsername(username);
	}

	@Override
	public void registrarPermiso(Authority a) {
		usuarioDAO.registrarPermiso(a);
	}

	@Override
	@Deprecated
	public Authority obtenerPerfilUsuario(String username) {
		return usuarioDAO.obtenerPerfilUsuario(username);
	}

	@Override
	public List<Usuario> listarUsuarios(Usuario usuario) {
		return usuarioDAO.listarUsuarios(usuario);
	}

	@Override
	public List<Permisos> listarPermisos() {
		return this.usuarioDAO.listarPermisos();
	}

	@Override
	public List<String> obtenerPermisos(String username) {
		return  this.usuarioDAO.obtenerPermisos(username);
	}

	@Override
	public void registrarPermisos(Usuario usuario) {
		this.usuarioDAO.registrarPermisos(usuario);
	}

	@Override
	public void modificarClave(Usuario usuario) {
		usuario.setClave( Utiles.hashMd5( usuario.getClave() ));
		usuarioDAO.registrarUsuario(usuario);		
	}

	
}
