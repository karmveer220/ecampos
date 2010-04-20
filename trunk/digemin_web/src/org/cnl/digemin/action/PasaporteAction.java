package org.cnl.digemin.action;


import gob.min.digemin.ejb.entitiesWeb.Simpasaporte1;
import gob.min.digemin.ejb.entitiesWeb.Simpersona1;

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
import org.springframework.beans.factory.annotation.Autowired;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class PasaporteAction extends DispatchAction{

    private Logger logger = Logger.getLogger(PasaporteAction.class);
    
    private BeanPersona usrLogin;
    @Autowired
    private PasaporteService servicio;
    @Autowired
    private ImagenService imgService;
    @Autowired
    private PersonaService pservicio;
    
    public ActionForward inicio(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
            HttpSession session = request.getSession();
            removerSession(session,"listaPersonas","listaPasaportePersona","listaImagenesPasaporte");
            return mapping.findForward("inicio");
      }
      
    public ActionForward buscarPasaporte(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session = request.getSession();
        String path = ""+this.servlet.getServletContext().getRealPath("/");
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        BuscarPersonasForm miform=(BuscarPersonasForm)form; 
        String nro =  miform.getSnroce();
        
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
                    return mapping.findForward("pasaporte");
                }
                logger.debug("pasaporte en request");
                lista.add(pasaporte);
                session.setAttribute("listaPasaportePersona", lista);
                if(pasaporte.getCantidad() > 1){
                    request.setAttribute("otrosDocs",pasaporte.getCantidad());
                }
                Simpersona1 persona = pservicio.obtenerDatosPersonaPorPasaporte(nro,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
                if( persona==null ){
                    removerSession(session,"extranjero","listaPasaportePersona","listaImagenesPasaporte");
                    request.setAttribute("msgError", "No se pudo obtener información de la persona.");
                    return mapping.findForward("pasaporte");
                }
                session.setAttribute("extranjero", persona );
                String t_img[] = {};
                List<String> limagenes = imgService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacimiento().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
                if(limagenes.size()==0){
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
                    return mapping.findForward("error");
                }
                
            if(Utiles.nullToBlank(miform.getSnombre()).equals("")){
                if(Utiles.nullToBlank(miform.getSpaterno()).equals("") || Utiles.nullToBlank(miform.getSmaterno()).equals("")){
                    session.removeAttribute("listaPersonas");
                    request.setAttribute("msgError", "Ingrese el nombre de la persona para realizar la consulta.");
                    return mapping.findForward("error");
                }
            }
            List<Simpersona1> listaPersonas = pservicio.listaPersonas(Utiles.nullToBlank(miform.getSnombre()), Utiles.nullToBlank(miform.getSpaterno()), Utiles.nullToBlank(miform.getSmaterno()),true,coincidirAlInicio,new BeanAuditoria(123L),"ecampos");
            session.setAttribute("listaPersonas", listaPersonas);
            return mapping.findForward("pasaporte");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("pasaporte");
        }
       
    }
    
    public ActionForward pasaporteDetalle(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        
        HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        String path = ""+this.servlet.getServletContext().getRealPath("/");
        try{
            logger.debug("pasaporte detalle dentro del try");
            String id = request.getParameter("uid");
            Simpersona1 persona = pservicio.obtenerDatosPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(persona==null){
                removerSession(session,"extranjero","listaPasaportePersona","listaImagenesPasaporte");
                request.setAttribute("msgError", "No se pudo obtener información de la persona.");
                return mapping.findForward("pasaporte");
            }
            logger.debug("persona en request");
            session.setAttribute("extranjero", persona );
             List<Simpasaporte1> lis_pass =  servicio.obtenerListaPasaportePorUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_pass.size()==0){
                removerSession(session,"listaPasaportePersona","listaImagenesPasaporte");
                request.setAttribute("msgError", "La persona no cuenta con ningún Pasaporte registrado.");
                return mapping.findForward("detalle");
            }
            logger.debug("pasaporte en request");
            session.setAttribute("listaPasaportePersona",lis_pass);
            String t_img[] = {};
            List<String> lis_imagenes = imgService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacimiento().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_imagenes.size()==0){
                session.removeAttribute("listaImagenesPasaporte");
                request.setAttribute("msgError", "La persona no tiene imagenes registradas.");
                return mapping.findForward("detalle");
            }
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
            List<Simpasaporte1> lis_pass =  servicio.obtenerListaPasaportePorUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_pass.size()==0){
                removerSession(session,"listaPasaportePersona","listaImagenesPasaporte");
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
