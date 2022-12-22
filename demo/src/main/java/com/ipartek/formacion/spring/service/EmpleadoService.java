package com.ipartek.formacion.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.pojos.Empleado;
import com.ipartek.formacion.spring.repos.EmpleadoRepo;

@Service
public class EmpleadoService {
	
    private EmpleadoRepo cat;
	
	
	public EmpleadoService(EmpleadoRepo roles) {
		super();
		this.cat=roles;

	}
    public List<Empleado> obtenerTodos() {
        return cat.findAll();
    }
    
    public Empleado findId(Long a) {
    	Optional<Empleado> u=cat.findById(a);
    	if (u.isPresent()) {
    		return u.get();
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        
    }
    public Empleado insertar(Empleado a) {	
    	cat.save(a);
		return a;
    	
    }

}
