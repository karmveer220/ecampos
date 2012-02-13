package pe.gob.pcm.constitucion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.pcm.constitucion.web.dao.MandatarioDAO;
import pe.gob.pcm.constitucion.web.model.T032mandatario;
import pe.gob.pcm.constitucion.web.service.MandatarioService;

@Service
public class MandatarioServiceImpl implements MandatarioService {

	@Autowired
	private MandatarioDAO mandatarioDAO;
	
	@Override
	public List<T032mandatario> listarMandatarios(Integer idTramite) {
		return mandatarioDAO.listarMandatarios(idTramite);
	}

	@Override
	public T032mandatario obtenerMandatario(Integer idMandatario) {
		return mandatarioDAO.obtenerMandatario(idMandatario);
	}

	@Override
	public void registrarMandatario(T032mandatario mandatario) {
		mandatarioDAO.registrarMandatario(mandatario);
	}

	@Override
	public void eliminarMandatario(Integer mandatario) {
		mandatarioDAO.eliminarMandatario(mandatario);
	}

	@Override
	public void editarMandatario(T032mandatario mandatario) {
		mandatarioDAO.editarMandatario(mandatario);
	}

	@Override
	public void asignaCargoMandatario(Integer codman, String codCargo) {
		mandatarioDAO.asignaCargoMandatario(codman, codCargo);
	}

}
