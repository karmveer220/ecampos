package pe.gob.pcm.constitucion.web.dao;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T001parametro;

public interface ParametroDAO {

	public List<T001parametro> litarParametros(String padre);
	/**
	 * en casos como Zona registral y Oficina registral
	 * en donde con el codigo de la zona escogida (codigo padre)
	 * filtro las oficinas cuyo cod_param inicie con el codigo padre
	 * @param padre
	 * @param padre2
	 * @return
	 */
	public List<T001parametro> litarParametros(String padre,String padre2);
	
	public List<T001parametro> litarParametrosDepartamentos();
	public List<T001parametro> litarParametrosProvincias(String depa);
	public List<T001parametro> litarParametrosdistritos(String depa, String prov);
	public String obtenerParametro(String tipoDocumento, String codTipdoc);
	
	
}
