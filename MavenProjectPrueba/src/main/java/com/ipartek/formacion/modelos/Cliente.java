package com.ipartek.formacion.modelos;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name="clientes")
public class Cliente {


	public Cliente(long long1, String string, String string2, String string3) {
		setId(long1);
		setNombre(string);
		setNif(string2);
		setEmail(string3);
	}

	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nif")
	private String nif;
	
	@Column(name="email")
	private String email;

	@OneToMany(mappedBy = "facturas")
	private final Set<Factura> facturas = new HashSet<>();
}
