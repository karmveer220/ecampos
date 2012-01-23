<form id="aporteForm" name="aporteForm" dojoType="dijit.form.Form">
	<input type="hidden" name="action" value="grabaAporteBien"/>
	<input id="aporteNumero" type="hidden" name="numeroAporte" value=""/>
	<input id="aporteModo" type="hidden" name="modo" value="NEW"/>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td>(+) <b>Cantidad</b>:</td>
			<td colspan="2">
				<input id="aporteCantidad" name="cantidadBien"
					   dojoType="dijit.form.CurrencyTextBox"
					   required="true"
					   constraints="{min:1, places:0}"
					   maxlength="22"
					   type="text" value="1"
					   invalidMessage="Cantidad Inv&aacute;lida."
					   style="font-size:13px;"/>
			</td>
		</tr>
		<tr>
			<td valign="top">(+) <b>Descripci&oacute;n</b>:</td>
			<td colspan="2">
				<textarea id="aporteDescripcion" name="descripcionBien"
						  dojoType="dijit.form.SimpleTextarea"
						  maxLength="500"
						  style="width:292px;height:70px;font-size:13px;"></textarea>
			</td>
		</tr>
		<tr>
			<td>(+) <b>Monto</b>:</td>
			<td colspan="2">
				<input id="aporteMonto" name="montoBien"
					   dojoType="dijit.form.CurrencyTextBox"
					   constraints="{min:0, places:2}"
					   required="true" maxlength="22" type="text"
					   invalidMessage="Monto Inv&aacute;lido." style="font-size:13px;"/>
			</td>
		</tr>		
	</table>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td colspan="2" height="35px" valign="bottom" align="center">
				<table cellspacing="5">
					<tr>
						<td><button id="aporteBtnGrabar"dojoType="dijit.form.Button" iconClass="icon-by-ok" onclick="notarios.grabarAporte()">Aceptar</button></td>
						<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="dijit.byId('dialogAportes').hide()">Cancelar</button></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>