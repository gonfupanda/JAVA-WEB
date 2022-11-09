package com.ipartek.examen.capas.acceso;

import java.sql.SQLException;

//Data Access Object
public interface Dao<T> {
	// CRUD
	// Create Retrieve Update Delete
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id) throws SQLException;
	
	T insertar(T objeto);
	T modificar(T objeto);
	void borrar(Long id);
}
