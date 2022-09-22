package com.ipartek.gonza.objetos.pojos;

public class Persona {
	private long id;
	private String nombre;
	
	//CONTRUCTORES
	public Persona() {}	
	public Persona(long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	//GETTERS Y SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {	
		if( id < 0  ) {
			throw new RuntimeException("No se admiten Id negativos");
		}
		this.id = id;	
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new NullPointerException("No se admiten nulos"+nombre);
		}
		if(nombre.trim().length() == 0) {
			throw new NullPointerException("No se admiten nombres vacios");
		}
		this.nombre = nombre;
	}



}
