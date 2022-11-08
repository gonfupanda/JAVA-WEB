<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/libro" class="needs-validation" method="post">
	<legend>Registrar Libro</legend>
	<div class="mb-3">
		<label for="id" class="form-label">Id</label> <input type="number"
			id="id" name="id" class="form-control"
			aria-describedby="passwordHelpBlock" value="${libro.id}" required >
			<div class="invalid-feedback">
				${producto.errores.id}
			</div>

	</div>
	<div class="mb-3">
		<label for="nombre" class="form-label">Nombre</label> <input
			type="text" id="nombre" name="nombre" class="form-control"
			aria-describedby="passwordHelpBlock" value="${libro.nombre}" required >
			<div class="invalid-feedback">
				${producto.errores.id}
			</div>

	</div>
	<div class="mb-3">
		<label for="precio" class="form-label">Precio</label> <input
			type="number" id="precio" name="precio" class="form-control"
			aria-describedby="passwordHelpBlock" value="${libro.precio}" required >
			<div class="invalid-feedback">
				${producto.errores.id}
			</div>

	</div>
	<div class="mb-3">
		<label for="descuento" class="form-label">Descuento</label> <input
			type="number" id="descuento" name="descuento" class="form-control"
			aria-describedby="passwordHelpBlock" value="${libro.descuento}" required >
			<div class="invalid-feedback">
				${producto.errores.id}
			</div>
	</div>
	<div class="mb-3">
		<label for="autor" class="form-label">Autor</label> <input
			type="text" id="autor" name="autor" class="form-control"
			aria-describedby="passwordHelpBlock" value="${libro.autor}">


	</div>
	<div class="mb-3">
		<label for="imagen" class="form-label">Imagen</label> <input
			type="text" id="imagen" name="imagen" class="form-control"
			placeholder="Introduzca la url de la imagen " value="${libro.imagen}">

	</div>
	

	<button type="submit" class="btn btn-primary">Submit</button>

</form>
<br><br><br><br>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>