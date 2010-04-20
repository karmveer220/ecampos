<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
-1=--Seleccionar Notaria--
<c:forEach items="${lstNotarias}" var="reg">
;<c:out value="${reg.ncodigo}"/>=<c:out value="${reg.snombre}"/>
</c:forEach>