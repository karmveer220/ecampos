<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>    
<head>
    <title>Login</title>    
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
	<link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet" type="text/css" />
</head>
	
    <body onload="document.forms[0].j_username.focus();">
    	<c:out value="${msgError}"/>
	    <div style="margin-top: 50px; margin-bottom: 100px;">					
					
					<form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
										
					
					<div align="center">
					<table width="900" border="0" cellspacing="1" cellpadding="1" bgcolor="#eaeaea">
					  <tr>
					    <td align="left">
					    	<img src="${pageContext.request.contextPath}/images/logointra.jpg" width="100%" alt="Intranet" />					    	
					    </td>
					    <td width="0.2px">
					    	
					    </td>
					    <td align="left">
					    	<img src="${pageContext.request.contextPath}/images/intranetprincipal.jpg" width="100%"/>		
					    </td>
					  </tr>
					  <tr bgcolor="#666666">
					    <td colspan="4" height="15" width="895px">&nbsp;</td>
					  </tr>	
					  <tr>
					    <td colspan="4" height="100px">&nbsp;</td>
					  </tr>					 
					  <tr>
					    <td height="350" colspan="4">
					    	<table width="510" border="0" align="center" cellpadding="1" cellspacing="5" bgcolor="#CCCCCC">
						      <tr>
						        <td width="250" height="400" valign="top">
							        <table bgcolor="#CCCCCC">
								        <tr>
								        	<td>
								        		<table width="100%" border="0" bgcolor="#FFFFFF" >
									        		<tr valign="top">
										        		<td colspan="2" width="250" valign="top" height="100%"><img src="images/intranet_sub.jpg" width="345" height="100%"/></td>
										        	</tr>
									        	</table>
								        	</td>							        	
								        </tr>
								        <tr>
								        	<td>
								        		<table width="100%" border="0" bgcolor="#FFFFFF" >						        		
										       		<tr>
										        		<td colspan="2" align="center">
									        				 <strong>Bienvenidos</strong>
									        			</td>
										        	</tr>
										        	<tr>
										        		<td colspan="2" style="text-align: justify;">
										        			Esta Intranet permitir&aacute; una comunicaci&oacute;n entre los usuarios y los Sistemas Inform&aacute;ticos de manera mas segura y f&aacute;cil; incorporando adem&aacute;s algunos servicios como:
										        		</td>
										        	</tr>
										        	<tr>
										        		<td><img src="images/editor.png" width="20" height="20" /></td>
										        		<th align="left">Tr&aacute;mite Documentario</th>
										        	</tr>
										        	<tr >
										        		<td width="5px"></td>
										        		<td style="text-align: justify;">Permitir&aacute; mostrar la informaci&oacute;n de la situaci&oacute;n de los Documentos en tr&aacute;mite por el Usuario.</td>
										        	</tr>
										        	<tr>
										        		<td><img src="images/editor.png" width="20" height="20" /></td>
										        		<th align="left">Record de Asistencias</th>
										        	</tr>
										        	<tr>
										        		<td width="5px"></td>
										        		<td style="text-align: justify;">Consultas del Software de Marcaci&oacute; de Asistencias de Personal.</td>
										        	</tr>
										        	<tr>
										        		<td><img src="images/editor.png" width="20" height="20" /></td>
										        		<th align="left">Acceso Directo a las Aplicaciones</th>
										        	</tr>
										        	<tr>
										        		<td width="5px"></td>
										        		<td style="text-align: justify;">No ser&aacute; necesario volver a digitar el usuario y clave de las aplicaciones desarrolladas internamente.</td>
										        	</tr>
										        	<tr>
										        		<td colspan="2" height="20px">&nbsp;</td>
										        	</tr>
										        </table>
								        	</td>							        	
								        </tr>
							        </table>						        							        	
						        </td>
						        <td width="0.2"></td>
						        <td width="250" valign="top">
						        	<table width="350" border="0" cellspacing="0" cellpadding="0" bgcolor="#CCCCCC">
						        	  <tr>
							            <td bgcolor="#CCCCCC" height="2"></td>
							          </tr>
							          <tr>
							            <td width="350" valign="top" height="150"><img src="images/intranet.png" width="350" height="100%" /></td>
							          </tr>
							          <tr>
							            <td bgcolor="#CCCCCC" height="4"></td>
							          </tr>
							          <tr>
							            <td bgcolor="#FFFFFF">
							            	<table align="center" width="250px" border="0" height="143px" >
								        		<tr>
													<th colspan="2">ACCESO A LA INTRANET</th>
												</tr>
												<tr>
													<td align="left">USUARIO</td>
													<td>
													<c:if test="${not empty param.login_error}">
														<c:set var="username" value="${sessionScope.SPRING_SECURITY_LAST_USERNAME}"/>
													</c:if>
													<input type="text" name="j_username" size="15" value="${username}"/>									
													</td>										
												</tr>	
												<tr>
													<td align="left">CLAVE</td>
													<td><input type="password" name="j_password" size="15" value=""/></td>
													
												</tr>
												<tr>													
													<td colspan="2" align="right"><input type="submit" value="Ingresar" /></td>
												</tr>
											</table>
							            </td>
							          </tr>
							          <tr>
							            <td bgcolor="#CCCCCC" height="4"></td>
							          </tr>
							          <tr>
							            <td style="text-align: justify;" bgcolor="#FFFFFF">
							        	<strong>Aviso:</strong>
							        	Ingresar el mismo usuario y clave de inicio de su computadora.<br/>
							        	En caso de tener alguna duda o consulta, por favor escribanos a soporte@mininter.gob.pe.					        
								        </td>
							    	  </tr>
							    	  <tr>
							        	<td height="25px" bgcolor="#FFFFFF"></td>
							          </tr>
							        </table>
						        </td>
						      </tr>
						    </table>					    
					    </td>
					  </tr>
					  <tr>
					    <td colspan="4" align="center">
					    	<c:if test="${not empty param.login_error}">
								<div class="errors" style="color: red;" align="center">
									No pudo ingresar al sistema, Intentelo nuevamente. Razon: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
								</div>
							</c:if>	
					    </td>
					  </tr>	
					  <tr>
					    <td colspan="4" height="100px">&nbsp;</td>
					  </tr>
					  <tr>
					    <td colspan="4" class="pie">  <jsp:include page="copyright.jsp"/> </td>
					  </tr>
					</table>
					</div>					
					</form>					
			</div>
	    	
	    	
    </body>

</html>