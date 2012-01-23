<span dojoType="dojo.data.ItemFileWriteStore" jsId="storeUsuarios" url="admin.do?action=getUsuarios" urlPreventCache="true" clearOnClose="true"></span>

<div dojoType="dijit.layout.BorderContainer" gutters="false" style="overflow:hidden">
	<div dojoType="dijit.layout.ContentPane" region="top" splitter="false">
		<div class="dextPanelHeader" style="padding: 5px 8px">
			Mantenimiento de Usuarios
		</div>
		<div dojoType="dijit.Toolbar" style="border-left:1px solid #99BBE8; border-right:1px solid #99BBE8; border-bottom:0px;">
			<button dojoType="dijit.form.DropDownButton" iconClass="icon-by-account">
				<span>Nuevo Usuario</span>
				<div dojoType="dijit.Menu">
					<div dojoType="dijit.MenuItem" onclick="notarios.nuevoUsuario(1)">Administrador</div>
					<div dojoType="dijit.MenuItem" onclick="notarios.nuevoUsuario(2)">Principal</div>
					<div dojoType="dijit.MenuItem" onclick="notarios.nuevoUsuario(3)">Secundario</div>
				</div>
			</button>
			<button dojoType="dijit.form.Button" iconClass="icon-by-edit" onclick="notarios.editarUsuario()">Editar</button>
			<button dojoType="dijit.form.Button" iconClass="icon-by-del" onclick="notarios.eliminarUsuario()">Eliminar</button>
		</div>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="center" splitter="false" style="overflow:hidden; border:1px solid #99BBE8;">
		<table jsid="gridUsuarios" id="gridUsuarios" dojoType="dojox.grid.DataGrid" store="storeUsuarios" rowsPerPage="20" selectionMode="single">
			<script type="dojo/method" event="onRowDblClick" args="cell"> 
				if(cell) notarios.editarUsuario();
			</script>
			<script type="dojo/method" event="onRowMouseOver" args="cell"> 
				if(cell.cellNode) dijit.byId("menuUsuarios").bindDomNode(cell.cellNode);		
			</script>
			<script type="dojo/method" event="onRowMouseDown" args="cell">
				if(cell) this.selection.select(cell.rowIndex);
			</script>
			<thead>
				<tr>
					<th field="tipoUsuario" width="120px">Tipo de usuario</th>
					<th field="notaria" width="120px">Notar&iacute;a &oacute; Grupo</th>
					<th field="usuario" width="120px">Usuario</th>
					<th field="desEstado" width="120px">Estado</th>
					<th field="fechaModificacion" width="120px">Fecha Modificaci&oacute;n</th>
				</tr>
			</thead>
		</table>
	</div>
</div>

<div dojoType="dijit.Menu" id="menuUsuarios" style="display: none;">
	<div dojoType="dijit.PopupMenuItem" iconClass="icon-by-account">
		<span>Nuevo usuario&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<div dojoType="dijit.Menu">
			<div dojoType="dijit.MenuItem" onClick="notarios.nuevoUsuario(1)">Administrador</div>
			<div dojoType="dijit.MenuItem" onClick="notarios.nuevoUsuario(2)">Principal</div>
			<div dojoType="dijit.MenuItem" onClick="notarios.nuevoUsuario(3)">Secundario</div>
		</div>
	</div>
	<div dojoType="dijit.MenuItem" iconClass="icon-by-edit" onclick="notarios.editarUsuario()">Editar</div>
	<div dojoType="dijit.MenuItem" iconClass="icon-by-del" onclick="notarios.eliminarUsuario()">Eliminar</div>
</div>

<div id="dialogUsuario" dojoType="dojext.Dialog" innerBorder="simple" title="Nuevo Usuario" duration="100" style="width:450px; visibility:hidden">
	<%@include file="UsuarioEditable.jsp"%>
</div>

