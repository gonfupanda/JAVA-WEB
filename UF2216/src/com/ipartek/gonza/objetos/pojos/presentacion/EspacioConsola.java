package com.ipartek.gonza.objetos.pojos.presentacion;

import com.ipartek.gonza.objetos.pojos.Cliente;
import com.ipartek.gonza.objetos.pojos.Espacio;
import com.ipartek.gonza.objetos.pojos.Persona;

public class EspacioConsola {

	public static void main(String[] args) {
		
		/*
		Espacio e = new Espacio("Bilbao");
		Persona p = new Persona(0L,"Javi");
		System.out.println(p.getInformacion());
		
		e.entrar(p);
		e.entrar(new Persona(1L,"PEPE"));
		e.entrar(new Persona(2L,"No me quedo"));
		e.entrar(new Persona(3L,"Juan"));
		e.entrar(new Persona(4L,"tampoco me quedo"));
		
		for(Persona persona : e.getPersonas()) {
			System.out.println(persona.getNombre());
		}
		*/
		/*
		 
		 */
		Espacio e = new Espacio("Herencia");
		
		Cliente c = new Cliente(1L,"PEPE","123143214K");
		Persona p = c;//casting implicito
		e.entrar(c);
		e.entrar(p);
		//System.out.println(c.getInformacion());
		Cliente cliente;
		
		for(Persona persona : e.getPersonas()) {
			if(persona instanceof Cliente) {
				cliente=(Cliente) persona;
				System.out.println(cliente.getNif());
			}else {
				System.out.println(persona.getInformacion());
			}
			
		}
	}

}
