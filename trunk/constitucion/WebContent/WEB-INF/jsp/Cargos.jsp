<form id="cargoForm" name="cargoForm" dojoType="dijit.form.Form">
	<input type="hidden" name="action" value="asignarCargos"/>
	<input id="cargoUid" type="hidden" name="uid" value=""/>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td width="50px">&nbsp;</td>
			<td>
				<input name="director" id="director" />
				<label for="director">Director</label>
			</td>
		</tr>
		<tr>
			<td width="50px">&nbsp;</td>
			<td>
				<input name="gerente" id="gerente" />
				<label for="gerente">Gerente</label>
			</td>
		</tr>
		<tr>
			<td width="50px">&nbsp;</td>
			<td>
				<input name="subgerente" id="subgerente" />
				<label for="subgerente">Sub-Gerente</label>
			</td>
		</tr>

		<tr><td colspan="2">&nbsp;</td></tr>
	</table>
	<table cellspacing="5" style="width:100%" cellspacing="5">
		<tr>
			<td colspan="2" height="35px" valign="bottom" align="center">
				<table cellspacing="5">
					<tr>
						<td><button id="cargoBtnGrabar" dojoType="dijit.form.Button" iconClass="icon-by-ok" onclick="notarios.grabarCargos()">Aceptar</button></td>
						<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="dijit.byId('dialogCargos').hide()">Cancelar</button></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>