package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Autor;

import lombok.extern.java.Log;



@RepositoryRestResource(path = "autores", collectionResourceRel = "autores")
public interface AutorRest extends PagingAndSortingRepository<Autor, Long>, CrudRepository<Autor,Long> {

	public Autor findByNombre(String nombre);

}
