package org.cnl.digemin.service;

import java.util.List;

import org.cnl.digemin.DAO.PerfilDAO;
import org.cnl.digemin.DAO.impl.HibPerfilDAO;
import org.cnl.digemin.bean.BeanPerfil;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Marzo 2010
 * @version 1.0
 */
public class PerfilService {

	private PerfilDAO perfilDAO;
	
	public PerfilService(){
		this.perfilDAO = new HibPerfilDAO();
	}
	
	public List<BeanPerfil> listaPErfiles()throws Exception{
		return perfilDAO.listaPErfiles();		
	}
}
