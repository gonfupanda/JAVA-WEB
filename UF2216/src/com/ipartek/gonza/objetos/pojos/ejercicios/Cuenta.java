package com.ipartek.gonza.objetos.pojos.ejercicios;

public class Cuenta {
	private String nombre;
	private String num_cuenta;
	private Double interes;
	private Double saldo;
	
	//CONSTRUCTORS
	
	public Cuenta(String nombre, String num_cuenta, Double interes, Double saldo) {
		setNombre(nombre);
		setNum_cuenta(num_cuenta);
		setInteres(interes);
		setSaldo(saldo);
	}
	public Cuenta(){
		
	}
	public Cuenta(Cuenta c) {
		  nombre=c.getNombre();
		  num_cuenta= c.getNum_cuenta();
		  interes= c.getInteres();
		  saldo=c.getSaldo();
	}
	/*
	 * public Cuenta(Cuenta c) {
		  new Cuenta(c.getNombre(),c.getNum_cuenta(),c.getInteres(),c.getSaldo());
	}
	*/
	
	
	//SETTER GETTER
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new NullPointerException("No se admiten nulos");
		}
		if(nombre.trim().length() == 0) {
			throw new NullPointerException("No se admiten nombres vacios");
		}
		this.nombre = nombre;
	}
	public String getNum_cuenta() {
		
		return num_cuenta;
	}
	public void setNum_cuenta(String num_cuenta) {
		if(num_cuenta == null) {
			throw new NullPointerException("No se admiten nulos");
		}
		if(num_cuenta.trim().length() == 0) {
			throw new NullPointerException("No se admiten nombres vacios");
		}
		this.num_cuenta = num_cuenta;
	}
	public Double getInteres() {
		return interes;
	}
	public void setInteres(Double interes) {
		if(interes < 0) {
			throw new NullPointerException("No se admiten intereses menores a 0");
		}
		this.interes = interes;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		if(saldo < 0) {
			throw new NullPointerException("No se admiten saldos menores a 0");
		}
		this.saldo = saldo;
	}
	//METHODS
	public boolean ingreso(Double aumento) {
		boolean okey=true;;
		if(aumento < 0) {
			okey=false;
		}else{
			this.saldo+=aumento;
		}
		return okey;
		
	}
	public boolean reintegro(Double aumento) {
		boolean okey=true;;
		if(aumento < 0 || aumento> this.saldo) {
			okey=false;
			System.out.println("La cuenat no dispone del dinero suficiente");
		}else{
			this.saldo-=aumento;
		}
		return okey;
		
	}
	public void getDatos() {
		 System.out.println("Nombre del titular: " + getNombre());
		 System.out.println("Número de cuenta: " +getNum_cuenta());
		 System.out.println("Tipo de interés: " + getInteres());
		 System.out.println("Saldo: " + getSaldo());
		 System.out.println();
	}
	public void transferencia(Cuenta c,Double d) {
		reintegro(d);
		c.ingreso(d);
	}
}
