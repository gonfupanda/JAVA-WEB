package com.ipartek.formacion.modelos;

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
@NoArgsConstructor
@Entity
@Table(name="empleados")
public class Empleado {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nif")
	private String nif;
	
	@ManyToOne
    @JoinColumn(name="jefe_id")
	private Empleado jefe;
	
	public Empleado(Long id, String nombre, String nif, Empleado jefe) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setJefe(jefe);
	}

	public void setId(Long id) {
		if (id != null && jefe != null && jefe.getId() != null && jefe.getId() == id) {
			throw new IllegalArgumentException("Un empleado no puede ser jefe de sí mismo");
		}

		this.id = id;
	}

	public void setJefe(Empleado jefe) {
		if (this.getId() != null && jefe != null && jefe.getId() != null && jefe.getId() == this.getId()) {
			throw new IllegalArgumentException("Un empleado no puede ser jefe de sí mismo");
		}

		this.jefe = jefe;
	}
}
