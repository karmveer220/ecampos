<jsp:include page="include/header.jsp" flush="true"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div dojoType="dijit.layout.BorderContainer" gutters="false" style="overflow:hidden">
	<div dojoType="dijit.layout.ContentPane" region="top"  class="x-panel-header" style="border-bottom: 0px; padding: 5px 8px">
	Tr&aacute;mite - Parte
	</div>
	<div dojoType="dijit.layout.ContentPane" region="center" splitter="false" style="background:white; border:1px solid #99BBE8">
		<div style="width:640px; padding:10px 10px 10px 10px;">
			<table width="100%" cellspacing="13">
				<tr>
					<td colspan="2" align="left" style="color:gray;border-bottom:1px solid #ccc"><b><span id="parteTitulo">Subir archivo de parte</span></b></td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="parteUpload" style="height:80px;display:	">
							<form id="parteUploadForm" name="uploadForm" method="POST" enctype="multipart/form-data">
								<table width="100%">
									<tr>
										<td width="150px">Seleccione un archivo:</td>
										<td><input id="parteArchivo" name="archivo" type="file" class="inputFile" size="50" style="font-size:13px; width:400px"/></td>
									</tr>
									<tr><td colspan="2" height="8px">&nbsp;</td></tr>
									<tr>
										<td>&nbsp;</td>
										<td><button dojoType="dijit.form.Button" iconClass="icon-by-upload" onclick="notarios.subirParte()">Subir archivo</button></td>
									</tr>
								</table>
							</form>
						</div>
						<div id="parteUploaded" style="height:80px;display:">
							<form id="parteUploadedForm" name="uploadedForm" method="POST">
								<input id="parteNumeroArchivo" type="hidden" name="numeroArchivo" value=""/>
								<table width="100%">
									<tr>
										<td width="150px">Archivo de parte:</td>
										<td colspan="2"><b><span id="parteArchivoUploaded">algo.rtf</span></b></td>
									</tr>
									<tr><td colspan="3" height="8px">&nbsp;</td></tr>
									<tr>
										<td>&nbsp;</td>
										<td width="120px"><button dojoType="dijit.form.Button" iconClass="icon-by-del" onclick="notarios.borrarParte()">Borrar archivo</button></td>
										<td><button dojoType="dijit.form.Button" iconClass="icon-by-view" onclick="notarios.contenidoParte()">Ver contenido</button></td>
									</tr>
								</table>
							</form>
						</div>
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td colspan="2">
						<form id="parteForm" name="parteForm" dojoType="dijit.form.Form">
							<input id="parteModifico" type="hidden" name="modifico" value="0"/>
							<table width="100%">
								<tr>
									<td colspan="2" align="left" style="color:gray;border-bottom:1px solid #ccc"><b>Derechos registrales</b></td>
								</tr>
								<tr><td colspan="2" height="8px">&nbsp;</td></tr>
								<tr>
									<td width="150px">(*) Derechos registrales S/.:</td>
									<td width="450px">
										<input id="parteDerechoRegistral" name="derechoRegistral"
											   maxlength="22" type="text"
											   style="font-size:13px; width:150px"
											   onchange="notarios.cambioParte()"/>
									</td>
								</tr>
								<tr><td colspan="2" height="8px">&nbsp;</td></tr>
								<tr>
									<td>(*) Forma de Pago:</td>
									<td>
										<input id="parteFPUno" name="formaPago"
											   dojoType="dijit.form.RadioButton"
											   checked="checked"
											   type="radio" value="T01">
										<label for="parteFPUno">Descuento de Saldo&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<input id="parteFPDos" name="formaPago"
											   dojoType="dijit.form.RadioButton"
											   type="radio" value="T02" disabled="true">
										<label for="parteFPDos">P.O.S.&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<input id="parteFPTres" name="formaPago"
											   dojoType="dijit.form.RadioButton"
											   type="radio" value="T03" disabled="true">
										<label for="parteFPTres">Tarjeta de Cr&eacute;dito&nbsp;&nbsp;&nbsp;&nbsp;</label>
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="bottom" splitter="false" style="overflow:hidden;height:50px;border:1px solid #99BBE8; border-top:0px">
		<table cellspacing="13" style="overflow:hidden;">
			<tr>
				<td width="100%">&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-back" onclick="notarios.seguirMandatarios()">Anterior</button></td>
				<td>&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-save" onclick="notarios.grabarDerechos()">Grabar</button></td>
				<td>&nbsp;</td>
				<td><button dojoType="dijit.form.Button" iconClass="icon-by-close" onclick="notarios.salirTramite()">Salir</button></td>
			</tr>
		</table>
	</div>
</div>
<div id="dialogParte" dojoType="dojext.Message" position="center" style="width:380px">
	<table width="100%" cellspacing="10">
		<tr>
			<td width="110px"><b>Subiendo Archivo</b></td>
			<td align="center">
				<div style="width:230px" indeterminate="true" dojoType="dijit.ProgressBar"></div>
			</td>
		</tr>
	</table>
</div>

<jsp:include page="include/footer.jsp" flush="true"/>