package com.ipartek.formacion.controladores.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

import java.io.IOException;

import com.ipartek.formacion.carrito.InicializarCarrito.Lista;
import com.ipartek.formacion.controladores.Globales;
import com.ipartek.formacion.modelos.Producto;

@Log
@WebServlet("/carrito")
public class ListadoCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CARRITO = "carrito";
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
		 log.info(() -> "Se ha recibido el carrito " + session.getAttribute(CARRITO));
		request.setAttribute(CARRITO, session.getAttribute(CARRITO));
		request.getRequestDispatcher("/WEB-INF/vistas/admin/carrito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {

			Producto producto = Globales.DAO_PRODUCTO.obtenerPorId(Long.parseLong(id));


			log.info(() -> "Se ha recibido el id " + id);
			log.info(producto::toString);

		} else {
			log.warning("No se ha recibido id en el Post");
		}

		response.sendRedirect(request.getContextPath() + "/carrito");
	}

}
