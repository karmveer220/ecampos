package gob.min.digemin.ejb;

import gob.min.digemin.ejb.entitiesWeb.BeanImagen;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;
import gob.min.digemin.ejb.entitiesWeb.Simcarnetextranjeria1;
import gob.min.digemin.ejb.entitiesWeb.Simmovmigra1;
import gob.min.digemin.ejb.entitiesWeb.Simpasaporte1;
import gob.min.digemin.ejb.entitiesWeb.Simpersona1;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface EjbDigeminWS{
    
	/**
	 * Recibe los siguientes parametros:<br/>
	 * @param request conteniendo solo: nombre, apePaterno, apeMaterno, peruano, aproximado, idSession.
	 * @return listaPersonas
	 */
    @WebMethod 
    @WebResult(name="listaPersonas") 
    public List<Simpersona1> listaPersonaPorNombres(@WebParam(name="request")BeanRequest request);
    
    /*
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo:  nombre, apePaterno, apeMaterno, peruano, aproximado, idSession.
     * @return listaPersonas
     /
    @WebMethod 
    @WebResult(name="listaPersonas") 
    public List<Simpersona1> listaPersonaPorNombresCondoc(@WebParam(name="request")BeanRequest request);
    */
    
    /**
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo: uIdPersona, idSession.
     * @return persona
     */
    @WebMethod
    @WebResult(name="persona")
    public Simpersona1 PersonaLeer(@WebParam(name="request")BeanRequest request);
    
    /**
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo: sNumPasaporte, idSession.
     * @return persona
     */
    @WebMethod
    @WebResult(name="persona")
    public Simpersona1 PersonaLeerPorPasaporte(@WebParam(name="request")BeanRequest request);
    
    /* ***CARNET DE EXTRANJERIA***** */
    
    /**
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo: numero, idSession.
     * @return carnet 
     */
    @WebMethod 
    @WebResult(name="carnet")
    public Simcarnetextranjeria1 CarnetExtranjeriaLeerNro(@WebParam(name="request")BeanRequest request);
    
    /**
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo: uIdPersona, idSession.
     * @return listaCarnet
     */
    @WebMethod 
    @WebResult(name="listaCarnet")
    public List<Simcarnetextranjeria1> CarnetExtranjeriaLeerPersona(@WebParam(name="request")BeanRequest request);
    
    /* *** PASAPORTE ***** */
    /**
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo: sNumPasaporte, idSession.
     * @return pasaporte
     */
    @WebMethod 
    @WebResult(name="pasaporte")
    public Simpasaporte1 PasaporteLeerNro(@WebParam(name="request")BeanRequest request);
    
    /**
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo: uIdPersona, idSession.
     * @return listaPasaportes
     */
    @WebMethod 
    @WebResult(name="listaPasaportes")
    public List<Simpasaporte1> PasaporteLeerPersona(@WebParam(name="request")BeanRequest request);
    
    /* IMAGENES */
   
    @WebMethod 
    @WebResult(name="listaImagenes")
    public List<BeanImagen> MCMImagenBuscarUltimasPorIdPersonaPeruano(BeanRequest request);
    
    @WebMethod 
    @WebResult(name="listaImagenes")
    public List<BeanImagen> MCMImagenBuscarUltimasPorIdPersonaExtranjero(BeanRequest request);
    
    /*  MOVIMIENTOS MIGRATORIOS  */
    
    /**
     * Recibe el numero de documento para compararlo con el campo sNumeroDoc.</br>
     * Entrega la lsita de movimientos migratorios que se hayan realizado con el numero indicado</br>
     * Recibe los siguientes parametros:<br/>
     * @param request conteniendo solo: numeroDoc, idSession. 
     * @return listaMovimientos
     */
    @WebMethod 
    @WebResult(name="listaMovimientos")
    public List<Simmovmigra1> listaMovimientosXCarnet(@WebParam(name="request")BeanRequest request);
    
    @WebMethod 
    @WebResult(name="idSession")
    public String autenticaSession(@WebParam(name="idUsuario")String idUsuario)throws java.lang.Exception;
}
