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
import com.ipartek.formacion.spring.pojos.Factura;
import com.ipartek.formacion.spring.pojos.Usuario;

@RestController
@RequestMapping("/api/facturas")
public class FacturaRest {
	private Dao<Factura> us;
	
	public FacturaRest(Dao<Factura> us) {
		super();
		this.us=us;
	}

	@GetMapping
	public Iterable<Factura> obtenerFacturas() {
		
		return us.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Factura obtenerPorId(@PathVariable Long id) {
		Factura u =  us.findId(id);
		
		if(u == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return u;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Factura insertar(@RequestBody Factura fac) {

		return us.insertar(fac);
	}

}