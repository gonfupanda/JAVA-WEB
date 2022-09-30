package com.ipartek.gonza.biblioteca;

import static com.ipartek.gonza.biblioteca.Consola.gString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);
	
	public static void pl(Object o) {
		System.out.println(o);
	}
	public static void p(Object o) {
		System.out.println(o);
		
	}
	public static String gString(String mensaje) {
		p(mensaje+":");
		return sc.nextLine();
	}
	
	public static int gInt(String mensaje) {
		
		return (int) gObject(mensaje, new Convertible() {

			@Override
			public Object convertir(String texto) {
				return Integer.parseInt(texto);
			}
			
		});	
	}
	public static Long gLong(String mensaje) {
		return (Long) gObject(mensaje, new Convertible() {

			@Override
			public Object convertir(String texto) {
				return Long.parseLong(texto);
			}
			
		});
		
	}
	public static float gFloat(String mensaje) {
		float i=0;
		try {
			String texto = gString(mensaje);
			i=Float.parseFloat(texto);
			
		}catch(Exception e) {
			System.out.println("Introduzca un numero valido");
			gInt(mensaje);
			
		}
		return i;
		
	}
	public static Double gDouble(String mensaje) {
		return (Double) gObject(mensaje, new Convertible() {

			@Override
			public Object convertir(String texto) {
				return Double.parseDouble(texto);
			}
			
		});
		
	}
	public static BigDecimal gBigDecimal(String mensaje) {
		return (BigDecimal) gObject(mensaje, new Convertible() {

			@Override
			public Object convertir(String texto) {
				return new BigDecimal(texto);
			}
			
		});
		
	}	
	public static LocalDate gDate(String mensaje) {
		
		return LocalDate.parse(mensaje, DateTimeFormatter.ISO_DATE);
	}
	
public static Object gObject(String mensaje,Object o) {
		String error=null;
		boolean ookey;
				
		do {			
		ookey=false;
			try {
				String texto = gString(mensaje);
				if(o instanceof LocalDate) {
					o=gDate(mensaje);
					error="Error en la Date";
				}else if(o instanceof Integer) {
					error="Error en el Integer";
					o=gInt(mensaje);
				}else if(o instanceof Long) {
					error="Error en el Long ";
					o=gLong(mensaje);
				}else if (o instanceof Double) {
					error="Error en El Double";
					o=gDouble(mensaje);
	
				}else if(o instanceof BigDecimal) {
					error="Error en el big decimal";
					o=gBigDecimal(mensaje);
				}	
				
				ookey=true;
				//throw new IllegalArgumentException("El tipo "+o.getClass()+" no es corrrecto");
				
			}catch(Exception e) {
				System.out.println("Introduzca un valor valido");
				System.out.println(e.getCause());
				
			}
		}while(!ookey);
		
		return o;
	}
	
	public static boolean gBoolean(String mensaje) {
		boolean a;
		try {
	         //Find the next boolean token and print it  
			a=false;
			p(mensaje+":");
			a=sc.nextBoolean();
			sc.nextLine();
			return a;
		}catch(Exception e) {
			sc.nextLine();
			System.out.println("no es un booleano correcto");
			a = gBoolean(mensaje);
			
			return a;
		}
	}
	
	public static int entreRangos(int a , int b) {
		boolean okey=false;
		int c;
		int aux;
		if(a>b) {
			aux=a;
			a=b;
			b=a;
		}
		do {
			okey=true;
			c=gInt("introduce un numero entre "+a+" y "+b);
			if(c<a || c>b) {
				okey=false;
				System.out.println("Introduce un numero en el rango indicado");
			}
		}while(okey);

		return c;
	}
	public static boolean gcontinuarSN() {
		boolean seguir=false;
		boolean opt=false;
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
		return opt;
	}
	
	interface Convertible{
		Object convertir(String texto);
	}
}
