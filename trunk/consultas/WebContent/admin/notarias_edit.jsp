<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript">
	function cancelar() {
		document.forms[0].method.value = "cancelaModificar";
		document.forms[0].submit();
	}
</script>

<html:form action="notarias" onsubmit="return validateNotariasForm(this)">
 <input name="method" type="hidden" value="modificar"/>

  <table width="600px" border="0" align="center" cellpadding="3" cellspacing="0" class="tFormulario">
    <tr>
       <td>&nbsp;</td>
       <th>Colegio: </th>
       <td>
           <html:select name="m_notaria" property="ncolegio" styleClass="select">
              <html:options collection="comboColegios" labelProperty="snombre" property="ncodigo"/>
           </html:select>
       </td>
       <td>&nbsp;</td>
     </tr>
     <tr>
    <td>&nbsp;</td>
    <th>Nombre Notaria  : </th>
    <td><html:text property="snombre" name="m_notaria" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="10%">&nbsp;</td>
    <th width="27%">Notario : </th>
    <td width="54%"><html:text property="nnotario" name="m_notaria" styleClass="input"/></td>
    <td width="9%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Direccion : </th>
    <td><html:text property="sdireccion" name="m_notaria" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Telefono : </th>
    <td><html:text property="stelefono" name="m_notaria" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Fax : </th>
    <td><html:text property="sfax" name="m_notaria" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>E-Mail : </th>
    <td><html:text property="semail" name="m_notaria" styleClass="input"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="2" align="center">
        <input name="btnEnviar" type="submit" class="botonAz" id="btnEnviar" value="Grabar"/>&nbsp;&nbsp;
        <input name="Submit2" type="button" class="botonAz" value="Cancelar" onClick="javascript:cancelar();"/>    </td>
    <td>&nbsp;</td>
  </tr> 
</table>
<br />
  
  </html:form>
    <html:javascript formName="notariasForm"/>