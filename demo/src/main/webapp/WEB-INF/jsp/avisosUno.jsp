<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Directivas de Ecoeficiencia</title>
<%@ include file="../jsp/taglibs.jsp"%>
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
				<table  border="0" cellspacing="0" cellpadding="0">					
					<tr>
						<td height="150" valign="top">
							<table width="690" border="0">								
								<tr>
									<td>
										<c:if test="${not empty beanPublicacion1 }">
											<iframe scrolling="yes" frameborder="0" width="690" height="670" src="pdf.htm?id=${beanPublicacion1.coImgCodigo}"></iframe>
					                	</c:if>
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
			<td colspan="2" class="pie"><jsp:include page="copyright.jsp" />
			</td>
		</tr>
	</table>

</body>
</html>