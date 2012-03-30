 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 
<un:useConstants var="const" className="CustomerStatementDTO"/>


<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Documento sin t&iacute;tulo</title>


<style type="text/css">
<!--
body {background-color: #D9ECFF;}
.soporte {font-family:tahoma;font-weight: bold; font-size:15px; background-color: #D9ECFF;}

-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
       <table width="600" border="0" cellpadding="1" class="soporte">
         <tr>
           <td colspan="3" bgcolor="#0066CC" style="color:#FFFFFF; font-size:18px">Cumpleaños del D&iacute;a </td>
         </tr>
         <tr>
           <td width="231" bgcolor="#B0D8FF">    <ul>
                <c:forEach items="${lcumpleanios}" var="sis">				 	
				 	<li><c:out value="${sis.nombreCompleto}"/> </li>
				 </c:forEach>
				 
				 
				  
                </ul>   </td>
           <td width="150" bgcolor="#B0D8FF">&nbsp;</td>
           <td width="150" bgcolor="#B0D8FF">&nbsp;</td>
         </tr>
  </table>
</form>
</body>
</html>


