package com.ipartek.formacion.spring.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.service.ProductoService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private ProductoService servicio;

	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", servicio.obtenerTodos());
		return "index";
	}
}
