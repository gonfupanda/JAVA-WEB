<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />

<!DOCTYPE html>
<html class="h-100">
<head>
<base href="${pageContext.request.contextPath}/" />
<meta charset="UTF-8">
<title>UF2218</title>


<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-icons.css">
<link rel="stylesheet" href="css/footer.css">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
<style>
body {
	padding-bottom: 70px;
}
</style>

</head>
<script>
	$(document).ready(function() {
		$('table').DataTable();
	});
</script>
<!--Boodstrap JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>

</head>
<body class="d-flex flex-column h-100">
	<nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
		<div class="container-fluid">
			<c:if test="${sessionScope.usuario != null}">
				<a class="navbar-brand" href="index">${sessionScope.usuario}</a>
			</c:if>
			<c:if test="${sessionScope.usuario == null}">
				<a class="navbar-brand" href="index">Examen Modulo</a>
			</c:if>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="navbar-nav mb-2 mb-lg-0">
					<c:if test="${sessionScope.usuario != null}">

						<li class="nav-item"><a class="nav-link" href="admin/libro">Registrar
								Libro</a></li>
						<li class="nav-item"><a class="nav-link" href="admin/index">Cambios</a></li>
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
					</c:if>
					<c:if test="${sessionScope.usuario == null}">
						<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${alertaMensaje != null}">
		<div class="alert alert-${alertaNivel} alert-dismissible fade show"
			role="alert">
			${alertaMensaje}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>

	<div class="container-fluid mt-4">