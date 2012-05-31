package pe.gob.mininter.service;

import java.util.List;

import pe.gob.mininter.entities.SiminCorreo;

public interface UtilesService {

	public void registrarCorreo(SiminCorreo correo);
	
	public List<SiminCorreo> listarCorreos(Integer codEmpleado);
	
}
