<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test seguridad</title>
</head>
<body>

	<p>
	Si ves esto, significa que estas loguead como <security:authentication property="principal.username" /> 
	</p>
	<security:authorize ifAnyGranted="ROLE_UNO">
	<p>
	Puedes ver opcion uno
	</p>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_DOS">
	<p>
	puedes ver opcion dos
	</p>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_TRES">
	<p>
	puedes ver opcion tres
	</p>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_UNO,ROLE_TRES">
	<p>
	puedes ver opcion uno y  tres
	</p>
	</security:authorize>
	


</body>
</html>