package com.ipartek.formacion.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.pojos.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Long> {

}
