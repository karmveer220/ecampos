<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<jsp:include page="includes/cabecera.jsp"/>

<script>


	$(function() {

 	$( "#fechaRegistro" ).datepicker({
	        showOn: "button",
	        buttonImage: "${pageContext.request.contextPath}/img/cal.gif",
	        buttonImageOnly: false,
	        dateFormat: 'dd/mm/yy'
	      });
	});

	function grabar(){
		alert('La informacion ha sido grabada con exito');
		window.location ='lSellos.htm';
	}
	
	function cancel(){
		if( confirm("Seguro que desea cancelar?") ){
			window.location ='lSellos.htm';
		} 
	}
	
</script>

	<form class="form-horizontal" name="frm2" action="nSello.htm" method="post">
                                    
		<input type="hidden" name="idSello"/>
        <input type="hidden" value="1" name="estado"/>  
        
        <c:if test="${not empty msgError}"><div class="alert alert-danger"> <strong><c:out value="${msgError}"/></strong> </div></c:if>
		<c:if test="${not empty mensaje}"><div class="alert alert-success">  <strong><c:out value="${mensaje}"/></strong> </div></c:if>
		
		<fieldset>

			<!-- Form Name -->
			<legend>Nuevo Sello</legend>

			<!-- Search input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="tagsEntidad">Notario</label>
				<div class="col-md-6">
                 <input type="text" name="notario" id="tagsEntidad" size="40" class="form-control input-md" />
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="texto">Texto</label>
				<div class="col-md-2">
					 <input type="text" class="form-control input-md" name="texto" id="texto" placeholder="texto para codigo" size="25" />
				</div>
			</div>
			

			<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="btnGrabar"></label>
					<div class="col-md-4">
						<button id="btnGrabar" name="btnGrabar" class="btn btn-default" onclick="javascript:grabar();">Grabar</button>
						<a id="btnCancel" class="btn btn-default" onclick="javascript:cancel();">Cancelar</a>
					</div>
				</div>
		</fieldset>
		
		</form> 
		
      <hr>

    <jsp:include page="includes/pie.jsp"/>