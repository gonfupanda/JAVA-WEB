package com.ipartek.formacion.mf0967.doscapas.accesodatos;

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

