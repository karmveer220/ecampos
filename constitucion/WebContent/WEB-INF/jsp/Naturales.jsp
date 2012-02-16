<%@page import="pe.gob.pcm.constitucion.web.model.T001parametro"%>
<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page import="pe.gob.pcm.constitucion.web.bean.Parametro"%>
<%@page import="java.util.List"%>

<script>
	function grabar(){		
		document.forms[0].submit();
	}
	function perEstadoCivil(){
		document.getElementById('personaCasado').style.display='block';
	}
</script>

<form:form name="personaForm" action="registrapn.htm" method="post" modelAttribute="persona">

	<form:hidden path="idPernat"/>
	
	<input id="personaTipo" type="hidden" name="tipo" value="NATURAL"/>
	<input type="hidden" name="action" value="grabaAccionista"/>
	<table width="90%">
		<tr>
			<td align="center">
				<table cellspacing="10" width="640px">
					<tr>
						<td colspan="3" align="left" style="color:gray;border-bottom:1px solid #ccc"><b><span id="personaAsunto">Persona Natural</span></b></td>
					</tr>
					<tr>
						<td align="left" width="160px" style="padding-left:10px">(<b>+</b>) <b>Tipo Participante</b>:</td>
						<td colspan="2" width="440px" align="left">
							<form:select path="codParticipa" id="personaTipoParticipante" cssStyle="width:240px">
								<option value="0000">SELECCIONE TIPO DE PARTICIPANTE</option>
								<%	List<T001parametro> lsTipoSociedad = (List<T001parametro>)request.getAttribute("lsParticipante");
									for(T001parametro p : lsTipoSociedad) {%>
								<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
								<%	}%>
							</form:select>
						</td>
					</tr>
					<tr>
						<td align="left" width="160px" style="padding-left:10px">(<b>+</b>) <b>Tipo documento</b>:</td>
						<td colspan="2" width="440px" align="left">
							<form:select path="codTipdoc" id="personaTipoDocumento" cssStyle="width:200px" onchange="notarios.cmbperTipoDocu()">
								<form:option value="01">DNI</form:option>
								<form:option value="02">CARNET EXTRANJERIA</form:option>
								<form:option value="03">PASAPORTE</form:option>							
							</form:select>

						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(<b>+</b>) <b>N&uacute;mero de documento</b>:</td>
						<td align="left" width="135px">
							<form:input path="numDocum" id="personaNumeroDocumento" maxlength="8" cssStyle="font-size:13px; width:120px" onchange="notarios.cmbperNumeDocu()"/>
						</td>
						<td align="left">
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Paterno:</td>
						<td colspan="2" align="left">
							<form:input path="apePaterno" id="personaApellidoPaterno"  maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Materno:</td>
						<td colspan="2" align="left">
							<form:input path="apeMaterno" id="personaApellidoMaterno" maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nombres:</td>
						<td colspan="2" align="left">
							<form:input path="nomPernat" id="personaNombres" maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nacionalidad:</td>
						<td colspan="2" align="left">
							<form:select path="codPais" id="personaNacionalidad" cssStyle="width:200px">
								<option value="PE" selected="selected">PERU</option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">Profesion/Ocupaci&oacute;n:</td>
						<td colspan="2" align="left">
							<form:input path="desProfesion" id="personaProfesion" maxlength="100" cssStyle="font-size:13px; width:270px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Domicilio / Direcci&oacute;n:</td>
						<td colspan="2" align="left">
							<form:input path="dirPernat" id="personaDireccion" maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>						
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Departamento:</td>
						<td colspan="2" align="left">
							<select id="personaDepartamento" name="departamento"
									style="width:270px" onChange="notarios.cmbperDepartamento()">
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Provincia:</td>
						<td colspan="2" align="left">
							<select id="personaProvincia" name="provincia"
									style="width:270px" onChange="notarios.cmbperProvincia()">
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Distrito:</td>
						<td colspan="2" align="left">
							<select id="personaDistrito" name="distrito" style="width:270px">
							</select>
						</td>
					</tr>
					<% try{
						%>
						
					<tr>
						<td align="left" style="padding-left:10px">(*) Estado Civil:</td>
						<td colspan="2" align="left">
							<form:select path="codEstcivil" id="personaEstadoCivil"  cssStyle="width:200px" onchange="perEstadoCivil()">
								<option value="00" selected="selected">SELECCIONE ESTADO CIVIL</option>
								<option value="01" selected="selected">SOLTERO</option>
								<option value="02" selected="selected">CASADO</option>
								<option value="03" selected="selected">DIVORCIADO</option>
							</form:select>
						</td>
					</tr>
					<% 
					}catch(Exception e){System.out.println("error");} %>
					<tr>
						<td colspan="3" align="left">
					
							<div id="personaCasado" style="border:1px solid #ccc; padding:4px; display: none;">
								<table cellspacing="5" width="100%">
									<tr>
										<td width="165px">(*) Tipo documento conyuge:</td>
										<td width="435px" colspan="2">
											<form:select path="codTdcon" id="personaTipoDocumentoCon" cssStyle="width:200px" onchange="notarios.cmbperTipoDocuCon()">
												<option value="01" selected="selected">D.N.I.</option>
												<option value="02">CARNET EXTRANJERIA</option>
												<option value="03">PASAPORTE</option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td>(*) N&uacute;mero de documento:</td>
										<td>
											<form:input path="numDoccon" id="personaNumeroDocumentoCon" maxlength="8" cssStyle="font-size:13px; width:120px" onchange="notarios.cmbperNumeDocuCon()"/>
										</td>
										<td>
											<button id="personaBtnConReniec" onclick="notarios.cmbperValidDocuCon()">RENIEC</button>
										</td>
									</tr>
									<tr>
										<td>(*) Apellido paterno conyuge:</td>
										<td colspan="2">
											<form:input path="apePatcon" id="personaApellidoPaternoCon" maxlength="100" cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Apellido materno conyuge:</td>
										<td colspan="2">
											<form:input path="apeMatcon" id="personaApellidoMaternoCon" maxlength="100" cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Nombres conyuge:</td>
										<td colspan="2">
											<form:input path="nomConyuge" id="personaNombresCon" maxlength="100"  cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Profesi&oacute;n conyuge:</td>
										<td colspan="2">
											<form:input path="desProfcon" id="personaProfesionCon" maxlength="100" cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Tipo de aporte:</td>
						<td colspan="2" align="left">
						//si tipo de aporte es != de Ambos
							<form:hidden path="indAporte" id="personaTipoAporte" />
							muestro desciocion del tipo de aporte
							
							//sino muestro combo
								<select id="personaTipoAporte" name="tipoAporte" style="width:220px"
								onChange="notarios.cmbperTipoAporte()">
								<%	List<T001parametro> lsTipoAporteJ = (List<T001parametro>)request.getAttribute("lsTipoAporte");
									if(lsTipoAporteJ!=null)for(T001parametro p : lsTipoAporteJ) {%>
									<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
								<%	}%>
							</select>
						</td>
					</tr>	
					<tr>
						<td colspan="3" align="left">
							<div id="divMontoAporte" style="">
								<table cellspacing ="0" width="100%">
									<tr>
										<td width="167px" style="padding-left:10px">Monto Aporte S/.:</td>
										<td width="433px">
											//si en el combo escogo que aporta Dinerario o ambos muestro el campo monto
											<form:input path="montoAporte" id="personaMontoAporte" maxlength="18" cssStyle="font-size:13px; width:180px"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="left">
							
							<button  onclick="javascript:grabar();">Grabar</button>
							
							//si es no dinerario o ambos, muestro este detalle de bienes
							<div id="toolbarAportes" style="border:1px solid #99BBE8; border-Bottom:0px; width:610px;">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Lista de aporte de bienes</b></div>
								<button  onclick="notarios.adicionarAporte()">Adicionar</button>
								<button  onclick="notarios.editarAporte()">Editar</button>
								<button  onclick="notarios.eliminarAporte()">Eliminar</button>
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
				</table>
			</td>
		</tr>
	</table>
</form:form>

<jsp:include page="include/footer.jsp" flush="true"/>