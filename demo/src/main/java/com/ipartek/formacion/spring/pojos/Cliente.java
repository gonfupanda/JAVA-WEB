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
import jakarta.persistence.OneToOne;
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
	@Nonnull
	private String nombre;
	
	@Column(name="nif")
	@Nonnull
	private String nif;
	
	@Column(name="email")
	@Nonnull
	private String email;

	@OneToMany(mappedBy = "cliente")
	private final Set<Factura> facturas = new HashSet<>();
	
	 @OneToOne
	   private Usuario usuario;
}
