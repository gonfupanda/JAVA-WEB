package com.ipartek.examen.spring.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@Column(name="codigo")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private  Long codigo;
	
	@Column(name="nombre")
	@Nonnull
	private  String nombre;
	
	@Column(name="email")
	@Nonnull
	private  String email;
	
	@Column(name="poblacion")
	private  String poblacion;
	
	@Column(name="codigopostal")
	@Nullable
	private  Integer codigopostal;
	
	@Column(name="telefono")
	@Nonnull
	private  int telefono;
	
	@Column(name="direccion")
	private  String direccion;
	
	@Column(name="activo")
	private  int activo;
	
	@Column(name="identificador")
	@Nonnull
	private  String identificador;
	
	@OneToMany(mappedBy = "cursoCli")
	private final List<Curso> cursosCli = new ArrayList<>();

}
