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
<title>Intranet del Ministerio del Interior</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<link href="css/displaytag.css" rel="stylesheet" type="text/css" />
<link href="css/ajaxtags.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.displaytag-ajax-1.2.js"></script>

<script language="javascript" type="text/javascript">
	
	$( function(){
	   $("#displayTagDiv").displayTagAjax();
	})
	
	function buscarCumple(){		
		document.forms[0].action = "cumplemensual.htm";
		document.forms[0].submit();
	}
	
</script>
</head>


<body>	  
	<form action="cumplemensual.htm">
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
		        			<tr>
		        				<td colspan="3">&nbsp;</td></tr>
		        			<tr>
		        				<th colspan="3" class="tituloEncabezado">Reporte de los Cumpleaños Mensualizados</th>
		        			</tr>
		        			<tr>
		        				<td colspan="3">&nbsp;</td>
	        				</tr>
	        				<tr>
		        				<td>Busqueda por Meses : </td>
		        				<td align="left">
		        					<select name="mes">
		        						<option value="-1" selected="selected">Seleccionar</option>
		       							<option value="1">Enero</option>
		       							<option value="2">Febrero</option>
		       							<option value="3">Marzo</option>
		       							<option value="4">Abril</option>
		       							<option value="5" >Mayo</option>
		       							<option value="6">Junio</option>
		       							<option value="7">Julio</option>
		       							<option value="8">Agosto</option>
		       							<option value="9">Septiembre</option>
		       							<option value="10">Octubre</option>
		       							<option value="11">Noviembre</option>
		       							<option value="12">Diciembre</option>
		       						</select>
		        				</td>
		        				<td>&nbsp;</td>
	        				</tr>
	        				<tr>
		        				<td>Apellidos o Nombres : </td>
		        				<td align="left">
		        					<input type="text" name=nombres maxlength="50" class="texto" size="30" />
		        				</td>
		        				<td>                	
		                   			<div align="left">                      
	                     				<a href="javascript:buscarCumple();"><img width="30" height="30" src="images/buscar.png" border="0" alt="Buscar"/></a>                
		                   			</div>
                    			</td>
	        				</tr>
	        				<tr>
		        				<td colspan="3">&nbsp;</td>
	        				</tr>
		        			<tr>
								<td colspan="3" align="left">
								<div id="displayTagDiv">
						            <display:table name="requestScope.lcumpleaniosMensual" requestURI="cumplemensual.htm" class="displaytag" pagesize="25" defaultsort="5" defaultorder="ascending" id="row" excludedParams="ajax">
							            <display:column title="Nombre Completo" property="nombreCompleto" sortable="true" headerClass="sortable" />
							            <display:column title="Unidad Organica" property="siminUnidadorganica1.nunoDescripcion" sortable="true" headerClass="sortable" />
							            <display:column title="Abreviatura" property="siminUnidadorganica1.nunoAbreviatura" sortable="true" headerClass="sortable" />
						                <display:column title="Cargo/Funcion" sortable="true">
						                <c:choose>
								            <c:when test="${row.ctingCodigo==5 or row.ctingCodigo==7}">
								            	<c:out value="${row.funcionEmp}"/>
								            </c:when>
								            <c:otherwise>
								            	<c:out value="${row.siminGrado2.ngraNombre}"/>
								            </c:otherwise>
								            </c:choose>
							            </display:column>
							            <display:column title="Dia del Mes" sortable="true" headerClass="sortable">
                                           <fmt:formatDate value="${row.dmstFechanacimiento}" pattern="dd-MM"/>
                                   		</display:column>
							   		</display:table>
							   		</div>
								</td>
							</tr>
		        			<tr>
		        				<td colspan="3">&nbsp;</td>
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