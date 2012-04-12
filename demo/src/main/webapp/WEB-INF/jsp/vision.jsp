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

	<table width="1000" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<form action="" method="post">
			<tr>
				<td height="115" colspan="2" valign="top"><jsp:include
						page="cabecera.jsp" /></td>
			</tr>
			<tr>
				<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
				<td width="700" valign="top">
					<table width="795" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="2" colspan="5"><img src="images/blank.jpg"
								width="2" /></td>
						</tr>
						<tr>
							<td height="150" valign="top"><br />
								<table width="100%" border="0" class="">

									<tr>
										<th class="">&nbsp;</th>
										<th colspan="9" class="">
											<div align="left">VISI&Oacute;N</div>
										</th>
										<th class="">&nbsp;</th>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="9"><div align="justify">
												<p>Ser un Sector proactivo que aplica adecuadas
													estrategias que garanticen el mantenimiento del Orden
													Interno, Orden P&uacute;blico y la Seguridad Ciudadana, en
													el marco de una cultura de paz y respecto a los derechos
													humanos que coadyuve a mejorar la convivencia
													pac&iacute;fica.</p>
											</div></td>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<th class="">&nbsp;</th>
										<th colspan="9" class="">
											<div align="left">MISI&Oacute;N</div>
										</th>
										<th class="">&nbsp;</th>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="9"><div align="justify">El Ministerio
												del Interior es un organismo p&uacute;blico que, en
												armon&iacute;a con las disposiciones constitucionales y la
												Pol&iacute;tica General del Estado, se encarga de proteger y
												garantizar el libre ejercicio de los derechos y libertades
												fundamentales de las personas, mantener y restablecer el
												orden interno democr&aacute;tico, el orden p&uacute;blico y
												la seguridad interna del pa&iacute;s; competente para
												intervenir en todos los asuntos relacionados con el
												cumplimiento de su finalidad: Gobierno Interior, Seguridad
												Interna, Funci&oacute;n Policial, Movimiento Migratorio y
												Naturalizaci&oacute;n, Control de Servicios de Seguridad,
												Control de Armas, Munici&oacute;n y Explosivos de Uso Civil,
												entre otras que la ley le asigna, generando una cultura de
												convivencia pac&iacute;fica y solidaridad que contribuya con
												el pa&iacute;s para alcanzar el bienestar y el desarrollo
												humano.</div></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="9">&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="9">&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="9">&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
								</table></td>
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