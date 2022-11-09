<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/libro" method="post">
	<legend>Registrar Libro</legend>
	<div class="mb-3">
		<label for="id" class="form-label">Id</label> <input type="number"
			id="id" name="id" class="form-control"
			aria-describedby="passwordHelpBlock">

	</div>
	<div class="mb-3">
		<label for="nombre" class="form-label">Nombre</label> <input
			type="text" id="nombre" name="nombre" class="form-control"
			aria-describedby="passwordHelpBlock">

	</div>
	<div class="mb-3">
		<label for="precio" class="form-label">Precio</label> <input
			type="number" id="precio" name="precio" class="form-control"
			aria-describedby="passwordHelpBlock">

	</div>
	<div class="mb-3">
		<label for="descuento" class="form-label">Descuento</label> <input
			type="number" id="descuento" name="descuento" class="form-control"
			aria-describedby="passwordHelpBlock">

	</div>

	<button type="submit" class="btn btn-primary">Submit</button>

</form>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>