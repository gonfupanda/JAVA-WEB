package com.ipartek.gonza.objetos.pojos.presentacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ipartek.gonza.objetos.pojos.Cliente;
import com.ipartek.gonza.objetos.pojos.Espacio;
import com.ipartek.gonza.objetos.pojos.Persona;

public class FicheroObjetoConsola {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Espacio e =new Espacio("Bilbo");
		
		e.entrar(new Persona());
		e.entrar(new Persona("asdaada"));
		e.entrar(new Cliente("sdscscs","acacasc"));
		
		FileOutputStream fos = new FileOutputStream("datos.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(e);
		
		
		FileInputStream fis = new FileInputStream("datos.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Espacio espacio = (Espacio) ois.readObject();
		
		for(Persona per:e.getPersonas()) {
			System.out.println(per);
		}
		
		

	}

}
