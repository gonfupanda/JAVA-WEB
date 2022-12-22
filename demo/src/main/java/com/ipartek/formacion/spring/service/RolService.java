package com.ipartek.formacion.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.accesodatos.Dao;
import com.ipartek.formacion.spring.pojos.Rol;
import com.ipartek.formacion.spring.repos.RolRepo;

@Service
public class RolService implements Dao<Rol>{
	
    private RolRepo roles;
	
	
	public RolService(RolRepo roles) {
		super();
		this.roles=roles;

	}
    public List<Rol> obtenerTodos() {
        return roles.findAll();
    }
    
    public Rol findId(Long a) {
    	Optional<Rol> u=roles.findById(a);
    	if (u.isPresent()) {
    		return u.get();
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        
    }
    public Rol insertar(Rol a) {	
    	roles.save(a);
		return a;
    	
    }

}
