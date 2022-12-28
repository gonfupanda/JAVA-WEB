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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@Column(name="codigo")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private  Long codigo;
	
	@Column(name="nombre")
	@Nonnull
	private  String nombre;
	
	@Column(name="apellidos")
	@Nonnull
	private  String apellidos;
	
	@Column(name="fnacimiento")
	private  Date fnacimiento;
	
	@Column(name="dni")
	@Nonnull
	private  String dni;
	
	@Column(name="direccion")
	private  String direccion;
	
	@Column(name="poblacion")
	private  String poblacion;
	
	@Column(name="codigopostal")
	private  Integer codigopostal;
	
	@Column(name="telefono")
	@Nonnull
	private  int telefono;
	
	@Column(name="email")
	@Nonnull
	private  String email;
	
	@Column(name="activo")
	private  int activo;
	
	@Column(name="NSS")
	private  Long nss;
	
	@OneToMany(mappedBy = "cursoProf")
	private final List<Curso> cursoProf = new ArrayList<>();

}
