package pe.gob.mininter.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dao.UsuarioDao;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.entities.SiminUsuariosistema;
import pe.gob.mininter.entities.Users;
import pe.gob.mininter.utiles.Parametros;

@Repository
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao{
	
	@Autowired
	public UsuarioDaoImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public User obtenerUsuarioPorUsername(String username) {
		logger.debug("obtenr usuario  por username en la bd");
	
		Query q = getSession().createQuery("from SiminMaestro s where  s.nMstLogin = :username ")
        .setString("username", username);
		SiminMaestro user = (SiminMaestro) q.uniqueResult();
		logger.debug("Usuario en BD = "+user);
		
		Query q2 =  getSession().createQuery("from SiminUsuariosistema u where u.siminMaestro.cPerlCodigo  = :iduser and u.siminSistema.cSisCodigo = :idsis ")
	        .setInteger("iduser",new Long(user.getCPerlCodigo()).intValue() )
	        .setInteger("idsis", Parametros.SISTEMA_INTRANET );
		
		 List<SiminUsuariosistema> permisos = q2.list();
		 logger.debug("permisos para esta persona = "+permisos.size());
		 
		 List<GrantedAuthority> oo = new ArrayList<GrantedAuthority>(); 
		 for(SiminUsuariosistema rol : permisos){
			 oo.add(new GrantedAuthorityImpl("ROLE_" + rol.getSiminTipousuario().getCTusuDetalle() ) );
			 logger.debug( "ROLE_" + rol.getSiminTipousuario().getCTusuDetalle()  );
		 }
		
		 SiminMaestro usuario= new SiminMaestro(user.getNMstLogin(), user.getNMstClave(), true, oo,user.getNMstNombre(), user.getNMstApepaterno(),user.getNMstApematerno(),user.getDMstFechanacimiento(), user.getCSitCodigo() );
		
        return usuario; 
		        
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SiminUsuariosistema> listarSistemas(String username) {
		return this.getSession().createQuery(" from SiminUsuariosistema s where s.siminMaestro.nMstLogin = :username")
				.setString("username", username)
				.list();
	}

	@Override
	public List<SiminMaestro> listarCumpleaniosMes() {
		Calendar hoy = new GregorianCalendar();
		logger.debug("================ rtaercumpleanosdelmes =============== "+ hoy.get(Calendar.DATE)+"/"+hoy.get(Calendar.MONTH));
		 List<SiminMaestro> lis = this.getSession().createQuery(" from SiminMaestro s where to_char(s.dMstFechanacimiento, 'dd/MM') like :fec  and s.cSitCodigo=1")
				.setString("fec", hoy.get(Calendar.DATE)+"/0"+ (hoy.get(Calendar.MONTH)+1) )
				.list();		 
		 logger.debug(lis);
		 return lis;
	}

}
