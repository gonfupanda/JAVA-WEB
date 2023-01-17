package com.ipartek.examen.spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Libro;

@RepositoryRestResource(path = "libros", collectionResourceRel = "libros")
public interface LibroRepo extends  CrudRepository<Libro,Long> {
	public Libro findByNombre(String nombre);
	public Libro findByIsbn(String isbn);
	

}
