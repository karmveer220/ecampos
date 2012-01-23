<form id="manForm" name="manForm" dojoType="dijit.form.Form">
	<input type="hidden" name="action" value="grabaMandatario"/>
	<input id="manModo" type="hidden" name="modo" value="NEW"/>
	<input id="manUid" type="hidden" name="uid" value=""/>
	<input id="manValida" type="hidden" name="valida" value="0"/>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td width="200px">(+) <b>Tipo documento</b>:</td>
			<td colspan="2">
				<select id="manTipoDocumento" name="tipoDocumento"
						dojoType="dijit.form.FilteringSelect"
						value="01"
						autocomplete="true"
						style="width:200px"
						onChange="notarios.cmbmanTipoDocu()">
					<option value="01" selected="selected">D.N.I.</option>
					<option value="02">CARNET EXTRANJERIA</option>
					<option value="03">PASAPORTE</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>(+) <b>N&uacute;mero de documento</b>:</td>
			<td>
				<input id="manNumeroDocumento" name="numeroDocumento"
					   dojoType="dojext.form.ValidationTextBox"
					   type="text" maxLength="20"
					   style="font-size:13px; width:120px"
					   onChange="notarios.cmbmanNumeDocu()"/>
			</td>
			<td>
				<button id="manBtnReniec"
						dojoType="dijit.form.Button"
						iconClass="icon-by-ok" disabled="true"
						onclick="notarios.cmbmanValidDocu()">RENIEC</button>
			</td>
		</tr>
		<tr>
			<td>(*) Apellido paterno:</td>
			<td colspan="2">
				<input id="manApellidoPaterno" name="apellidoPaterno"
					   dojoType="dijit.form.ValidationTextBox"  
					   type="text" maxLength="100" uppercase="true"
					   style="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>(*) Apellido materno:</td>
			<td colspan="2">
				<input id="manApellidoMaterno" name="apellidoMaterno"
					   dojoType="dijit.form.ValidationTextBox"
					   type="text" maxLength="100" uppercase="true"
					   style="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>(*) Nombres:</td>
			<td colspan="2">
				<input id="manNombres" name="nombres"
					   dojoType="dijit.form.ValidationTextBox"
					   type="text" maxLength="100" uppercase="true"
					   style="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>(*) Direcci&oacute;n:</td>
			<td colspan="2">
				<input id="manDireccion" name="direccion"
					   dojoType="dijit.form.ValidationTextBox"
					   type="text" maxLength="100" uppercase="true"
					   style="font-size:13px; width:270px"/>
			</td>
		</tr>
		<tr>
			<td>Profesi&oacute;n:</td>
			<td colspan="2">
				<input id="manProfesion" name="profesion"
					   dojoType="dijit.form.ValidationTextBox"
					   type="text" maxLength="100" uppercase="true"
					   style="font-size:13px; width:180px"/>
			</td>
		</tr>
		<tr>
			<td>Insc. Registral:</td>
			<td colspan="2">
				<input id="manInscripcionRegistral" name="inscripcionRegistral"
					   dojoType="dijit.form.ValidationTextBox"
					   type="text" maxLength="100" uppercase="true"
					   style="font-size:13px; width:180px"/>
			</td>
		</tr>
	</table>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td colspan="2" height="35px" valign="bottom" align="center">
				<table cellspacing="5">
					<tr>
						<td><button id="manBtnGrabar" dojoType="dijit.form.Button" iconClass="icon-by-ok" onclick="notarios.grabarMandatario()">Aceptar</button></td>
						<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="dijit.byId('dialogMandatario').hide()">Cancelar</button></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>