<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />


<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

</head>

<body>
<table width="680" border="0"   cellspacing="0" cellpadding="0">
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
        <td width="230"><div   class="botones"><img src="images/utilitarios.gif" width="20" height="20" />Utilitarios</div></td>
		        <td rowspan="5"><img src="images/blank.jpg" width="5" height="5" /></td>
        <td width="230"> <div   class="botones"> <img src="images/Computer.png" width="20" height="20" />Sistemas </div></td>
		    <td rowspan="5"><img src="images/blank.jpg" width="5" height="5" /></td>
        <td width="230"><div   class="botones"><img src="images/pastel.jpg" width="20" height="20" />Cumplea&ntilde;os</div></td>
      </tr>
      <tr>
        <td height="150" valign="top" bgcolor="#EAEAEA"><img src="images/reloj.GIF" width="20" height="20" />Asistencia <br>
        <img src="images/icon_libro.png" width="20" height="20" />Boleta de pago</td>
        <td valign="top" bgcolor="#EAEAEA" >

		
			<c:forEach items="${lstSistemas}" var="sis">
				 	<li>
			 		  <a href="http://srvprueba:8080/${sis.siminSistema.nsisAbreviatura}" target="_blank">
				 			<c:out value="${sis.siminSistema.nsisDescripcion}"/>
			 		  </a>				 	</li>				 	
		    </c:forEach>			</td>
        <td valign="top" bgcolor="#EAEAEA">    <c:forEach items="${lcumpleanios}" var="sis">				 	
				 	<li>
				 	  <c:out value="${sis.nombreCompleto}"/> </li>
		    </c:forEach></td>
        </tr>
      <tr>
        <td valign="top">&nbsp;</td>
        <td height="10" valign="top">&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><div class="botones"><img src="images/soporte.png" width="20" height="20" />Soporte</div></td>
        <td valign="top"><div class="botones"><img src="images/menu.gif" width="20" height="20" />Menu</div></td>
        <td valign="top"><div class="botones"><img src="images/campanas.jpg" width="20" height="20" />Campa&ntilde;as</div></td>
        </tr>
      <tr >
        <td height="150" bgcolor="#EAEAEA">&nbsp;</td>
        <td bgcolor="#EAEAEA">&nbsp;</td>
        <td bgcolor="#EAEAEA">&nbsp;</td>
        </tr>
    </table>
</body>
</html>
