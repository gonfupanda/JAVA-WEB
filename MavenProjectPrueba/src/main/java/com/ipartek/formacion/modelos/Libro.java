package com.ipartek.formacion.modelos;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table( name = "libros" )
public class Libro {
	
	 @Column(name="id")
	 @GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	 
	 @Column(name="nombre")
	private String nombre;
	 
	 @Column(name="fecha")
	 @Temporal(TemporalType.TIMESTAMP)
	private Date fechaPubli;
	
	
	
}

   
