<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Constitucion de Empresas</title>
        <link href="${pageContext.request.contextPath}/css/master.css" rel="stylesheet" type="text/css" media="screen" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_style.css" type="text/css" />
    	
    	<script language="JavaScript">
	    	function upperCase(ctrl) {
				var data = ctrl.value;
				ctrl.value = data.toUpperCase();
			}
	    </script>
	
	</head>
    <body onload="document.forms[0].j_username.focus();">
    	<div id="principal">
    	
			<div id="banners">
			    <a href="home.htm">
			        <img src="${pageContext.request.contextPath}/images/cabecera.jpg" />
			    </a><br/>    
			</div>
    	
    	
	    	<div id="cuerpo">
	    	
	    		<div style="margin-top: 50px; margin-bottom: 100px;">
					<c:if test="${not empty param.login_error}">
						<div class="errors" style="color: #000;" align="right">
							No pudo ingresar al sistema, Intentelo nuevamente.<br />
							Razon: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
						</div>
					</c:if>
					
					<form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
					
						<table align="right" width="250px">
							<tr>
								<td>Usuario</td>
								<td>
									<c:if test="${not empty param.login_error}">
										<c:set var="username" value="${sessionScope.SPRING_SECURITY_LAST_USERNAME}"/>
									</c:if>
									<input type="text" name="j_username" size="15" value="${username}" onChange="upperCase(this)"/>
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
								<td><input type="submit" value="Login" /></td>
								<td></td>
							</tr>		
						</table>
					
					</form>
					<br/><br/><br/>
					</div>
	    	</div>
	    	
	        <jsp:include page="include/footer.jsp" flush="true"></jsp:include>
	        
        </div>
    </body>
</html>