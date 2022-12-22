package com.ipartek.formacion.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.accesodatos.Dao;
import com.ipartek.formacion.spring.pojos.Cliente;
import com.ipartek.formacion.spring.repos.ClienteRepo;

@Service
public class ClienteService implements Dao<Cliente> {
	
    private ClienteRepo cat;
	
	
	public ClienteService(ClienteRepo roles) {
		super();
		this.cat=roles;

	}
    public List<Cliente> obtenerTodos() {
        return cat.findAll();
    }
    
    public Cliente findId(Long a) {
    	Optional<Cliente> u=cat.findById(a);
    	if (u.isPresent()) {
    		return u.get();
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        
    }
    public Cliente insertar(Cliente a) {	
    	cat.save(a);
		return a;
    	
    }

}
