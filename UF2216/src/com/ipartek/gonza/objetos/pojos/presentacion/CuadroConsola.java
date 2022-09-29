package com.ipartek.gonza.objetos.pojos.presentacion;

import static com.ipartek.gonza.biblioteca.Consola.*;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.gonza.objetos.pojos.ejercicios.Autor;
import com.ipartek.gonza.objetos.pojos.ejercicios.Cuadro;

public class CuadroConsola {

	public static void main(String[] args) {
		
		
		List<Cuadro> cuadros = new ArrayList<>();
		boolean opt=true;
		boolean esta=false;;
		
		do {
			esta=false;
			Cuadro c = new Cuadro();
			Autor a=new Autor(gString("Introduce el nombre del autor"),gString("Introduce el nombre del autor"));
			c.setAutor(a);
			c.setTitulo(gString("Introduce el titulo del cuadro"));
			c.setAltura(gInt("Introduce la altura del cuadro"));
			c.setAnchura(gInt("Introduce la altura del cuadro"));
			c.setAno(gInt("Introduce el año de finalizacion del cuadro"));		
			c.setRestaurado(gBoolean("Introduce si esta restaurado"));	
			c.setPrecio(gDouble("Introduce el precio del cuadro"));	
			
			//cuadros.add(cuadros.size(),c);
			for(Cuadro cc:cuadros) {
				if (cc.getTitulo().equalsIgnoreCase(c.getTitulo()) && a.getNombre().equalsIgnoreCase(c.getAutor().getNombre()) && a.getApellidos().equalsIgnoreCase(c.getAutor().getApellidos())){
					esta=true;
					break;
				}
				cc.getDatos();
			}
			if(!esta) {
				cuadros.add(c);
			}else {
				System.out.println("El cuadro introducido ya se encuentra enla base");
			}
			
			
			opt=gcontinuarSN();	
			
			
		}while(opt);
		
		for(Cuadro cc:cuadros) {
			cc.getDatos();
		}
		
		
	}

}
