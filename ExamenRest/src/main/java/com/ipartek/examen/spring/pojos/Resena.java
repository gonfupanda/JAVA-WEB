package com.ipartek.examen.spring.pojos;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resenas")
public class Resena {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private  Long id;
	/*
	@Column(name="curso_codigo")
	@Nonnull
	private  Long curso_codigo;
	
	@Column(name="alumno_codigo")
	@Nonnull
	private  Long alumno_codigo;*/
	
	@Column(name="texto")
	@Nonnull
	private  String texto;
	
	
	@ManyToOne
    @JoinColumn(name="curso_codigo")
	private Curso cursoRes;
	
	@ManyToOne
    @JoinColumn(name="alumno_codigo")
	private Alumno alumno;

}
