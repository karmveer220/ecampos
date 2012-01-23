<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
0=-Please Select-
<c:forEach items="${lcombosmaterial}" var="reg">
,<c:out value="${reg.matcodigopk}"/>=<c:out value="${reg.matnombrevh}"/>
</c:forEach>