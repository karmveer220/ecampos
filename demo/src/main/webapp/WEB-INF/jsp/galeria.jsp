<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Galeria del Ministerio del Interior</title>
<%@ include file="../jsp/taglibs.jsp"%>
</head>

<body>
	<table width="900" border="0" cellspacing="0" cellpadding="0" align="center">		
		<tr>
			<td height="115" colspan="2" valign="top">
				<jsp:include page="cabecera.jsp" />
			</td>
		</tr>
		<tr>
			<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
			<td width="700" valign="top">
				<div align="center">
				<table width="700" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="2"><img src="images/blank.jpg" width="2" /></td>
					</tr>
					<tr>
						<td height="150" valign="top"><br />
							<table width="700" border="0">
								<tr>
									<td class="tituloEncabezado">
										Galer&iacute;a Fotogr&aacute;fica
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<th align="left">
										Click en la imagen para ver el album completo
									</th>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="center">
									  <div align="center">
										<table width="695" border="0" cellspacing="0" cellpadding="0">	
											<tr>    			
												<td align="center">
												  <div align="center">
														<iframe scrolling="no" frameborder="0" width="690" height="550" src="galeriaFotos.htm"></iframe>
													</div>
												</td>
												
											</tr>
										</table>
										</div>
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
			<td colspan="2" class="pie"><jsp:include page="copyright.jsp" /></td>
		</tr>
	</table>

</body>
</html>