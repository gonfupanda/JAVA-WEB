package com.ipartek.examen.spring.rest;

import com.ipartek.examen.spring.pojos.Libro;

public interface LibroService {
	public Iterable<Libro> obtenerTodos();
	
	public Libro findByNombre(String nombre);
	public Libro findByIsbn(String isbn);

	public Libro obtenerPorId(Long id);
}
