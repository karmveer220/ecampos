package org.cnl.digemin.service;

import java.util.List;

import org.cnl.digemin.bean.BeanAuditoria;

public interface ImagenService {

	public abstract List<String> MCMImagenBuscarUltimasPorIdPersona(
			String uidPErsona, String paisNacionalidad, String pers_llave,
			String[] ltipoImagen, String path, BeanAuditoria auditoria,
			String idSession) throws Exception;

}