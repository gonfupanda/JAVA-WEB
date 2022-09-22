package com.ipartek.gonza.objetos.pojos.presentacion;

import com.ipartek.gonza.objetos.pojos.Persona;

public class PersonaConsola {

	public static void main(String[] args) {
		
		Persona p = new Persona(1L,"gonza");
		
		System.out.println(p);
		Persona p2=p;
		System.out.println(p2);
		p2.setNombre("gon");
		System.out.println(p.getNombre());

	}

}
