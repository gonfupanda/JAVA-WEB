package com.ipartek.examen.spring.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="curso")
public class Curso {

	@Id
	@Column(name="codigo")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private  Long codigo;
	
	@Column(name="nombre")
	@Nonnull
	private  String nombre;
	
	@Column(name="identificador")
	@Nonnull
	private  String identificador;
	
	@Column(name="fInicio")
	private  Date finicio;
	
	@Column(name="fFin")
	private  Date ffin;
	
	@Column(name="nHoras")
	@Nonnull
	private  int nhoras;
	
	@Column(name="temario")
	private  String temario;
	
	@Column(name="activo")
	private  int activo;
	
	@Column(name="precio")
	private  Double precio;
	
	@OneToMany(mappedBy = "cursoImp")
	private final List<Imparticion> imparticiones = new ArrayList<>();
	
	@OneToMany(mappedBy = "cursoRes")
	private final List<Resena> resenas = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name="cliente_codigo")
	private Cliente cursoCli;
	
	@ManyToOne
    @JoinColumn(name="profesor_codigo")
	private Profesor cursoProf;
}
