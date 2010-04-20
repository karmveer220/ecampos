<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

  <link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
  	
   <script type="text/javascript">
  
   function limpiar(){
    document.forms[0].action="notarias.do";
    document.forms[0].method.value="nuevo";
    document.forms[0].snombre.value='';
    document.forms[0].nnotario.value='';
    document.forms[0].stelefono.value='';
    document.forms[0].sdireccion.value='';
    document.forms[0].sfax.value='';
    document.forms[0].semail.value='';
	document.forms[0].snombre.focus();
  }
   function cancelar(){
    document.forms[0].method.value="cancelaNuevo";
	document.forms[0].submit();
  }
  </script>
 
 <html:form action="notarias" onsubmit="return validateNotariasForm(this)">
 <input name="method" type="hidden" value="nuevo"/>
 		
        <table width="600px" border="0" align="center" cellpadding="3" cellspacing="0" class="tFormulario">
          <tr>
	        <td>&nbsp;</td>
	        <th>Colegio: </th>
	        <td>
	            <html:select name="n_notaria" property="ncolegio" styleClass="select" >
	               <html:options collection="comboColegios" labelProperty="snombre" property="ncodigo"/>
	            </html:select>
	        </td>
	        <td>&nbsp;</td>
	      </tr>
          <tr>
            <td>&nbsp;</td>
            <th>Nombre Notaria  : </th>
            <td><html:text property="snombre" name="n_notaria" styleClass="input"/></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="10%">&nbsp;</td>
            <th width="27%">Notario : </th>
            <td width="54%"><html:text property="nnotario" name="n_notaria" styleClass="input"/></td>
            <td width="9%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <th>Direccion : </th>
            <td><html:text property="sdireccion" name="n_notaria" styleClass="input"/></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <th>Telefono : </th>
            <td><html:text property="stelefono" name="n_notaria" styleClass="input"/></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <th>Fax : </th>
            <td><html:text property="sfax" name="n_notaria" styleClass="input"/></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <th>E-Mail : </th>
            <td><html:text property="semail" name="n_notaria" styleClass="input"/></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td colspan="2" align="center">
				  <input name="btnEnviar" type="submit" class="botonAz" id="btnEnviar" value="Grabar"/>&nbsp;&nbsp;
    	          <input name="btnLimpia" type="button" class="botonAz" value="Limpiar" onClick="javascript:limpiar();"/>&nbsp;&nbsp;
	              <input name="Submit2" type="button" class="botonAz" value="Cancelar" onClick="javascript:cancelar();"/>
            </td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <br />
  
  </html:form>
    <html:javascript formName="notariasForm"/>