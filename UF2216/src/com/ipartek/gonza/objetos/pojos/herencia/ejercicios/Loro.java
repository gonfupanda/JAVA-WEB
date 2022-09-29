package com.ipartek.gonza.objetos.pojos.herencia.ejercicios;


public class Loro extends Ave{
	
	private char region;
	private String color;
	
	/**
	 * @param sexo
	 * @param edad
	 * @param region
	 * @param color
	 */
	public Loro(char sexo, int edad, char region, String color, DatosPersonales d) {
		super(sexo, edad, d);
		setRegion(region);
		setColor(color);
	}


	public char getRegion() {
		return region;
	}

	public void setRegion(char region) {
		this.region = region;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void dondeEres() {
		if(getRegion()=='N') {
			System.out.println("Norte");
		}
		if(getRegion()=='S') {
			System.out.println("Sur");
		}
		if(getRegion()=='E') {
			System.out.println("Este");
		}
		if(getRegion()=='O') {
			System.out.println("Oeste");
		}
	}


	@Override
	public void cantar() {
		System.out.println("Piooo Pioo Loro bonito");
		
	}
	
	

}
