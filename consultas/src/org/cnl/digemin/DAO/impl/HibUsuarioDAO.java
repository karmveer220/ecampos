package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.cnl.digemin.DAO.UsuarioDAO;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.service.impl.NotariaServiceImpl;
import org.cnl.digemin.utiles.Utiles;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */

public class HibUsuarioDAO extends HibernateDaoSupport implements UsuarioDAO{
    
	private static final Logger logger = Logger.getLogger(HibUsuarioDAO.class); 
    
	public HibUsuarioDAO(){}
	
    
    public BeanPersona validarPersona(String usuario, String clave) throws Exception{
        BeanPersona usrLogin = new BeanPersona();
       
        	logger.debug(" select user: "+usuario + "; password:"+clave);
        	System.out.println(" select user: "+usuario + "; password:"+clave);
            usrLogin = (BeanPersona)getSession().createQuery(" from BeanPersona as p where p.susuario = :usuario and p.sclave = :clave")
                          .setParameter("usuario",usuario)
                          .setParameter("clave",clave)
                          .uniqueResult();
            logger.debug(usrLogin);
            System.out.println(usrLogin);
            
            if(usrLogin == null) {
                throw new Exception("Usuario o clave incorrectos.");
            }
      
        return usrLogin;
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Integer nuevaPersona(BeanPersona persona) throws Exception{        
    	getSession().persist(persona);
    	return 1;
    }

    @SuppressWarnings("unchecked")
	public List<BeanPersona> listarUsuarios(Long codigo)throws Exception {
        List<BeanPersona> lsi = null;        
        if( codigo==null || codigo != NotariaServiceImpl.CODIGO_COLEGIO){
           lsi = getSession().createQuery("from BeanPersona as p where p.nnotaria.ncodigo = :codigo")
                  .setLong("codigo",codigo)
                  .list();
        }else{
            lsi = getSession().createQuery("from BeanPersona as p").list();
        }
        return lsi;
    }

    @SuppressWarnings("unchecked")
	public List<BeanPersona> buscarUsuarios(BeanPersona b) throws Exception{
       List<BeanPersona> lista ;       
       //try{  
    	   //tx = session.beginTransaction();
            Criteria crit = getSession().createCriteria(BeanPersona.class);
    		//crit.add(Restrictions.eq("estado","1"));
    		if(!Utiles.nullToBlank(b.getSusuario()).equals("")){
    			crit.add(Restrictions.like("susuario",b.getSusuario()));
    		}
    		if(!Utiles.nullToBlank(b.getSnombre()).equals("")){
    			crit.add(Restrictions.ilike("snombre",b.getSnombre()));
    		}
            if(!Utiles.nullToBlank(b.getSpaterno()).equals("")){
            	crit.add(Restrictions.ilike("spaterno",b.getSpaterno()));
            }
            if(!Utiles.nullToBlank(b.getSmaterno()).equals("")){
            	crit.add(Restrictions.ilike("smaterno",b.getSmaterno()));
            }
            if(!Utiles.nullToBlank(b.getSnum_doc()).equals("")){
            	crit.add(Restrictions.ilike("snum_doc",b.getSnum_doc()));
            }
            if(b.getNotaria()!=0 ){
            	crit.add(Restrictions.eq("nnotaria.ncodigo",b.getNotaria()));
            }
            if(b.getColegio()!=0 ){
            	crit.add(Restrictions.eq("ncolegio.ncodigo",b.getColegio()));
            }
    		lista = crit.list();
    		
        return lista;
    }
    
    public BeanPersona obtenerUsuarioById(Long codigo)throws Exception{
       BeanPersona usrLogin = new BeanPersona();      
        usrLogin = (BeanPersona)getSession().createQuery("select p from BeanPersona as p where p.ncodigo = :codigo ")
                                .setParameter("codigo",codigo)
                                .uniqueResult();
        if(usrLogin == null) {
            throw new Exception("Usuario no encontrado.");
        }
        return usrLogin;
    }
    
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Integer modificarPersona(BeanPersona p) throws Exception{
    	getSession().update(p); 
        return 1;
    }   
}