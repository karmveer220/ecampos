package org.cnl.digemin.service;

import java.util.List;

import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanPersona;

public interface AdminService {

	public abstract BeanPersona validarPersona(String usuario, String clave,
			BeanAuditoria auditoria) throws Exception;

	public abstract Integer nuevaPersona(BeanPersona p, BeanAuditoria auditoria)
			throws Exception;

	/**
	 * Recibe el codigo de la notaria, si es 0 significa que el usuario es del CNL<br />
	 * y le corresponde la lista de todos los usuarios, de ser otro numero <br />
	 * le corresponde solo la lista de usuarios de su notariam.
	 * @param codigo Id de notaria.
	 * @return lista de usuarios segun la notaria ingresada
	 * @throws Exception
	 */
	public abstract List<BeanPersona> listarUsuarios(Long codigo)
			throws Exception;

	/**
	 * Evalua el codigo de la notaria. sies del CNL entrega todos los usuarios, sino, solo 
	 * los usuarios de su ntoaria.
	 * @param b beanPersona con informacion cargada
	 * @return
	 * @throws Exception
	 */
	public abstract List<BeanPersona> buscarUsuarios(BeanPersona b)
			throws Exception;

	public abstract BeanPersona obtenerUsuarioById(Long codigo)
			throws Exception;

	public abstract Integer modificarPersona(BeanPersona p,
			BeanAuditoria auditoria) throws Exception;

}