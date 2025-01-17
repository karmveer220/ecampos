<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="org.cnl.digemin.utiles.Utiles"%>
<%@page import="gob.min.digemin.ejb.entitiesWeb.Simpersona1"%>
<%@page import="gob.min.digemin.ejb.entitiesWeb.Simmovmigra1"%>
<%
    Simpersona1 m_persona = (Simpersona1)session.getAttribute("m_persona");
%>
<html:html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Detalle De Movimientos</title>
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
                    window.open("print_mov.jsp","carga",features);
                }
                function detalle(){
                    document.forms[0].submit();
                }  
			  
            </SCRIPT>
				
  </head>
  
<body>

<div id="contenedor">

<div  id="cuerpo">

	 <html:form action="/movimientos.do">
           <input type="hidden" name="method" value=""/>
            
   
	<div id="titulo">Datos de la Persona</div>
        
        <logic:present name="msgError">
                <div id="error"><bean:write name="msgError" scope="request"/></div><br />
        </logic:present>
        <logic:present name="mensaje">
                <div id="mensaje"><bean:write name="mensaje" scope="request"/></div><br />
        </logic:present>
        
	<div style="float:right"><a href="javascript:imprimir();"><img src="images/tb_print.gif" alt="imprimir" width="22" height="30" longdesc="imprimir detalle" border="0">	</a></div>
	
        <logic:present name="m_persona">
	 <input type="hidden" name="uid" value="<bean:write name="m_persona" property="UIdPersona"/>"/> 
        <table width="600px" cellpadding="4" cellspacing="0" class="tFormulario">
            <tr>
                <th width="36%">Nombres</th>
                <td width="64%"><bean:write name="m_persona" property="SNombre"/>&nbsp;
                                <bean:write name="m_persona" property="SPaterno"/>&nbsp;
                                <bean:write name="m_persona" property="SMaterno"/></td>
            </tr>
            <tr>
                <th>Fecha de Nacimiento</th>
                <td><%=Utiles.CalendarToString(((Simpersona1)m_persona).getDFechaNacimiento(),"dd/MM/yyyy")%>&nbsp;</td>
            </tr>
            <tr>
            <th>Sexo</th>
            <td><%=Utiles.descripcionSexo(((Simpersona1)m_persona).getSSexo())%>&nbsp;</td>
          </tr>
          <tr>
            <th>Documento de Identidad</th>
            <td><bean:write name="m_persona" property="SIdDocIdentidad"/>:<bean:write name="m_persona" property="SNumDocIdentidad"/>&nbsp;</td>
          </tr>
            <tr>
            <td colspan="2" align="center">
			
			<logic:present name="otrosDocs">
				<div id="moreDocs"><a href="javascript:detalle();">Mostrar los <bean:write name="otrosDocs"/> documentos de la persona</a></div>
			</logic:present>	
					
                <logic:present name="m_listaMovimientos">
                  <table width="95%" cellpadding="0" cellspacing="0" class="tLista">
                        <tr>
                          <th>Calidad Migratoria</th>
                          <th>Tipo Documento</th>
                          <th>Num. Documento</th>
                          <th>Tipo Movimiento</th>
                          <th>Pais de origen</th>
                          <th>Fecha de Control</th>
                          <th>Observaciones</th>
                        </tr>
                        <logic:iterate id="movimiento" name="m_listaMovimientos">
                          <tr valign="middle" >
                                <td>&nbsp;<bean:write name="movimiento" property="NIdCalidad.SDescripcion"/>&nbsp;</td>
                                <td>&nbsp;<bean:write name="movimiento" property="SIdDocumento.SDescripcion"/></td>
                                <td>&nbsp;<bean:write name="movimiento" property="SNumeroDoc"/></td>
                                <td>&nbsp;<bean:write name="movimiento" property="STipo"/></td>
                                <td>&nbsp;<bean:write name="movimiento" property="SIdPaisMov.SNombre"/></td>
                                <td>&nbsp;<%=Utiles.CalendarToString(((Simmovmigra1)movimiento).getDFechaControl(),"dd/MM/yyyy")%>&nbsp;</td>
                                <td>&nbsp;<bean:write name="movimiento" property="SObservaciones"/></td>
                          </tr>
                        </logic:iterate>
                  </table>
                </logic:present>
            </td>
           </tr>
        </table> 
        <div  id="message_warnig"><bean:message key="welcome.message.warning"/></div>   
    </logic:present>	
</html:form>
	  
</div>
</div>
</body>
</html:html>