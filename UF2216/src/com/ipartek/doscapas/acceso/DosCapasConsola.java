package com.ipartek.doscapas.acceso;

import static com.ipartek.gonza.biblioteca.Consola.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.doscapas.entidad.EntidadesException;
import com.ipartek.doscapas.entidad.Producto;

public class DosCapasConsola {

	private static final int SALIR = 0;
	private static final int VERTODOS = 1;
	private static final int VERID = 2;
	private static final int ANADIR = 3;
	private static final int MOD = 4;
	private static final int BORRAR = 5;

	private static final Dao<Producto> d = DaoMemoriaProducto.getInstancia();

	public static void main(String[] args) {
		int opt;
		do {
			menu();
			opt = pedirOpcion();
			procesarOpcion(opt);
			
		}while(opt!=SALIR);

	}

	private static void menu() {
		pl("\nMENU\n1-Ver los productos\n2-Ver producto por la id\n3-Anadir producto\n4-Modificar producto existente\n5-Borrar producto\n0-Salir\n");
		
	}

	private static int pedirOpcion() {
		
		return gInt("Introduce una opcion");
	}

	private static void procesarOpcion(int opt) {
		switch(opt) {
			case SALIR:
				System.out.println("Gracias por usar nuestra aplicacion!");
				break;
			case VERTODOS:
				obtenerTodos();
				break;
			case VERID:
				verId();
				break;
			case ANADIR:
				alta();
				break;
			case MOD:
				mod();
				break;
			case BORRAR:
				borrar();
				break;
			default:
				pl("opcion no reconocida");
				
		}
		
	}

	private static void obtenerTodos() {
		for(Producto p:d.obtenerTodos()) {
			mostrarProducto(p);
		}
		
	}

	private static void verId() {
		long id = gLong("Introduce el id a buscar");
		Producto prod = d.obtenerPorId(id);
		mostrarProducto(prod);
		
	}

	private static void alta() {
		Producto p = new Producto();
		boolean okey=false;
		try {
			p.setNombre(gString("Introduce el nombre del Producto"));
			p.setCaducidad(gDate("Introduce la caducidad"));
			p.setPrecio(gBigDecimal("Introduce el precio"));
			p.setCantidad(gInt("Introduce la cantidad"));
			
			d.insertar(p);
			
			
			p("Producto introducido");
		
		}catch(EntidadesException e) {
			System.out.println("salta porla exception");
			System.out.println(e.getCause());
		}
		
		
		
	}

	private static void mod() {
		// TODO Auto-generated method stub
		
	}

	private static void borrar() {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarProducto(Producto p) {
		p(p);
		
	}

}
