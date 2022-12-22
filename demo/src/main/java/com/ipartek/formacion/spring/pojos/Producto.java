package com.ipartek.formacion.spring.pojos;

import java.math.BigDecimal;

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
@Table(name="productos")
public class Producto {

	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Id
	private Long id;
	
	@Column(name="nombre")
	@Nonnull
	private String nombre;
	
	@Column(name="precio")
	@Nonnull
	private BigDecimal precio;
	
	@Column(name="desscripcion")
	@Nonnull
	private String descripcion;

	@ManyToOne
    @JoinColumn(name="productos")
	private Categoria categoria;
}
