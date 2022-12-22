package com.ipartek.formacion.spring.rest;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

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
import com.ipartek.formacion.spring.pojos.Usuario;
import com.ipartek.formacion.spring.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRest {
	private Dao<Usuario> us;
	

	public UsuarioRest(Dao<Usuario> us) {
		super();
		this.us=us;
	}

	@GetMapping
	public Iterable<Usuario> obtenerPersonas() {
		
		return us.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Usuario obtenerPorId(@PathVariable Long id) {
		Usuario u =  us.findId(id);
		
		if(u == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return u;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario insertar(@RequestBody Usuario usu) {

		return us.insertar(usu);
	}
}
