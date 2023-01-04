package com.ipartek.formacion.spring.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ipartek.formacion.spring.pojos.Pedido;
import com.ipartek.formacion.spring.service.CarritoService;
import com.ipartek.formacion.spring.service.ProductoService;

@Controller
@RequestMapping("/")
@SessionAttributes("carrito")
public class IndexController {

	@ModelAttribute("carrito")
	public Pedido getCarrito() {
		return new Pedido();
	}
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CarritoService carritoService;

	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", productoService.obtenerTodos());
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
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

	@GetMapping("/cerrar-sesion")
	public String abandonarCarrito(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
}
