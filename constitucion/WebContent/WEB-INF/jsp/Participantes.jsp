<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	String error = "";
	error = request.getAttribute("msgError")!=null ? (String)request.getAttribute("msgError") : "";
	String mensaje = "";
	mensaje = request.getAttribute("mensaje")!=null ? (String)request.getAttribute("mensaje") : "";
%> 


<script>
	function seguirParticipacion(){
		document.forms[0].action='${pageContext.request.contextPath}/constitucion/tramitePasoTres.htm';
		document.forms[0].submit();
	}

	function mostrarTramite(){
		document.forms[0].action='${pageContext.request.contextPath}/constitucion/regresaPasoUno.htm';
		document.forms[0].submit();
	}
	
</script>

 <div id="cuerpo">
    <table width="100%">
        <tr>
            <td height="233">
				<div align="center" style="color: red"> <%=error %> </div>
				<div align="center" style="color: blue"> <%=mensaje %> </div>
		
		<h2>
		<c:if test="${tramitesistema.numTramite eq null }">Nuevo Tramite</c:if>
		<c:if test="${tramitesistema.numTramite ne null }">Editando Tramite Kardex <c:out value="${tramitesistema.clvKardex}"/></c:if>		
		</h2>	

		<table>
			<tr>
				<td><a href="${pageContext.request.contextPath}/participantes/nuevopn.htm"> Nueva P Natural </a></td>
				<td><a href="${pageContext.request.contextPath}/participantes/nuevopj.htm"> Nueva P Juridica </a></td>
			</tr>
		</table>

		<display:table  name="requestScope.lparticipantes" class="displaytag" pagesize="10"
	    	    defaultsort="1" defaultorder="ascending"  export="false" id="row" excludedParams="ajax" >
	           
	           <display:column title="Tipo" property="codParticipa" headerClass="sortable" />
	           <display:column title="Tipo. Documento" property="codTipdoc" headerClass="sortable" />
	           <display:column title="Documento" property="numDocum" headerClass="sortable" />
	           <display:column title="Aporte" property="mtoAporte" headerClass="sortable" />
	           
	           <display:column title="Acciones">
	           	<a href="editarTramite.htm?codigo=${row.idAccionista}"><img title="Editar" src="${pageContext.request.contextPath}/img/search.png" height="18px" width="18px"/></a>
	           	<a href="verTramite.htm?codigo=${row.idAccionista}"><img title="Ver" src="${pageContext.request.contextPath}/img/search.png" height="18px" width="18px"/></a>
			</display:column>
	  		</display:table>

		<form action="tramitePasoTres.htm" method="post">
		
			<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button onclick="mostrarTramite()">Anterior</button></td>
				<td>&nbsp;</td>
				<td><button onclick="seguirParticipacion()">Siguiente</button></td>
				<td>&nbsp;</td>
				<td><button onclick="salirTramite()">Salir</button></td>
			</tr>
			</table>
		
		</form>
			
			
				
			</td>
        </tr>
    </table>						
</div>
<jsp:include page="include/footer.jsp" flush="true"/>