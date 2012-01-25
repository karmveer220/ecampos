<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page import="pe.gob.pcm.constitucion.web.bean.Parametro"%>
<%@page import="java.util.List"%>

<script>
	function grabar(){
		document.forms[0].submit();
	}
</script>

<form id="personaForm" name="personaForm" action="registrapn.htm" method="post">
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
						<td align="left" width="160px" style="padding-left:10px">(<b>+</b>) <b>Tipo documento</b>:</td>
						<td colspan="2" width="440px" align="left">
							<select id="personaTipoDocumento" name="tipoDocumento"
									style="width:200px"
									onChange="notarios.cmbperTipoDocu()">
								<option value="01" selected="selected">D.N.I.</option>
								<option value="02">CARNET EXTRANJERIA</option>
								<option value="03">PASAPORTE</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(<b>+</b>) <b>N&uacute;mero de documento</b>:</td>
						<td align="left" width="135px">
							<input id="personaNumeroDocumento" name="numeroDocumento"
								   type="text"
								   maxLength="8" 
								   style="font-size:13px; width:120px"
								   onChange="notarios.cmbperNumeDocu()"/>
						</td>
						<td align="left">
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Paterno:</td>
						<td colspan="2" align="left">
							<input id="personaApellidoPaterno" name="apellidoPaterno"
								   type="text" maxLength="100" 
								   style="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Materno:</td>
						<td colspan="2" align="left">
							<input id="personaApellidoMaterno" name="apellidoMaterno"
								   type="text" maxLength="100" 
								   style="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nombres:</td>
						<td colspan="2" align="left">
							<input id="personaNombres" name="nombres"
								   type="text" maxLength="100"
								   style="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nacionalidad:</td>
						<td colspan="2" align="left">
							<select id="personaNacionalidad" name="nacionalidad" style="width:200px">
								<option value="PE" selected="selected">PERU</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">Profesion/Ocupaci&oacute;n:</td>
						<td colspan="2" align="left">
							<input id="personaProfesion" name="profesion"
								   type="text" maxLength="100"
								   style="font-size:13px; width:270px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Domicilio / Direcci&oacute;n:</td>
						<td colspan="2" align="left">
							<input id="personaDireccion" name="direccion"
								   type="text" maxLength="100" 
								   style="font-size:13px; width:300px"/>
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
					<tr>
						<td align="left" style="padding-left:10px">(*) Estado Civil:</td>
						<td colspan="2" align="left">
							<select id="personaEstadoCivil" name="estadoCivil"
									style="width:200px"
									onChange="notarios.cmbperEstadoCivil()">
								<option value="00" selected="selected">SELECCIONE ESTADO CIVIL</option>
								<option value="01" selected="selected">SOLTERO</option>
								<option value="02" selected="selected">CASADO</option>
								<option value="03" selected="selected">DIVORCIADO</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="left">
					
							<div id="personaCasado" style="border:1px solid #ccc; padding:4px; ">
								<table cellspacing="5" width="100%">
									<tr>
										<td width="165px">(*) Tipo documento conyuge:</td>
										<td width="435px" colspan="2">
											<select id="personaTipoDocumentoCon" name="tipoDocumentoCon"
													style="width:200px"
													onChange="notarios.cmbperTipoDocuCon()">
												<option value="01" selected="selected">D.N.I.</option>
												<option value="02">CARNET EXTRANJERIA</option>
												<option value="03">PASAPORTE</option>
											</select>
										</td>
									</tr>
									<tr>
										<td>(*) N&uacute;mero de documento:</td>
										<td>
											<input id="personaNumeroDocumentoCon" name="numeroDocumentoCon"
												   type="text" maxLength="8"
												   style="font-size:13px; width:120px"
												   onChange="notarios.cmbperNumeDocuCon()"/>
										</td>
										<td>
											<button id="personaBtnConReniec" onclick="notarios.cmbperValidDocuCon()">RENIEC</button>
										</td>
									</tr>
									<tr>
										<td>(*) Apellido paterno conyuge:</td>
										<td colspan="2">
											<input id="personaApellidoPaternoCon" name="apellidoPaternoCon"
												   type="text" maxLength="100"
												   style="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Apellido materno conyuge:</td>
										<td colspan="2">
											<input id="personaApellidoMaternoCon" name="apellidoMaternoCon"
												   type="text" maxLength="100" style="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Nombres conyuge:</td>
										<td colspan="2">
											<input id="personaNombresCon" name="nombresCon"
												   type="text" maxLength="100"  style="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Profesi&oacute;n conyuge:</td>
										<td colspan="2">
											<input id="personaProfesionCon" name="profesionCon"
												   type="text" maxLength="100" style="font-size:13px; width:270px"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Tipo de aporte:</td>
						<td colspan="2" align="left">
							<input id="personaTipoAporte" type="hidden" name="tipoAporte" value=""/>
							<input value="" style="width:180px;margin-left:2px"/>
						</td>
					</tr>	
					<tr>
						<td colspan="3" align="left">
							<div id="divMontoAporte" style="">
								<table cellspacing ="0" width="100%">
									<tr>
										<td width="167px" style="padding-left:10px">Monto Aporte S/.:</td>
										<td width="433px">
											<input id="personaMontoAporte" name="montoAporte"
												 type="text" maxLength="18" style="font-size:13px; width:180px"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="left">
							
							<button  onclick="javascript:grabar();">Grabar</button>
						
							<div id="toolbarAportes" style="border:1px solid #99BBE8; border-Bottom:0px; width:610px;">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Lista de aporte de bienes</b></div>
								
								<button  onclick="notarios.adicionarAporte()">Adicionar</button>
								<button  onclick="notarios.editarAporte()">Editar</button>
								<button  onclick="notarios.eliminarAporte()">Eliminar</button>
							</div>
							<div id="divGridAportes" style="border:1px solid #99BBE8; position:relative; text-align:left; height:150px; width:614px;">
								<table jsid="gridAportes" id="gridAportes" dojoType="dojox.grid.DataGrid" store="storeAportes" rowsPerPage="20" selectionMode="single">
									<script type="dojo/method" event="onRowDblClick" args="cell"> 
										if(cell) notarios.editarAporte();
									</script>
									<thead>
										<tr>
											<th field="cantidadBien" width="120px">Cantidad</th>
											<th field="descripcionBien" width="280px">Descripci&oacute;n de bienes</th>
											<th field="montoBien" width="120px">Valor de Mercado</th>
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
</form>

<jsp:include page="include/footer.jsp" flush="true"/>