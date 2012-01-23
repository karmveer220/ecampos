<jsp:useBean id="usuarioBean" scope="session" class="pe.org.notarios.framework.security.bean.UsuarioBean"/>
<%@page import="pe.org.notarios.sisev.constitucion.domain.Tramite"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>SISEV - Constituci&oacute;n de Empresas</title>
	<link rel="stylesheet" type="text/css" href="/a/js/dojo-1.3.1/dijit/themes/tundra/tundra.css"/>
	<link rel="stylesheet" type="text/css" href="/a/js/dojo-1.3.1/dojext/resources/css/ext-all.css"/>
	<link rel="stylesheet" type="text/css" href="/a/js/dojo-1.3.1/dojext/resources/css/dojext.css"/>
    <link rel="stylesheet" type="text/css" href="/a/js/dojo-1.3.1/cnl/resources/css/notarios.css"/>
</head>
<body class="tundra dojext">
<!-- <span dojoType="dojo.data.ItemFileWriteStore" jsId="storeOficinas" url="consultas.do?action=getOficinas" urlPreventCache="false"></span> -->
<!-- <span dojoType="dojo.data.ItemFileWriteStore" jsId="storeUbigeos" url="consultas.do?action=getUbigeos" urlPreventCache="false"></span> -->
<div id="loader">
	<table class="loader-border">
		<tr>
 			<td align="center">
				<table class="loader-msg">
					<tr><td><div class="loader-load"><div id="splashMessage">Inicializando...</div></div></td></tr>
				</table>
			</td>
		</tr>
	</table>
</div>

<div id="dialogAlert" dojoType="dojext.Dialog" innerBorder="none" title="Constituci&oacute;n de Empresas" duration="100" style="width:300px;visibility:hidden">
	<table cellspacing="10" width="100%">
		<tr>
			<td id="alertIcon">&nbsp;</td>
			<td id="alertMessage" >&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button dojoType="dijit.form.Button" onclick="dijit.byId('dialogAlert').hide()">Aceptar</button>
			</td>
		</tr>
	</table>
</div>

<div id="main" dojoType="dijit.layout.BorderContainer" gutters="false">
	<div id="header" dojoType="dijit.layout.ContentPane" region="top" splitter="false">
		<div class="powered">Powered By <b>CQ</b></div>
		<div class="api-title">Notar&iacute;a:&nbsp;<b><%=usuarioBean.getCodigoNotaria()%></b>&nbsp;-&nbsp;<b><%=usuarioBean.getNombreCompleto()%></b></div>
	</div>
	<div dojoType="dijit.layout.BorderContainer" liveSplitters="false" region="center" gutters="false">
		<div id="left" dojoType="dijit.layout.ContentPane" region="left" splitter="true" minSize="230" style="width: 280px;overflow:hidden">
			<div dojoType="dijit.layout.AccordionContainer">
				<div dojoType="dijit.layout.ContentPane" title="Lista de Estados">
					<ul class="bandejas" style="font-size:11px">
						<li>
							<img class="icon-by-category" src="/a/imagenes/s.gif"/>
							<a id="opcUno" href="#" url="consultas.do?action=showPorEstados&estado=<%=Tramite.ESTADO_ENTRANTE%>" onclick="notarios.filtro(this)">Bandeja de Entrada</a>
						</li>
						<li>
							<img class="icon-by-category" src="/a/imagenes/s.gif"/>
							<a id="opcDos" href="#" url="consultas.do?action=showPorEstados&estado=<%=Tramite.ESTADO_INCOMPLETO%>" onclick="notarios.filtro(this)">Incompletos</a>
						</li>
						<li>
							<img class="icon-by-category" src="/a/imagenes/s.gif"/>
							<a id="opcTres" href="#" url="consultas.do?action=showPorEstados&estado=<%=Tramite.ESTADO_PENDIENTE%>" onclick="notarios.filtro(this)">Pendientes de Firmado Digital</a>
						</li>
						<li>
							<img class="icon-by-category" src="/a/imagenes/s.gif"/>
							<a id="opcCuatro" href="#" url="consultas.do?action=showPorEstados&estado=<%=Tramite.ESTADO_FIRMADO%>" onclick="notarios.filtro(this)">Firmados Digitalmente</a>
						</li>
						<li>
							<img class="icon-by-category" src="/a/imagenes/s.gif"/>
							<a id="opcCinco" href="#" url="consultas.do?action=showPorEstados&estado=<%=Tramite.ESTADO_ENVIADO%>" onclick="notarios.filtro(this)">Enviados</a>
						</li>
						<li>
							<img class="icon-by-category" src="/a/imagenes/s.gif"/>
							<a id="opcSeis" href="#" url="consultas.do?action=showPorEstados&estado=<%=Tramite.ESTADO_SHOW_ELIMINADO%>" onclick="notarios.filtro(this)">Eliminados</a>
						</li>
					</ul>
				</div>
				<div dojoType="dijit.layout.ContentPane" title="Consulta de Tr&aacute;mite">
					<table cellspacing="5" width="100%" style="font-size:11px">
						<tr>
							<td width="110px">Estado:</td>
							<td>
								<select name="estado" dojoType="dijit.form.FilteringSelect" autocomplete="true" style="font-size:13px; width:150px">
									<option value="01" selected="selected">TODOS</option>
									<option value="03">INCOMPLETO</option>
									<option value="07">PENDIENTE DE ENVIO</option>
									<option value="08">ENVIADOS</option>
									<option value="08">ELIMINADOS</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>DNI:</td>
							<td><input name="serieComprobante" dojoType="dijit.form.TextBox" type="text" style="font-size:13px;width:100px" maxLength="8" regExp="\d{8}"></td>
						</tr>
						<tr>
							<td>CUO:</td>
							<td><input name="numeroComprobante" dojoType="dijit.form.TextBox" type="text" style="font-size:13px;width:100px" maxLength="15" regExp="\d{0,15}"></td>
						</tr>
						<tr>
							<td>Kardex:</td>
							<td><input name="numeroComprobante" dojoType="dijit.form.TextBox" type="text" style="font-size:13px;width:100px" maxLength="15" regExp="\d{0,15}"></td>
						</tr>
						<tr>
							<td width="70px">Fecha Inicial:</td>
							<td><input id="filtroMultiple.fechaInicial" name="fechaInicial" dojoType="dijit.form.DateTextBox" type="text" style="font-size:13px;width:100px" onChange="dijit.byId('filtroMultiple.fechaFinal').constraints.min = this.getValue();"></td>
						</tr>
						<tr>
							<td width="70px">Fecha Final:</td>
							<td><input id="filtroMultiple.fechaFinal" name="fechaFinal" dojoType="dijit.form.DateTextBox" type="text" style="font-size:13px;width:100px" onChange="dijit.byId('filtroMultiple.fechaInicial').constraints.max = this.getValue();"></td>
						</tr>
						<tr><td colspan="2">&nbsp;</td></tr>
						<tr>
							<td colspan="2" align="right"><button dojoType="dijit.form.Button" iconClass="icon-by-search" onclick="dijit.byId('workspace').setHref('Borrador.html')">Buscar</button></td>
						</tr>
						<tr><td colspan="2">&nbsp;</td></tr>
						<tr>
							<td colspan="2" align="center"><div id="filtroComprobante.mensaje" style="visibility:hidden"><img class="x-panel-inline-icon icon-warn-16" src="/a/imagenes/s.gif"/><b>No hay comprobantes para este filtro</b></div></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div id="workspace" dojoType="dijit.layout.ContentPane" region="center" style="overflow:hidden">
		</div>
	</div>
</div>
<script type="text/javascript" src="/a/js/dojo-1.3.1/dojo/dojo.js" djConfig="parseOnLoad: false, locale: 'es-pe', usePlainJson:true, isDebug: false"></script>
<script type="text/javascript" src="/a/js/dojo-1.3.1/cnl/constitucion/principal.js"></script>
</body>
</html>
