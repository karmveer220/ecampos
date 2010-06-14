package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.cnl.digemin.DAO.NotariaDAO;
import org.cnl.digemin.bean.BeanNotaria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class HibNotariasDAO extends HibernateDaoSupport implements NotariaDAO{
   
    public HibNotariasDAO(){}
  
    @SuppressWarnings("unchecked")
	public List<BeanNotaria> buscarnotarias(String nombre) throws Exception{
           return getSession().createQuery("from BeanNotaria as n where n.snombre like '%'||:nombre||'%'")
                  .setString("nombre",nombre)
                  .list();
    }
    
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Integer grabaNotaria(BeanNotaria notaria) throws Exception{
          getSession().save(notaria);
          return 1;
    }
    
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Integer modificaNotaria(BeanNotaria notaria) throws Exception{
        getSession().update(notaria);
        return 1;
    }

    public BeanNotaria obtenerNotaria(String cod) throws Exception{
       return  (BeanNotaria) getSession().createQuery("from BeanNotaria as n where ncodigo = :codigo")
                             .setString("codigo",cod)
                             .uniqueResult();
    }

    @SuppressWarnings("unchecked")
	public List<BeanNotaria> listadeNotarias() throws Exception{
         return  getSession().createQuery("from BeanNotaria as n").list();          
    }
    
    @SuppressWarnings("unchecked")
	public List<BeanNotaria> listaComboNotarias(Long colegio) throws Exception{
       System.out.println(" ************* ");
       System.out.println(colegio);
       return getSession().createQuery("from BeanNotaria as n where n.ncolegio = :codigo").setLong("codigo",colegio).list();               
    }

}