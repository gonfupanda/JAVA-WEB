<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 g-3">
	<c:forEach items="${libros}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="${p.imagen}" class="card-img-top" alt="...">
				<div class="card-body">
					<hr></hr>
					<p class="card-title">${p.nombre}</p>
					<%-- <link rel="icon" type="image/x-icon" href="/images/favicon.ico">--%>
					<p class="card-text">
						<strong>${p.autor}</strong>
					</p>
					<c:if test="${p.descuento > 0}">
						<a> <a class="card-text" style="color: red;">${p.getPrecioFinal()}€&nbsp;</a>
							<del>
								<a class="card-text" style="color: grey">${p.precio}€</a>
							</del> <a style="background-color: red; color: white;">&nbsp;&nbsp;-&nbsp;${p.descuento}%</a>
						</a>
					</c:if>
					<c:if test="${p.descuento == 0}">
						<p class="card-text">${p.precio}€</p>
					</c:if>
				</div>
				<div class="card-footer">
					<small class="text-muted">${p.id}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<br>
<br>
<br>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>