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
import com.ipartek.formacion.spring.pojos.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRest {
	
private Dao<Cliente> us;
	
	public ClienteRest(Dao<Cliente> us) {
		super();
		this.us=us;
	}

	@GetMapping
	public Iterable<Cliente> obtenerClientes() {
		
		return us.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Cliente obtenerPorId(@PathVariable Long id) {
		Cliente u =  us.findId(id);
		
		if(u == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return u;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente insertar(@RequestBody Cliente cli) {

		return us.insertar(cli);
	}

}
