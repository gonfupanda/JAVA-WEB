package pruebas.clases.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import capas.entidades.Producto;
import static pruebas.clases.Globales.dao;//Importante para poder usar el dao

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/admin/producto")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String cantidad = request.getParameter("cantidad");
		String precio = request.getParameter("precio");
		String caducidad = request.getParameter("caducidad");

		Producto producto = new Producto(id, nombre, caducidad, precio, cantidad);

		if (producto.getErrores().size() > 0) {
			request.setAttribute("alertaNivel", "danger");
			request.setAttribute("alertaMensaje", "Hay errores en el formulario");
			request.setAttribute("producto", producto);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
		} else {
			if (producto.getId() == null) {
				dao.insertar(producto);
			} else {
				dao.modificar(producto);
			}
			
			response.sendRedirect(request.getContextPath() + "/admin/index");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Producto producto = dao.obtenerPorId(Long.parseLong(id));

			request.setAttribute("producto", producto);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
	}

}
