package com.ipartek.examen.spring.pojos;

import java.util.ArrayList;
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
@Table(name="autores")
public class Autor {
	
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	@Id
	private  Long id;
	
	@Column(name="nombre")
	@Nonnull
	private  String nombre;
	
	@Column(name="apellidos")
	@Nonnull
	private  String apellidos;
	
	@OneToMany(mappedBy = "autor")
	private final List<Libro> libros = new ArrayList<>();
	
}
