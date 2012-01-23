<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://www.springframework.org/security/tags' prefix='security'%>
 <div id="menu">
     <ul>
        <security:authorize ifAnyGranted="ROLE_SECUNDARIO">
        <li><a href="#">Constituciones</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/constitucion/bandeja.htm">Bandeja</a></li>
                <li><a href="${pageContext.request.contextPath}/constitucion/incompletos.htm">Incompletos</a> </li>
                <li><a href="${pageContext.request.contextPath}/constitucion/pendientes.htm">Pendiente de Firma</a> </li>
                <li><a href="${pageContext.request.contextPath}/constitucion/firmados.htm">Firmados Digitalmente</a> </li>
                <li><a href="${pageContext.request.contextPath}/constitucion/enviados.htm">Enviados</a> </li>
                <li><a href="${pageContext.request.contextPath}/constitucion/eliminados.htm">Eliminados</a> </li>
            </ul>
        </li>
        </security:authorize>
        <security:authorize ifAnyGranted="ROLE_PRINCIPAL">
        <li><a href="#">Administracion</a>
            <ul>
           		<li><a href="${pageContext.request.contextPath}/administracion/usuarios.htm">Control de Usuarios</a></li>                
                <li><a href="${pageContext.request.contextPath}/administracion/notarias.htm">Ingreso de Notarias</a></li>
              </ul>
        </li>
        </security:authorize>
         <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a></li>
     </ul>
</div>