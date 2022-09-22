package com.ipartek.gonza.objetos.pojos.ejercicios;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 String nombre, numero;
		 double tipo, importe;

		 Cuenta cuenta1 = new Cuenta();

		 System.out.print("Nombre : ");
		 cuenta1.setNombre( sc.nextLine()); 
		 System.out.print("Número de cuenta : ");
		 cuenta1.setNum_cuenta( sc.nextLine()); 

		 System.out.print("Tipo de interes : ");
		 cuenta1.setInteres(sc.nextDouble()); 
		 System.out.print("Saldo: ");
		 cuenta1.setSaldo(sc.nextDouble()); 
		 
		 Cuenta cuenta2 = new Cuenta("Juan Ferrández Rubio", "12345678901234567890", 1.75, 300.0);
		 
		 Cuenta cuenta3 = new Cuenta(cuenta1);


		/* System.out.println("------------");
		 cuenta1.getDatos();
		 System.out.println("------------");
		 cuenta2.getDatos();
		 System.out.println("-------------");
		 cuenta3.getDatos();*/
		 System.out.println("-------");
		 System.out.println(cuenta3.getSaldo());
		 System.out.println(cuenta1.getSaldo());
		 
		
		 cuenta3.transferencia(cuenta1, 10.0);
		 System.out.println("-------");
		 System.out.println(cuenta3.getSaldo());
		 System.out.println(cuenta1.getSaldo());
		 
	}

}
