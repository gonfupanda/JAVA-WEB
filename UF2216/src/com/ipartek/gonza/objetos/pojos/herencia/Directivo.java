package com.ipartek.gonza.objetos.pojos.herencia;

public class Directivo extends Empleado {

	public Directivo(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString()+"-->Directivo "  ;
	}
	

}
