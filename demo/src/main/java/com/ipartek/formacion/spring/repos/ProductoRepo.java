package com.ipartek.formacion.spring.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ipartek.formacion.spring.pojos.Producto;

@RepositoryRestResource(path = "productos", collectionResourceRel = "productos")
public interface ProductoRepo extends PagingAndSortingRepository<Producto, Long>, CrudRepository<Producto,Long> {

}
