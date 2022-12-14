package com.ipartek.formacion.mf0966ejemplo.modelos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.ipartek.formacion.mf0966ejemplo.carrito.InicializarCarrito.Lista;


class TestPedido {
	@Test
	void guardar() {
		Pedido pedido = new Pedido();
		Producto producto = new Producto(1L, "Producto", null, null, null);
		
		pedido.guardar(0, producto);
		
		assertEquals(0, pedido.lineas.size());
		
		final int CANTIDAD = 5;
		
		pedido.guardar(CANTIDAD, producto);
		
		assertEquals(1, pedido.lineas.size());
		
		Lista linea = pedido.getLineasPorId().get(1L);
		
		assertNotNull(linea);
		
		Producto guardado = linea.getProd();
		
		assertNotNull(guardado);
		
		assertEquals(producto, guardado);
		
		assertEquals(CANTIDAD, linea.getCantidad());
		
		int OTRA_CANTIDAD = 10;
		
		pedido.guardar(OTRA_CANTIDAD, producto);
		
		assertEquals(OTRA_CANTIDAD, pedido.getLineasPorId().get(1L).getCantidad());
		
		pedido.guardar(0, producto);
		
		assertEquals(0, pedido.lineas.size());
	}

}
