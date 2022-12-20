<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="decorada table table-striped table-hover table-bordered">
	<thead class="table-dark">
		<tr>
		<th></th>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
			<th>Descripcion</th>
			<th>categoria</th>
			<c:if test="${sessionScope.usuario.rol.nombre == 'ADMIN'}">
				<th>Opciones</th>
			</c:if>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<td><img src="imgs/${p.id}.jpg" alt="${p.nombre}" onerror="this.onerror=null;this.src='http://craftsnippets.com/articles_images/placeholder/placeholder.jpg'" style="height:80px; overflow:hidden;content-align:center "></td>
				<th class="text-end">${p.id}</th>
				<td>${p.nombre}</td>		
				<td class="text-end"><fmt:formatNumber type="currency" value="${p.precio}"/></td>
				<td>${p.descripcion}</td>
				<td>${p.categoria.id}</td>
				<c:if test="${sessionScope.usuario.rol.nombre == 'ADMIN'}">
				
					<td>
						<a class="btn btn-primary btn-sm"
						href="admin/producto?id=${p.id}">Editar</a> 
						<a
						class="btn btn-danger btn-sm"
						href="admin/producto/borrar?id=${p.id}">Borrar</a>
					</td>
				</c:if>
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
			<c:if test="${sessionScope.usuario.rol.nombre == 'ADMIN'}">
				<td><a class="btn btn-primary btn-sm" href="admin/producto">Añadir</a>
			</c:if>
			
			
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>