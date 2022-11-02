<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<form action="login" method="post">
		<input name="user" placeholder="Usuario">
		<input name="pass" type="password" placeholder="Contraseña">
		<button>Login</button>
		<span class="error"><%= request.getAttribute("error") %></span>
		<span class="error">${error}</span>
		<%-- 		${}recoge el atributo/parametro con el nombre dentro de las llaves --%>
	</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>


