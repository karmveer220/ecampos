package pe.gob.mininter.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.entities.SiminUsuariosistema;
import pe.gob.mininter.entities.Users;

@Repository
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao{
	
	@Autowired
	public UsuarioDaoImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public Users obtenerUsuarioPorUsername(String username) {
		logger.debug("obtenr usuario  por username en la bd");
	
		Query q = getSession().createQuery("from SiminMaestro s where  s.nMstLogin = :username ")
        .setString("username", username);
		SiminMaestro user = (SiminMaestro) q.uniqueResult();
		logger.debug(user);
		
		Query q2 =  getSession().createQuery("from SiminUsuariosistema u where u.siminMaestro.cPerlCodigo  = :iduser ")
	        .setInteger("iduser",new Long(user.getCPerlCodigo()).intValue() );
		
		 List<SiminUsuariosistema> permisos = q2.list();
		 logger.debug("permisos para esta persona = "+permisos.size());
		 
		 List<GrantedAuthority> oo = new ArrayList<GrantedAuthority>(); 
		 for(SiminUsuariosistema rol : permisos){
			 oo.add(new GrantedAuthorityImpl("ROLE_" + rol.getSiminTipousuario().getCTusuDetalle() ) );
			 logger.debug( "ROLE_" + rol.getSiminTipousuario().getCTusuDetalle()  );
		 }
			
		
		 Users usuario= new Users(user.getNMstLogin(), user.getNMstClave(), true, oo);
		
        return usuario; 
		        
	}

}
