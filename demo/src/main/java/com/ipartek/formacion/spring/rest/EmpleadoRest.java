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
import com.ipartek.formacion.spring.pojos.Empleado;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRest {
	
private Dao<Empleado> us;
	
	public EmpleadoRest(Dao<Empleado> us) {
		super();
		this.us=us;
	}

	@GetMapping
	public Iterable<Empleado> obtenerEmpleados() {
		
		return us.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Empleado obtenerPorId(@PathVariable Long id) {
		Empleado u =  us.findId(id);
		
		if(u == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return u;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado insertar(@RequestBody Empleado cli) {

		return us.insertar(cli);
	}

}
