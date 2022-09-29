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
		int i=0;
		try {
			String texto = gString(mensaje);
			i=Integer.parseInt(texto);
			
		}catch(Exception e) {
			System.out.println("Introduzca un numero valido");
			gInt(mensaje);
			
		}
		return i;
		
	}
	public static long gLong(String mensaje) {
		long i=0;
		try {
			String texto = gString(mensaje);
			i=Long.parseLong(texto);
			
		}catch(Exception e) {
			System.out.println("Introduzca un numero valido");
			gInt(mensaje);
			
		}
		return i;
		
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
		Double i=0D;
		try {
			String texto = gString(mensaje);
			i=Double.parseDouble(texto);
			
		}catch(Exception e) {
			System.out.println("Introduzca un numero valido");
			gInt(mensaje);
			
		}
		return i;
		
	}
	public static BigDecimal gBigDecimal(String mensaje) {
		BigDecimal i=null;
		try {
			String texto = gString(mensaje);
			i=new BigDecimal(texto);
			
		}catch(Exception e) {
			System.out.println("Introduzca un numero valido");
			gInt(mensaje);
			
		}
		return i;
		
	}
	
	public static LocalDate gDate(String mensaje) {
		
		LocalDate i=null;
		try {
			String texto = gString(mensaje+"(AAAA-MM.DD)");
			i=LocalDate.parse(texto, DateTimeFormatter.ISO_DATE);
			
		}catch(Exception e) {
			System.out.println("Introduzca un numero valido");
			System.out.println(e.getCause());
			gInt(mensaje);
			
		}
		return i;
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

}
