<div dojoType="dijit.layout.ContentPane" style="width:536px;overflow:hidden;height:220px;border-bottom:1px solid #99BBE8;">
	<table jsid="gridNaturales" id="gridNaturales" dojoType="dojox.grid.DataGrid" store="storeNaturales" rowsPerPage="20" selectionMode="single">
		<script type="dojo/method" event="onRowDblClick" args="cell"> 
			if(cell) notarios.asignarAccionista();
		</script>
		<script type="dojo/method" event="onRowMouseDown" args="cell"> 
			if(cell) this.selection.select(cell.rowIndex);
		</script>
		<thead>
			<tr>
				<th field="razonSocial" width="300px">Nombre Completo</th>
				<th field="desTipoDocumento" width="130px">Tipo Documento</th>
				<th field="numeroDocumento" width="110px">N&uacute;mero Documento</th>
				<!-- <th field="porcentaje" width="110px">Porcentaje Llenado</th> -->
			</tr>
		</thead>
	</table>
</div>
<table cellspacing="5" style="width:100%" cellspacing="5">
	<tr>
		<td colspan="2" height="35px" valign="bottom" align="center">
			<table cellspacing="5">
				<tr>
					<td><button id="selaccBtnGrabar" dojoType="dijit.form.Button" iconClass="icon-by-ok" onclick="notarios.asignarAccionista()">Aceptar</button></td>
					<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="dijit.byId('dialogEscoger').hide()">Cancelar</button></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
