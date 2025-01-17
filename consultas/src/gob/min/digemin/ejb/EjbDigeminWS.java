
package gob.min.digemin.ejb;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.4-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "EjbDigeminWS", targetNamespace = "http://ejb.digemin.min.gob/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EjbDigeminWS {


    /**
     * 
     * @param request
     * @return
     *     returns gob.min.digemin.ejb.Simcarnetextranjeria1
     */
    @WebMethod(operationName = "CarnetExtranjeriaLeerNro")
    @WebResult(name = "carnet", targetNamespace = "")
    @RequestWrapper(localName = "CarnetExtranjeriaLeerNro", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.CarnetExtranjeriaLeerNro")
    @ResponseWrapper(localName = "CarnetExtranjeriaLeerNroResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.CarnetExtranjeriaLeerNroResponse")
    public Simcarnetextranjeria1 carnetExtranjeriaLeerNro(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns java.util.List<gob.min.digemin.ejb.Simcarnetextranjeria1>
     */
    @WebMethod(operationName = "CarnetExtranjeriaLeerPersona")
    @WebResult(name = "listaCarnet", targetNamespace = "")
    @RequestWrapper(localName = "CarnetExtranjeriaLeerPersona", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.CarnetExtranjeriaLeerPersona")
    @ResponseWrapper(localName = "CarnetExtranjeriaLeerPersonaResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.CarnetExtranjeriaLeerPersonaResponse")
    public List<Simcarnetextranjeria1> carnetExtranjeriaLeerPersona(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<gob.min.digemin.ejb.BeanImagen>
     */
    @WebMethod(operationName = "MCMImagenBuscarUltimasPorIdPersonaExtranjero")
    @WebResult(name = "listaImagenes", targetNamespace = "")
    @RequestWrapper(localName = "MCMImagenBuscarUltimasPorIdPersonaExtranjero", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.MCMImagenBuscarUltimasPorIdPersonaExtranjero")
    @ResponseWrapper(localName = "MCMImagenBuscarUltimasPorIdPersonaExtranjeroResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.MCMImagenBuscarUltimasPorIdPersonaExtranjeroResponse")
    public List<BeanImagen> mcmImagenBuscarUltimasPorIdPersonaExtranjero(
        @WebParam(name = "arg0", targetNamespace = "")
        BeanRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<gob.min.digemin.ejb.BeanImagen>
     */
    @WebMethod(operationName = "MCMImagenBuscarUltimasPorIdPersonaPeruano")
    @WebResult(name = "listaImagenes", targetNamespace = "")
    @RequestWrapper(localName = "MCMImagenBuscarUltimasPorIdPersonaPeruano", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.MCMImagenBuscarUltimasPorIdPersonaPeruano")
    @ResponseWrapper(localName = "MCMImagenBuscarUltimasPorIdPersonaPeruanoResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.MCMImagenBuscarUltimasPorIdPersonaPeruanoResponse")
    public List<BeanImagen> mcmImagenBuscarUltimasPorIdPersonaPeruano(
        @WebParam(name = "arg0", targetNamespace = "")
        BeanRequest arg0);

    /**
     * 
     * @param request
     * @return
     *     returns gob.min.digemin.ejb.Simpasaporte1
     */
    @WebMethod(operationName = "PasaporteLeerNro")
    @WebResult(name = "pasaporte", targetNamespace = "")
    @RequestWrapper(localName = "PasaporteLeerNro", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PasaporteLeerNro")
    @ResponseWrapper(localName = "PasaporteLeerNroResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PasaporteLeerNroResponse")
    public Simpasaporte1 pasaporteLeerNro(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns java.util.List<gob.min.digemin.ejb.Simpasaporte1>
     */
    @WebMethod(operationName = "PasaporteLeerPersona")
    @WebResult(name = "listaPasaportes", targetNamespace = "")
    @RequestWrapper(localName = "PasaporteLeerPersona", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PasaporteLeerPersona")
    @ResponseWrapper(localName = "PasaporteLeerPersonaResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PasaporteLeerPersonaResponse")
    public List<Simpasaporte1> pasaporteLeerPersona(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns gob.min.digemin.ejb.Simpersona1
     */
    @WebMethod(operationName = "PersonaLeer")
    @WebResult(name = "persona", targetNamespace = "")
    @RequestWrapper(localName = "PersonaLeer", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PersonaLeer")
    @ResponseWrapper(localName = "PersonaLeerResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PersonaLeerResponse")
    public Simpersona1 personaLeer(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns gob.min.digemin.ejb.Simpersona1
     */
    @WebMethod(operationName = "PersonaLeerPorPasaporte")
    @WebResult(name = "persona", targetNamespace = "")
    @RequestWrapper(localName = "PersonaLeerPorPasaporte", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PersonaLeerPorPasaporte")
    @ResponseWrapper(localName = "PersonaLeerPorPasaporteResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.PersonaLeerPorPasaporteResponse")
    public Simpersona1 personaLeerPorPasaporte(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

    /**
     * 
     * @param idUsuario
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(name = "idSession", targetNamespace = "")
    @RequestWrapper(localName = "autenticaSession", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.AutenticaSession")
    @ResponseWrapper(localName = "autenticaSessionResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.AutenticaSessionResponse")
    public String autenticaSession(
        @WebParam(name = "idUsuario", targetNamespace = "")
        String idUsuario)
        throws Exception_Exception
    ;

    /**
     * 
     * @param request
     * @return
     *     returns java.util.List<gob.min.digemin.ejb.Simmovmigra1>
     */
    @WebMethod
    @WebResult(name = "listaMovimientos", targetNamespace = "")
    @RequestWrapper(localName = "listaMovimientosXCarnet", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.ListaMovimientosXCarnet")
    @ResponseWrapper(localName = "listaMovimientosXCarnetResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.ListaMovimientosXCarnetResponse")
    public List<Simmovmigra1> listaMovimientosXCarnet(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns java.util.List<gob.min.digemin.ejb.Simpersona1>
     */
    @WebMethod
    @WebResult(name = "listaPersonas", targetNamespace = "")
    @RequestWrapper(localName = "listaPersonaPorNombres", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.ListaPersonaPorNombres")
    @ResponseWrapper(localName = "listaPersonaPorNombresResponse", targetNamespace = "http://ejb.digemin.min.gob/", className = "gob.min.digemin.ejb.ListaPersonaPorNombresResponse")
    public List<Simpersona1> listaPersonaPorNombres(
        @WebParam(name = "request", targetNamespace = "")
        BeanRequest request);

}
