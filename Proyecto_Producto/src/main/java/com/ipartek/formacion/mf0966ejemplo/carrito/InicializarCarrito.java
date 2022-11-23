package com.ipartek.formacion.mf0966ejemplo.carrito;

import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.carrito.InicializarCarrito.Lista;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ESTA CLASE TIENE COMO OBJETIVO INICIALIZAR UNA ARRAY AL HACERSE LOGIN, ESTA ARRAY SERA EL CARRITO DONDE 
//INSERTAR LOS PRODUCTOS
public class InicializarCarrito implements HttpSessionListener {

	    ServletContext ctx=null;  
	    static boolean logged=false; 
      
	    public void sessionCreated(HttpSessionEvent e) {  
		    logged=true;
		    ArrayList<Lista>carrito= new ArrayList<Lista>();
	      
		    ctx=e.getSession().getServletContext();  
		   // ((HttpSessionEvent) ctx).getSession().setAttribute("carrito",carrito);
		    ctx.setAttribute("carrito",carrito ); 
      
	    } 


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Lista {
		private int prod_id;
		private int cantidad;
	}
	
}
