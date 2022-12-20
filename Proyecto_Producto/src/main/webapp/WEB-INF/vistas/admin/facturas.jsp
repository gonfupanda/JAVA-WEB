<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="decorada table table-striped table-hover table-bordered">
<caption class="d-none">Listado Facturas</caption>
	<thead class="table-dark">
		<tr>
			<th class="text-end" scope="col">Id</th>
			<th scope="col">Codigo</th>
			<th scope="col">Fecha</th>
			<th scope="col">Cliente</th>
			<th scope="col">Empleado</th>
			<th scope="col">Producto  Cantidad</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${facturas}" var="f">
			<tr>
				<td class="text-end">${f.id}</td>
				<td>${f.codigo}</td>	
				<td>${f.fecha}</td>		
				<td>${f.cliente.id}</td>
				<td>${f.empleado.id}</td>
				<td><a href="admin/facturas/productos?id=${f.id}">Lista productos</a></td>
				<%-- 
				<td>
				<c:forEach items="${f.lineas}" var="l">
					${l.producto.nombre}     ${l.cantidad}<br>
				</c:forEach> 
				</td>
				--%>
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
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>