package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ipartek.examen.spring.pojos.Imparticion;

@RepositoryRestResource(path = "imparticiones", collectionResourceRel = "imparticiones")
public interface ImparticionRest extends PagingAndSortingRepository<Imparticion, Long>, CrudRepository<Imparticion,Long> {

}
