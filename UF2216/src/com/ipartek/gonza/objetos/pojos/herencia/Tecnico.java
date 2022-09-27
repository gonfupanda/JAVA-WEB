package com.ipartek.gonza.objetos.pojos.herencia;

public class Tecnico extends Operario{

	public Tecnico(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  super.toString()+"-->Tecnico " ;
	}
	

}
