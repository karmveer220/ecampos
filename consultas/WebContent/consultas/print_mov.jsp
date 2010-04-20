<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="org.cnl.digemin.utiles.Utiles"%>
<%@page import="gob.min.digemin.ejb.Simpersona1"%>
<%@page import="gob.min.digemin.ejb.Simmovmigra1"%>
<%
    Simpersona1 m_persona = (Simpersona1)session.getAttribute("m_persona");
%>
<html:html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Detalle De Movimientos Migratorios</title>
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
	
	<div id="titulo">Consulta a Base de Datos de Migraciones <br />Movimientos Migratorios</div>
        
     
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
    
        <div>   <bean:write name="usrLogin" property="nnotaria.snombre"/><br/>
                <bean:write name="usrLogin" property="snombre"/>&nbsp;<bean:write name="usrLogin" property="spaterno"/><br/>
                <script language="JavaScript" type="text/javascript">printDate();</script>
        </div>
 
</div>

</div>

</body>
</html:html>