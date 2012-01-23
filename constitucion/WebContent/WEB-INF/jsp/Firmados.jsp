 <jsp:include page="include/header.jsp" flush="true"/>
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
					
					<table>
						<tr>
							<th>Acciones</th>
							<th>Kardex</th>
							<th>CUO</th>
							<th>Razon Social</th>
							<th>Fecha Creacion</th>		
						</tr>
						<tr>
							<td>
								<a href="#" title="Eliminar">X</a>&nbsp;
								<a href="#" title="Ver">Ver</a>&nbsp;
								<a href="#" title="Imprimir">Parte</a>&nbsp;
								<a href="#" title="Enviar">Env</a>
							</td>
							<td>2345</td>
							<td>0000003</td>
							<td>Empresa UNO SAC</td>
							<td>10/10/2012</td>
						</tr>
					</table>

			</td>
        </tr>
    </table>						
</div>
 <jsp:include page="include/footer.jsp" flush="true"/>