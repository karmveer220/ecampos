<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">



<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test seguridad</title>

<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"> </link>
<link href="css/estilos.css" rel="stylesheet" type="text/css" /> </link>

<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

</head>
<body>

	<div id="main-container">
  <div id="header" style="background-image: url('images/cabecera.jpg');">
    <ul id="topnav">
    
<li><a href="home.htm" > <img class="link-img" alt="inicio" src="images/home.png">Home</a></li>
      
<li><a href="http://www.mininter.gob.pe/ target="_blank""> <img class="link-img" alt="Portal" src="images/logo_min.png">Portal</a></li>
      
 <li><a href="http://correo.mininter.gob.pe" target="_blank" > <img class="link-img" alt="Correo" src="images/mail.png">Correo</a></li>
    </ul>
    
    
    <a id="logo" href="#"><img src="images/logo_peru.jpg" alt="Ministerio del Interior" name="logo_img" width="201" height="47" border="0" id="logo_img"></a> </div>
  <!-- #header -->
  <div class="clearfix" id="tabs-container">
   <span style="margin-left:20px;">IP:172.16.10.1</span> 
   <span style="margin-left:60px">Gerencia: Sistemas de la informaci&oacute;n</span>
   <span style="margin-left:60px">Usuario:  ${pageContext.request.userPrincipal.name}</span> 
   <span style="float:right; margin-right:20px;"> <script language="javascript">
document.write(nombres_dias[dia_semana] + ", " + dia_mes + " de " + nombres_meses[mes - 1] + " de " + anio)
</script>
   </span>
   
   
   
   
   </div>
  <!-- #tabs-container -->
  <div class="clearfix" style="background: none repeat scroll 0% 0% #F7F7F7;" id="content">
    <div id="full-content">
      <div id="left-content">
        <div class="sider">
          <h2><img border="0" class="link-img" alt="" src="images/Favorite.png">Menu Principal</h2>
         
         <div  > <jsp:include page="menu.html" /></div>
         
         
         
         
          <br />
          <h2><img border="0" class="link-img" alt="" src="images/Users_Chat.png">Avisos importantes</h2>
		  
		  <marquee direction=up onMouseOver="this.stop();" onMouseOut="this.start();">
			Avisos Importantes<br>
			Avisos Importantes<br>
		  <a href="doc/varios/LoncherasEscolares[1].pdf">Lonchera Escolar</a><br>
		  </marquee>
		  
      <!--  <p style="padding:0; margin:0; margin-bottom:5px;">La Candelaria</p>   -->  
    
 <!--	<img style="border:1px solid #D3D3D3;" border="0" class="link-img" alt="Fiesta de la Virgen de la Candelaria" src="images/candelaria.jpg">  -->  
	
	 <DIV class=menucinas>
	 
	  <h2><img border="0" class="link-img" alt="" src="images/oficinass.png" height="30" width="30">Oficinas del Sector</h2>
	  
                        <DIV align=center>
                        <DIV>
                        <P class=botonfi>
						<A style="COLOR:#333333; TEXT-DECORATION: none" 
                        href="http://www.mininter.gob.pe/defensoria/" 
                        target=_blank><IMG class=buttonimg border=0 alt="" 
                        src="images/defensoria.png" 
                        width=15 height=15> DEFENSORIA DE LA PNP</A></P>
						</DIV>
                        <DIV>
                        <P class=botonfi><A 
                        style="COLOR: #333333; TEXT-DECORATION: none" 
                        href="http://www.mininter.gob.pe/cnddhh/" 
                        target=_blank><IMG border=0 alt="" 
                        src="images/dh.png" 
                        width=15 height=15> DERECHOS HUMANOS</A></P></DIV>
                        <DIV>
                        <P class=botonfi><A 
                        style="COLOR: #333333; TEXT-DECORATION: none" 
                        href="http://dggi.mininter.gob.pe/" target=_blank><IMG 
                        border=0 
                        src="images/dggi.png" 
                        width=15 height=15> GOBIERNO INTERIOR</A></P></DIV>
                        <DIV>
                        <P class=botonfi><A 
                        style="COLOR: #333333; TEXT-DECORATION: none" 
                        href="http://www.dicscamec.gob.pe/" target=_blank><IMG 
                        border=0 
                        src="images/dicscamec.png" 
                        width=15 height=15> DICSCAMEC</A></P></DIV>
                        <DIV>
                        <P class=botonfi><A 
                        style="COLOR: #333333; TEXT-DECORATION: none" 
                        href="http://www.digemin.gob.pe/" target=_blank><IMG 
                        border=0 
                        src="images/digemin.png" 
                        width=15 height=15> MIGRACIONES</A></P></DIV>
                        <DIV>
                        <P class=botonfi><A 
                        style="COLOR: #333333; TEXT-DECORATION: none" 
                        href="http://www.mininter.gob.pe/ofecod/" 
                        target=_blank><IMG border=0 
                        src="images/ofecod.png" 
                        width=15 height=15> OFECOD</A></P></DIV>
                        <DIV>
                        <P class=botonfi><A 
                        style="COLOR: #333333; TEXT-DECORATION: none" 
                        href="http://www.pnp.gob.pe/" target=_blank><IMG 
                        border=0 
                        src="images/pnp.png" 
                        width=15 height=15> POLICIA 
                        NACIONAL</A></P></DIV></DIV></DIV>
	
	
	 </div>
		  
      </div>
      <!-- #left-content -->
      <div id="right-content">
        <div class="emo verytop"> 
		
	<!--	<img src="images/BANER.swf" alt="Imágenes interesantes del Mininter" width="566" height="283" /> -->
	
	<object
			classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
			width="566" height="283">
			<param name="movie" value="images/BANER.swf" />
			<param name="quality" value="high" />
		</object>
		</div>
		
		
	    <div id="right-content">
        <div class="emo verytop">
		<table width="552" border="1" cellpadding="1">
          <tr>
            <td><table width="184" border="0" cellpadding="1">
              <tr>
                <td colspan="3"><div align="center"><img border="0" class="link-img" alt="" src="images/utilitarios.gif"><strong>Utilitarios</strong></div></td>
                </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td> <a href="rptasistencia.htm" target="_blank"> <img border="0" class="link-img" alt="" src="images/reloj.GIF" width="25" height="25" /> </a> </td>
                <td>Record de asistencia </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td> <a href="rptcasboleta.htm"> <img border="0" class="link-img" alt="" src="images/icon_libro.png" width="25" height="25" /> </a> </td>
                <td>Boleta de pago</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
            <td>
	            <div align="center"><strong>Sistemas</strong></div>
            	<ul>
				 <c:forEach items="${lstSistemas}" var="sis">
				 	<li>
				 		<a href="http://servermininter/${sis.siminSistema.nsisDescripcion}" target="_blank">
				 			<c:out value="${sis.siminSistema.nsisDescripcion}"/>
				 		</a>
				 	</li>				 	
				 </c:forEach>
				 </ul>
				 </td>
            <td>
            	<div align="center"><strong>Cumplea&ntilde;os del dia </strong></div>            
                <ul>
                <c:forEach items="${lcumpleanios}" var="sis">				 	
				 	<li><c:out value="${sis.nombreCompleto}"/> </li>
				 </c:forEach>
                </ul>            
            </td>
          </tr>
          <tr>
            <td><table width="184" border="0" cellpadding="1">
              <tr>
                <td colspan="3"><div align="center"><strong>Menu de la semana </strong></div></td>
                </tr>
              <tr>
                <td colspan="3" align="center">
				
				<a href="images/listamenu.jpg" target="_blank">
				  <img src="images/menusemana.JPG" width="150" height="165" /> </a>
				</td>
                </tr>
              
            </table></td>
            <td><table width="184" border="0" cellpadding="1">
              <tr>
                <td colspan="3"><div align="center"><strong><img border="0" class="link-img" alt="" width="25" height="25" src="images/soporte.png">Soporte tecnico </strong></div></td>
                </tr>
              <tr>
                <td>Carlos Canepa </td>
                <td>#422747</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>Carlos Valenzuela </td>
                <td>#422819</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>Jimmy Jorge </td>
                <td>#422824</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>Pedro Ramos </td>
                <td>#422929</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              
            </table></td>
            <td><table width="184" border="0" cellpadding="1">
              <tr>
                <td colspan="3"><div align="center"><strong>Campaña de salud </strong></div></td>
                </tr>
              <tr>
                <td colspan="3" align="center"><a href="http://www.minsa.gob.pe/portada/Especiales/2011/dengue/" target="_blank">
				  <img src="images/maricarmen_dengue.png" width="150" height="165" /> </a> </td>
                </tr>
              
            </table></td>
          </tr>
        </table>
		</div>
		
	    </div>
		
	  </div>
      <!-- #right-content --> 
    </div>
    <!-- #full-content --> 
    <br class="clear"/>
  </div>
  <!-- #content -->
  <div id="footer" >
    <p align="center"  id="copyright" >Dirección: Plaza 30 de Agosto s/n Urb. Corpac - San Isidro - Lima | Atención: 8:00 a 16:15 hrs.<br />
      Teléfonos: Central 01 518-0000 - Prensa 980122710<br />
      <strong>Ministerio del Interior</strong></p>
    <div class="clear"></div>
  </div>
  <!-- #footer --> 
</div>


</body>
</html>