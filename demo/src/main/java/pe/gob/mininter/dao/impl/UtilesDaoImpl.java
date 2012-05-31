package pe.gob.mininter.dao.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dao.UtilesDao;
import pe.gob.mininter.entities.SiminCorreo;
import pe.gob.mininter.utiles.Utiles;

@Repository
public class UtilesDaoImpl extends HibernateDaoSupport implements UtilesDao {

	@Autowired
	public UtilesDaoImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void registrarCorreo(SiminCorreo correo) {
		Object codCorreo = getSession().createSQLQuery("select seq_co_mail_codigo.nextval+1 as sec from dual").uniqueResult();
		BigDecimal cod =  (BigDecimal) codCorreo;
		
		correo.setCoMailCodigo(cod.longValueExact());
		String nuevoCodigoGenerado = Utiles.completarCero(Integer.parseInt(codCorreo.toString()));
		nuevoCodigoGenerado = Utiles.autocompletar(nuevoCodigoGenerado)+""+new GregorianCalendar().get(Calendar.YEAR);
		correo.setCoMailGenerado(nuevoCodigoGenerado);
		this.getHibernateTemplate().save(correo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SiminCorreo> listarCorreos(Integer codEmpleado) {
		return this.getHibernateTemplate().find("from SiminCorreo co where co.siminMaestro.cperlCodigo = "+codEmpleado+" order by coMailCodigo asc");
		
	}

}
