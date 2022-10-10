package com.ipartek.gonza.biblioteca;

import static com.ipartek.gonza.biblioteca.Consola.gString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Function;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	public static void pl(Object o) {
		System.out.println(o);
	}

	public static void p(Object o) {
		System.out.println(o);

	}

	public static String gString(String mensaje) {
		p(mensaje + ":");
		return sc.nextLine();
	}

	public static int gInt(String mensaje) {

		return (int) gObject(mensaje, texto -> Integer.parseInt(texto));
	}

	public static Long gLong(String mensaje) {
		return (Long) gObject(mensaje, texto -> Long.parseLong(texto));

	}

	public static Double gDouble(String mensaje) {
		return (Double) gObject(mensaje, texto -> Double.parseDouble(texto));

	}

	public static BigDecimal gBigDecimal(String mensaje) {
		return (BigDecimal) gObject(mensaje, texto -> new BigDecimal(texto));

	}

	public static LocalDate gDate(String mensaje) {

		return (LocalDate) gObject(mensaje, texto -> LocalDate.parse(mensaje, DateTimeFormatter.ISO_DATE));
	}

	public static <T> T gObject(String mensaje, Function<String, T> op) {
		String error = null;
		boolean ookey;
		T o = null;

		do {
			ookey = false;
			try {
				String texto = gString(mensaje);
				o = op.apply(texto);

				ookey = true;
				// throw new IllegalArgumentException("El tipo "+o.getClass()+" no es
				// corrrecto");

			} catch (Exception e) {
				System.out.println("Introduzca un valor valido");
				System.out.println(e.getCause());

			}
		} while (!ookey);

		return o;
	}

	public static boolean gBoolean(String mensaje) {
		boolean a;
		try {
			// Find the next boolean token and print it
			a = false;
			p(mensaje + ":");
			a = sc.nextBoolean();
			sc.nextLine();
			return a;
		} catch (Exception e) {
			sc.nextLine();
			System.out.println("no es un booleano correcto");
			a = gBoolean(mensaje);

			return a;
		}
	}

	public static int entreRangos(int a, int b) {
		boolean okey = false;
		int c;
		int aux;
		if (a > b) {
			aux = a;
			a = b;
			b = a;
		}
		do {
			okey = true;
			c = gInt("introduce un numero entre " + a + " y " + b);
			if (c < a || c > b) {
				okey = false;
				System.out.println("Introduce un numero en el rango indicado");
			}
		} while (okey);

		return c;
	}

	public static boolean gcontinuarSN() {
		boolean seguir = false;
		boolean opt = false;
		do {
			seguir = true;
			String a = gString("Desea continuar añadiendo Cuadros?(S/N)");
			a = a.toLowerCase();
			if (a.equals("s")) {
				opt = true;
			} else if (a.equals("n")) {

				opt = false;
			} else {
				System.out.println("Introduce un dato valido");
				seguir = false;
			}
		} while (!seguir);
		return opt;
	}

	interface Convertible {
		Object convertir(String texto);
	}
}
