package com.ipartek.formacion.carrito;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.modelos.Pedido;
import com.ipartek.formacion.modelos.Producto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ESTA CLASE TIENE COMO OBJETIVO INICIALIZAR UNA ARRAY AL HACERSE LOGIN, ESTA ARRAY SERA EL CARRITO DONDE 
//INSERTAR LOS PRODUCTOS
public class InicializarCarrito implements HttpSessionListener {

	    ServletContext ctx=null;  
      
	    @Override
	    public void sessionCreated(HttpSessionEvent e) {  
		    e.getSession().setAttribute("carrito",new Pedido() );
		    e.getSession().setAttribute("carritoLenght",0 );

      
	    } 


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Lista {
		private Producto prod;
		private int cantidad;
		
		public BigDecimal getTotal() {
			return this.prod.getPrecio().multiply(new BigDecimal(cantidad));
		}
	}
	
}
