<span dojoType="dojo.data.ItemFileWriteStore" jsId="storeNotarios" url="admin.do?action=getNotarias" urlPreventCache="true" clearOnClose="true"></span>

<div dojoType="dijit.layout.BorderContainer" gutters="false" style="overflow:hidden">
	<div dojoType="dijit.layout.ContentPane" region="top" splitter="false">
		<div class="dextPanelHeader" style="padding: 5px 8px">
			Mantenimiento de Notarios
		</div>
		<div dojoType="dijit.Toolbar" style="border-left:1px solid #99BBE8; border-right:1px solid #99BBE8; border-bottom:0px;">
			<button dojoType="dijit.form.Button" iconClass="icon-by-notario" onclick="notarios.nuevoNotario()">Nuevo Notario</button>
			<button dojoType="dijit.form.Button" iconClass="icon-by-edit" onclick="notarios.editarNotario()">Editar</button>
			<button dojoType="dijit.form.Button" iconClass="icon-by-del" onclick="notarios.eliminarNotario()">Eliminar</button>
		</div>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="center" splitter="false" style="overflow:hidden; border:1px solid #99BBE8;">
		<table jsid="gridNotarios" id="gridNotarios" dojoType="dojox.grid.DataGrid" store="storeNotarios" rowsPerPage="20" selectionMode="single">
			<script type="dojo/method" event="onRowDblClick" args="cell"> 
				if(cell) notarios.editarNotario();
			</script>
			<script type="dojo/method" event="onRowMouseOver" args="cell"> 
				if(cell.cellNode) dijit.byId("menuNotarios").bindDomNode(cell.cellNode);		
			</script>
			<script type="dojo/method" event="onRowMouseDown" args="cell">
				if(cell) this.selection.select(cell.rowIndex);
			</script>
			<thead>
				<tr>
					<th field="codigoNotaria" width="110px">C&oacute;digo</th>
					<th field="razonSocial" width="300px">Raz&oacute;n Social</th>
					<th field="direccionNotaria" width="300px">Direcci&oacute;n Notar&iacute;a</th>
					<th field="desDepartamento" width="200px">Departamento</th>
					<th field="correoElectronico" width="200px">Correo Electr&oacute;nico</th>
					<th field="fechaRegistro" width="130px">Fecha de Registro</th>
				</tr>
			</thead>
		</table>
	</div>
</div>

<div dojoType="dijit.Menu" id="menuNotarios" style="display: none;">
	<div dojoType="dijit.MenuItem" iconClass="icon-by-notario" onclick="notarios.nuevoNotario()">Nuevo Notario&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	<div dojoType="dijit.MenuItem" iconClass="icon-by-edit" onclick="notarios.editarNotario()">Editar</div>
	<div dojoType="dijit.MenuItem" iconClass="icon-by-del" onclick="notarios.eliminarNotario()">Eliminar</div>
</div>

<div id="dialogNotario" dojoType="dojext.Dialog" innerBorder="simple" title="Nuevo Notario" duration="100" style="width:600px; visibility:hidden">
	<div id="notarioContent" dojoType="dijit.layout.ContentPane" style="overflow:hidden;height:380px" preventCache="true"></div>
</div>
