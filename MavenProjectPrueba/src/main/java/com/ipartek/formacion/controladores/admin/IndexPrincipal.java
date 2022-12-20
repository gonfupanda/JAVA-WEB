package com.ipartek.formacion.controladores.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ipartek.formacion.controladores.Globales;

@WebServlet("/index")
public class IndexPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("productos", Globales.DAO_PRODUCTO.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
