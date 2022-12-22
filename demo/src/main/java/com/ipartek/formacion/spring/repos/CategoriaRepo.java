package com.ipartek.formacion.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.pojos.Categoria;

public interface CategoriaRepo extends JpaRepository<Categoria, Long> {

}
