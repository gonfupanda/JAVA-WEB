package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Libro;

@RepositoryRestResource(path = "libros", collectionResourceRel = "libros")
public interface LibroRest extends PagingAndSortingRepository<Libro, Long>, CrudRepository<Libro,Long> {
	
	public Libro findByNombre(String nombre);


}
