<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<link href="css/estilos.css" rel="stylesheet" type="text/css"></link>
<link type="text/css" rel="stylesheet" href="cssa/displaytag.css"></link>
<script type="text/javascript" src="js/sack.js"></script>
<script type="text/javascript" src="ajaxtags/jsa/prototype.js"></script>
<script type="text/javascript" src="ajaxtags/jsa/scriptaculous/scriptaculous.js"></script>
<script type="text/javascript" src="ajaxtags/jsa/overlibmws/overlibmws.js"></script>
<script type="text/javascript">
  
   function nuevo(){
    document.forms[0].method.value="preNuevo";
    document.forms[0].submit();
  }  
  
  function detalle(codigo){    
    document.forms[0].action="admin.do";
    document.forms[0].method.value="preModificar";
    document.forms[0].uid.value=codigo;
    document.forms[0].submit();
  }  
   function limpiar(){
    document.forms[0].action="admin.do";
    document.forms[0].method.value="buscar";
    document.forms[0].snombre.value='';
    document.forms[0].spaterno.value='';
    document.forms[0].susuario.value='';
    document.forms[0].snombre.focus();
  }
  </script>

<html:form action="admin">
	<input type="hidden" name="method" value="buscar" />

	<table width="600px" border="0" align="center" cellpadding="3" cellspacing="0" class="tFormulario">
		<tr>
			<th>Colegio</th>
			<td colspan="2">&nbsp;
				<html:select property="colegio" styleClass="select" styleId="cmbcolegio"
	             onchange="javascript:cargaNotaria(document.getElementById('cmbcolegio'));">
	               <html:options collection="comboColegios" labelProperty="snombre" property="ncodigo"/>
	            </html:select>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th>Notaria</th>
			<td colspan="2">&nbsp;
				 <html:select property="notaria" styleClass="select" styleId="cmbnotaria">
	               <logic:present name="lstNotarias">
	               		<html:options collection="lstNotarias" labelProperty="snombre" property="ncodigo"/>
	               </logic:present>
	            </html:select>
            </td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="17%">Nombre :</th>
			<td width="35%"><html:text property="snombre" styleClass="input" /></td>
			<th width="17%">Ap. Paterno :</th>
			<td width="31%">&nbsp;<html:text property="spaterno" styleClass="input" /></td>
		</tr>
		<tr>			
			<th>Usuario :</th>
			<td><html:text property="susuario" styleClass="input" /></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="2" align="center" valign="middle">
				<input name="btnBuscar" type="button" class="botonAz" id="btnBuscar" value="Nuevo" onClick="javascript:nuevo();" />&nbsp;
				<input name="btnBuscar" type="submit" class="botonAz" id="btnBuscar" value="Buscar" />&nbsp;
				<input name="btnLimpiar" type="button" class="botonAz" id="btnLimpiar" value="Limpiar" onClick="javascript:limpiar();" />
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>

	<div style="width: 600px">
		<display:table name="sessionScope.listaUsuariosuu" requestURI="lusuarios.do"  class="displaytag" pagesize="10"
			defaultsort="1" defaultorder="ascending" export="true" id="row" excludedParams="ajax">
			<display:column media="html" title="Usuario" autolink="true" paramId="usr" paramProperty="ncodigo" property="susuario" href="admin.do?method=preModificar" sortable="true" headerClass="sortable" />
			<display:column media="excel pdf" title="Usuario" property="susuario" headerClass="sortable" />
			<display:column title="Nombre" property="snombre" sortable="true" headerClass="sortable" />
			<display:column title="A. Paterno" property="spaterno" sortable="true" class="definition" />
			<display:column title="A. Materno" property="smaterno" sortable="true" class="definition" />
			<display:column media="excel pdf" title="DNI" property="snum_doc" class="definition" />
			<display:column media="excel pdf" title="Notaria" property="nnotaria.snombre" class="definition" />
			<display:column title="Perfil" property="nperfil.sdescripcion" sortable="true" class="definition" />
			<display:column media="html" autolink="true" href="clave.do?method=preRestClave" paramId="usr" paramProperty="ncodigo" title="Restablecer Clave" headerClass="sortable">Cambiar</display:column>
			<display:setProperty name="export.csv" value="false" />
			<display:setProperty name="export.xml" value="false" />
			<display:setProperty name="export.excel.filename" value="usuarios.xls" />
			<display:setProperty name="export.pdf.filename" value="usuarios.pdf" />
		</display:table>
	</div>

</html:form>