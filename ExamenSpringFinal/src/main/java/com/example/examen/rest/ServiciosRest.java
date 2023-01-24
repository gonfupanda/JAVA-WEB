package com.example.examen.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entidades.Servicio;
import com.example.examen.repos.ServicioRepo;

import lombok.extern.java.Log;

@Service
@Log
public class ServiciosRest implements ServiciosService {
	
	@Autowired
	private ServicioRepo repo;
	@Override
	public Iterable<Servicio> obtenerTodos() {
		return   repo.findAll();
	}

}
