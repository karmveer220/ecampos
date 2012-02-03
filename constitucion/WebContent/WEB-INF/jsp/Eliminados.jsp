<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%
	String error = "";
	error = request.getAttribute("msgError")!=null ? (String)request.getAttribute("msgError") : "";
	String mensaje = "";
	mensaje = request.getAttribute("mensaje")!=null ? (String)request.getAttribute("mensaje") : "";
%> 
 <div id="cuerpo">
    <table width="100%">
        <tr>
            <td height="233">
				<div align="center" style="color: red"> <%=error %> </div>
				<div align="center" style="color: blue"> <%=mensaje %> </div>
		
				<display:table  name="requestScope.lEliminados" requestURI="eliminados.htm"  class="displaytag" pagesize="10"
			    	    defaultsort="1" defaultorder="ascending" sort="list" export="false" id="row" excludedParams="ajax" >
		            <display:column title="Estado" property="indEstado" headerClass="sortable" />
		            <display:column title="Kardex" property="clvKardex" headerClass="sortable" />
		            <display:column title="Razon Soc." property="nomRazsoc" headerClass="sortable" />
		            <display:column title="Num. CUO" property="numCuo" headerClass="sortable" />
		            <display:column title="Fec Registro" property="fecRegistro" headerClass="sortable" />
		            <display:column title="Acciones">
		            	<a href="restaurarTramite.htm?codigo=${row.numTramite}"><img title="Restaurar" src="${pageContext.request.contextPath}/img/search.png" height="18px" width="18px"/></a>
		            	<a href="verTramite.htm?codigo=${row.numTramite}"><img title="Ver" src="${pageContext.request.contextPath}/img/search.png" height="18px" width="18px"/></a>
					</display:column>
		   		</display:table>

			</td>
        </tr>
    </table>						
</div>
 <jsp:include page="include/footer.jsp" flush="true"/>