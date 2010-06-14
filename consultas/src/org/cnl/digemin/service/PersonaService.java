	package org.cnl.digemin.service;

import gob.min.digemin.ejb.Simpersona1;

import java.util.List;

import org.cnl.digemin.bean.BeanAuditoria;

public interface PersonaService {

	public abstract List<Simpersona1> listaPersonas(String snombre,
			String spaterno, String smaterno, boolean bPeruano,
			boolean coincidirAlFinal, BeanAuditoria auditoria, String idSession)
			throws Exception;

	public abstract Simpersona1 obtenerDatosPersona(String uIdPErsona,
			BeanAuditoria auditoria, String idSession) throws Exception;

	public abstract Simpersona1 obtenerDatosPersonaPorPasaporte(
			String sNumPasaporte, BeanAuditoria auditoria, String idSession)
			throws Exception;

}