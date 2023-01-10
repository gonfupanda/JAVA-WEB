package com.ipartek.formacion.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ipartek.formacion.spring.pojos.Cliente;
import com.ipartek.formacion.spring.pojos.Usuario;

public interface UsuarioService {

	Usuario buscarPorEmail(String email);
	Usuario altaDatosCliente(Long idUsuario, Cliente cliente);
	Usuario registrar(Usuario usuario);

}


