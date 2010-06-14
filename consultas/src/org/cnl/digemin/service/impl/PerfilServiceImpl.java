package org.cnl.digemin.service.impl;

import java.util.List;

import org.cnl.digemin.DAO.PerfilDAO;
import org.cnl.digemin.bean.BeanPerfil;
import org.cnl.digemin.service.PerfilService;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Marzo 2010
 * @version 1.0
 */

public class PerfilServiceImpl implements  PerfilService {
	
	private PerfilDAO perfilDAO;	
	public void setPerfilDAO(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}

	public PerfilServiceImpl(){
	}
	
	/* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.PerfilService#listaPErfiles()
	 */
	public List<BeanPerfil> listaPErfiles()throws Exception{
		return perfilDAO.listaPerfiles();		
	}
}
