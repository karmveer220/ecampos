package pe.org.cnc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.cnc.dao.NotarioDAO;
import pe.org.cnc.model.Notario;
import pe.org.cnc.service.NotarioService;

@Service
public class NotarioServiceImpl implements NotarioService {

	@Autowired
	private NotarioDAO notarioDAO;
	
	@Override
	public void registrarNotario(Notario notario) {
		this.notarioDAO.registrarNotario(notario);
	}

	@Override
	public Notario obtenerNotario(Integer idNotario) {
		return this.notarioDAO.obtenerNotario(idNotario);
	}

	@Override
	public void eliminarNotario(Integer idNotario) {
		this.notarioDAO.eliminarNotario(idNotario);
	}

	@Override
	public List<Notario> buscarNotario(Notario notario) {
		return this.notarioDAO.buscarNotario(notario);
	}

	@Override
	public Notario validaTexto(String texto) {
		return notarioDAO.validaTexto(texto);
	}

}