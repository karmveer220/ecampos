<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
  
    <link rel="stylesheet" type="text/css" media="all" href="css/calendar-system.css" title="system" />
    <script type="text/javascript" src="js/sack.js"></script>
    <script type="text/javascript" src="js/calendar.js"></script>
    <script type="text/javascript" src="js/calendar-es.js"></script>
    <script type="text/javascript" src="js/calendar-setup.js"></script>

<script type="text/javascript">
	function limpiar() {
		document.forms[0].action = "admin.do";
		document.forms[0].method.value = "nuevo";
		document.forms[0].snombre.value = "";
		document.forms[0].spaterno.value = "";
		document.forms[0].smaterno.value = "";
		document.forms[0].snum_doc.value = "";
		document.forms[0].susuario.value = "";
		document.forms[0].sclave.value = "";
		document.forms[0].semail.value = "";
		document.forms[0].dnacimiento.value = "";
		document.forms[0].snombre.focus();
	}

	function cancela() {
		document.forms[0].action = "admin.do";
		document.forms[0].method.value = "cancelaModificar";
		document.forms[0].submit();
	}
</script>

<html:form action="admin" onsubmit="return validateUsuarioForm(this)">
 <input name="method" type="hidden" value="nuevo"/>
   
  <table width="600px" border="0" align="center" cellpadding="3" cellspacing="0" class="tFormulario">
 <c:choose>
    <c:when test="${usrLogin.nperfil.ncodigo==1}">
    <tr>
        <td>&nbsp;</td>
        <th>Colegio: </th>
        <td>
            <html:select name="nuser" property="colegio" styleClass="select" styleId="cmbcolegio"
             onchange="javascript:cargaNotaria(document.getElementById('cmbcolegio'));">
               <html:options collection="comboColegios" labelProperty="snombre" property="ncodigo"/>
            </html:select>
        </td>
        <td>&nbsp;</td>
      </tr>
     <tr>
        <td>&nbsp;</td>
        <th>Notaria : </th>
        <td>
            <html:select name="nuser" property="notaria" styleClass="select" styleId="cmbnotaria">
               <html:option value="-1">--Seleccionar Notaria--</html:option>
               <logic:present name="lstNotarias">
               		<html:options collection="lstNotarias" labelProperty="snombre" property="ncodigo"/>
               </logic:present>
            </html:select>
        </td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <th>Perfil : </th>
        <td>
            <html:select name="nuser" property="perfil" styleClass="select">
                <html:options collection="comboPerfiles" labelProperty="sdescripcion" property="ncodigo"/>
            </html:select>
        </td>
        <td>&nbsp;</td>
      </tr>
    </c:when>
    <c:otherwise>
     <tr>
        <td>&nbsp;</td>
        <th>Notaria : </th>
        <td><c:out value="${usrLogin.ncolegio.snombre}"/>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
     <tr>
        <td>&nbsp;</td>
        <th>Notaria : </th>
        <td><c:out value="${usrLogin.nnotaria.snombre}"/>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <th>Perfil : </th>
        <td>Consulta</td>
        <td>&nbsp;</td>
      </tr>
    </c:otherwise>
 </c:choose>
  <tr>
    <td width="10%">&nbsp;</td>
    <th width="27%">Nombres : </th>
    <td width="54%"><html:text property="snombre" name="nuser" styleClass="input"/></td>
    <td width="9%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>A. Paterno : </th>
    <td><html:text property="spaterno" name="nuser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>A. Materno : </th>
    <td><html:text property="smaterno" name="nuser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Fecha Nacimiento : </th>
    <td><input name="dnacimiento" id="dnacimiento" type="text" class="input" size="20" maxlength="10">
         <img src="images/cal.gif" alt="A&ntilde;o/Mes/D&iacute;a" width="16" height="16" border="0" id="triggerCal" />
         <script type="text/javascript">
                 /*var fechita = new Date();
                 fechota = fechita.getDate() + "/" + (fechita.getMonth()+1) + "/" + fechita.getFullYear();
                 document.forms[0].dnacimiento.value = fechota;*/
                     Calendar.setup({
                         inputField     :    "dnacimiento", // id del campo de texto
                         ifFormat       :    "%Y-%m-%d",       // Formato de la Fecha
                         showsTime      :    false,            // Flag para mostrar la Fecha
                         button         :    "triggerCal",   // ID del elemento que llamara al calendario
                         singleClick    :    true           // Flag Modo doble-click 
                     });
             </script>
	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Num. DNI : </th>
    <td><html:text property="snum_doc" name="nuser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Usuario : </th>
    <td><html:text property="susuario" name="nuser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
   <tr>
    <td>&nbsp;</td>
    <th>Clave : </th>
    <td><html:password property="sclave" name="nuser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>E-Mail : </th>
    <td><html:text property="semail" name="nuser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="2" align="center">
        <input name="btnEnviar" type="submit" class="botonAz" id="btnEnviar" value="Grabar">&nbsp;&nbsp;
        <input name="Submit2" type="button" class="botonAz" value="Limpiar" onClick="javascript:limpiar();"/>&nbsp;&nbsp;
		 <input name="Submit2" type="button" class="botonAz" value="Cancelar" onClick="javascript:cancela();"/>
    </td>
    <td>&nbsp;</td>
  </tr> 
</table>

  </html:form>
    <html:javascript formName="usuarioForm"/>