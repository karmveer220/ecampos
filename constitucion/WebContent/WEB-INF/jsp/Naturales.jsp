<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="pe.gob.pcm.constitucion.web.model.T025pernat"%>
<%@page import="pe.gob.pcm.constitucion.web.bean.Parametro"%>
<%@page import="java.util.List"%>
<%@page import="pe.gob.pcm.constitucion.web.model.T001parametro"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp" flush="true"/>

<script>

	function grabar(){		
		document.forms[0].submit();
	}
	
	function perEstadoCivil(){
		var obj = document.getElementById('personaEstadoCivil');
		var sel = obj.options[obj.selectedIndex].value;
		if( sel == '02' ){ 
			document.getElementById('personaCasado').style.display='block';
		}else{
			document.getElementById('personaCasado').style.display='none';
		}
	}

	function cmbperTipoAporte(){
		var obj = document.getElementById('TipoAporte');
		var sel = obj.options[obj.selectedIndex].value;
		if( sel == '2' ){ 
			document.getElementById('divMontoAporte').style.display='block';
			document.getElementById('toolbarAportes').style.display='block';
			document.getElementById('divGridAportes').style.display='block';  
		}else{
			document.getElementById('divMontoAporte').style.display='none';
			document.getElementById('toolbarAportes').style.display='none';
			document.getElementById('divGridAportes').style.display='none';
		}
	}
</script>

<form:form name="personaForm" action="registrapn.htm" method="post" modelAttribute="persona">

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
						<td colspan="2" width="440px" align="left">
							<form:select path="codParticipa" id="personaTipoParticipante" cssStyle="width:240px">
								<option value="0000">SELECCIONE TIPO DE PARTICIPANTE</option>
								<form:options items="${lsParticipante}" itemLabel="desParam" itemValue="codParam"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td align="left" width="160px" style="padding-left:10px">(<b>+</b>) <b>Tipo documento</b>:</td>
						<td colspan="2" width="440px" align="left">
							<form:select path="codTipdoc" id="personaTipoDocumento" cssStyle="width:200px" onchange="notarios.cmbperTipoDocu()">
								<form:options items="${lsTipoDoc}" itemLabel="desParam" itemValue="codParam"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(<b>+</b>) <b>N&uacute;mero de documento</b>:</td>
						<td align="left" width="135px">
							<form:input path="numDocum" id="personaNumeroDocumento" maxlength="8" cssStyle="font-size:13px; width:120px" onchange="notarios.cmbperNumeDocu()"/>
						</td>
						<td align="left">
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Paterno:</td>
						<td colspan="2" align="left">
							<form:input path="apePaterno" id="personaApellidoPaterno"  maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Apellido Materno:</td>
						<td colspan="2" align="left">
							<form:input path="apeMaterno" id="personaApellidoMaterno" maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nombres:</td>
						<td colspan="2" align="left">
							<form:input path="nomPernat" id="personaNombres" maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Nacionalidad:</td>
						<td colspan="2" align="left">
							<form:select path="codPais" id="personaNacionalidad" cssStyle="width:200px">
								<option value="PE" selected="selected">PERU</option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">Profesion/Ocupaci&oacute;n:</td>
						<td colspan="2" align="left">
							<form:input path="desProfesion" id="personaProfesion" maxlength="100" cssStyle="font-size:13px; width:270px"/>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Domicilio / Direcci&oacute;n:</td>
						<td colspan="2" align="left">
							<form:input path="dirPernat" id="personaDireccion" maxlength="100" cssStyle="font-size:13px; width:300px"/>
						</td>						
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Departamento:</td>
						<td colspan="2" align="left">
							<form:select path="codDepa" id="Departamento" cssStyle="width:220px" 
									onchange="javascript:comboDepartamento(document.getElementById('Departamento'));">
								<form:options items="${lsDepartamentos}" itemLabel="desParam" itemValue="codParam"/>								
							</form:select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Provincia:</td>
						<td colspan="2" align="left">
							<form:select path="codDepa" id="Provincia" cssStyle="width:220px"
								onchange="javascript:comboProvincia(document.getElementById('Departamento'),document.getElementById('Provincia'));">
								<form:options items="${lcomboprovincias}" itemLabel="desParam" itemValue="codParam"/>							
							</form:select>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Distrito:</td>
						<td colspan="2" align="left">
							<form:select path="codUbigeo" id="Distrito" cssStyle="width:220px">
								<form:options items="${lcombodistritos}" itemLabel="desParam" itemValue="codParam"/>							
							</form:select>
						</td>
					</tr>
				
					<tr>
						<td align="left" style="padding-left:10px">(*) Estado Civil:</td>
						<td colspan="2" align="left">
							<form:select path="codEstcivil" id="personaEstadoCivil"  cssStyle="width:200px" onchange="perEstadoCivil()">
								<form:option value="00">SELECCIONE ESTADO CIVIL</form:option>
								<form:option value="01">SOLTERO</form:option>
								<form:option value="02">CASADO</form:option>
								<form:option value="03">DIVORCIADO</form:option>
							</form:select>
						</td>
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
										<td width="435px" colspan="2">
											<form:select path="codTdcon" id="personaTipoDocumentoCon" cssStyle="width:200px" onchange="notarios.cmbperTipoDocuCon()">
												<form:options items="${lsTipoDoc}" itemLabel="desParam" itemValue="codParam"/>
											</form:select>
										</td>
									</tr>
									<tr>
										<td>(*) N&uacute;mero de documento:</td>
										<td colspan="2">
											<form:input path="numDoccon" id="personaNumeroDocumentoCon" maxlength="8" cssStyle="font-size:13px; width:120px" onchange="notarios.cmbperNumeDocuCon()"/>
										</td>
									</tr>
									<tr>
										<td>(*) Apellido paterno conyuge:</td>
										<td colspan="2">
											<form:input path="apePatcon" id="personaApellidoPaternoCon" maxlength="100" cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Apellido materno conyuge:</td>
										<td colspan="2">
											<form:input path="apeMatcon" id="personaApellidoMaternoCon" maxlength="100" cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Nombres conyuge:</td>
										<td colspan="2">
											<form:input path="nomConyuge" id="personaNombresCon" maxlength="100"  cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
									<tr>
										<td>(*) Profesi&oacute;n conyuge:</td>
										<td colspan="2">
											<form:input path="desProfcon" id="personaProfesionCon" maxlength="100" cssStyle="font-size:13px; width:270px"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" style="padding-left:10px">(*) Tipo de aporte:</td>
						<td colspan="2" align="left">
							<c:if test="${persona.indAporte != 3}">
								<form:hidden path="indAporte" id="personaTipoAporte" />
								nombre tipo aporte
								<!-- si tipo de aporte es != de Ambos  muestro desciocion del tipo de aporte -->
							</c:if>
							<c:if test="${persona.indAporte == 3 }">
								<!-- sino muestro combo -->
								<form:select id="TipoAporte" path="indAporte" cssStyle="width:220px"
									onchange="cmbperTipoAporte()">
									<form:options items="${lsTipoAporte}" itemLabel="desParam" itemValue="codParam"/>
								</form:select>
							</c:if>
						</td>
					</tr>	
					<tr>
						<td colspan="3" align="left">
							<div id="divMontoAporte" style="display:<%=aporte %>">
								<table cellspacing ="0" width="100%">
									<tr>
										<td width="167px" style="padding-left:10px">Monto Aporte S/.:</td>
										<td width="433px">
											<!-- si en el combo escogo que aporta Dinerario o ambos muestro el campo monto -->
											<form:input path="montoAporte" id="personaMontoAporte" maxlength="18" cssStyle="font-size:13px; width:180px"/>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="left">
							
							<button  onclick="javascript:grabar();">Grabar</button>
							
							<!-- si es no dinerario o ambos, muestro este detalle de bienes -->
							<div id="toolbarAportes" style="border:1px solid #99BBE8; border-Bottom:0px; width:610px; display:<%=aporte2 %>;">
								<div class="dijitInline"style="color:#15428b; width:350px; padding-left:4px"><b>Lista de aporte de bienes</b></div>
								<button  onclick="notarios.adicionarAporte()">Adicionar</button>
								<button  onclick="notarios.editarAporte()">Editar</button>
								<button  onclick="notarios.eliminarAporte()">Eliminar</button>
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