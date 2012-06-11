<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Asistencia Personal del Ministerio del Interior</title>
<script language="javascript" type="text/javascript">
	function buscarAsistencia() {
		var fechaFin = document.forms[0].fechaFin.value;
		var fechaInicio = document.forms[0].fechaInicio.value;
		
		if (fechaFin != "" && fechaInicio != "") {
			if (compare_dates(fechaInicio, fechaFin)) {
				alert(" Fecha Fin no puede ser inferior a fecha de inicio");
			} else {
				document.forms[0].action = "rptasistencia.htm";
				document.forms[0].target = "baner";
				document.forms[0].submit();
			}
		} else {
			alert(" Ingrese un rango de fechas");
		}
	}
</script>
<%@ include file="../jsp/taglibs.jsp"%>
</head>

<body>
	<form action="" method="post">
		<table width="900" border="0" cellspacing="0" cellpadding="0"
			align="center">

			<tr>
				<td height="115" colspan="2" valign="top"><jsp:include
						page="cabecera.jsp" /></td>
			</tr>
			<tr>
				<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
				<td width="700" valign="top">
					<div align="center">
						<table width="680" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="2" colspan="5"><img src="images/blank.jpg"
									width="2" /></td>
							</tr>
							<tr>
								<td height="150" valign="top" bgcolor="#FFFFFF"><br />
									<table width="700" border="0" class="">
										<tr>
											<td colspan="7">&nbsp;</td>
										</tr>
										<tr>
											<th colspan="7" class="tituloEncabezado">Reporte de
												Asistencia</th>
										</tr>
										<tr>
											<td colspan="7">&nbsp;</td>
										</tr>
										<tr>
											<td>Fecha Inicio</td>
											<td>:</td>
											<td><input type="text" name="fechaInicio"
												id="fechaInicio" maxlength="10" class="texto" size="10" />
												&nbsp; <img src="images/cal.gif" alt="Fecha de Inicio"
												width="16" height="16" border="0" id="triggerCal39" /> <script
													type="text/javascript">
													Calendar
															.setup({
																inputField : "fechaInicio", // id del campo de texto
																ifFormat : "%d/%m/%Y", // Formato de la Fecha
																showsTime : false, // Flag para mostrar la Fecha
																button : "triggerCal39", // ID del elemento que llamara al calendario
																singleClick : true
															// Flag Modo doble-click 
															});
												</script></td>
											<td>Fecha Fin</td>
											<td>:</td>
											<td><input type="text" name="fechaFin" id="fechaFin"
												maxlength="10" class="texto" size="10" /> &nbsp; <img
												src="images/cal.gif" alt="Fecha de Fin" width="16"
												height="16" border="0" id="triggerCal40" /> <script
													type="text/javascript">
													Calendar
															.setup({
																inputField : "fechaFin", // id del campo de texto
																ifFormat : "%d/%m/%Y", // Formato de la Fecha
																showsTime : false, // Flag para mostrar la Fecha
																button : "triggerCal40", // ID del elemento que llamara al calendario
																singleClick : true
															// Flag Modo doble-click 
															});
												</script></td>
											<td>
												<div align="left">
													<a href="javascript:buscarAsistencia();">
														<img width="30" height="30" src="images/buscar.png" border="0" alt="Buscar" />
													</a>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="7">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="7" height="200" colspan="5" valign="top">
												<iframe id="baner" name="baner" scrolling="no" frameborder="0" width="690" height="540" src=""> </iframe>
											</td>
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
	</form>
</body>
</html>