<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Intranet del Ministerio del Interior</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="css/calendar-system.css" ></link>
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/calendar-es.js"></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>

<script language="javascript" type="text/javascript">
	function buscarAsistencia(){	
		document.forms[0].action = "rptasistencia.htm";
		document.forms[0].target="baner";
		document.forms[0].submit();
	}
</script>
</head>


<body>	  
	<form action="" method="post">
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
		        		<table width="700" border="0" class="">
		        			<tr><td colspan="7">&nbsp;</td></tr>
		        			<tr>
		        				<th colspan="7" class="tituloEncabezado">Reporte de Asistencia </th>
		        			</tr>
		        			<tr><td colspan="7">&nbsp;</td></tr>
		        			<tr>
		        				<td>Fecha Inicio </td>
		       					<td>:</td>
		       					<td>
		       						<input type="text" name="fechaInicio" id="fechaInicio" maxlength="10" class="texto"
						size="10" />
		       						&nbsp; <img src="images/cal.gif"
						alt="Fecha de Inicio" width="16" height="16" border="0"
						id="triggerCal39" /> <script type="text/javascript">
						Calendar.setup( {
							inputField :"fechaInicio", // id del campo de texto
							ifFormat :"%d/%m/%Y", // Formato de la Fecha
							showsTime :false, // Flag para mostrar la Fecha
							button :"triggerCal39", // ID del elemento que llamara al calendario
							singleClick :true
						// Flag Modo doble-click 
								});
					</script>
							  </td>
		       					<td>Fecha Fin </td>
		       					<td>:</td>
								<td>
									<input type="text" name="fechaFin" id="fechaFin"  maxlength="10" class="texto" size="10" />
									&nbsp;
					<img src="images/cal.gif" alt="Fecha de Fin" width="16"
						height="16" border="0" id="triggerCal40" /> <script
						type="text/javascript">
									Calendar.setup( {
										inputField :"fechaFin", // id del campo de texto
										ifFormat :"%d/%m/%Y", // Formato de la Fecha
										showsTime :false, // Flag para mostrar la Fecha
										button :"triggerCal40", // ID del elemento que llamara al calendario
										singleClick :true
									// Flag Modo doble-click 
											});
								</script>
								</td>
								<td>                	
		                   			<div align="left">                      
	                     				<a href="javascript:buscarAsistencia();"><img width="30" height="30" src="images/buscar.png" border="0" alt="Buscar"/></a>                
		                   			</div>
                    			</td>
							</tr>
		        			<tr>
		        				<td colspan="7">&nbsp;</td>
		        			</tr>
		        			<tr>
			        			<td colspan="7" height="200" colspan="5" valign="top">
					        		<iframe id="baner" name="baner" scrolling="no" frameborder="0" width="690" height="540" src="" > </iframe>
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