package com.ipartek.formacion.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.spring.pojos.Empleado;

public interface EmpleadoRepo extends JpaRepository<Empleado, Long>{

}
