<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<table >
	<tr>
		<td width="180px">
			<div id="left-content" align="center">
				<div class="sider" style="color: #FFFFFF">
					<div class="menu_list" id="secondpane">
						<p class="menu_head">Informaci&oacute;n Institucional</p>
						<div class="menu_body">
							<a href="vision.htm" target="_top">Visi&oacute;n/Misi&oacute;n</a> <a href="marcoLegal.htm" target="_top">Marco Legal</a>
						</div>
						
						<p class="menu_head">Documentos de Gesti&oacute;n</p>
						<div class="menu_body">
							<a href="cap.htm" target="_top">CAP</a> 
							<a href="mof.htm" target="_top">MOF</a> 
							<a href="rof.htm" target="_top">ROF</a> 
							<a href="tupa.htm" target="_top">TUPA</a> 
							<a href="directivas.htm" target="_top">DIRECTIVAS</a> 
							<a href="directivasEco.htm" target="_top">DIRECTIVAS DE ECOEFICIENCIA</a> 
							<a href="organigrama.htm" target="_top">ORGANIGRAMA</a>
							<a href="procedimientos.htm" target="_top">MAPRO</a>
						</div>
					
						<p class="menu_head">Directorio Telef&oacute;nico</p>
						<div class="menu_body">
							<a href="directorioTelf.htm" target="_top">Telefonos Fijos/Anexos</a>
						</div>
					
						<p class="menu_head">Boletines</p>
						<div class="menu_body">
							<a href="boletines.htm" target="_top">Boletin Informativo</a>
							<a href="eco.htm" target="_top">Ecoeficiencia</a>
						</div>
					
						<p class="menu_head">Galer&iacute;a de fotos</p>
						<div class="menu_body">
							<a href="galeria.htm" target="_top">Fotos Mininter</a>
							<a href="listarVideo.htm" target="_top">Videos Mininter</a>
						</div>
							
						<security:authorize ifAnyGranted="ROLE_SYSTEM">
						<p class="menu_head">Opciones Avanzadas</p>
						<div class="menu_body">
							<a href="adjuntarArchivos.htm" target="_top">Administrar Archivos</a>
							<a href="listarCorreo.htm" target="_top">Administrar Correos</a>
						</div>	
						</security:authorize>
					</div>
				</div>
				<h2>Avisos de Interés</h2>
				<div class="avisos">
					<jsp:include page="banner.jsp" />
				</div>
				<div>
					<table style="height: 330px; color: #EAEAEA" >
					</table>
				</div>
			</div>
		</td>
	</tr>
</table>

