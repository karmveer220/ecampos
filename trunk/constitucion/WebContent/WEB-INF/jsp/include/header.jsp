<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
    
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Pragma" content="nocache">
		
        <title>Constituci&oacute;n</title>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/master.css" type="text/css" media="screen" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_style.css" type="text/css" />    	
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar-system.css" type="text/css" media="all" title="system" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ajaxtags.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/displaytag.css" type="text/css"/>
       
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/prototype.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/scriptaculous/scriptaculous.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/overlibmws/overlibmws.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxtags.js"></script>
        
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar-es.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar-setup.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tw-sack.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/validation.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/shadowbox/shadowbox.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-latest.pack.js"></script>
        
      
	    
	</head>
    <body>
    	<div id="principal">
			
			<div id="banners">
			   <div style="float: right;">Bienvenido ${pageContext.request.userPrincipal.name} |  <a href="${pageContext.request.contextPath}/j_spring_security_logout">Cerrar Session</a></div>
			    <a href="${pageContext.request.contextPath}/home.htm">
			        <img src="${pageContext.request.contextPath}/img/cabecera.jpg" height="200px" />
			    </a><br/>
			</div>
		
	    	<jsp:include page="menu.jsp"/>
	    	
	    	<div id="cuerpo">
	    		
	    	