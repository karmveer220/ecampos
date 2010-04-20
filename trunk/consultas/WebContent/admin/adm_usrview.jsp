<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

  <link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
   <script type="text/javascript">
  
  function detalle(codigo){    
    document.forms[0].action="pasaporte.do";
    document.forms[0].method.value="pasaporteDetalle";
    document.forms[0].uid.value=codigo;
    document.forms[0].submit();
  }  
   function limpiar(){
    document.forms[0].action="pasaporte.do";
    document.forms[0].method.value="buscarPasaporte";
    document.forms[0].uid.value='';
    document.forms[0].snombre.value='';
    document.forms[0].spaterno.value='';
    document.forms[0].smaterno.value='';
    document.forms[0].snroce.value='';
    document.forms[0].snombre.focus();
  }
  </script>
  
  <table width="600px" border="0" align="center" cellpadding="3" cellspacing="0" class="tFormulario">
  <tr>
    <td width="10%">&nbsp;</td>
    <td width="27%">&nbsp;</td>
    <td width="54%">&nbsp;</td>
    <td width="9%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Nombres : </th>
    <td>XXXXX XXXXXXXXX </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>A. Paterno : </th>
    <td>XXXXXXXX</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>A. Materno : </th>
    <td>XXXXXX</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Fecha Nacimiento : </th>
    <td>XXXXXXXX</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Num. DNI : </th>
    <td>XXXXXXXXXXXXX</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>Usuario : </th>
    <td>XXXXXXXX</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <th>&nbsp;</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="2" align="center"><input name="Submit2" type="submit" class="botonAz" value="Volver"></td><td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
 