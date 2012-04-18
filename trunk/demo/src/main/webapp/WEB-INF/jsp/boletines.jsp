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
			<td width="700" valign="top"><table width="695" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>&nbsp;</td>
                <td><img src="images/blank.jpg"
							width="2" height="5" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><img src="images/blank.jpg" width="2" height="5" /></td>
                <td class="tituloEncabezado">Oficina de Comunicaci&oacute;n Social / Bolet&iacute;n Informativo</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="center">
                	<a href="http://www.mininter.gob.pe/comunicados/boletin.informativo-IV-63.pdf" target="baner"><strong>
					<img src="images/boletin.png" width="15" height="15" /> BOLETIN  INFORMATIVO N&ordm; 063 - A&ntilde;o IV</strong></a>
				</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="center"> 
	                <a href="http://www.mininter.gob.pe/comunicados/boletin.informativo-IV-62.pdf" target="baner"><strong>
	                <img src="images/boletin.png" width="15" height="15" />BOLETIN  INFORMATIVO N&ordm; 062 - A&ntilde;o IV</strong></a>
                </td>
                <td>&nbsp;</td>
              </tr>
              <tr >
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="center">
                	<a href="http://www.mininter.gob.pe/comunicados/boletin.informativo-61-V.pdf" target="baner"><strong>
					<img src="images/boletin.png" width="15" height="15" /> BOLETIN  INFORMATIVO N&ordm; 061 - A&ntilde;o </strong></a><a href="http://www.mininter.gob.pe/comunicados/boletin.informativo-IV-62.pdf" target="_blank"><strong>IV</strong></a>
				</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><iframe id="baner" name="baner" scrolling="no" frameborder="0" width="690" height="540" src="" > </iframe></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>			</td>
		</tr>
		<tr>
			<td colspan="2" class="pie"><jsp:include page="copyright.jsp" />
			</td>
		</tr>
	</table>

</body>
</html>