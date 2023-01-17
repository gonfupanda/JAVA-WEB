package com.ipartek.examen.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.examen.spring.pojos.Libro;
import com.ipartek.examen.spring.rest.LibroService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private LibroService libroService;

	@GetMapping
	public String index(Model modelo) {

		Iterable<Libro> libros = libroService.obtenerTodos();
		modelo.addAttribute("libros", libros);

		return "index";
	}

	@GetMapping({ "/buscar" })
	public String buscar() {
		return "buscar";
	}

	@GetMapping({ "/libro", "/libro/{id}" })
	public String mostrarFormularioProducto(@PathVariable(required = false) Long id, Model modelo, Libro libro) {
		if (id != null) {
			modelo.addAttribute("libro", libroService.obtenerPorId(id));
		}

		return "libro";
	}

	@PostMapping({ "/buscar" })
	public String buscarLibroNombre(@PathVariable(required = false) String nombre, Model modelo, Libro libro) {
		String nom=null;
		if(libroService.findByNombre(libro.getNombre())!=null) {
			nom = libroService.findByNombre(libro.getNombre()).getNombre();
		}
		
		//String isbn = libroService.findByIsbn(libro.getNombre()).getIsbn();

		log.info("entro en buscarLibros");
		if (nom != null) {
			modelo.addAttribute("libro", libroService.findByNombre(nom));
			return "libro";
		}  else {
			String isbn=null;
			if(libroService.findByIsbn(libro.getNombre())!=null) {
				isbn = libroService.findByNombre(libro.getNombre()).getNombre();
			}
			if (isbn != null) {
				modelo.addAttribute("libro", libroService.findByIsbn(isbn));
				return "libro";
			} else {
				modelo.addAttribute("mensaje", "No se ha encontrado el libro con ese nombre o ISBN");
				modelo.addAttribute("nivel", "danger");
			}
		}
		

		return "buscar";
	}
}
