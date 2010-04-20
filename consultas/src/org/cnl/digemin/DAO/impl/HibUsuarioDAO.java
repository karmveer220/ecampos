package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.cnl.digemin.DAO.UsuarioDAO;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.service.NotariaService;
import org.cnl.digemin.utiles.Utiles;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class HibUsuarioDAO implements UsuarioDAO{
    
	private static final Logger logger = Logger.getLogger(HibUsuarioDAO.class); 
    static SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    
    static{
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public HibUsuarioDAO(){
        session = sessionFactory.getCurrentSession();
    }   
    
    public BeanPersona validarPersona(String usuario, String clave) throws Exception{
        BeanPersona usrLogin = new BeanPersona();
        try{
        	tx = session.beginTransaction();
        	logger.debug(" select user: "+usuario + "; password:"+clave);
        	System.out.println(" select user: "+usuario + "; password:"+clave);
            usrLogin = (BeanPersona)session.createQuery(" from BeanPersona as p where p.susuario = :usuario and p.sclave = :clave")
                          .setParameter("usuario",usuario)
                          .setParameter("clave",clave)
                          .uniqueResult();
            logger.debug(usrLogin);
            System.out.println(usrLogin);
            tx.commit();
            if(usrLogin == null) {
                throw new Exception("Usuario o clave incorrectos.");
            }
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
            throw e;
        }
        return usrLogin;
    }

    public Integer nuevaPersona(BeanPersona persona) throws Exception{        
       
        try{
           tx = session.beginTransaction();
            session.save(persona);
            tx.commit();
       }catch (HibernateException e) { 
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

    @SuppressWarnings("unchecked")
	public List<BeanPersona> listarUsuarios(Long codigo)throws Exception {
        List<BeanPersona> lsi = null;
        try{
        	 tx = session.beginTransaction();
                if( codigo==null || codigo != NotariaService.CODIGO_COLEGIO){
                   lsi = session.createQuery("from BeanPersona as p where p.notaria = :codigo")
                          .setLong("codigo",codigo)
                          .list();
                }else{
                    lsi = session.createQuery("from BeanPersona as p").list();
                }
               tx.commit();
        }catch (HibernateException e) { 
            e.printStackTrace();
            tx.rollback();
            throw e;
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
            throw e;
        }
        return lsi;
    }

    @SuppressWarnings("unchecked")
	public List<BeanPersona> buscarUsuarios(BeanPersona b) throws Exception{
       List<BeanPersona> lista ;       
       try{  
    	   tx = session.beginTransaction();
            Criteria crit = session.createCriteria(BeanPersona.class);
    		crit.add(Restrictions.eq("estado","1"));
    		if(!Utiles.nullToBlank(b.getSusuario()).equals("")){
    			crit.add(Restrictions.like("susuario",b.getSusuario()));
    		}
    		if(!Utiles.nullToBlank(b.getSnombre()).equals("")){
    			crit.add(Restrictions.like("snombre",b.getSnombre()));
    		}
            if(!Utiles.nullToBlank(b.getSpaterno()).equals("")){
            	crit.add(Restrictions.like("spaterno",b.getSpaterno()));
            }
            if(!Utiles.nullToBlank(b.getSmaterno()).equals("")){
            	crit.add(Restrictions.like("smaterno",b.getSmaterno()));
            }
            if(!Utiles.nullToBlank(b.getSnum_doc()).equals("")){
            	crit.add(Restrictions.like("snum_doc",b.getSnum_doc()));
            }
            if(b.getNotaria()!=null ){
            	crit.add(Restrictions.like("notaria",b.getNotaria()));
            }
            if(b.getColegio()!=null ){
            	crit.add(Restrictions.like("colegio",b.getColegio()));
            }
    		lista = crit.list();
    		tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
            throw e;
        }
        return lista;
    }
    
    public BeanPersona obtenerUsuarioById(Long codigo)throws Exception{
       BeanPersona usrLogin = new BeanPersona();
       Transaction tx = null;
        try{
            tx = session.beginTransaction();
            usrLogin = (BeanPersona)session.createQuery("select p from BeanPersona as p where p.ncodigo = :codigo ")
                                    .setParameter("codigo",codigo)
                                    .uniqueResult();
            if(usrLogin == null) {
                throw new Exception("Usuario no encontrado.");
            }
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
            throw e;
        }
        return usrLogin;
    }

    public Integer modificarPersona(BeanPersona p) throws Exception{
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(p);
            tx.commit();
        }catch (HibernateException e) { 
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
    
   
}
