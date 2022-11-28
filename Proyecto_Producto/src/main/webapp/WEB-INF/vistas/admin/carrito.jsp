<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
<caption class="d-none">Carrito</caption>
	<thead class="table-dark">
		<tr>
			<th class="text-end" scope="col">Id</th>
			<th scope="col">imagen</th>
			<th scope="col">nombre</th>
			<th scope="col">cantidad</th>
			<th scope="col">Precio</th>
			<th scope="col"></th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="c">
			<tr>
				<td class="text-end" >${c.prod.id}</td>
				<td><img src="imgs/${c.prod.id}.jpg" alt="${c.prod.nombre}" onerror="this.onerror=null;this.src='http://craftsnippets.com/articles_images/placeholder/placeholder.jpg'" style="height:80px; overflow:hidden;content-align:center "></td>
				<td>${c.prod.nombre}</td>	
				<td>${c.cantidad}</td>	
				<td class="text-end"><fmt:formatNumber type="currency" value="${c.prod.precio*c.cantidad}"/></td>
				<c:set var="totalProd" value="${c.prod.precio*c.cantidad}"/>
				<c:set var="total" value="${total+totalProd}"/>
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
			<td><fmt:formatNumber type="currency" value="${total}"/></td>
			<td><a class="btn btn-primary btn-sm"
						href="compra">Compra</a></td>

		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>