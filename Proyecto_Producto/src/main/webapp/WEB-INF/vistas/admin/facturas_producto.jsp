<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<thead class="table-dark">
		<tr>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			
			<th>categoria</th>
			<th>Cantidad</th>
			<th class="text-end">Precio</th>
			
			<th>valor</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${lineas}" var="l">
			<tr>
				<th class="text-end">${l.producto.id}</th>
				<td>${l.producto.nombre}</td>		
				<td>${l.producto.descripcion}</td>
				<td>${l.producto.categoria.id}</td>
				<td>${l.cantidad}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${l.producto.precio}"/></td>
				<c:set var="totalProd" value="${l.producto.precio*l.cantidad}"/>
				<c:set var="total" value="${total+totalProd}"/>
				<td><fmt:formatNumber type="currency" value="${totalProd}"/></td>
				
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><fmt:formatNumber type="currency" value="${total}"/></td>
			<td><a class="btn btn-primary btn-sm" href="admin/producto">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>