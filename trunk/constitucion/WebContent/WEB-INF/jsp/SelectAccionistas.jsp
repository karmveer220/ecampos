<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="registraCargo.htm" name="cargoForm" method="post">

<div>
	<table >
		<thead>
			<tr>
				<th width="300px">Sel</th>
				<th width="300px">Nombre Completo</th>
				<th width="130px">Tipo Documento</th>
				<th width="110px">N&uacute;mero Documento</th>
			</tr>
		</thead>
		<c:forEach items="${lparticipantes}" var="socio">
		<tr>
			<td><input type="radio" name="socio" value="<c:out value="${socio.idAccionista}"/>"/></td>
			<td><c:out value="${socio.nombreCompleto}"/></td>
			<td><c:out value="${socio.codTipdoc}"/></td>
			<td><c:out value="${socio.numDocum}"/></td>
		</tr>
		</c:forEach>
	</table>
</div>

<table cellspacing="5" style="width:100%" cellspacing="5">
	<tr>
		<td colspan="2" height="35px" valign="bottom" align="center">
			<table cellspacing="5">
				<tr>
					<td><button onclick="notarios.asignarAccionista()">Aceptar</button></td>
					<td><button onclick="$('#dialog-modal3').dialog('close');">Cancelar</button></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>