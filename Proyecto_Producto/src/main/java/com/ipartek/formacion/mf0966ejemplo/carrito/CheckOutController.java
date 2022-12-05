package com.ipartek.formacion.mf0966ejemplo.carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

@WebServlet("/checkout")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Pedido pedido = (Pedido) session.getAttribute("carrito");
		
		Factura factura = new Factura(pedido);
		
		factura.setCliente(usuario.getCliente());
		factura.setFecha(LocalDate.now());
		factura.setEmpleado(Globales.DAO_EMPLEADO.obtenerPorId(2L));
		
		session.setAttribute("factura", factura);
		
		request.getRequestDispatcher("/WEB-INF/vistas/checkOut.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
