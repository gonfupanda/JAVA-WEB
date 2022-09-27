package com.ipartek.gonza.objetos.pojos;

import java.util.ArrayList;
import java.util.List;

public class Espacio {

	private long id;
	private String nombre;
	private List<Persona> personas;
	
	
	/**
	 * @param id
	 * @param nombre
	 */
	public Espacio(long id, String nombre) {
		setId(id);
		setNombre(nombre);
		personas = new ArrayList<Persona>();
		
	}
	public Espacio(String nombre) {
		setNombre(nombre);
		personas = new ArrayList<Persona>();
	}
	//GETTER SETTER
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		
		if(nombre == null) {
			throw new NullPointerException("No se admiten nulos"+nombre);
		}
		if(nombre.trim().length() < 3) {
			throw new NullPointerException("No se admiten nombres con menos de 3 caracteres");
		}
		this.nombre = nombre;
	}
	
	//Control de la colleccion
	
	public void entrar(Persona p) {
		personas.add(p);
	}
	public void salir(Persona p) {
		personas.remove(p);
	}
	public Persona[] getPersonas(){
		return personas.toArray(new Persona[personas.size()]);
	}
	
	
}
