<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<jsp:include page="include/header.jsp" flush="true"/>


<script>

	function guardarCargo(){
			$.ajax({
				url:'${pageContext.request.contextPath}/registraCargo.htm',
				type:'POST',
				async:true,
				data:$('#cargoform').serialize(),
				success:function(data){
					// reload list
				}
			});
	}


$(document).ready(function() {

	 $("#cargos").live("click", function () {
		 var id = $(this).attr("noteid");
		 $.ajax({
		        url: "${pageContext.request.contextPath}/asignacargo.htm?cod="+id,
		        async: false,
		        cache: false,
		        success: function(data) {
		            $(function() {
		                var moddiv = $('<div>').attr({
		                    id: "divCargos",
		                    align:'justify'
		                });
		                $('body').append(moddiv);
		                $('#divCargos').html(data);
		                $('#divCargos').dialog({
		                    title: "<b>Seleccion de Cargo</b>",
		                    modal: true,
		                    width: 450,
		                    height: 300,
		                    resizable: false,
		                    hide: "explode",
		                    show: "blind",
		                    buttons:{
		                    	"Grabar": function () { guardarCargo(); $(this).dialog("close"); },
		                        "Cerrar": function() { $(this).dialog("close"); }
		                    }
		                });
		            });
		        }
		    });		        
     });

	 $("#nuevom").live("click", function () {
		 $.ajax({
			 	url: "${pageContext.request.contextPath}/nuevomandatario.htm",
		        async: false,
		        cache: false,
		        success: function(data) {
		            $(function() {
		                var moddiv = $('<div>').attr({
		                    id: "divNuevo",
		                    align:'justify'
		                });
		                $('body').append(moddiv);
		                $('#divNuevo').html(data);
		                $('#divNuevo').dialog({
		                    title: "<b>Nuevo Mandatario</b>",
		                    modal: true,
		                    width: 450,
		                    height: 400,
		                    resizable: false,
		                    hide: "explode",
		                    show: "blind",
		                    buttons:{
		                    	"Grabar": function () { $(this).dialog("close"); },
		                        "Cerrar": function() { $(this).dialog("close"); }
		                    }
		                });
		            });
		        }
		    });
		        
     });
     
	 $("#editar").live("click", function () {
		 $.ajax({
		        url: "${pageContext.request.contextPath}/editarMandatario.htm?cod="+id,
		        async: false,
		        cache: false,
		        success: function(data) {
		            $(function() {
		                var moddiv = $('<div>').attr({
		                    id: "divEditar",
		                    align:'justify'
		                });
		                $('body').append(moddiv);
		                $('#divEditar').html(data);
		                $('#divEditar').dialog({
		                    title: "<b>Nuevo Mandatario</b>",
		                    modal: true,
		                    width: 450,
		                    height: 400,
		                    resizable: false,
		                    hide: "explode",
		                    show: "blind",
		                    buttons:{
		                    	"Grabar": function () { $(this).dialog("close"); },
		                        "Cerrar": function() { $(this).dialog("close"); }
		                    }
		                });
		            });
		        }
		    });
		        
     });

	 $("#ver").live("click", function () {
		 var id = $(this).attr("noteid");
		 $.ajax({
		        url: "${pageContext.request.contextPath}/verMandatario.htm?cod="+id,
		        async: false,
		        cache: false,
		        success: function(data) {
		            $(function() {
		                var moddiv = $('<div>').attr({
		                    id: "divVer",
		                    align:'justify'
		                });
		                $('body').append(moddiv);
		                $('#divVer').html(data);
		                $('#divVer').dialog({
		                    title: "<b>Ver Mandatario</b>",
		                    modal: true,
		                    width: 450,
		                    height: 400,
		                    resizable: false,
		                    hide: "explode",
		                    show: "blind",
		                    buttons:{
		                    	"Cerrar": function() { $(this).dialog("close"); }
		                    }
		                });
		            });
		        }
		    });
		        
     });

	 $("#seleccionar").live("click", function () {
		 $.ajax({
		        url: "${pageContext.request.contextPath}/seleccionasocio.htm",
		        async: false,
		        cache: false,
		        success: function(data) {
		            $(function() {
		                var moddiv = $('<div>').attr({
		                    id: "divSelecc",
		                    align:'justify'
		                });
		                $('body').append(moddiv);
		                $('#divSelecc').html(data);
		                $('#divSelecc').dialog({
		                    title: "<b>Seleccionar Socio / accionista</b>",
		                    modal: true,
		                    width: 450,
		                    height: 400,
		                    resizable: false,
		                    hide: "explode",
		                    show: "blind",
		                    buttons:{
		                    	"Cerrar": function() { $(this).dialog("close"); }
		                    }
		                });
		            });
		        }
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
		
		<div align="center" style="color: red"> <c:out value="${msgError}"/> </div>
		<div align="center" style="color: blue"> <c:out value="${mensaje}"/> </div>
				
		<div  style="border-left:1px solid #99BBE8; border-right:1px solid #99BBE8; border-bottom:0px;">
			<button id="seleccionar"  type="button">Socio / Accionista existente</button>
			<button id="nuevom" type="button">Nuevo Mandatario</button>
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
	           	<span id="editar" class="ButtonLink" noteid="${row.idMandatario}"><img title="Editar" src="${pageContext.request.contextPath}/img/page_edit.png" height="16px" width="16px"/></span>
	           	<span id="ver"    class="ButtonLink" noteid="${row.idMandatario}"><img title="Ver" src="${pageContext.request.contextPath}/img/page.png" height="16px" width="16px"/></span>
	           	<span id="cargos" class="ButtonLink" noteid="${row.idMandatario}"><img title="Asignar Cargo" src="${pageContext.request.contextPath}/img/page.png" height="16px" width="16px"/></span>
	           	<a href="${pageContext.request.contextPath}/eliminarMandatario.htm?codigo=${row.idMandatario}" onclick="return confirm('Seguro de eliminar el Mandatario?');"><img title="Eliminar" src="${pageContext.request.contextPath}/img/delete.png" height="16px" width="16px"/></a>
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