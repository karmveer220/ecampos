<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	function nuevoMandatario(){
		document.forms[0].action='${pageContext.request.contextPath}/constitucion/nmandatario.htm';
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
			<input type="button" value="Socio / Accionista existente" onClick=""/>
			<input type="button" value="Nuevo Mandatario" onclick="nuevoMandatario()"/>
			<input type="button" value="Asignar" onClick="asignarCargos()"/>
			<input type="button" value="Editar" onClick="editarMandatario()"/>
			<input type="button" value="Eliminar" onClick="eliminarMandatario()"/>
		</div>
	</div>
	<div style="overflow:hidden; border:1px solid #99BBE8;">
	
		<display:table  name="requestScope.lmandatarios" class="displaytag" pagesize="10"
	    	    defaultsort="1" defaultorder="ascending"  export="false" id="row" excludedParams="ajax" >	           
	           <display:column title="Nombre" property="nomMandat" headerClass="sortable" />
	           <display:column title="Cargo" property="codCargo" headerClass="sortable" />
	           <display:column title="Tipo Doc." property="codTdocman" headerClass="sortable" />
	           <display:column title="Numero Doc." property="numDocman" headerClass="sortable" />	           
	           <display:column title="Acciones">
	           	<a href="editarTramite.htm?codigo=${row.idMandatario}"><img title="Editar" src="${pageContext.request.contextPath}/img/search.png" height="18px" width="18px"/></a>
	           	<a href="verTramite.htm?codigo=${row.idMandatario}"><img title="Ver" src="${pageContext.request.contextPath}/img/search.png" height="18px" width="18px"/></a>
			</display:column>
	  		</display:table>
		
	</div>
		
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