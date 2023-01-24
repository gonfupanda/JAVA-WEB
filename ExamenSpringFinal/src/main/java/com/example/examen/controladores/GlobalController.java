package com.example.examen.controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.examen.entidades.Inmueble;
import com.example.examen.rest.InmuebleService;
import com.example.examen.rest.ServiciosService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/")
public class GlobalController {

	public static final String UPLOAD_DIRECTORY = getResourceAsFile("static/imgs").getAbsolutePath(); //

	public static final String INMUEBLES = "inmuebles";
	public static final String INMUEBLE = "inmueble";
	public static final String INDEX = "index";

	@Autowired
	private InmuebleService inmuebleService;
	@Autowired
	private ServiciosService serviciosService;

	@GetMapping
	public String index(Model modelo) {
		if (modelo.getAttribute(INMUEBLES) == null) {
			modelo.addAttribute(INMUEBLES, inmuebleService.obtenerTodos());
		}

		return INDEX;
	}

	@GetMapping("/index")
	public String indexx(Model modelo) {
		modelo.getAttribute(INMUEBLES);
		return INDEX;
	}

	@GetMapping("/alquiler")
	public String alquiler(Model modelo) {
		modelo.addAttribute(INMUEBLES, inmuebleService.obtenerAlquiler());
		return INDEX;
	}

	@GetMapping("/ventas")
	public String ventas(Model modelo) {
		modelo.addAttribute(INMUEBLES, inmuebleService.obtenerVenta());
		return INDEX;
	}

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Long id, Model modelo) {
		log.info(String.valueOf(id));
		modelo.addAttribute("vivienda", inmuebleService.obtenerid(id));
		modelo.addAttribute(INMUEBLES, inmuebleService.obtenerTodos());
		return INDEX;
	}

	@PostMapping("/nombre")
	public String porNombre(Model modelo, @PathVariable(required = false) String nombre, Inmueble in) {

		modelo.addAttribute(INMUEBLES, inmuebleService.obtenerNombre(in.getNombre()));

		return INDEX;
	}

	@GetMapping("/inmueble")
	public String inmueblee(Model modelo, @PathVariable(required = false) String nombre, Inmueble in) {
		modelo.addAttribute("servicios", serviciosService.obtenerTodos());

		return INMUEBLE;
	}

	@PostMapping("/crear")
	public String crear(@Valid Inmueble innmu, BindingResult bindingResult, Model modelo,@RequestParam("imagen") MultipartFile imagen, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {

			return INMUEBLE;
		}
		inmuebleService.insertar(innmu);
		
		String nombre = imagen.getOriginalFilename();
		if (nombre != null && nombre.trim().length() != 0) {

			Path ruta = Paths.get(UPLOAD_DIRECTORY, innmu.getId() + ".jpg");
			try {
				log.info(ruta.toString());
				Files.write(ruta, imagen.getBytes());
			} catch (IOException e) {
				log.throwing(GlobalController.class.getName(), "guardarImagen", e);
				return "admin/producto";
			}
		}
		modelo.addAttribute("mensaje", "Inmueble insertado");
		modelo.addAttribute("nivel", "succes");

		return INDEX;
	}

	@PostMapping("/precio")
	public String precio(Model modelo, Integer min, Integer max, Inmueble in, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (min==null ||max==null) {
			modelo.addAttribute("mensaje", "Ambos campos deben estar rellenos");
			modelo.addAttribute("nivel", "danger");
			modelo.addAttribute(INMUEBLES, inmuebleService.obtenerTodos());

			return INDEX;
		}
		log.info(String.valueOf(min));
		log.info(String.valueOf(max));
		modelo.addAttribute(INMUEBLES, inmuebleService.obtenerPorPrecio(min, max));
		return INDEX;
	}
	
	@GetMapping("/resumen")
	public String resumen(Model modelo) {
		modelo.addAttribute(INMUEBLES, inmuebleService.obtenerPorNombreOrdenado());
		modelo.addAttribute("Primercocina", inmuebleService.primeroConCocina());
		modelo.addAttribute("total", inmuebleService.totalHabitaciones3());
		modelo.addAttribute("servicios", serviciosService.obtenerTodos());
		
		return "resumenDatos";
	}

	/// APARTADO PARA LAS IMG
	public static File getResourceAsFile(String relativeFilePath) {
		try {
			return ResourceUtils.getFile(String.format("classpath:%s", relativeFilePath));
		} catch (FileNotFoundException e) {
			log.throwing(GlobalController.class.getName(), "getResourceAsFile", e);
			return null;
		}
	}

}
