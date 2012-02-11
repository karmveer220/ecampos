<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<jsp:include page="include/header.jsp" flush="true"/>


<script> 	
$(document).ready(function() {

	$( "#dialog-modal" ).dialog({        
        autoOpen: false,
        width: 460,
        height: 250,
        modal: true,
        close: function(ev, ui) { $(this).dialog("close"); }
    });
    
	 $(".soc_cargo").live("click", function () {
		 var id = $(this).attr("noteid");
         $("#dialog-modal").html("")
             .dialog("option", "title", "Asignar Cargo")
             .load("${pageContext.request.contextPath}/mandatarios/asignacargo.htm?cod="+id, function () { $("#dialog-modal").dialog("open"); });
     });
     $("#b_mandatario").click(function(){
	    $( "#dialog-modal2" ).dialog({
	        height: 350,
	        width: 460,
	        modal: true
	    });
         $.ajax({ url: "${pageContext.request.contextPath}/mandatarios/nuevomandatario.htm",
               success: function(data){ $('#dialog-modal2 p').html(data); },
               error: function (){ alert('Errorrr '); }
         });
	 });
	
	$("#b_socio").click(function(){
	    $( "#dialog-modal3" ).dialog({
	        height: 350,
	        width: 460,
	        modal: true
	    });
         $.ajax({ url: "${pageContext.request.contextPath}/mandatarios/seleccionasocio.htm",
               success: function(data){ $('#dialog-modal3 p').html(data); },
               error: function (){ alert('Errorrr '); }
         });
	 });
	$("#soc_edit").click(function(){
	    $( "#dialog-modal4" ).dialog({
	        height: 350,
	        width: 460,
	        modal: true
	    });
         $.ajax({ url: "${pageContext.request.contextPath}/mandatarios/editarsocio.htm",
               success: function(data){ $('#dialog-modal4 p').html(data); },
               error: function (){ alert('Errorrr '); }
         });
	 });
	$("#soc_ver").click(function(){
	    $( "#dialog-modal5" ).dialog({
	        height: 350,
	        width: 460,
	        modal: true
	    });
         $.ajax({ url: "${pageContext.request.contextPath}/mandatarios/versocio.htm",
               success: function(data){ $('#dialog-modal5 p').html(data); },
               error: function (){ alert('Errorrr '); }
         });
	 });
});	

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
	
	<form action="tramitePart.htm" method="post">
	
	<h2>
		<c:if test="${tramitesistema.numTramite eq null }">Nuevo Tramite</c:if>
		<c:if test="${tramitesistema.numTramite ne null }">Editando Tramite Kardex <c:out value="${tramitesistema.clvKardex}"/></c:if>		
		</h2>	
		
	<div>
		<div class="dextPanelHeader" style="padding: 5px 8px">
			Asignaci&oacute;n de Mandatarios
		</div>
		<div  style="border-left:1px solid #99BBE8; border-right:1px solid #99BBE8; border-bottom:0px;">
			<button id="b_socio">Socio / Accionista existente</button>
			<button id="b_mandatario">Nuevo Mandatario</button>
		</div>
	</div>
	<div style="overflow:hidden; border:1px solid #99BBE8;">
	
	<div style='display:none'>
	  <div id="dialog-modal" class="dialog-modal" title="Nuevo Mandatario">
	  	<p>Loading</p>
	  </div>
	  <div id="dialog-modal2" title="Asignar Cargos">
	    <p>Loading</p>
	  </div>
	  <div id="dialog-modal3" title="Seleccionar entre socios">
	    <p>Loading</p>
	  </div>
	  <div id="dialog-modal4" title="Editar Mandatario">
	    <p>Loading</p>
	  </div>
	  <div id="dialog-modal4" title="Ver Mandatario">
	    <p>Loading</p>
	  </div>
	</div>


		<display:table  name="requestScope.lmandatarios" class="displaytag" pagesize="10"
	    	    defaultsort="1" defaultorder="ascending"  export="false" id="row" excludedParams="ajax" >	           
	           <display:column title="Nombre" property="nomMandat" headerClass="sortable" />
	           <display:column title="Cargo" property="codCargo" headerClass="sortable" />
	           <display:column title="Tipo Doc." property="codTdocman" headerClass="sortable" />
	           <display:column title="Numero Doc." property="numDocman" headerClass="sortable" />	           
	           <display:column title="Acciones">
	           	<a href="?codigo=${row.idMandatario}" id="soc_edit"><img title="Editar" src="${pageContext.request.contextPath}/img/page_edit.png" height="16px" width="16px"/></a>
	           	<a href="?codigo=${row.idMandatario}" id="soc_ver"><img title="Ver" src="${pageContext.request.contextPath}/img/page.png" height="16px" width="16px"/></a>
	           	<span class="soc_cargo ButtonLink" noteid="${row.idMandatario}"><img title="Asignar Cargo" src="${pageContext.request.contextPath}/img/page.png" height="16px" width="16px"/></span>
	           	<a href="eliminarMandatario.htm?codigo=${row.idMandatario}" onclick="return confirm('Seguro de eliminar el Mandatario?');"><img title="Eliminar" src="${pageContext.request.contextPath}/img/delete.png" height="16px" width="16px"/></a>
			</display:column>
	  		</display:table>
		
	</div>
	
	<script type="text/javascript">


	</script>
		
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

<jsp:include page="include/footer.jsp" flush="true"/>