package pe.gob.pcm.constitucion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.pcm.constitucion.web.dao.InsertoDAO;
import pe.gob.pcm.constitucion.web.dao.TramiteDAO;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T029archivo;
import pe.gob.pcm.constitucion.web.model.T030inserto;
import pe.gob.pcm.constitucion.web.service.TramiteService;
import pe.gob.pcm.constitucion.web.util.Utiles;

@Service
public class TramiteServiceImpl implements TramiteService {

	@Autowired
	private TramiteDAO tramiteDAO;
	
	@Autowired
	private InsertoDAO insertoDAO;
	
	@Override
	@Transactional
	public void registrarTramite(T020tramite tramite) {
		tramiteDAO.registrarTramite(tramite);
		
		if(!Utiles.nullToBlank(tramite.getObjetoSocial()).equals("")){
			T030inserto inserto = new T030inserto();
			inserto.setDesInserto(tramite.getObjetoSocial());
			inserto.setT020tramite(tramite);
			insertoDAO.registraInserto(inserto);			
		}
		
	}

	@Override
	public void modificarTramite(T020tramite tramite) {
		tramiteDAO.modificarTramite(tramite);	
	}

	@Override
	public List<T020tramite> listarTramites(T020tramite tramite) {
		return tramiteDAO.listarTramites(tramite);
	}

	@Override
	public T020tramite obtenerTramite(String id) {
		return tramiteDAO.obtenerTramite(id);
	}

	@Override
	public void registrarArchivo(T029archivo archivo) {
		insertoDAO.registrarArchivo(archivo);
	}

	@Override
	public T029archivo obtenerArchivo(String idTramite, String tipo) {
		return insertoDAO.obtenerArchivo(idTramite,tipo);
	}

	@Override
	public void borrarParte(Integer numTramite, String tipo) {
		insertoDAO.borrarParte(numTramite,tipo);
	}

}
