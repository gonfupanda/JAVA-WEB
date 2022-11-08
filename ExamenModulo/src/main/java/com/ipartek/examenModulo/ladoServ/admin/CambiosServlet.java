package com.ipartek.examenModulo.ladoServ.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ipartek.examenModulo.capas.entidades.Libro;
import static com.ipartek.examenModulo.ladoServ.Globales.dao;

@WebServlet("/admin/index")
public class CambiosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Libro> libros = dao.obtenerTodos();
		
		request.setAttribute("libros", libros);		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/index.jsp").forward(request, response);
	}

}
