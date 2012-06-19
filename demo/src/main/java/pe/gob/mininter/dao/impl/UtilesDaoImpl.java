package pe.gob.mininter.dao.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dao.UtilesDao;
import pe.gob.mininter.entities.SiminCorreo;
import pe.gob.mininter.entities.SiminMaestro;
import pe.gob.mininter.utiles.Utiles;

@Repository
public class UtilesDaoImpl extends HibernateDaoSupport implements UtilesDao {

	@Autowired
	public UtilesDaoImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void registrarCorreo(SiminCorreo correo, SiminMaestro usuario) {
		Object codCorreo = getSession().createSQLQuery("select seq_co_mail_codigo.nextval+1 as sec from dual").uniqueResult();
		BigDecimal cod =  (BigDecimal) codCorreo;
		long codigo = usuario.getCperlCodigo();
		
		correo.setCoMailCodigo(cod.longValueExact());
		String nuevoCodigoGenerado = Utiles.completarCero(Integer.parseInt(codCorreo.toString()));
		nuevoCodigoGenerado = Utiles.autocompletar(nuevoCodigoGenerado)+"-"+new GregorianCalendar().get(Calendar.YEAR);
		correo.setCoMailGenerado(nuevoCodigoGenerado);
		
		getSession().createSQLQuery(" update simin_maestro set n_mst_email = :mail where c_perl_Codigo = :codigo ")
        .setString("mail", usuario.getNmstEmail())
        .setLong("codigo", codigo)
        .executeUpdate();
		
		this.getHibernateTemplate().save(correo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SiminCorreo> listarCorreos(Integer codEmpleado) {
		if (codEmpleado == 0) {
			Query q = getSession().createQuery("select co from SiminCorreo co, SiminMaestro m where co.siminMaestro.cperlCodigo = m.cperlCodigo order by co.coMailCodigo desc");
			List<SiminCorreo> listaCorreos = q.list();
			return listaCorreos;
		}else {
			return this.getHibernateTemplate().find("from SiminCorreo co where co.siminMaestro.cperlCodigo = "+codEmpleado+" order by coMailCodigo desc");
		}
	}

	@Override
	public void actualizarCorreo(Integer codCorreo, String estadoCorreo) {
		Query query = getSession().createQuery("update SiminCorreo set faMailEstado = :faMailEstado where coMailCodigo = :coMailCodigo")
				.setString("faMailEstado", estadoCorreo)
				.setInteger("coMailCodigo", codCorreo);
		query.executeUpdate();
	}
}
