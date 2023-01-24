package com.example.examen.rest;

import java.util.Optional;

import com.example.examen.entidades.Inmueble;

public interface InmuebleService {

	Iterable<Inmueble> obtenerTodos();
	Iterable<Inmueble> obtenerAlquiler();
	Iterable<Inmueble> obtenerVenta();
	Iterable<Inmueble> obtenerPorPrecio(int min,int max);
	Iterable<Inmueble> obtenerNombre(String nombre);
	Iterable<Inmueble> obtenerNombreOPrecio(String nombre,String direccion);
	Inmueble insertar(Inmueble usuario);
	public Inmueble obtenerid(Long id);
	Iterable<Inmueble> obtenerPorNombreOrdenado();
	public Inmueble primeroConCocina();
	public Double totalHabitaciones3();
	

}
