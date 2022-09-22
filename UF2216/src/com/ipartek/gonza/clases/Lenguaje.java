package com.ipartek.gonza.clases;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

public class Lenguaje {
	
	public static  void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Numero:");
		BigInteger num=s.nextBigInteger();
		
		System.out.println(recursivas(num));
	}
	public static BigInteger recursivas(BigInteger x) {//sacar el factorial //como usar el BigInteger
		if(BigInteger.ONE.compareTo(x)==1)return BigInteger.ONE;
		return x.multiply(recursivas(x.subtract(BigInteger.ONE))) ;
	}
	
	public static void entrada() {
		Scanner s = new Scanner(System.in);
		System.out.println("Nombre:");
		String nombre= s.nextLine();
		System.out.println("hola " + nombre);/**/
		
		s.close();
	}
	public static void excepciones() {
		
		int div=0,a =32,b=6,c=0;
		try {
			
			System.out.println("INICIO");
			div=a/0;
			System.out.println(div);
			System.out.println("FIN");
			
		}catch(ArithmeticException ex){
			System.out.println("Ha saltado una ArithmeticException");
			div=Integer.MAX_VALUE;
			System.out.println(ex.getCause());
			System.out.println(ex.getLocalizedMessage());
			System.out.println(ex.getMessage());
			
			return;
			
		}catch(Exception e) {
		
			System.out.println("Ha saltado una excepcion");

			System.out.println(e.getCause());
		}finally {
			System.out.println("Soy el finally y siempre me ejecuto");
			System.out.println("porque puedo");
		}
	}
	public static void bucles() {
		String []arr= {"uno","dos","tres"};/*
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}*/
		
		etiqueta:for(String s :arr) {//foreach
			System.out.println(s);
			if("dos".equals(s)) {
				System.out.println("Encontrado");
				//break;
				break etiqueta;
			}
		}
		String s;
		boolean encontrado=false;
		for(int i=0;i<arr.length && !encontrado;i++) {
			s =arr[i];
			System.out.println("Comparando "+s);
			if("dos".equals(s)) {
				System.out.println("Encontrado");
				encontrado=true;
			}
		}
		/*int opcion=2,dias=0;
		switch(opcion) {
			case 2:
				dias=28;
				break;
			case 4:
				break;
			case 11:
				dias=30;
				break;
			default:
				dias=31;
		}
		System.out.println(dias);*/
	}
	public static void control(){
		
	}
	public static void operaciones() {
		int x=5;
		int y;
		System.out.println(1 <= x && x <= 10);
		
		System.out.println(5 | 3);//101 OR 011 = 111
		System.out.println(y= x +=7);
		System.out.println(x >y ? x : y);
		System.out.println(y++);//saca 5 y despues suma 
		System.out.println(++y);//suma y saca 6
	}
	public static void collecciones() {
		//COLLECCIONES
				List<Integer>lista = new ArrayList<>();
				lista.add(10);
				lista.add(20);
				lista.add(30);
				System.out.println(lista);
				
				Set<Integer> s = new HashSet<>();//no permite repetidos
				s.add(4);
				s.add(5);
				s.add(5);
				
				System.out.println(s);
				
				//MAPA
				Map<String,String> m = new HashMap<>();
				m.put("casa", "home");
				m.put("perro", "dog");
				
				System.out.println(m.get("perro"));
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
	@SuppressWarnings("deprecation")
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
