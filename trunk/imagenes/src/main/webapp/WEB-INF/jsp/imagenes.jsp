 <%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="pe.org.notarios.web.model.Imagenes"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 
 <html>
<body>
   
   <a href="inicio2.htm">jQuery File Upload Demo</a>
   
	<form action="carga.htm" method="post"  enctype="multipart/form-data"> 
	
	<table cellpadding="0" width="100%">
		<tr>
			<td colspan="3"> Carga de imagenes </td>
		</tr>
		<tr>
			<td colspan="3"> 
				<input type="file" name="imagenes"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Enviar"/>
			</td>
		</tr>
	</table>
	</form>
	
	<% List<Imagenes> lista = (List<Imagenes>)request.getAttribute("limagenes");
		for(Imagenes img : lista){
	%>
	
		<img alt="<%=img.getNombre() %>" src="img.htm?id=<%=img.getIdImagen()%>"> <br/>		
	<%
		}
	%>
		
	
		
		

	
</body>
</html>
