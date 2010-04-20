<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="org.cnl.digemin.utiles.Utiles"%>
<%@page import="gob.min.digemin.ejb.entitiesWeb.Simpasaporte1"%>
<%@page import="gob.min.digemin.ejb.entitiesWeb.Simpersona1"%>
<%
    Simpersona1 estranjero = (Simpersona1)session.getAttribute("extranjero");
%>
<html:html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><bean:message key="welcome.title"/> - Detalle De Pasaportes</title>
        <html:base/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css">
        <link href="css/lightbox.css" rel="stylesheet" type="text/css" media="screen" />
            <script src="js/prototype.js" type="text/javascript"></script>
            <script src="js/scriptaculous.js?load=effects" type="text/javascript"></script>
            <script src="js/lightbox.js" type="text/javascript"></script>
		<link href="greybox/gb_styles.css" rel="stylesheet" type="text/css" media="all" />	
			<script src="greybox/AJS.js" type="text/javascript"></script>
            <script src="greybox/AJS_fx.js" type="text/javascript"></script>
            <script src="greybox/gb_scripts.js" type="text/javascript"></script>
		
            <SCRIPT language="JavaScript" type="text/javascript">
                function imprimir(){ 
                    var features = "Width=700,Height=500,status=yes,toolbar=no,top=10,left=150,menubar=no,location=no,scrollbars=yes";
                    window.open("print_pas.jsp","carga",features);
                }
                function detalle(){
                    document.forms[0].submit();
                }  
			  
            </SCRIPT>
				
             

  </head>
  
<body>

<div id="contenedor">
        
<div  id="cuerpo">
	
	
	 <html:form action="/pasaporte.do">
           <input type="hidden" name="method" value="pasaporteDetalle2"/>
            
   
	<div id="titulo">Datos de la Persona</div>
        
        <logic:present name="msgError">
                <div id="error"><bean:write name="msgError" scope="request"/></div><br />
        </logic:present>
		<logic:present name="mensaje">
                <div id="mensaje"><bean:write name="mensaje" scope="request"/></div><br />
        </logic:present>
		
		<div style="float:right">
			<a href="javascript:imprimir();">
				<img src="images/tb_print.gif" alt="imprimir" width="22" height="30" longdesc="imprimir detalle" border="0">
			</a>
		</div>
	
    <logic:present name="extranjero">
	 <input type="hidden" name="uid" value="<bean:write name="extranjero" property="UIdPersona"/>"/> 
        <table width="600px" cellpadding="4" cellspacing="0" class="tFormulario">
            <tr>
                <th width="36%">Nombres</th>
                <td width="64%"><bean:write name="extranjero" property="SNombre"/>&nbsp;
                                <bean:write name="extranjero" property="SPaterno"/>&nbsp;
                                <bean:write name="extranjero" property="SMaterno"/></td>
            </tr>
            <tr>
                <th>Fecha de Nacimiento</th>
                <td><%=Utiles.CalendarToString(((Simpersona1)estranjero).getDFechaNacimiento(),"dd/MM/yyyy")%>&nbsp;</td>
            </tr>
            <tr>
            <th>Sexo</th>
            <td><%=Utiles.descripcionSexo(((Simpersona1)estranjero).getSSexo())%>&nbsp;</td>
          </tr>
          <tr>
            <th>Documento de Identidad</th>
            <td><bean:write name="extranjero" property="SIdDocIdentidad"/>:<bean:write name="extranjero" property="SNumDocIdentidad"/>&nbsp;</td>
          </tr>
            <tr>
            <td colspan="2" align="center">
			
				<logic:present name="otrosDocs">
					<div id="moreDocs"><a href="javascript:detalle();">Mostrar los <bean:write name="otrosDocs"/> documentos de la persona</a></div>
				</logic:present>
					
                <logic:present name="listaPasaportePersona">
                  <table width="95%" cellpadding="0" cellspacing="0" class="tLista">
                        <tr>
                          <th>Nro. Pasaporte</th>
                          <th>Estado</th>
                          <th>Fecha Emisi&oacute;n</th>
                          <th>Fecha de Expiraci&oacute;n</th>
                          <th>Otro Documento</th>
                        </tr>
                        <logic:iterate id="pasaporte" name="listaPasaportePersona">
                          <tr valign="middle" >
                                <td><bean:write name="pasaporte" property="SPasNumero"/>&nbsp;</td>
                                <td><%=Utiles.descripcionEstadoPasaporte(((Simpasaporte1)pasaporte).getSEstadoActual())%>&nbsp;</td>
                                <td><%=Utiles.CalendarToString(((Simpasaporte1)pasaporte).getDFechaEmision(),"dd/MM/yyyy")%>&nbsp;</td>
                                <td><%=Utiles.CalendarToString(((Simpasaporte1)pasaporte).getDFechaExpiracion(),"dd/MM/yyyy")%>&nbsp;</td>
                                <td><bean:write name="pasaporte" property="SIdDocumento"/>:&nbsp;<bean:write name="pasaporte" property="SNumeroDoc"/>&nbsp;</td>
                          </tr>
                        </logic:iterate>
                  </table>
                </logic:present>
            </td>
           </tr>
            <logic:present name="listaImagenesPasaporte">
			   <tr>
				<td colspan="2" align="center">
                  <table cellpadding="3" cellspacing="0" border="0">
                        <tr>
                            <logic:iterate id="nombreim" name="listaImagenesPasaporte">
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
        
    </logic:present>
	
	  </html:form>
	
</div>

</div>

</body>
</html:html>