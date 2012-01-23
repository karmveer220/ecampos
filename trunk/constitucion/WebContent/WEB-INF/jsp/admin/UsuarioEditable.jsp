<jsp:useBean id="usuarioBean" scope="session" class="pe.org.notarios.framework.security.bean.UsuarioBean"/>
<div dojoType="dijit.layout.ContentPane" style="overflow:hidden;">
	<form id="usrForm" name="usrForm" dojoType="dijit.form.Form" onsubmit="return false">
		<input type="hidden" name="action" value="grabaUsuario"/>
		<input id="usrModo" type="hidden" name="modo" value="NEW"/>
		<input id="usrUid" type="hidden" name="uid" value=""/>
		<input id="usrRole" type="hidden" name="rol" value="0"/>
		<input id="usrCurrentGrupo" type="hidden" name="actualGrupo" value="<%=usuarioBean.getCodigoNotaria()%>"/>
		<input id="usrCurrentDesGrupo" type="hidden" name="actualDesGrupo" value="<%=usuarioBean.getNombreCompleto()%>"/>
		<table cellspacing="5" style="width:100%" cellspacing="5">
			<tr>
				<td width="100px"><span id="usTitleGrupo">Notar&iacute;a</span>:</td>
				<td colspan="2">
					<input id="usrGrupo" name="grupo"
						   dojoType="dojext.form.ValidationTextBox"  
						   type="text" maxLength="6" uppercase="true" regExp="\w{0,6}"
						   style="font-size:13px; width:90px"
						   onChange="notarios.cmbusrGrupo()"/>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2">
					<input id="usrDesGrupo" name="desGrupo"
						   dojoType="dijit.form.ValidationTextBox"  
						   type="text" maxLength="100" readOnly="true"
						   style="font-size:13px; width:300px"/>
				</td>
			</tr>
			<tr>
				<td>Usuario:</td>
				<td colspan="2">
					<input id="usrUsuario" name="usuario"
						   dojoType="dijit.form.ValidationTextBox"  
						   type="text" maxLength="14" uppercase="true" regExp="\w{0,14}"
						   style="font-size:13px; width:150px"/>
				</td>
			</tr>
			<tr>
				<td>Contrase&ntilde;a:</td>
				<td colspan="2">
					<input id="usrPassword" name="password"
						   dojoType="dojext.form.ValidationTextBox"
						   type="password" maxLength="14" regExp="\w{0,14}"
						   style="font-size:13px; width:150px"
						   onChange="notarios.cmbusrNuevoPwd()"/>
				</td>
			</tr>
			<tr>
				<td>Repita Contrase&ntilde;a:</td>
				<td colspan="2">
					<input id="usrRepitePassword" name="repitePassword"
						   dojoType="dojext.form.ValidationTextBox"
						   type="password" maxLength="14" regExp="\w{0,14}"
						   style="font-size:13px; width:150px"
						   onChange="notarios.cmbusrRepitePwd()"/>
				</td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td colspan="2">
					<table cellspacing="0">
						<tr>
							<td>
								<input id="usrEstadoUno" name="estado" dojoType="dijit.form.RadioButton" type="radio" value="T01" checked="checked">
								<label for="usrEstadoUno">Habilitado</label>
							</td>
							<td>&nbsp;</td>
							<td>
								<input id="usrEstadoDos" name="estado" dojoType="dijit.form.RadioButton" type="radio" value="T02">&nbsp;
								<label for="usrEstadoDos">Deshabilitado</label>
							</td>
						</tr>
					</table>
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
					<td><button id="usrBtnGrabar" dojoType="dijit.form.Button" iconClass="icon-by-ok" onclick="notarios.grabarUsuario()">Aceptar</button></td>
					<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="dijit.byId('dialogUsuario').hide()">Cancelar</button></td>
				</tr>
			</table>
		</td>
	</tr>
</table>