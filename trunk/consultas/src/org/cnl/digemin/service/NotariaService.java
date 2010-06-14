package org.cnl.digemin.service;

import java.util.List;

import org.cnl.digemin.bean.BeanNotaria;

public interface NotariaService {

	/**
	 * Si el codigo de notaria pertenece a la del Colegio de Notarios entrega <br />
	 * toda al lista de notarias. Caso contrario, entrega solo la notaria <br />
	 * que coincide con el codigo.
	 * @param colegio codigo de colegio
	 * @return lista de notarias de un colegio
	 * @throws Exception
	 */
	public abstract List<BeanNotaria> listaComboNotarias(Long colegio)
			throws Exception;

	public abstract Integer grabaNotaria(BeanNotaria notaria) throws Exception;

	public abstract Integer modificaNotaria(BeanNotaria notaria)
			throws Exception;

	public abstract BeanNotaria obtenerNotaria(String cod) throws Exception;

	public abstract List<BeanNotaria> buscarnotarias(String nombre)
			throws Exception;

}