package com.ipartek.formacion.spring.pojos;

import java.util.HashSet;
import java.util.Set;

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
@Table(name="roles")
public class Rol {
	
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Id
	private Long id;
	
	@Column(name="nombre")
	@Nonnull
	private String nombre;
	
	@Column(name="descripcion")
	@Nonnull
	private String descripcion;
	
	 @OneToMany(mappedBy = "rol")
	private final Set<Usuario> usuarios = new HashSet<>();
}


