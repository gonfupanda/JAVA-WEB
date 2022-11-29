package com.ipartek.formacion.mf0966ejemplo.carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.carrito.InicializarCarrito.Lista;
import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

@WebServlet("/deleteCarrito")
public class BorrarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CARRITO="carrito";
       
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index=0;
		Long id = Long.parseLong(request.getParameter("id"));
		Producto prod=Globales.DAO_PRODUCTO.obtenerPorId(id);
		Pedido pedido= (Pedido) request.getSession().getAttribute(CARRITO);
		
		pedido.eliminar(prod);
		
		request.setAttribute("alertaMensaje", "Producto eliminado del carrito");
		request.setAttribute("alertaNivel", "danger");
			
		
		int tamCarrito=0;
		for(Lista li:pedido.getLineas()) {
			tamCarrito=tamCarrito+li.getCantidad();
		}
		request.getSession().setAttribute("carritoLenght",tamCarrito);
		response.sendRedirect(request.getContextPath() + "/carrito");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
