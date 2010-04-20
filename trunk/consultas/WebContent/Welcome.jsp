<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
<head>
    <title><bean:message key="welcome.title"/></title>
    <html:base/>
    <link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="contenedor">
		  <div id="banner">
		<jsp:include page="banner.jsp" flush="true" />
	</div>
	<div id="menu">
		<jsp:include page="menu.jsp" flush="true" />
	</div>
    
	    
  <div id="cuerpo">
  
	<div id="cabecera">
		<jsp:include page="cabecera.jsp" flush="true" />
	</div>
	
    <div id="titulo">Colegio de Notarios De Lima</div>
    
    	<logic:present name="mensaje">
                <div id="mensaje"><bean:write name="mensaje" scope="request"/></div><br />
        </logic:present>
        
        <logic:present name="msgError">
                <div id="error"><bean:write name="msgError" scope="request"/></div><br />
        </logic:present>
        
    <h3>Bienvenido</h3>
   <p>Esta es la p&aacute;gina web desarrollada para los notarios afiliados al convenio de intercambio<br />
        de informaci&oacute;n con la DIGEMIN.</p>
   <p>Cabe se&ntilde;alar que la informaci&oacute;n presentada es la misma que maneja la DIGEMIN,<br />
    en la cual puede que  no se encuentre registrada toda la informaci&oacute;n asociada a una persona,<br />
     en la mayor&iacute;a de casos movimientos migratorios. Por ello, no es responsabiliad del CNL que <br />
   en alg&uacute;n momento no se encuentre la iformaci&oacute;n requerida. </p>
    
    Opciones:
      <ul>
            <li><a href="ce_buscar.jsp">Buscar Carnet de Extranjer&iacute;a</a></li>
            <li><a href="pasaporte_buscar.jsp">Buscar Pasaporte</a></li>
            <li><a href="movimientos.do?method=inicio">Movimientos Migratorios</a></li>
    </ul>
	
	<jsp:include page="pie.jsp" flush="true" />
	
	
  </div>
  
  </div>
</body>
</html:html>
