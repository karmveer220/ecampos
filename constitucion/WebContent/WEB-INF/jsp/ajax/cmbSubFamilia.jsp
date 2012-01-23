<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
0=-Please Select-
<c:forEach items="${lcombossubfamilias}" var="reg">
,<c:out value="${reg.sfamcodigopk}"/>=<c:out value="${reg.sfamnombrevh}"/>
</c:forEach>