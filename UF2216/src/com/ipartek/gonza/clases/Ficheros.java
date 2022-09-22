package com.ipartek.gonza.clases;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class Ficheros {

	public static void main(String[] args) {
		FileWriter fw;
		PrintWriter pw = null;
		Scanner sc = null;
		try {
			//String locFich="C:\\Users\\java\\git\\JAVA-WEB\\UF2216";//"C/Users/java/git/JAVA-WEB/UF2216" tambien funciona
			String fichero ="datos.txt";
			fw = new FileWriter(fichero);
			pw = new PrintWriter(fw);
			
			pw.println("Hola desde el nuevo fichero");
			//pw.flush();
			pw.close();
			
			FileReader fr = new FileReader(fichero);
			//BufferedReader br = new BufferedReader(fr);
			
			String linea="";
			/*
			While((linea = br.readLine()) != null){
				System.out.println(linea);
			}*/		 
			sc =new Scanner(fr);
			while(sc.hasNext()) {
				System.out.println(linea);
			}			
			
		}catch(FileNotFoundException e) {
			System.err.println("No se ha podido encontrar en el fichero");
		}catch(IOException e) {
			System.err.println("No se ha podido escribir en el fichero");
		}finally {
			if(pw != null) {
				pw.close();
			}
			
		}
		

	}

}
