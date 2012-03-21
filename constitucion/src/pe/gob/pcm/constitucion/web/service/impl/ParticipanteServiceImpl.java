package pe.gob.pcm.constitucion.web.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.pcm.constitucion.web.dao.ParametroDAO;
import pe.gob.pcm.constitucion.web.dao.ParticipanteDAO;
import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T022accionista;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;
import pe.gob.pcm.constitucion.web.service.ParticipanteService;
import pe.gob.pcm.constitucion.web.util.ParametrosUtil;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	private static final Logger logger = Logger.getLogger(ParticipanteServiceImpl.class);
	
	@Autowired
	private ParticipanteDAO participanteDAO;
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Override
	public List<T022accionista> listarAccionistas( int idtramite ) {
		return participanteDAO.listarAccionistas(idtramite);
	}


	@Override
	public List<T022accionista> listarAccionistasCompleto(Integer numTramite) {
		List<T022accionista> lista = listarAccionistas(numTramite);
		for(T022accionista acc : lista){
			 acc.setDescParticipa( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_PARTICIPANTE, acc.getCodParticipa() )  );
			 acc.setDescTipdoc(  parametroDAO.obtenerParametro(ParametrosUtil.TIPO_DOCUMENTO, acc.getCodTipdoc() )  );
		}
		return lista;
	}


	@Override
	public List<T022accionista> listarAccionistasPersonaCompleto( Integer numTramite) {
		List<T022accionista> lista = listarAccionistasCompleto(numTramite);
		for( T022accionista acc : lista){
			if( acc.getCodTipdoc() == ParametrosUtil.T_DOC_RUC){ acc.setT026perjur( participanteDAO.obtenerParticipantePj( acc.getT020tramite().getNumTramite() , acc.getCodTipdoc(), acc.getNumDocum() )) ; }
			else{  acc.setT025pernat( participanteDAO.obtenerParticipantePn( acc.getT020tramite().getNumTramite() , acc.getCodTipdoc(), acc.getNumDocum() )) ; }
		}
		return lista;
	}

	
	@Override
	public List<T025pernat> listarPersonasNaturales( int idtramite ) {
		return participanteDAO.listarPersonasNaturales(idtramite);
	}

	@Override
	public List<T026perjur> listarPersonasJuridicas( int idtramite ) {
		return participanteDAO.listarPersonasJuridicas(idtramite);
	}

	@Override
	public void registrarAccionistas(T022accionista accionista) {
		participanteDAO.registrarAccionistas(accionista);
	}

	@Override
	@Transactional
	public void registrarPersonaNatural(T025pernat accionista) {
		logger.debug("registra persona natural");
		participanteDAO.registrarPersonaNatural(accionista);
		
	//	if( !Utiles.nullToBlank(accionista.getMontoAporte()).equals("") ){
			logger.debug( accionista.getNumDocum() + " " + accionista.getCodTipdoc()  + " " +accionista.getT020tramite().getNumTramite() );
			T022accionista as = participanteDAO.obtenerAccionista( accionista.getNumDocum() , accionista.getCodTipdoc() , accionista.getT020tramite() );
			logger.debug( "accionista = "+as );
			T022accionista acc = new T022accionista();
			
			if(as != null){ 
				logger.debug("exste acionista");
				acc.setIdAccionista( as.getIdAccionista() );
			}
			
			acc.setFecRegistro( new Date());
			
			acc.setMtoAporte( accionista.getMontoAporte() );
			acc.setIndAporte( accionista.getIndAporte() );
			acc.setCodParticipa( accionista.getCodParticipa() );
			
			acc.setNumDocum( accionista.getNumDocum() );
			acc.setCodTipdoc( accionista.getCodTipdoc());
			acc.setT020tramite( accionista.getT020tramite() );
			logger.debug("registra accionista");
			participanteDAO.registrarAccionistas( acc );
	//	}
	}

	@Override
	public void registrarPersonaJuridica(T026perjur accionista) {
		participanteDAO.registrarPersonaJuridica(accionista);
		
		//if( !Utiles.nullToBlank(accionista.getMontoAporte()).equals("") ){			
			T022accionista acc = new T022accionista();
			acc.setFecRegistro( new Date());
			
			acc.setMtoAporte( accionista.getMontoAporte() );
			acc.setIndAporte( accionista.getIndAporte() );
			acc.setCodParticipa( accionista.getCodParticipa() );
			
			acc.setNumDocum( accionista.getNumDocum() );
			acc.setCodTipdoc( accionista.getCodTipdoc());
			acc.setT020tramite( accionista.getT020tramite() );
			logger.debug("registra accionista");
			participanteDAO.registrarAccionistas( acc );
		//}
		
	}

	@Override
	public void modificarAccionistas(T022accionista accionista) {
		participanteDAO.modificarAccionistas(accionista);
	}

	@Override
	public void modificarPersonaNatural(T025pernat accionista) {
		participanteDAO.modificarPersonaNatural(accionista);
	}

	@Override
	public void modificarPersonaJuridica(T026perjur accionista) {
		participanteDAO.modificarPersonaJuridica(accionista);
	}

	@Override
	public T025pernat completarParticipante(T020tramite trm, T025pernat per) {
		logger.debug( trm );
		logger.debug( per );
		per.setIndAporte( trm.getIndAporte() + "" );
		if(	StringUtils.isNotEmpty( per.getCodUbigeo())){
			per.setCodDepa( per.getCodUbigeo().substring(0,2) + "0000" ) ;
			per.setCodProv( per.getCodUbigeo().substring(0,4) + "00" );
		}
		//obtenr accionista
		T022accionista acc = participanteDAO.obtenerAccionista(per.getNumDocum(), per.getCodTipdoc(), trm );
		if(acc != null){
			per.setCodParticipa( acc.getCodParticipa()  );
			per.setMontoAporte( acc.getMtoAporte() );
			per.setIndAporte( acc.getIndAporte() );	
		}
		return per;
	}

	@Override
	public T025pernat completarParticipanteVista(T020tramite trm, T025pernat per) {
		per.setDescParticipa( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_PARTICIPANTE , per.getCodParticipa() ) );
		per.setDescTipdoc( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_DOCUMENTO , per.getCodTipdoc()) );
		per.setDescPais( "Peru" );
		per.setDescDepa( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_UBIGEO, per.getCodDepa() ) );
		per.setDescProv( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_UBIGEO, per.getCodProv()) );
		per.setDescUbigeo( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_UBIGEO, per.getCodUbigeo()) );
		per.setDescEstcivil( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_ESTADO_CIVIL, per.getCodEstcivil()) );
		per.setDescTdcon( parametroDAO.obtenerParametro(ParametrosUtil.TIPO_DOCUMENTO, per.getCodTdcon()) );
		return per;
	}

	public void eliminarParticipantePn(Integer idPn ) {
		logger.debug("elimina pn " + idPn);
		T025pernat pn = participanteDAO.obtenerParticipantePn(idPn);
		eliminarParticipante(pn.getT020tramite().getNumTramite(), pn.getCodTipdoc(), pn.getNumDocum());
	}

	@Override
	@Transactional
	public void eliminarParticipante(Integer idAcc ) {
		logger.debug("elimina participante ");
		T022accionista acc = participanteDAO.obtenerAccionista( idAcc );		
		eliminarParticipante(acc.getT020tramite().getNumTramite(), acc.getCodTipdoc(),  acc.getNumDocum());
	}

	private void eliminarParticipante(Integer tramite, String tipo, String num ){
		participanteDAO.eliminarAccionistas( tramite , tipo ,num );
		if(tipo == ParametrosUtil.T_DOC_RUC){
			participanteDAO.eliminarPersonaJuridica( tramite , tipo , num );	
		}else{
			participanteDAO.eliminarPersonaNatural( tramite , tipo , num );	
		}
	}

	@Override
	public T022accionista obtenerAccionista(String numDoccon, String codTipdoc,T020tramite t020tramite) {
		return participanteDAO.obtenerAccionista(numDoccon, codTipdoc, t020tramite);
	}


	@Override
	public T022accionista obtenerAccionista(Integer cod) {
		return participanteDAO.obtenerAccionista(cod);
	}


	@Override
	public T025pernat obtenerParticipantePn(Integer tramite, String codTipoDoc, String numDoc) {
		return participanteDAO.obtenerParticipantePn(tramite, codTipoDoc, numDoc);
	}


	@Override
	public T026perjur obtenerParticipantePj(Integer tramite, String codTipoDoc, String numDoc) {
		return participanteDAO.obtenerParticipantePj(tramite, codTipoDoc, numDoc);
	}


}
