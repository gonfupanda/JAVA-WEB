package pruebas.clases.admin;

import java.io.IOException;

import capas.entidades.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static pruebas.clases.Globales.dao;//Importante para poder usar el dao

/**
 * Servlet implementation class IndexServletAdmin
 */
@WebServlet("/admin/index")
public class IndexServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Producto> productos = dao.obtenerTodos();
		
		request.setAttribute("productos", productos);		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/index.jsp").forward(request, response);
	}

}
