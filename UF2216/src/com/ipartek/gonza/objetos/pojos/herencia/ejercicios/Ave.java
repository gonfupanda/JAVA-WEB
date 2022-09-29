package com.ipartek.gonza.objetos.pojos.herencia.ejercicios;

public abstract class Ave {
	private char sexo;
	private int edad;
	private static  int numCreadas;
	private DatosPersonales datos;
	
	
	
	/**
	 * @param sexo
	 * @param edad
	 */
	public Ave(char sexo, int edad, DatosPersonales d) {
		setSexo(sexo);
		setEdad(edad);
		setNumCreadas(getNumCreadas()+1);
		setDatos(d);
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNumCreadas() {
		return numCreadas;
	}
	public void setNumCreadas(int numCreadas) {
		this.numCreadas = numCreadas;
	}
	
	public void numAves() {
		System.out.println(getNumCreadas());
	}
	
	
	public DatosPersonales getDatos() {
		return datos;
	}
	public void setDatosNombre(String datos) {
		this.datos.setNombre(datos);
	}
	public void setDatosNombreDueno(String datos) {
		this.datos.setNombreDueno(datos);
	}
	public void quienSoy() {
		System.out.println(getSexo()+"  "+getEdad());
	}
	
	
	public void setDatos(DatosPersonales datos) {
		this.datos = datos;
	}
	public abstract void cantar();
	
	
}
