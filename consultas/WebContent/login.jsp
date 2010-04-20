<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Colegio de Notarios de Lima</title>
         <html:base />
        <link href="css/estilos.css" rel="stylesheet" type="text/css">
    </head>
<body>


<html:form action="/login">
<input type="hidden" name="method" value="login"/>
        
<div id="login" align="center">

        <div align="center">
        
            <logic:present name="msgError">
                    <div id="error"><bean:write name="msgError" scope="request"/></div><br />
            </logic:present>
            
            <table width="664" cellspacing="0" cellpadding="0">
                  <tr>
                        <td width="207"><img src="images/colegio_notarios.jpg" alt="logo" width="207" height="205" longdesc="logo CNL"></td>
                        <td width="413">
						
						<table width="400px" cellpadding="2" cellspacing="0" class="login">
                          <tr>
                            <td colspan="3">&nbsp;</td>
                          </tr>
						  <tr>
                            <th width="30%" align="right">Usuario</th>
                            <td width="60%"><html:text property="usuario" styleClass="input"></html:text></td>
                            <td width="10%">&nbsp;</td>
                          </tr>
                          <tr>
                            <td colspan="3"><font color="red"><html:errors property="usuario"/></font></td>
                          </tr>
                          <tr>
                            <th align="right">Contrase&ntilde;a</th>
                            <td><html:password property="clave" styleClass="input"></html:password></td>
                            <td>&nbsp;</td>
                          </tr>
                           <tr>
                            <td colspan="3"><font color="red"><html:errors property="clave"/></font></td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td align="center" valign="middle"><html:submit property="btnIngresar" styleClass="botonAz" value="Ingresar" ></html:submit>
                              &nbsp;&nbsp;
                              <input name="btnCancelar" type="reset" class="botonAz" value="Limpiar" /></td>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                        <td width="42">&nbsp;</td>
                  </tr>
          </table>
        </div>
                
                
  </div>
</html:form>

</body>
</html:html>