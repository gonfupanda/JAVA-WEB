package com.ipartek.formacion.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.pojos.Pedido;
import com.ipartek.formacion.spring.pojos.Producto;
import com.ipartek.formacion.spring.service.CarritoService;
import com.ipartek.formacion.spring.service.ProductoService;

@Service
public class CarritoRest implements CarritoService {
	
	@Autowired
	private ProductoService productoService;

	@Override
	public void guardarProductoEnCarrito(Long id, Integer cantidad, Pedido pedido) {
		Producto producto = productoService.obtenerPorId(id);

		if (pedido != null) {
			pedido.guardar(cantidad, producto);
		} else {
			throw new UnsupportedOperationException("¡No se ha encontrado el carrito!");
		}
	}

}
