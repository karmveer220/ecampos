<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title>test seguridad</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

</head>

<body>
	<table width="900" height="180" border="0" align="center" cellpadding="3" cellspacing="0">
      <tr>
        <td colspan="3" align="center">
        	<div id="header" style="background-image: url('images/cabecera.jpg');">
                 
                <ul id="topnav">
                    <li><a href="home.htm" > <img class="link-img" alt="inicio" src="images/home.png">Home</a></li>
                    <li><a href="http://www.mininter.gob.pe/ target="_blank""> <img class="link-img" alt="Portal" src="images/logo_min.png">Portal</a></li>
                    <li><a href="http://correo.mininter.gob.pe" target="_blank" > <img class="link-img" alt="Correo" src="images/mail.png">Correo</a></li>
                </ul>
                <a id="logo" href="#"><img src="images/logo_peru.jpg" alt="Ministerio del Interior" name="logo_img" width="201" height="47" border="0" id="logo_img"></a>
            </div>
        </td>
      </tr>
      <tr>
        <td colspan="3" align="center">
        	<div class="clearfix" id="tabs-container">
                <table style="border: 0; padding: 0; width: 100%">
                    <tr>
                        <td align="left"><span style="margin-left:10px" >Bienvenido: <c:out value="${usuario.nombreCompleto}"/>  </span></td>
                        <td align="center"><span>Area: <c:out value="${usuario.siminUnidadorganica1.nunoDescripcion}"/> </span></td>
                        <td align="right"><span style="margin-right:10px">IP: <c:out value="${usuario.ipPrivada}"/></span> </td>
                    </tr>        
                </table>
            </div>
        </td>
      </tr>
      <tr>      	
        <td>		    
		    <div id="left-content" class="sider">		    
	      		<jsp:include page="menu.html" />
	   			<br />
	      
		  		<h2><img border="0" class="link-img" alt="" src="images/Users_Chat.png">Avisos importantes</h2>
			  
	  			<marquee direction=up onMouseOver="this.stop();" onMouseOut="this.start();">
					Avisos Importantes<br>
		  			<a href="doc/varios/LoncherasEscolares[1].pdf">Lonchera Escolar</a><br>
		  		</marquee>
				
		 		<div class=menucinas>
		 			<h2><img border="0" class="link-img" alt="" src="images/oficinass.png" height="30" width="30">Oficinas del Sector</h2>
					<div align="left" class="botonfi">
					<div>
						<p class=botonfi><a style="COLOR:#333333; TEXT-DECORATION: none" href="http://www.mininter.gob.pe/defensoria/" target=_blank><img class=buttonimg border=0 alt="" src="images/defensoria.png"width=15 height=15> DEFENSORIA DE LA PNP</a></p>
					</div>
					<div>
						<p class=botonfi><a style="COLOR: #333333; TEXT-DECORATION: none" href="http://www.mininter.gob.pe/cnddhh/" target=_blank><img border=0 alt="" src="images/dh.png" width=15 height=15> DERECHOS HUMANOS</a></p>
					</div>
					<div>
						<p class=botonfi><a style="COLOR: #333333; TEXT-DECORATION: none" href="http://dggi.mininter.gob.pe/" target=_blank><img border=0 src="images/dggi.png" width=15 height=15>GOBIERNO INTERIOR</a></p>
					</div>
					<div>
					 	<p class=botonfi><a style="COLOR: #333333; TEXT-DECORATION: none" href="http://www.dicscamec.gob.pe/" target=_blank><img border=0 src="images/dicscamec.png" width=15 height=15>DICSCAMEC</a></p>
				 	</div>
					<div>
						<p class=botonfi><a style="COLOR: #333333; TEXT-DECORATION: none" href="http://www.digemin.gob.pe/" target=_blank><img border=0 src="images/digemin.png" width=15 height=15>MIGRACIONES</a></p>
					</div>
					<div>
						<p class=botonfi><a style="COLOR: #333333; TEXT-DECORATION: none" href="http://www.mininter.gob.pe/ofecod/" target=_blank><img border=0 src="images/ofecod.png" width=15 height=15>OFECOD</a></P>
					</div>
					<div>
						<p class=botonfi><a style="COLOR: #333333; TEXT-DECORATION: none" href="http://www.pnp.gob.pe/" target=_blank><img border=0 src="images/pnp.png" width=15 height=15> POLICIA NACIONAL</a></p></div>
					</div>
		        </div>	
    		</div>
        </td>  
        <td colspan="2" valign="top" class="emo verytop">
        	<table>	
        		<tr>
        			<td><iframe  id="baner" name="baner" frameborder="0" width="600px" height="300px" src="eco.htm" ></iframe></td>			
        		</tr>
        		<tr>
        			<td>&nbsp;</td>			
        		</tr>
        		<tr>
        			<td>
        				<div id="topPanel">
			  			<div id="headerPanelfast">
							<h2>Utilitarios</h2>
								<p>
									Boleta de Pago
									Asitencia
								</p><a href="rptasistencia.htm" target="_blank"></a>
						</div>
						<div id="headerPanelthird">
							<h2>Onomásticos</h2>
								<p>Relación de cumpleaños </br>
					 			del Ministerio del Interior </p><a href="cumple.htm" target="baner"></a>
						</div>
					    <div id="headerPanelsecond">
			        		<h2>Sistemas</h2>
								<p>Sistemas Informáticos  </br>
								del Ministerio del Interior</p><a href="sistemas.htm" target="baner" > </a>
					   </div>
					    <div id="headerPanelfour" >
							<h2 >Menu</h2>
								<p>Semana del 26 al </br>
								31 de Marzo</p><a href="http://www.mininter.gob.pe/comunicados/menu.pdf" target="_blank"></a>
						</div>
						<div id="headerPanelfive">
							<h2>Soporte</h2>
								<p>Soporte Técnico </p><a href="soporte.htm" target="baner" ></a>
						</div>
					    <div id="headerPanelsix">
			        		<h2>Campañas</h2>
							<p>Campañas Actuales</p><a href="campanas.htm" target="baner" > </a>
						</div>
						</div>
        			</td>			
        		</tr>
        	</table>
        </td>    
      </tr>
      <tr>
        <td colspan="3">
      		<div id="footer" >
				<p align="center"  id="copyright" >Direcci&oacute;n: Plaza 30 de Agosto s/n Urb. Corpac - San Isidro - Lima | AtenciÃ³n: 8:00 a 16:15 hrs.<br />
			      Tel&eacute;fonos: Central 01 518-0000 - Prensa 980122710<br />
			      <strong>Ministerio del Interior</strong></p>
			    <div class="clear"></div>
		  	</div>  
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>

</body>
</html>