package com.ipartek.formacion.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.pojos.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Long>{

}
