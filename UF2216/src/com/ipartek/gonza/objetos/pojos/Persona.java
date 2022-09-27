package com.ipartek.gonza.objetos.pojos;

public class Persona {
	private long id;
	private String nombre;
	
	//CONSTANTES
	private static final String NOMBRE_POR_DEFECTO ="anonimo";
	
	//ENUMERACION
	public static enum Formato{
		MAYUSCULAS,
		MINUSCULAS,
		SIN_FORMATO
	}
	//VARIABLES STATICAS
	private static Formato formato =Formato.SIN_FORMATO;
	
	//CONTRUCTORES
	//public Persona() {}	
	/*public Persona() {
		this(null,NOMBRE_POR_DEFECTO)
	}*/	
	public Persona() {
		this((Long) null,NOMBRE_POR_DEFECTO);
	}
	public Persona(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	public Persona(String string) {
		setNombre(string);
	}
	
	//GETTERS Y SETTERS
	
	
	public long getId() {
		return id;
	}

	public static Formato getFormato() {
		return formato;
	}
	public static void setFormato(Formato formato) {
		Persona.formato = formato;
	}
	public void setId(long id) {	
		if( id < 0  ) {
			throw new RuntimeException("No se admiten Id negativos");
		}
		this.id = id;	
		
	}
	//METODO PRIVADO
	private static String formatear(String dato) {
		switch(formato) {
			case SIN_FORMATO:
				return dato;	
			case MAYUSCULAS:
				return dato.toUpperCase();
			case MINUSCULAS:
				return dato.toLowerCase();
			default:
				return dato;
		}
		
	}
	public  String getInformacion() {
		return getId()+" :"+getNombre();
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
