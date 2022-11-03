<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form>
  <fieldset disabled>
    <legend>Disabled fieldset example</legend>
    <div class="mb-3">
	    <label for="Id" class="form-label">Id</label>
		<input type="number" id="Id" class="form-control" aria-describedby="passwordHelpBlock">
		<div id="passwordHelpBlock" class="form-text">
		 id
		</div>
    </div>
   <div class="mb-3">
	    <label for="Nombre" class="form-label">Nombre</label>
		<input type="text" id="Nombre" class="form-control" aria-describedby="passwordHelpBlock">
		<div id="passwordHelpBlock" class="form-text">
		  nombre
		</div>
    </div>
    <div class="mb-3">
	    <label for="Precio" class="form-label">Precio</label>
		<input type="number" id="Precio" class="form-control" aria-describedby="passwordHelpBlock">
		<div id="passwordHelpBlock" class="form-text">
		precio
		</div>
    </div>
    <div class="mb-3">
	    <label for="Cantidad" class="form-label">Cantidad</label>
		<input type="number" id="Cantidad" class="form-control" aria-describedby="passwordHelpBlock">
		<div id="passwordHelpBlock" class="form-text">
		  cantidad
		</div>
    </div>
      
    <button type="submit" class="btn btn-primary">Submit</button>
  </fieldset>
</form>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>