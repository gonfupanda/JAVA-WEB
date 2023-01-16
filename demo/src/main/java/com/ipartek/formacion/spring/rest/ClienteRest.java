package com.ipartek.formacion.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.pojos.Cliente;
import com.ipartek.formacion.spring.repos.ClienteRepo;
import com.ipartek.formacion.spring.service.ClienteService;

@Service
public class ClienteRest implements ClienteService{
	
	@Autowired
	private ClienteRepo repo;

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return repo.findAll();
	}

}
