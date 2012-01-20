package pe.org.notarios.web.dao;

import java.util.List;

import pe.org.notarios.web.model.Imagenes;

public interface ImagenDAO {

	public List<Imagenes> listarImagenes();
	public void insertaImagen(Imagenes imagen);
	public Imagenes obtenerImagen(String id);
	
	
}
