package com.ipartek.formacion.modelos;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {


	public Cliente(long long1, String string, String string2, String string3) {
		setId(long1);
		setNombre(string);
		setNif(string2);
		setEmail(string3);
	}

	private Long id;
	private String nombre;
	private String nif;
	private String email;

	private final Set<Factura> facturas = new HashSet<>();
}
