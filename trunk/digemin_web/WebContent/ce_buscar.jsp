<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="org.cnl.digemin.utiles.Utiles"%>
<%@page import="gob.min.digemin.ejb.entitiesWeb.Simpersona1"%>
<html:html>
 <head>
  <title><bean:message key="welcome.title"/></title>
  <html:base/>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
    <link type="text/css" rel="stylesheet" href="css/cssa/displaytag.css" ></link>
    <script type="text/javascript" src="js/jsa/prototype.js"></script>
    <script type="text/javascript" src="js/jsa/scriptaculous/scriptaculous.js"></script>
    <script type="text/javascript" src="js/jsa/overlibmws/overlibmws.js"></script>

  <script type="text/javascript">
  
    function detalle(codigo){    
    document.forms[0].action="ce.do";
    document.forms[0].method.value="ceDetalle";
    document.forms[0].uid.value=codigo;
    document.forms[0].submit();
  }
  
  function limpiar(){
    document.forms[0].action="ce.do";
    document.forms[0].method.value="buscarCe";
    document.forms[0].uid.value='';
    document.forms[0].snombre.value='';
    document.forms[0].spaterno.value='';
    document.forms[0].smaterno.value='';
    document.forms[0].snroce.value='';
    document.forms[0].snombre.focus();
  }
  </script>
 </head>
 <body>
 
<div id="contenedor">
      
<div  id="cuerpo">
	
 <div id="titulo"><bean:message key="ce.search.heading"/></div>
        <p><bean:message key="ce.search.desc"/></p>
  
  <html:form action="/ce">
   <input type="hidden" name="method" value="buscarCe"/>
   <input type="hidden" name="uid" value=""/>
  
        <logic:present name="msgError">
            <div id="error"><bean:write name="msgError" scope="request"/></div><br />
        </logic:present>
		 <logic:present name="mensaje">
                <div id="mensaje"><bean:write name="mensaje" scope="request"/></div><br />
        </logic:present>
        <table width="600px" cellpadding="4" cellspacing="0" class="tFormulario">
		 <tr align="center">
            <td width="491"><table width="100%" cellspacing="0" cellpadding="4" border="0">
              <tr>
               <th width="134"><bean:message key="text.person.name"/></th>
            <td width="357"><html:text property="snombre" styleClass="input"></html:text></td>
              </tr>
              <tr>
               <th height="21"><bean:message key="text.person.father"/></th>
               <td><html:text property="spaterno" styleClass="input"></html:text></td>
              </tr>
              <tr>
                <th><bean:message key="text.person.mother"/></th>
            <td><html:text property="smaterno" styleClass="input"></html:text></td>
              </tr>
              <tr>
                 <th><bean:message key="text.person.nroce"/></th>
            <td><html:text property="snroce" styleClass="input"></html:text></td>
              </tr>
              <tr>
                <td colspan="2" align="center">
                    <label><input type="radio" name="coincidir" value="0" checked="checked"/>Coincidir al Inicio</label>
                    <label><input type="radio" name="coincidir" value="1"/>Coincidir en cualquier lugar</label>
                </td>
              </tr>
            </table></td>
            <td width="82">
		<input name="btnBuscar" type="submit" class="botonAz" value="Buscar">
                <br><br>
		 <input name="btnLimpiar" type="button" class="botonAz" value="Limpar" onClick="javascript:limpiar();">
                </td>
          </tr>
        </table>
                        
    <div style="width:600px">
	<display:table name="sessionScope.listaPersonas" class="displaytag" pagesize="10" defaultsort="1"
		defaultorder="ascending" export="false" id="row" excludedParams="ajax">
            <display:column title="Nombre" property="SNombre" sortable="true" headerClass="sortable" />
	    <display:column title="A. Paterno" property="SPaterno" sortable="true" headerClass="sortable"/>
	    <display:column title="A. Materno" property="SMaterno" sortable="true" headerClass="sortable"/>
            <display:column title="F. Nacimiento" headerClass="definition">
                <%=Utiles.CalendarToString(((Simpersona1)row).getDFechaNacimiento(),"dd/MM/yyyy")%>&nbsp;
            </display:column>
            <display:column media="html" title="Detalle"  headerClass="definition">
                <a href="javascript:detalle('<bean:write name="row" property="UIdPersona"/>');">Detalle</a>
            </display:column>
	 </display:table>
    </div>
    
        
        <div id="message_warnig"><bean:message key="welcome.message.warning"/></div>
        
  </html:form>
</div>

</div>
</body>
</html:html>