<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Imagenes</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

</head>
<body>
	
	<form action="carga.htm" method="post" enctype="multipart/form-data">
	
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">
	  	<tr>
	    	<td height="115" colspan="2" valign="top"> <jsp:include page="cabecera.jsp"/> </td>
	 	</tr>
	  	<tr>
		    <td width="200" valign="top" > <jsp:include page="menu.jsp"/> </td>
		    <td width="700" valign="top">
		    	<div align="center">
		    	<table width="700" border="0" cellspacing="0" cellpadding="0">
		      	<tr>
		        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" /></td>
		        </tr>
		      	<tr>
		        	<td height="150" valign="top" bgcolor="#FFFFFF" align="center">	
		        		<br/>
		        		<table width="700" border="0" class="">
		        			<tr>
		        				<td>&nbsp;</td>
		        			</tr>		        			
		        			<tr>
		        				<td>&nbsp;</td>
		        			</tr>
		        			<tr>
					        	<td height="200" valign="top">
									<table cellpadding="0" width="100%">
										<tr>
										<a href="inicio2.htm">jQuery File Upload Demo</a>
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
								</td>
				        	</tr>
		        		</table>	        		
		           	</td>
		        </tr>
		    	</table>
		    	</div>
	    	</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2" class="pie">  <jsp:include page="copyright.jsp"/> </td>
	  	</tr>
	</table>
	
	
	</form>
</body>
</html>