<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Intranet del Ministerio del Interior</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script language="javascript">
   nombres_dias = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")
   nombres_meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
   fecha_actual = new Date()
   dia_mes = fecha_actual.getDate()		//dia del mes
   strdia_mes = (dia_mes <= 9) ? "0" + dia_mes : dia_mes
   dia_semana = fecha_actual.getDay()		//dia de la semana
   mes = fecha_actual.getMonth() + 1
   strmes = (mes <= 9) ? "0" + mes : mes
   anio = fecha_actual.getYear()
   if (anio < 100) anio = "19" + anio			//pasa el año a 4 digitos
   else if ( ( anio > 100 ) && ( anio < 999 ) ) {	//efecto 2000
      var cadena_anio = new String(anio)
      anio = "20" + cadena_anio.substring(1,3)
   }
</script>
</head>

<body>	  
	<table width="1000" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr>
	    <td height="115" colspan="2" valign="top"> <jsp:include page="cabecera.jsp"/> </td>
	  </tr>
	  <tr>
	    <td width="200" valign="top" > <jsp:include page="menu.jsp"/> </td>
	    <td width="700" valign="top">
	    	<table width="680" border="0" cellspacing="0" cellpadding="0">
	      	<tr>
	        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" /></td>
	        </tr>
	      	<tr>
	        	<td height="200" colspan="5" valign="top"><img src="images/tres.JPG" width="690" height="200" /></td>
	        </tr>
	      	<tr>
	        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" height="5" /></td>
	        </tr>
	      	<tr>
		        <td width="220"><div class="botones"><img src="images/utilitarios.gif" width="20" height="20" />Utilitarios</div></td>
		        <td><img src="images/blank.jpg" width="5" height="5" /></td>
		        <td width="220"> <div class="botones"> <img src="images/Computer.png" width="20" height="20" />Sistemas </div></td>
			    <td><img src="images/blank.jpg" width="5" height="5" /></td>
		        <td width="220"><div class="botones"><img src="images/pastel.jpg" width="20" height="20" />Cumplea&ntilde;os</div></td>
	      	</tr>
	      	<tr>
	        	<td height="150" valign="top" bgcolor="#EAEAEA">	
	        		<br/>
	        		<table>
	        			<tr><td>
	        				<a href="rptasistencia.htm" target="_blank"><img src="images/reloj.GIF" width="14" height="14" />Asistencia</a>
        					</td>
        				</tr>
	        			<tr><td>
	        				<a href="rptcasboleta.htm" target="_blank"><img src="images/icon_libro.png" width="14" height="14" />Boleta de pago</a>
	        				</td>
	        			</tr>
	        		</table>
            	</td>
            	<td><img src="images/blank.jpg" width="5" height="5" /></td>
	        	<td valign="top" bgcolor="#EAEAEA" align="left">
	        		<br/>
	        		<ul>
					<c:forEach items="${lstSistemas}" var="sis">
						<li><a href="http://srvprueba:8080/${sis.siminSistema.nsisAbreviatura}" target="_blank"> <c:out value="${sis.siminSistema.nsisDescripcion}"/></a><br/></li><br/>
				    </c:forEach>
				    </ul>			
			    </td>
			    <td><img src="images/blank.jpg" width="5" height="5" /></td>
	       	 	<td valign="top" bgcolor="#EAEAEA">
			   		<c:forEach items="${lcumpleanios}" var="sis">				 	
					 	<li><c:out value="${sis.nombreCompleto}"/></li>
			    	</c:forEach>
			    </td>
	        </tr>
	      	<tr>
		        <td valign="top" colspan="5">&nbsp;</td>
	      	</tr>
	      	<tr>
		        <td valign="top"><div class="botones"><img src="images/soporte.png" width="16" height="16" />Soporte</div></td>
		        <td>&nbsp;</td>		        
		        <td valign="top"><div class="botones"><img src="images/menu.gif" width="20" height="20" />Menu</div></td>
		        <td>&nbsp;</td>		        
		        <td valign="top"><div class="botones"><img src="images/campanas.jpg" width="20" height="20" />Campa&ntilde;as</div></td>
	        </tr>
	      	<tr>
		        <td height="150" valign="top" width="100%" bgcolor="#EAEAEA">
		        	<br/>
		        	<table>
		        		<tr>
		        			<td>Carlos Valenzuela</td>
		        			<td align="right">#422747</td>
		        		</tr>
		        		<tr>
		        			<td>Jimmy Jorge</td>
		        			<td align="right">#422824</td>
		        		</tr>
	        		</table>
	        		<div align="right"><a href="#">Ver mas..</a></div>
				</td>
				<td>&nbsp;</td>
				<td valign="top" bgcolor="#EAEAEA"><br/>test</td>
				<td>&nbsp;</td>
		        <td valign="top" bgcolor="#EAEAEA"><br/>test</td>
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