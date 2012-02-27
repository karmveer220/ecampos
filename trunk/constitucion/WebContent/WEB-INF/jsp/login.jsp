<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Constitucion de Empresas</title>
    	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_login.css" />
    	
    	<script language="JavaScript">
	    	function upperCase(ctrl) {
				var data = ctrl.value;
				ctrl.value = data.toUpperCase();
			}
	    </script>
	
	</head>
    <body onload="document.forms[0].j_username.focus();">


	<form id="login-form" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
	
	<c:if test="${not empty param.login_error}">
		<div class="errors" style="color: #000;" align="right">
			No pudo ingresar al sistema, Intentelo nuevamente.<br />
			Razon: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
		</div>
	</c:if>
					
		<fieldset>
		
			<legend>Log in</legend>
			
			<label for="login">Email</label>
			<c:if test="${not empty param.login_error}">
				<c:set var="username" value="${sessionScope.SPRING_SECURITY_LAST_USERNAME}"/>
			</c:if>
			<input type="text" id="login" name="j_username" size="15" value="${username}" onChange="upperCase(this)"/>
			<div class="clear"></div>
			
			<label for="password">Password</label>
			<input type="password" id="password" name="j_password" size="15" value=""/>
			<div class="clear"></div>
			
			<div class="clear"></div>
			
			<br />
			
			<input type="submit" style="margin: -20px 0 0 287px;" class="button" name="commit" value="Log in"/>	
		</fieldset>
	</form>
	
</body>

</html>
