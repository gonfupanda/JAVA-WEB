package com.ipartek.examenModulo.ladoServ.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.ipartek.examenModulo.ladoServ.Globales.dao;

import java.io.IOException;

import com.ipartek.examenModulo.capas.entidades.Libro;

@WebServlet("/admin/libro")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean repe = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {//El libro existe, carga los datos
			request.setAttribute("alertaNivel", "warning");
			request.setAttribute("alertaMensaje", "Estas editando un libro existente");
			Libro libro = dao.obtenerPorId(Long.parseLong(id));

			request.setAttribute("libro", libro);
		}
		request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Iterable<Libro> libros = dao.obtenerTodos();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");
		String autor = request.getParameter("autor");
		String imagen = request.getParameter("imagen");

		Libro libro = new Libro(id, nombre, precio, descuento, autor, imagen);

		this.repe = false;
		libros.forEach((e) -> {
			if (e.getId().equals(Long.parseLong(id))) {
				this.repe = true;
			}
		});
		
		
		if (libro.getErrores().size() > 0 ) {
			
			request.setAttribute("alertaNivel", "danger");
			request.setAttribute("alertaMensaje", "Hay errores en el formulario");
			request.setAttribute("producto", libro);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
		} else if(!this.repe){
			dao.insertar(libro);
			response.sendRedirect(request.getContextPath() + "/index");
		}else {
			dao.modificar(libro);
			response.sendRedirect(request.getContextPath() + "/index");
		}

	}

}
