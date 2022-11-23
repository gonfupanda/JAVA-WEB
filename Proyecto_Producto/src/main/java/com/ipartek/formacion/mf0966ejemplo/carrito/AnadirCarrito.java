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


@WebServlet("/addCarrito")
public class AnadirCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id_prod = request.getParameter("id");
		String cantidad = request.getParameter("cantidad");
		Lista l = new Lista(Integer.parseInt(id_prod),Integer.parseInt(cantidad));
		
		((ArrayList<Lista>)request.getAttribute("carrito")).add(l);

		
			//request.getSession().setAttribute("usuario", usuario);
			//response.sendRedirect(request.getContextPath() + "/index");
	} 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
