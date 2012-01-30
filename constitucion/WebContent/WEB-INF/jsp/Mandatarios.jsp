<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script>
	function seguirParticipacion(){
		document.forms[0].action='${pageContext.request.contextPath}/constitucion/tramitePart.htm';
		document.forms[0].submit();
	}

	function mostrarAccionistas(){
		document.forms[0].action='${pageContext.request.contextPath}/constitucion/regresaPasoDos.htm';
		document.forms[0].submit();
	}
</script>


<div style="overflow:hidden">
	<div >
		<div class="dextPanelHeader" style="padding: 5px 8px">
			Asignaci&oacute;n de Mandatarios
		</div>
		<div  style="border-left:1px solid #99BBE8; border-right:1px solid #99BBE8; border-bottom:0px;">
			<button >
				<span>Adicionar Mandatario</span>
				<div >
					<div  onclick="notarios.escogerMandatario()">Socio / Accionista existente</div>
					<div  onclick="notarios.nuevoMandatario()">Nuevo Mandatario</div>
				</div>
			</button>
			<button  onclick="notarios.asignarCargos()">Asignar</button>
			<button  onclick="notarios.editarMandatario()">Editar</button>
			<button  onclick="notarios.eliminarMandatario()">Eliminar</button>
		</div>
	</div>
	<div  style="overflow:hidden; border:1px solid #99BBE8;">
		<table  id="gridMandatarios" >
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
	<div style="overflow:hidden;height:50px;border:1px solid #99BBE8; border-top:0px">
		<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button onclick="mostrarAccionistas()">Anterior</button></td>
				<td>&nbsp;</td>
				<td><button onclick="javascript:seguirParticipacion();">Siguiente</button></td>
				<td>&nbsp;</td>
				<td><button onclick="salirTramite()">Salir</button></td>
			</tr>
		</table>
	</div>
	</form>
	
</div>

<div  id="menuMandatarios" style="display: none;">
	<div onclick="asignarCargos()">Asignar</div>
	<div onclick="editarMandatario()">Editar</div>
	<div onclick="eliminarMandatario()">Eliminar</div>
</div>

<div id="dialogEscoger" title="Seleccione un Accionista / Socio" style="width:550px; visibility:hidden">
	<%@include file="SelectAccionistas.jsp"%>
</div>

<div id="dialogMandatario" title="Nuevo Mandatario" style="width:470px; visibility:hidden">
	<%@include file="ManEditable.jsp"%>
</div>

<div id="dialogCargos" title="Asignar Cargos"  style="width:300px; visibility:hidden">
	<%@include file="Cargos.jsp"%>
</div>

<jsp:include page="include/footer.jsp" flush="true"/>