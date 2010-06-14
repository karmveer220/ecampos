package org.cnl.digemin.DAO;

import java.util.List;

import org.cnl.digemin.bean.BeanPerfil;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Marzo 2010
 * @version 1.0
 */
public interface PerfilDAO {

	public List<BeanPerfil> listaPerfiles()throws Exception;
	
}
