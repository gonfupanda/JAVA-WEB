package com.ipartek.formacion.mf0966ejemplo.carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.carrito.InicializarCarrito.Lista;

@WebServlet("/deleteCarrito")
public class BorrarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CARRITO="carrito";
       
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index=0;
		Long id = Long.parseLong(request.getParameter("id"));
		int tam=(int) request.getSession().getAttribute("carritoLenght")-1;
		
		ArrayList<Lista>b=(ArrayList<Lista>) request.getSession().getAttribute(CARRITO);
				
		for(Lista li:b) {
			
			if(li.getProd().getId().equals(id)) {
				break;					
			}else {
				index++;
			}
		}
		if(b.get(index).getCantidad()!=1) {
			((ArrayList<Lista>)request.getSession().getAttribute(CARRITO)).get(index).setCantidad(b.get(index).getCantidad()-1);
		}else {
			((ArrayList<Lista>)request.getSession().getAttribute(CARRITO)).remove(index);
			request.setAttribute("alertaMensaje", "Producto eliminado del carrito");
			request.setAttribute("alertaNivel", "danger");
			
		}
		 request.getSession().setAttribute("carritoLenght",tam);
		response.sendRedirect(request.getContextPath() + "/carrito");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
