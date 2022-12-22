package com.ipartek.formacion.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.pojos.Factura;

public interface FacturaRepo extends JpaRepository<Factura, Long> {

}
