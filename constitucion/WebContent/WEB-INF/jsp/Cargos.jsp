<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<form action="registraCargo.htm" id="cargoform" name="cargoform" method="post">

	<input type="hidden" name="codManda" value='<c:out value="${manda.idMandatario}"/>'/>
	 
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr><td colspan="2">&nbsp;</td></tr>
		<c:forEach items="${lCargos}" var="cargo">
		<tr>
			<td width="50px">&nbsp;</td>
			<td>
				<label><input type="radio" name="cargo" value='<c:out value="${cargo.codParam}"/>' <c:if test="${manda.codCargo == cargo.codParam}"> checked="checked" </c:if>  /><c:out value="${cargo.desParam}"/></label>
			</td>
		</tr>
		</c:forEach>
		<tr><td colspan="2">&nbsp;</td></tr>
	</table>
	
</form>
</body>
</html>