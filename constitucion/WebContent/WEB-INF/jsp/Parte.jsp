<%@page import="pe.gob.pcm.constitucion.web.model.T029archivo"%>
<%@page import="pe.gob.pcm.constitucion.web.model.T020tramite"%>
<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
	T020tramite tram = (T020tramite)session.getAttribute("tramitesistema"); 
	T029archivo arch = (T029archivo)request.getAttribute("archivoTramite");
	System.out.println(arch);
%>
<script>


	function subirParte(){
		document.forms[0].action='${pageContext.request.contextPath}/constitucion/subirParte.htm';
		document.forms[0].submit();
	}

	function borrarParte(){
		document.forms[1].action='${pageContext.request.contextPath}/constitucion/borrarParte.htm';
		document.forms[1].submit();
	}

	function contenidoParte(){
		document.forms[1].action='${pageContext.request.contextPath}/constitucion/verParte.htm';
		document.forms[1].submit();
	}

	function grabarDerechos(){
		document.forms[2].action='${pageContext.request.contextPath}/constitucion/grabarDerechos.htm';
		document.forms[2].submit();
	}

	function seguirMandatarios(){
		document.forms[2].action='${pageContext.request.contextPath}/constitucion/regresaPasoTres.htm';
		document.forms[2].submit();
	}
	
</script>
	
<div  style="overflow:hidden">
	<div class="x-panel-header" style="border-bottom: 0px; padding: 5px 8px">
	Tr&aacute;mite - Parte
	</div>
	<div  style="background:white; border:1px solid #99BBE8">
		<div style="width:640px; padding:10px 10px 10px 10px;">
			<table width="100%" cellspacing="13">
				<tr>
					<td colspan="2" align="left" style="color:gray;border-bottom:1px solid #ccc"><b><span id="parteTitulo">Subir archivo de parte</span></b></td>
				</tr>
				<tr>
					<td colspan="2">
						
						<% if( arch==null ){ %>
						
						<div id="parteUpload" style="height:80px;">
							<form id="parteUploadForm" name="UploadForm" method="POST" action="" enctype="multipart/form-data">
								
								<table width="100%">
									<tr>
										<td width="150px">Seleccione un archivo:</td>
										<td><input id="parteArchivo" name="archivo" type="file" class="inputFile" size="50" style="font-size:13px; width:400px"/></td>
									</tr>									
									<tr>
										<td>&nbsp;</td>
										<td><input type="button" value="Subir Archivo" onclick="javascript:subirParte();"/></td>
									</tr>
								</table>
							</form>
						</div>
						<% } else { %>
						
						<div id="parteUploaded" style="height:80px;">							
							
							<form id="parteUploadedForm" name="uploadedForm" method="POST">
								<input id="parteNumeroArchivo" type="hidden" name="numeroArchivo" value=""/>
								<input id="idTramite" type="hidden" name="idTramite" value="<%=tram.getNumTramite() %>"/>
								
								<table width="100%">
									<tr>
										<td width="150px">Archivo de parte:</td>
										<td colspan="2"><b><span id="parteArchivoUploaded"><%=arch.getNomArchivo() %></span></b></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td width="120px"><input type="button" onClick="borrarParte()" value="Borrar Archivo"></td>
										<td><input type="button" onClick="contenidoParte()" value="Ver Contendo"></td>
									</tr>
								</table>
							</form>
							
						</div>
						
						<% } %>
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td colspan="2">
						<form id="parteForm" name="parteForm" method="post">
							<input id="parteModifico" type="hidden" name="modifico" value="0"/>
							<table width="100%">
								<tr>
									<td colspan="2" align="left" style="color:gray;border-bottom:1px solid #ccc"><b>Derechos registrales</b></td>
								</tr>
								<tr><td colspan="2" height="8px">&nbsp;</td></tr>
								<tr>
									<td width="150px">(*) Derechos registrales S/.:</td>
									<td width="450px">
										<input id="parteDerechoRegistral" name="derechoRegistral" maxlength="22" type="text" style="font-size:13px; width:150px" onchange="notarios.cambioParte()"/>
									</td>
								</tr>
								<tr><td colspan="2" height="8px">&nbsp;</td></tr>
								<tr>
									<td>(*) Forma de Pago:</td>
									<td>
										<label><input name="formaPago" checked="checked" type="radio" value="T01">Descuento de Saldo&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<label><input name="formaPago" type="radio" value="T02" disabled="disabled"">P.O.S.&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<label><input name="formaPago"  type="radio" value="T03" disabled="disabled">Tarjeta de Cr&eacute;dito&nbsp;&nbsp;&nbsp;&nbsp;</label>
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div style="overflow:hidden;height:50px;border:1px solid #99BBE8; border-top:0px">
		<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><input type="button" onClick="javascript:seguirMandatarios();" value="Anterior"></td>
				<td>&nbsp;</td>
				<td><input type="button" onClick="javascript:grabarDerechos();" value="Grabar"></td>
				<td>&nbsp;</td>
				<td><input type="button" onClick="javascript:salirTramite();" value="Salir"></td>
			</tr>
		</table>
	</div>
</div>

<jsp:include page="include/footer.jsp" flush="true"/>