package com.ipartek.formacion.spring.service;

import com.ipartek.formacion.spring.pojos.Producto;

public interface ProductoService {
	public Iterable<Producto> obtenerTodos();

	public Producto obtenerPorId(Long id);

	public void borrar(Long id);

	public Producto insertar(Producto producto);
	
	public Producto modificar(Producto producto);
}
