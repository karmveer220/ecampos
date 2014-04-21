<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<jsp:include page="includes/cabecera.jsp"/>

<script>

	
	function cancel(){ 
	   window.close();
	}
	
</script>

	<fieldset>
		<legend>Detalle de Notario</legend>
		
		<c:if test="${not empty msgError}"><div class="alert alert-danger"> <strong><c:out value="${msgError}"/></strong> </div></c:if>
		<c:if test="${not empty mensaje}"><div class="alert alert-success">  <strong><c:out value="${mensaje}"/></strong> </div></c:if>
		
		
		<form:form class="form-horizontal" action="ver.htm" name="frmSello" id="frmSello" method="post" modelAttribute="notario">
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nombreNotario">Notar&iacute;a</label>
				<div class="col-md-4">${notario.nombrenotaria}</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nombreNotario">Nombres</label>
				<div class="col-md-4">${notario.nombre}</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="numeroColegiatura">Apellidos</label>
				<div class="col-md-4">${notario.apellidos}</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="numeroColegiatura">Colegiatura</label>
				<div class="col-md-4">${notario.colegiatura}</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="direccion">Direccion de Notar&iacute;a</label>
				<div class="col-md-4">${notario.direccion}</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="direccion">Telefonos</label>
				<div class="col-md-4">${notario.telefonos}</div>
			</div>

			<!-- Button -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="btnBuscar"></label>
			  <div class="col-md-4">
			   		<a id="btnCancel" class="btn btn-success" onclick="javascript:cancel();">Cerrar</a>
			  </div>
			</div>
			
		</form:form>
	</fieldset>

    <hr>
    <jsp:include page="includes/pie.jsp"/>