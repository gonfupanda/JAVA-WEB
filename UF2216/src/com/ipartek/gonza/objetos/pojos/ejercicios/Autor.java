package com.ipartek.gonza.objetos.pojos.ejercicios;

public class Autor {
	private String nombre;
	private String apellidos;
	/**
	 * @param nombre
	 * @param apellidos
	 */
	public Autor(String nombre, String apellidos) {
		setNombre(nombre);
		setApellidos(apellidos);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
}	
