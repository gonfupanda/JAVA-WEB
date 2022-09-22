package com.ipartek.gonza.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		capicua();

	}
	public static void capicua() {
		
		Scanner s = new Scanner(System.in);
		try {
			boolean okey=false;
			String num;
			do {
				okey=false;
				System.out.println("Introduce una numero con mas de una cifra:");
				num= s.nextLine();
				if(num.length()<2) {
					okey=true;
				}
			}while(okey);

			
			int num1=Integer.parseInt(num);
			List<Integer> numerosDivididos = new ArrayList<>();
			
			for(int i=0;i<num.length();i++) {
				String a=String.valueOf(num.charAt(i));
				numerosDivididos.add(Integer.parseInt(a));
			}
			List<Integer> numerosDivididosCambiados = new ArrayList<>();			
			for(int i=numerosDivididos.size();i>0;i--) {
				numerosDivididosCambiados.add(numerosDivididos.get(i-1));
			}
			
			String numReves = "";
			for(Integer w : numerosDivididosCambiados) {
				numReves+=String.valueOf(w);
			}
			System.out.println("El numero es "+num);
			System.out.println("El numero es "+numReves);
			if(numReves.equals(num)) {
				System.out.println("El numero es "+num+" CAPICIUA");
			}else {
				System.out.println("El numero NO es "+num+"  CAPICIUA");
			}
			
			s.close();
		}catch(NumberFormatException e) {
			System.out.println("Introduce NUMERO INTERO\n------------");
			capicua();
			
		}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println("Ha ocurrido un error imprevisto");
		
		}
		
		
		
	}
	public static void cifradoCesar() {
		
		Scanner s = new Scanner(System.in);

		System.out.println("Introduce una palabra:");
		String contra= s.nextLine();
		String newPass="";
		char ch = 'a';//Character.toString ((char) i);
		//int as_chi = ch;
		for(int i=0;i<contra.length();i++) {//Cifrar con una separacion de 3
			int as_chi =contra.charAt(i);
			
			//System.out.println(contra.charAt(i)+"------"+as_chi);
			newPass+=Character.toString ((char) as_chi+3);
		}
		System.out.println("nueva palabra:"+newPass);
		
	}
	
	public static void numerosAmigos() {
		try {
			Scanner s = new Scanner(System.in);

			System.out.println("Introduce el primer numero amigo:");
			String num= s.nextLine();
			System.out.println("Introduce el segundo numero amigo:");
			String nu= s.nextLine();
			int num1=Integer.parseInt(num);
			int num2=Integer.parseInt(nu);
			List<Integer> divisores1 = new ArrayList<>();
			List<Integer> divisores2 = new ArrayList<>();
			
			divisores1= numerosDividor(num1);
			divisores2= numerosDividor(num2);
			
			int sumDiv1=0;
			int sumDiv2=0;
			for(int a:divisores1 ) {
				sumDiv1+=a;
			}
			for(int a:divisores2 ) {
				sumDiv2+=a;
			}
			System.out.println("\nSuma de los divisores de "+num1+":"+sumDiv1);
			System.out.println("Suma de los divisores de "+num2+":"+sumDiv2);
			if(sumDiv1== sumDiv2) {
				System.out.println("-------------\nLos numeros "+num1+" y "+num2+" SI son amigos");
			}else {
				System.out.println("-------------\nLos numeros "+num1+" y "+num2+" NO son amigos");
			}
			s.close();
		}catch(NumberFormatException e) {
			System.out.println("Introduce 2 NUMEROS INTEROS\n------------");
			numerosAmigos();
			
		}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println("Ha ocurrido un error imprevisto");
		
		}
		
		
	}
	public static List numerosDividor(int num) {
		//int numResto=num;
		List<Integer> divisores = new ArrayList<>();
		for(int i=1;i<num+1;i++) {
			if(num%i==0) {
				divisores.add(i);			
			}
		}
		System.out.println("Divisores de "+num+":"+divisores);
		return divisores;
		
	}

}
