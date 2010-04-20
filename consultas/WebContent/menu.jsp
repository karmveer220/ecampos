<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul id="navi">
        <li><a href="home.do">Inicio</a></li>
	<c:if test="${usrLogin.nperfil.ncodigo==1 or usrLogin.nperfil.ncodigo==3}">
			 <!-- Menu del Administrador de las Notarias-->
            <li><a href="admin.do?method=lista">Administracion de usuarios</a></li>
        </c:if>
        <c:if test="${usrLogin.nperfil.ncodigo==1}">
		 	<!-- Menu del Super Administrador-->
			<li><a href="notarias.do?method=lista">Administracion de Notarias</a></li>
        </c:if>
       	<li><a href="ce.do?method=inicio">Buscar Carnet de Extranjer&iacute;a</a></li>
        <li><a href="pasaporte.do?method=inicio">Buscar Pasaporte</a></li>
        <li><a href="movimientos.do?method=inicio">Movimientos Migratorios</a></li>
		<li><hr/></li>
		<li><a href="clave.do?method=preCambioClave">Cambiar Clave</a></li>
		<li><a href="login.do?method=logout">Cerrar Sessi&oacute;n</a></li>
     
</ul>