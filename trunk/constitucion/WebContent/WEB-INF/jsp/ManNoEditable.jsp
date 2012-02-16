<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="screen" />
</head>
<body>

<div id="dvmaincontainer">
			
	<div id="dvbodycontainer">		
   	
   	<div id="dvleftpanel">
   	
<form:form id="manForm" name="manForm" method="post" action="registraMandatario.htm" modelAttribute="mandatario" >
	
	<form:hidden path="idMandatario"/>
	
	<table cellspacing="2" cellspacing="2">
		<tr>
			<td width="200px"><b>Tipo documento</b>:</td>
			<td colspan="2">
				<form:select path="codTdocman" id="manTipoDocumento" disabled="disabled">
					<option value="01" selected="selected">D.N.I.</option>
					<option value="02">CARNET EXTRANJERIA</option>
					<option value="03">PASAPORTE</option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><b>N&uacute;mero de documento</b>:</td>
			<td><c:out value="${mandatario.numDocman}"/>  </td>
			<td> </td>
		</tr>
		<tr>
			<td>Apellido paterno:</td>
			<td colspan="2"> <c:out value="${mandatario.apePaterno}"/> </td>
		</tr>
		<tr>
			<td>Apellido materno:</td>
			<td colspan="2"> <c:out value="${mandatario.apeMaterno}"/></td>
		</tr>
		<tr>
			<td>Nombres:</td>
			<td colspan="2"> <c:out value="${mandatario.nomMandat}"/></td>
		</tr>
		<tr>
			<td>Direcci&oacute;n:</td>
			<td colspan="2"><c:out value="${mandatario.dirMandat}"/> </td>
		</tr>
		<tr>
			<td>Profesi&oacute;n:</td>
			<td colspan="2"><c:out value="${mandatario.desProfesion}"/> </td>
		</tr>
		<tr>
			<td>Insc. Registral:</td>
			<td colspan="2"><c:out value="${mandatario.clvInsreg}"/> </td>
		</tr>
	</table>
	
</form:form>
</div>
</div>
</div>
</body>
</html>