package com.ipartek.formacion.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.pojos.Categoria;
import com.ipartek.formacion.spring.repos.CategoriaRepo;
import com.ipartek.formacion.spring.service.CategoriaService;

@Service
public class CategoriaRest implements CategoriaService {
	@Autowired
	private CategoriaRepo repo;
	
	@Override
	public Iterable<Categoria> obtenerTodas() {
		return repo.findAll();
	}

}
