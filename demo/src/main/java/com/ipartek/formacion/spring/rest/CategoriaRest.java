package com.ipartek.formacion.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.accesodatos.Dao;
import com.ipartek.formacion.spring.pojos.Categoria;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRest {
	
private Dao<Categoria> us;
	
	public CategoriaRest(Dao<Categoria> us) {
		super();
		this.us=us;
	}

	@GetMapping
	public Iterable<Categoria> obtenerRoles() {
		
		return us.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Categoria obtenerPorId(@PathVariable Long id) {
		Categoria u =  us.findId(id);
		
		if(u == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return u;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria insertar(@RequestBody Categoria rol) {

		return us.insertar(rol);
	}

}
