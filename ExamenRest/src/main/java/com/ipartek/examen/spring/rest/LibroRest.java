package com.ipartek.examen.spring.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.examen.spring.pojos.Libro;
import com.ipartek.examen.spring.repo.LibroRepo;

@Service
public class LibroRest implements LibroService {
	
	@Autowired
	private LibroRepo repo;

	@Override
	public Iterable<Libro> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Libro findByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

	@Override
	public Libro findByIsbn(String isbn) {
		return repo.findByIsbn(isbn);
	}

	@Override
	public Libro obtenerPorId(Long id) {
	
		return repo.findById(id).orElse(null);
	}
	
	

}
