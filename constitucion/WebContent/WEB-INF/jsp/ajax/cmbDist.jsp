<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
0=-Please Select-
<c:forEach items="${lcomboDistritos}" var="reg">
;<c:out value="${reg.codParam}"/>=<c:out value="${reg.desParam}"/>
</c:forEach>