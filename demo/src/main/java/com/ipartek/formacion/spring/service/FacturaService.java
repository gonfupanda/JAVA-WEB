package com.ipartek.formacion.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.accesodatos.Dao;
import com.ipartek.formacion.spring.pojos.Factura;
import com.ipartek.formacion.spring.repos.FacturaRepo;

@Service
public class FacturaService implements Dao<Factura> {
	
	
    private FacturaRepo facturas;
	
	
	public FacturaService(FacturaRepo usuarios) {
		super();
		this.facturas=usuarios;

	}

    public List<Factura> obtenerTodos() {
        return facturas.findAll();
    }
    
    public Factura findId(Long a) {
    	Optional<Factura> u=facturas.findById(a);
    	if (u.isPresent()) {
    		return u.get();
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
        
    }
    public Factura insertar(Factura a) {
    	
    	facturas.save(a);
		return a;
    	
    }

}
