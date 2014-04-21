package pe.org.cnc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.cnc.dao.ParametroDAO;
import pe.org.cnc.model.Parametros;
import pe.org.cnc.service.ParametroService;

@Service
public class ParametroServiceImpl implements ParametroService {

	@Autowired
	private ParametroDAO parametroDAO;
	
	@Override
	public Parametros obtenerParametro(Integer id) {
		return parametroDAO.obtenerParametro(id);
	}

}
