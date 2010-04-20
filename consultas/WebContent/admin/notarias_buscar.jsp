<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
   <script type="text/javascript">
   
	function nuevo() {
		document.forms[0].method.value = "preNuevo";
		document.forms[0].submit();
	}

	function detalle(codigo) {
		document.forms[0].action = "notarias.do";
		document.forms[0].method.value = "preModificar";
		//document.forms[0].uid.value=codigo;
		document.forms[0].submit();
	}
	function limpiar() {
		document.forms[0].action = "notarias.do";
		document.forms[0].method.value = "buscar";
		document.forms[0].snombre.value = '';
		document.forms[0].snombre.focus();
	}
</script>

 
 <html:form action="notarias">
 <input type="hidden" name="method" value="buscar"/>

  <table width="600px" border="0" align="center" cellpadding="3" cellspacing="0" class="tFormulario">
  <tr>
    <td width="13%">&nbsp;</td>
    <th width="20%">Notaria : </th>
    <td width="55%"><html:text property="snombre" styleClass="input"/></td>
    <td width="12%">&nbsp;</td>
  </tr> 
  <tr>
    <td>&nbsp;</td>
    <td colspan="2" align="center" valign="middle">
        <input name="btnnuevo" type="button" class="botonAz" id="btnnuevo" value="Nuevo" onClick="javascript:nuevo();"/>&nbsp; 
        <input name="btnBuscar" type="submit" class="botonAz" id="btnBuscar" value="Buscar"/>&nbsp; 
        <input name="btnLimpiar" type="button" class="botonAz" id="btnLimpiar" value="Limpiar" onClick="javascript:limpiar();"/>    </td>
    <td>&nbsp;
    
    </td>
  </tr>
</table>

    <div style="width:600px">
    
    
	  <display:table name="sessionScope.listaNotarias" requestURI="lnotarias.do" class="displaytag" pagesize="10" defaultsort="1"
		defaultorder="ascending" export="true" id="row" excludedParams="ajax">	
            <display:column title="Nombre" property="snombre" sortable="true" headerClass="sortable" />
            <display:column title="Notario" property="nnotario" sortable="true" class="definition"/>
            <display:column title="Direccion" media="excel pdf" property="sdireccion" class="definition"/>
            <display:column title="Telefono" media="excel pdf" property="stelefono" class="definition"/>
            <display:column title="Fax" media="excel pdf" property="sfax" class="definition"/>
            <display:column title="E-mail" media="html" property="semail" autolink="true" sortable="true" class="definition"/>
            <display:column title="E-mail" media="excel pdf" property="semail" class="definition"/>
            <display:column title="Modificar" media="html" class="definition">
            	<a href="notarias.do?method=preModificar&amp;not=${row.ncodigo}"><img alt="Modificar" src="images/edit.png" height="18px" width="18px"> </a>
            </display:column>                    
            <display:setProperty name="export.csv" value="false" />
            <display:setProperty name="export.xml" value="false" />
            <display:setProperty name="export.excel.filename" value="notairas.xls" />
            <display:setProperty name="export.pdf.filename" value="notarias.pdf" />
        </display:table>
      
    </div>
    
  </html:form>