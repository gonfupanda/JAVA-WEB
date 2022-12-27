package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Resena;

@RepositoryRestResource(path = "resenas", collectionResourceRel = "resenas")
public interface ResenaRest extends PagingAndSortingRepository<Resena, Long>, CrudRepository<Resena,Long> {

}
