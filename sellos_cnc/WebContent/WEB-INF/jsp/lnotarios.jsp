<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<jsp:include page="includes/cabecera.jsp"/>

<script>

	function limpiar(){
		$('#txtSello').val("");
	}
	
	function nuevo(){ 
		   window.location='nnotario.htm';
		}
	
</script>

	<fieldset>
		<legend>Listado de Notarios</legend>
		
		<c:if test="${not empty msgError}"><div class="alert alert-danger"> <strong><c:out value="${msgError}"/></strong> </div></c:if>
		<c:if test="${not empty mensaje}"><div class="alert alert-success">  <strong><c:out value="${mensaje}"/></strong> </div></c:if>
		
		
		<form class="form-horizontal" action="nnotario.htm" name="frmSello" id="frmSello" method="post">
			
			<!-- Button -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="btnBuscar"></label>
			  <div class="col-md-4">
			   <a id="btnCancel" class="btn btn-success" onclick="javascript:nuevo();">Nuevo</a>
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
	            <display:column title="Nombres" property="nombre" sortable="true" headerClass="sortable" />
	            <display:column title="Apellidos" property="apellidos" sortable="true" headerClass="sortable" />
	            <display:column title="Direccion" property="direccion" sortable="true" headerClass="sortable" />
	            <display:column title="Colegiatura" property="colegiatura" sortable="true" headerClass="sortable" />
	            <display:column title="" style="width:120px;">
	            	<div class="pull-right action-buttons">
	            		<a href="sello.htm?codigo=${row.idnotario}"  target="_blank"><span class="glyphicon glyphicon-picture"></span></a>
	            		<a href="enotario.htm?codigo=${row.idnotario}"><span class="glyphicon glyphicon-pencil"></span></a>
	            		<a href="javascript:eliminar(${row.idnotario});" class="trash"><span class="glyphicon glyphicon-trash"></span></a>
	            	</div>
				</display:column>
	   		</display:table>
		</div>
	</div>
	</div>		
	
    <jsp:include page="includes/pie.jsp"/>