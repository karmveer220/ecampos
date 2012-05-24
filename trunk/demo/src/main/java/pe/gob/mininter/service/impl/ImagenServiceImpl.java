package pe.gob.mininter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dao.ImagenDao;
import pe.gob.mininter.entities.SiminImagen;
import pe.gob.mininter.service.ImagenService;

@Service
public class ImagenServiceImpl implements ImagenService{
	

	@Autowired
	private ImagenDao imagenDao;
	
	public ImagenServiceImpl( ) { }

	@Override
	public List<SiminImagen> listarImagenes(Integer codPublicacion) {
		return imagenDao.listarImagenes(codPublicacion);
	}

	@Override
	public Integer insertaImagen(SiminImagen imagen) {
		return imagenDao.insertaImagen(imagen);		
	}

	@Override
	public SiminImagen obtenerImagen(String id) {		
		return imagenDao.obtenerImagen(id);
	}

	@Override
	public SiminImagen listarImagenCodigo(String id) {
		return imagenDao.listarImagenCodigo(id);
	}	

}
