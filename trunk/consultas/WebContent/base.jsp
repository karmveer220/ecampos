<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
 <head>
	<META Http-Equiv="Cache-Control" Content="no-cache">
	
	<META Http-Equiv="Expires" Content="0"> 
  <title><tiles:getAsString name="titulo"/></title>
  <html:base/>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
    <link type="text/css" rel="stylesheet" href="cssa/ajaxtags.css" ></link>
    <link type="text/css" rel="stylesheet" href="cssa/displaytag.css" ></link>
    <script type="text/javascript" src="ajaxtags/jsa/prototype.js"></script>
    <script type="text/javascript" src="ajaxtags/jsa/scriptaculous/scriptaculous.js"></script>
    <script type="text/javascript" src="ajaxtags/jsa/overlibmws/overlibmws.js"></script>
    <script type="text/javascript" src="ajaxtags/jsa/ajaxtags.js"></script>
   
 </head>
 <body bgcolor="white">
 
<div id="contenedor">
	<div id="banner"> <tiles:insert attribute="banner"/> </div>
	<div id="menu"> <tiles:insert attribute="menu"/> </div>
        
	<div  id="cuerpo">
	
	<div id="cabecera"> <tiles:insert attribute="cabeza"/> </div>
	
	 <div id="titulo"><tiles:getAsString name="titulo"/></div>
        <p><tiles:getAsString name="descripcion"/></p>
  
        <logic:present name="msgError"><div id="error"><bean:write name="msgError" scope="request"/></div><br /></logic:present>
        <logic:present name="mensaje"><div id="mensaje"><bean:write name="mensaje" scope="request"/></div><br /></logic:present>
        
  		<tiles:insert attribute="cuerpo"/>
  		
  	<tiles:insert attribute="pie"/>
  
  </div>
  
  </div>
  </body>
  <head>  
  	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  </head>
</html:html>