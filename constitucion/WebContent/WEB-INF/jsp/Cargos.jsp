<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="registraCargo.htm" name="cargoForm" method="post">

	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr><td colspan="2">&nbsp;</td></tr>
		<c:forEach items="${lCargos}" var="cargo">
		<tr>
			<td width="50px">&nbsp;</td>
			<td>
				<label><input type="radio" name="cargo" value='<c:out value="${cargo.codParam}"/>' /><c:out value="${cargo.desParam}"/></label>
			</td>
		</tr>
		</c:forEach>
		<tr><td colspan="2">&nbsp;</td></tr>
	</table>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td colspan="2" height="35px" valign="bottom" align="center">
				<table cellspacing="5">
					<tr>
						<td><button onclick="notarios.grabarCargos()">Aceptar</button></td>
						<td><button onclick="$('#dialog-modal').dialog('close');">Cancelar</button></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>