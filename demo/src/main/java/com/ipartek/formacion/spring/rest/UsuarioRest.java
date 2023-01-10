package com.ipartek.formacion.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.pojos.Cliente;
import com.ipartek.formacion.spring.pojos.Rol;
import com.ipartek.formacion.spring.pojos.Usuario;
import com.ipartek.formacion.spring.repos.ClienteRepo;
import com.ipartek.formacion.spring.repos.RolRepo;
import com.ipartek.formacion.spring.repos.UsuarioRepo;
import com.ipartek.formacion.spring.service.ServiciosException;
import com.ipartek.formacion.spring.service.UsuarioService;

import lombok.extern.java.Log;

@Log
@Service
public class UsuarioRest implements UsuarioService{
	@Autowired
	private UsuarioRepo repoUsuario;

	@Autowired
	private ClienteRepo repoCliente;
	
	@Autowired
	private RolRepo repoRol;

	@Override
	public Usuario buscarPorEmail(String email) {
		return repoUsuario.findByEmail(email);
	}

	@Override
	public Usuario altaDatosCliente(Long idUsuario, Cliente cliente) {
		log.info(idUsuario.toString());

		log.info(cliente.toString());

		Usuario usuario = repoUsuario.findById(idUsuario).orElse(null);

		log.info(usuario.toString());

		if(usuario == null) {
			throw new ServiciosException("No se ha encontrado el usuario");
		}

		repoCliente.save(cliente);
		usuario.setCliente(cliente);
		repoUsuario.save(usuario);

		return usuario;
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		Rol rol = repoRol.findByNombre("USER");

		if(rol == null) {
			throw new ServiciosException("No se ha encontrado el rol de usuario");
		}

		usuario.setRol(rol);

		log.info("Se acaba de registrar el usuario " + usuario);

		return repoUsuario.save(usuario);
	}
	    
	   

}

