package pe.gob.pcm.constitucion.web.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import pe.gob.pcm.constitucion.web.bean.BeanValida;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;
import pe.gob.pcm.constitucion.web.service.ValidacionService;

@Service
public class ValidacionServiceImpl implements ValidacionService {

	@Override
	public BeanValida validaParticipantePn(T025pernat participante) {
		BeanValida val = new BeanValida(0,"");
		if( StringUtils.isEmpty( participante.getNomPernat() ) ){
			val.aumenta(1, "Debe ingresar el nombre");
		}
		System.out.println( val.toString() );
		return val;
	}

	@Override
	public BeanValida validaParticipantePj(T026perjur participante) {
		BeanValida val = new BeanValida(0,"");
		if( StringUtils.isEmpty( participante.getNomRazsoc() ) ){
			val.aumenta(1, "Debe ingresar la razon social");
		}
		return val;
	}

	@Override
	public BeanValida validaTramiteInicial(T020tramite tramite) {
		BeanValida val = new BeanValida(0,"");
		if( StringUtils.isEmpty( tramite.getClvKardex() ) ){
			val.aumenta(1, "Debe ingresar el Kardex");
		}
		return val;
	}

	@Override
	public BeanValida validaCerrarTramite(T020tramite tramite) {
		BeanValida val = new BeanValida(0,"");
		if(tramite==null){
			val.aumenta(1, "No se ha encontrado el tramite");
			return val;
		}
		if( StringUtils.isEmpty( tramite.getClvKardex() ) ){
			val.aumenta(1, "Debe ingresar el Kardex");
		}
		return val;
	}

	@Override
	public BeanValida validaFirmarTramite(T020tramite obtenerTramite) {
		BeanValida val = new BeanValida(0,"");
		return val;
	}

	@Override
	public BeanValida validaEnviarTramite(T020tramite obtenerTramite) {
		BeanValida val = new BeanValida(0,"");
		return val;
	}

	@Override
	public BeanValida validaEliminarTramite(T020tramite obtenerTramite) {
		BeanValida val = new BeanValida(0,"");
		return val;
	}

	@Override
	public BeanValida validaRestaurarTramite(T020tramite obtenerTramite) {
		BeanValida val = new BeanValida(0,"");
		return val;
	}

	@Override
	public BeanValida validaAbrirTramite(T020tramite obtenerTramite) {
		BeanValida val = new BeanValida(0,"");
		return val;
	}

}
