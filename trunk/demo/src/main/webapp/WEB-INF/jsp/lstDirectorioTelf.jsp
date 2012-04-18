<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Directorio Telefonico</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<link href="css/displaytag.css" rel="stylesheet" type="text/css" />
<link href="css/ajaxtags.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

<script language="javascript" type="text/javascript">
	function buscarDirectorioTelf(){	
		document.forms[0].action = "directorioTelf.htm";
		//SSdocument.forms[0].target="baner";
		document.forms[0].submit();
	}
</script>
</head>


<body>	  
	<form action="rptdirectoriotelf.htm">
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">
	  	<tr>
	    	<td height="115" colspan="2" valign="top"> <jsp:include page="cabecera.jsp"/> </td>
	 	</tr>
	  	<tr>
		    <td width="200" valign="top" > <jsp:include page="menu.jsp"/> </td>
		    <td width="700" valign="top">
		    	<div align="center">
		    	<table width="680" border="0" cellspacing="0" cellpadding="0">
		      	<tr>
		        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" /></td>
		        </tr>
		      	<tr>
		        	<td height="150" valign="top" bgcolor="#FFFFFF">	
		        		<br/>
		        		<table width="100%" border="0">
		        			<tr><td colspan="7">&nbsp;</td></tr>
		        			<tr>
		        				<th colspan="7" class="tituloEncabezado">Reporte Directorio Telefonico</th>
		        			</tr>
		        			
		        			<tr><td colspan="7">&nbsp;</td></tr>
		        			<tr><td>Dependencia </td>
		       					<td>:</td>
		       					<td>
		       						<input type="text" name="n_dir_descripcion" id="n_dir_descripcion" maxlength="10" class="texto"
						size="10" /></td>
						 </tr>
						 <tr><td>Telefono </td>
		       					<td>:</td>
		       					<td>
		       						<input type="text" name="n_dir_telefono" id="n_dir_telefono" maxlength="10" class="texto"
						size="10" /></td>
						 </tr>
						 <tr><td>Anexo </td>
		       					<td>:</td>
		       					<td>
		       						<input type="text" name="n_dir_anexo" id="n_dir_anexo" maxlength="10" class="texto"
						size="10" /></td>
						 </tr>
						 <tr>
						 <td>                	
		                   			<div align="left">                      
	                     				<a href="javascript:buscarDirectorioTelf();"><img width="30" height="30" src="images/buscar.png" border="0" alt="Buscar"/></a>                
		                   			</div>
                    			</td>
						 </tr>
		        			<tr><td colspan="7">&nbsp;</td></tr>
		        			<tr>
								<td colspan="7" align="left">
							    	<display:table  name="requestScope.ldirectorioTelf" requestURI="directorioTelf.htm"  class="displaytagJ"
							            defaultsort="4" defaultorder="ascending" sort="list" export="false" id="row" excludedParams="ajax" >
							            <display:column title="Dependencia" property="n_dir_descripcion" sortable="true" headerClass="sortable" />
							            <display:column title="Telefono" property="n_dir_telefono" sortable="true" headerClass="sortable" />
							            <display:column title="Anexo" property="n_dir_anexo" sortable="true" headerClass="sortable" />
							           
							           
							           
							   		</display:table>
								</td>
							</tr>
		        			<tr>
		        				<td colspan="7">&nbsp;</td>
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