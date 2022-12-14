<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es-ES" />

<!DOCTYPE html>
<html class="h-100" lang="es">
<head>

<base href="${pageContext.request.contextPath}/" />

<meta charset="UTF-8">
<title>UF2218 Ejemplo</title>

<style>
	.nombreLista{
		position: relative;
	}
	.nombreLista .badge{
		  position: absolute;
		  top: -10px;
		  left: 50px;
		  background: red;
		  width: 15px;
		  border-radius: 50%;
		  display: flex;
		  color: white;
		  padding: 4px;
	}
	.cart {
	  position: relative;
	}

</style>


<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="css/stripe.css" />

<script src="js/jquery-3.5.1.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/dataTables.bootstrap5.min.js"></script>

<script src="js/datatables.js"></script>
<script src="js/cantidad.js"></script>
<script src="js/cantidadTotal.js"></script>


</head>
<body class="d-flex flex-column h-100">
	<nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top d-print-none">
		<div class="container-fluid">
			<a class="navbar-brand " href="#">Principal</a>
			<button class="navbar-toggler " type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 " >
				<c:if test="${sessionScope.usuario != null}">
					<li class="nav-item"><a class="nav-link" href="admin/producto">New Producto</a></li>
					<li class="nav-item"><a class="nav-link" href="admin/productos">Productos</a></li>
					<li class="nav-item"><a class="nav-link" href="admin/facturas">Listado facturas</a></li>
					<li class="nav-item"><a class="nav-link" href="admin/empleados">Empleados</a></li>
					
				</c:if>
				<li class="nav-item">
					<a class="nav-link " href="carrito">
						<span  class="nombreLista">Carrito
						<span  data-action="cart-can" class="badge rounded-circle">${sessionScope.carritoLenght}</span>
						
						</span>
						 
						
					</a>
					</li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<c:if test="${sessionScope.usuario != null}">
						
						<li class="navbar-text">${sessionScope.usuario.email} / ${sessionScope.usuario.rol.nombre}</li>
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