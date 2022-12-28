package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Alumno;

@RepositoryRestResource(path = "alumnos", collectionResourceRel = "alumnos")
public interface AlumnoRest extends PagingAndSortingRepository<Alumno, Long>, CrudRepository<Alumno,Long> {

}
