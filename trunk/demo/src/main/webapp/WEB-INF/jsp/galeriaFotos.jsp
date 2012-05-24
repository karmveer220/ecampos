<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Galer%iacute;a de Imagenes</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
</head>

<body>
	<table width="695" border="0" cellspacing="0" cellpadding="0">	
		<tr>
			<% SiminImagen listInterior = (SiminImagen)request.getAttribute("listInterior");%>
			<% SiminImagen listDigemin = (SiminImagen)request.getAttribute("listDigemin");%>
			<% SiminImagen listDiscamec = (SiminImagen)request.getAttribute("listDiscamec");%>
		        			
			<td width="225" height="150">
				<a href="fotosCampe2011.htm">					
        			<img alt="<%=listInterior.getNaImgNombre() %>" src="img.htm?id=<%=listInterior.getCoImgCodigo()%>" width="225" height="150" border="0"/>
				</a>
			</td>
			<td width="10"><img src="images/blank.jpg" width="10" /></td>
			<td width="225" height="150">
				<a href="fotosDigemin.htm">
					<img alt="<%=listDigemin.getNaImgNombre() %>" src="img.htm?id=<%=listDigemin.getCoImgCodigo()%>" width="225" height="150" border="0"/>
				</a>
			</td>
			<td width="10"><img src="images/blank.jpg" width="10" /></td>
			<td width="225" height="150">
				<a href="fotosDicscamec.htm">
					<img alt="<%=listDiscamec.getNaImgNombre() %>" src="img.htm?id=<%=listDiscamec.getCoImgCodigo()%>" width="225" height="150" border="0"/>
				</a>
			</td>
		</tr>
		<tr>
			<td><div align="center">CAMPEONATO 2011</div></td>
			<td>&nbsp;</td>
			<td><div align="center">DIGEMINN</div></td>
			<td>&nbsp;</td>
			<td><div align="center">DICSCAMEC</div></td>
		</tr>		
	</table>
</body>
</html>
