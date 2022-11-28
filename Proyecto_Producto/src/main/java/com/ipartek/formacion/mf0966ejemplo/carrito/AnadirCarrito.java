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
	private static final String CARRITO="carrito";
       
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		boolean esta=false;
		int index=0;

		Long id = Long.parseLong(request.getParameter("id"));
		int cantidad=1;
		ArrayList<Lista>a=(ArrayList<Lista>) request.getSession().getAttribute(CARRITO);
		int tamCarrito=0;

		
		
		for(Lista li:a) {
			
			tamCarrito=tamCarrito+li.getCantidad();
			if(li.getProd().getId().equals(id)) {
				cantidad=li.getCantidad()+1;
				((ArrayList<Lista>)request.getSession().getAttribute(CARRITO)).get(index).setCantidad(cantidad);
				tamCarrito++;
				esta=true;
			}else {
				index++;
			}
		}
		if(!esta) {
			Lista l = new Lista(Globales.DAO_PRODUCTO.obtenerPorId(id),cantidad);
			
			if(request.getSession().getAttribute(CARRITO)!=null) {
				((ArrayList<Lista>)request.getSession().getAttribute(CARRITO)).add(l);
			}
			tamCarrito++;
			
		}
		 request.getSession().setAttribute("carritoLenght",tamCarrito);
		
		
		
		response.sendRedirect(request.getContextPath() + "/admin/productos");

		
	} 
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
