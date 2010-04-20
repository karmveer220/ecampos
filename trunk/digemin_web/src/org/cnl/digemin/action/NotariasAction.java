package org.cnl.digemin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.cnl.digemin.bean.BeanNotaria;
import org.cnl.digemin.bean.BeanPersona;
import org.cnl.digemin.service.NotariaService;
import org.cnl.digemin.utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since MAYO 2009
 * @version 2.0
 */
public class NotariasAction extends DispatchAction {
   
    private Logger logger = Logger.getLogger(NotariasAction.class);
    private BeanPersona usrLogin;
    @Autowired
    private NotariaService notariasService;
    
    public ActionForward lista(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          try{
                logger.debug("lista de notarias");
                List<BeanNotaria> lista = notariasService.listaComboNotarias(usrLogin.getNnotaria().getNcodigo());
                request.getSession().setAttribute("listaNotarias", lista);
                request.getSession().setAttribute("comboNotarias", lista);
          }catch(Exception e){
                e.printStackTrace();
                request.setAttribute("msgError",e.getMessage());
          }
        return mapping.findForward("not_inicio");
    }
    
    public ActionForward buscar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          try{
                logger.debug("buscar ntoarias");
                String nombre = Utiles.nullToBlank(request.getParameter("snombre"));
                request.getSession().setAttribute("listaNotarias",notariasService.buscarnotarias(nombre));
                
          }catch(Exception e){
                e.printStackTrace();
                request.setAttribute("msgError",e.getMessage());
          }
        return mapping.findForward("not_inicio");
    }
    
    public ActionForward preModificar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          try{
              logger.debug("pre modificar");
              String cod = Utiles.nullToBlank(request.getParameter("not"));
              request.getSession().setAttribute("m_notaria",notariasService.obtenerNotaria(cod));
          }catch(Exception e){
              e.printStackTrace();
              request.setAttribute("msgError",e.getMessage());
              return mapping.findForward("not_inicio");
          }
        return mapping.findForward("not_edit");
    }
 
    public ActionForward modificar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          try{
              System.out.println("en el modificar");
              usrLogin = (BeanPersona) request.getSession().getAttribute("usrLogin");
              DynaActionForm myform = (DynaActionForm)form;
              BeanNotaria notaria = (BeanNotaria)request.getSession().getAttribute("m_notaria");
              notaria.setSdireccion(Utiles.nullToBlank(myform.get("sdireccion")));
              notaria.setSemail(Utiles.nullToBlank(myform.get("semail")));
              notaria.setSfax(Utiles.nullToBlank(myform.get("sfax")));
              notaria.setSnombre(Utiles.nullToBlank(myform.get("snombre")));
              notaria.setStelefono(Utiles.nullToBlank(myform.get("stelefono")));
              notaria.setNnotario(Utiles.nullToBlank(myform.get("nnotario")));
              notariasService.modificaNotaria(notaria);
              request.setAttribute("mensaje","Notaria modificada");
              request.getSession().removeAttribute("comboNotarias");
              request.getSession().removeAttribute("m_notaria");
              return lista(mapping,form,request,response);
          }catch(Exception e){
              e.printStackTrace();
              request.setAttribute("msgError",e.getMessage());
              return mapping.findForward("not_edit");
          }
    }
    
    public ActionForward cancelaModificar(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          logger.debug("cancela modificar");
          request.getSession().removeAttribute("m_notaria");
          return mapping.findForward("not_inicio");
    }
    
    
    public ActionForward preNuevo(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        logger.debug("pre nuevo");
        request.getSession().setAttribute("n_notaria",new BeanNotaria());
        return mapping.findForward("not_nuevo");
    }
    
    public ActionForward nuevo(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          try{
              System.out.println("en el nuevo");
              usrLogin = (BeanPersona) request.getSession().getAttribute("usrLogin");
              DynaActionForm myform = (DynaActionForm)form;
              BeanNotaria notaria = (BeanNotaria)request.getSession().getAttribute("n_notaria");
              notaria.setSdireccion(Utiles.nullToBlank(myform.get("sdireccion")));
              notaria.setSemail(Utiles.nullToBlank(myform.get("semail")));
              notaria.setSfax(Utiles.nullToBlank(myform.get("sfax")));
              notaria.setSnombre(Utiles.nullToBlank(myform.get("snombre")));
              notaria.setStelefono(Utiles.nullToBlank(myform.get("stelefono")));
              notaria.setNnotario(Utiles.nullToBlank(myform.get("nnotario")));
              notariasService.grabaNotaria(notaria);
              request.setAttribute("mensaje","Notaria registrada");
              request.getSession().removeAttribute("comboNotarias");
              request.getSession().removeAttribute("n_notaria");
              return lista(mapping,form,request,response);
          }catch(Exception e){
              e.printStackTrace();
              request.setAttribute("msgError",e.getMessage());
              return mapping.findForward("not_nuevo");
          }
    }
    
    public ActionForward cancelaNuevo(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
          logger.debug("cancela nuevo");
          request.getSession().removeAttribute("n_notaria");
          return mapping.findForward("not_inicio");
    }
}
