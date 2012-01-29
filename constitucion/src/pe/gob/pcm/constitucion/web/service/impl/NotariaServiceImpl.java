package pe.gob.pcm.constitucion.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.pcm.constitucion.web.dao.NotariaDAO;
import pe.gob.pcm.constitucion.web.model.T021notaria;
import pe.gob.pcm.constitucion.web.service.NotariaService;

@Service
public class NotariaServiceImpl implements NotariaService{

	@Autowired
	private NotariaDAO notariaDAO;
	
	@Override
	public T021notaria obtenerNotaria(String codNotaria) {
		return notariaDAO.obtenerNotaria(codNotaria);
	}

}
