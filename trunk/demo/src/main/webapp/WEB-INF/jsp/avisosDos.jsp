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

	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">		
		<tr>
			<td height="115" colspan="2" valign="top"><jsp:include
					page="cabecera.jsp" /></td>
		</tr>
		<tr>
			<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
			<td width="700" valign="top">
				<div align="center">
				<table width="700" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="2" colspan="5"><img src="images/blank.jpg"
							width="2" /></td>
					</tr>
					<tr>
						<td height="150" valign="top" bgcolor="#FFFFFF"><br />
							<table width="700" border="0" class="">
								
								<tr>
									<td colspan="7"><iframe scrolling="yes" frameborder="0"
											width="700" height="700"
											src="http://www.mininter.gob.pe/comunicados/BoletinBienestar01.pdf">
										</iframe></td>
								</tr>
							</table></td>
					</tr>
				</table>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="pie"><jsp:include page="copyright.jsp" />
			</td>
		</tr>
	</table>

</body>
</html>