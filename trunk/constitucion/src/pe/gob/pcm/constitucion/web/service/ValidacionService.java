package pe.gob.pcm.constitucion.web.service;

import pe.gob.pcm.constitucion.web.bean.BeanValida;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;

public interface ValidacionService {

	public BeanValida validaParticipantePn(T025pernat participante);
	public BeanValida validaParticipantePj(T026perjur participante);
	/**
	 * Validar el tramite cuando es grabado por primera vez
	 * @param tramite
	 */
	public BeanValida validaTramiteInicial(T020tramite tramite);
	public BeanValida validaCerrarTramite(T020tramite tramite);
	public BeanValida validaFirmarTramite(T020tramite obtenerTramite);
	public BeanValida validaEnviarTramite(T020tramite obtenerTramite);
	public BeanValida validaEliminarTramite(T020tramite obtenerTramite);
	public BeanValida validaRestaurarTramite(T020tramite obtenerTramite);
	public BeanValida validaAbrirTramite(T020tramite obtenerTramite);
	
}
