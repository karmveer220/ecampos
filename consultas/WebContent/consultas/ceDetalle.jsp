<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="org.cnl.digemin.utiles.Utiles"%>
<%@page import="gob.min.digemin.ejb.Simpersona1"%>
<%@page import="gob.min.digemin.ejb.Simpais1"%>
<%@page import="gob.min.digemin.ejb.Simcarnetextranjeria1"%>
<%
    Simpersona1 estranjero = (Simpersona1)session.getAttribute("extranjero");
    Simpais1 paisNac = estranjero.getPaisNacionalidad();
%>

    <link href="css/estilos.css" rel="stylesheet" type="text/css">
    <link href="css/lightbox.css" rel="stylesheet" type="text/css" media="screen" />
	<script src="js/prototype.js" type="text/javascript"></script>
	<script src="js/scriptaculous.js?load=effects" type="text/javascript"></script>
	<script src="js/lightbox.js" type="text/javascript"></script>
	<SCRIPT language="JavaScript" type="text/javascript">
             function imprimir(){ 
                var features = "Width=700,Height=500,status=yes,toolbar=no,top=10,left=150,menubar=no,location=no,scrollbars=yes";
                window.open("consultas/print_ce.jsp","carga",features);
            }
              
            function detalle(){
                document.forms[0].submit();
            }
	</SCRIPT>
 
	<html:form action="/ce">
	   <input type="hidden" name="method" value="ceDetalle2"/>
	   <input type="hidden" name="uid" value="<bean:write name="extranjero" property="UIdPersona"/>"/>
	   
	 <div style="float:right"><a href="javascript:imprimir();"> <img src="images/tb_print.gif" alt="imprimir" width="22" height="30" longdesc="imprimir detalle" border="0">	</a></div>
	
      <table width="600px"  cellpadding="4" cellspacing="0" class="tFormulario">
          <tr>
            <th width="36%" >Nombres</th>
            <td width="64%">
                <bean:write name="extranjero" property="SNombre"/>&nbsp;
                <bean:write name="extranjero" property="SPaterno"/>&nbsp;
                <bean:write name="extranjero" property="SMaterno"/>
            </td>
          </tr>
          <tr>
            <th>Fecha de Nacimiento</th>
            <td><%=Utiles.CalendarToString((((Simpersona1)estranjero).getDFechaNacimiento()),"dd/MM/yyyy")%>&nbsp;</td>
          </tr>
          <tr>
            <th>Sexo</th>
            <td><%=Utiles.descripcionSexo(((Simpersona1)estranjero).getSSexo())%>&nbsp;</td>
          </tr>
          <tr>
            <th>Nacionalidad</th>
            <td><%=paisNac.getSNacionalidad()%>&nbsp;</td>
          </tr>
             <tr>
                <td colspan="2" align="center">      
				
                    <logic:present name="otrosDocs">
                        <div id="moreDocs"><a href="javascript:detalle();">Mostrar los <bean:write name="otrosDocs"/> documentos de la persona</a></div>
                    </logic:present>
	              
                    <logic:present name="listaCEPersona">
                    <table width="95%" cellpadding="0" cellspacing="0" class="tLista">
                        <tr>
                          <th>Nro. CE</th>
                          <th>Fecha Emisi&oacute;n</th>
                          <th>Fecha de Caducidad</th>
                        </tr>
                        <logic:iterate id="carne" name="listaCEPersona">
                          <tr valign="middle" >
                                <td><bean:write name="carne" property="SNumeroCarnet"/>&nbsp;</td>
                                <td><%=Utiles.CalendarToString(((Simcarnetextranjeria1)carne).getDFechaEmision(),"dd/MM/yyyy")%>&nbsp;</td>
                                <td><%=Utiles.CalendarToString(((Simcarnetextranjeria1)carne).getDFechaCaducidad(),"dd/MM/yyyy")%>&nbsp;</td>
                          </tr>
                        </logic:iterate>
                    </table>
                    </logic:present>                            
               </td>
            </tr>
            <logic:present name="listaImagenesCE">
             <tr>
                 <td colspan="2" align="center">
                      <table cellpadding="3" cellspacing="0" border="0">
                            <tr>
                                <logic:iterate id="nombreim" name="listaImagenesCE">
                                    <td>
                                      <div class="wrap0"><div class="wrap1"><div class="wrap2"><div class="wrap3">
                                               <a href="<bean:write name="nombreim"/>" rel="lightbox[roadtrip]"><img  width="100px" border="0" height="100px" src="<bean:write name="nombreim"/>"/></a>
                                        </div></div></div></div>
                                    </td>
                                </logic:iterate>
                            </tr>
                   </table>
               </td>
              </tr> 
        </logic:present>
    </table>  
    
    <div  id="message_warnig"><bean:message key="welcome.message.warning"/></div>
    
     </html:form>