package com.ipartek.formacion.spring.controladores.admin;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ipartek.formacion.spring.pojos.Usuario;
import com.ipartek.formacion.spring.service.UsuarioService;

public class GlobalController {
	
	public GlobalController() {
		super();
	}

	@Autowired UsuarioService usuarioService;

	@ModelAttribute("usuario")
	public Usuario getUsuario(Principal principal) {
		if (principal == null) {
			return null;
		}

		String email = principal.getName();

		return usuarioService.buscarPorEmail(email);
	}

}
