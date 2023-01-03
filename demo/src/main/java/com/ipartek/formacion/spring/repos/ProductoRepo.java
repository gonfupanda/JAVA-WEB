package com.ipartek.formacion.spring.repos;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ipartek.formacion.spring.pojos.Producto;

//@RepositoryRestResource(path = "productos", collectionResourceRel = "productos")
public interface ProductoRepo extends  CrudRepository<Producto,Long> {
	
	@Query("from Producto p join fetch p.categoria")
	public Set<Producto> findAll();
	
	@Query("from Producto p join fetch p.categoria where p.id = :id")
	public Optional<Producto> findById(Long id);

}
