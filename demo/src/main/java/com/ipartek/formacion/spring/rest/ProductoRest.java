package com.ipartek.formacion.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.pojos.Producto;
import com.ipartek.formacion.spring.repos.ProductoRepo;
import com.ipartek.formacion.spring.service.ProductoService;
import com.ipartek.formacion.spring.service.ServiciosException;

@Service
public class ProductoRest implements ProductoService {
	
	@Autowired
	private ProductoRepo repo;
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		if(producto.getId() != null) {
			throw new ServiciosException("No se puede insertar un elemento con Id");
		}
		return repo.save(producto);
	}
	
	public Producto modificar(Producto producto) {
		if(producto.getId() == null) {
			throw new ServiciosException("No se puede modificar un elemento sin saber su Id");
		}
		return repo.save(producto);
	}
}
