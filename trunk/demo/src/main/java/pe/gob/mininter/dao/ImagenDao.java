package pe.gob.mininter.dao;

import java.util.List;

import pe.gob.mininter.entities.SiminImagen;


public interface ImagenDao {

	public List<SiminImagen> listarImagenes(Integer codPublicacion);
	
	public Integer insertaImagen(SiminImagen imagen);
	
	public SiminImagen obtenerImagen(String id);

	public SiminImagen listarImagenCodigo(String id);
	
}
