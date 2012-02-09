<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="screen" />    	    	


<script type="text/javascript">
<!--
	function grabarMandatario(){
		document.forms[0].submit();
	}

	function cancelar(){
		
	}
//-->
</script>
</head>
<body>

<div id="dvmaincontainer">
			
	<div id="dvbodycontainer">		
   	
   	<div id="dvleftpanel">
   	
<form:form id="manForm" name="manForm" method="post" action="registraMandatario.htm" modelAttribute="mandatario" >
	
	<form:hidden path="idMandatario"/>
	
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td width="200px">(+) <b>Tipo documento</b>:</td>
			<td colspan="2">
				<form:select path="codTdocman" id="manTipoDocumento" cssStyle="width:200px" onchange="notarios.cmbmanTipoDocu()">
					<option value="01" selected="selected">D.N.I.</option>
					<option value="02">CARNET EXTRANJERIA</option>
					<option value="03">PASAPORTE</option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>(+) <b>N&uacute;mero de documento</b>:</td>
			<td>
				<form:input path="numDocman" id="manNumeroDocumento" maxlength="20" cssStyle="font-size:13px; width:120px" onchange="notarios.cmbmanNumeDocu()"/>
			</td>
			<td>
				<button id="manBtnReniec" disabled="disabled" onclick="notarios.cmbmanValidDocu()">RENIEC</button>
			</td>
		</tr>
		<tr>
			<td>(*) Apellido paterno:</td>
			<td colspan="2">
				<form:input path="apePaterno" id="manApellidoPaterno" maxlength="100" cssStyle="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>(*) Apellido materno:</td>
			<td colspan="2">
				<form:input path="apeMaterno" id="manApellidoMaterno" maxlength="100" cssStyle="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>(*) Nombres:</td>
			<td colspan="2">
				<form:input path="nomMandat" id="manNombres" maxlength="100" cssStyle="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>(*) Direcci&oacute;n:</td>
			<td colspan="2">
				<form:input path="dirMandat" id="manDireccion" maxlength="100" cssStyle="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>Profesi&oacute;n:</td>
			<td colspan="2">
				<form:input path="desProfesion" id="manProfesion" maxlength="100" cssStyle="font-size:13px; width:180px"/>
			</td>
		</tr>
		<tr>
			<td>Insc. Registral:</td>
			<td colspan="2">
				<form:input path="clvInsreg" id="manInscripcionRegistral" maxlength="100" cssStyle="font-size:13px; width:180px"/>
			</td>
		</tr>
	</table>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td colspan="2" height="35px" valign="bottom" align="center">
				<table cellspacing="5">
					<tr>
						<td><button id="manBtnGrabar" onclick="grabarMandatario()">Aceptar</button></td>
						<td><button onclick="cancelar()">Cancelar</button></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form:form>
</div>
</div>
</div>
</body>
</html>