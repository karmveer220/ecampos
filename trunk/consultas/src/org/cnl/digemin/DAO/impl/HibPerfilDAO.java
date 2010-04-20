package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.cnl.digemin.DAO.PerfilDAO;
import org.cnl.digemin.bean.BeanPerfil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Marzo 2010
 * @version 1.0
 */
public class HibPerfilDAO implements PerfilDAO {

	  static SessionFactory sessionFactory = null;
	    Session session = null;
	    
	    static{
	        sessionFactory = new Configuration().configure().buildSessionFactory();
	    }
	    
	    public HibPerfilDAO(){
	        session = sessionFactory.getCurrentSession();
	    }
	    
	@SuppressWarnings("unchecked")
	@Override
	public List<BeanPerfil> listaPErfiles() throws Exception{		 
        List<BeanPerfil> lista = null;
        try{	           
           lista = session.createQuery("from BeanPerfil as n").list();	         
       }catch(HibernateException e){
           e.printStackTrace();
           throw e;
       }catch(Exception e){
           e.printStackTrace();
           throw e;
       }
        return lista;
	}

}
