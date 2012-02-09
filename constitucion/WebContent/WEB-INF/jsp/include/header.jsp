<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
    
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Pragma" content="nocache">
		
        <title>Constituci&oacute;n</title>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_style.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="screen" />    	    	
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
               
       	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
	    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/themes/redmond/jquery-ui.css" type="text/css" media="all" />
		
	    
	</head>
    <body>
    	<div id="dvmaincontainer">
			
			<div id="dvtopcontainer">
			    <div id="dvlogocontainer">
			      <h1>Constitucion de Empresas</h1>
				  <h4>en 72 horas</h4>
			    </div>
			    <div id="dvnavicontainer">
			      <img src="${pageContext.request.contextPath}/img/navi_left.jpg" alt="" />
					<div id="tabs1" >
			        <ul>
					  <li>Bienvenido Ecampos | </li>
			          <li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><span>Cerrar Session</span></a></li>
			        </ul>
			      </div>
			      <img src="${pageContext.request.contextPath}/img/navi_right.jpg" alt="" />
			    </div>
			  </div>
			  
		<div id="dvbodycontainer">		
	    	<jsp:include page="menu.jsp"/>
	    	<div id="dvcentraltpanel">