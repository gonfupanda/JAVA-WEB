package com.ipartek.formacion.spring.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ipartek.formacion.spring.pojos.*;

@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuarioRepo extends PagingAndSortingRepository<Usuario, Long>, CrudRepository<Usuario,Long> {
	

}
