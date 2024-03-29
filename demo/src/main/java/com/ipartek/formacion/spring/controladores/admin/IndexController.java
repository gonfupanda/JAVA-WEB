package com.ipartek.formacion.spring.controladores.admin;


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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ipartek.formacion.spring.pojos.Cliente;
import com.ipartek.formacion.spring.pojos.Factura;
import com.ipartek.formacion.spring.pojos.Pedido;
import com.ipartek.formacion.spring.pojos.Usuario;
import com.ipartek.formacion.spring.service.CarritoService;
import com.ipartek.formacion.spring.service.ClienteService;
import com.ipartek.formacion.spring.service.FacturaService;
import com.ipartek.formacion.spring.service.ProductoService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/")
@SessionAttributes({ "carrito"})
public class IndexController  extends GlobalController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;

	@ModelAttribute("carrito")
	public Pedido getCarrito() {
		return new Pedido();
	}


	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private CarritoService carritoService;
	
	@Autowired
	private FacturaService facturaService;

	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", productoService.obtenerTodos());
		return "index";
	}

	@GetMapping("/login")
	public String login(Usuario usuario, Model modelo) {
		modelo.addAttribute("clientes",clienteService.obtenerTodos());
		return "login";
	}

	@PostMapping("/registro")
	public String registro(HttpSession session, @ModelAttribute("usuarioForm") @Valid Usuario usuario, BindingResult bindingResult) {
		log.info(usuario.toString());
		

		if (bindingResult.hasErrors()) {
			return "login";
		}

		String password = usuario.getPassword();
		
		usuario.setPassword(passwordEncoder.encode(password));
		
		usuarioService.registrar(usuario);
		
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

	@GetMapping("/carrito")
	public String verCarrito() {
		return "carrito";
	}

	@PostMapping("/carrito")
	public String agregarProductoACarrito(Long id, Integer cantidad, @SessionAttribute Pedido carrito) {
		carritoService.guardarProductoEnCarrito(id, cantidad, carrito);

		return "redirect:/carrito";
	}

	@GetMapping("/confirmacion")
	public String confirmacion(@ModelAttribute Usuario usuario) {
		if (usuario == null || usuario.getCliente() == null) {
			return "redirect:/alta-cliente";
		}

		return "confirmacion";
	}

	@GetMapping("/alta-cliente")
	public String altaCliente(Cliente cliente) {
		return "alta-cliente";
	}

	@PostMapping("/alta-cliente")
	public String altaClientePost(@ModelAttribute Usuario usuario, @Valid Cliente cliente,
			BindingResult bindingResult, Model modelo) {
		if (bindingResult.hasErrors()) {
			return "alta-cliente";
		}

		modelo.addAttribute("usuario", usuarioService.altaDatosCliente(usuario.getId(), cliente));

		return "redirect:/confirmacion";
	}

	@GetMapping("/cerrar-sesion")
	public String abandonarCarrito(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	@GetMapping("/quitar-del-carrito/{id}")
	public String quitarDelCarrito(@PathVariable Long id, @SessionAttribute Pedido carrito) {
		carrito.getLineasPorId().remove(id);

		return "redirect:/carrito";
	}
	
	@GetMapping("/factura")
	public String factura(@SessionAttribute Pedido carrito, @ModelAttribute Usuario usuario, Model modelo) {
		Factura factura = facturaService.obtenerFactura(carrito, usuario.getCliente());
		facturaService.guardarFactura(factura);

		modelo.addAttribute(factura);

		return "factura";
	}
}
