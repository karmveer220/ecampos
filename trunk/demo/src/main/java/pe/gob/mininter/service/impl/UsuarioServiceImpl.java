package pe.gob.mininter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dao.UsuarioDao;
import pe.gob.mininter.entities.SiminDirectorio;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.entities.SiminUnidadorganica;
import pe.gob.mininter.entities.SiminUsuariosistema;
import pe.gob.mininter.entities.Users;
import pe.gob.mininter.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	

	@Autowired
	private UsuarioDao usuarioDao;
	
	public UsuarioServiceImpl( ) { }
	
	@Override
	public List<Users> listaUsuarios() {
		return null;
	}
	@Override
	public UserDetails loadUserByUsername(String username) {
		return usuarioDao.obtenerUsuarioPorUsername(username);
	}
	
	@Override
	public List<SiminUsuariosistema> listarSistemas(String username) {
		return usuarioDao.listarSistemas(username);
	}

	@Override
	public List<SiminMaestro> listarCumpleaniosMes(String rptMensual, String mes) throws NumberFormatException, Exception {
		return usuarioDao.listarCumpleaniosMes(rptMensual, mes);
	}

	@Override
	public List<SiminDirectorio> listarDirectorioTelf(String dependencia, String telefono, String anexo) throws NumberFormatException, Exception {
		return usuarioDao.listarDirectorioTelf(dependencia, telefono, anexo);
	}

	@Override
	public List<SiminUnidadorganica> listarUnidadOrganica() {
		return usuarioDao.listarUnidadOrganica();
	}

}
