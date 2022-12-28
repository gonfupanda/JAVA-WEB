package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Curso;

@RepositoryRestResource(path = "cursos", collectionResourceRel = "cursos")
public interface CursoRest extends PagingAndSortingRepository<Curso, Long>, CrudRepository<Curso,Long>{

}
