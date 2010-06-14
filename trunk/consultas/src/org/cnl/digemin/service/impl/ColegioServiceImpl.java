package org.cnl.digemin.service.impl;

import java.util.List;

import org.cnl.digemin.DAO.ColegioDAO;
import org.cnl.digemin.bean.BeanColegio;
import org.cnl.digemin.service.ColegioService;

public class ColegioServiceImpl implements ColegioService {
	
	private ColegioDAO colegioDAO;
	
	public void setColegioDAO(ColegioDAO colegioDAO) {
		this.colegioDAO = colegioDAO;
	}

	public ColegioServiceImpl(){
			
	}
	
	/* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.ColegioService#listaDeColegios()
	 */
	public List<BeanColegio> listaDeColegios()throws Exception{
		return colegioDAO.listaDeColegios();
	}
}
