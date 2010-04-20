package org.cnl.digemin.service;

import java.util.List;

import org.cnl.digemin.DAO.ColegioDAO;
import org.cnl.digemin.DAO.impl.HibColegioDAO;
import org.cnl.digemin.bean.BeanColegio;

public class ColegioService {

	ColegioDAO colegioDAO;
	
	public ColegioService(){
		colegioDAO = new HibColegioDAO();	
	}
	
	public List<BeanColegio> listaDeColegios()throws Exception{
		return colegioDAO.listaDeColegios();
	}
}
