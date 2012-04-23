<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Intranet del Ministerio del Interior</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
</head>

<body>	  
	
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">
	  	<tr>
	    	<td height="115" colspan="2" valign="top"> <jsp:include page="cabecera.jsp"/> </td>
	 	</tr>
	  	<tr>
		    <td width="200" valign="top"> <jsp:include page="menu.jsp"/> </td>
		    <td width="700" valign="top" bgcolor="#EAEAEA">
		    	<table width="600" border="0" cellspacing="0" cellpadding="0" >
		      	<tr>
		        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" /></td>
		        </tr>
		      	<tr align="center">
		        	<td height="200" colspan="5" valign="top"><img src="images/tres.png" width="700" height="200" /></td>
		        </tr>
		      	<tr>
		        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" height="5" /></td>
		        </tr>
		      	<tr>
			        <td width="210"><div><img src="images/boton_util.png" width="230" height="25" /></div></td>			        
			        <td>&nbsp;</td>		
			        <td width="210"> <div> <img src="images/boton_sistemas.png" width="230" height="25" /></div></td>
				    <td>&nbsp;</td>		
			        <td width="210"><div><img src="images/boton_cumple.png" width="230" height="25" /></div></td>
		      	</tr>
		      	<tr>
		        	<td height="150" valign="top" bgcolor="#EAEAEA">	
		        		<br/>
		        		<table width="100%">
		        			<tr>
		        				<td valign="top">
		        					<a href="asistencia.htm"><img src="images/reloj.GIF" width="16" height="16" />Asistencia</a>
		       					</td>
		       					<td align="right">&nbsp;</td>
		       				</tr>
		        			<tr>
		        				<td>
		        					<a href="boleta.htm"><img src="images/icon_libro.png" width="16" height="16" />Boleta de pago</a>
		        				</td>
		        				<td align="right">&nbsp;</td>
		        			</tr>
		        		</table>	        		
		           	</td>
		           	<td>&nbsp;</td>
		        	<td valign="top" bgcolor="#EAEAEA" align="left">
		        		<br/>
		        		
						<c:forEach items="${lstSistemas}" var="sis">
							<a href="http://srvprueba:8080/${sis.siminSistema.nsisAbreviatura}/${sis.siminSistema.nsisMetodo}=${usuario.nmstLogin}&var=1" target="_blank"> <c:out value="${sis.siminSistema.nsisDescripcion}"/></a><br/><br/>
					    </c:forEach>
					    		
				    </td>
				    <td>&nbsp;</td>
		       	 	<td valign="top" bgcolor="#EAEAEA">
		       	 		<br/>
				   		<c:forEach items="${lcumpleanios}" var="sis">				 	
						 	<c:out value="${sis.nombreCompleto}"/>
						 	<br/>
				    	</c:forEach><br/><br/><br/><br/><br/><br/>
				    	<div align="right"><a href="cumplemensual.htm">Ver mas..</a></div>
				    </td>
		        </tr>
		      	<tr>
			        <td valign="top" colspan="5">&nbsp;</td>
		      	</tr>
		      	<tr>
			        <td valign="top"><div><img src="images/boton_menu.png" width="230" height="25" /></div></td>
			        <td>&nbsp;</td>		        
			        <td valign="top"><div><img src="images/boton_soporte.png" width="230" height="25" /></div></td>
			        <td>&nbsp;</td>		        
			        <td valign="top"><div><img src="images/boton_campana.png" width="230" height="25" /></div></td>
		        </tr>
		      	<tr>
					<td valign="middle" align="center" bgcolor="#EAEAEA"><br/>
						<a href="menuSemanal.htm"> <img alt="Menú Semanal" src="images/pizarra.png" width="200" height="70" /></a>
					</td>
					<td>&nbsp;</td>
					<td height="150" valign="top" width="100%" bgcolor="#EAEAEA">
			        	<br/>
			        	<table width="100%">
			        			<tr>
									<td>Nelly Chang</td>
									<td align="right">#422721</td>
								</tr>
								<tr>
									<td>Carlos Valenzuela</td>
									<td align="right">#422747</td>
								</tr>
								<tr>
									<td>Jimmy Jorge</td>
									<td align="right">#422824</td>
								</tr>
								<tr>
									<td>Carlos Canepa</td>
									<td align="right">#422819</td>
								</tr>
								<tr>
									<td>Pedro Ramos</td>
									<td align="right">#422929</td>
								</tr>
			        		<tr>
								<td colspan="2" align="center">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									Horario de Atenci&oacute;n:8:30 - 21:00 horas
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">soporte@mininter.gob.pe</td>
							</tr>
		        		</table><br/>
					</td>
					<td>&nbsp;</td>
			        <td valign="top" bgcolor="#EAEAEA"><br/>
			        	<div align="center">
							<a
								href="campanas.htm"> <img alt="Campañas" src="images/campanas.png" width="160" height="150" />
							</a>
						</div>
			        </td>
		        </tr>
		    	</table>
	    	</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2" class="pie">  <jsp:include page="copyright.jsp"/> </td>
	  	</tr>
	</table>
	</form>
</body>
</html>