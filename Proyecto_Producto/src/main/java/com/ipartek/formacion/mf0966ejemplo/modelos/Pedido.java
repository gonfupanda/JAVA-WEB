package com.ipartek.formacion.mf0966ejemplo.modelos;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import com.ipartek.formacion.mf0966ejemplo.carrito.InicializarCarrito.Lista;


public class Pedido {
	protected TreeMap<Long, Lista> lineas = new TreeMap<>();
	
	public Iterable<Lista> getLineas() {
		return lineas.values();
	}
	
	public Map<Long, Lista> getLineasPorId() {
		return lineas;
	}
	
	public void guardar(Integer cantidad, Producto producto) {
		Long id = producto.getId();
		boolean estaProductoEnCarrito = lineas.containsKey(id);

		if (cantidad <= 0 && !estaProductoEnCarrito) {
			return;
		}

		if (!estaProductoEnCarrito) {
			lineas.put(producto.getId(), new Lista(producto, cantidad));
			return;
		}

		Lista linea = lineas.get(id);

		if (cantidad > 0) {
			linea.setCantidad(cantidad);
		} else {
			lineas.remove(id);
		}
	}
	public void eliminar(Producto producto) {
		lineas.remove(producto.getId());
	}

	public void vaciar() {
		lineas.clear();
	}
	public BigDecimal getTotal() {
		return lineas.values().stream()
				.map(Lista::getTotal)
				.filter(total -> total.compareTo(BigDecimal.ZERO) != 0)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
