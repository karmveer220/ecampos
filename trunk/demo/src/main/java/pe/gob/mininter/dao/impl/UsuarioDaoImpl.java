package pe.gob.mininter.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dao.UsuarioDao;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.entities.SiminUnidadorganica;
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
	
		Query q = getSession().createQuery("select s from SiminMaestro s, SiminUnidadorganica o where s.siminUnidadorganica1.cUnoCodigo = o.cUnoCodigo " +
				" and  s.nmstLogin = :username ")
			.setString("username", username);
		SiminMaestro user = (SiminMaestro) q.uniqueResult();
		user.getSiminUnidadorganica1().getNunoDescripcion();
		logger.debug("ahora"+user.getSiminUnidadorganica1().getNunoDescripcion());

		
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
		
		SiminMaestro usuario= new SiminMaestro(user.getNmstLogin(), user.getNMstClave(), true, oo,user.getNMstNombre(), user.getNMstApepaterno(),user.getNMstApematerno(),user.getDMstFechanacimiento(), user.getCSitCodigo(), user.getSiminUnidadorganica1().getNunoDescripcion() );
		//usuario.setNMstNombre(user.getNMstNombre());
		
		logger.debug(usuario.toString());
		
		
        return usuario; 
		        
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SiminUsuariosistema> listarSistemas(String username) {
		return this.getSession().createQuery(" from SiminUsuariosistema s where s.siminMaestro.nmstLogin = :username and siminSistema.cSisCodigo <> 16  ")
				.setString("username", username)
				.list();
		
	}
	
		
	@Override
	public List<SiminMaestro> listarCumpleaniosMes() {
		Calendar hoy = new GregorianCalendar();
		logger.debug("================ rtaercumpleanosdelmes =============== "+ hoy.get(Calendar.DATE)+"/"+hoy.get(Calendar.MONTH));
		
		SQLQuery query = (SQLQuery) this.getSession().createSQLQuery(" select s.* from simin_maestro s " +
				"inner join simin_unidadorganica u on s.c_uno_codigo_of_destaque = u.c_uno_codigo " +
		 		" and to_char(s.d_mst_fechanacimiento, 'dd/MM')" +
		 		" like :fec  and s.c_sit_codigo=1 ") ;
		query.addEntity(SiminMaestro.class);
		query.setString("fec", (""+(hoy.get(Calendar.DATE)+"/0"+ (hoy.get(Calendar.MONTH)+1))));

		// hoy.get(Calendar.DATE)+"/0"+ (hoy.get(Calendar.MONTH)+1)

		logger.debug("as"+hoy.get(Calendar.MONTH)+1);
		 logger.debug("pinta algo"+query.getQueryString());
		 
		 List<SiminMaestro> lis =query.list();
		 
		 
		 /*SQLQuery query = (SQLQuery) this.getSession().createSQLQuery(" select s.* from simin_maestro s " +
					"inner join simin_unidadorganica u on s.c_uno_codigo_of_destaque = u.c_uno_codigo " +
			 		" and to_char(s.d_mst_fechanacimiento, 'dd')" +
			 		" like :fec  and s.c_sit_codigo=1 and substr(c_uno_codigointerno,0,3) like (select substr(ue.c_uno_codigointerno,0,3) from simin_unidadorganica ue where ue.c_uno_codigo = 67) ") ;*/
		 
		 /*List<SiminMaestro> lis = this.getSession().createQuery(" from SiminMaestro s, SiminUnidadOrganica u where s.siminUnidadorganica1.cUnoCodigo = u.cUnoCodigo " +
		 		" and to_char(s.dMstFechanacimiento, 'dd/MM')" +
		 		" like :fec  and s.cSitCodigo=1").setString("fec", hoy.get(Calendar.DATE)+"/0"+ (hoy.get(Calendar.MONTH)+1) )
				 .list();           	*/
		 
		 logger.debug(lis.size());
		 return lis;
	}

}
