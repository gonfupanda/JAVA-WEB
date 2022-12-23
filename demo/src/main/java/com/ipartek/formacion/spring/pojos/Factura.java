package com.ipartek.formacion.spring.pojos;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="facturas")
public class Factura extends Pedido {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@Nonnull
	private LocalDate fecha;

	@ManyToOne
    @JoinColumn(name="clientes_id")
	private Cliente cliente;
	
	@ManyToOne
    @JoinColumn(name="empleados_id")
	private Empleado empleado;
	
	public Factura(Pedido pedido) {
		this.lineas = pedido.lineas;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor

	public static class Linea {

		private Factura factura;
		

		private Producto producto;
		

		private Integer cantidad;
		

	}
}
