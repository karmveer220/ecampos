package org.cnl.digemin.DAO.impl;

import java.util.List;
import org.cnl.digemin.DAO.NotariaDAO;
import org.cnl.digemin.bean.BeanNotaria;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibNotariasDAO implements NotariaDAO{
   
    static SessionFactory sessionFactory = null;
    Session session = null;
    
    static{
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public HibNotariasDAO(){
        session = sessionFactory.getCurrentSession();
    }
    
   

    @SuppressWarnings("unchecked")
	public List<BeanNotaria> buscarnotarias(String nombre) throws Exception{
        Transaction tx = null;
        List<BeanNotaria> lista = null;
        try{
           tx = session.beginTransaction();
           lista = session.createQuery("from BeanNotaria as n where n.snombre like '%'||:nombre||'%'")
                          .setString("nombre",nombre)
                          .list();
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
    
    public Integer grabaNotaria(BeanNotaria notaria) throws Exception{
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(notaria);
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
        return 1;
    }

    public Integer modificaNotaria(BeanNotaria notaria) throws Exception{
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(notaria);
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
        return 1;
    }

    public BeanNotaria obtenerNotaria(String cod) throws Exception{
        Transaction tx = null;
        BeanNotaria not = null;
        try{
            tx = session.beginTransaction();
            not = (BeanNotaria) session.createQuery("from BeanNotaria as n where ncodigo = :codigo")
                                        .setString("codigo",cod)
                                        .uniqueResult();
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
        return not;
    }

    @SuppressWarnings("unchecked")
	public List<BeanNotaria> listadeNotarias() throws Exception{
         Transaction tx = null;
         List<BeanNotaria> lista = null;
         try{
            tx = session.beginTransaction();
            Query q = session.createQuery("from BeanNotaria as n");
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
    
    @SuppressWarnings("unchecked")
	public List<BeanNotaria> listaComboNotarias(Long colegio) throws Exception{
        Transaction tx = null;
        List<BeanNotaria> lista = null;
         try{
                tx = session.beginTransaction();
                System.out.println(" ************* ");
                System.out.println(colegio);
               lista = session.createQuery("from BeanNotaria as n where n.ncolegio = :codigo").setLong("codigo",colegio).list();
                tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
            if(tx!=null)tx.rollback();
            throw e;
        }catch(Exception e){
            e.printStackTrace();
            if(tx!=null)tx.rollback();
            throw e;
        }
        return lista;
    }

}