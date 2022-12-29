package com.ipartek.formacion.spring.service;

import com.ipartek.formacion.spring.pojos.Producto;

public interface ProductoService {
	public Iterable<Producto> obtenerTodos();
}
