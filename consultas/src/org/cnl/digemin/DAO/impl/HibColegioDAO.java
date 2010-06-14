package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.cnl.digemin.DAO.ColegioDAO;
import org.cnl.digemin.bean.BeanColegio;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class HibColegioDAO extends HibernateDaoSupport implements ColegioDAO {
	
    public HibColegioDAO(){}
    
  	@SuppressWarnings("unchecked")
	@Override
	public List<BeanColegio> listaDeColegios() throws Exception {
        return  getSession().createQuery("from BeanColegio as c").list();
	}

}
