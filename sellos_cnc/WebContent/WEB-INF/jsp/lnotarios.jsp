<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<jsp:include page="includes/cabecera.jsp"/>

<script>

	function limpiar(){
		$('#txtSello').val("");
	}
	
</script>

	<fieldset>
		<legend>Listado de Notarios</legend>
		
		<form class="form-horizontal" action="nNotario.htm" name="frmSello" id="frmSello" method="post">
			
			<!-- Button -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="btnBuscar"></label>
			  <div class="col-md-4">
			    <button id="btnBuscar" name="btnBuscar" class="btn btn-default">Nuevo</button>
			  </div>
			</div>
			
		</form>
	</fieldset>

    <hr>

	<!-- muestra al notario con su sello activo  -->

	 <div id="tablaDinamica">
	   <div id="resultado">
   		<div id="displayTagDiv">
	    	<display:table  name="requestScope.lNotarios" requestURI="lnotarios.htm" class="displaytag" pagesize="10"
	            defaultsort="1" defaultorder="descending" sort="list" export="false" id="row" excludedParams="ajax" >
	            <display:column title="Notario" property="nombre" sortable="true" headerClass="sortable" />
	            <display:column title="" style="width:120px;">
	            	<div class="pull-right action-buttons">
	            		<a href="editNotario.htm?codigo=${row.codigo}" target="_blank"><span class="glyphicon glyphicon-pencil"></span></a>
	            		<a href="javascript:eliminar(${row.codigo});" class="trash"><span class="glyphicon glyphicon-trash"></span></a>
	            	</div>
				</display:column>
	   		</display:table>
		</div>
	</div>
	</div>		
	
    <jsp:include page="includes/pie.jsp"/>