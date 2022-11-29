package com.ipartek.formacion.mf0966ejemplo.carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.mf0966ejemplo.carrito.InicializarCarrito.Lista;
import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;


@WebServlet("/addCarrito")
@Log
public class AnadirCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CARRITO="carrito";
       
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("UTF-8");
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
		
		
		
		response.sendRedirect(request.getContextPath() + "/admin/productos");*/
	
	} 
	
	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String cantidadString = request.getParameter("cantidad");

		int tamCarrito=0;
		
		if (id != null) {
			Integer cantidad = 1;
			
			if(cantidadString != null) {
				try {
					cantidad = Integer.parseInt(cantidadString);
				} catch (NumberFormatException e) {
					log.warning("Se ha recibido una cantidad " + cantidadString);
				}
			}
			
			Pedido pedido = (Pedido) request.getSession().getAttribute(CARRITO);

			Producto producto = Globales.DAO_PRODUCTO.obtenerPorId(Long.parseLong(id));

			pedido.guardar(cantidad, producto);

			
			for(Lista li:pedido.getLineas()) {
				tamCarrito=tamCarrito+li.getCantidad();
			}
			request.getSession().setAttribute("carritoLenght",tamCarrito);
			

			log.info(() -> "Se ha recibido el id " + id);
			log.info(producto::toString);

		} else {
			log.warning("No se ha recibido id en el Post");
		}

		response.sendRedirect(request.getContextPath() + "/carrito");
	}

}
