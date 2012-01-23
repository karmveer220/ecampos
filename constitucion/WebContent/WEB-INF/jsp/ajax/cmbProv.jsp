<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
0=-Please Select-
<c:forEach items="${lcomboprovincias}" var="reg">
;<c:out value="${reg.t001parametroPK.codParam}"/>=<c:out value="${reg.desParam}"/>
</c:forEach>