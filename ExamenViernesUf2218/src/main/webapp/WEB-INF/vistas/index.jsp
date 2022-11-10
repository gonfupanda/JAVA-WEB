<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hovered table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Descuento</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="p">
			<tr>
				<td>${p.nombre}</td>
				<td><fmt:formatNumber type="currency" value="${p.precio}"></fmt:formatNumber>
				</td>
				<td>${p.descuento}%</td>
				<td>
					<a class="btn btn-sm btn-primary" href="admin/libro?id=${p.id}">Editar</a>
					<a class="btn btn-sm btn-danger" href="admin/libro/borrar?id=${p.id}">Borrar</a>
				</td>
			</tr>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>

		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>