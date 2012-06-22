<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Galeria del Ministerio del Interior</title>
<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>
<%@ include file="../jsp/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css" media="screen" />
<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
	  $("a[rel^='prettyPhoto']").prettyPhoto();
	});	
	
</script>

</head>

<body>
	<table>
		<tr>
			<td></td>
			<td>
				<div align="left"><a href="galeriaFotos.htm" id="irgaleria" class="irgaleria"></a></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="gallery">
					<ul>
						<% List<SiminImagen> lista = (List<SiminImagen>)request.getAttribute("limagenesPadre");
							for(SiminImagen img : lista){
						%>
						<li>		
							
							<a href="img.htm?id=<%=img.getCoImgCodigo()%>" rel="prettyPhoto[pp_gal2]" title="<%=img.getNaImgNombre() %>">
								<img alt="<%=img.getNaImgNombre() %>" src="img.htm?id=<%=img.getCoImgCodigo()%>" width="130" height="110" alt="Red round shape"/>
							</a>
						</li>
						<%
							}
						%>
					</ul>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>