<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html xmlns="http://www.w3.org/1999/xhtml">

<head>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link href="css/cuadros.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.5.1.min.js" type="text/javascript"></script>

</head>

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



<title>test seguridad</title>
</head>
<body>
<center>
<table width="900" height="800" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="115" colspan="2" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="10" colspan="4" align="right" valign="top" bgcolor="#666666">
		  		<ul id="topnav">
                    <li><a href="home.htm" > <img src="images/home.png" alt="inicio" width="20" height="20" class="link-img" />Home</a></li>
                    <li><a href="http://www.mininter.gob.pe/ target="_blank""><img src="images/logo_min.png" alt="Portal" width="20" height="20" class="link-img" />Portal</a></li>
                    <li><a href="http://correo.mininter.gob.pe" target="_blank" > <img src="images/mail.png" alt="Correo" width="20" height="20" class="link-img" />Correo</a></li>
                </ul>	</td>
        </tr>
        <tr>
          <td height="90"  colspan="4" align="left" valign="top"    >
		     <table width="900"  height="90" border="0" cellspacing="0" cellpadding="0">
               <tr>
                  <td width="245"><img src="images/min.jpg" width="245" height="90" /></td>
                <td width="490">
					<div class="tituintra1" >M I N I N T E R</div>
					<div class="tituintra2" >Ministerio del Interior</div>
					
				
				
				</td>
                <td width="165" align="right" valign="top"><img src="images/mintranet.jpg" width="165" height="83" /></td>
               </tr>
          </table></td>
        </tr>
        
        <tr valign="top" class="datuser">
          <td width="260"  height="25"        >
		  
		  Bienvenido:<br> 
            <c:out value="${usuario.nombreCompleto}"/></td>
          <td width="410" height="25">Area:<br> 
            <c:out value="${usuario.siminUnidadorganica1.nunoDescripcion}"/></td>
          <td width="100" height="25">IP:<br> 
            <c:out value="${usuario.ipPrivada}"/></td>
          <td width="140" height="25">Fecha:<br>  
            <script language="javascript">
document.write(nombres_dias[dia_semana] + ", " + dia_mes + " de " + nombres_meses[mes - 1] + " de " + anio)
</script></td>
        </tr>
      </table></td>
  </tr>
  <tr>
  
    <td width="200" valign="top" >
     <div id="left-content" >
	   <div class="sider" >
	   <jsp:include page="menu.html" />
	   </div>
	   
	   <div class="avisos">
		<jsp:include page="banner.html" />
		</div>
		
		<div class="menucinas">
		 			<h2><img border="0" class="link-img" alt="" src="images/oficinass.png" height="30" width="30" />Oficinas del Sector</h2>
						<div align="left" class="botonfi">
						
							<div>
								<p >
									<a style="COLOR:#333333; TEXT-DECORATION: none" 
									href="http://www.mininter.gob.pe/defensoria/" 
									target="_blank"><img class="buttonimg" border="0" alt="" 
									src="images/defensoria.png"width="15" height="15" /> DEFENSORIA DE LA PNP</a>
								</p>
							</div>
							<div>
								<p class="botonfi">
									<a style="COLOR: #333333; TEXT-DECORATION: none" 
									href="http://www.mininter.gob.pe/cnddhh/" 
									target="_blank"><img border="0" alt="" src="images/dh.png" width="15" height="15" /> DERECHOS HUMANOS</a>
								</p>
							</div>
							<div>
								<p class="botonfi">
									<a style="COLOR: #333333; TEXT-DECORATION: none" 
									href="http://dggi.mininter.gob.pe/" 
									target="_blank"><img border="0" src="images/dggi.png" width="15" height="15" />GOBIERNO INTERIOR</a></p>
							</div>
							<div>
					 			<p class="botonfi">
									<a style="COLOR: #333333; TEXT-DECORATION: none" 
									href="http://www.dicscamec.gob.pe/" 
									target="_blank"><img border="0" src="images/dicscamec.png" width="15" height="15" />DICSCAMEC</a></p>
				 			</div>				
							<div>
								<p class="botonfi">
									<a style="COLOR: #333333; TEXT-DECORATION: none" 
									href="http://www.digemin.gob.pe/" 
									target="_blank"><img border="0" src="images/digemin.png" width="15" height="15" />MIGRACIONES</a></p>
							</div>					
							<div>
								<p >
									<a style="COLOR: #333333; TEXT-DECORATION: none;text-align:left" 
									href="http://www.mininter.gob.pe/ofecod/" 
									target="_blank"><img border="0" src="images/ofecod.png" width="15" height="15" />OFECOD</a></p>
					</div>					
					<div>
								<p class="botonfi">
									<a style="COLOR: #333333; TEXT-DECORATION: none" 
									href="http://www.pnp.gob.pe/" 
									target="_blank"><img border="0" src="images/pnp.png" width="15" height="15" /> POLICIA NACIONAL</a></p></div>
					</div>
          </div>	
		  
   </div>
		
	  </td>
	  
    <td width="700" valign="top"><table width="680" border="0"   cellspacing="0" cellpadding="0">
      <tr>
        <td height="2" colspan="5"><img src="images/blank.jpg" width="2" /></td>
        </tr>
      <tr>
        <td height="200" colspan="5" valign="top"><img src="images/tres.JPG" width="690" height="200" /></td>
        </tr>
      <tr>
        <td height="2" colspan="5"><img src="images/blank.jpg" width="2" height="5" /></td>
        </tr>
      <tr>
        <td width="230"><div   class="botones"><img src="images/utilitarios.gif" width="16" height="16" />Utilitarios</div></td>
		        <td rowspan="5"><img src="images/blank.jpg" width="5" height="5" /></td>
        <td width="230"> <div   class="botones"> <img src="images/Computer.png" width="20" height="20" />Sistemas </div></td>
		    <td rowspan="5"><img src="images/blank.jpg" width="5" height="5" /></td>
        <td width="230"><div   class="botones"><img src="images/pastel.jpg" width="20" height="20" />Cumplea&ntilde;os</div></td>
      </tr>
      <tr>
        <td height="150" valign="top" bgcolor="#EAEAEA"><img src="images/reloj.GIF" width="20" height="20" />Asistencia <br>
        <img src="images/icon_libro.png" width="20" height="20" />Boleta de pago</td>
        <td valign="top" bgcolor="#EAEAEA" >

		
			<c:forEach items="${lstSistemas}" var="sis">
				 	<li>
			 		  <a href="http://srvprueba:8080/${sis.siminSistema.nsisAbreviatura}" target="_blank">
				 			<c:out value="${sis.siminSistema.nsisDescripcion}"/>
			 		  </a>				 	</li>				 	
		    </c:forEach>			</td>
        <td valign="top" bgcolor="#EAEAEA">    <c:forEach items="${lcumpleanios}" var="sis">				 	
				 	<li>
				 	  <c:out value="${sis.nombreCompleto}"/> </li>
		    </c:forEach></td>
        </tr>
      <tr>
        <td valign="top">&nbsp;</td>
        <td valign="top">&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><div class="botones"><img src="images/soporte.png" width="20" height="20" />Soporte</div></td>
        <td valign="top"><div class="botones"><img src="images/menu.gif" width="20" height="20" />Menu</div></td>
        <td valign="top"><div class="botones"><img src="images/campanas.jpg" width="20" height="20" />Campa&ntilde;as</div></td>
        </tr>
      <tr >
        <td height="150" bgcolor="#EAEAEA">&nbsp;</td>
        <td bgcolor="#EAEAEA">&nbsp;</td>
        <td bgcolor="#EAEAEA">&nbsp;</td>
        </tr>
    </table></td>
	
	
  </tr>
  
  <tr>
    <td colspan="2" class="pie"  > 
    Dirección: Plaza 30 de Agosto s/n Urb. Corpac - San Isidro - Lima | Atención: 8:00 a 16:15 hrs.<br />
      Teléfonos: Central 01 518-0000 - Prensa 980122710<br />
      <strong>Ministerio del Interior</strong>
    </td>
  </tr>
</table>
</center>		
</body>
</html>