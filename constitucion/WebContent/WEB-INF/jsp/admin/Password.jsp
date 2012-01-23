<jsp:useBean id="usuarioBean" scope="session" class="pe.org.notarios.framework.security.bean.UsuarioBean"/>
<div dojoType="dijit.layout.BorderContainer" gutters="false" style="overflow:hidden">
	<div dojoType="dijit.layout.ContentPane" region="top"  class="x-panel-header" style="border-bottom: 0px; padding: 5px 8px">
	Cambio de Contrase&ntilde;a
	</div>
	<div dojoType="dijit.layout.ContentPane" region="center" splitter="false" style="background:white; border:1px solid #99BBE8">
		<div style="width:640px; padding:10px 10px 10px 10px;">
			<form id="passForm" dojoType="dijit.form.Form" onsubmit="return false"> 
				<table width="100%" cellspacing="13">
					<input type="hidden" name="action" value="cambiaPassword"/>
					<tr>
						<td colspan="2" align="left" style="color:gray;border-bottom:1px solid #ccc">
							<b><span>Esta opci&oacute;n cambiar&aacute; la contrase&ntilde;a del usuario <%=usuarioBean.getUsuario()%> - <%=usuarioBean.getNombreCompleto()%></span></b>
						</td>
					</tr>
					<tr>
						<td width="190px">(+) <b>Contrase&ntilde;a actual:</b></td>
						<td>
							<input id="passActualPassword" name="actualPassword"
								   dojoType="dojext.form.ValidationTextBox"
								   type="password" maxLength="14" regExp="\w{0,14}"
								   style="font-size:13px; width:150px"
								   onChange="notarios.cmbpassActualPwd()"/>
						</td>
					</tr>
					<tr>
						<td>(+) <b>Nueva Contrase&ntilde;a:</b></td>
						<td>
							<input id="passNuevoPassword" name="nuevoPassword"
								   dojoType="dojext.form.ValidationTextBox"
								   type="password" maxLength="14" regExp="\w{0,14}"
								   style="font-size:13px; width:150px"
								   onChange="notarios.cmbpassNuevoPwd()"/>
						</td>
					</tr>
					<tr>
						<td>(+) <b>Repite la nueva Contrase&ntilde;a:</b></td>
						<td>
							<input id="passRepitePassword" name="repitePassword"
								   dojoType="dojext.form.ValidationTextBox"
								   type="password" maxLength="14" regExp="\w{0,14}"
								   style="font-size:13px; width:150px"
								   onChange="notarios.cmbpassRepitePwd()"/>
						</td>
					</tr>
				</table>
			</form> 
		</div>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="bottom" splitter="false" style="overflow:hidden;height:50px;border:1px solid #99BBE8; border-top:0px">
		<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-save" onclick="notarios.cambiarPassword()">Grabar</button></td>
				<td>&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="notarios.salirTramite()">Salir</button></td>
			</tr>
		</table>
	</div>
</div>
