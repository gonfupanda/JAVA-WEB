package com.ipartek.examen.ladoServ.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.ipartek.examen.ladoServ.Globales.daoCrud;

import com.ipartek.examen.capas.entidades.Libro;

@WebServlet("/admin/libro")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean repe = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Libro libro;
			try {
				libro = daoCrud.obtenerPorId(Long.parseLong(id));
				request.setAttribute("libro", libro);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Iterable<Libro> libros = daoCrud.obtenerTodos();

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");

		Libro libro = new Libro(id, nombre, precio, descuento);

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
			request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
		} else if(!this.repe){
			daoCrud.insertar(libro);
			response.sendRedirect(request.getContextPath() + "/index");
		}else {
			daoCrud.modificar(libro);
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}

}
