package com.ipartek.examen.ladoServ.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.ipartek.examen.ladoServ.Globales.daoCrud;

@WebServlet("/admin/libro/borrar")
public class BorrarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		daoCrud.borrar(Long.parseLong(id));
		
		response.sendRedirect(request.getContextPath() + "/index");
	}

}
