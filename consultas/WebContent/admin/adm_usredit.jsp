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
	function cancela() {
		document.forms[0].action = "admin.do";
		document.forms[0].method.value = "cancelaModificar";
		document.forms[0].submit();
	}
</script>

<html:form action="admin" onsubmit="return validateUsuarioForm(this)">
 <input name="method" type="hidden" value="modificar"/>
 
  <table width="600px" border="0" align="center" cellpadding="3" cellspacing="0" class="tFormulario">
 <c:choose>
    <c:when test="${usrLogin.nperfil.ncodigo==1}">
    <tr>
        <td>&nbsp;</td>
        <th>Colegio: </th>
        <td>
            <html:select name="muser" property="colegio" styleClass="select" styleId="cmbcolegio"
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
            <html:select name="muser" property="notaria" styleClass="select" styleId="cmbnotaria">
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
            <html:select name="muser" property="perfil" styleClass="select">
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
    <td width="54%"><html:text property="snombre" name="muser" styleClass="input"/></td>
    <td width="9%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>A. Paterno : </th>
    <td><html:text property="spaterno" name="muser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>A. Materno : </th>
    <td><html:text property="smaterno" name="muser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Fecha Nacimiento : </th>
    <td><html:text property="dnacimiento" styleId="dnacimiento" name="muser" size="20" maxlength="10" styleClass="input"/>
           <img src="images/cal.gif" width="16" height="16" border="0" id="triggerCal" alt="A&ntilde;o/Mes/D&iacute;a" />
           <script type="text/javascript">
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
    <td><html:text property="snum_doc" name="muser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Usuario : </th>
    <td><html:text property="susuario" name="muser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>E-Mail : </th>
    <td><html:text property="semail" name="muser" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="2" align="center">
        <input name="btnEnviar" type="submit" class="botonAz" id="btnEnviar" value="Guardar">&nbsp;&nbsp;
        <input name="Submit2" type="button" class="botonAz" value="Cancelar" onClick="javascript:cancela();"/>&nbsp;&nbsp;
    </td>
    <td>&nbsp;</td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
 
  </html:form>
  
  <html:javascript formName="usuarioForm"/>