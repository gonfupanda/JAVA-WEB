package com.ipartek.formacion.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.pojos.Producto;
import com.ipartek.formacion.spring.service.ProductoService;

@Controller
@RequestMapping("/admin/productos")
public class ProductosAdminController {

		@Autowired
		private ProductoService servicio;

		@GetMapping
		public String mostrarListado(Model modelo) {
			Iterable<Producto> productos = servicio.obtenerTodos();

			modelo.addAttribute("productos", productos);

			return "admin/productos";
		}
	}
