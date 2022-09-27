package com.ipartek.gonza.objetos.pojos.ejercicios;

import java.time.LocalDateTime;

public class Fecha {
	private int dia;
	private int mes;
	private int ano;
	
	//CONTRUCTORS
	public Fecha(int dia, int mes, int ano) throws Exception {
		setAno(ano);
		setDia(dia);
		setMes(mes);

	}
	
	public Fecha() {}

	//GETTER SETTER
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) throws Exception {
		String a=String.valueOf(ano);
		if(a.length()!=4) {
			throw new Exception("introdusca la fecha del año de manera correcta");
		}
		this.ano = ano;
	}
	
	
	//METHODS
	public void getFecha() {
		System.out.println(dia+"/"+mes+"/"+ano);
	}
	public boolean bisiesto() {
		if(this.ano%4==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void diaSiguiente() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date.plusDays(1));
		this.ano=date.getYear();
		this.mes=date.getMonthValue();
		this.dia=date.getDayOfMonth();

		
		
	}
	public boolean fechaCorrecta() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth());
		System.out.println(ano+"-"+mes+"-"+dia);
		boolean okey=true;
		
		if(date.getYear()!=ano || date.getMonthValue()!=mes || date.getDayOfMonth()!=dia) {
			okey=false;
		}
		if(okey) {
			System.out.println("La fecha es correta");
		}else {
			System.out.println("La fecha es incorrecta");
		}
		return okey;
	}
	
	public void setFecha(Fecha c) {
		try {
			//c.getFecha();
			setAno(c.getAno());
			setDia(c.getDia());
			setMes(c.getMes());
		}catch(Exception e) {
			c.getFecha();
			//throw new Exception();
		}
	}
	
	public boolean esMayorQue(Fecha c) {
		boolean mayor= true;
		if(c.getAno()>this.ano) {
			mayor=false;
		}
		if(c.getMes()>this.mes) {
			mayor=false;
		}
		if(c.getDia()>=this.dia) {
			mayor=false;
		}
		return mayor;
	}
	@Override
	public String toString() {
		if(this.dia<10 &&this.mes<10) {
			return "0" + dia + "-0" + mes + "-" + ano;
		}else if(this.dia>10 &&this.mes<10){
			return dia + "-0" + mes + "-" + ano;
		}else if(this.dia<10 &&this.mes>10){
			return "0" + dia + " -" + mes + "-" + ano;
		}else {
			return dia + "-" + mes + "-" + ano;
		}
		
	}

	
	
	
}
