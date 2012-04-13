<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Intranet del Ministerio del Interior</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.5.1.min.js" type="text/javascript"></script>



</head>


<body>

	<table width="900" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<form action="" method="post">
			<tr>
				<td height="115" colspan="2" valign="top"><jsp:include
						page="cabecera.jsp" /></td>
			</tr>
			<tr>
				<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
				<td width="700" valign="top">
					<table width="675" border="0" cellspacing="0" cellpadding="0" >

					<tr>
						<td height="2" colspan="6"><img src="images/blank.jpg"
							width="2" /></td>
					</tr>

					<tr>
						<td height="2" colspan="6"><img src="images/blank.jpg"
							width="2" height="5" /></td>
					</tr>

					<tr>
				        <td width="5" valign="top"><img src="images/blank.jpg" width="5" height="5" /></td>					
						<td width="220" height="210" valign="top" bgcolor="#EAEAEA">						</td>
						<td width="5"><img src="images/blank.jpg" width="5" height="5" /></td>
						<td width="220" align="left" valign="top" bgcolor="#EAEAEA">
						<div align="center">
						 <a href="http://www.mininter.gob.pe/comunicados/DiadelNinoPeruano.jpg" target="_blank"> <img src="images/campana_nino.jpg" width="220" height="210" border="1" /></a>					   </div>
						</td>
						<td width="5" height="5"><img src="images/blank.jpg" width="5" height="5" /></td>
						<td width="220" valign="top" bgcolor="#EAEAEA"></td>

					</tr>
					<tr>
						<td valign="top" colspan="6">&nbsp;</td>
					</tr>

					<tr>
									        <td width="5" valign="top" ></td>
						<td height="210" valign="top" width="210" bgcolor="#EAEAEA">
												</td>
						<td width="5">&nbsp;</td>
						<td valign="top" bgcolor="#EAEAEA"></td>
						<td>&nbsp;</td>
						<td valign="top" bgcolor="#EAEAEA">
						<div align="center">
						 <a href="http://www.mimp.gob.pe/mujer/" target="_blank"> <img src="images/campana_mujer.jpg" width="220" height="210" /></a>
					   </div>					                            
                       
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="pie"><jsp:include page="copyright.jsp" />
				</td>
			</tr>
		</form>
	</table>

</body>
</html>