package com.example.examen.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entidades.Inmueble;
import com.example.examen.repos.InmuebleRepo;

import lombok.extern.java.Log;
@Service
@Log
public class InmuebleRest implements InmuebleService{
	
	@Autowired
	private InmuebleRepo repo;
	
	@Override
	public Iterable<Inmueble> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Iterable<Inmueble> obtenerPorPrecio(int min,int max) {
		return repo.obtenerPorPrecio(min, max);
	}

	@Override
	public Iterable<Inmueble> obtenerNombre(String nombre) {
		return repo.obtenerNombre(nombre);
	}

	@Override
	public Iterable<Inmueble> obtenerNombreOPrecio(String nombre,String direccion) {
		log.info(nombre);
		log.info(direccion);
		return repo.findByNombreOrDireccion(nombre, direccion);
	}
	@Override
	public Inmueble insertar(Inmueble usuario) {
		if(usuario.getId() != null) {
			throw new ServiciosException("No se puede insertar un usuario con id");
		}
		return repo.save(usuario);
	}

	@Override
	public Inmueble obtenerid(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Iterable<Inmueble> obtenerAlquiler() {
		return repo.findAllAlquiler();
	}

	@Override
	public Iterable<Inmueble> obtenerVenta() {
		return repo.findAllVenta();
	}

	@Override
	public Iterable<Inmueble> obtenerPorNombreOrdenado() {
		return repo.obtenerPorNombreOrdenado();
	}

	@Override
	public Inmueble primeroConCocina() {
		return repo.primeroConCocina();
	}

	@Override
	public Double totalHabitaciones3() {
		return repo.totalHabitaciones3();
	}






}
