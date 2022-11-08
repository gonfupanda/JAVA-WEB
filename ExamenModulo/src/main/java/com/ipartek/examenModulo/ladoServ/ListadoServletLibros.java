package com.ipartek.examenModulo.ladoServ;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ipartek.examenModulo.capas.entidades.Libro;

import static com.ipartek.examenModulo.ladoServ.Globales.dao;

/**
 * Servlet implementation class ListadoServletLibros
 */
@WebServlet("/index")
public class ListadoServletLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Iterable<Libro> libros = dao.obtenerTodos();
		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setAttribute("libros", libros);
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
