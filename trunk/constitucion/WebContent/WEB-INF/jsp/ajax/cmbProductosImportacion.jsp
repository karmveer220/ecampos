<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
0=-Please Select-
<c:forEach items="${lcomboproductosimportacion}" var="reg">
,<c:out value="${reg.palcodigopk}"/>=<c:out value="${reg.combo}"/>
</c:forEach>