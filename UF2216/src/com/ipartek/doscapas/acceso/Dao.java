package com.ipartek.doscapas.acceso;

import com.ipartek.doscapas.entidad.Producto;

//Data acces object
public interface Dao<T> {
	
	//CRUD
	Iterable<T>obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T objeto);
	T modificar(T objeto);
	 void borrar(Long id);
}
