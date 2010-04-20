package org.cnl.digemin.action;


import gob.min.digemin.ejb.Simpasaporte1;
import gob.min.digemin.ejb.Simpersona1;

import java.util.ArrayList;
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
import org.cnl.digemin.service.ImagenService;
import org.cnl.digemin.service.PasaporteService;
import org.cnl.digemin.service.PersonaService;
import org.cnl.digemin.utiles.Utiles;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class PasaporteAction extends DispatchAction{

	private static final Logger logger = Logger.getLogger(PasaporteAction.class);
    private BeanPersona usrLogin;
    
    public ActionForward inicio(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
            HttpSession session = request.getSession();
            removerSession(session,"listaPersonas","listaPasaportePersona","listaImagenesPasaporte");
            return mapping.findForward("lista");
      }
      
    public ActionForward buscarPasaporte(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session = request.getSession();
        String path = ""+this.servlet.getServletContext().getRealPath("/");
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        BuscarPersonasForm miform=(BuscarPersonasForm)form; 
        String nro =  miform.getSnroce();
        PasaporteService servicio = new PasaporteService();
        ImagenService imgService = null;
        boolean coincidirAlInicio = false;
        try{
        
            if(Utiles.nullToBlank(miform.getCoincidir()).equals("0")){
                coincidirAlInicio = true;
            }
            
            if(!Utiles.nullToBlank(nro).equals("")){
                List<Simpasaporte1> lista = new ArrayList<Simpasaporte1>();
                Simpasaporte1 pasaporte = servicio.PasaporteLeerNro(nro,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
                if(pasaporte == null){
                    removerSession(session,"listaPasaportePersona","listaImagenesPasaporte");
                    request.setAttribute("msgError", "El número ingresado no coincide con ninguún Pasaporte.");
                    return mapping.findForward("lista");
                }
                logger.debug("pasaporte en request");
                lista.add(pasaporte);
                session.setAttribute("listaPasaportePersona", lista);
                
                //TODO: la cantidad de otros docs debe queedar en el request no en el session
                if(pasaporte.getCantidad() > 1){
                    request.setAttribute("otrosDocs",pasaporte.getCantidad());
                }
                PersonaService pservicio =new PersonaService();
                Simpersona1 persona = pservicio.obtenerDatosPersonaPorPasaporte(nro,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
                if( persona==null ){
                    //session.removeAttribute("extranjero");
                    removerSession(session,"extranjero","listaPasaportePersona","listaImagenesPasaporte");
                    request.setAttribute("msgError", "No se pudo obtener información de la persona.");
                    return mapping.findForward("lista");
                }
                session.setAttribute("extranjero", persona );
                imgService = new ImagenService();
                String t_img[] = {};
                List<String> limagenes = imgService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacimiento().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
                if( limagenes==null || limagenes.size()==0){
                    session.removeAttribute("listaImagenesPasaporte");
                    request.setAttribute("msgError", "La persona no tiene imagenes registradas.");
                    return mapping.findForward("detalle");
                }
                logger.debug("lista de imagenes en request");
                session.setAttribute("listaImagenesPasaporte",limagenes);
                return mapping.findForward("detalle");
            }
            
            if(Utiles.nullToBlank(miform.getSpaterno()).equals("") && Utiles.nullToBlank(miform.getSmaterno()).equals("")){
                    session.removeAttribute("listaPersonas");
                    request.setAttribute("msgError", "La búsqueda requiere un campo más (Apellido Paterno o Materno ).");
                    return mapping.findForward("lista");
                }
                
            if(Utiles.nullToBlank(miform.getSnombre()).equals("")){
                if(Utiles.nullToBlank(miform.getSpaterno()).equals("") || Utiles.nullToBlank(miform.getSmaterno()).equals("")){
                    session.removeAttribute("listaPersonas");
                    request.setAttribute("msgError", "Ingrese el nombre de la persona para realizar la consulta.");
                    return mapping.findForward("lista");
                }
            }
            
            PersonaService pservicio = new PersonaService();
            List<Simpersona1> listaPersonas = pservicio.listaPersonas(Utiles.nullToBlank(miform.getSnombre()), Utiles.nullToBlank(miform.getSpaterno()), Utiles.nullToBlank(miform.getSmaterno()),true,coincidirAlInicio,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            session.setAttribute("listaPersonas", listaPersonas);
            return mapping.findForward("lista");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("lista");
        }
       
    }
    
    public ActionForward pasaporteDetalle(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        
        HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        String path = ""+this.servlet.getServletContext().getRealPath("/");
        PersonaService pservicio = null;
        ImagenService imgService = null;
        try{
            logger.debug("pasaporte detalle dentro del try");
            pservicio =new PersonaService();
            String id = request.getParameter("uid");
            Simpersona1 persona = pservicio.obtenerDatosPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(persona==null){
                removerSession(session,"extranjero","listaPasaportePersona","listaImagenesPasaporte");
                request.setAttribute("msgError", "No se pudo obtener información de la persona.");
                return mapping.findForward("lista");
            }
            logger.debug("persona en request");
            session.setAttribute("extranjero", persona );
            PasaporteService servicio = new PasaporteService();
            List<Simpasaporte1> lis_pass =  servicio.obtenerListaPasaportePorUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_pass.size()==0){
                removerSession(session,"listaPasaportePersona","listaImagenesPasaporte");
                request.setAttribute("msgError", "La persona no cuenta con ningún Pasaporte registrado.");
                return mapping.findForward("detalle");
            }
            logger.debug("pasaporte en request");
            session.setAttribute("listaPasaportePersona",lis_pass);
            imgService = new ImagenService();
            String t_img[] = {};
            List<String> lis_imagenes = imgService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacimiento().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if( lis_imagenes==null || lis_imagenes.size()==0){
                session.removeAttribute("listaImagenesPasaporte");
                request.setAttribute("msgError", "La persona no tiene imagenes registradas.");
                return mapping.findForward("detalle");
            }
            //System.out.println("imafgenbes en request");
            session.setAttribute("listaImagenesPasaporte", lis_imagenes);
            return mapping.findForward("detalle");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("detalle");
        }
    }
    
    public ActionForward pasaporteDetalle2(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
    
        HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        try{           
            String id = request.getParameter("uid");
          
            PasaporteService servicio = new PasaporteService();
            List<Simpasaporte1> lis_pass =  servicio.obtenerListaPasaportePorUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_pass.size()==0){
                removerSession(session,"listaPasaportePersona","listaImagenesPasaporte");
                //session.removeAttribute("listaPasaportePersona");
                request.setAttribute("msgError", "La persona no cuenta con ningún Pasaporte registrado.");
                return mapping.findForward("detalle");
            }
            session.setAttribute("listaPasaportePersona",lis_pass);
          
            return mapping.findForward("detalle");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("detalle");
        }
    }
    
    public void removerSession(HttpSession session,String... elementos){
        for(String s : elementos){
            session.removeAttribute(s);
        }
    }
}
