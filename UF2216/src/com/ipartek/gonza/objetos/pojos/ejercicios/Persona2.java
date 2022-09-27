package com.ipartek.gonza.objetos.pojos.ejercicios;

import java.time.LocalDateTime;

public class Persona2 {
	
	private String nombre;	
	private String direccion;
	private Long codigoPostal;
	private String ciudad;
	private Fecha fechaNac;
	
	public Persona2(String a, String c, Long b, String d, Fecha f) {
		setNombre(a);
		setDireccion(c);
		setCodigoPostal(b);	
		setCiudad(d);
		fechaNac =new Fecha();
		fechaNac.setFecha(f);
		
	}
	
	//SETTER GETTER
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public boolean esMayorDeEdad() {
		boolean mayor=false;
		LocalDateTime date = LocalDateTime.now();
		
	
		
		if(date.getYear()-this.fechaNac.getAno()>18) {
			mayor=true;
		}else if(date.getYear()-this.fechaNac.getAno()<=18){
			if(date.getMonthValue()<this.fechaNac.getMes()) {
				mayor=true;
			}else if(date.getMonthValue()==this.fechaNac.getMes()) {	
				if(date.getDayOfMonth()<=this.fechaNac.getDia()) {
					mayor=true;
				}
			}
		}
		return mayor;
	}

	@Override
	public String toString() {
		return "\nNombre:" + nombre+ "\n fecha Nacimiento=" +
				fechaNac + "\n Direccion=" +
				direccion + "\n" +
				codigoPostal
				+ "  " + ciudad ;
	}
	
	
	

}
