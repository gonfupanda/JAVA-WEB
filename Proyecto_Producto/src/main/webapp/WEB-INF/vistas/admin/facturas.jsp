<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<thead class="table-dark">
		<tr>
			<th class="text-end">Id</th>
			<th>Codigo</th>
			<th >Fecha</th>
			<th>Cliente</th>
			<th>Empleado</th>
			<th>$Producto</th>
			<th>Opciones</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${facturas}" var="f">
			<tr>
				<th class="text-end">${f.id}</th>
				<td>${f.codigo}</td>	
				<td>${f.fecha}</td>		
				<td>${f.cliente.id}</td>
				<td>${f.empleado.id}</td>
				<td>
				PRODUCTO       CANTIDAD<br>
				<c:forEach items="${f.lineas}" var="l">
					${l.producto.nombre}     ${l.cantidad}<br>
				</c:forEach> 
				</td>

				
				<td><a class="btn btn-primary btn-sm"
					href="admin/producto?id=${f.id}">Editar</a> <a
					class="btn btn-danger btn-sm"
					href="admin/producto/borrar?id=${f.id}">Borrar</a></td>
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
			<td></td>
			<td><a class="btn btn-primary btn-sm" href="admin/producto">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>