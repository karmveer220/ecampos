<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>

<html>
<head >
<title>Soporte T&eacute;cnico del Ministerio del Interior</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/scriptaculous/scriptaculous.js"></script>
<script type="text/javascript" src="js/overlibmws/overlibmws.js"></script>
<script type="text/javascript" src="js/ajaxtags.js"></script>

<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/banner.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/displaytag.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="css/ajaxtags.css" ></link>

</head>

<body>
	<table width="900" border="0" align="center" bgcolor="#FFFFFF">		
		<tr>
			<td height="115" colspan="2" valign="top"><jsp:include page="cabecera.jsp" /></td>
		</tr>
		<tr>
			<td width="200" valign="top"><jsp:include page="menu.jsp" /></td>
			<td width="690" valign="top">
				<table width="690" border="0" cellspacing="0" cellpadding="0" >
					<tr>
						<td height="25"><img src="images/blank.jpg" width="2" /></td>
					</tr>
					<tr>
						<th align="center" class="tituloEncabezado">Listado de Requerimientos de los Usuarios</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
					  	<td align="left" width="690">
					  		<display:table name="requestScope.lstTotalCorreos" requestURI="listarCorreo.htm" class="displaytag" pagesize="4"
								defaultsort="1" defaultorder="descending" sort="list" export="true" id="row" excludedParams="ajax">
								<display:column title="Codigo" property="coMailCodigo" sortable="true" headerClass="sortable" media="pdf"/>
								<display:column title="Codigo Atencion" property="coMailGenerado" sortable="true" headerClass="sortable" />
								<display:column title="Empleado" property="siminMaestro.nombreCompleto" sortable="true" headerClass="sortable" />
								<display:column title="Requerimiento" property="naMailRequerimiento" sortable="true" headerClass="sortable" />
								<display:column title="N° de Contacto" property="naMailContacto" sortable="true" headerClass="sortable" />
								<display:column title="N° de Piso" property="naMailPiso" sortable="true" headerClass="sortable" />
								<display:column title="Fec. Requerimiento" sortable="true" headerClass="sortable">
                                	<fmt:formatDate value="${row.daMailFecha}" pattern="dd/MM/yyyy hh:mm:ss"/>
                          		</display:column>
								
								<display:column title="Estado" media="html" headerClass="definition" sortable="true">
									<c:if test='${row.faMailEstado!=null}'>
										<span id="toedit<c:out value='${row.coMailCodigo}'/>"><c:out value='${row.faMailEstado}'/></span>
										<script type="text/javascript"> 
										var $editor_toedit = new Ajax.InPlaceEditor(
												"toedit<c:out value='${row.coMailCodigo}'/>", 
												"editarCorreo.htm?cod=<c:out value='${row.coMailCodigo}'/>", 
												{	
												baseUrl: "editarCorreo.htm?cod=<c:out value='${row.coMailCodigo}'/>",
					                    		target: "toedit<c:out value='${row.coMailCodigo}'/>"
												}
											);
										</script>
									</c:if>
						    	</display:column>
                           		<display:column title="Estado" class="definition" sortable="true" headerClass="sortable">
									<c:if test="${row.faMailEstado==1}">Pendiente</c:if>
									<c:if test="${row.faMailEstado==2}">Atendido</c:if>
								</display:column>
								
                           		
							</display:table>
						</td>
			  		</tr>
			  		<tr>
				  		<td align="left" style="color: red;">						
						*Al editar el estado cambiar por 1 si es que esta pendiente y 2 si ya esta atendido
						</td>
				  	</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="pie"><jsp:include page="copyright.jsp" />
			</td>
		</tr>
	</table>
	
</body>
</html>