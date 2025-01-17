<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <div id="cuerpo">
    <table width="100%">
        <tr>
            <td height="233">
				<div align="center" style="color: red"> <c:out value="${msgError}"/> </div>
				<div align="center" style="color: blue"> <c:out value="${mensaje}"/> </div>
		
				<display:table  name="requestScope.lEliminados" requestURI="eliminados.htm"  class="displaytag" pagesize="10"
			    	    defaultsort="1" defaultorder="ascending" sort="list" export="false" id="row" excludedParams="ajax" >
		            <display:column title="Estado" property="estado" headerClass="sortable" />
		            <display:column title="Kardex" property="clvKardex" headerClass="sortable" />
		            <display:column title="Razon Soc." property="nomRazsoc" headerClass="sortable" />
		            <display:column title="Num. CUO" property="numCuo" headerClass="sortable" />
		            <display:column title="Fec Registro" headerClass="sortable">
		            	<fmt:formatDate value="${row.fecRegistro}" pattern="dd/MM/yyyy"/>
		            </display:column>
		            <display:column title="Acciones">		            	
		            	<a href="verTramite.htm?codigo=${row.numTramite}"><img title="Ver" src="${pageContext.request.contextPath}/img/page.png" height="16px" width="16px"/></a>
		            	<a href="restaurarTramite.htm?codigo=${row.numTramite}" onclick="return confirm('Seguro de restaurar el tramite?')"><img title="Restaurar" src="${pageContext.request.contextPath}/img/arrow_up.png" height="16px" width="16px"/></a>
					</display:column>
		   		</display:table>

			</td>
        </tr>
    </table>						
</div>
 <jsp:include page="include/footer.jsp" flush="true"/>