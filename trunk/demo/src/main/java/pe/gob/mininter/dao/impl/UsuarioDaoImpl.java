package pe.gob.mininter.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dao.UsuarioDao;
import pe.gob.mininter.entities.SiminDirectorio;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.entities.SiminUnidadorganica;
import pe.gob.mininter.entities.SiminUsuariosistema;
import pe.gob.mininter.utiles.Parametros;
import pe.gob.mininter.utiles.Utiles;

@Repository
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao{
	
	@Autowired
	public UsuarioDaoImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public User obtenerUsuarioPorUsername(String username) {
		logger.debug("obtenr usuario  por username en la bd");
	
		Query q = getSession().createQuery("select s from SiminMaestro s, SiminUnidadorganica o where s.siminUnidadorganica1.cunoCodigo = o.cunoCodigo " +
				" and  s.nmstLogin = :username ")
			.setString("username", username);
		SiminMaestro user = (SiminMaestro) q.uniqueResult();
		user.getSiminUnidadorganica1().getNunoDescripcion();
		logger.debug("ahora"+user.getSiminUnidadorganica1().getNunoDescripcion());
		logger.debug("ahora"+user.getCtingCodigo());

		
		Query q2 =  getSession().createQuery("from SiminUsuariosistema u where u.siminMaestro.cperlCodigo  = :iduser and u.siminSistema.cSisCodigo = :idsis ")
	        .setInteger("iduser",new Long(user.getCperlCodigo()).intValue() )
	        .setInteger("idsis", Parametros.SISTEMA_INTRANET );
		
		List<SiminUsuariosistema> permisos = q2.list();
		logger.debug("permisos para esta persona = "+permisos.size());
		 
		List<GrantedAuthority> oo = new ArrayList<GrantedAuthority>(); 
		for(SiminUsuariosistema rol : permisos){
			oo.add(new GrantedAuthorityImpl("ROLE_" + rol.getSiminTipousuario().getCTusuDetalle() ) );
			logger.debug( "ROLE_" + rol.getSiminTipousuario().getCTusuDetalle()  );
		}
		
		SiminMaestro usuario= new SiminMaestro(user.getCperlCodigo(), user.getNmstLogin(), user.getNMstClave(), true, oo,user.getNMstNombre(), user.getNMstApepaterno(),user.getNMstApematerno(),user.getDmstFechanacimiento(), user.getCSitCodigo(), user.getSiminUnidadorganica1().getNunoDescripcion(), user.getCtingCodigo(), user.getSiminUnidadorganica1().getNunoGeneralAbrev(), user.getNmstEmail());
		//usuario.setNMstNombre(user.getNMstNombre());
		
		logger.debug(usuario.toString());
		logger.debug(usuario.getCtingCodigo());
		logger.debug("hola "+usuario.getCperlCodigo());
		logger.debug("hola "+usuario.getNmstEmail());
		
		
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
	@Transactional(propagation=Propagation.MANDATORY)
	public List<SiminMaestro> listarCumpleaniosMes(String rptMensual, String mes, String[] palabras) throws NumberFormatException, Exception {
		Calendar hoy = new GregorianCalendar();
		SQLQuery query = null ;
		
		String palabra = "";
		
		if(!Utiles.nullToBlank(palabras).equals("")){

			for(int i = 0; i<palabras.length; i++ ){
				String item = palabras[i];
				if(!item.trim().equals("de")){
					if(!item.trim().equals("las")){
						if(!item.trim().equals("la")){
							palabra = "and ( UPPER(n_mst_nombre) like UPPER('%"+item+"%') or UPPER(n_mst_apepaterno) like UPPER('%"+item+"%') or UPPER(n_mst_apematerno) like UPPER('%"+item+"%') )";
							logger.debug("actual = " + i + " < " +palabras.length);
						}
					}	
				}	 
			}  
		}
		
		String parametro = "";
		
		if (mes.equals("-1")) {
			parametro = "";
		}else {
			parametro = " and to_char(s.d_mst_fechanacimiento, 'MM') = :fec ";
		}
		
		if (rptMensual.equals("1")) {
			query = (SQLQuery) this.getSession().createSQLQuery(" select s.c_perl_codigo, s.n_mst_nombre , s.n_mst_apepaterno , s.n_mst_apematerno, " +
					"u.n_uno_descripcion, to_char(s.d_mst_fechanacimiento, 'dd/MM/yyyy') as d_mst_fechanacimiento, " +
					"g.n_gra_nombre, f.n_fun_abreviatura, s.c_ting_codigo, u.n_uno_general_abrev from simin_maestro s " +
					"inner join simin_unidadorganica u on s.c_uno_codigo_of_destaque = u.c_uno_codigo " +
					"left join simin_grado g on s.c_gra_codigo = g.c_gra_codigo " +
					"left join simin_funciones f on f.c_fun_codigo = s.c_fun_codigo " +
			 		"where s.c_sit_codigo=1 " +parametro+ " and d_mst_fechanacimiento is not null "+
			 		"and u.c_ue_codigo = 1 " + palabra+ " order by d_mst_fechanacimiento") ;
		}else {
			query = (SQLQuery) this.getSession().createSQLQuery(" select s.c_perl_codigo, s.n_mst_nombre , s.n_mst_apepaterno , s.n_mst_apematerno, " +
					"u.n_uno_descripcion, to_char(s.d_mst_fechanacimiento, 'dd/MM/yyyy') as d_mst_fechanacimiento, " +
					"g.n_gra_nombre, f.n_fun_abreviatura, s.c_ting_codigo, u.n_uno_general_abrev from simin_maestro s " +
					"inner join simin_unidadorganica u on s.c_uno_codigo_of_destaque = u.c_uno_codigo " +
					"left join simin_grado g on s.c_gra_codigo = g.c_gra_codigo " +
					"left join simin_funciones f on f.c_fun_codigo = s.c_fun_codigo " +
			 		"where to_char(s.d_mst_fechanacimiento, 'dd/MM')" +
			 		" = :fec  and s.c_sit_codigo=1  and u.c_ue_codigo = 1 ") ;
		}

		if (rptMensual.equals("1")) {
			if (mes.equals("")) {
				query.setString("fec", (Utiles.completarCero((hoy.get(Calendar.MONTH)+1))));
				
			}else {
				if (mes.equals("-1")) {
					logger.debug("hola");
				}else {
					query.setString("fec", (Utiles.completarCero(Integer.parseInt(mes))));
				}
								
			}
		}else {
			query.setString("fec", (""+(Utiles.completarCero(hoy.get(Calendar.DATE))+"/"+ Utiles.completarCero((hoy.get(Calendar.MONTH)+1)))));
		}

		List<SiminMaestro> lis = new ArrayList<SiminMaestro>();
		
		List<Object[]> oj = query.list();
		for(Object[] o : oj){
			lis.add(
					new SiminMaestro(
						new Long(o[0].toString()),
						Utiles.nullToBlank(o[1]),
						Utiles.nullToBlank(o[2]),
						Utiles.nullToBlank(o[3]),
						Utiles.nullToBlank(o[4]),
						Utiles.stringToDate(o[5].toString(), Utiles.FORMATO_FECHA_CORTA),
						Utiles.nullToBlank(o[6]),
						Utiles.nullToBlank(o[7]),
						Utiles.nullToBlank(o[8]),
						Utiles.nullToBlank(o[9])
						)
					);
		}

		logger.debug(lis.size());
		return lis;
	}

	@Override
	public List<SiminDirectorio> listarDirectorioTelf(String dependencia, String telefono, String anexo) throws NumberFormatException,Exception {
		Query q = getSession().createQuery("select d from SiminDirectorio d, SiminUnidadorganica o where d.siminUnidadorganica.cunoCodigo = o.cunoCodigo" +
					" and upper(d.ndirDescripcion) like upper('"+dependencia+"%')");
		
		List<SiminDirectorio> listaDirec = q.list();
		return listaDirec;
	}

	@Override
	public List<SiminUnidadorganica> listarUnidadOrganica() {
		SQLQuery q = getSession().createSQLQuery("select distinct(N_UNO_GENERAL_ABREV) from SIMIN_UNIDADORGANICA  order by N_UNO_GENERAL_ABREV asc"   );		
		List<SiminUnidadorganica> lista = new ArrayList<SiminUnidadorganica>();
		List<Object> listaUnidadOrg = q.list();
		for(Object o: listaUnidadOrg){		
			lista.add(new SiminUnidadorganica(  o+""  ));
		}		
		System.out.println("dsfds" + lista.size());
		return lista;
	}

}
