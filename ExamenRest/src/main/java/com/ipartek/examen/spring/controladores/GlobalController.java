package com.ipartek.examen.spring.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ipartek.examen.spring.pojos.Usuario;
import com.ipartek.examen.spring.rest.UsuarioService;



public class GlobalController {

	public GlobalController() {
		super();
	}

	@Autowired UsuarioService usuarioService;

	@ModelAttribute("usuarioLogin")
	public Usuario getUsuario(Principal principal) {
		System.out.println(principal);
		if (principal == null) {
			return null;
		}

		String email = principal.getName();

		return usuarioService.obtenerPorEmail(email);
	}
}
