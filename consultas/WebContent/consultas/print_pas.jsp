<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="org.cnl.digemin.utiles.Utiles"%>
<%@page import="gob.min.digemin.ejb.Simpersona1"%>
<%@page import="gob.min.digemin.ejb.Simpasaporte1"%>
<%
    Simpersona1 estranjero = (Simpersona1)session.getAttribute("extranjero");
%>

<html:html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Detalle De Pasaportes</title>
        <html:base/>
        <link href="../css/ahorro.css" rel="stylesheet" type="text/css">
        <script src="../js/libreria.js" type="text/javascript"></script>
        <script language="JavaScript" type="text/javascript">  
            imprimir();
            function imprimir(){ 
                    window.print(); 
            }
            function cerrar(){
              window.close();
              }
        </script> 
     
  </head>
  
<body>

<div id="contenedor">


<div  id="cuerpo">
	
	<div id="titulo">Consulta a Base de Datos de Migraciones <br />Datos de Pasaporte</div>
        
     
    <logic:present name="extranjero">
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
                                  <img  width="100px" border="0" height="100px" src="../<bean:write name="nombreim"/>"/>
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
    
	<div>   <bean:write name="usrLogin" property="nnotaria.snombre"/><br/>
                <bean:write name="usrLogin" property="snombre"/>&nbsp;<bean:write name="usrLogin" property="spaterno"/><br/>
                <script language="JavaScript" type="text/javascript">printDate();</script>
        </div>
 
</div>

</div>

</body>
</html:html>