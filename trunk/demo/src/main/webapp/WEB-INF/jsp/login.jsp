<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>       
	</head>
	
    <body onload="document.forms[0].j_username.focus();">
    	
	    <div style="margin-top: 50px; margin-bottom: 100px;">
		
					<c:if test="${not empty param.login_error}">
						<div class="errors" style="color: #000;" align="right">
							No pudo ingresar al sistema, Intentelo nuevamente.<br />
							Razon: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
						</div>
					</c:if>
					
					<form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
					
						<table align="center" width="250px">
							<tr>
								<td>Usuario</td>
								<td>
									<c:if test="${not empty param.login_error}">
										<c:set var="username" value="${sessionScope.SPRING_SECURITY_LAST_USERNAME}"/>
									</c:if>
									<input type="text" name="j_username" size="15" value="${username}"/>
								</td>
								<td></td>
							</tr>	
							<tr>
								<td>Contrase&ntilde;a</td>
								<td><input type="password" name="j_password" size="15" value=""/></td>
								<td> </td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Ingresar" /></td>
								<td></td>
							</tr>		
						</table>
					
					</form>
					
			</div>
	    	
	    	
    </body>
</html>