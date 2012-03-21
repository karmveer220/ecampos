<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String error = "";
	error = request.getAttribute("msgError")!=null ? (String)request.getAttribute("msgError") : "";
	String mensaje = "";
	mensaje = request.getAttribute("mensaje")!=null ? (String)request.getAttribute("mensaje") : "";
%> 

    	<script language="JavaScript">
	    	function paraloquesea(){
	    		document.forms[0].action='${pageContext.request.contextPath}/constitucion/cerrarTramite.htm';
	    		document.forms[0].submit();
	    	}
	    </script>
	    
 <div id="cuerpo">
    <table width="100%">
        <tr>
            <td height="233">
				<div align="center" style="color: red"> <c:out value="${msgError}"/> </div>
				<div align="center" style="color: blue"> <c:out value="${mensaje}"/> </div>
		
				<form action="nuevoTramite.htm" method="post">
					
					<input type="submit" value="[ NUEVO ]">
				
					
				</form>
								
			    <display:table  name="requestScope.lIncompletos" requestURI="incompletos.htm"  class="displaytag" pagesize="10"
			    	    defaultsort="1" defaultorder="ascending" sort="list" export="false" id="row" excludedParams="ajax" >
		            <display:column title="Kardex" property="clvKardex" sortable="true" headerClass="sortable" />
		            <display:column title="Razon Soc." property="nomRazsoc" sortable="true" headerClass="sortable" />
		            <display:column title="Num. CUO" property="numCuo" sortable="true" headerClass="sortable" />
		            <display:column title="Fec Registro" sortable="true" headerClass="sortable">
		            	<fmt:formatDate value="${row.fecRegistro}" pattern="dd/MM/yyyy"/>
		            </display:column>
		            <display:column title="Acciones">
		            	<a href="verTramite.htm?codigo=${row.numTramite}"><img title="Ver" src="${pageContext.request.contextPath}/img/page.png" height="16px" width="16px"/></a>
		            	<a href="editarTramite.htm?codigo=${row.numTramite}"><img title="Editar" src="${pageContext.request.contextPath}/img/page_edit.png" height="16px" width="16px"/></a>
		            	<a href="cerrarTramite.htm?codigo=${row.numTramite}" onclick="return confirm('Seguro de cerrar el tramite?')"><img title="Cerrar" src="${pageContext.request.contextPath}/img/shield_add.png" height="16px" width="16px"/></a>
		            	<a href="eliminarTramite.htm?codigo=${row.numTramite}" onclick="return confirm('Seguro de eliminar el tramite?')"><img title="Eliminar" src="${pageContext.request.contextPath}/img/delete.png" height="16px" width="16px"/></a>
					</display:column>
		   		</display:table>
				
			</td>
        </tr>
    </table>						
</div>
 <jsp:include page="include/footer.jsp" flush="true"/>