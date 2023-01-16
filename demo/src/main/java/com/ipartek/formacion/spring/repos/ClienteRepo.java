package com.ipartek.formacion.spring.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.pojos.Cliente;


@RepositoryRestResource(path = "clientes", collectionResourceRel = "clientes")
public interface ClienteRepo extends  CrudRepository<Cliente,Long>{
	

}
