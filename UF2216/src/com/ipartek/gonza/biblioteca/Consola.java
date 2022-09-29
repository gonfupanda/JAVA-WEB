package com.ipartek.gonza.biblioteca;

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

}
