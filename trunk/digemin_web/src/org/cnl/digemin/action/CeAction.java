package org.cnl.digemin.action;

import gob.min.digemin.ejb.entitiesWeb.Simcarnetextranjeria1;
import gob.min.digemin.ejb.entitiesWeb.Simpersona1;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.cnl.digemin.bean.BeanAuditoria;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.form.BuscarPersonasForm;
import org.cnl.digemin.service.CeService;
import org.cnl.digemin.service.ImagenService;
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
public class CeAction extends DispatchAction {

    
    
    private BeanPersona usrLogin;
  
    @Autowired
    private CeService servicio;
    @Autowired
    private ImagenService imgService;
    @Autowired
    private PersonaService pservicio;
    
    public ActionForward inicio(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
    	    HttpSession session = request.getSession();
           removerSession(session,"listaPersonas","listaCEPersona","listaImagenesCE");
           return mapping.findForward("inicio");
       }
       
    public ActionForward buscarCe(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {

    	HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        
        String path = ""+this.servlet.getServletContext().getRealPath("/");
        BuscarPersonasForm miform=(BuscarPersonasForm)form; 
        String nro =  miform.getSnroce();
        boolean coincidirAlInicio = false;
        try{
        
            if(Utiles.nullToBlank(miform.getCoincidir()).equals("0")){
                coincidirAlInicio = true;
            }
            
            if(!Utiles.nullToBlank(nro).equals("")){
                ArrayList<Simcarnetextranjeria1> lista = new ArrayList<Simcarnetextranjeria1>();
                
                Simcarnetextranjeria1 ce = servicio.CarnetExtranjeriaLeerNro(nro,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
                if(ce == null){
                    removerSession(session,"listaCEPersona","listaImagenesCE");
                    request.setAttribute("msgError", "El número ingresado no coincide con ninguún Carnet de Extranjería.");
                    return mapping.findForward("error");
                }
                lista.add(ce);
                session.setAttribute("listaCEPersona", lista);

                if(ce.getCantidad()>1){
                    request.setAttribute("otrosDocs",ce.getCantidad());
                }
                
                Simpersona1 persona = pservicio.obtenerDatosPersona(ce.getUIdPersona(),new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());  
                session.setAttribute("extranjero", persona );
                String t_img[] = {"ID","II"};
                List<String> limagenes = imgService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacionalidad().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
                if(limagenes.size()==0){
                    session.removeAttribute("listaImagenesCE");
                    request.setAttribute("msgError", "La persona no tiene imagenes registradas.");
                    return mapping.findForward("ceDetalle");
                }
                session.setAttribute("listaImagenesCE",limagenes);
                return mapping.findForward("ceDetalle");
            }
            
            if(Utiles.nullToBlank(miform.getSpaterno()).equals("") && Utiles.nullToBlank(miform.getSmaterno()).equals("")){
                removerSession(session,"listaPersonas","listaCEPersona","listaImagenesCE");
                    request.setAttribute("msgError", "La búsqueda requiere un campo más (Apellido Paterno o Materno ).");
                    return mapping.findForward("error");
            }
                
            if(Utiles.nullToBlank(miform.getSnombre()).equals("")){
                removerSession(session,"listaPersonas","listaCEPersona","listaImagenesCE");
                 if(Utiles.nullToBlank(miform.getSpaterno()).equals("") || Utiles.nullToBlank(miform.getSmaterno()).equals("")){
                     request.setAttribute("msgError", "Ingrese el nombre de la persona para realizar la consulta.");
                     return mapping.findForward("error");
                 }
            }
            List<Simpersona1> listaPersonas = pservicio.listaPersonas(Utiles.nullToBlank(miform.getSnombre()), Utiles.nullToBlank(miform.getSpaterno()), Utiles.nullToBlank(miform.getSmaterno()),false,coincidirAlInicio,new BeanAuditoria(123L),"ecampos");
            session.setAttribute("listaPersonas", listaPersonas);
            return mapping.findForward("exito");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("exito");
        }
       
    }
    
    public ActionForward ceDetalle(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        
        String path = ""+this.servlet.getServletContext().getRealPath("/");
       
       try{           
          
            String id = request.getParameter("uid");
            Simpersona1 persona = pservicio.obtenerDatosPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(persona==null){
                removerSession(session,"extranjero","listaCEPersona","listaImagenesCE");
                request.setAttribute("msgError", "No se pudo obtener información de la persona.");
                return mapping.findForward("ceDetalle");
            }
            session.setAttribute("extranjero", persona );
            List<Simcarnetextranjeria1> lis_carnet =  servicio.obtenerListaCeporUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_carnet.size()==0){
                removerSession(session,"listaCEPersona","listaImagenesCE");
                request.setAttribute("msgError", "La persona no cuenta con ningún Carnet de Extranjería registrado.");
                return mapping.findForward("ceDetalle");
            }
            session.setAttribute("listaCEPersona",lis_carnet);
            String t_img[] = {"ID","II"};
            List<String> lis_imagenes = imgService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacionalidad().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_imagenes.size()==0){
                session.removeAttribute("listaImagenesCE");
                request.setAttribute("msgError", "La persona no tiene imagenes registradas.");
                return mapping.findForward("ceDetalle");
            }
            session.setAttribute("listaImagenesCE", lis_imagenes);
            return mapping.findForward("ceDetalle");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("ceDetalle");
        }
    }    
    public ActionForward ceDetalle2(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        
        HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
       
       try{
            String id = request.getParameter("uid");
            List<Simcarnetextranjeria1> lis_carnet =  servicio.obtenerListaCeporUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo()),usrLogin.getIdSession());
            if(lis_carnet.size()==0){
                removerSession(session,"listaCEPersona","listaImagenesCE");
                request.setAttribute("msgError", "La persona no cuenta con ningún Carnet de Extranjería registrado.");
                return mapping.findForward("ceDetalle");
            }
            session.setAttribute("listaCEPersona",lis_carnet);          
          
            return mapping.findForward("ceDetalle");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("ceDetalle");
        }
    }
    
    public void removerSession(HttpSession session,String... elementos){
        for(String s : elementos){
            session.removeAttribute(s);
        }
    }
}
