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
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index=0;
		boolean esta=false;
		Long id_prod = Long.parseLong(request.getParameter("id"));
		
		ArrayList<Lista>b=(ArrayList<Lista>) request.getSession().getAttribute("carrito");
				
		for(Lista li:b) {
			
			if(li.getProd().getId().equals(id_prod)) {
				esta=true;
				break;
				
				
			}else {
				index++;
			}
		}
		if(b.get(index).getCantidad()!=1) {
			((ArrayList<Lista>)request.getSession().getAttribute("carrito")).get(index).setCantidad(b.get(index).getCantidad()-1);
		}else {
			((ArrayList<Lista>)request.getSession().getAttribute("carrito")).remove(index);
			request.setAttribute("alertaMensaje", "Producto eliminado del carrito");
			request.setAttribute("alertaNivel", "danger");
			
		}
		 request.getSession().setAttribute("carritoLenght",b.size());
		response.sendRedirect(request.getContextPath() + "/carrito");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
