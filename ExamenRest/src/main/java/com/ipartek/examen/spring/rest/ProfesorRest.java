package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Profesor;

@RepositoryRestResource(path = "profesores", collectionResourceRel = "profesores")
public interface ProfesorRest extends PagingAndSortingRepository<Profesor, Long>, CrudRepository<Profesor,Long>  {

}
