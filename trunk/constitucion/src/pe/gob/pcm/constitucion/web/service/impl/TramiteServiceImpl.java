package pe.gob.pcm.constitucion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.pcm.constitucion.web.dao.TramiteDAO;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.service.TramiteService;

@Service
public class TramiteServiceImpl implements TramiteService {

	@Autowired
	TramiteDAO tramiteDAO;
	
	@Override
	public void registrarTramite(T020tramite tramite) {
		tramiteDAO.registrarTramite(tramite);		
	}

	@Override
	public void modificarTramite(T020tramite tramite) {
		tramiteDAO.modificarTramite(tramite);	
	}

	@Override
	public List<T020tramite> listarTramites(T020tramite tramite) {
		return tramiteDAO.listarTramites(tramite);
	}

}
