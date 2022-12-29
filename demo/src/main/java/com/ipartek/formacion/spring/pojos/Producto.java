package com.ipartek.formacion.spring.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.ipartek.formacion.spring.pojos.Factura.Linea;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@Column(name="descripcion")
	@Nonnull
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categorias_id")
	private Categoria categoria;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.LAZY)
	private final List<Linea> lineas = new ArrayList<>();
}
