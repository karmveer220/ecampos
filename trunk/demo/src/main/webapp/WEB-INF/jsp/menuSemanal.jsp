<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Menu Semanal del Ministerio del Interior</title>
<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>
<%@ include file="../jsp/taglibs.jsp"%>
</head>

<body>	  
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">
	  	<tr>
	    	<td height="115" colspan="2" valign="top"> <jsp:include page="cabecera.jsp"/> </td>
	 	</tr>
	  	<tr>
		    <td width="200" valign="top" > <jsp:include page="menu.jsp"/> </td>
		    <td width="700" valign="top" align="center">
		    	<table width="680" border="0" cellspacing="0" cellpadding="0">
		      	<tr>
		        	<td width="660" height="2"><img src="images/blank.jpg" width="2" /></td>
		        </tr>
		      	<tr>
		        	<td height="200" valign="top">
		        		<% SiminImagen lista = (SiminImagen)request.getAttribute("lmenu");%>
		        			<img alt="<%=lista.getNaImgNombre() %>" src="img.htm?id=<%=lista.getCoImgCodigo()%>" width="690px" height="700px" alt=""/>
		        		<% %>
		        	</td>
		        </tr>
		      	<tr>
		        	<td height="2"><img src="images/blank.jpg" width="2" height="5" /></td>
		        </tr>		      	
		    	</table>
	    	</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2" class="pie">  <jsp:include page="copyright.jsp"/> </td>
	  	</tr>
	</table>
</body>
</html>