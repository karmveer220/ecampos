<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

 <script language="javascript">
<!--
   nombres_dias = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")
   nombres_meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
   fecha_actual = new Date()
   dia_mes = fecha_actual.getDate()		//dia del mes
   strdia_mes = (dia_mes <= 9) ? "0" + dia_mes : dia_mes
   dia_semana = fecha_actual.getDay()		//dia de la semana
   mes = fecha_actual.getMonth() + 1
   strmes = (mes <= 9) ? "0" + mes : mes
   anio = fecha_actual.getYear()
   if (anio < 100) anio = "19" + anio			//pasa el año a 4 digitos
   else if ( ( anio > 100 ) && ( anio < 999 ) ) {	//efecto 2000
      var cadena_anio = new String(anio)
      anio = "20" + cadena_anio.substring(1,3)
   }
//-->
</script>




<title>Intranet | Mininter</title>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
<link href="estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main-container">
  <div id="header">
    <ul id="topnav">
      <li><a href="#">Inicio</a></li>
      <li><a href="http://www.mininter.gob.pe/ target="_blank""><img border="0" class="link-img" alt="" src="images/icons/Home.png">Portal</a></li>
      <li><a href="http://correo.mininter.gob.pe" target="_blank" ><img class="link-img" alt="correo" src="images/icons/Mail.png">Correo</a></li>
    </ul>
    <a id="logo" href="#"><img src="images/logo_peru.jpg" alt="Ministerio del Interior" name="logo_img" width="201" height="47" border="0" id="logo_img"></a> </div>
  <!-- #header -->
  <div class="clearfix" id="tabs-container">
   <span style="margin-left:20px;">IP:172.16.10.1</span> 
   <span style="margin-left:60px">Gerencia: Sistemas de la información</span>
   <span style="margin-left:60px">Usuario: Jullyzza Perez</span> 
   <span style="float:right; margin-right:20px;"> <script language="javascript">
document.write(nombres_dias[dia_semana] + ", " + dia_mes + " de " + nombres_meses[mes - 1] + " de " + anio)
</script></span> 
  
   
   </div>
  <!-- #tabs-container -->
  <div class="clearfix" style="background: none repeat scroll 0% 0% #F7F7F7;" id="content">
    <div id="full-content">
      <div id="left-content">
        <div class="sider">
          <h2><img border="0" class="link-img" alt="" src="images/icons/Favorite.png">Menú Principal</h2>
          <ul class="navlist">
            <li><a href="InfInstitucional.html">Información institucional</a></li>
            <li><a href="DocumentosGestion.html">Documentos de Gestión</a></li>
            <li><a href="DIRECTORIO2012-nokia.xlsx">Directorio telefónico</a></li>
            <li><a href="http://hercules:8080/sistemasintegrados/" target="_blank">Sistemas</a></li>
         <!--   <li><a href="#">Calidad</a></li> -->
            <li><a href="#">Eventos</a></li>
            <li><a href="#">Galeriá de fotos</a></li>
          </ul>
          <br />
          <h2><img border="0" class="link-img" alt="" src="images/icons/Users_Chat.png">Avisos importantes</h2>
		  
		  <marquee direction=up onMouseOver="this.stop();" onMouseOut="this.start();">
			Avisos Importantes<br>
			Avisos Importantes<br>
			Avisos Importantes<br>

		  <a href="#">Avisos Importantes</a><br></marquee>
		  
      <!--  <p style="padding:0; margin:0; margin-bottom:5px;">La Candelaria</p>   -->  
    
 <!--	<img style="border:1px solid #D3D3D3;" border="0" class="link-img" alt="Fiesta de la Virgen de la Candelaria" src="images/candelaria.jpg">  -->  
	
	 <div>
	   <h2><img border="0" class="link-img" alt="" src="images/icons/ie.png" width="25" height="25">Enlaces de Interes</h2>
	   

	   	 <li><a href="http://dggi.mininter.gob.pe" target="_blank">DGGI</a></li>
	    <li><a href="http://www.digemin.gob.pe" target="_blank"></a>DIGEMIN</li>
		<li><a href="http://www.dicscamec.gob.pe" target="_blank">DICSCAMEC</a></li>
		<li><a href="http://www.pnp.gob.pe" target="_blank"></a>PNP</li>
		<li><a href="http://www.sunat.gob.pe" target="_blank"></a>SUNAT</li>
		<li><a href="http://www.essalud.gob.pe" target="_blank"></a>ESSALUD</li>
		
		
	 </div>
	
	
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
        <table border="0" style="border:1px solid #D3D3D3">
          <tr>
            <td style="background-color:#EBEBEB">Directorio telefónico</td>
            <td style="background-color:#EBEBEB; border-left:1px solid #F7F7F7">Sistemas</td>
            <td style="background-color:#EBEBEB; border-left:1px solid #F7F7F7">Cumpleaños del día</td>
          </tr>
          <tr>
            <td width="33%"><table border="0">
                <tr>
                  <td>Dependencia</td>
                  <td>Anexo</td>
                </tr>
                <tr>
                  <td>OFITEL</td>
                  <td>2643</td>
                </tr>
                <tr>
                  <td>OFITEL-Informatica</td>
                  <td>2657</td>
                </tr>
                <tr>
                  <td>OFITEL-Redes</td>
                  <td>2247</td>
                </tr>
                <tr>
                  <td>OFITEL-Hardware</td>
                  <td>2646</td>
                </tr>
                <tr>
                  <td>OFITEL-Software</td>
                  <td>2657</td>
                </tr>
              </table></td>
            <td width="33%" style="border-left:1px solid #D3D3D3"><table border="0">
                <tr>
                  <td><a href="#">SIGE</a></td>
                </tr>
                <tr>
                  <td><a href="#">SIRRHH</a></td>
                </tr>
                <tr>
                  <td><a href="#">Sistema de Hardware</a></td>
                </tr>
                <tr>
                  <td><a href="#">Sistema de Rendicion de Fondos </a></td>
                </tr>
                <tr>
                  <td><a href="#">Sistema de Inversión Publica</a></td>
                </tr>
                
              </table></td>
            <td width="33%" style="border-left:1px solid #D3D3D3"><table border="0">
                <tr>
                  <td><img src="images/tortas.jpg" width="222" height="165" /></td>
                </tr>
              </table></td>
          </tr>
        </table>
      </div>
      <!-- #right-content --> 
    </div>
    <!-- #full-content --> 
    <br class="clear"/>
  </div>
  <!-- #content -->
  <div id="footer" >
    <p align="center" id="copyright" >Dirección: Plaza 30 de Agosto s/n Urb. Corpac - San Isidro - Lima | Atención: 8:00 a 16:15 hrs.<br />
      Teléfonos: Central 01 518-0000 - Prensa 980122710<br />
      <strong>Ministerio del Interior</strong></p>
    <div class="clear"></div>
  </div>
  <!-- #footer --> 
</div>
<!-- #main-container -->
</body>
</html>