<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html:html>
 <head>
  <title><bean:message key="welcome.title"/></title>
  <html:base/>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
    <link type="text/css" rel="stylesheet" href="css/cssa/ajaxtags.css" ></link>
    <link type="text/css" rel="stylesheet" href="css/cssa/displaytag.css" ></link>
    <script type="text/javascript" src="js/jsa/prototype.js"></script>
    <script type="text/javascript" src="js/jsa/scriptaculous/scriptaculous.js"></script>
    <script type="text/javascript" src="js/jsa/overlibmws/overlibmws.js"></script>
    <script type="text/javascript" src="js/jsa/ajaxtags.js"></script>
  <script type="text/javascript">
  
  function detalle(codigo){    
    document.forms[0].action="movimientos.do";
    document.forms[0].method.value="movimientosDetalle";
    document.forms[0].uid.value=codigo;
    document.forms[0].submit();
  }  
   function limpiar(){
    document.forms[0].action="movimientos.do";
    document.forms[0].method.value="buscarMovimientos";
    document.forms[0].snroce.value='';
    document.forms[0].snombre.focus();
  }
  </script>
  
 </head>
 <body bgcolor="white">
 
 <div id="contenedor">

<div  id="cuerpo">
	
	 <div id="titulo"><bean:message key="movimientos.search.heading"/></div>
        <p><bean:message key="movimientos.search.desc"/></p>
  
          <logic:present name="msgError">
                <div id="error"><bean:write name="msgError" scope="request"/></div><br />
        </logic:present>
        <logic:present name="mensaje">
                <div id="mensaje"><bean:write name="mensaje" scope="request"/></div><br />
        </logic:present>
        
  <html:form action="/movimientos">
   <input type="hidden" name="method" value="buscarPersonas"/>
    
    <table width="600px" cellpadding="4" cellspacing="0" class="tFormulario">
	<tr>
            <td width="497" >
		
                <table width="100%" cellspacing="0" cellpadding="4" border="0">         
                  <tr>
                      <th><bean:message key="text.person.nropasaporte"/></th>
                      <td><html:text property="snropas" styleClass="input"></html:text></td>
                  </tr>
                  <tr>
                      <th><bean:message key="text.person.nroce"/></th>
                      <td><html:text property="snroce" styleClass="input"></html:text></td>
                  </tr>
                </table>
                
            </td>
            <td width="83">
                <input name="btnBuscar" type="submit" class="botonAz" value="Buscar"><br/><br>
                <input name="btnLimpiar" type="button" class="botonAz" value="Limpar" onClick="javascript:limpiar();">
            </td>
	</tr>
    </table>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  <div  id="message_warnig"><bean:message key="welcome.message.warning"/></div>
  </html:form>
</div>
</div>
</body>
</html:html>