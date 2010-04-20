package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.cnl.digemin.DAO.ColegioDAO;
import org.cnl.digemin.bean.BeanColegio;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibColegioDAO implements ColegioDAO {
	
	static SessionFactory sessionFactory = null;
    Session session = null;
    
    static{
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public HibColegioDAO(){
        session = sessionFactory.getCurrentSession();
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<BeanColegio> listaDeColegios() throws Exception {
		Transaction tx = null;
        List<BeanColegio> lista = null;
        try{
           tx = session.beginTransaction();
           Query q = session.createQuery("from BeanColegio as c");
           lista = q.list();
           tx.commit();
       }catch(HibernateException e){
           e.printStackTrace();
           tx.rollback();
           throw e;
       }catch(Exception e){
           e.printStackTrace();
           tx.rollback();
           throw e;
       }
       return lista;
	}

}
