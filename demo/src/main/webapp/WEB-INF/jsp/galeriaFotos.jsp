<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Galeria de Fotos del Ministerio del Interior</title>

<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>
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
			<td width="10"><img src="images/blank.jpg" width="10"  /></td>
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
