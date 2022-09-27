package com.ipartek.gonza.objetos.pojos.ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.gonza.biblioteca.Consola;

import static com.ipartek.gonza.biblioteca.Consola.*;

public class Main {

	public static void main(String[] args) throws Exception {
		personas();
		 
	}
	public void ejerCuenta() {
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
	
	public static void fechas() throws Exception {
		Fecha f = new Fecha(01,9,2020);
		System.out.println(f.toString());
		
		
		//f.fechaCorrecta();
		System.out.println(f.getAno()+"-"+f.getMes()+"-"+f.getDia());
		f.diaSiguiente();
		System.out.println(f.getAno()+"-"+f.getMes()+"-"+f.getDia());
		
	}
	public static void personas() throws Exception {
		
		 ArrayList<Persona2> personas = new ArrayList();
		 
		 String nombre;
		 String direccion;
		 Long codigo;
		 String ciudad;
		 int ano;
		 int mes;
		 int dia;
		 int seguir;
		 do {
			 nombre = gString("Introduce el nombre");
			 direccion = gString("Introduce el direccion");
			 codigo = gLong("Introduce el Codigo");
			 ciudad = gString("Introduce la ciudad");
			 
			 System.out.println("Introduce la fecha de nacimiento");
			 ano =gInt("introduce el año");
			 mes =gInt("introduce el mes");
			 dia =gInt("introduce el dia");
			 Fecha f = new Fecha(dia,mes,ano);
			 Persona2 p= new Persona2(nombre,direccion,codigo,ciudad,f);
			 personas.add(p);
			 seguir=gInt("Desea continuar(1-Si  0-No)?");
			 
		 }while(seguir==1);
		 
		//Persona2 p = new Persona2("gonza", "aaaaa", 1L, "Bilbao", new Fecha(25,10,2004));
		 
		 for(Persona2 a: personas) {
			
			 if(a.esMayorDeEdad()) {
				  System.out.println(a.getNombre()+" es mayor de edad");
			 }else{
				 System.out.println(a.getNombre()+" es menor de edad");
			 }
		 }
		 
		 
		
		
		
		
	}

}
