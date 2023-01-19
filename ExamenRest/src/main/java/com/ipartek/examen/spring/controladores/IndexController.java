package com.ipartek.examen.spring.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.examen.spring.pojos.Usuario;
import com.ipartek.examen.spring.rest.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.java.Log;





@Log
@Controller
@RequestMapping("/")
public class IndexController extends GlobalController{
	
	/////////////////////////   ZONA DE AUTENTICACION + ENCRIPTACION
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
	////////////////////////////////
	
	@GetMapping
	public String index(Model modelo) {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Usuario usuario, Model modelo) {
		modelo.addAttribute("usuarios",usuarioService.obtenerTodos());
		return "login";
	}
	
	@PostMapping("/registro")
	public String registro(HttpSession session, @ModelAttribute("usuarioForm") @Valid Usuario usuario, BindingResult bindingResult) {
		

		if (bindingResult.hasErrors()) {
			return "login";
		}

		String password = usuario.getPassword();
		
		usuario.setPassword(passwordEncoder.encode(password));
		
		usuarioService.insertar(usuario);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getEmail(), password);

		try {
			AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
			Authentication authentication = authenticationManager.authenticate(token);
			
			SecurityContext sc = SecurityContextHolder.getContext();
		    sc.setAuthentication(authentication);
		    
		    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
		} catch (Exception e) {
			log.severe("No se ha podido autenticar");
			log.throwing(IndexController.class.getName(), "registro", e);
		}
		
		return "redirect:/";
	}

}
