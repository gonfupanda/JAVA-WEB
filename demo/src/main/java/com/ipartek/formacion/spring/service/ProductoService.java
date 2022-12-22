package com.ipartek.formacion.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.pojos.Producto;
import com.ipartek.formacion.spring.repos.ProductoRepo;

@Service
public class ProductoService {

    private ProductoRepo cat;
	
	
	public ProductoService(ProductoRepo roles) {
		super();
		this.cat=roles;

	}
    public List<Producto> obtenerTodos() {
        return cat.findAll();
    }
    
    public Producto findId(Long a) {
    	Optional<Producto> u=cat.findById(a);
    	if (u.isPresent()) {
    		return u.get();
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        
    }
    public Producto insertar(Producto a) {	
    	cat.save(a);
		return a;
    	
    }
}
