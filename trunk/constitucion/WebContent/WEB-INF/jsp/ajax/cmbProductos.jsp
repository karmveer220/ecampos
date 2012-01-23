<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
0=-Please Select-
<c:forEach items="${lcomboproductos}" var="reg">
,<c:out value="${reg.prcodigopk}"/>=<c:out value="${reg.prdiametrovh}"/>
</c:forEach>