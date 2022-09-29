package com.ipartek.gonza.objetos.pojos.presentacion;

import static com.ipartek.gonza.biblioteca.Consola.*;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.gonza.objetos.pojos.ejercicios.Cuadro;

public class CuadroConsola {

	public static void main(String[] args) {
		Cuadro c = new Cuadro();
		
		List<Cuadro> cuadros = new ArrayList<>();
		boolean opt=true;
		boolean seguir;
		
		do {
			c.setAutor(gString("Introduce el nombre del autor"));
			c.setTitulo(gString("Introduce el titulo del cuadro"));
			c.setAltura(gInt("Introduce la altura del cuadro"));
			c.setAnchura(gInt("Introduce la altura del cuadro"));
			c.setAno(gInt("Introduce el año de finalizacion del cuadro"));		
			c.setRestaurado(gBoolean("Introduce si esta restaurado"));	
			c.setPrecio(gDouble("Introduce el precio del cuadro"));	
			
			cuadros.add(c);
			do {
				seguir=true;
				String a =gString("Desea continuar añadiendo Cuadros?(S/N)");
				a=a.toLowerCase();
				if(a.equals("s")) {
					opt=true;
				}else if(a.equals("n")){
					
					opt=false;
				}else {
					System.out.println("Introduce un dato valido");
					seguir=false;
				}
			}while(!seguir);		
			
			
		}while(opt);
		
		for(Cuadro cc:cuadros) {
			cc.getDatos();
		}
		
		
	}

}
