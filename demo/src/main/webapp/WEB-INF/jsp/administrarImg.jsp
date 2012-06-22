<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Administrar Imagenes</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ include file="../jsp/taglibs.jsp"%>
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
		        	<td height="150" valign="top" align="center">	
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
									<table cellpadding="0" width="700" cellspacing="10">
										<tr>
											<th colspan="3" class="tituloEncabezado">Carga Masiva de Archivos</th>
										</tr>
										<tr>
											<td>
												Carga de jQuery Upload
											</td>
											<td>:</td>
											<td align="left"><a href="inicio2.htm">jQuery File Upload Demo</a> </td>
										</tr>
										<tr>
											<td>
												Carga de Archivos
											</td>
											<td>:</td>
											<td align="left"> 
												<input type="file" name="imagenes"/>
											</td>
										</tr>
										<tr>
											<td colspan="3" align="right">
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