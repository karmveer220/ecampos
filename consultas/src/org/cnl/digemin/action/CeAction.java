package org.cnl.digemin.action;

import gob.min.digemin.ejb.Simcarnetextranjeria1;
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
import org.cnl.digemin.service.CeService;
import org.cnl.digemin.service.ImagenService;
import org.cnl.digemin.service.PersonaService;
import org.cnl.digemin.utiles.Utiles;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class CeAction extends DispatchAction {

	private static final Logger logger = Logger.getLogger(CeAction.class);
    private BeanPersona usrLogin;
    
    private CeService ceService;
    private ImagenService imagenService;
    private PersonaService personaService;    
    public void setCeService(CeService ceService) {
		this.ceService = ceService;
	}
	public void setImagenService(ImagenService imagenService) {
		this.imagenService = imagenService;
	}
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public ActionForward inicio(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
           HttpSession session = request.getSession();
           removerSession(session,"listaPersonas","listaCEPersona","listaImagenesCE");
           return mapping.findForward("buscar");
       }
       
    public ActionForward buscarCe(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        logger.debug("bsucar");
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
                Simcarnetextranjeria1 ce = ceService.CarnetExtranjeriaLeerNro(nro,new BeanAuditoria( usrLogin.getNcodigo().intValue() ),usrLogin.getIdSession());
                if(ce == null){
                    removerSession(session,"listaCEPersona","listaImagenesCE");
                    request.setAttribute("msgError", "El número ingresado no coincide con ninguún Carnet de Extranjería.");
                    return mapping.findForward("buscar");
                }
                lista.add(ce);
                session.setAttribute("listaCEPersona", lista);

                if(ce.getCantidad()>1){
                    request.setAttribute("otrosDocs",ce.getCantidad());
                }
                
                Simpersona1 persona = personaService.obtenerDatosPersona(ce.getUIdPersona(),new BeanAuditoria(usrLogin.getNcodigo().intValue()),usrLogin.getIdSession());  
                session.setAttribute("extranjero", persona );
                
                String t_img[] = {"ID","II"};
                List<String> limagenes = imagenService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacionalidad().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo().intValue()),usrLogin.getIdSession());
                if(limagenes==null || limagenes.size()==0){
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
                    return mapping.findForward("buscar");
            }
                
            if(Utiles.nullToBlank(miform.getSnombre()).equals("")){
                removerSession(session,"listaPersonas","listaCEPersona","listaImagenesCE");
                 if(Utiles.nullToBlank(miform.getSpaterno()).equals("") || Utiles.nullToBlank(miform.getSmaterno()).equals("")){
                     request.setAttribute("msgError", "Ingrese el nombre de la persona para realizar la consulta.");
                     return mapping.findForward("buscar");
                 }
            }
            List<Simpersona1> listaPersonas = personaService.listaPersonas(Utiles.nullToBlank(miform.getSnombre()), Utiles.nullToBlank(miform.getSpaterno()), Utiles.nullToBlank(miform.getSmaterno()),false,coincidirAlInicio,new BeanAuditoria(usrLogin.getNcodigo().intValue()),usrLogin.getIdSession());
            session.setAttribute("listaPersonas", listaPersonas);
            return mapping.findForward("buscar");
            
        }catch(Exception e){
            request.setAttribute("msgError", e.getMessage());
            e.printStackTrace();
            return mapping.findForward("buscar");
        }
       
    }
    
    public ActionForward ceDetalle(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        HttpSession session = request.getSession();
        usrLogin = (BeanPersona)session.getAttribute("usrLogin");
        
        String path = ""+this.servlet.getServletContext().getRealPath("/");        
       try{           
            
            String id = request.getParameter("uid");
            Simpersona1 persona = personaService.obtenerDatosPersona(id,new BeanAuditoria(usrLogin.getNcodigo().intValue()),usrLogin.getIdSession());
            if(persona==null){
                removerSession(session,"extranjero","listaCEPersona","listaImagenesCE");
                request.setAttribute("msgError", "No se pudo obtener información de la persona.");
                return mapping.findForward("ceDetalle");
            }
            session.setAttribute("extranjero", persona );
            
            List<Simcarnetextranjeria1> lis_carnet =  ceService.obtenerListaCeporUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo().intValue()),usrLogin.getIdSession());
            if(lis_carnet.size()==0){
                removerSession(session,"listaCEPersona","listaImagenesCE");
                request.setAttribute("msgError", "La persona no cuenta con ningún Carnet de Extranjería registrado.");
                return mapping.findForward("ceDetalle");
            }
            session.setAttribute("listaCEPersona",lis_carnet);
            
            String t_img[] = {"ID","II"};
            List<String> lis_imagenes = imagenService.MCMImagenBuscarUltimasPorIdPersona(persona.getUIdPersona(),persona.getPaisNacionalidad().getSIdPais(),"",t_img,path,new BeanAuditoria(usrLogin.getNcodigo().intValue()),usrLogin.getIdSession());
            if(lis_imagenes==null || lis_imagenes.size()==0){
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
            
            List<Simcarnetextranjeria1> lis_carnet =  ceService.obtenerListaCeporUidPersona(id,new BeanAuditoria(usrLogin.getNcodigo().intValue()),usrLogin.getIdSession());
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
