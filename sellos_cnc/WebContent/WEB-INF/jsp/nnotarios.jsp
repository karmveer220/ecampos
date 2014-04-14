<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<jsp:include page="includes/cabecera.jsp"/>

<script>

	function limpiar(){
		$('#txtSello').val("");
	}
	
	function grabar(){
	    document.forms[0].action = "nnotario.htm";
	    document.forms[0].submit();
	}
	
	function cancel(){ 
	   window.location='lnotarios.htm';
	}
	
</script>

	<fieldset>
		<legend>Registro de Notarios</legend>
		
		<c:if test="${not empty msgError}"><div class="alert alert-danger"> <strong><c:out value="${msgError}"/></strong> </div></c:if>
		<c:if test="${not empty mensaje}"><div class="alert alert-success">  <strong><c:out value="${mensaje}"/></strong> </div></c:if>
		
		
		<form:form class="form-horizontal" action="nNotario.htm" name="frmSello" id="frmSello" method="post" modelAttribute="notario">
			<form:hidden path="idnotario" />
			<form:hidden path="estado" />

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nombreNotario">Nombre de Notario</label>
				<div class="col-md-4">
					<form:input path="nombre" id="nombre" cssClass="form-control input-md"/>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="numeroColegiatura">Apellidos</label>
				<div class="col-md-4">
					<form:input path="apellidos" id="apellidos" cssClass="form-control input-md"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="direccion">Direccion de Notar&iacute;a</label>
				<div class="col-md-4">
					<form:input path="direccion" id="direccion" cssClass="form-control input-md"/>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="btnBuscar"></label>
			  <div class="col-md-4">
			    <button id="btnGrabar" name="btnGrabar" class="btn btn-success" onclick="javascript:grabar();">Grabar</button>
				<a id="btnCancel" class="btn btn-success" onclick="javascript:cancel();">Cancelar</a>
			  </div>
			</div>
			
		</form:form>
	</fieldset>

    <hr>
    <jsp:include page="includes/pie.jsp"/>