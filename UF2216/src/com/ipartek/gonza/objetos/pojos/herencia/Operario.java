package com.ipartek.gonza.objetos.pojos.herencia;

public class Operario extends Empleado{

	public Operario(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  super.toString()+"-->Operario " ;
	}
	
}
