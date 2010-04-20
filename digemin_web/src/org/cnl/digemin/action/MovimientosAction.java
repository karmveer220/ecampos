package org.cnl.digemin.action;

import gob.min.digemin.ejb.entitiesWeb.Simcarnetextranjeria1;
import gob.min.digemin.ejb.entitiesWeb.Simmovmigra1;
import gob.min.digemin.ejb.entitiesWeb.Simpersona1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.form.BuscarPersonasForm;
import org.cnl.digemin.service.CeService;
import org.cnl.digemin.service.MovimientoService;
import org.cnl.digemin.service.PersonaService;
import org.cnl.digemin.utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * Esta clase se encarga de hacer la busqueda de movimientos migratorios segun el
 * numero de documento ingresado en la pantalla
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class MovimientosAction extends DispatchAction{
   
    private Logger logger = Logger.getLogger(MovimientosAction.class);
    private BeanPersona usrLogin;
    @Autowired
    private CeService ceServicio;
    @Autowired
    private PersonaService pservicio;
    @Autowired
    private MovimientoService movService;
    
    public ActionForward inicio(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
           HttpSession session = request.getSession();
           removerSession(session,"listaPersonas","listaCEPersona","listaImagenesCE");
           return mapping.findForward("m_inicio");       
    }
    
    public ActionForward movimientosDetalle(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
         try{
         
         }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
            return mapping.findForward("m_inicio"); 
         }
         return mapping.findForward("m_detalle");       
    }
    
     public ActionForward buscarMovimientos(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          try{
            logger.debug(form);
          }catch(Exception e){
             e.printStackTrace();
             request.setAttribute("msgError",e.getMessage());
          }
          return mapping.findForward("m_inicio");       
     }
     
     
     /**
     * Metodo que se usa cuando se da clic sobre el boton bsucar en la pantalla de busqueda</br>
     * cuando se han ingresado los datos de la persona de la cual se quieren ver los movimientos migratorios.</br>
     * Con esto solo se entrega una lsita de personas cuyos nombres o docuentos coinciden con los indicados</br>
     * Luego de esto, el usuario deberá seleccionar la persona y/o documento para ver los movimientos.</br>
     * Ai la busqueda se realiza por nombre entonces que haga un join con la tabla documento y que muestre la</br>
     * info de la persona mas el numero de documento (Pasaporte o carnet de extranjeria) vigente
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward buscarPersonas(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        System.out.println("---EN EL buscar personas del movimiento migraotorio---");
        BuscarPersonasForm miform=(BuscarPersonasForm)form; 
        
        List<Simmovmigra1> listaMov = null;
        usrLogin = (BeanPersona)request.getSession().getAttribute("usrLogin");
         try{
             Simpersona1 persona=null;
             //Obtener movimientos migratorios a partir de un numero de carnet de extranjeria
              if(!Utiles.nullToBlank(miform.getSnroce()).equals("")){
              System.out.println("-------BUSQUEDA con numero de CARNET EXTRANJERIA-------");
                  
                  Simcarnetextranjeria1 ce = ceServicio.CarnetExtranjeriaLeerNro(miform.getSnroce(),new BeanAuditoria(usrLogin.getNcodigo(),usrLogin.getSusuario()),usrLogin.getIdSession());
                  if(ce == null){
                      removerSession(request.getSession(),"m_listaMovimientos","m_listaPersonas");
                      request.setAttribute("msgError", "El número ingresado no coincide con ninguún Carnet de Extranjería.");
                      return mapping.findForward("m_inicio");
                  }
                 
                  listaMov = movService.listaDeMovimientosNumeroDocumento(miform.getSnroce(),new BeanAuditoria(usrLogin.getNcodigo(),usrLogin.getSusuario()),usrLogin.getIdSession());
                  request.getSession().setAttribute("m_listaMovimientos", listaMov);
                  persona = pservicio.obtenerDatosPersona(ce.getUIdPersona(),new BeanAuditoria(usrLogin.getNcodigo(),usrLogin.getSusuario()),usrLogin.getIdSession());  
                  request.getSession().setAttribute("m_persona", persona );
               }
             
             if(!Utiles.nullToBlank(miform.getSnropas()).equals("")){
                 System.out.println("----OBTENER la lista de movimeintos migratorios a partir de un numero de PASAPORTE entregado-----");
                 
                 listaMov = movService.listaDeMovimientosNumeroDocumento(Utiles.nullToBlank(miform.getSnropas()),new BeanAuditoria(usrLogin.getNcodigo(),usrLogin.getSusuario()),usrLogin.getIdSession());                 
                 request.getSession().setAttribute("m_listaMovimientos", listaMov);
                 persona = pservicio.obtenerDatosPersonaPorPasaporte(miform.getSnropas(),new BeanAuditoria(usrLogin.getNcodigo(),usrLogin.getSusuario()),usrLogin.getIdSession());
                 request.getSession().setAttribute("m_persona", persona );
              }
             
             if( persona==null ){
                 removerSession(request.getSession(),"m_persona","m_listaMovimientos","m_listaPersonas");
                 request.setAttribute("msgError", "No se pudo obtener información de la persona.");
                 return mapping.findForward("m_inicio");
             }
             System.out.println("---PERSONA--- " + Utiles.nullToBlank(persona.getSNombre()));
             return mapping.findForward("m_detalle");
         }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msgError",e.getMessage());
         }
        return mapping.findForward("m_inicio");
    }
    /**
     * Elimina de session los elemntos entregados
     * @param session la referencia al HTTPSESSION
     * @param elementos arreglo o lista de elemtnos que deben ser eliminados de la session
     */
    public void removerSession(HttpSession session,String... elementos){
        for(String s : elementos){
            session.removeAttribute(s);
        }
    }
}
