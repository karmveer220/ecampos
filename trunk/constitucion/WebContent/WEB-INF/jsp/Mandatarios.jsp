<script>
	function seguirParticipacion(){
		document.forms[0].submit();
	}
</script>


<div dojoType="dijit.layout.BorderContainer" gutters="false" style="overflow:hidden">
	<div dojoType="dijit.layout.ContentPane" region="top" splitter="false">
		<div class="dextPanelHeader" style="padding: 5px 8px">
			Asignaci&oacute;n de Mandatarios
		</div>
		<div dojoType="dijit.Toolbar" style="border-left:1px solid #99BBE8; border-right:1px solid #99BBE8; border-bottom:0px;">
			<button dojoType="dijit.form.DropDownButton" iconClass="icon-by-account">
				<span>Adicionar Mandatario</span>
				<div dojoType="dijit.Menu">
					<div dojoType="dijit.MenuItem" onclick="notarios.escogerMandatario()">Socio / Accionista existente</div>
					<div dojoType="dijit.MenuItem" onclick="notarios.nuevoMandatario()">Nuevo Mandatario</div>
				</div>
			</button>
			<button dojoType="dijit.form.Button" iconClass="icon-by-assign" onclick="notarios.asignarCargos()">Asignar</button>
			<button dojoType="dijit.form.Button" iconClass="icon-by-edit" onclick="notarios.editarMandatario()">Editar</button>
			<button dojoType="dijit.form.Button" iconClass="icon-by-del" onclick="notarios.eliminarMandatario()">Eliminar</button>
		</div>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="center" splitter="false" style="overflow:hidden; border:1px solid #99BBE8;">
		<table jsid="gridMandatarios" id="gridMandatarios" dojoType="dojox.grid.DataGrid" store="storeMandatarios" rowsPerPage="20" selectionMode="single">
			<script type="dojo/method" event="onRowDblClick" args="cell"> 
				if(cell) notarios.asignarCargos();
			</script>
			<script type="dojo/method" event="onRowMouseOver" args="cell"> 
				if(cell.cellNode) dijit.byId("menuMandatarios").bindDomNode(cell.cellNode);		
			</script>
			<script type="dojo/method" event="onRowMouseDown" args="cell">
				if(cell) this.selection.select(cell.rowIndex);
			</script>
			<thead>
				<tr>
					<th width="300px">Nombres</th>
					<th width="110px">Director</th>
					<th width="110px">Gerente</th>
					<th width="110px">Sub-Gerente</th>
					<th width="110px">Porcentaje Llenado</th>
					<th width="130px">Tipo Documento</th>
					<th width="110px">N&uacute;mero Documento</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<form action="tramitePart.htm" method="post">
	<div dojoType="dijit.layout.ContentPane" region="bottom" splitter="false" style="overflow:hidden;height:50px;border:1px solid #99BBE8; border-top:0px">
		<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-back" onclick="notarios.mostrarAccionistas()">Anterior</button></td>
				<td>&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-continue" onclick="javascript:seguirParticipacion();">Siguiente</button></td>
				<td>&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="notarios.salirTramite()">Salir</button></td>
			</tr>
		</table>
	</div>
	</form>
	
</div>

<div dojoType="dijit.Menu" id="menuMandatarios" style="display: none;">
	<div dojoType="dijit.MenuItem" iconClass="icon-by-assign" onclick="notarios.asignarCargos()">Asignar</div>
	<div dojoType="dijit.MenuItem" iconClass="icon-by-edit" onclick="notarios.editarMandatario()">Editar</div>
	<div dojoType="dijit.MenuItem" iconClass="icon-by-del" onclick="notarios.eliminarMandatario()">Eliminar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>

<div id="dialogEscoger" dojoType="dojext.Dialog" innerBorder="simple" title="Seleccione un Accionista / Socio" duration="100" style="width:550px; visibility:hidden">
	<%@include file="SelectAccionistas.jsp"%>
</div>

<div id="dialogMandatario" dojoType="dojext.Dialog" innerBorder="simple" title="Nuevo Mandatario" duration="100" style="width:470px; visibility:hidden">
	<%@include file="ManEditable.jsp"%>
</div>

<div id="dialogCargos" dojoType="dojext.Dialog" innerBorder="simple" title="Asignar Cargos" duration="100" style="width:300px; visibility:hidden">
	<%@include file="Cargos.jsp"%>
</div>