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
import com.ipartek.formacion.spring.pojos.Producto;

@RestController
@RequestMapping("/api/productos")
public class ProductoRest {
private Dao<Producto> us;
	
	public ProductoRest(Dao<Producto> us) {
		super();
		this.us=us;
	}

	@GetMapping
	public Iterable<Producto> obtenerProductos() {
		
		return us.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Producto obtenerPorId(@PathVariable Long id) {
		Producto u =  us.findId(id);
		
		if(u == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return u;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Producto insertar(@RequestBody Producto cli) {

		return us.insertar(cli);
	}

}
