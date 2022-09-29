package com.ipartek.gonza.objetos.pojos.herencia.ejercicios;

public class Piolin extends Canario {
	
	private int NumPelis;

	public Piolin(char sexo, int edad, Double t, int pelis, DatosPersonales d) {
		super(sexo, edad, t,d );
		setNumPelis(pelis);
	}

	public int getNumPelis() {
		return NumPelis;
	}

	public void setNumPelis(int numPelis) {
		NumPelis = numPelis;
	}
	
	public void cantar() {
		System.out.println("Piooo Pioo Soy un Piolin");
	}
	
	public static void main(String[] args) {
		
		Piolin p[]=new Piolin[3];
		p[0]= new Piolin('M', 2, 32D, 4, new DatosPersonales("omi","gonza"));
		p[1]= new Piolin('H', 8, 16D, 5, new DatosPersonales("artiz","gonza"));
		p[2]= new Piolin('M', 12, 5D, 1, new DatosPersonales("aRRU","pablo"));
		
		p[0].setDatosNombre("pablo");
		
		Loro l = new Loro('H', 4, 'N', "amarillo",new DatosPersonales("rok224","carlos"));
		
		p[0].cantar();
		p[1].cantar();
		p[2].cantar();
		l.cantar();
		System.out.println(p[1].getDatos().getNombre()+ "  " +p[1].getDatos().getNombreDueno());
	}
	
	public void ejer1() {
		/*Loro l = new Loro('H', 4, 'N', "amarillo");
		Piolin p = new Piolin('M', 12, 32D, 4);
		
		p.quienSoy();
		l.quienSoy();
		
		p.altura();
		l.dondeEres();
		
		p.setTamano(15D);
		p.altura();
		
		System.out.println(l.getNumCreadas());*/
	}
	
	


}
