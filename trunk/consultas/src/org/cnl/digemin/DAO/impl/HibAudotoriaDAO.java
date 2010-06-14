package org.cnl.digemin.DAO.impl;

import java.util.Date;

import org.cnl.digemin.DAO.AuditoriaDAO;
import org.cnl.digemin.bean.BeanAuditoria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC Convenio DIGEMIN - CNL
 * 
 * @author Elvis Ruben Campos Mori
 * @since MAYO 2009
 * @version 1.0
 */

public class HibAudotoriaDAO extends HibernateDaoSupport implements AuditoriaDAO {

	public HibAudotoriaDAO() {
		
	}
	

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void grabaAuditoria(BeanAuditoria auditoria) throws Exception {
		auditoria.setFechaRegistro(new Date());
		getSession().save(auditoria);
	}

}
