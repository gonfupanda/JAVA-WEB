package com.ipartek.gonza.objetos.pojos.herencia.ejercicios;

public class Canario extends Ave {
	private Double tamano;

	public Canario(char sexo, int edad,Double t,DatosPersonales d) {
		super(sexo, edad, d);
		setTamano(t);
		
	}
	public Canario(char sexo, int edad, DatosPersonales d) {
		super(sexo, edad, d);
	}

	
	public Double getTamano() {
		return tamano;
	}

	public void setTamano(Double tamano) {
		this.tamano = tamano;
	}
	
	public void altura() {
		if(getTamano()>30) {
			System.out.println("Alto");
		}else if(getTamano()>15) {
			System.out.println("Mediano");
		}else {
			System.out.println("Bajo");
		}
	}
	@Override
	public void cantar() {
		// TODO Auto-generated method stub
		
	}
	

}
