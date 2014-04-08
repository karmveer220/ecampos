<jsp:include page="includes/cabecera.jsp"/>

<script>

	function buscar(){
		$.ajax({
			type: 'POST',
			url: 'consultaSello1.htm',
			data:{ texto: $('#txtSello').val() },
			success: function(data) {   
				$('#resultado').html(data);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert('errrror ' + textStatus + '  ' + errorThrown + '  ' + jqXHR);
			}
			
		});
	}
	function limpiar(){
		$('#txtSello').val("");
	}
</script>

	<fieldset>
		<form class="form-horizontal" action="#" name="frmSello" id="frmSello" method="post">
		<!-- Form Name -->
		<legend>Validacion de Sellos</legend>
			
        <div class="span4">
          <p> Vara validar un sellos coloca el cursor del mouse sobre la caja y escanea el documento</p>
        </div>
    
    		<div class="form-group">
			  <label class="col-md-4 control-label" for="txtRemitente">Contenido</label>  
			  <div class="col-md-5">
			  	<input id="txtSello" name="txtSello" type="text" placeholder="Contenido" class="form-control input-md">
			  </div>
			</div>
		
		    
			<!-- Button -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="btnBuscar"></label>
			  <div class="col-md-4">
			    <a href="javascript:buscar();" class="btn btn-success">Buscar</a>
			    <a href="javascript:limpiar();" class="btn btn-success">Limpiar</a>
			  </div>
			</div>
			
		<div id="resultado"> </div>
		</form>
	</fieldset>		

      <hr>

    <jsp:include page="includes/pie.jsp"/>