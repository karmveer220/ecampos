package org.cnl.digemin.DAO.impl;

import java.util.Date;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since MAYO 2009
 * @version 1.0
 */
public class HibAudotoriaDAO implements AuditoriaDAO{
   
    public HibAudotoriaDAO(){
      
    }
    
    public void grabaAuditoria(BeanAuditoria auditoria) throws Exception{
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            ///auditoria.setFechaRegistro(Utiles.CalendarToString(new GregorianCalendar(), Utiles.FORMATO_FECHA_CORTA_MYSQL));
            auditoria.setFechaRegistro(new Date());
            session.save(auditoria);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally{
            session.close();
        }        
    }

}
