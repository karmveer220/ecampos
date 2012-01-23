<%@ page import="pe.org.notarios.sisev.constitucion.domain.Tramite"%>
<%@ page import="pe.org.notarios.sisev.constitucion.util.TramiteUtil"%>
<%Tramite tramite = (Tramite)request.getSession().getAttribute("tramiteActual");%>
<span dojoType="dojo.data.ItemFileWriteStore" jsId="storeAccionistas" url="accionistas.do?action=getAccionistasTramite" urlPreventCache="true" clearOnClose="true"></span>
<div dojoType="dijit.layout.BorderContainer" gutters="false" style="overflow:hidden">
	<div dojoType="dijit.layout.ContentPane" region="top"  class="x-panel-header" style="border-bottom: 0px; padding: 5px 8px">
	 Tr&aacute;mite - CUO: <%=TramiteUtil.showValue(tramite.getDesIndicadorCuo())%>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="center" splitter="false" style="background:white; border:1px solid #99BBE8">
		<table width="90%">
			<tr>
				<td align="center">
					<table cellspacing="10" width="640px">
						<tr>
							<td align="left" width="200px">Tipo de Sociedad:</td>
							<td align="left" width="200px" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDesTipoSociedad())%></b></td>
						</tr>
						<tr>
							<td align="left">Zona:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDesZonaRegistral())%></b></td>
						</tr>
						<tr>
							<td align="left">Oficina Registral:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDesOficinaRegistral())%></b></td>
						</tr>
						<tr>
							<td align="left">Kardex:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getKardex())%></b></td>
						</tr>
						<tr>
							<td align="left">DNI Solicitante:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDniSolicitante())%></b></td>
						</tr>
						<tr>
							<td align="left">Fecha de inicio de escritura publica:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getFechaRegistro())%></b></td>
						</tr>
						<tr>
							<td align="left">Denominaci&oacute;n y/o Raz&oacute;n Social:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getRazonSocial())%></b></td>
						</tr>
						<tr>
							<td align="left">Denominaci&oacute;n abreviada:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDenominacionAbreviada())%></b></td>
						</tr>
						<tr>
							<td align="left">Departamento:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDesDepartamento())%></b></td>
						</tr>
						<tr>
							<td align="left">Provincia:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDesProvincia())%></b></td>
						</tr>
						<tr>
							<td align="left" valign="top">Objeto Social:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showTexto(tramite.getObjetoSocial())%></b></td>
						</tr>
						<tr>
							<td align="left">Monto S/.:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getMontoAporte())%></b></td>
						</tr>
						<tr>
							<td align="left">Valor de accion/participaci&oacute;n S/.:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getValorAccion())%></b></td>
						</tr>
						<tr>
							<td align="left">Acciones:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getCantidadAcciones())%></b></td>
						</tr>
						<tr>
							<td align="left">Cancelaci&oacute;n de capital:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDesCancelacionCapital())%></b></td>
						</tr>
						<tr>
							<td align="left">Porcentaje Cancelado:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getPorcentajeCancelado())%></b> %</td>
						</tr>
						<tr>
							<td align="left">Derechos registrales S/.:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDerechoRegistral())%></b></td>
						</tr>
						<tr>
							<td align="left">Forma de Pago:</td>
							<td align="left" colspan="3"><b><%=TramiteUtil.showValue(tramite.getDesFormaPago())%></b></td>
						</tr>
						<tr>
							<td align="left" colspan="4">
								<button dojoType="dijit.form.Button"
										iconClass="icon-by-view"
<%	if(tramite.getParte() == null) {%>
										disabled="true"
<% 	}%>
										onclick="notarios.contenidoParte()">Ver Parte</button>
							</td>
						</tr>
						<tr>
							<td align="left" colspan="4" style="color:gray"><b><span id="personaAsunto"><u>&nbsp;Accionistas / Socios&nbsp;</u></span></b></td>
						</tr>
						<tr>
							<td align="left" colspan="4">
								<div style="overflow:hidden;width:600px;height:200px;border:1px solid #99BBE8;">
									<table jsid="gridAccionistas" id="gridAccionistas" dojoType="dojox.grid.DataGrid" store="storeAccionistas" rowsPerPage="20" selectionMode="none">
										<thead>
											<tr>
												<th field="tipoAccionista" width="130px">Tipo Accionista / Socio</th>
												<th field="razonSocial" width="300px">Raz&oacute;n Social</th>
												<th field="desTipoDocumento" width="130px">Tipo Documento</th>
												<th field="numeroDocumento" width="110px">N&uacute;mero Documento</th>
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
	</div>
	<div dojoType="dijit.layout.ContentPane" region="bottom" splitter="false" style="overflow:hidden;height:50px;border:1px solid #99BBE8; border-top:0px">
		<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="notarios.salirTramite()">Salir</button></td>
			</tr>
		</table>
	</div>
</div>