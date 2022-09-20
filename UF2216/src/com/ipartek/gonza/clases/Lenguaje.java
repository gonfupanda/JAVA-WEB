package com.ipartek.gonza.clases;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Lenguaje {
	
	public static  void main(String[] args) {
		
		List<Integer>lista = new ArrayList<>();
		lista.add(10);
		lista.add(20);
		lista.add(30);
		System.out.println(lista);
		
		
	}
	public static void array() {
		int tamano =3;
		int [] arr = new int[tamano];
		arr[0]=1;
		arr[1]=4;
		arr[2]=6;
		System.out.println(arr[0]+" "+arr[1] + "  "+arr[2]);
		//arr[3]=7;//saca exception porque no existe este espacio
		System.out.println(arr.length);
		@SuppressWarnings("unused")
		char [][] ajedrez= new char[8][8];
		
	}
	public static void fechas() {
		//1.0
				Date d =new Date();
				System.out.println(d);
				System.out.println(d.getDate()+"--"+(d.getMonth()+1)+"--"+(d.getYear()+1900));
				System.out.println(d.getHours()+"--"+d.getMinutes());
				
				//1.1
				Calendar c = new GregorianCalendar();
				System.out.println(c.get(Calendar.DATE)+ "\n"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DAY_OF_MONTH));
				
				//1.4 API externa JodaTime V1
				//1.5 API externa JodaTime V2
				
				//1.8 JodaTime
				LocalDateTime date = LocalDateTime.now();
				//System.out.println(date);
				System.out.println(date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear());
				System.out.println(date.getHour()+":"+date.getMinute()+":"+date.getSecond());
				
	}
	public static void tiposBasicos() {
		
		double d1=4.8;
		double d2=4.8;
		
		@SuppressWarnings("unused")
		long l =44444444;
		
		System.out.println(d1 -d2);
		String nombre = new String("Javier");
		String nombre1 = new String("Javier");
		
		System.out.println(nombre.equals(nombre1));
		System.out.println("Hola "+ nombre);
		
		//int i =null;// UN INT NO PUEDE SER NULL
		//Integer ii=null;//UN INTEGER SI QUE PUEDE SER NULL
		BigDecimal bd1 = new BigDecimal("4.8");
		BigDecimal bd2 = new BigDecimal("0.4");
		
		System.out.println(bd1.subtract(bd2));
	}

}
