package com.example.examen.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.examen.entidades.Servicio;

@Repository
public interface ServicioRepo   extends CrudRepository<Servicio, Long>{

}
