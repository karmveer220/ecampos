<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Bolet&iacute;n Informativo del Ministerio del Interior</title>
<%@ include file="../jsp/taglibs.jsp"%>
<script type="text/javascript" src="js/jquery.displaytag-ajax-1.2.js"></script>

<script language="javascript" type="text/javascript">
	$( function(){
		$("#displayTagDiv").displayTagAjax();
	});
</script>
 
</head>

<body>
	<form:form action="enviarCorreo.htm" method="post" modelAttribute="correo">
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">		
		<tr>
			<td height="115" colspan="2" valign="top"><jsp:include page="cabecera.jsp" /></td>
		</tr>
		<tr>
			<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
			<td width="698" valign="top">
				<table border="0" cellspacing="0" cellpadding="0" >
					<tr>
						<td height="2"><img src="images/blank.jpg" width="2" /></td>
					</tr>
					<tr>
						<td height="150" valign="top" width="700">
							<div align="center">
							<table border="0">
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<th>Ingreso de Incidencias a Soporte T&eacute;cnico (Sector Interior) </th>
								</tr>
								<tr>
									<td>
										<div align="center" style="color: red"> <c:out value="${msgError}"/> </div>
										<div align="center" style="color: blue"> <c:out value="${mensaje}"/> </div>
									</td>
								</tr>
								<tr>
									<td>
										<table width="500" border="0" cellspacing="2" cellpadding="2">
										  <tr>
										    <th colspan="3" align="left">Datos del Solicitante</th>
										  </tr>
										  <tr>
										  	<td colspan="3" align="center">
										  		<table width="400" border="0">
										  			<tr>
										  				<td width="110" align="left">Usuario Atenci&oacute;n</td>
													    <td width="20">:</td>
													    <td align="left">
													    	<input name="" value="${usuario.nombreCompleto}" disabled="disabled" size="30" />
													    	<form:hidden path="siminMaestro.cperlCodigo" value="${usuario.cperlCodigo}" />
													    </td>
										  			</tr>
										  			<tr>
													    <td width="110" align="left">Dependencia</td>
													    <td>:</td>
													    <td align="left"><input name="" value="${usuario.siminUnidadorganica1.nunoDescripcion}" disabled="disabled" size="30"/></td>
													  </tr>
													  <tr>
													    <td width="110" align="left">Ubicaci&oacute;n (Piso)</td>
													    <td>:</td>
													    <td align="left">
													    	<form:select path="naMailPiso" id="naMailPiso">
													    		<form:option value="-1">--Seleccionar--</form:option>
													    		<form:option value="1er. Piso">1er. Piso</form:option>
													    		<form:option value="2do. Piso">2do. Piso</form:option>
													    		<form:option value="3er. Piso">3er. Piso</form:option>
													    		<form:option value="4to. Piso">4to. Piso</form:option>
													    		<form:option value="5to. Piso">5to. Piso</form:option>
													    		<form:option value="6to. Piso">6to. Piso</form:option>
													    	</form:select>&nbsp;<span style="color: red">*</span>
												    	</td>
													  </tr>
													  <tr>
													    <td width="110" align="left">Celular o Anexo</td>
													    <td>:</td>
													    <td align="left">
													    	<form:input path="naMailContacto" id="naMailContacto" size="30"/>&nbsp;<span style="color: red">*</span>
													    </td>
													  </tr>
													  <tr>
													    <td width="110" align="left">Correo Institucional</td>
													    <td>:</td>
													    <td align="left">
													    	<input name="email" id="email" value="${usuario.nmstEmail}" size="30"/>
													    </td>
													  </tr>
													  <tr>
													    <td colspan="2"></td>
													    <td align="left" height="10">
													    	<span style="color: red">* Actualizar si no figura el correo institucional</span>
													    </td>
													  </tr>
										  		</table>
										  	</td>										    
										  </tr>										  
										  <tr>
										    <td colspan="3">&nbsp;</td>
										  </tr>
										  <tr>
										    <th colspan="3" align="left">Datos del Requerimiento</th>
										  </tr>
										  <tr>
										  	<td align="center">
										  		<table width="400" border="0">
												  	<tr>
													    <td colspan="3" align="left" height="20">Describa el Requerimiento</td>
													</tr>
													<tr>
													    <td colspan="3" align="left">
											    			<form:textarea path="naMailRequerimiento" id="naMailRequerimiento" rows="5" cols="48"/>&nbsp;<span style="color: red">*</span>
													    </td>
												  	</tr>
										  		</table>
										  	</td>
										  </tr>
										  <tr>
										  	<td align="center">
												<input type="submit" value="Enviar"/>
											</td>
										  </tr> 
										  <tr>
										  	<td align="center">&nbsp;</td>
										  </tr> 
										  <tr>
										  	<td align="left" style="color: red;">
												*Horario de Atenci&oacute;n 8:30am - 9:00pm (Solo a personal dentro del Ministerio del Interior)
											</td>
										  </tr>
									   </table>
									</td>
								</tr>
								 
							</table>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left">&nbsp;</td>
					</tr>
					<tr>
					  	<td align="left" width="680">
					  		<div id="displayTagDiv">
							<display:table name="requestScope.lstCorreos" requestURI="correo.htm?ajx=1" class="displaytag" pagesize="3"
								defaultsort="0" defaultorder="ascending" sort="list" export="false" id="row" excludedParams="ajax">
								<display:column title="Codigo Atencion" property="coMailGenerado" sortable="true" headerClass="sortable" />
								<display:column title="Requerimiento" property="naMailRequerimiento" sortable="true" headerClass="sortable" />
								
								<display:column title="Fec. Requerimiento" sortable="true" headerClass="sortable">
                                	<fmt:formatDate value="${row.daMailFecha}" pattern="dd/MM/yyyy hh:mm:ss"/>
                          		</display:column>
                           		<display:column title="Estado" class="definition" sortable="true" headerClass="sortable">
									<c:if test="${row.faMailEstado==1}">Pendiente</c:if>
									<c:if test="${row.faMailEstado==2}">Atendido</c:if>
								</display:column>
							</display:table>
							</div>
						</td>
			  		</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="pie"><jsp:include page="copyright.jsp" />
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>