<%@ page import="java.util.List"%>
<%@ page import="pe.org.notarios.framework.util.domain.Ubigeo"%>
<%@ page import="pe.org.notarios.sisev.constitucion.domain.Notaria"%>
<%@ page import="pe.org.notarios.sisev.constitucion.util.TramiteUtil"%>
<%	Notaria notaria = null;
	String modo = (String)request.getAttribute("modo");
	boolean isEdit = (modo.equals("EDIT") ? true : false);
	if(isEdit) {
		notaria = (Notaria)request.getAttribute("notariaActual");
	}
%>
<span id="storeProvincias" dojoType="dojo.data.ItemFileWriteStore" jsId="storeProvincias" url="consultas.do?action=getUbigeos&ubigeo=<%=(isEdit ? TramiteUtil.getDepartamento(notaria.getCodigoUbigeo(), true) : "000000")%>&tipo=2" urlPreventCache="true" clearOnClose="true"></span>
<span id="storeDistritos" dojoType="dojo.data.ItemFileWriteStore" jsId="storeDistritos" url="consultas.do?action=getUbigeos&ubigeo=<%=(isEdit ? TramiteUtil.getProvincia(notaria.getCodigoUbigeo(), true) : "000100")%>&tipo=3" urlPreventCache="true" clearOnClose="true"></span>

<div dojoType="dijit.layout.ContentPane" style="overflow:hidden;">
	<form id="notarioForm" name="notarioForm" dojoType="dijit.form.Form" onsubmit="return false">
		<input type="hidden" name="action" value="grabaNotaria"/>
		<input id="notarioModo" type="hidden" name="modo" value="<%=modo%>"/>
		<table cellspacing="5" style="width:100%" cellspacing="5">
			<tr>
				<td>
					<div id="notarioTabContainer" dojoType="dijit.layout.TabContainer" class="tabLeft" style="width:100%;height:300px" tabStrip="true" tabPosition="left-h">
						<div id="notarioTabPrincipal" dojoType="dijit.layout.ContentPane" title="Datos Principales" selected="true">
							<table cellspacing="4" style="width:100%">
								<tr>
									<td>(+) <b>C&oacute;digo de Notar&iacute;a</b>:</td>
									<td colspan="2">
										<input id="notarioCodigoNotaria" name="codigoNotaria"
											   dojoType="dojext.form.ValidationTextBox"
											   type="text" maxLength="6" regExp="\w{6}"
											   uppercase="true"
<%	if(isEdit) { %>
								   			   value="<%=TramiteUtil.showValue(notaria.getCodigoNotaria())%>"
								   			   readOnly="true"
<%	}%>
											   style="font-size:13px; width:90px"/>
									</td>
								</tr>
								<tr>
									<td>(+) <b>Raz&oacute;n Social</b>:</td>
									<td colspan="2">
										<input id="notarioRazonSocial" name="razonSocial"
											   dojoType="dijit.form.ValidationTextBox"  
											   type="text" maxLength="100" uppercase="true"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getRazonSocial())%>"
<%	}%>
											   style="font-size:13px; width:270px"/>
									</td>
								</tr>
								<tr>
									<td>(+) <b>N&uacute;mero RUC</b>:</td>
									<td colspan="2">
										<input id="notarioNumeroRuc" name="numeroRuc"
											   dojoType="dijit.form.ValidationTextBox"
											   type="text" maxLength="11"  regExp="\d{11}"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getNumeroRuc())%>"
<%	}%>
											   style="font-size:13px; width:120px"/>
									</td>
								</tr>
								<tr>
									<td>(+) <b>Correo electr&oacute;nico</b>:</td>
									<td colspan="2">
										<input id="notarioEmail" name="email"
											   dojoType="dijit.form.ValidationTextBox"
											   trim="true" maxLength="100"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getCorreoElectronico())%>"
<%	}%>
											   regExpGen="dojox.validate.regexp.emailAddress"
											   invalidMessage="Correo incorrecto"
											   style="font-size:13px; width:270px"/>
									</td>
								</tr>
								<tr>
									<td>Sitio web:</td>
									<td colspan="2">
										<input id="notarioSitioWeb" name="sitioWeb"
											   dojoType="dijit.form.ValidationTextBox"
											   trim="true" maxLength="100"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getDireccionWEB())%>"
<%	}%>
											   regExpGen="dojox.validate.regexp.url"
											   invalidMessage="URL incorrecta"
											   style="font-size:13px; width:270px"/>
									</td>
								</tr>
								<tr>
									<td>Tel&eacute;fono:</td>
									<td colspan="2">
										<input id="notarioTelefono" name="telefono"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getTelefonoPrincipal())%>"
<%	}%>
											   trim="true" maxLength="20"
											   style="font-size:13px; width:120px"/>
									</td>
								</tr>
								<tr>
									<td>Otro tel&eacute;fono:</td>
									<td colspan="2">
										<input id="notarioOtroTelefono" name="otroTelefono"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getTelefonoSecundario())%>"
<%	}%>
											   trim="true" maxLength="20"
											   style="font-size:13px; width:120px"/>
									</td>
								</tr>
								<tr>
									<td>C&oacute;digo de colegio:</td>
									<td colspan="2">
										<input id="notarioCodigoColegio" name="codigoColegio"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getColegioNotario())%>"
<%	}%>
											   type="text" maxLength="4" uppercase="true"
											   style="font-size:13px; width:90px"/>
									</td>
								</tr>
								<tr>
									<td>(+) <b>C&oacute;digo de SUNARP</b>:</td>
									<td colspan="2">
										<input id="notarioCodigoSunarp" name="codigoSunarp"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getCodigoSunarp())%>"
<%	}%>
											   type="text" maxLength="20"  regExp="\w{1,20}" uppercase="true"
											   style="font-size:13px; width:200px"/>
									</td>
								</tr>
							</table>
						</div>
						<div id="notarioTabPresentante" dojoType="dijit.layout.ContentPane" title="Presentante">
							<table cellspacing="5" style="width:100%" cellspacing="5">
								<tr>
									<td>N&uacute;mero de DNI:</td> 
									<td colspan="2">
										<input id="notarioDniPresentante" name="dniPresentante"
											   dojoType="dijit.form.ValidationTextBox"
											   type="text" maxLength="8"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getDniPresentante())%>"
<%	}%>
											   regExp="\d{8}" uppercase="true"
											   style="font-size:13px; width:150px"/>
									</td>
								</tr>
								<tr>
									<td>Apellido Paterno:</td>
									<td colspan="2">
										<input id="notarioApePatPresentante" name="apePatPresentante"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getApePaternoPresentante())%>"
<%	}%>
											   type="text" maxLength="100" uppercase="true"
											   style="font-size:13px; width:270px"/>
									</td>
								</tr>
								<tr>
									<td>Apellido Materno:</td>
									<td colspan="2">
										<input id="notarioApeMatPresentante" name="apeMatPresentante"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getApeMaternoPresentante())%>"
<%	}%>
											   type="text" maxLength="100" uppercase="true"
											   style="font-size:13px; width:270px"/>
									</td>
								</tr>
								<tr>
									<td>Nombres:</td>
									<td colspan="2">
										<input id="notarioNombrePresentante" name="nombrePresentante"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getNombrePresentante())%>"
<%	}%>
											   type="text" maxLength="100" uppercase="true"
											   style="font-size:13px; width:270px"/>
									</td>
								</tr>
							</table>
						</div>
						<div id="notarioTabUbicacion" dojoType="dijit.layout.ContentPane" title="Ubicaci&oacute;n">
							<table cellspacing="5" style="width:100%" cellspacing="5">
								<tr>
									<td>Direcci&oacute;n:</td>
									<td colspan="2">
										<input id="notarioDireccion" name="direccion"
											   dojoType="dijit.form.ValidationTextBox"
<%	if(isEdit) { %>
											   value="<%=TramiteUtil.showValue(notaria.getDireccionNotaria())%>"
<%	}%>
											   type="text" maxLength="100" uppercase="true"
											   style="font-size:13px; width:270px"/>
									</td>
								</tr>
								<tr>
									<td>Departamento:</td>
									<td colspan="2">
										<select id="notarioDepartamento" name="departamento"
												dojoType="dijit.form.FilteringSelect"
												autocomplete="true"
<%	if(isEdit) { %>
												value="<%=TramiteUtil.getDepartamento(notaria.getCodigoUbigeo(), true)%>"
<%	}
	else {%>
												value="000000"
<%	}%>
												style="width:270px"
												onChange="notarios.cmbnotDepartamento()">
<%	List<Ubigeo> lsUbigeos = (List<Ubigeo>)request.getAttribute("lsDepartamentos");
	for(Ubigeo u : lsUbigeos) {%>
											<option value="<%=u.getCodigo()%>"><%=u.getDescripcion()%></option>
<%	}%>
										</select>
									</td>
								</tr>
								<tr>
									<td>Provincia:</td>
									<td colspan="2">
										<select id="notarioProvincia" name="provincia"
												dojoType="dijit.form.FilteringSelect"
												store="storeProvincias"
												autocomplete="true"
<%	if(isEdit) { %>
												value="<%=TramiteUtil.getProvincia(notaria.getCodigoUbigeo(), true)%>"
												query="{codigo: '<%=TramiteUtil.getDepartamento(notaria.getCodigoUbigeo(), false)%>*'}"
<%	}
	else {%>
												value="000100"
												query="{codigo: '000100'}"
<%	}%>
												searchAttr="descripcion"
												style="width:270px"
												onChange="notarios.cmbnotProvincia()">
										</select>
									</td>
								</tr>
								<tr>
									<td>Distrito:</td>
									<td colspan="2">
										<select id="notarioDistrito" name="distrito"
												dojoType="dijit.form.FilteringSelect"
												store="storeDistritos"
												autocomplete="true"
<%	if(isEdit) { %>
												value="<%=TramiteUtil.getDistrito(notaria.getCodigoUbigeo())%>"
												query="{codigo: '<%=TramiteUtil.getProvincia(notaria.getCodigoUbigeo(), false)%>*'}"
<%	}
	else {%>
												value="000101"
												query="{codigo: '000101'}"
<%	}%>
												searchAttr="descripcion"
												style="width:270px">
										</select>
									</td>
								</tr>
								<tr>
									<td>Latitud:</td>
									<td colspan="2">
										<input id="notarioLatitud" name="latitud"
											dojoType="dijit.form.NumberTextBox"
											type="text" maxLength="12"
<%	if(isEdit) { %>
											value="<%=TramiteUtil.showValue(notaria.getNumeroLatitud())%>"
<%	}%>
											constraints="{places:6,min:-180,max:180}"
											style="font-size:13px; width:120px"/>
									</td>
								</tr>
								<tr>
									<td>Longitud:</td>
									<td colspan="2">
										<input id="notarioLongitud" name="longitud"
											dojoType="dijit.form.NumberTextBox"
											type="text" maxLength="12"
<%	if(isEdit) { %>
											value="<%=TramiteUtil.showValue(notaria.getNumeroLongitud())%>"
<%	}%>
											constraints="{places:6,min:-180,max:180}"
											style="font-size:13px; width:120px"/>
									</td>
								</tr>
							</table>
						</div>
						<div id="notarioTabObservacion" dojoType="dijit.layout.ContentPane" title="Notas">
							<table cellspacing="5" style="width:100%" cellspacing="5">
								<tr>
									<td>Observaci&oacute;n:</td>
								</tr>
								<tr>
									<td>
										<textarea id="notarioObservacion" name="observacion"
												  dojoType="dijit.form.SimpleTextarea"
<%	if(isEdit) { %>
												  value="<%=TramiteUtil.showValue(notaria.getObservacion())%>"
<%	}%>
												  maxLength="100" uppercase="true"
												  style="width:370px;font-size:13px;height:60px"></textarea>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>
<table cellspacing="5" style="width:100%" cellspacing="5">
	<tr>
		<td colspan="2" height="35px" valign="bottom" align="center">
			<table cellspacing="5">
				<tr>
					<td><button id="notarioBtnGrabar" dojoType="dijit.form.Button" iconClass="icon-by-ok" onclick="notarios.grabarNotario()">Aceptar</button></td>
					<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="dijit.byId('dialogNotario').hide()">Cancelar</button></td>
				</tr>
			</table>
		</td>
	</tr>
</table>