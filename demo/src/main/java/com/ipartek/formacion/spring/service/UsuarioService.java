package com.ipartek.formacion.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.accesodatos.Dao;
import com.ipartek.formacion.spring.pojos.Factura;
import com.ipartek.formacion.spring.pojos.Usuario;
import com.ipartek.formacion.spring.repos.UsuarioRepo;

@Service
public class UsuarioService implements Dao<Usuario>{
    private UsuarioRepo usuarios;
	
	
	public UsuarioService(UsuarioRepo usuarios) {
		super();
		this.usuarios=usuarios;

	}
    public List<Usuario> obtenerTodos() {
        return usuarios.findAll();
    }
    
    public Usuario findId(Long a) {
    	Optional<Usuario> u=usuarios.findById(a);
    	if (u.isPresent()) {
    		return u.get();
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        
    }
    public Usuario insertar(Usuario a) {
    	
    	usuarios.save(a);
		return a;
    	
    }

}
