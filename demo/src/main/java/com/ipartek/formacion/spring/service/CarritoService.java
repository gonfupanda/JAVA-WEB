package com.ipartek.formacion.spring.service;

import com.ipartek.formacion.spring.pojos.Pedido;

public interface CarritoService {

	void guardarProductoEnCarrito(Long id, Integer cantidad, Pedido pedido);

}
