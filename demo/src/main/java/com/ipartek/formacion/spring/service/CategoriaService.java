package com.ipartek.formacion.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.accesodatos.Dao;
import com.ipartek.formacion.spring.pojos.Categoria;
import com.ipartek.formacion.spring.repos.CategoriaRepo;

@Service
public class CategoriaService  implements Dao<Categoria>{
	
    private CategoriaRepo cat;
	
	
	public CategoriaService(CategoriaRepo roles) {
		super();
		this.cat=roles;

	}
    public List<Categoria> obtenerTodos() {
        return cat.findAll();
    }
    
    public Categoria findId(Long a) {
    	Optional<Categoria> u=cat.findById(a);
    	if (u.isPresent()) {
    		return u.get();
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        
    }
    public Categoria insertar(Categoria a) {	
    	cat.save(a);
		return a;
    	
    }

}
