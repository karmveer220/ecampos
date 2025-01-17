<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="pe.gob.pcm.constitucion.web.model.T025pernat"%>
<%@page import="pe.gob.pcm.constitucion.web.bean.Parametro"%>
<%@page import="java.util.List"%>
<%@page import="pe.gob.pcm.constitucion.web.model.T001parametro"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp" flush="true"/>

<form:form name="personaForm" action="${pageContext.request.contextPath}/constitucion/regresaPasoDos.htm" method="post" modelAttribute="persona">

	<form:hidden path="idPernat"/>
	
	<table width="90%">
		<tr>
			<td align="center">
				<table cellspacing="10" width="640px">
					<tr>
						<td colspan="3" align="left" style="color:gray;border-bottom:1px solid #ccc"><b><span id="personaAsunto">Persona Natural</span></b></td>
					</tr>
					<tr>
						<td align="left" width="160px" style="padding-left:10px">(<b>+</b>) <b>Tipo Participante</b>:</td>
						<td colspan="2" width="440px" align="left"><c:out value="${persona.descParticipa}"/></td>
					</tr>
					<tr>
						<td align="left" width="160px" style="padding-left:10px">(<b>+</b>) <b>Tipo documento</b>:</td>
						<td colspan="2" width="440px" align="left"><c:out value="${persona.descTipdoc}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(<b>+</b>) <b>N&uacute;mero de documento</b>:</td>
						<td align="left" width="135px" colspan="2"><c:out value="${persona.numDocum}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Paterno:</td>
						<td colspan="2" align="left"><c:out value="${persona.apePaterno}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Materno:</td>
						<td colspan="2" align="left"><c:out value="${persona.apeMaterno}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nombres:</td>
						<td colspan="2" align="left"><c:out value="${persona.nomPernat}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nacionalidad:</td>
						<td colspan="2" align="left"><c:out value="${persona.codPais}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">Profesion/Ocupaci&oacute;n:</td>
						<td colspan="2" align="left"><c:out value="${persona.desProfesion}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Domicilio / Direcci&oacute;n:</td>
						<td colspan="2" align="left"><c:out value="${persona.dirPernat}"/></td>						
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Departamento:</td>
						<td colspan="2" align="left"><c:out value="${persona.descDepa}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Provincia:</td>
						<td colspan="2" align="left"><c:out value="${persona.descProv}"/></td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Distrito:</td>
						<td colspan="2" align="left"><c:out value="${persona.descUbigeo}"/></td>
					</tr>
				
					<tr>
						<td align="left" style="padding-left:10px">(*) Estado Civil:</td>
						<td colspan="2" align="left"><c:out value="${persona.descEstcivil}"/></td>
					</tr>
					<tr>
						<td colspan="3" align="left">
					<% 
						 	T025pernat persona = (T025pernat)request.getAttribute("persona");
							String estciv = "none";
							String aporte = "none";
							String aporte2 = "none";
							if( StringUtils.isNotEmpty( persona.getCodEstcivil()) ){
								if(persona.getCodEstcivil().equals("02") ){
									estciv = "block";
								}
							}
							if( StringUtils.isNotEmpty( persona.getIndAporte()) ){
								if( !persona.getIndAporte().equals("2") ){
									aporte = "block";
								}
								if( !persona.getIndAporte().equals("1") ){
									aporte2 = "block";
								}
							}
						%>
							<div id="personaCasado" style="border:1px solid #ccc; padding:4px; display: <%=estciv %>;">
								<table cellspacing="5" width="100%">
									<tr>
										<td width="165px">(*) Tipo documento conyuge:</td>
										<td width="435px" colspan="2"><c:out value="${persona.descTdcon}"/></td>
									</tr>
									<tr>
										<td>(*) N&uacute;mero de documento:</td>
										<td colspan="2"><c:out value="${persona.numDoccon}"/></td>
									</tr>
									<tr>
										<td>(*) Apellido paterno conyuge:</td>
										<td colspan="2"><c:out value="${persona.apePatcon}"/></td>
									</tr>
									<tr>
										<td>(*) Apellido materno conyuge:</td>
										<td colspan="2"><c:out value="${persona.apeMatcon}"/></td>
									</tr>
									<tr>
										<td>(*) Nombres conyuge:</td>
										<td colspan="2"><c:out value="${persona.nomConyuge}"/></td>
									</tr>
									<tr>
										<td>(*) Profesi&oacute;n conyuge:</td>
										<td colspan="2"><c:out value="${persona.desProfcon}"/></td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Tipo de aporte:</td>
						<td colspan="2" align="left">						
							<c:if test="${persona.indAporte == 1}">Dinerario</c:if>
							<c:if test="${persona.indAporte == 2}">No Dinerario</c:if>
							<c:if test="${persona.indAporte == 3}">Ambos</c:if>
						</td>
					</tr>	
					<tr>
						<td colspan="3" align="left">
							<div id="divMontoAporte" style="display:<%=aporte %>">
								<table cellspacing ="0" width="100%">
									<tr>
										<td width="167px" style="padding-left:10px">Monto Aporte S/.:</td>
										<td width="433px">
											<c:out value="${persona.montoAporte}"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="left">
							
							<input type="submit" name="btCancelar" value="Regresar"/>
							<!-- si es no dinerario o ambos, muestro este detalle de bienes -->
							<div id="toolbarAportes" style="border:1px solid #99BBE8; border-Bottom:0px; width:610px; display:<%=aporte2 %>;">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Lista de aporte de bienes</b></div>
							</div>				
							<div id="divGridAportes" style="border:1px solid #99BBE8; position:relative; text-align:left; height:150px; width:614px;display:<%=aporte2 %>;">
								<table>
										<thead>
										<tr>
											<th width="120px">Cantidad</th>
											<th width="280px">Descripci&oacute;n de bienes</th>
											<th width="120px">Valor de Mercado</th>
										</tr>
									</thead>
								</table>
							</div>
							
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form:form>

<jsp:include page="include/footer.jsp" flush="true"/>