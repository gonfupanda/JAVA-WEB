package com.ipartek.examen.spring.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.examen.spring.pojos.Cliente;

@RepositoryRestResource(path = "clientes", collectionResourceRel = "clientes")
public interface ClienteRest extends PagingAndSortingRepository<Cliente, Long>, CrudRepository<Cliente,Long> {

}
