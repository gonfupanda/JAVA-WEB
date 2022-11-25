<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<thead class="table-dark">
		<tr>
			<th class="text-end">Id</th>
			<th>imagen</th>
			<th>nombre</th>
			<th>cantidad</th>
			<th></th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="c">
			<tr>
				<th class="text-end">${c.prod.id}</th>
				<td><img src="imgs/${c.prod.id}.jpg" alt="${c.prod.nombre}" onerror="this.onerror=null;this.src='http://craftsnippets.com/articles_images/placeholder/placeholder.jpg'" style="height:80px; overflow:hidden;content-align:center "></td>
				<td>${c.prod.nombre}</td>	
				<td>${c.cantidad}</td>	
				<td><a class="btn btn-primary btn-sm"
						href="deleteCarrito?id=${c.prod.id}">Quitar</a> <td>

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

		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>