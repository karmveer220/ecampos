package gob.min.digemin.ejb;
import gob.min.digemin.ejb.entitiesWeb.BeanImagen;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;
import gob.min.digemin.ejb.entitiesWeb.Simcarnetextranjeria1;
import gob.min.digemin.ejb.entitiesWeb.Simmovmigra1;
import gob.min.digemin.ejb.entitiesWeb.Simpasaporte1;
import gob.min.digemin.ejb.entitiesWeb.Simpersona1;

import java.util.List;

import javax.ejb.Remote;
@Remote
public interface EjbDigeminRemote {
	
	/* *****PERSONA******/    
    public List<Simpersona1> listaPersonaPorNombres(BeanRequest request);
   // public List<Simpersona1> listaPersonaPorNombresCondoc(BeanRequest request); no se para que se usa
    public Simpersona1 PersonaLeer(BeanRequest request);
    public Simpersona1 PersonaLeerPorPasaporte(BeanRequest request);
    
    /* ***CARNET DE EXTRANJERIA******/
    public Simcarnetextranjeria1 CarnetExtranjeriaLeerNro(BeanRequest request);
    public List<Simcarnetextranjeria1> CarnetExtranjeriaLeerPersona(BeanRequest request);
   
    /* *** PASAPORTE ******/
    public Simpasaporte1 PasaporteLeerNro(BeanRequest request);
    public List<Simpasaporte1> PasaporteLeerPersona(BeanRequest request);
    
    /* *******IMAGENES*******/
    //public List<BeanImagen> MCMImagenBuscarUltimasPorIdPersona(BeanRequest request);
    public List<BeanImagen> MCMImagenBuscarUltimasPorIdPersonaPeruano(BeanRequest request);
    public List<BeanImagen> MCMImagenBuscarUltimasPorIdPersonaExtranjero(BeanRequest request);
    public int cantidadCE(String uIdPersona,String idSession);
    public int cantidadPasaporte(String sNumPasaporte,String idSession);
    
    /* MOVIMIENTOS MIGRATORIOS */
    
    public List<Simmovmigra1> listaMovimientosXCarnet(BeanRequest request);
    
    /* SEGURIDAD */
    public String autenticaSession(String idUsuario)throws java.lang.Exception;
    public void registraLog(String tc,String dd,String ids,String obs,String uid);
    public boolean existeIdSesion(String idSesion);
}
