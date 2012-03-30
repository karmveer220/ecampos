 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 
<un:useConstants var="const" className="CustomerStatementDTO"/>


<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Documento sin t&iacute;tulo</title>


</head>

<body>
        <td>
            	<div align="center"><strong>Sistemas </strong></div>            
                <ul>
          	 <c:forEach items="${lstSistemas}" var="sis">
				 	<li>
				 		<a href="http://srvprueba:8080/${sis.siminSistema.nsisAbreviatura}" target="_blank">
				 			<c:out value="${sis.siminSistema.nsisDescripcion}"/>
				 		</a>
				 	</li>				 	
				 </c:forEach>
				 
				 
				  
                </ul>   
              
                         
            </td>
</body>
</html>


