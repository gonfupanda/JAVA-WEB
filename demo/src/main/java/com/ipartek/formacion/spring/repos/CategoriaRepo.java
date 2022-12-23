package com.ipartek.formacion.spring.repos;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.pojos.Categoria;

@RepositoryRestResource(path = "categorias", collectionResourceRel = "categorias")
public interface CategoriaRepo extends PagingAndSortingRepository<Categoria, Long>, CrudRepository<Categoria,Long> {

}
