<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head >
<title>Intranet del Ministerio del Interior</title>
<%@ include file="../jsp/taglibs.jsp"%>
</head>

<body>	
	<table width="900" border="0"  cellpadding="0" align="center">
	  	<tr>
	    	<td height="115" colspan="2" valign="top"> <jsp:include page="cabecera.jsp"/> </td>
	 	</tr>
	  	<tr>
		    <td width="200" valign="top"> <jsp:include page="menuHome.jsp"/> </td>
		    <td width="700" valign="top" bgcolor="#EAEAEA">
		    	<table width="600" border="0" cellspacing="0" cellpadding="0" >
		      	<tr>
		        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" /></td>
		        </tr>
		      	<tr align="center">
		        	<td height="200" colspan="5" valign="top"><img src="images/tres.png" width="700" height="200" /></td>
		        </tr>
		      	<tr>
		        	<td height="2" colspan="5"><img src="images/blank.jpg" width="2" height="5" /></td>
		        </tr>
		      	<tr>
			        <td width="210"><div><img src="images/boton_util.png" width="230" height="25" /></div></td>			        
			        <td>&nbsp;</td>		
			        <td width="210"> <div> <img src="images/boton_sistemas.png" width="230" height="25" /></div></td>
				    <td>&nbsp;</td>		
			        <td width="210"><div><img src="images/boton_cumple.png" width="230" height="25" /></div></td>
		      	</tr>
		      	<tr>
		        	<td height="150" valign="top" bgcolor="#EAEAEA">	
		        		<br/>
		        		<table width="100%">
		        			<tr>
		        				<td valign="top">
		        					<a href="asistencia.htm"><img src="images/reloj.GIF" width="16" height="16" />Asistencia</a>
		       					</td>
		       					<td align="right">&nbsp;</td>
		       				</tr>
		        			<tr>
		        				<td>
		        					<a href="boleta.htm"><img src="images/icon_libro.png" width="16" height="16" />Boleta de pago</a>
		        				</td>
		        				<td align="right">&nbsp;</td>
		        			</tr>
		        		</table>	        		
		           	</td>
		           	<td>&nbsp;</td>
		        	<td valign="top" bgcolor="#EAEAEA" align="left">
		        		<br/>
						<c:forEach items="${lstSistemas}" var="sis">
							<a href="http://srvprueba:8080/${sis.siminSistema.nsisAbreviatura}/${sis.siminSistema.nsisMetodo}=${usuario.nmstLogin}&var=1" target="_blank"> <c:out value="${sis.siminSistema.nsisDescripcion}"/></a><br/><br/>
					    </c:forEach>
			    		<security:authorize ifAnyGranted="ROLE_ADMINISTRADOR">
							<a href="http://sistgeo.mininter.gob.pe:8181" target="_blank">Sistema Georeferencial</a>
						</security:authorize>
							    						    		
				    </td>
				    <td>&nbsp;</td>
		       	 	<td valign="top" bgcolor="#EAEAEA">
		       	 		<br/>
		       	 		<table border="0">
		       	 			<tr valign="top">
		       	 				<td colspan="2" height="105px" width="450px">
		       	 					<table border="0"  >
		       	 					<c:forEach items="${lcumpleanios}" var="sis">
		       	 							<tr valign="top">
		       	 								<td><c:out value="${sis.nombreCompleto}"/></td>
		       	 								<td align="right"><c:out value="${sis.siminUnidadorganica1.nunoAbreviatura}"/></td>
		       	 							</tr>
							    	</c:forEach>
							    	
							    	</table>
		       	 				</td><c:if test="${empty lcumpleanios}" > No registra cumplea&ntilde;os el d&iacute;a de hoy </c:if>
		       	 			</tr>
		       	 			<tr>
		       	 				<td align="left" colspan="2">
		       	 					<div align="right"><a href="cumplemensual.htm">Ver mas..</a></div>		
	       	 					</td>
		       	 			</tr>
		       	 		</table>
				    </td>
		        </tr>
		      	<tr>
			        <td valign="top" colspan="5">&nbsp;</td>
		      	</tr>
		      	<tr>
			        <td valign="top"><div><img src="images/boton_menu.png" width="230" height="25" /></div></td>
			        <td>&nbsp;</td>		        
			        <td valign="top"><div><img src="images/boton_soporte.png" width="230" height="25" /></div></td>
			        <td>&nbsp;</td>		        
			        <td valign="top"><div><img src="images/boton_campana.png" width="230" height="25" /></div></td>
		        </tr>
		      	<tr>
					<td valign="middle" align="center" bgcolor="#EAEAEA"><br/>
						<a href="menu.htm"> <img alt="Menú Semanal" src="images/pizarra.png" width="200" height="70" /></a>
					</td>
					<td>&nbsp;</td>
					<td height="150" valign="top" width="100%" bgcolor="#EAEAEA">
			        	<br/>
			        	<table width="100%">
			        			<tr>
									<td>Nelly Chang</td>
									<td align="right">#422721</td>
								</tr>
								<tr>
									<td>Carlos Valenzuela</td>
									<td align="right">#422747</td>
								</tr>
								<tr>
									<td>Jimmy Jorge</td>
									<td align="right">#422824</td>
								</tr>
								<tr>
									<td>Carlos Canepa</td>
									<td align="right">#422819</td>
								</tr>
								<tr>
									<td>Pedro Ramos</td>
									<td align="right">#422929</td>
								</tr>
								<tr>
									<td>Freddy Caballero</td>
									<td align="right">#422910</td>
								</tr>
			        		<tr>
								<td colspan="2" align="center">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									Horario de Atenci&oacute;n:8:30 - 21:00 horas
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><br/>
					 				<a href="correo.htm"><strong>Enviar requerimiento al &aacute;rea de Soporte T&eacute;cnico</strong></a>&nbsp;					 				
								</td>
							</tr>							
		        		</table><br/>
					</td>
					<td>&nbsp;</td>
			        <td valign="top" bgcolor="#EAEAEA"><br/>
			        	<div align="center">
							<a href="campanas.htm"> <img alt="Campañas" src="images/campanas.png" width="160" height="150" /></a>
						</div>
			        </td>
		        </tr>
		    	</table>
	    	</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2" class="pie">  <jsp:include page="copyright.jsp"/> </td>
	  	</tr>
	</table>	
</body>
</html>