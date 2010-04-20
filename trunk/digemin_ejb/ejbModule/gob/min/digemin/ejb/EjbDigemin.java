package gob.min.digemin.ejb;

import gob.min.digemin.ejb.bean.Simauditoriaconsultaweb;
import gob.min.digemin.ejb.bean.Simcarnetextranjeria;
import gob.min.digemin.ejb.bean.Simimagen;
import gob.min.digemin.ejb.bean.Simimagenextranjero;
import gob.min.digemin.ejb.bean.Simmovmigra;
import gob.min.digemin.ejb.bean.Simpasaporte;
import gob.min.digemin.ejb.bean.Simpersona;
import gob.min.digemin.ejb.bean.Simsesion;
import gob.min.digemin.ejb.bean.Simusuarioexterno;
import gob.min.digemin.ejb.entitiesWeb.BeanImagen;
import gob.min.digemin.ejb.entitiesWeb.BeanRequest;
import gob.min.digemin.ejb.entitiesWeb.Simcalidadmigratoria1;
import gob.min.digemin.ejb.entitiesWeb.Simcarnetextranjeria1;
import gob.min.digemin.ejb.entitiesWeb.Simdocumento1;
import gob.min.digemin.ejb.entitiesWeb.Simmovmigra1;
import gob.min.digemin.ejb.entitiesWeb.Simpais1;
import gob.min.digemin.ejb.entitiesWeb.Simpasaporte1;
import gob.min.digemin.ejb.entitiesWeb.Simpersona1;
import gob.min.digemin.ejb.utiles.Utiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class EjbDigemin
 * https://www.virtualizationhero.org/docs/manuals/jboss/jboss-eap-4.3/doc/Server_Configuration_Guide/html/Server_Configuration_Guide-Proprietary_Annotations-WebContext.html
 * 
 */

@WebService(name = "EjbDigeminWs", serviceName="WsDigeminService", endpointInterface = "gob.min.digemin.ejb.EjbDigeminWS")
/*@WebContext(contextRoot = "/digemin-digemin_ejb", urlPattern = "/EjbDigemin",
		authMethod = "BASIC", 
		secureWSDLAccess = false)    
@HandlerChain(file = "EjbDigemin_handler.xml")*/
@Stateless(name = "EjbDigemin", mappedName="ejb/digemin/EJBDigemin")
//@TransactionManagement(TransactionManagementType.CONTAINER) 
public class EjbDigemin implements EjbDigeminWS,EjbDigeminLocal,EjbDigeminRemote {
	
    @PersistenceContext(unitName = "EJBDigemin")
    private static EntityManager em;
    static {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EJBDigemin");
        em = factory.createEntityManager();
    }
    public EjbDigemin(){}
    
    
    @SuppressWarnings("unchecked")
	public List<Simpersona1> listaPersonaPorNombres(BeanRequest request){
       
    	existeIdSesion(request.getSIdSession());
    	
        List<Simpersona> lista = new ArrayList<Simpersona>();
        StringBuffer query = new StringBuffer("select p from Simpersona p ");

        if (request.isBPeruano()) {
            query.append(" , Simperuano r where p.uIdPersona=r.uIdPersona ");
        } else {
            query.append(" , Simextranjero r where p.uIdPersona=r.uIdPersona ");
        }

        if (!Utiles.nullToBlank(request.getSNombre()).equals("")) {
            query.append(" and ");
            if (!request.isBAproximado())
                query.append(" p.sNombre like '%'||:name||'%'");
            else
                query.append(" p.sNombre like :name||'%' ");
        }

        if (!Utiles.nullToBlank(request.getSApePaterno()).equals("")) {
            query.append(" and ");
            if (!request.isBAproximado())
                query.append(" p.sPaterno like '%'||:paterno||'%'");
            else
                query.append(" p.sPaterno like :paterno||'%' ");
        }

        if (!Utiles.nullToBlank(request.getSApeMaterno()).equals("")) {
            query.append(" and ");
            if (!request.isBAproximado())
                query.append(" p.sMaterno like '%'||:materno||'%'");
            else
                query.append(" p.sMaterno like :materno||'%' ");
        }

        query.append(" order by p.sNombre asc");
        System.out.println(query.toString());
        Query consulta = em.createQuery(query.toString());
        if (!Utiles.nullToBlank(request.getSNombre()).equals(""))
            consulta.setParameter("name", Utiles.nullToBlank(request.getSNombre()));
        if (!Utiles.nullToBlank(request.getSApePaterno()).equals(""))
            consulta.setParameter("paterno", Utiles.nullToBlank(request.getSApePaterno()));
        if (!Utiles.nullToBlank(request.getSApeMaterno()).equals(""))
            consulta.setParameter("materno", Utiles.nullToBlank(request.getSApeMaterno()));
        consulta.setMaxResults(50);
        lista = consulta.getResultList();
        /* Proceso la lista para retornar una de Simpersona1 */
        List<Simpersona1> listaPersonas = new ArrayList<Simpersona1>();
        if (lista.size() > 0) {
            for (Simpersona p: lista) {
                listaPersonas.add(new Simpersona1(p.getUIdPersona(), 
                                                  p.getDFechaNacimiento(), 
                                                  p.getSMaterno(), 
                                                  p.getSNombre(), 
                                                  p.getSPaterno()));
            }
            System.out.println("Coincidencias con la búsqueda : " + lista.size());
        }
        
        return listaPersonas;
    }
    
    public Simpersona1 PersonaLeer(BeanRequest request){
    	
    	existeIdSesion(request.getSIdSession());
    	
        Query q = em.createQuery("from Simpersona p where p.uIdPersona=:id");
        q.setParameter("id", Utiles.nullToBlank(request.getUIdPersona()));
        Simpersona p =null;
        try {
        	p = (Simpersona)q.getSingleResult();	
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
        Simpersona1 persona = null;
        if (p != null) {
            persona = 
                    new Simpersona1(p.getUIdPersona(), p.getDFechaNacimiento(), 
                                    p.getSMaterno(), p.getSNombre(), 
                                    p.getSPaterno(), p.getSSexo(), 
                                    new Simpais1(p.getSimpais2().getSIdPais(), 
                                                 p.getSimpais2().getSNombre(), 
                                                 p.getSimpais2().getSNacionalidad()), 
                                    new Simpais1(p.getSimpais().getSIdPais(), 
                                                 p.getSimpais().getSNombre(), 
                                                 p.getSimpais().getSNacionalidad()), 
                                    p.getSIdDocIdentidad(), 
                                    p.getSNumDocIdentidad());
            System.out.println("Persona encontrada : " + Utiles.nullToBlank(p.toString()));
            //TODO: LOG aqui no xq no esta cmpleto, cuando traigo el pasaporte o  carnet de extranjeria debo loguear
            //registraLog("PAS", null, request.getSIdSession(), null, p.getUIdPersona());
        }        
        return persona;

    }
    
    public Simpersona1 PersonaLeerPorPasaporte(BeanRequest request){
    	
    	existeIdSesion(request.getSIdSession());
    	
        System.out.println("PersonaLeerPorPasaporte.162");
        Query q = em.createQuery("select R from Simpersona R, Simpasaporte P, Simpasperu S " + 
                           " where P.sPasNumero=S.sPasNumero and S.uIdPersona=R.uIdPersona and P.sPasNumero =:num");
        q.setParameter("num", Utiles.nullToBlank(request.getSNumPasaporte()));
        Simpersona p =null;
        try {
        	p = (Simpersona)q.getSingleResult();	
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
        Simpersona1 persona = null;
        if (p != null) {
            persona = 
                    new Simpersona1(p.getUIdPersona(), p.getDFechaNacimiento(), 
                                    p.getSMaterno(), p.getSNombre(), 
                                    p.getSPaterno(), p.getSSexo(), 
                                    new Simpais1(p.getSimpais2().getSIdPais(), 
                                                 p.getSimpais2().getSNombre(), 
                                                 p.getSimpais2().getSNacionalidad()), 
                                    new Simpais1(p.getSimpais().getSIdPais(), 
                                                 p.getSimpais().getSNombre(), 
                                                 p.getSimpais().getSNacionalidad()), 
                                    p.getSIdDocIdentidad(), 
                                    p.getSNumDocIdentidad());
            System.out.println("Persona encontrada : " +  Utiles.nullToBlank(p.toString()));
            //TODO: LOG
        	registraLog("PAS", "PAS-"+request.getSNumPasaporte(), request.getSIdSession(), null, p.getUIdPersona());
        }
        return persona;
    }
       
    public Simcarnetextranjeria1 CarnetExtranjeriaLeerNro(BeanRequest request){
    	    	
    	existeIdSesion(request.getSIdSession());
    	
        Query q = em.createQuery("from Simcarnetextranjeria c where c.sNumeroCarnet=:numero");
        q.setParameter("numero", Utiles.nullToBlank(request.getSNumCE()));
        Simcarnetextranjeria c=null;
        try {
        	c = (Simcarnetextranjeria)q.getSingleResult();        	
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}
        Simcarnetextranjeria1 carnet = null;
        if (c != null) {
            carnet = new Simcarnetextranjeria1(c.getNIdCarnet(), c.getSNumeroCarnet(), 
                                              c.getUIdPersona(), 
                                              c.getDFechaEmision(), 
                                              c.getDFechaCaducidad(), 
                                              c.getDFechaVencRes(), 
                                              c.getSTipo());
            carnet.setCantidad(cantidadCE(carnet.getUIdPersona(), request.getSIdSession() ));
            System.out.println("Carnet de Extranjería numero : " + Utiles.nullToBlank(c.toString()));
            //TODO: LOG
        	registraLog("CE", "CE-"+c.getSNumeroCarnet(), request.getSIdSession(), null, c.getUIdPersona());
        }

        return carnet;
    }
   
    @SuppressWarnings("unchecked")
	public List<Simcarnetextranjeria1> CarnetExtranjeriaLeerPersona(BeanRequest request){
    	    	
    	existeIdSesion(request.getSIdSession());
    	
        Query consulta = em.createQuery("from Simcarnetextranjeria c where c.uIdPersona=:id order by c.dFechaEmision asc");
        consulta.setParameter("id", Utiles.nullToBlank(request.getUIdPersona()));
        List<Simcarnetextranjeria> lista = consulta.getResultList();
        List<Simcarnetextranjeria1> listraCarnet = new ArrayList<Simcarnetextranjeria1>();
        if (lista.size() > 0) {
            for (Simcarnetextranjeria c: lista) {
                listraCarnet.add(new Simcarnetextranjeria1(c.getNIdCarnet(), 
                                                           c.getSNumeroCarnet(), 
                                                           c.getUIdPersona(), 
                                                           c.getDFechaEmision(), 
                                                           c.getDFechaCaducidad(), 
                                                           c.getDFechaVencRes(), 
                                                           c.getSTipo()));
            }
            //TODO: LOG
        	registraLog("CE", "CE-"+lista.get(0).getSNumeroCarnet(), request.getSIdSession(), null, request.getUIdPersona());
        }
        System.out.println("[EJB] CarnetExtranjeriaLeerPersona : from Simcarnetextranjeria c where c.uIdPersona=:id order by c.dFechaEmision asc");
        return listraCarnet;
    }

    public Simpasaporte1 PasaporteLeerNro(BeanRequest request){
       
    	existeIdSesion(request.getSIdSession());
    	
        Query consulta = em.createQuery("from Simpasaporte p where p.sPasNumero=:numero");
        consulta.setParameter("numero", Utiles.nullToBlank(request.getSNumPasaporte() ));
        Simpasaporte p =null;
        try {
        	p = (Simpasaporte)consulta.getSingleResult();	
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}
        Simpasaporte1 pasaporte = null;
        if (p != null) {
            pasaporte = new Simpasaporte1(p.getSPasNumero(), p.getDFechaEmision(), 
                                      p.getDFechaExpiracion(), 
                                      p.getSIdDocumento(), p.getSNumeroDoc(), 
                                      p.getSEstadoActual());
            pasaporte.setCantidad(cantidadPasaporte(request.getSNumPasaporte(), request.getSIdSession()));
            //TODO: LOG
            registraLog("PAS", "PAS-"+p.getSNumeroDoc(), request.getSIdSession(), null, null);
        }
        return pasaporte;
    }
       
    @SuppressWarnings("unchecked")
	public List<Simpasaporte1> PasaporteLeerPersona(BeanRequest request){
    	
    	existeIdSesion(request.getSIdSession());
    	
        String sql = "select p from Simpasaporte p, Simpasperu R where p.sPasNumero=R.sPasNumero and R.uIdPersona=:id order by p.dFechaEmision asc";
        Query consulta = em.createQuery(sql);
        consulta.setParameter("id", Utiles.nullToBlank(request.getUIdPersona()));
        List<Simpasaporte> lista = consulta.getResultList();
        System.out.println("[EJB] PasaporteLeerPersona : " + sql);
        List<Simpasaporte1> listaPasaportes = new ArrayList<Simpasaporte1>();
        if (lista.size() > 0) {
            for (Simpasaporte p: lista) {
                listaPasaportes.add(new Simpasaporte1(p.getSPasNumero(), 
                                                      p.getDFechaEmision(), 
                                                      p.getDFechaExpiracion(), 
                                                      p.getSIdDocumento(), 
                                                      p.getSNumeroDoc(), 
                                                      p.getSEstadoActual()));
            }
            //TODO: LOG
        	registraLog("PAS", "PAS-"+lista.get(0).getSPasNumero(), request.getSIdSession(), null, request.getUIdPersona());
        }
        return listaPasaportes;

    }
     
    @SuppressWarnings("unchecked")
	public List<BeanImagen> MCMImagenBuscarUltimasPorIdPersonaExtranjero(BeanRequest request) {
    	
    	existeIdSesion(request.getSIdSession());
    	
         List<BeanImagen> lImagen = null;
         java.util.Hashtable<String, String> imgPersona = new Hashtable<String, String>();
         StringBuffer ltipoImagen = new StringBuffer("");
        
         //ID,II
         if(request.getSTipoImagen()!=null){
        	 if (request.getSTipoImagen().length == 1) {
                 ltipoImagen.append(" sIdDedo= '" + Utiles.nullToBlank(request.getSTipoImagen()[0]) + "'");
             } else {
                 for (String es: request.getSTipoImagen()) {
                     ltipoImagen.append((ltipoImagen.toString().length() != 0 ?  "," : "") + "'" + Utiles.nullToBlank(es) + "'");
                 }
             }        	 
         }
             StringBuffer sQuery = new StringBuffer();
             sQuery.append("from Simimagenextranjero e WHERE e.uIdPersona=:uid and e.bUltimo=1 ");
             if (ltipoImagen.toString().trim().length() != 0) {
                 sQuery.append("and ( e.sIdDedo IN(" );
                 sQuery.append(Utiles.nullToBlank(ltipoImagen.toString()) );
                 sQuery.append(")");
                 sQuery.append(" or e.sTipo in('F','M') )");
             }
             //TODO: una buena practicaes no poner OR sino hacer query 1 UNION query2 pero solo cuando los campos del where son index
             sQuery.append(" order by e.sTipo asc");
             System.out.println("--- Imagen de EXTRANJERO ---"+  sQuery.toString());
             Query q = em.createQuery(sQuery.toString());
             q.setParameter("uid", Utiles.nullToBlank(request.getUIdPersona()));
             List<Simimagenextranjero> listaImagenes = (List)q.getResultList();
             String llave = "";
             if (listaImagenes != null) {
                 lImagen = new ArrayList<BeanImagen>();
                 if(listaImagenes.size() > 0 ){
	                 for (Simimagenextranjero img: listaImagenes) {
	                     llave = img.getSIdDedo() != null ? img.getSIdDedo() : img.getSTipo();
	                     llave = Utiles.nullToBlank(llave);
	                     if (imgPersona.get(llave) == null) {
	                         imgPersona.put(llave, "");
	                         lImagen.add(new BeanImagen(llave, img.getXImagen()));
	                     }
	                 }
	                 System.out.println("Lista de imagenes : " + lImagen.size());
	                 //TODO: LOG
	             	 registraLog("CE", "CE-"+listaImagenes.get(0).getSNumeroCarnet(), request.getSIdSession(), null, request.getUIdPersona());
                 }
             }
         return lImagen;
	}

	@SuppressWarnings("unchecked")
	public List<BeanImagen> MCMImagenBuscarUltimasPorIdPersonaPeruano(BeanRequest request) {
		
		existeIdSesion(request.getSIdSession());
		
	        List<BeanImagen> lImagen = null;
	        java.util.Hashtable<String, String> imgPersona = new Hashtable<String, String>();
	        StringBuffer ltipoImagen = new StringBuffer("");
	        if(request.getSTipoImagen()!=null){
	            if (request.getSTipoImagen().length == 1) {
	                ltipoImagen.append(" AND sTipoImagen= '" + Utiles.nullToBlank(request.getSTipoImagen()[0]) + "'");
	            } else {
	                for (String es: request.getSTipoImagen()) {
	                    ltipoImagen.append((ltipoImagen.toString().length() != 0 ?  "," : "") + "'" +  Utiles.nullToBlank(es) + "'");
	                }
	            }
	        }
	            StringBuffer sQuery = new StringBuffer();
	            sQuery.append("from Simimagen i where i.uIdPersona=:uid and i.bUltimo=1 ");
	            if (ltipoImagen.toString().trim().length() != 0) {
	                sQuery.append(" AND sTipoImagen IN(");
	                sQuery.append(Utiles.nullToBlank(ltipoImagen.toString()) );
	                sQuery.append(")");
	            }
	            sQuery.append(" order by i.sTipoImagen asc");
	            System.out.println("--- Imagen de PERUANO ---");
	            System.out.println("Select imagenes PERUANO : " +  sQuery.toString() + " - uid : " + request.getUIdPersona());
	            Query q = em.createQuery(sQuery.toString());
	            q.setParameter("uid", Utiles.nullToBlank(request.getUIdPersona()));
	            List<Simimagen> listaImagenes = (List)q.getResultList();
	            if (listaImagenes != null) {
	                lImagen = new ArrayList<BeanImagen>();
	                if(listaImagenes.size() > 0 ){
	                	 for (Simimagen img: listaImagenes) {
	 	                    if (imgPersona.get(img.getSTipoImagen()) == null) {
	 	                        imgPersona.put(img.getSTipoImagen(), "");
	 	                        lImagen.add(new BeanImagen(img.getSTipoImagen(), img.getXImagen()));
	 	                    }
	 	                }
	 	                System.out.println("Lista de imagenes : " + lImagen.size());
	 	                //TODO: LOG
	 	        		registraLog("PAS", "PAS-"+listaImagenes.get(0).getSPasNumero(), request.getSIdSession(), null, request.getUIdPersona());
	                }
	            }

	        
	        return lImagen;
	}
	
    public int cantidadCE(String uIdPersona,String idSession) {
    	
    	existeIdSesion(idSession);
    	
        String cadena = "Select count(c) from Simcarnetextranjeria c where c.uIdPersona=:uid ";
        Query q = em.createQuery(cadena);
        q.setParameter("uid", Utiles.nullToBlank(uIdPersona));
        Long count = (Long)q.getSingleResult();
        //TODO: LOG
    	registraLog("CE", "CE-count", idSession, null, uIdPersona);
        return count.intValue();
        
    }
    
    public int cantidadPasaporte(String sNumPasaporte,String idSession) {
    	
    	existeIdSesion(idSession);
    	
        String cadena = "Select count(p)  from Simpasaporte p, Simpasperu R where p.sPasNumero=R.sPasNumero and R.uIdPersona=(Select uIdPersona from Simpasperu where sPasNumero=:num)  ";
        Query q = em.createQuery(cadena);
        q.setParameter("num", Utiles.nullToBlank(sNumPasaporte));
        Long count = (Long)q.getSingleResult();
        //TODO: LOG
    	registraLog("PAS", "PAS-"+sNumPasaporte, idSession, null, null);
        return count.intValue();
        
    }
   
    @SuppressWarnings("unchecked")
	public List<Simmovmigra1> listaMovimientosXCarnet(BeanRequest request){
       
    	existeIdSesion(request.getSIdSession());
    	
        Query consulta = em.createQuery("from Simmovmigra m where m.sNumeroDoc=:numero order by m.dFechaControl desc");
        consulta.setParameter("numero", Utiles.nullToBlank(request.getSNumDocMovimiento()));
        consulta.setMaxResults(5);
        List<Simmovmigra> lista = (List)consulta.getResultList();
        
        if (lista != null) {
            List<Simmovmigra1> lista1 = new ArrayList<Simmovmigra1>();
            if (lista.size() > 0) {
                for (Simmovmigra mo: lista) {
                    lista1.add(new Simmovmigra1(mo.getSIdMovMigratorio(), 
                                                new Simcalidadmigratoria1(mo.getSimcalidadmigratoria().getNIdCalidad(), 
                                                                          mo.getSimcalidadmigratoria().getSDescripcion()), 
                                                mo.getDFechaControl(), 
                                                mo.getSNumeroDoc(), 
                                                mo.getSNumDocControl(), 
                                                mo.getSObservaciones(), 
                                                new Simpais1(mo.getSimpais1().getSIdPais(), 
                                                             mo.getSimpais1().getSNombre(), 
                                                             mo.getSimpais1().getSNacionalidad()), 
                                                mo.getSDireccionDestino(), 
                                                new Simdocumento1(mo.getSimdocumento1().getSIdDocumento(), 
                                                                  mo.getSimdocumento1().getSDescripcion()), 
                                                mo.getSTipo()));
                }
                //TODO: LOG
                registraLog("MM", "MM-"+request.getSNumDocMovimiento(), request.getSIdSession(), null, null);
            }
            System.out.println("LISTA LLENA DE MOV MIGRA");
            return lista1;
        } else {
            return null;
        }

    }

    /**
     * Realiza la validacion del usuario, de ser correcto, devuelve un Id de session </br>
     * que usara el usuario en cada llamada al webService
     * @param idUsuario
     * @return Id de session para autenticar cada llamada al web service
     * @throws Exception
     */
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String autenticaSession(String idUsuario)throws java.lang.Exception{
    	
    	 Query consulta = em.createQuery("from Simusuarioexterno m where m.sLogin=:usuario");
    	 consulta.setParameter("usuario", Utiles.nullToBlank(idUsuario));
         Simusuarioexterno usuario = null;
        	 try {
        		 usuario  = (Simusuarioexterno)consulta.getSingleResult();		
			} catch (Exception e) {
				System.out.println("error "+e.getMessage());
				throw new Exception("usuario no registrado en DIGEMIN.");
			}
        if(usuario != null){
        	
        	Simsesion session = new Simsesion();
        	session.setSMacAddress(null);
        	session.setDFechaInicio(new GregorianCalendar());
        	session.setDFechaFin(new GregorianCalendar());
        	session.setSVersionModulo("1.1");
        	session.setNIdOperador(usuario.getNIdOperador());
        	session.setSIdModulo("WEB-CNT");
        	session.setSIPAddress("127.0.0.1");
        	session.setXToken(null);
        	session.setBActivo(true);
        	session.setNIdEstacion(1);
        	session.setSIdDependencia("95");
        	session.setNIdSesionMigra(null);
        	session.setSAppServer(null);
        	session.setSPuerto(null);
        	session.setSUsuarioRed(null);
        	session.setSIdSubDependencia(null);
        	em.persist(session);
        	return ""+session.getNIdSesion();
        }
         
        return "";
    }
   
    /**
     * 
     * @param tc tipo consulta {MM,PAS,CE}
     * @param dd documento detalle PAS - 000000
     * @param ids id session
     * @param obs observacion
     * @param uid uid de persona
     */
    public void registraLog(String tc,String dd,String ids,String obs,String uid){
    	Simauditoriaconsultaweb auditoria = new Simauditoriaconsultaweb();
        auditoria.setSTipoConsulta(tc);
        auditoria.setDFechaConsulta(new Date());
        auditoria.setSDocDetalle(dd);
        auditoria.setSIdProcedimientoForm(null);
        auditoria.setSIdSesion(Integer.parseInt(ids));
        auditoria.setSObservacion(obs);
        auditoria.setUIdPersona(uid);
        em.persist(auditoria);
    }


    /**
     * Verifica si el IDsession indicado existe en la base de datos y no sea falso
     */
	public boolean existeIdSesion(String idSesion) {
		Query consulta = em.createQuery("Select m.nIdSesion from Simsesion m where m.nIdSesion=:sesion");
   	 	consulta.setParameter("sesion", Integer.parseInt(idSesion));
   	 	try {
	   	 	if(consulta.getSingleResult()!=null){
	   	 		System.out.println("SI EXISTE... ES VALIDO");
	   	 		return true;
	   	 	}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Usuario no autenticado. IdSesion no corresponde");
		}
		throw new RuntimeException("Usuario no autenticado. IdSesion no corresponde");
	}

}
