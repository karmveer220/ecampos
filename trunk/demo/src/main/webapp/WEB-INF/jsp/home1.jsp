<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test seguridad</title>
</head>
<body>

	<p>
	Si ves esto, significa que estas loguead como <security:authentication property="principal.username" /> 
	</p>
	<security:authorize ifAnyGranted="ROLE_SYSTEM">
	<p>
	Puedes ver opcion para SYSTEM
	</p>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ASISTENCIA">
	<p>
	puedes ver opcion ROLE AISTENCIA
	</p>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_USER">
	<p>
	puedes ver opcion ROLE USER
	</p>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_UNO,ROLE_ADMIN">
	<p>
	puedes ver opcion uno y  ADMIN
	</p>
	</security:authorize>
		
</body>
</html>