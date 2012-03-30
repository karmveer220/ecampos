<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
<head>

<!--  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test seguridad</title>

<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"> </link>
<link href="css/estilos.css" rel="stylesheet" type="text/css" /> </link>
<link href="css/cuadros.css" rel="stylesheet" type="text/css" /> </link>
  
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

</head>
<body>

	<div id="main-container">
    <div id="header" style="background-image: url('images/cabecera.jpg');">
        <a id="logo" href="#"><img src="images/logo_peru.jpg" alt="Ministerio del Interior" name="logo_img" width="201" height="47" border="0" id="logo_img"></a> 
        <ul id="topnav">
            <li><a href="home.htm" > <img class="link-img" alt="inicio" src="images/home.png">Home</a></li>
            <li><a href="http://www.mininter.gob.pe/ target="_blank""> <img class="link-img" alt="Portal" src="images/logo_min.png">Portal</a></li>
            <li><a href="http://correo.mininter.gob.pe" target="_blank" > <img class="link-img" alt="Correo" src="images/mail.png">Correo</a></li>
        </ul>
    </div>
	<div class="clearfix" id="tabs-container">
        <table cellpadding="0" cellspacing="0" width="100%">
            <tr>
                <td align="left"><span style="margin-left:10px" >Bienvenido: <c:out value="${usuario.nombreCompleto}"/>  </span></td>
                <td align="center"><span>Area: <c:out value="${usuario.siminUnidadorganica1.nunoDescripcion}"/> </span></td>
                <td align="right"><span style="margin-right:10px">IP: <c:out value="${usuario.ipPrivada}"/></span> </td>
            </tr>        
        </table>
        <span style="float:right; margin-right:20px;"> 
        <script language="javascript">
            document.write(nombres_dias[dia_semana] + ", " + dia_mes + " de " + nombres_meses[mes - 1] + " de " + anio)
        </script>
	</span>
	</div>
  <!-- #tabs-container -->
  <div class="clearfix" style="background: none repeat scroll 0% 0% #F7F7F7;" id="content">
    <div id="full-content">
      <div id="left-content">
      <div class="sider">
      <div  > <jsp:include page="menu.html" /></div>
      <br />
      
	  <h2><img border="0" class="link-img" alt="" src="images/Users_Chat.png">Avisos importantes</h2>
		  
	  <marquee direction=up onMouseOver="this.stop();" onMouseOut="this.start();">
		Avisos Importantes<br>
		Avisos Importantes<br>
	  <a href="doc/varios/LoncherasEscolares[1].pdf">Lonchera Escolar</a><br>
	  </marquee>
	
	 <div class=menucinas>
	 
	  <h2><img border="0" class="link-img" alt="" src="images/oficinass.png" height="30" width="30">Oficinas del Sector</h2>
	  
                        <DIV align="left">
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
                        NACIONAL</A></P></div></div></div>
	
	 </div>
		  
      </div>
      
      <div id="right-content">
        	<div class="emo verytop"> 
				<iframe  id="baner" name="baner" frameborder="0" width="600px" height="300px" src="eco.htm" >
			</div>
	  <div > 
		<left></iframe></left>
		</div>
		

		
	<div id="right-content">
	<div class="verytop">
        
          <div id="topPanel">
  			
  			<div id="headerPanelfast">
				<h2>Utilitarios</h2>
					<p>
					- Boleta de Pago</br>
					- Asistencia
					</p><a href="#"></a>
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

	</div> 
              
              <tr>
                <td> <a href="rptasistencia.htm" target="_blank"> <img border="0" class="link-img" alt="" src="images/reloj.GIF" width="25" height="25" /> </a> </td>
                <td>Record de asistencia </td>
              </tr>
              
              <tr>
                <td> <a href="rptcasboleta.htm" target="_blank"> <img border="0" class="link-img" alt="" src="images/icon_libro.png" width="25" height="25" /> </a> </td>
                <td>Boleta de pago</td>
              </tr>	
		
	  </div>
      <!-- #right-content --> 
    </div>
    <!-- #full-content --> 
    <br class="clear"/>
  </div>
  <!-- #content -->
  <div id="footer" >
    <p align="center"  id="copyright" >Direcci&oacute;n: Plaza 30 de Agosto s/n Urb. Corpac - San Isidro - Lima | AtenciÃ³n: 8:00 a 16:15 hrs.<br />
      Tel&eacute;fonos: Central 01 518-0000 - Prensa 980122710<br />
      <strong>Ministerio del Interior</strong></p>
    <div class="clear"></div>
  </div>
  <!-- #footer --> 
</div>


</body>
</html>