package com.ipartek.examen.spring.pojos;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name="imparticion")
public class Imparticion {
	@Id
	@Column(name="codigo")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private  Long codigo;
	
	@Column(name="fmatriculacion")
	private  Date fmatriculacion;
	
	
	@ManyToOne
    @JoinColumn(name="curso_codigo")
	private Curso cursoImp;
	
	@ManyToOne
    @JoinColumn(name="alumno_codigo")
	private Alumno alumnoImp;

}
