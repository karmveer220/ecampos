<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
<link rel="stylesheet" type="text/css" media="all" href="css/calendar-system.css" title="system" />
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/calendar-es.js"></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>

<script type="text/javascript">
	function limpiar() {
		document.forms[0].action = "clave.do";
		document.forms[0].method.value = "cambioClave";
		document.forms[0].dnacimiento.value = '';
		document.forms[0].snombre.focus();
	}
</script>

<html:form action="clave">
	<input name="method" type="hidden" value="cambioClave" />

	<table width="600px" border="0" align="center" cellpadding="3"
		cellspacing="0" class="tFormulario">
		<tr>
			<th width="27%">Nombres :</th>
			<td width="54%">
				<bean:write name="usrLogin" property="snombre" />&nbsp;
				<bean:write name="usrLogin" property="spaterno" />&nbsp;
				<bean:write name="usrLogin" property="smaterno" />
			</td>
		</tr>
		<tr>
			<th>Usuario :</th>
			<td><bean:write name="usrLogin" property="susuario" /></td>
		</tr>
		<tr>
			<th>Clave actual :</th>
			<td><html:password property="clave" styleClass="input" /></td>
		</tr>
		<tr>
			<th>Nueva Clave :</th>
			<td><html:password property="nuevaClave" styleClass="input" /></td>
		</tr>
		<tr>
			<th>Confirmar Nueva Clave :</th>
			<td><html:password property="confirmarClave" styleClass="input" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input name="btnEnviar" type="submit" class="botonAz" id="btnEnviar" value="Enviar">&nbsp;&nbsp;
				<input name="Submit2" type="button" class="botonAz" value="Limpiar" onClick="javascript:limpiar();" />
			</td>
		</tr>
	</table>


</html:form>