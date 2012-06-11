package pe.gob.mininter.dao;

import java.util.List;

import pe.gob.mininter.entities.SiminCorreo;
import pe.gob.mininter.entities.SiminMaestro;


public interface UtilesDao {

	public void registrarCorreo(SiminCorreo correo, SiminMaestro usuario);

	public List<SiminCorreo> listarCorreos(Integer codEmpleado);

	public void actualizarCorreo(Integer codCorreo, String estadoCorreo);
	
}
