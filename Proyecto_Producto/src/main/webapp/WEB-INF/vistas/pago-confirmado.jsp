<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>El pago ha sido confirmado</h2>

<div class="d-flex">
	<div class="me-auto">
		<p>Datos de empresa</p>
		<p>[${factura.id}]</p>
		<p>${factura.codigo}</p>
	</div>

	<div>
		<p>${factura.cliente.nif}</p>
		<p>${factura.cliente.nombre}</p>
		<p>${factura.cliente.email}</p>
		<p>${factura.fecha}</p>
	</div>
</div>
<div class="table-responsive">
	<table class="table">
		<caption class="d-none">Detalle</caption>
		<thead>
			<tr>
				<th scope="col">Nombre</th>
				<th scope="col" class="text-end">Precio</th>
				<th scope="col" class="text-end">Cantidad</th>
				<th scope="col" class="text-end">Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${factura.lineas}" var="l">
				<tr>
					<td>${l.prod.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${l.prod.precio}" /></td>
					<td class="text-end">${l.cantidad}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${l.total}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${factura.total}" /></td>
			</tr>
		</tfoot>
	</table>
</div>

<a class="d-print-none btn btn-primary w-100 mb-3" href="">Volver al listado de
	productos</a>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>