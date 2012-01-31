<%@page import="pe.gob.pcm.constitucion.web.model.T001parametro"%>
<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page import="java.util.List"%>

<script>
	
	function grabar(){
		///document.forms[0].action='${pageContext.request.contextPath}/participantes/registrapj.htm';
		document.forms[0].submit();
	}
	
	function cancelar(){
		document.forms[0].action='${pageContext.request.contextPath}/participantes/cancelapj.htm';
		document.forms[0].submit();
	}
	
</script>


<form:form name="personaForm" action="registrapj.htm" method="post" modelAttribute="persona">

	<form:hidden path="idPerjur"/>		
	<input id="personaTipo" type="hidden" name="tipo" value="JURIDICA"/>
	<input id="personaTipoDocumento" type="hidden" name="tipoDocumento" value="06"/>
	
	<table width="90%">
		<tr>
			<td align="center">
				<table cellspacing="10" width="640px">
					<tr>
						<td colspan="3" align="left" style="color:gray;border-bottom:1px solid #ccc"><b><span id="personaAsunto">Nueva persona juridica</span></b></td>
					</tr>
					<tr>
						<td align="left" width="210px" style="padding-left:10px">(<b>+</b>) <b>Tipo Participante</b>:</td>
						<td colspan="2" width="395px" align="left">
							<select id="personaTipoParticipante" name="tipoParticipante" style="width:240px">
								<option value="0000">SELECCIONE TIPO DE PARTICIPANTE</option>
									<%	List<T001parametro> lsParticipante = (List<T001parametro>)request.getAttribute("lsParticipante");
										for(T001parametro p : lsParticipante) {%>
										<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
									<%	}%>
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" width="210px" style="padding-left:10px">(<b>+</b>) <b>N&uacute;mero RUC</b>:</td>
						<td align="left" width="130px">
							<form:input path=""numDocum id="personaNumeroDocumento" maxlength="11" cssStyle="font-size:13px; width:120px" onchange="notarios.cmbperNumeDocuRuc()"/>
						</td>
						<td align="left" width="265px">
							<button id="personaBtnSunat" onclick="notarios.cmbperValidDocuRuc()">SUNAT</button>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Raz&oacute;n Social:</td>
						<td colspan="2" align="left">
							<form:input path="nomRazsoc" id="personaRazonSocial" maxlength="200" cssStyle="font-size:13px; width:370px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Direcci&oacute;n:</td>
						<td colspan="2" align="left">
							<form:input path="dirPerjur" id="personaDireccion" maxlength="200" cssStyle="font-size:13px; width:370px"/>
						</td>						
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Siglas:</td>
						<td colspan ="2" align="left">
							<form:input path="desSiglas" id="personaSiglas" maxlength="100" cssStyle="font-size:13px; width:180px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Insc. Registral(Partida/Ficha/Tomo):</td>
						<td colspan="2" align="left">
							<form:input path="clvInsreg" id="personaInscripcionRegistral" maxlength="30" cssStyle="font-size:13px; width:180px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Zona Registral:</td>
						<td colspan="2" align="left">
							<form:select path="codZonreg"></form:select>
							<select id="personaZonaRegistral" name="zonaRegistral" style="width:370px" onChange="notarios.cmbperZonaRegistral()">
										<option value="00" selected="selected">SELECCIONE LA ZONA REGISTRAL</option>
										<option value="11">lima</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Oficina Registral:</td>
						<td colspan="2" align="left">
						<form:select path="codOficreg"></form:select>
							<select id="personaOficinaRegistral" name="oficinaRegistral" style="width:370px">
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Tipo de aporte:</td>
						<td colspan="2" align="left">
							//si tipo aporte != ambos
							<form:hidden path="indAporte" id="personaTipoAporte" />
							DesTipoAporte
							
							//SINO 
							//value = persona.gettipoaporte
							<select id="personaTipoAporte" name="tipoAporte" style="width:220px"
								onChange="notarios.cmbperTipoAporte()">
								<%	List<T001parametro> lsTipoAporteJ = (List<T001parametro>)request.getAttribute("lsTipoAporte");
									for(T001parametro p : lsTipoAporteJ) {%>
									<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
								<%	}%>
							</select>
						</td>
					</tr>	
					<tr>
						<td colspan="3" align="left">
							//si en el combo escogo que aporta Dinerario o ambos muestro el campo monto 
							<div id="divMontoAporte" style="">
								<table cellspacing ="0" width="100%">
									<tr>
										<td width="205px" style="padding-left:10px">Monto Aporte S/.:</td>
										<td width="395px">
											<form:input path="" id="personaMontoAporte" maxlength="18" cssStyle="font-size:13px; width:180px"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="left">
						//si es no dinerario o ambos, muestro este detalle de bienes
							<div id="toolbarAportes" style="border:1px solid #99BBE8; border-Bottom:0px; width:610px;">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Lista de aporte de bienes</b></div>
								<button onclick="notarios.adicionarAporte()">Adicionar</button>
								//adicionar me carga pop up para adicionar aporte no dinerario
								<button onclick="notarios.editarAporte()">Editar</button>
								<button onclick="notarios.eliminarAporte()">Eliminar</button>
							</div>
							<div id="divGridAportes" style="border:1px solid #99BBE8; position:relative; text-align:left; height:150px; width:614px;">
								<table>
									<thead>
										<tr>
											<th width="120px">Cantidad</th>
											<th width="280px">Descripci&oacute;n de bienes</th>
											<th width="120px">Valor de Mercado</th>
										</tr>
									</thead>
								</table>
							</div>
							
						</td>
					</tr>

					<tr>
						<td colspan="3" align="left">
						
							<button  onclick="javascript:grabar();">Grabar</button>
						
							<div style="border:1px solid #99BBE8; border-Bottom:0px; width:610px">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Representantes Legales</b></div>
								<button onclick="notarios.adicionarReps()">Adicionar</button>
								<button onclick="notarios.editarReps()">Editar</button>
								<button onclick="notarios.eliminarReps()">Eliminar</button>
							</div>
							//muestro lista de representantes y opciones para agregar pmas representantes leghales para esta PJ
							<div id="divGridReps" style="border:1px solid #99BBE8; position:relative; text-align:left; height:150px; width:614px;">
								<table>
									<thead>
										<tr>
											<th width="300px">Nombre Completo</th>
											<th width="130px">Tipo Documento</th>
											<th width="110px">N&uacute;mero Documento</th>
											<th  width="280px">Direcci&oacute;n</th>
										</tr>
									</thead>
								</table>
							</div>
							
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form:form>


<jsp:include page="include/footer.jsp" flush="true"/>