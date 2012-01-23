<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>

<html>
<head>
	<title>Colegio de Notarios</title>
</head>
<script language="JavaScript">
	function cargarPagina() {
		var un = document.f.j_username;
		var len = un.value.length;
		if(len > 6) {
			document.f.j_notaria.value = un.value.substring(0,6);
			document.f.j_usuario.value = un.value.substring(6);
		}
		document.f.j_notaria.focus();
	}
	
	function validaLogin() {
		if(document.f.j_notaria.value.length != 6) {
			alert("El codigo de notaria es incorrecto");
			document.f.j_notaria.focus();
			return false;
		}
		
		if(document.f.j_usuario.value.length < 6) {
			alert("El usuario debe tener una longitud minima de 6 caracteres");
			document.f.j_usuario.focus();
			return false;
		}
		
		if(document.f.j_password.value.length < 6) {
			alert("El password debe tener una longitud minima de 6 caracteres");
			document.f.j_password.focus();
			return false;
		}
		
		document.f.j_username.value = document.f.j_notaria.value +
									  document.f.j_usuario.value; 
									  
		return true;
	}
	
	function upperCase(ctrl) {
		var data = ctrl.value;
		ctrl.value = data.toUpperCase();
	}
</script>
<body onload="cargarPagina()" style="margin:0px">
	<div style="left: 0px; top: 0px; position: relative">
		<div style="background-image: url(/a/imagenes/fondosuperior.gif); height: 100px; display:block; width:100%;">
			<img style="left: 0px; top: 0px; position: relative" src="/a/imagenes/superior.jpg" alt="" border="0" align="left"/>
		</div>
	</div>

	<div style="height:50px;text-align:center;padding:10px">
	</div>
	
	<form name="f" action="j_spring_security_check" onSubmit="if(!validaLogin())return false;" method="POST">
		<input id="j_usernameLogin" type='hidden' name='j_username' <% if(session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY) != null) {%> value="<%=session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY)%>"<%}%>/>
		<table width="100%">
			<tr>
				<td align="center">
					<table style="border:1px solid #c3d9ff" cellspacing="4px">
						<tr>
							<td bgColor="#e8eefa">
								<table cellspacing="10px" style="font-family:verdana;font-size:13px;">
									<tr>
										<td width="140px"><b>C&oacute;digo de Notaria:</b></td>
										<td><input type='text' name='j_notaria' value='' maxlength='6' onChange="upperCase(this)"/></td>
									</tr>
									<tr>
										<td><b>Usuario:</b></td>
										<td><input type='text' name='j_usuario' value='' maxlength='14' onChange="upperCase(this)"/></td>
									</tr>
									<tr>
										<td><b>Contrase&ntilde;a:</b></td>
										<td><input type='password' name='j_password' maxlength='14'></td>
									</tr>
									<tr>
										<td colspan="2">
											<input type="checkbox" name="_spring_security_remember_me"><b>&nbsp;&nbsp;No solicitar mi contrase&ntilde;a durante dos semanas</b>
										</td>
									</tr>
									<tr>
										<td colspan="2">
											<table width="100%" cellspacing="10px-">
												<tr>
													<td align="right" width="50%"><input name="submit" type="submit" value="Acceder"/></td>
													<td align="left"><input name="reset" type="reset" value="Limpiar"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
