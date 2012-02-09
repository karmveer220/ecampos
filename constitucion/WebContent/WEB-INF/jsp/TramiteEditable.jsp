<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="pe.gob.pcm.constitucion.web.model.T001parametro"%>
<%@page import="pe.gob.pcm.constitucion.web.bean.Parametro"%>
<%@page import="java.util.List"%>
<%
	String error = "";
	error = request.getAttribute("msgError")!=null ? (String)request.getAttribute("msgError") : "";
	String mensaje = "";
	mensaje = request.getAttribute("mensaje")!=null ? (String)request.getAttribute("mensaje") : "";
%> 

<script>

	function grabarTramite(){
		if(document.getElementById('modifico')!=0 ){
			document.forms[0].action = 'grabarTramite.htm';
			document.forms[0].submit();
		}else{
			alert('No se han encontrado cambios');
		}
	}

	function seguirAccionistas(){
		if(document.getElementById('modifico').value !=0 ){
			alert('debe grabar los cambios. var = ' +  document.getElementById('modifico') );
		}else{
			document.forms[0].submit();	
		}
	}
	
</script>
 <div id="cuerpo">
    <table width="100%">
        <tr>
            <td height="233">
				<div align="center" style="color: red"> <%=error %> </div>
				<div align="center" style="color: blue"> <%=mensaje %> </div>
		
		
	<form:form name="tramiteForm" action="tramitePasoDos.htm" method="post" modelAttribute="tramite">
		<h2>
		<c:if test="${tramitesistema.numTramite eq null }">Nuevo Tramite</c:if>
		<c:if test="${tramitesistema.numTramite ne null }">Editando Tramite Kardex <c:out value="${tramitesistema.clvKardex}"/></c:if>		
		</h2>	
			<input id="modifico" type="hidden" name="modifico" value="0"/>
			
			<form:hidden path="numTramite"/>
			<div style="width:700px; padding:10px 10px 10px 10px;">
				<table width="100%" cellspacing="10">
					<tr>
						<td width="212px">(<b>+</b>) <b>Tipo de Sociedad</b>:</td>
						<td width="200px" colspan="3">
							<form:select id="tramiteTipoSociedad" path="codTipsoc" onchange="notarios.cmbtraTipoSociedad()">
								<option value="00" selected="selected">SELECCIONE UN TIPO DE SOCIEDAD</option>
								<%	List<T001parametro> lsTipoSociedad = (List<T001parametro>)request.getAttribute("lsTipoSociedad");
									for(T001parametro p : lsTipoSociedad) {%>
								<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
								<%	}%>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>(<b>+</b>) <b>Zona</b>:</td>
						<td colspan="3">
						<form:select path="codZonreg" id="tramiteZonaRegistral" onchange="javascript:comboOficinaRegistral(document.getElementById('tramiteZonaRegistral'));">
								<option value="00" selected="selected">SELECCIONE LA ZONA REGISTRAL</option>
								<%	List<T001parametro> lsZonaRegistral = (List<T001parametro>)request.getAttribute("lsZonaRegistral");
									for(T001parametro p : lsZonaRegistral) {%>
								<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
								<%	}%>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>(<b>+</b>) <b>Oficina Registral</b>:</td>
						<td colspan="3">
							<form:select path="codOficreg" id="tramiteOficinaRegistral" cssStyle="width:370px" onchange="cambioTramite();">
							</form:select>
						</td>
					</tr>
					<tr>
						<td>(<b>+</b>) <b>Kardex</b>:</td>
						<td colspan="3">
							<form:input path="clvKardex" id="tramiteKardex" maxlength="20" cssStyle="font-size:13px; width:150px" onchange="notarios.cambioTramite()"/>
						</td>
					</tr>
					<tr>
						<td>(*) DNI Solicitante:</td>
						<td colspan="3">
							<form:input path="numDocsol" id="tramiteDniSolicitante" maxlength="8" cssStyle="font-size:13px; width:100px" onchange="notarios.cambioTramite()"/>
						</td>
					</tr>
					<tr>
						<td>(*) N&uacute;mero de T&iacute;tulo de Reserva Nombre:</td>
						<td colspan="3">
						<form:input path="numTitulo" id="tramiteNumeroTitulo" maxlength="20" cssStyle="font-size:13px; width:170px" onchange="notarios.cambioTramite()"/></td>
					</tr>
					<tr>
						<td>(*) Denominaci&oacute;n o Raz&oacute;n Social:</td>
						<td colspan="3">
							<form:input path="nomRazsoc" id="tramiteRazonSocial" maxlength="200" cssStyle="font-size:13px; width:250px" onchange="notarios.cambioTramite()"/>
						</td>
					</tr>
					<tr>
						<td>Denominaci&oacute;n abreviada:</td>
						<td colspan="3">
							<form:input path="nomDenabrev" id="tramiteDenominacionAbreviada" maxlength="100" cssStyle="font-size:13px; width:170px" onchange="notarios.cambioTramite()"/>
						</td>
					</tr>
					<tr>
						<td>(*) Departamento:</td>
						<td colspan="3">
							<select id="tramiteDepartamento" name="departamento" style="width:220px" 
									onChange="javascript:comboDepartamento(document.getElementById('tramiteDepartamento'));">
								<%	List<T001parametro> lsdepas= (List<T001parametro>)request.getAttribute("lsDepartamentos");
									for(T001parametro p : lsdepas) {%>
								<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
								<%	}%>
							</select>
						</td>
					</tr>
					<tr>
						<td>(*) Provincia:</td>
						<td colspan="3">
							<form:select path="codUbigeo" id="tramiteProvincia" cssStyle="width:220px">							
							</form:select>
						</td>
					</tr>
					<tr>
						<td valign="top">(*) Objeto Social:</td>
						<td colspan="3">
							<form:textarea path="objetoSocial" id="tramiteObjetoSocial" cssStyle="width:370px;font-size:13px;height:60px" onchange="notarios.cambioTramite()"/>
						</td>
					</tr>
					<tr>
						<td>(<b>+</b>) <b>Aporte</b>:</td>
						<td colspan="3">
							<input id="tramiteTipoAporteEx" type="hidden" name="tipoAporteEx" value=""/>
							<select id="tramiteTipoAporte" name="tipoAporte"
									 style="width:220px"
									onChange="notarios.cmbtraTipoAporte()">
								<option value="0" selected="selected">SELECCIONE TIPO APORTE</option>
							<%	List<T001parametro> lsTipoAporte = (List<T001parametro>)request.getAttribute("lsTipoAporte");
								for(T001parametro p : lsTipoAporte) {%>
								<option value="<%=p.getCodParam()%>"><%=p.getDesParam()%></option>
							<%	}%>
							</select>
						</td>
					</tr>
					<tr>
						<td>(<b>+</b>) <b>Monto S/.</b>:</td>
						<td colspan="3">
							<form:input path="mtoAporte" id="tramiteMontoAporte"  maxlength="18" cssStyle="font-size:13px; width:150px" onchange="notarios.cmbtraValorAccion()"/>
						</td>
					</tr>
					<tr>
						<td>(<b>+</b>) <b>Valor de accion/participaci&oacute;n S/.</b>:</td>
						<td colspan="3">
							<form:input path="mtoValoraccion" id="tramiteValorAccion" maxlength="18" cssStyle="font-size:13px; width:150px" onchange="notarios.cmbtraValorAccion()"/>
						</td>
					</tr>
					<tr>
						<td>Acciones / Participaciones:</td>
						<td colspan="3">
							 (monto / valor de accion) 150 
						</td>
					</tr>
					<tr>
						<td>(*) Cancelaci&oacute;n de capital:</td>
						<td colspan="3">
							<label>
								<form:radiobutton path="indCancecapi" id="t1CancelacionCapital" value="T01" onchange="notarios.cmbtraCancelCapital()"/>
							</label>
							<label>
								<form:radiobutton path="indCancecapi" id="t2CancelacionCapital" value="T02"/>
							</label>
							
						</td>
					</tr>
					<tr>
						<td>(*) % Cancelado:</td>
						<td colspan="3">
							<table cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="3">
										<form:input path="numPorcencanc" id="tramitePorcentajeCancelado" cssStyle="font-size:13px;width:82px;" onchange="notarios.cambioTramite()"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="border-bottom: 1px solid #ccc">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">(<b>+</b>) <b><i>Obligatorio</i></b></td>
					</tr>
					<tr>
						<td colspan="4">(*) <i>Requerido</i></td>
					</tr>
				</table>
			</div>
			
			<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button onclick="grabarTramite()">Grabar</button></td>
				<td>&nbsp;</td>
				<td><button onclick="seguirAccionistas()">Siguiente</button></td>
				<td>&nbsp;</td>
				<td><button onclick="salirTramite()">Salir</button></td>
			</tr>
		</table>
		
		</form:form>
			
			
				
			</td>
        </tr>
    </table>						
</div>
<jsp:include page="include/footer.jsp" flush="true"/>