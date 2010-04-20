package org.cnl.digemin.DAO;

import java.util.List;

import org.cnl.digemin.bean.BeanColegio;

public interface ColegioDAO {
	
	public List<BeanColegio> listaDeColegios()throws Exception;
	
}
