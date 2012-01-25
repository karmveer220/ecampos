<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	String error = "";
	error = request.getAttribute("msgError")!=null ? (String)request.getAttribute("msgError") : "";
	String mensaje = "";
	mensaje = request.getAttribute("mensaje")!=null ? (String)request.getAttribute("mensaje") : "";
%> 


<script>
	function seguirParticipacion(){
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
		Editando Tramite Kardex 777
		</h2>

<table>
	<tr>
		<td><a href="${pageContext.request.contextPath}/participantes/nuevopn.htm"> Nueva P Natural </a></td>
		<td><a href="${pageContext.request.contextPath}/participantes/nuevopj.htm"> Nueva P Juridica </a></td>
	</tr>
</table>


<table>
	<tr>
		<th>Tipo</th>
		<th>nombre</th>
		<th>apellido</th>
		<th>documento</th>
		<th>Numero doc</th>
		<th>acciones</th>
	</tr>
	<tr>
		<td>Natural</td>
		<td>juan</td>
		<td>perez</td>
		<td>DNI</td>
		<td>12345678</td>
		<td> <a href="#">X</a> <a href="#">E</a></td>
	</tr>
	<tr>
		<td>Natural</td>
		<td>juan</td>
		<td>perez</td>
		<td>DNI</td>
		<td>12345678</td>
		<td> <a href="#">X</a> <a href="#">E</a></td>
	</tr>
	<tr>
		<td>Natural</td>
		<td>juan</td>
		<td>perez</td>
		<td>DNI</td>
		<td>12345678</td>
		<td> <a href="#">X</a> <a href="#">E</a></td>
	</tr>
</table>	


		<form action="tramitePasoTres.htm" method="post">			
		
			<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button onclick="grabarTramite()">Grabar</button></td>
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