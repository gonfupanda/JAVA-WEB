package com.ipartek.gonza.objetos.pojos.ejercicios;

public class Cuadro {
	private String titulo;
	private String autor;
	private int altura;
	private int  anchura;
	private int  ano;
	private boolean restaurado;
	private Double precio;
	
	
	public Cuadro(String titulo, String autor, int altura, int anchura, int ano, boolean restaurado, Double precio) {
		setTitulo(titulo);
		setAutor(autor);
		setAltura(altura);
		setAnchura(anchura);
		setAno(ano);
		setRestaurado(restaurado);
		setPrecio(precio);
	}
	public Cuadro() {
		
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getAnchura() {
		return anchura;
	}
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public boolean isRestaurado() {
		return restaurado;
	}
	public void setRestaurado(boolean restaurado) {
		this.restaurado = restaurado;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public void getDatos() {
		System.out.println("\nAutor: "+getAutor()+
				"\nTitulo: "+getTitulo()+
				"\nAltura: "+getAltura()+
				"\nAnchura: "+getAnchura()+
				"\nAño: "+getAno()+
				"\nRestaurado: "+isRestaurado()+
				"\nPrecio: "+getPrecio()+"\n--------------------");
	}
	
	
}
