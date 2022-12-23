package com.ipartek.formacion.spring.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ipartek.formacion.spring.pojos.Rol;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RolRepo extends PagingAndSortingRepository<Rol, Long>, CrudRepository<Rol,Long>{
	

}
