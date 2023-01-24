package com.example.examen.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inmuebles")
public class Inmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	
	@NotNull
	@Column(name="estado")
	private String estado;
	
	@Column(name="precio")
	@NotNull
	@Min(value = 0)
	private BigDecimal precio;
	
	@Column(name="habitaciones")
	@NotNull
	@Min(value = 0)
	private int habitaciones;
	
	@NotNull
	@Size(min = 3, max = 40)
	@Column(name="nombre")
	private String nombre;
	
	@NotNull
	@Lob
	@Size(max = 2000)
	@Column(name="direccion")
	private String direccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="servicios_id")
	private Servicio servicio;
}
