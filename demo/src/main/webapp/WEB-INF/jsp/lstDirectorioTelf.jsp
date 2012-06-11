<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Directorio Telef&oacute;nico del Ministerio del Interior</title>
<%@ include file="../jsp/taglibs.jsp"%>

<script language="javascript" type="text/javascript">
	function buscarDirectorioTelf(){	
		document.forms[0].action = "directorioTelf.htm";
		document.forms[0].submit();
	}
</script>
</head>

<body>	  
	<form:form action="rptdirectoriotelf.htm" modelAttribute="oficina">
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">
	  	<tr>
	    	<td height="115" colspan="2" valign="top"> <jsp:include page="cabecera.jsp"/> </td>
	 	</tr>
	  	<tr>
		    <td width="200" valign="top" > <jsp:include page="menu.jsp"/> </td>
		    <td width="700" valign="top">
		    	<div align="center">
		    	<table width="680" border="0" cellspacing="0" cellpadding="0">
		      	<tr>
		        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" /></td>
		        </tr>
		      	<tr>
		        	<td height="150" valign="top" bgcolor="#FFFFFF">	
		        		<br/>
		        		<table width="100%" border="0">
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr>
								<th colspan="5" class="tituloEncabezado">Reporte Directorio Telefonico</th>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr>
								<th>Buscar por Dependencia</th>
								<td>
									<form:select path="nunoGeneralAbrev">
									<form:option value="-1">Seleccionar</form:option>
										<form:options items="${lstOficinas}" itemLabel="nunoGeneralAbrev" itemValue="nunoGeneralAbrev"/>
									</form:select>
								</td>
								<td align="center">o</td>
								<td>
									<form:input path="nunoDescripcion" cssClass="text" size="15" maxlength="10"/>
								</td>
								<td>
									<a href="javascript:buscarDirectorioTelf();"><img width="30" height="30" src="images/buscar.png" border="0" alt="Buscar" /></a>
								</td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="5" align="left">
									<display:table name="requestScope.ldirectorioTelf" requestURI="directorioTelf.htm" class="displaytag" pagesize="20"
									defaultsort="1" defaultorder="ascending" sort="list" export="false" id="row" excludedParams="ajax">
										<display:column title="Dependencia" property="ndirDescripcion" sortable="true" headerClass="sortable" />
										<display:column title="Abreviatura" property="siminUnidadorganica.nunoAbreviatura" sortable="true" headerClass="sortable" />
										<display:column title="Telefono" property="ndirTelefono" sortable="true" headerClass="sortable" />
										<display:column title="Anexo" property="ndirAnexo" sortable="true" headerClass="sortable" />
									</display:table>
								</td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							</table>
						</td>
	       		</tr>
		    	</table>
		    	</div>
	    	</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2" class="pie">  <jsp:include page="copyright.jsp"/> </td>
	  	</tr>
	  	
	</table>
	</form:form>
</body>
</html>