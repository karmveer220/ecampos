package org.cnl.digemin.service;

import java.util.List;

import org.cnl.digemin.bean.BeanColegio;

public interface ColegioService {

	public abstract List<BeanColegio> listaDeColegios() throws Exception;

}