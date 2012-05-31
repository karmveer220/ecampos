package pe.gob.mininter.dao;

import java.util.List;

import pe.gob.mininter.entities.SiminCorreo;


public interface UtilesDao {

	public void registrarCorreo(SiminCorreo correo);

	public List<SiminCorreo> listarCorreos(Integer codEmpleado);
	
}
