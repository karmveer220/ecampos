<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page import="java.util.List"%>

<script>
	function grabar(){
		document.forms[0].submit();
	}
</script>


<form id="personaForm" name="personaForm" action="registrapj.htm" method="post">
	<input id="personaTipo" type="hidden" name="tipo" value="JURIDICA"/>
	<input type="hidden" name="action" value="grabaAccionista"/>
	<input id="personaTipoDocumento" type="hidden" name="tipoDocumento" value="06"/>
	<table width="90%">
		<tr>
			<td align="center">
				<table cellspacing="10" width="640px">
					<tr>
						<td colspan="3" align="left" style="color:gray;border-bottom:1px solid #ccc"><b><span id="personaAsunto">Nueva persona juridica</span></b></td>
					</tr>
					<tr>
						<td align="left" width="210px" style="padding-left:10px">(<b>+</b>) <b>N&uacute;mero RUC</b>:</td>
						<td align="left" width="130px">
							<input id="personaNumeroDocumento" name="numeroDocumento"
									type="text" maxLength="11"
								   style="font-size:13px; width:120px"
								   onChange="notarios.cmbperNumeDocuRuc()"/>
						</td>
						<td align="left" width="265px">
							<button id="personaBtnSunat" onclick="notarios.cmbperValidDocuRuc()">SUNAT</button>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Raz&oacute;n Social:</td>
						<td colspan="2" align="left">
							<input id="personaRazonSocial" name="razonSocial"
								   type="text" maxLength="200" 
								   style="font-size:13px; width:370px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Direcci&oacute;n:</td>
						<td colspan="2" align="left">
							<input id="personaDireccion" name="direccion" type="text" maxLength="200" 
								   style="font-size:13px; width:370px"/>
						</td>						
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Siglas:</td>
						<td colspan ="2" align="left">
							<input id="personaSiglas" name="siglas"
								   type="text" maxLength="100" style="font-size:13px; width:180px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Insc. Registral(Partida/Ficha/Tomo):</td>
						<td colspan="2" align="left">
							<input id="personaInscripcionRegistral" name="inscripcionRegistral"
								   type="text" maxLength="30"  style="font-size:13px; width:180px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Zona Registral:</td>
						<td colspan="2" align="left">
							<select id="personaZonaRegistral" name="zonaRegistral"
									style="width:370px" onChange="notarios.cmbperZonaRegistral()">
										<option value="00" selected="selected">SELECCIONE LA ZONA REGISTRAL</option>
										<option value="11">lima</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Oficina Registral:</td>
						<td colspan="2" align="left">
							<select id="personaOficinaRegistral" name="oficinaRegistral" style="width:370px">
							</select>
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
										<td width="205px" style="padding-left:10px">Monto Aporte S/.:</td>
										<td width="395px">
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
							<div id="toolbarAportes" dojoType="dijit.Toolbar" style="border:1px solid #99BBE8; border-Bottom:0px; width:610px;">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Lista de aporte de bienes</b></div>
								<span dojoType="dijit.ToolbarSeparator"></span>
								<button onclick="notarios.adicionarAporte()">Adicionar</button>
								<button onclick="notarios.editarAporte()">Editar</button>
								<button onclick="notarios.eliminarAporte()">Eliminar</button>
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

					<tr>
						<td colspan="3" align="left">
						
							<button  onclick="javascript:grabar();">Grabar</button>
						
							<div dojoType="dijit.Toolbar" style="border:1px solid #99BBE8; border-Bottom:0px; width:610px">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Representantes Legales</b></div>
								<span dojoType="dijit.ToolbarSeparator"></span>
								<button onclick="notarios.adicionarReps()">Adicionar</button>
								<button onclick="notarios.editarReps()">Editar</button>
								<button onclick="notarios.eliminarReps()">Eliminar</button>
							</div>
							<div id="divGridReps" style="border:1px solid #99BBE8; position:relative; text-align:left; height:150px; width:614px;">
								<table jsid="gridReps" id="gridReps" dojoType="dojox.grid.DataGrid" store="storeReps" rowsPerPage="20" selectionMode="single">
									<script type="dojo/method" event="onRowDblClick" args="cell"> 
										if(cell) notarios.editarReps();
									</script>
									<thead>
										<tr>
											<th field="nombreCompleto" width="300px">Nombre Completo</th>
											<th field="desTipoDocumento" width="130px">Tipo Documento</th>
											<th field="numeroDocumentoRep" width="110px">N&uacute;mero Documento</th>
											<th field="direccion" width="280px">Direcci&oacute;n</th>
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