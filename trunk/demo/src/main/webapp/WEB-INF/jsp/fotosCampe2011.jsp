<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fotos del Interior</title>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css" media="screen" />

<link rel="stylesheet" type="text/css" href="css/estilos.css" />
<link rel="stylesheet" type="text/css" href="css/style-projects-jquery.css" />

<script type="text/javascript">
	$(document).ready(function(){
	  $("a[rel^='prettyPhoto']").prettyPhoto();
	});	
	
</script>

<style type="text/css">
.irgaleria {
	background-image: url("images/icon_galeria.jpg");
	height: 22px;
	display: block;
	width: 104px;
	margin-left: 480px;
	margin-top: 10px;
}
</style>

</head>

<body>
	
	<div>
		<a href="galeriaFotos.htm" class="irgaleria"></a>
	</div>
	
	<div id="gallery">
		<ul>
			<% List<SiminImagen> lista = (List<SiminImagen>)request.getAttribute("limagenesMininter");
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

</body>
</html>