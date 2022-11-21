package com.ipartek.formacion.mf0966ejemplo.controladores.admin;

import java.io.IOException;
import java.math.BigDecimal;

import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String id = request.getParameter("id");

			if ( id != null && id!="" ) {
				Producto producto = Globales.DAO_PRODUCTO.obtenerPorId(Long.parseLong(id));
				request.setAttribute("producto", producto);
			}

			Iterable<Categoria> categorias = Globales.DAO_CATEGORIA.obtenerTodos();

			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String categoria = request.getParameter("categoria");
		String descripcion = request.getParameter("descripcion");
		Categoria c=Globales.DAO_CATEGORIA.obtenerPorId(Long.parseLong(categoria));
		Producto p;
		
		
		
		if ( id == null || id=="" ) {
			p=new Producto(null,nombre,new BigDecimal(precio),descripcion,c);
			
			Globales.DAO_PRODUCTO.insertar(p);
	
		}else {
			p=new Producto(Long.parseLong(id),nombre,new BigDecimal(precio),descripcion,c);
			Globales.DAO_PRODUCTO.modificar(p);
	
		}
		
		Iterable<Categoria> categorias = Globales.DAO_CATEGORIA.obtenerTodos();

		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
	}

}
