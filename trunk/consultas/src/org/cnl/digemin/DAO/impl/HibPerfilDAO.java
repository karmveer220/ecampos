package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.cnl.digemin.DAO.PerfilDAO;
import org.cnl.digemin.bean.BeanPerfil;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Marzo 2010
 * @version 1.0
 */

public class HibPerfilDAO  extends HibernateDaoSupport implements PerfilDAO {

	public HibPerfilDAO(){}
	
	    
	@SuppressWarnings("unchecked")
	@Override
	public List<BeanPerfil> listaPerfiles() throws Exception{		 
		return getSession().createQuery("from BeanPerfil as n").list();
	}

}
