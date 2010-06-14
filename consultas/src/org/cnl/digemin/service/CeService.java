package org.cnl.digemin.service;

import gob.min.digemin.ejb.Simcarnetextranjeria1;

import java.util.List;

import org.cnl.digemin.bean.BeanAuditoria;

public interface CeService {

	public abstract List<Simcarnetextranjeria1> obtenerListaCeporUidPersona(
			String uIdPErsona, BeanAuditoria auditoria, String idSession)
			throws Exception;

	public abstract Simcarnetextranjeria1 CarnetExtranjeriaLeerNro(
			String numero, BeanAuditoria auditoria, String idSession)
			throws Exception;

}