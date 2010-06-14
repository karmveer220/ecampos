package org.cnl.digemin.service;

import gob.min.digemin.ejb.Simpasaporte1;

import java.util.List;

import org.cnl.digemin.bean.BeanAuditoria;

public interface PasaporteService {

	public abstract List<Simpasaporte1> obtenerListaPasaportePorUidPersona(
			String uIdPErsona, BeanAuditoria auditoria, String idSession)
			throws Exception;

	public abstract Simpasaporte1 PasaporteLeerNro(String numero,
			BeanAuditoria auditoria, String idSession) throws Exception;

}