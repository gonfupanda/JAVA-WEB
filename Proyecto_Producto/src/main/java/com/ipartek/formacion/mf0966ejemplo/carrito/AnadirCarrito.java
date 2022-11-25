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
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		boolean esta=false;
		int index=0;

		Long id_prod = Long.parseLong(request.getParameter("id"));
		int cantidad=1;
		ArrayList<Lista>a=(ArrayList<Lista>) request.getSession().getAttribute("carrito");
		
		for(Lista li:a) {
			
			if(li.getProd().getId().equals(id_prod)) {
				cantidad=li.getCantidad()+1;
				((ArrayList<Lista>)request.getSession().getAttribute("carrito")).get(index).setCantidad(cantidad);
				esta=true;
			}else {
				index++;
			}
		}
		if(!esta) {
			Lista l = new Lista(Globales.DAO_PRODUCTO.obtenerPorId(id_prod),cantidad);
			
			if(request.getSession().getAttribute("carrito")!=null) {
				((ArrayList<Lista>)request.getSession().getAttribute("carrito")).add(l);
			}
			
		}
		 request.getSession().setAttribute("carritoLenght",a.size());
		
		
		
		response.sendRedirect(request.getContextPath() + "/admin/productos");

		
			//request.getSession().setAttribute("usuario", usuario);
			//response.sendRedirect(request.getContextPath() + "/index");
	} 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
