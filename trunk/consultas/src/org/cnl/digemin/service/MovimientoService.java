package org.cnl.digemin.service;

import gob.min.digemin.ejb.Simmovmigra1;

import java.util.List;

import org.cnl.digemin.bean.BeanAuditoria;

public interface MovimientoService {

	public abstract List<Simmovmigra1> listaDeMovimientosNumeroDocumento(
			String nroCarnetE, BeanAuditoria auditoria, String idSession)
			throws Exception;

}