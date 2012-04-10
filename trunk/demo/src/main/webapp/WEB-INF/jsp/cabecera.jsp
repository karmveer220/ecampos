<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script language="javascript">
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
</script>

<table width="900" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="10" colspan="4" align="right" valign="top" bgcolor="#666666">
			<ul id="topnav">
				<li><a href="login.htm"> <img src="images/home.png"
						alt="inicio" width="20" height="20" class="link-img" />Home
				</a></li>
				<li><a href="http://www.mininter.gob.pe" target="_blank"><img
						src="images/logo_min.png" alt="Portal" width="20" height="20"
						class="link-img" />Portal</a></li>
				<li><a href="http://correo.mininter.gob.pe" target="_blank">
						<img src="images/mail.png" alt="Correo" width="20" height="20"
						class="link-img" />Correo
				</a></li>
			</ul>
		</td>
	</tr>
	<tr>
		<td height="90" colspan="4" align="left" valign="top">
			<table width="900" height="90" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="245"><img src="images/min.jpg" width="245"
						height="90" /></td>
					<td width="490">
						<div class="tituintra1">M I N I N T E R</div>
						<div class="tituintra2">Ministerio del Interior</div>
					</td>
					<td width="165" align="right" valign="top"><img
						src="images/mintranet.jpg" width="165" height="83" /></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr valign="top" class="datuser">
		<td width="260" height="25">Bienvenido:<br> <c:out
				value="${usuario.nombreCompleto}" /></td>
		<td width="410" height="25">Area:<br> <c:out
				value="${usuario.siminUnidadorganica1.nunoDescripcion}" /></td>
		<td width="100" height="25">IP:<br> <c:out
				value="${usuario.ipPrivada}" /></td>
		<td width="140" height="25">Fecha:<br>
		<script language="javascript">
			document.write(nombres_dias[dia_semana] + ", " + dia_mes + " de " + nombres_meses[mes - 1] + " de " + anio)
		</script>
		</td>
	</tr>
</table>