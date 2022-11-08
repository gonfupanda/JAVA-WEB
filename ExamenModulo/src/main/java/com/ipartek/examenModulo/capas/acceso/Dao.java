package com.ipartek.examenModulo.capas.acceso;

//Data Access Object
public interface Dao<T> {
	// CRUD
	// Create Retrieve Update Delete
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T objeto);
	T modificar(T objeto);
	void borrar(Long id);
}
