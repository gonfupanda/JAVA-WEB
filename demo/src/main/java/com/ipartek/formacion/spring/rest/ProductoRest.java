package com.ipartek.formacion.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.pojos.Producto;
import com.ipartek.formacion.spring.repos.ProductoRepo;
import com.ipartek.formacion.spring.service.ProductoService;

@Service
public class ProductoRest implements ProductoService {
	
	@Autowired
	private ProductoRepo repo;

	@Override
	public Iterable<Producto> obtenerTodos() {
		return repo.findAll();
	}

}
