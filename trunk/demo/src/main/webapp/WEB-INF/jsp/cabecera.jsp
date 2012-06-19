<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table style="width: 905px;">
	<tr>
		<td height="10" colspan="4" align="right" valign="top" bgcolor="#666666">
			<ul id="topnav">
				<li><a href="home.htm"><img src="images/home.png" alt="inicio" width="20" height="20" class="link-img" />Home</a></li>
				<li><a href="http://www.mininter.gob.pe" target="_blank"><img src="images/logo_min.png" alt="Portal" width="20" height="20" class="link-img" />Portal</a></li>
				<li><a href="http://correo.mininter.gob.pe" target="_blank"> <img src="images/mail.png" alt="Correo" width="20" height="20"class="link-img" />Correo</a></li>
			</ul>
		</td>
	</tr>
	<tr>
		<td height="90" colspan="4" align="left" valign="top">
			<table style="width: 905px; height: 90px; border: 0; padding: 0;">
				<tr>
					<td width="360"><img src="images/logomininter1.jpg" width="360"height="100" /></td>
					<td width="375">&nbsp;</td>
					<td width="165">
						<div class="tituintra1">Intranet</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td colspan="4" bgcolor="#666666">
			<table>
				<tr valign="top" class="datuser">
					<td width="260">Bienvenido: </td>
					<td width="400">Area: </td>
					<td width="100">IP: </td>
					<td width="150">Fecha: </td>
				</tr>
				<tr valign="top" class="datuser">
					<td width="260"> 
						<c:out value="${usuario.nombreCompleto}" />
					</td>
					<td width="400">
						<c:out value="${usuario.siminUnidadorganica1.nunoDescripcion}" />
					</td>
					<td width="100">
						<c:out value="${usuario.ipPrivada}" /></td>
					<td width="150">
						<script type="text/javascript">
							document.write(nombres_dias[dia_semana] + ", " + dia_mes + " de " + nombres_meses[mes - 1] + " de " + anio)
						</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
</table>